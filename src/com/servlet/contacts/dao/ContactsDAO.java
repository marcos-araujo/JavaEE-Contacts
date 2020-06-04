package com.servlet.contacts.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import com.servlet.contacts.model.Contact;
import com.servlet.contacts.mvc.logic.aux.Constant;

public class ContactsDAO{
	
	private Connection connection;
	
	public ContactsDAO(Connection connection){
		this.connection = connection;
	}
	
	public void add(Contact contact) throws SQLException{
		try(PreparedStatement stmt = this.connection.prepareStatement(Constant.INSERT)){
			stmt.setString(1, contact.getName());
			stmt.setString(2, contact.getEmail());
			stmt.setString(3, contact.getAddress());
			stmt.setDate(4, contact.getBirthdate() != null ? new Date(contact.getBirthdate().getTimeInMillis()) : null);
			stmt.execute();
		}
	}
	
	public void alter(Contact contact) throws SQLException{
		try(PreparedStatement stmt = this.connection.prepareStatement(Constant.UPDATE)){
			stmt.setString(1, contact.getName());
			stmt.setString(2, contact.getEmail());
			stmt.setString(3, contact.getAddress());
			stmt.setDate(4, contact.getBirthdate() != null ? new Date(contact.getBirthdate().getTimeInMillis()) : null);
			stmt.setLong(5, contact.getId());
			stmt.execute();
		}
	}
	
	public List<Contact> list() throws SQLException{
		try(PreparedStatement stmt = this.connection.prepareStatement(Constant.SELECT); ResultSet rs = stmt.executeQuery()){
			List<Contact> contatos = new ArrayList<>();
			while(rs.next()){
				Contact contato = new Contact();
				contato.setId(rs.getLong(Constant.ID));
				contato.setName(rs.getString(Constant.NAME));
				contato.setEmail(rs.getString(Constant.EMAIL));
				contato.setAddress(rs.getString(Constant.ADDRESS));
				if(rs.getDate(Constant.BIRTHDATE) != null){
					Calendar data = GregorianCalendar.getInstance();
					data.setTime(new java.util.Date(rs.getDate(Constant.BIRTHDATE).getTime()));
					contato.setBirthdate(data);
				}
				contatos.add(contato);
			}
			return contatos;
		}
	}
	
	public Contact get(long id) throws SQLException{
		try(PreparedStatement stmt = this.connection.prepareStatement(Constant.SELECT_ID)){
			stmt.setLong(1, id);
			try(ResultSet rs = stmt.executeQuery()){
				if(rs.next()){
					Contact contact = new Contact();
					contact.setId(rs.getLong(Constant.ID));
					contact.setName(rs.getString(Constant.NAME));
					contact.setEmail(rs.getString(Constant.EMAIL));
					contact.setAddress(rs.getString(Constant.ADDRESS));
					if(rs.getDate(Constant.BIRTHDATE) != null){
						Calendar data = Calendar.getInstance();
						data.setTime(rs.getDate(Constant.BIRTHDATE));
						contact.setBirthdate(data);
					}
					return contact;
				}
				return null;
			}
		}
	}
	
	public void delete(Contact contact) throws SQLException{
		try(PreparedStatement stmt = connection.prepareStatement(Constant.DELETE)){
			stmt.setLong(1, contact.getId());
			stmt.execute();
		}
	}
	
}