package com.contact.jdbc;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.contact.mvc.logic.AlterAdd;

public class ConnectionFactory{
	
	static final Logger logger = Logger.getLogger(AlterAdd.class);
	
    public Connection getConnection() throws URISyntaxException{
    	String forname;
    	String database;
    	String username;
    	String password;
    	String url;
    	boolean local = System.getenv("DATABASE_URL") == null;
    	
    	if(local){
    		forname	 = "com.mysql.cj.jdbc.Driver";
    		database = "PROJECTS";
    		username = "root";
    		password = "root";
    		url      = "jdbc:mysql://localhost/" + database + "?autoReconnect=true&useSSL=false&useTimezone=true&serverTimezone=UTC";
    	}else{
    		URI dbUri = new URI(System.getenv("DATABASE_URL"));
    		forname  = "org.postgresql.Driver";
    		username = dbUri.getUserInfo().split(":")[0];
    		password = dbUri.getUserInfo().split(":")[1];
    		url 	 = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();
    	}
        
		try{
			Class.forName(forname);
			return DriverManager.getConnection(url, username, password);
		}catch(SQLException e){
			logger.error(e);
			throw new RuntimeException(e);
		}catch(ClassNotFoundException e){
			logger.error(e);
		}
		return null;
	}
    
}