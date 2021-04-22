package br.com.komanda.eletronica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.komanda.eletronica.connection.ConnectFactory;
import br.com.komanda.eletronica.model.Pessoa;

public class PessoaDao {
	
	public PessoaDao() {
		
	}
	
	/******************** Adicionando *****************/
	public boolean adicionar(Pessoa p) {
		Connection connection = null;
		boolean sucesso = true;
		try {
			connection = ConnectFactory.createConnection();
			/* SQL */
			String query = "insert into pessoa (cpf, nome, endereco, telefone, email, isExcluido) values(?)";
			/* Preparando a Query */
			PreparedStatement prepare = connection.prepareStatement(query);
			prepare.setString(1, p.getCPF());
			prepare.setString(2, p.getNome());
			prepare.setString(3, p.getEndere�o());
			prepare.setString(4, p.getTelefone());
			prepare.setString(5, p.getEmail());
			prepare.setString(6, "0");// Valor Zero pois mostra que ele n�o est� exclu�do logicamente. Se alterar para valor 1, ele estar� exclu�do logicamente
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
	
	/******************** Adicionando com retorno de Id *****************/
	public int adicionarComRetorno(Pessoa pessoa) {
		Connection connection = null;
		//boolean sucesso = true;
		int res = 0;
		try {
			connection = ConnectFactory.createConnection();
			/* SQL */
			String query = "insert into pessoa (cpf, nome, endereco, telefone, email, isExcluido) values(??????)";
			/* Preparando a Query */
			PreparedStatement prepare = connection.prepareStatement(query);
			prepare.setString(1, pessoa.getCPF());
			prepare.setString(2, pessoa.getNome());
			prepare.setString(3, pessoa.getEndere�o());
			prepare.setString(4, pessoa.getTelefone());
			prepare.setString(5, pessoa.getEmail());
			prepare.setString(6, "0");// Valor Zero pois mostra que ele n�o est� exclu�do logicamente. Se alterar para valor 1, ele estar� exclu�do logicamente
			res = prepare.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			//sucesso = false;
		}
		/* Fechando a conexao Sql */
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return res;
	}
	
	/******************** Consulta por id *****************/
	public Pessoa consultaid(int identificacao) throws SQLException {
		Connection connection = ConnectFactory.createConnection();
		String query = "SELECT idPessoa, nome FROM Mesa WHERE idPessoa = " + identificacao;

		Statement stmt = (Statement) connection.createStatement();
		ResultSet resultado = stmt.executeQuery(query);
		Pessoa p = new Pessoa(resultado.getInt("IdPessoa"), resultado.getString("cpf"), resultado.getString("nome"), resultado.getString("endereco"), resultado.getString("telefone"), resultado.getString("email"));
		
		stmt.close();
		connection.close();
		
		return p;

	}

}