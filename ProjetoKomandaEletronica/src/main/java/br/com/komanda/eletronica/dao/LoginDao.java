package br.com.komanda.eletronica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.komanda.eletronica.connection.ConnectFactory;
import br.com.komanda.eletronica.model.Funcionario;
import br.com.komanda.eletronica.model.LoginFuncionarios;
import br.com.komanda.eletronica.model.Mesa;

public class LoginDao {
	
	private int IdFuncionario;
	
	public LoginDao() {
		
	}
	
	
	
	public int getIdFuncionario() {
		return IdFuncionario;
	}



	public void setIdFuncionario(int idFuncionario) {
		IdFuncionario = idFuncionario;
	}



	public boolean ValidaLoginFuncionarios(String usuario, String senha) {
		
		Connection connection = null;
		@SuppressWarnings("unused")
		boolean successo = false;
		try {
			connection = ConnectFactory.createConnection();
			LoginFuncionarios loginFunc = new LoginFuncionarios();
			String cpf = usuario;
			cpf = cpf.replace( " " , ""); //tira espaço em branco
			cpf = cpf.replace( "." , ""); //tira ponto
			cpf = cpf.replace( "/" , ""); //tira barra
			cpf = cpf.replace( "-" , ""); //tira hífen
			
			String sql = "SELECT a.IdLoginFuncionario, a. senha, c.cpf from loginfuncionario as a INNER JOIN funcionario as b INNER JOIN pessoa as c WHERE c.cpf ='" + cpf +"';";
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			
			this.setIdFuncionario(rs.getInt("IdLoginFuncionario"));
			String senhaFuncionario = rs.getString("senha");
			String CpfFuncionario = rs.getString("cpf");
					
			//loginFunc.setSenha();
			String senhaLogin = loginFunc.descriptografiaBase64Decode(senhaFuncionario); 
			if(cpf.equals(CpfFuncionario) && senha.equals(senhaLogin)) {
				//JOptionPane.showMessageDialog(null, "PAssou");
				return true;
			}else {
				//JOptionPane.showMessageDialog(null, "Não Passou");
				return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	/******************** Metodo UPDATE *****************/

	@SuppressWarnings("null")
	public boolean AlteraSenhaFuncionarios(Funcionario usuario, String senha, String senha2) throws SQLException {
		Connection connection = ConnectFactory.createConnection();
		String update = "UPDATE loginFuncionario SET senha = ? WHERE loginFuncionario.IdFuncionario = ?";
		LoginFuncionarios login = null;
		PreparedStatement stmt = connection.prepareStatement(update);
		try {
			stmt = connection.prepareStatement(update);
			stmt.setString(1, login.criptografiaBase64Encoder(senha));
			stmt.setInt(2, usuario.getIdFuncionario());
			stmt.executeUpdate();
			stmt.close();
			connection.close();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

}
