package com.contact.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory{

	String FORNAME_URL	 		= "com.mysql.jdbc.Driver";
	String DATABASE 			= "PROJECTS";
	String USERNAME				= "root";
	String PASSWORD				= "root";
	
	String USERNAME_OPENSHIFT 	= System.getenv("OPENSHIFT_MYSQL_DB_USERNAME");
	String PASSWORD_OPENSHIFT 	= System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD");
	String DB_NAME_OPENSHIFT 	= System.getenv("OPENSHIFT_APP_NAME");
    String PORT_OPENSHIFT 		= System.getenv("OPENSHIFT_MYSQL_DB_PORT");
    String HOST_OPENSHIFT 		= System.getenv("OPENSHIFT_MYSQL_DB_HOST");
    
    String URL_OPENSHIFT 		= "jdbc:mysql://" + HOST_OPENSHIFT + ":" + PORT_OPENSHIFT + "/" + DATABASE;
    String URL					= "jdbc:mysql://localhost/" + DATABASE + "?autoReconnect=true&useSSL=false";

    public Connection getConnection(){
		try{
			Class.forName(FORNAME_URL);
			//return DriverManager.getConnection(URL, USERNAME, PASSWORD);
			return DriverManager.getConnection(URL, USERNAME, PASSWORD);
		}catch(SQLException | ClassNotFoundException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}