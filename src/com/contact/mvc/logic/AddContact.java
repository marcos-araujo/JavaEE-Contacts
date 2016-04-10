package com.contact.mvc.logic;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.contact.dao.ContactDAO;
import com.contact.model.Contact;

public class AddContact implements Logic{
	
	public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception{
		String name = req.getParameter("name");
		String address = req.getParameter("address");
		String email = req.getParameter("email");
		String dateText = req.getParameter("birthdate");
		Calendar birthdate = null;
		if(!dateText.equals("")){
			try{
				Date date =	new SimpleDateFormat("dd/MM/yyyy").parse(dateText);
				birthdate = Calendar.getInstance();
				birthdate.setTime(date);
			}catch(ParseException e){
				e.printStackTrace();
			}
		}
		Contact contact = new Contact();
		contact.setName(name);
		contact.setAddress(address);
		contact.setEmail(email);
		contact.setBirthdate(birthdate);
		Connection connection = (Connection) req.getAttribute("connection");
		ContactDAO dao = new ContactDAO(connection);
		dao.add(contact);
		System.out.println("Adding Contact.");
		return "mvc?logic=ListContacts";
	}
			
}