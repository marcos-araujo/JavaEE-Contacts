package com.contacts.mvc.logic;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.contacts.dao.ContactsDAO;
import com.contacts.model.Contact;
import com.contacts.mvc.logic.aux.Constant;

public class Edit implements Logic{
	
    private static final Logger logger = LogManager.getLogger(Edit.class);
	
	public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception{
		Long id = !req.getParameter("id").equals("") ? Long.parseLong(req.getParameter("id")) : null;
		String name = req.getParameter("name");
		String address = req.getParameter("address");
		String email = req.getParameter("email");
		String dateText = req.getParameter("birthdate");
		Calendar birthdate = null;
		if(!dateText.equals(""))
			try{
				Date date =	new SimpleDateFormat("dd/MM/yyyy").parse(dateText);
				birthdate = Calendar.getInstance();
				birthdate.setTime(date);
			}catch(ParseException e){
				logger.error("date formating error", e);
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
			return Constant.PAGE_EDIT;
		}
		
		Connection connection = (Connection) req.getAttribute("connection");
		ContactsDAO dao = new ContactsDAO(connection);
		if(contact.getId() != null)
			dao.alter(contact);
		else
			dao.add(contact);
		
		logger.info("Edit");
		
		return Constant.LOGIC_LIST;
	}
	
}