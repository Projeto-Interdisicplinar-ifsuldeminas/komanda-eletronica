package br.com.komanda.eletronica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.komanda.eletronica.connection.ConnectFactory;
import br.com.komanda.eletronica.model.Funcionario;
import br.com.komanda.eletronica.model.LoginFuncionarios;
import br.com.komanda.eletronica.model.Pessoa;

public class FuncionarioDao {

	@SuppressWarnings("unused")
	private int idRetornoFuncionario;

	/******************** Adicionando *****************/
	public boolean adicionar(Funcionario funcionario, LoginFuncionarios login) {
		//cpf, nome, endereco, telefone, email, isExcluido
		Pessoa pessoa = new Pessoa(funcionario.getCPF(), funcionario.getNome(), funcionario.getEndereço(),funcionario.getTelefone(), funcionario.getEmail(), funcionario.isIsExcluido());
		PessoaDao novaPessoa = new PessoaDao();
		int idRetorno = novaPessoa.adicionarComRetorno(pessoa);
		Connection connection = null;
		boolean sucesso = true;
		try {
			connection = ConnectFactory.createConnection();
			/* SQL */
			String query = "insert into funcionario (idPessoa, NumeroRegistro, IdFuncao, IsGerente, isExcluido) values(?????)";
			/* Preparando a Query */
			PreparedStatement prepare = connection.prepareStatement(query);
			prepare.setInt(1, idRetorno);
			prepare.setInt(2, funcionario.getNumeroRegistro());
			prepare.setInt(3, funcionario.getIdFuncao());
			prepare.setBoolean(4, funcionario.isIsGerente());
			prepare.setBoolean(5, funcionario.isIsExcluido());
			prepare.setString(6, "0");// Valor Zero pois mostra que ele não está excluído logicamente. Se alterar para valor 1, ele estará excluído logicamente
			idRetornoFuncionario = prepare.executeUpdate();
			
			String queryLogin = "insert into loginfuncionario (idFuncionario, senha, nivelDeAcesso, IsBloqueado) values(????)";
			/* Preparando a Query */
			int senhaInicial = 12345678;
			PreparedStatement prepareLogin = connection.prepareStatement(queryLogin);
			prepareLogin.setInt(1, idRetornoFuncionario);
			prepareLogin.setInt(2, senhaInicial);
			prepareLogin.setInt(3, login.getNivelDeAcesso());
			prepareLogin.setInt(4, 0);
			idRetornoFuncionario = prepare.executeUpdate();

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
