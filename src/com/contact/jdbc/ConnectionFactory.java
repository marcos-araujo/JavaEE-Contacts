package com.contact.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory{
	
	String USERNAME = System.getenv("OPENSHIFT_MYSQL_DB_USERNAME");
	String PASSWORD = System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD");
	String DB_NAME = System.getenv("OPENSHIFT_APP_NAME");
    String PORT = System.getenv("OPENSHIFT_MYSQL_DB_PORT");
    String HOST = System.getenv("OPENSHIFT_MYSQL_DB_HOST");
    String FORNAME_URL = "com.mysql.jdbc.Driver";
	
    String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + "PROJECTS";

    public Connection getConnection(){
		try{
			Class.forName(FORNAME_URL);
			//return DriverManager.getConnection(URL, USERNAME, PASSWORD);
			return DriverManager.getConnection("jdbc:mysql://localhost/projects?autoReconnect=true&useSSL=false", "root", "root");
		}catch(SQLException | ClassNotFoundException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}