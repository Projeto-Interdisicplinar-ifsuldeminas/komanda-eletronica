package br.com.komanda.eletronica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.komanda.eletronica.connection.ConnectFactory;
import br.com.komanda.eletronica.model.LoginFuncionarios;

public class LoginDao {
	
	public LoginDao() {
		
	}
	
	public boolean ValidaLoginFuncionarios(String usuario, String senha) {
		
		Connection connection = null;
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
			int IdFuncionario = rs.getInt("IdLoginFuncionario");
			String senhaFuncionario = rs.getString("senha");
			String CpfFuncionario = rs.getString("cpf");
					
			//loginFunc.setSenha();
			String senhaLogin = loginFunc.Decripto(senhaFuncionario); 
			if(cpf.equals(CpfFuncionario) && senha.equals(senhaLogin)) {
				JOptionPane.showMessageDialog(null, "PAssou");
				return true;
			}else {
				JOptionPane.showMessageDialog(null, "Não Passou");
				return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public void AlteraSenhaFuncionarios() {
		
	}

}
