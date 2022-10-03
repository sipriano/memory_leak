package com.accenture.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private final String url = "jdbc:postgresql://localhost/leak";
	private final String user = "postgres";
	private final String password = "admin";
	//public Connection conn = null;
	static Connection conn = null;
	
	 public Connection connect() {
	        try {
	            conn = DriverManager.getConnection(url, user, password);
	            System.out.println("Connected to the PostgreSQL server successfully.");
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }

	        return conn;
	    }
	
}
