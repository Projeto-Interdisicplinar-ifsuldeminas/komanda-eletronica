package br.com.komanda.eletronica.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectFactory {
	
	private String server, porta, nome, user, senha;
	
	
	
	public ConnectFactory(String server, String porta, String nomeBanco, String user, String senha) {
		this.server = server;
		this.porta = porta;
		this.nome = nomeBanco;
		this.user = user;
		this.senha = senha;
	}

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}

	public String getPorta() {
		return porta;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setPorta(String porta) {
		this.porta = porta;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public static Connection createConnection(String server, String door, String name, String usuario, String senha) throws SQLException {

		String servidor = server;
		String porta = door;
		//TODO nome do banco, Usuario e Senha
		String nomeBanco = name;
		String user = usuario;
		String password = senha;
		String url = String.format("jdbc:mysql://%s:%s/%s?useTimezone=true&serverTimezone=UTC", servidor, porta,
				nomeBanco);

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return DriverManager.getConnection(url, user, password);

	}
	
	/*public static Connection createConnection() throws SQLException {

		String servidor = "localhost";
		String porta = "3306";
		//TODO nome do banco, Usuario e Senha
		String nomeBanco = "komandaeletronica";
		String user = "root";
		String password = "";
		String url = String.format("jdbc:mysql://%s:%s/%s?useTimezone=true&serverTimezone=UTC", servidor, porta,
				nomeBanco);

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return DriverManager.getConnection(url, user, password);

	}*/

	/*public static void main(String[] args) throws SQLException {
		Connection c = createConnection();
		c.close();
		System.out.println("Conectado!");
	}*/

}
