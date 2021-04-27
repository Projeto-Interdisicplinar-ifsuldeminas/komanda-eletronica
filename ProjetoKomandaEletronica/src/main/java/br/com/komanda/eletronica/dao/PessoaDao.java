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
			prepare.setString(3, p.getEndereço());
			prepare.setString(4, p.getTelefone());
			prepare.setString(5, p.getEmail());
			prepare.setString(6, "0");// Valor Zero pois mostra que ele não está excluído logicamente. Se alterar para valor 1, ele estará excluído logicamente
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
		int lastId = 0;
		try {
			connection = ConnectFactory.createConnection();
			/* SQL */
			String query = "insert into pessoa (cpf, nome, endereco, telefone, email, isExcluido) values(?,?,?,?,?,?)";
			/* Preparando a Query */
			PreparedStatement prepare = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			
			String cpf = pessoa.getCPF().replaceAll("\\p{Punct}", "");
			cpf = cpf.replace( " " , ""); //tira espaço em branco
			cpf = cpf.replace( "." , ""); //tira ponto
			cpf = cpf.replace( "-" , ""); //tira hífen
			
			prepare.setString(1, cpf);
			prepare.setString(2, pessoa.getNome());
			prepare.setString(3, pessoa.getEndereço());
			prepare.setString(4, pessoa.getTelefone());
			prepare.setString(5, pessoa.getEmail());
			prepare.setBoolean(6, false);
			prepare.execute();
			String sql = "SELECT IdPessoa from pessoa where IdPessoa = (select max(IdPessoa) from pessoa);";
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			lastId = rs.getInt("IdPessoa");

			rs.close();
			stmt.close();
			
			/*ResultSet rs = prepare.getGeneratedKeys();
			
			if(rs.next()){
				res = rs.getInt(1);
			}*/

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

		return lastId;
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
