package com.contact.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.contact.jdbc.ConnectionFactory;
import com.contact.model.Contact;

public class ContactDAO{
	
	private Connection connection;
	
	public ContactDAO(){
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public ContactDAO(Connection connection){
		this.connection = connection;
	}
	
	public void add(Contact contact){
		String sql = "INSERT INTO CONTACT (NAME, EMAIL, ADDRESS, BIRTHDATE) VALUES (?,?,?,?)";
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, contact.getName());
			stmt.setString(2, contact.getEmail());
			stmt.setString(3, contact.getAddress());
			stmt.setDate(4, new Date(contact.getBirthdate().getTimeInMillis()));
			stmt.execute();
			stmt.close();
		}catch(SQLException e){
			throw new RuntimeException();
		}
	}
	
	public void alter(Contact contact){
		String sql = "UPDATE CONTACT set NAME=?, EMAIL=?, ADDRESS=?, BIRTHDATE=? WHERE ID=?";
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, contact.getName());
			stmt.setString(2, contact.getEmail());
			stmt.setString(3, contact.getAddress());
			stmt.setDate(4, new Date(contact.getBirthdate().getTimeInMillis()));
			stmt.setLong(5, contact.getId());
			stmt.execute();
			stmt.close();
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public List<Contact> list(){
		try{
			List<Contact> contatos = new ArrayList<Contact>();
			PreparedStatement stmt = this.connection.prepareStatement("SELECT ID, NAME, EMAIL, ADDRESS, BIRTHDATE FROM CONTACT");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Contact contato = new Contact();
				contato.setId(rs.getLong("id"));
				contato.setName(rs.getString("name"));
				contato.setEmail(rs.getString("email"));
				contato.setAddress(rs.getString("address"));
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("birthdate"));
				contato.setBirthdate(data);
				contatos.add(contato);
			}
			rs.close();
			stmt.close();
			return contatos;
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public Contact get(long id){
		try{
			Contact contact = new Contact();
			PreparedStatement stmt = this.connection.prepareStatement("SELECT ID, NAME, EMAIL, ADDRESS, BIRTHDATE FROM CONTACT WHERE ID = " + id);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				contact.setId(rs.getLong("id"));
				contact.setName(rs.getString("name"));
				contact.setEmail(rs.getString("email"));
				contact.setAddress(rs.getString("address"));
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("birthdate"));
				contact.setBirthdate(data);
			}
			else
				return null;
			rs.close();
			stmt.close();
			return contact;
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public void delete(Contact contact){
		try{
			PreparedStatement stmt = connection.prepareStatement("DELETE FROM CONTACT WHERE ID = ?");
			stmt.setLong(1, contact.getId());
			stmt.execute();
			stmt.close();
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
}