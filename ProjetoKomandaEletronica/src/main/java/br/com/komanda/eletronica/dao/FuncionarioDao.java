package br.com.komanda.eletronica.dao;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
			
			String queryLogin = "insert into loginfuncionario (idFuncionario, senha, nivelDeAcesso, IsBloqueado, primeiroAcesso) values(?,?,?,?,?)";
			/* Preparando a Query */
			
			PreparedStatement prepareLogin = connection.prepareStatement(queryLogin);
			prepareLogin.setInt(1, lastId);
			prepareLogin.setString(2, login.criptografiaBase64Encoder(login.getSenha()));
			prepareLogin.setInt(3, login.getNivelDeAcesso());
			prepareLogin.setBoolean(4, false);
			prepareLogin.setBoolean(5, true);
			prepareLogin.execute();
			
			String queryUsuario = "insert into loginusuario (IdPessoa, senha, isBloqueado, primeiroAcesso) values(?,?,?,?)";
			/* Preparando a Query */
			
			PreparedStatement prepareLoginUsuario = connection.prepareStatement(queryUsuario);
			prepareLoginUsuario.setInt(1, lastId);
			prepareLoginUsuario.setString(2, login.criptografiaBase64Encoder(login.getSenha()));
			prepareLoginUsuario.setBoolean(3, false);
			prepareLoginUsuario.setBoolean(4, true);
			prepareLoginUsuario.execute();
			
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
	
	/******************** Consulta por id *****************/
	public Funcionario consultaid(int identificacao) throws SQLException {
		Connection connection = ConnectFactory.createConnection();
		String query = "SELECT a.IdFuncionario, b.IdPessoa, b. cpf, a.NumeroRegistro, a.IdFuncao, a.IsGerente, b.nome, a.IsExcluido FROM funcionario as a \r\n"
				+ "INNER JOIN pessoa as b ON a.IdPessoa = b.IdPessoa AND a.IdFuncionario = " + identificacao;

		PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(query);
		ResultSet rs = stmt.executeQuery();
		rs.next();
		Funcionario func = new Funcionario(rs.getInt("IdFuncionario"), rs.getInt("IdPessoa"), rs.getString("nome"), 
				rs.getString("cpf"), rs.getBoolean("IsExcluido"), rs.getInt("NumeroRegistro"), rs.getBoolean("IsGerente"), 
				rs.getInt("IdFuncao"));
		
		return func;

	}
	
	/******************** Metodo UPDATE *****************/
	//É feito um delete lógico para evitar perda de dados pelos usuários do sistema. 
	//Sendo possível pelo Administrador do BD recuperar a informação caso seja errôneamente apagada.

	public boolean Deletar(int idFuncionario) throws SQLException {
		Connection connection = ConnectFactory.createConnection();
		String update1 = "UPDATE funcionario SET IsExcluido = ? WHERE idFuncionario = ?";
		String update2 = "UPDATE loginFuncionario SET IsBloqueado = ? WHERE idFuncionario = ?";
		//A Pessoa não será excluída devido ao fato de mesmo que ela seja desligada da função, pode vir a ser um cliente
		PreparedStatement stmt = connection.prepareStatement(update1);
		PreparedStatement stmt1 = connection.prepareStatement(update1);
		try {
			stmt = connection.prepareStatement(update1);
			stmt.setBoolean(1, true);
			stmt.setInt(2, idFuncionario);
			stmt.executeUpdate();
			stmt.close();
			stmt1 = connection.prepareStatement(update2);
			stmt1.setBoolean(1, true);
			stmt1.setInt(2, idFuncionario);
			stmt1.executeUpdate();
			stmt1.close();
			connection.close();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}
	
	/******************** Busca todas os funcionarios *****************/
	public ArrayList<Funcionario> getAll() throws SQLException {
		Connection connection = ConnectFactory.createConnection();
		String query = "SELECT a.IdFuncionario,  a.IdPessoa, b.nome, b.cpf FROM funcionario a INNER JOIN pessoa b ON a.IdPessoa = b.IdPessoa;";

		Statement stmt = (Statement) connection.createStatement();
		ResultSet resultado = stmt.executeQuery(query);
		ArrayList<Funcionario> tipo = new ArrayList<>();
		while (resultado.next()) {
			int id = resultado.getInt("IdFuncionario");
			int idPessoa = resultado.getInt("IdPessoa");
			String nome = resultado.getString("nome");
			String cpf = resultado.getString("cpf");
			tipo.add(new Funcionario(id, idPessoa, nome, cpf));
		}
		stmt.close();
		connection.close();
		
		return tipo;

	}

}
