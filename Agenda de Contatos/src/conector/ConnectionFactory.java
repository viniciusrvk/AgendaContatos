package conector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {

	private final static String DRIVER = "com.mysql.jdbc.Driver";
	private final static String URL = "jdbc:mysql://localhost:3306/bancoContatos";
	private final static String USER = "viniciusrvk";
	private final static String PASSWORD = "123456";
	
	public static Connection getConnection() {
		
		try {
			Class.forName(DRIVER);
			
			return DriverManager.getConnection(URL, USER, PASSWORD);
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException("Erro na conexão", e );
		}
	}

	
	public static void closeConnection(Connection con) {
		
			try {
				if(con != null) {
					con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public static void closeConnection(Connection con, PreparedStatement stmt) {
		
		closeConnection(con);
		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
		
		closeConnection(con, stmt);
		
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
