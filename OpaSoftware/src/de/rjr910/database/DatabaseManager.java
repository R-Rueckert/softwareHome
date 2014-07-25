package de.rjr910.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
	
	private Connection conn;

	public Connection getConnection(){
        try {
        	Class.forName("org.h2.Driver");
//			this.conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
			this.conn = DriverManager.getConnection("jdbc:h2:file:C:\\Workspace_Home\\softwareHome\\OpaSoftware\\DB\\test", "sa", "");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("Connected to DB");
		return conn;
	}
	
	public void closeConnection(){
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Connection to DB closed");
	}
	
}
