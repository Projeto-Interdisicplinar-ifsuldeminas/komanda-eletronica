package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectFactory {
	public static Connection createConnection() throws SQLException {

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

	}

	public static void main(String[] args) throws SQLException {
		Connection c = createConnection();
		c.close();
		System.out.println("Conectado!");
	}

}
