package com.contact.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.contact.model.Contact;

public class ContactDAO{
	
	final String sqlUpdate = "UPDATE CONTACT SET NAME=?, EMAIL=?, ADDRESS=?, BIRTHDATE=? WHERE ID=?";
	final String sqlInsert = "INSERT INTO CONTACT (NAME, EMAIL, ADDRESS, BIRTHDATE) VALUES (?,?,?,?)";
	final String sqlSelect = "SELECT ID, NAME, EMAIL, ADDRESS, BIRTHDATE FROM CONTACT";
	final String sqlSelectId = "SELECT ID, NAME, EMAIL, ADDRESS, BIRTHDATE FROM CONTACT WHERE ID = ";
	final String sqlDelete = "DELETE FROM CONTACT WHERE ID = ?";
	
	private Connection connection;
	
	public ContactDAO(Connection connection){
		this.connection = connection;
	}
	
	public void add(Contact contact){
		PreparedStatement stmt = null;
		try{
			stmt = this.connection.prepareStatement(sqlInsert);
			stmt.setString(1, contact.getName());
			stmt.setString(2, contact.getEmail());
			stmt.setString(3, contact.getAddress());
			stmt.setDate(4, contact.getBirthdate() != null ? new Date(contact.getBirthdate().getTimeInMillis()) : null);
			stmt.execute();
		}catch(SQLException e){
			throw new RuntimeException();
		}finally{
			try{
				stmt.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	
	public void alter(Contact contact){
		PreparedStatement stmt = null;
		try{
			stmt = connection.prepareStatement(sqlUpdate);
			stmt.setString(1, contact.getName());
			stmt.setString(2, contact.getEmail());
			stmt.setString(3, contact.getAddress());
			stmt.setDate(4, contact.getBirthdate() != null ? new Date(contact.getBirthdate().getTimeInMillis()) : null);
			stmt.setLong(5, contact.getId());
			stmt.execute();
		}catch(SQLException e){
			throw new RuntimeException(e);
		}finally{
			try{
				stmt.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	
	public List<Contact> list(){
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			List<Contact> contatos = new ArrayList<Contact>();
			stmt = this.connection.prepareStatement(sqlSelect);
			rs = stmt.executeQuery();
			while(rs.next()){
				Contact contato = new Contact();
				contato.setId(rs.getLong("id"));
				contato.setName(rs.getString("name"));
				contato.setEmail(rs.getString("email"));
				contato.setAddress(rs.getString("address"));
				if(rs.getDate("birthdate") != null){
					Calendar data = Calendar.getInstance();
					data.setTime(rs.getDate("birthdate"));
					contato.setBirthdate(data);
				}
				contatos.add(contato);
			}
			return contatos;
		}catch(SQLException e){
			throw new RuntimeException(e);
		}finally{
			try{
				rs.close();
				stmt.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	
	public Contact get(long id){
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			stmt = this.connection.prepareStatement(sqlSelectId + id);
			rs = stmt.executeQuery();
			if(rs.next()){
				Contact contact = new Contact();
				contact.setId(rs.getLong("id"));
				contact.setName(rs.getString("name"));
				contact.setEmail(rs.getString("email"));
				contact.setAddress(rs.getString("address"));
				if(rs.getDate("birthdate") != null){
					Calendar data = Calendar.getInstance();
					data.setTime(rs.getDate("birthdate"));
					contact.setBirthdate(data);
				}
				return contact;
			}
			return null;
		}catch(SQLException e){
			throw new RuntimeException(e);
		}finally{
			try{
				rs.close();
				stmt.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	
	public void delete(Contact contact){
		PreparedStatement stmt = null;
		try{
			stmt = connection.prepareStatement(sqlDelete);
			stmt.setLong(1, contact.getId());
			stmt.execute();
		}catch(SQLException e){
			throw new RuntimeException(e);
		}finally{
			try{
				stmt.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	
}