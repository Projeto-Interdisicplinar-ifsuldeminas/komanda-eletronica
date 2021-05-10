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
import br.com.komanda.eletronica.model.Xml;


public class MesaDao {

	/********************
	 * Adicionando
	 * 
	 * @throws Exception
	 *****************/
	public boolean adicionar(Mesa mesa) throws Exception {
		Connection connection = null;
		boolean sucesso = true;
		try {
			ConnectFactory conection = null;
			Xml xml = new Xml();
			conection = xml.lerXML();
			connection = ConnectFactory.createConnection(conection.getServer(), conection.getPorta(),
					conection.getNome(), conection.getUser(), conection.getSenha());
			/* SQL */
			String query = "insert into mesa (nome) values(?)";
			/* Preparando a Query */
			PreparedStatement prepare = connection.prepareStatement(query);
			prepare.setString(1, mesa.getNomeMesa());
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
		String query = " DELETE FROM mesa WHERE idMesa = ?";
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
	public List<Mesa> consultaid(int identificacao) throws Exception {
		ConnectFactory conection = null;
		Xml xml = new Xml();
		conection = xml.lerXML();
		Connection connection = ConnectFactory.createConnection(conection.getServer(), conection.getPorta(),
				conection.getNome(), conection.getUser(), conection.getSenha());
		String query = "SELECT idMesa, nome FROM Mesa WHERE idMesa = " + identificacao;

		Statement stmt = (Statement) connection.createStatement();
		ResultSet resultado = stmt.executeQuery(query);
		List<Mesa> mesa = new ArrayList<>();
		while (resultado.next()) {
			int id = resultado.getInt("idMesa");
			String nome = resultado.getString("nome");
			mesa.add(new Mesa(id, nome));
		}
		stmt.close();
		connection.close();

		return mesa;

	}

	/********************
	 * Metodo UPDATE
	 * 
	 * @throws Exception
	 *****************/

	public boolean atualizar(Mesa mesa, int idMesa) throws Exception {
		ConnectFactory conection = null;
		Xml xml = new Xml();
		conection = xml.lerXML();
		Connection connection = ConnectFactory.createConnection(conection.getServer(), conection.getPorta(),
				conection.getNome(), conection.getUser(), conection.getSenha());
		String update = "UPDATE mesa SET nome = ? WHERE mesa.idMesa = ?";

		PreparedStatement stmt = connection.prepareStatement(update);
		try {
			stmt = connection.prepareStatement(update);
			stmt.setString(1, mesa.getNomeMesa());
			stmt.setInt(2, idMesa);
			stmt.executeUpdate();
			stmt.close();
			connection.close();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	/********************
	 * Metodo Retornando   Lista de Mesas
	 * 
	 *****************/
	public List<Mesa> listamesa() throws Exception {
		ConnectFactory conection = null;
		Xml xml = new Xml();
		conection = xml.lerXML();
		Connection connection = ConnectFactory.createConnection(conection.getServer(), conection.getPorta(),
				conection.getNome(), conection.getUser(), conection.getSenha());

		String query = "SELECT * FROM Mesa";

		Statement stmt = (Statement) connection.createStatement();
		ResultSet resultado = stmt.executeQuery(query);
		List<Mesa> mesas = new ArrayList<>();
		while (resultado.next()) {
			int IdMesa= resultado.getInt("IdMesa");
			String NomeMesa = resultado.getString("Nome");
			mesas.add(new Mesa(IdMesa, NomeMesa));
		}

		stmt.close();
		connection.close();

		return mesas;

	}

}
