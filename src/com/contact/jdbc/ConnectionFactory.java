package com.contact.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory{
	
	public Connection getConnection(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost/projects?autoReconnect=true&useSSL=false", "root", "root");
		}catch(SQLException | ClassNotFoundException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}