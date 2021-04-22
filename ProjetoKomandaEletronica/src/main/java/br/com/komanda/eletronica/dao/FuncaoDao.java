package br.com.komanda.eletronica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.komanda.eletronica.connection.ConnectFactory;
import br.com.komanda.eletronica.model.TiposdeFuncao;

public class FuncaoDao {
	
	/******************** Adicionando *****************/
	public boolean adicionar(String nomeFuncao) {
		Connection connection = null;
		boolean sucesso = true;
		try {
			connection = ConnectFactory.createConnection();
			/* SQL */
			String query = "insert into tiposdefuncao (nomeFuncao) values(?)";
			/* Preparando a Query */
			PreparedStatement prepare = connection.prepareStatement(query);
			prepare.setString(1, nomeFuncao);
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
		String query = " DELETE FROM tiposdefuncao WHERE idFuncao = ?";
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
	public List<TiposdeFuncao> consultaid(int identificacao) throws SQLException {
		Connection connection = ConnectFactory.createConnection();
		String query = "SELECT idFuncao, nomeFuncao FROM tiposdefuncao WHERE idFuncao = " + identificacao;

		Statement stmt = (Statement) connection.createStatement();
		ResultSet resultado = stmt.executeQuery(query);
		List<TiposdeFuncao> tipo = new ArrayList<>();
		while (resultado.next()) {
			int id = resultado.getInt("idFuncao");
			String nome = resultado.getString("nomeFuncao");
			tipo.add(new TiposdeFuncao(id, nome));
		}
		stmt.close();
		connection.close();
		
		return tipo;

	}
	
	/******************** Busca todas as funções *****************/
	public ArrayList<TiposdeFuncao> getAll() throws SQLException {
		Connection connection = ConnectFactory.createConnection();
		String query = "SELECT * FROM tiposdefuncao ";

		Statement stmt = (Statement) connection.createStatement();
		ResultSet resultado = stmt.executeQuery(query);
		ArrayList<TiposdeFuncao> tipo = new ArrayList<>();
		while (resultado.next()) {
			int id = resultado.getInt("idFuncao");
			String nome = resultado.getString("nomeFuncao");
			tipo.add(new TiposdeFuncao(id, nome));
		}
		stmt.close();
		connection.close();
		
		return tipo;

	}

	/******************** Metodo UPDATE *****************/

	public boolean atualizar(TiposdeFuncao funcao, int idFuncao) throws SQLException {
		Connection connection = ConnectFactory.createConnection();
		String update = "UPDATE tiposdefuncao SET nomeFuncao = ? WHERE tiposdefuncao.idFuncao = ?";

		PreparedStatement stmt = connection.prepareStatement(update);
		try {
			stmt = connection.prepareStatement(update);
			stmt.setString(1, funcao.getFuncao());
			stmt.setInt(2, idFuncao);
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
