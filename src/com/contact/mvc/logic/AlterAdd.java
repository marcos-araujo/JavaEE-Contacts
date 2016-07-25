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

public class AlterAdd implements Logic{
	
	public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception{
		Long id = !req.getParameter("id").equals("") ? Long.parseLong(req.getParameter("id")) : null;
		String name = req.getParameter("name");
		String address= req.getParameter("address");
		String email = req.getParameter("email");
		String dateText = req.getParameter("birthdate");
		Calendar birthdate = null;
		if(!dateText.equals(""))
			try{
				Date date =	new SimpleDateFormat("dd/MM/yyyy").parse(dateText);
				birthdate = Calendar.getInstance();
				birthdate.setTime(date);
			}catch(ParseException e){
				e.printStackTrace();
			}
		Contact contact = new Contact();
		contact.setId(id);
		contact.setName(name);
		contact.setAddress(address);
		contact.setEmail(email);
		contact.setBirthdate(birthdate);
		
		if(contact.getName().equals("")){
			req.setAttribute("contact", contact);
			req.setAttribute("message", "Name is required!");
			return "/WEB-INF/jsp/alter-add.jsp";
		}
		
		Connection connection = (Connection) req.getAttribute("connection");
		ContactDAO dao = new ContactDAO(connection);
		if(contact.getId() != null)
			dao.alter(contact);
		else
			dao.add(contact);
		System.out.println("Alter/Add");
		return "mvc?logic=ListContacts";
	}
			
}