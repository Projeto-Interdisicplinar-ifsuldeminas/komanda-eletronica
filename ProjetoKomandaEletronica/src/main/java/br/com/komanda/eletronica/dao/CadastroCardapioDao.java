package br.com.komanda.eletronica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.komanda.eletronica.connection.ConnectFactory;
import br.com.komanda.eletronica.model.Mesa;
import br.com.komanda.eletronica.model.ProdutoCardapio;
import br.com.komanda.eletronica.model.Xml;

public class CadastroCardapioDao {

	/********************
	 * Adicionando
	 * 
	 * @throws Exception
	 *****************/
	public boolean adicionar(ProdutoCardapio produtocardapio) throws Exception {
		Connection connection = null;
		boolean sucesso = true;

		try {
			ConnectFactory conection = null;
			Xml xml = new Xml();
			conection = xml.lerXML();
			connection = ConnectFactory.createConnection(conection.getServer(), conection.getPorta(),
					conection.getNome(), conection.getUser(), conection.getSenha());

			String query = "insert into produtocardapio (`Nome`, `Peso`, `Descricao`, `Valor`, `InformacaoesNutricionais`, `QuantidadeDePessoasQueServe`, `IsExcluido`) values(?, ?, ?, ?, ?,?,?)";

			PreparedStatement prepare = connection.prepareStatement(query);
			prepare.setString(1, produtocardapio.getNome());
			prepare.setDouble(2, produtocardapio.getPeso());
			prepare.setString(3, produtocardapio.getDescricao());
			prepare.setDouble(4, produtocardapio.getValor());
			prepare.setString(5, produtocardapio.getInformacoesNutricionais());
			prepare.setInt(6, produtocardapio.getQuantidadeDePessoasQueServe());
			prepare.setBoolean(7, produtocardapio.isIsExcluido());
			prepare.execute();

		} catch (SQLException e) {
			e.printStackTrace();
			sucesso = false;
		}
		/* Fechando a conexao Sql */
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return sucesso;
	}

	/********************
	 * Metodo Deletar
	 * 
	 * @throws Exception
	 *****************/
	public boolean deletar(int identificacao) throws Exception {
		ConnectFactory conection = null;
		Xml xml = new Xml();
		conection = xml.lerXML();
		Connection connection = ConnectFactory.createConnection(conection.getServer(), conection.getPorta(),
				conection.getNome(), conection.getUser(), conection.getSenha());
		String query = " DELETE FROM produtocardapio WHERE IdProdutoCardapio = ?";
		PreparedStatement stmt = connection.prepareStatement(query);
		stmt.setInt(1, identificacao);
		// retorna true se foi afetado algum registro
		if (stmt.executeUpdate() > 0) {
			return true;
		}

		stmt.close();
		connection.close();
		return false;

	}

	/********************
	 * Consulta por id
	 * 
	 * @throws Exception
	 *****************/
	public List<ProdutoCardapio> consultaid(int identificacao) throws Exception {
		ConnectFactory conection = null;
		Xml xml = new Xml();
		conection = xml.lerXML();
		Connection connection = ConnectFactory.createConnection(conection.getServer(), conection.getPorta(),
				conection.getNome(), conection.getUser(), conection.getSenha());
		String query = "SELECT `IdProdutoCardapio`, `Nome`, `Peso`, `Descricao`, `Valor`, `InformacaoesNutricionais`, `QuantidadeDePessoasQueServe`, `IsExcluido` FROM `produtocardapio` WHERE `IdProdutoCardapio` = "
				+ identificacao;

		Statement stmt = (Statement) connection.createStatement();
		ResultSet resultado = stmt.executeQuery(query);

		List<ProdutoCardapio> produtocardapio = new ArrayList<>();

		while (resultado.next()) {

			int IdProdutoCardapio = resultado.getInt("IdProdutoCardapio");
			String Nome = resultado.getString("Nome");
			double Peso = resultado.getDouble("Peso");
			String Descricao = resultado.getString("Descricao");
			double Valor = resultado.getDouble("Valor");
			String informacoesNutricionais = resultado.getString("InformacaoesNutricionais");
			int QuantidadeDePessoasQueServe = resultado.getInt("QuantidadeDePessoasQueServe");
			boolean IsExcluido = resultado.getBoolean("IsExcluido");
			produtocardapio.add(new ProdutoCardapio(IdProdutoCardapio, Nome, Peso, Descricao, Valor,
					informacoesNutricionais, QuantidadeDePessoasQueServe, IsExcluido));
		}
		stmt.close();
		connection.close();

		return produtocardapio;

	}

	/********************
	 * Metodo UPDATE
	 * 
	 * @throws Exception
	 *****************/
	public boolean atualizar(ProdutoCardapio produtocardapio, int id) throws Exception {
		ConnectFactory conection = null;
		Xml xml = new Xml();
		conection = xml.lerXML();
		Connection connection = ConnectFactory.createConnection(conection.getServer(), conection.getPorta(),
				conection.getNome(), conection.getUser(), conection.getSenha());
		String update = "UPDATE produtocardapio SET Nome = ?, Peso = ?, Descricao = ?, Valor = ?, InformacaoesNutricionais = ?, QuantidadeDePessoasQueServe = ?, IsExcluido = ? WHERE produtocardapio.IdProdutoCardapio = ?";

		PreparedStatement stmt = connection.prepareStatement(update);
		try {
			stmt = connection.prepareStatement(update);
			stmt.setString(1, produtocardapio.getNome());
			stmt.setDouble(2, produtocardapio.getPeso());
			stmt.setString(3, produtocardapio.getDescricao());
			stmt.setDouble(4, produtocardapio.getValor());
			stmt.setString(5, produtocardapio.getInformacoesNutricionais());
			stmt.setInt(6, produtocardapio.getQuantidadeDePessoasQueServe());
			stmt.setBoolean(7, produtocardapio.isIsExcluido());
			stmt.setInt(8, id);
			stmt.executeUpdate();
			stmt.close();
			connection.close();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	/********************
	 * Metodo Retornando Lista do cardapio
	 * 
	 *****************/
	public List<ProdutoCardapio> produtocardapiolista() throws Exception {
		ConnectFactory conection = null;
		Xml xml = new Xml();
		conection = xml.lerXML();
		Connection connection = ConnectFactory.createConnection(conection.getServer(), conection.getPorta(),
				conection.getNome(), conection.getUser(), conection.getSenha());

		String query = "SELECT * FROM produtocardapio";

		Statement stmt = (Statement) connection.createStatement();
		ResultSet resultado = stmt.executeQuery(query);
		List<ProdutoCardapio> produtoscardapio = new ArrayList<>();
		while (resultado.next()) {

			int IdProdutoCardapio = resultado.getInt("IdProdutoCardapio");
			String Nome = resultado.getString("Nome");
			double Peso = resultado.getDouble("Peso");
			String Descricao = resultado.getString("Descricao");
			double Valor = resultado.getDouble("Valor");
			String informacoesNutricionais = resultado.getString("InformacaoesNutricionais");
			int QuantidadeDePessoasQueServe = resultado.getInt("QuantidadeDePessoasQueServe");

			produtoscardapio.add(new ProdutoCardapio(IdProdutoCardapio, Nome, Peso, Descricao, Valor,
					informacoesNutricionais, QuantidadeDePessoasQueServe));
		}

		stmt.close();
		connection.close();

		return produtoscardapio;

	}

}
