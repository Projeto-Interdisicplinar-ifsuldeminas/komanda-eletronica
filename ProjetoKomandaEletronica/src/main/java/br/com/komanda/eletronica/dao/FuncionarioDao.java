package br.com.komanda.eletronica.dao;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.komanda.eletronica.connection.ConnectFactory;
import br.com.komanda.eletronica.model.Funcionario;
import br.com.komanda.eletronica.model.LoginFuncionarios;
import br.com.komanda.eletronica.model.Pessoa;

public class FuncionarioDao {

	/******************** Adicionando 
	 * @throws NoSuchAlgorithmException *****************/
	public boolean adicionar(Funcionario funcionario, LoginFuncionarios login) throws NoSuchAlgorithmException {
		//cpf, nome, endereco, telefone, email, isExcluido
		Pessoa pessoa = new Pessoa(funcionario.getNome(), funcionario.getCPF(), funcionario.getEndereço(),funcionario.getTelefone(), funcionario.getEmail(), funcionario.isIsExcluido());
		PessoaDao novaPessoa = new PessoaDao();
		int idRetorno = novaPessoa.adicionarComRetorno(pessoa);
		Connection connection = null;
		boolean sucesso = false;
		try {
			connection = ConnectFactory.createConnection();
			/* SQL */
			String query = "insert into funcionario (idPessoa, NumeroRegistro, IdFuncao, IsGerente, isExcluido) values(?,?,?,?,?)";
			/* Preparando a Query */
			PreparedStatement prepare = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			prepare.setInt(1, idRetorno);
			prepare.setInt(2, funcionario.getNumeroRegistro());
			prepare.setInt(3, funcionario.getIdFuncao());
			prepare.setBoolean(4, funcionario.isIsGerente());
			prepare.setBoolean(5, funcionario.isIsExcluido());
			prepare.execute();
			
			String sql = "SELECT IdFuncionario from funcionario where IdFuncionario = (select max(IdFuncionario) from funcionario);";
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			int lastId = rs.getInt("IdFuncionario");

			rs.close();
			stmt.close();
					
			
			/*ResultSet rs = prepare.getGeneratedKeys();
			
			if(rs.next()){
				idRetornoFuncionario = rs.getInt(1);
			}*/
			
			
			String queryLogin = "insert into loginfuncionario (idFuncionario, senha, nivelDeAcesso, IsBloqueado) values(?,?,?,?)";
			/* Preparando a Query */
			
			PreparedStatement prepareLogin = connection.prepareStatement(queryLogin);
			prepareLogin.setInt(1, lastId);
			prepareLogin.setString(2, login.Cripto(login.getSenha()));
			prepareLogin.setInt(3, login.getNivelDeAcesso());
			prepareLogin.setBoolean(4, false);
			prepareLogin.execute();
			sucesso = true;
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

}
