package com.contact.jdbc;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory{
	
	private String FORNAME;
	private String DATABASE;
	private String USERNAME;
	private String PASSWORD;
	private String URL;
	private boolean local = true;
	
    public Connection getConnection() throws URISyntaxException{
    	
    	if(local){
    		FORNAME	 = "com.mysql.jdbc.Driver";
    		DATABASE = "PROJECTS";
    		USERNAME = "root";
    		PASSWORD = "root";
    		URL      = "jdbc:mysql://localhost/" + DATABASE + "?autoReconnect=true&useSSL=false";
    	}else{
    		URI dbUri = new URI(System.getenv("DATABASE_URL"));
    		FORNAME  = "org.postgresql.Driver";
    		USERNAME = dbUri.getUserInfo().split(":")[0];
    		PASSWORD = dbUri.getUserInfo().split(":")[1];
    		URL 	 = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();
    	}
        
		try{
			Class.forName(FORNAME);
			return DriverManager.getConnection(URL, USERNAME, PASSWORD);
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		return null;
	}

}