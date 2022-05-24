package Utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
			
	private static ConnectionFactory instance;
		
	private ConnectionFactory() {
		super();
	}
	
	public static ConnectionFactory getInstance() {
		if(instance == null) {
			instance = new ConnectionFactory();
		}
		return instance;
 }
	
	public static Connection getConnection() throws SQLException{
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("CLASS WAS NOT FOUND");
			e.printStackTrace();
		}
		
		String url ="jdbc:postgresql://project1.ciq8ho5l9gk8.us-west-1.rds.amazonaws.com:5432/postgres?currentSchema=USERS";
		
		String username = "postgres";
		
		String password = "password";
		
		return DriverManager.getConnection(url, username, password);
	}
}
