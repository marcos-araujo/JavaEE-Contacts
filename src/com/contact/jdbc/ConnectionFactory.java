package com.contact.jdbc;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory{

	private String FORNAME_URL	 		= "com.mysql.jdbc.Driver";
	private String DATABASE 			= "PROJECTS";
	private String USERNAME				= "root";
	private String PASSWORD				= "root";
	private String URL					= "jdbc:mysql://localhost/" + DATABASE + "?autoReconnect=true&useSSL=false";

    
    public Connection getConnection() throws URISyntaxException{
    	URI dbUri = new URI(System.getenv("DATABASE_URL"));
    	USERNAME = dbUri.getUserInfo().split(":")[0];
        PASSWORD = dbUri.getUserInfo().split(":")[1];
        URL = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();
        
		try{
			Class.forName("org.postgreesql.Driver");
			return DriverManager.getConnection(URL, USERNAME, PASSWORD);
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}