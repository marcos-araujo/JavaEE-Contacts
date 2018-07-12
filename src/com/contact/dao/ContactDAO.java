package com.contact.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import com.contact.model.Contact;

public class ContactDAO{
	
	private Connection connection;
	
	private static final String SQL_UPDATE = "UPDATE CONTACT SET NAME=?, EMAIL=?, ADDRESS=?, BIRTHDATE=? WHERE ID=?";
	private static final String SQL_INSERT = "INSERT INTO CONTACT (NAME, EMAIL, ADDRESS, BIRTHDATE) VALUES (?,?,?,?)";
	private static final String SQL_SELECT = "SELECT ID, NAME, EMAIL, ADDRESS, BIRTHDATE FROM CONTACT";
	private static final String SQL_SELECT_ID = "SELECT ID, NAME, EMAIL, ADDRESS, BIRTHDATE FROM CONTACT WHERE ID = ?";
	private static final String SQL_DELETE = "DELETE FROM CONTACT WHERE ID = ?";
	
	public ContactDAO(Connection connection){
		this.connection = connection;
	}
	
	public void add(Contact contact) throws SQLException{
		try(PreparedStatement stmt = this.connection.prepareStatement(SQL_INSERT)){
			stmt.setString(1, contact.getName());
			stmt.setString(2, contact.getEmail());
			stmt.setString(3, contact.getAddress());
			stmt.setDate(4, contact.getBirthdate() != null ? new Date(contact.getBirthdate().getTimeInMillis()) : null);
			stmt.execute();
		}
	}
	
	public void alter(Contact contact) throws SQLException{
		try(PreparedStatement stmt = this.connection.prepareStatement(SQL_UPDATE)){
			stmt.setString(1, contact.getName());
			stmt.setString(2, contact.getEmail());
			stmt.setString(3, contact.getAddress());
			stmt.setDate(4, contact.getBirthdate() != null ? new Date(contact.getBirthdate().getTimeInMillis()) : null);
			stmt.setLong(5, contact.getId());
			stmt.execute();
		}
	}
	
	public List<Contact> list() throws SQLException{
		try(PreparedStatement stmt = this.connection.prepareStatement(SQL_SELECT); ResultSet rs = stmt.executeQuery()){
			List<Contact> contatos = new ArrayList<>();
			while(rs.next()){
				Contact contato = new Contact();
				contato.setId(rs.getLong("id"));
				contato.setName(rs.getString("name"));
				contato.setEmail(rs.getString("email"));
				contato.setAddress(rs.getString("address"));
				if(rs.getDate("birthdate") != null){
					Calendar data = GregorianCalendar.getInstance();
					data.setTime(new java.util.Date(rs.getDate("birthdate").getTime()));
					contato.setBirthdate(data);
				}
				contatos.add(contato);
			}
			return contatos;
		}
	}
	
	public Contact get(long id) throws SQLException{
		try(PreparedStatement stmt = this.connection.prepareStatement(SQL_SELECT_ID)){
			stmt.setLong(1, id);
			try(ResultSet rs = stmt.executeQuery()){
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
			}
		}
	}
	
	public void delete(Contact contact) throws SQLException{
		try(PreparedStatement stmt = connection.prepareStatement(SQL_DELETE)){
			stmt.setLong(1, contact.getId());
			stmt.execute();
		}
	}
	
}