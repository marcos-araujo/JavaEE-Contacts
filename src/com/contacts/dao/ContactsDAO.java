package com.contacts.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import com.contacts.model.Contact;
import com.contacts.mvc.logic.aux.Constants;

public class ContactsDAO{
	
	private Connection connection;
	
	
	public ContactsDAO(Connection connection){
		this.connection = connection;
	}
	
	public void add(Contact contact) throws SQLException{
		try(PreparedStatement stmt = this.connection.prepareStatement(Constants.INSERT)){
			stmt.setString(1, contact.getName());
			stmt.setString(2, contact.getEmail());
			stmt.setString(3, contact.getAddress());
			stmt.setDate(4, contact.getBirthdate() != null ? new Date(contact.getBirthdate().getTimeInMillis()) : null);
			stmt.execute();
		}
	}
	
	public void alter(Contact contact) throws SQLException{
		try(PreparedStatement stmt = this.connection.prepareStatement(Constants.UPDATE)){
			stmt.setString(1, contact.getName());
			stmt.setString(2, contact.getEmail());
			stmt.setString(3, contact.getAddress());
			stmt.setDate(4, contact.getBirthdate() != null ? new Date(contact.getBirthdate().getTimeInMillis()) : null);
			stmt.setLong(5, contact.getId());
			stmt.execute();
		}
	}
	
	public List<Contact> list() throws SQLException{
		try(PreparedStatement stmt = this.connection.prepareStatement(Constants.SELECT); ResultSet rs = stmt.executeQuery()){
			List<Contact> contatos = new ArrayList<>();
			while(rs.next()){
				Contact contato = new Contact();
				contato.setId(rs.getLong(Constants.ID));
				contato.setName(rs.getString(Constants.NAME));
				contato.setEmail(rs.getString(Constants.EMAIL));
				contato.setAddress(rs.getString(Constants.ADDRESS));
				if(rs.getDate(Constants.BIRTHDATE) != null){
					Calendar data = GregorianCalendar.getInstance();
					data.setTime(new java.util.Date(rs.getDate(Constants.BIRTHDATE).getTime()));
					contato.setBirthdate(data);
				}
				contatos.add(contato);
			}
			return contatos;
		}
	}
	
	public Contact get(long id) throws SQLException{
		try(PreparedStatement stmt = this.connection.prepareStatement(Constants.SELECT_ID)){
			stmt.setLong(1, id);
			try(ResultSet rs = stmt.executeQuery()){
				if(rs.next()){
					Contact contact = new Contact();
					contact.setId(rs.getLong(Constants.ID));
					contact.setName(rs.getString(Constants.NAME));
					contact.setEmail(rs.getString(Constants.EMAIL));
					contact.setAddress(rs.getString(Constants.ADDRESS));
					if(rs.getDate(Constants.BIRTHDATE) != null){
						Calendar data = Calendar.getInstance();
						data.setTime(rs.getDate(Constants.BIRTHDATE));
						contact.setBirthdate(data);
					}
					return contact;
				}
				return null;
			}
		}
	}
	
	public void delete(Contact contact) throws SQLException{
		try(PreparedStatement stmt = connection.prepareStatement(Constants.DELETE)){
			stmt.setLong(1, contact.getId());
			stmt.execute();
		}
	}
	
}