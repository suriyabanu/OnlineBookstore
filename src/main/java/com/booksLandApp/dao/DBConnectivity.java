package com.booksLandApp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectivity {
	public Connection dbconnection() {
		Connection conn=null;
				
				String url="jdbc:mysql://localhost:3306/booksland";
				String username="root";
				String password="mysql";
				
				try {
					conn=DriverManager.getConnection(url, username, password);
					if (conn != null) {
						//System.out.println("Connected Successfully");
					}
				} catch (SQLException e) {
					
					System.out.println(e.getMessage());
				}

		     return conn;
		}
}
