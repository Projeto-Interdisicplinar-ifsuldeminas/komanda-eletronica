package br.com.komanda.eletronica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.komanda.eletronica.connection.ConnectFactory;
import br.com.komanda.eletronica.model.ProdutoEstoque;
import br.com.komanda.eletronica.model.Xml;

public class ProdutoEstoqueDao {

	/******************** Adicionando 
	 * @throws Exception *****************/
	public boolean adicionar(ProdutoEstoque produtoestoque) throws Exception {
		Connection connection = null;
		boolean sucesso = true;
		try {
			ConnectFactory conection = null;
			Xml xml = new Xml();			
			conection = xml.lerXML();
			connection = ConnectFactory.createConnection(conection.getServer(), conection.getPorta(), conection.getNome(), conection.getUser(), conection.getSenha());
			/* SQL */
			String query = "insert into mesa (idprodutoestoque, nome, peso, descricao, informacao, IsExcluido) values(?,?,?,?,?,?)";
			/* Preparando a Query */
			PreparedStatement prepare = connection.prepareStatement(query);
			prepare.setInt(1,  produtoestoque.getIdProdutoEstoque());
			prepare.setString(2,  produtoestoque.getNome());
			prepare.setDouble(3,  produtoestoque.getPeso());
			prepare.setString(4,  produtoestoque.getDescrição());
			prepare.setString(5,  produtoestoque.getInformaçõesAdicionais());
			prepare.setBoolean(6,  produtoestoque.isIsExcluido());
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

	/******************** Metodo Deletar 
	 * @throws Exception *****************/
	public boolean deletar(int identificacao) throws Exception {
		ConnectFactory conection = null;
		Xml xml = new Xml();			
		conection = xml.lerXML();
		Connection connection = ConnectFactory.createConnection(conection.getServer(), conection.getPorta(), conection.getNome(), conection.getUser(), conection.getSenha());
		String query = " DELETE FROM mesa WHERE idProdutoEstoque = ?";
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

	/******************** Consulta por id 
	 * @throws Exception *****************/
	public List<ProdutoEstoque> consultaid(int identificacao) throws Exception {
		ConnectFactory conection = null;
		Xml xml = new Xml();			
		conection = xml.lerXML();
		Connection connection = ConnectFactory.createConnection(conection.getServer(), conection.getPorta(), conection.getNome(), conection.getUser(), conection.getSenha());
		String query = "SELECT idMesa, nome FROM Mesa WHERE IdProdutoEstoque = " + identificacao;

		Statement stmt = (Statement) connection.createStatement();
		ResultSet resultado = stmt.executeQuery(query);
		List<ProdutoEstoque> produtoestoque = new ArrayList<>();
		while (resultado.next()) {
			int id = resultado.getInt("idProdutoEstoque");
			String nome = resultado.getString("nome");
			double peso = resultado.getDouble("peso");
			String descricao = resultado.getString("descrição");
			String informacao = resultado.getString("informação");
			boolean  idexcluido = resultado.getBoolean("IsExcluido");
			
			
			produtoestoque.add(new ProdutoEstoque(id, nome, peso,descricao,informacao, idexcluido));
		}
		stmt.close();
		connection.close();
		
		return produtoestoque;

	}

	/******************** Metodo UPDATE 
	 * @throws Exception *****************/

	public boolean atualizar(ProdutoEstoque produtoestoque, int IdProdutoEstoque) throws Exception {
		ConnectFactory conection = null;
		Xml xml = new Xml();			
		conection = xml.lerXML();
		Connection connection = ConnectFactory.createConnection(conection.getServer(), conection.getPorta(), conection.getNome(), conection.getUser(), conection.getSenha());
		String update = "UPDATE mesa SET nome = ? WHERE produtoestoque.idProdutoEstoque = ?";

		PreparedStatement stmt = connection.prepareStatement(update);
		try {
			stmt = connection.prepareStatement(update);
			stmt.setString(1, produtoestoque.getNome());
			stmt.setDouble(2, produtoestoque.getPeso());
			stmt.setString(3, produtoestoque.getDescrição());
			stmt.setString(4, produtoestoque.getInformaçõesAdicionais());
			stmt.setInt(5, IdProdutoEstoque);
			stmt.executeUpdate();
			stmt.close();
			connection.close();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	/******************** Metodo Retornando ProdutoEstoque *****************/

}
