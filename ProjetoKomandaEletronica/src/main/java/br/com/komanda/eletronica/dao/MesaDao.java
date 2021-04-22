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

public class MesaDao {

	/******************** Adicionando *****************/
	public boolean adicionar(Mesa mesa) {
		Connection connection = null;
		boolean sucesso = true;
		try {
			connection = ConnectFactory.createConnection();
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

	/******************** Metodo Deletar *****************/
	public boolean deletar(int identificacao) throws SQLException {
		Connection connection = ConnectFactory.createConnection();
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

	/******************** Consulta por id *****************/
	public List<Mesa> consultaid(int identificacao) throws SQLException {
		Connection connection = ConnectFactory.createConnection();
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

	/******************** Metodo UPDATE *****************/

	public boolean atualizar(Mesa mesa, int idMesa) throws SQLException {
		Connection connection = ConnectFactory.createConnection();
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

	/******************** Metodo Retornando Mesas *****************/

}
