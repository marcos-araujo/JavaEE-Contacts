
package com.servlet.contacts.mvc.logic;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.servlet.contacts.dao.ContactsDAO;
import com.servlet.contacts.model.Contact;
import com.servlet.contacts.mvc.logic.aux.Constant;

public class Save implements Logic{
	
    private static final Logger logger = LogManager.getLogger(Save.class);
	
	public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception{
		
		Contact contact = populateContact(req);
		
		if(!isValidContact(req, contact))
			return Constant.PAGE_EDIT;
		
		Connection connection = (Connection) req.getAttribute("connection");
		ContactsDAO dao = new ContactsDAO(connection);
		
		if(contact.getId() != null)
			dao.alter(contact);
		else
			dao.add(contact);
		
		logger.info("Save");
		
		return Constant.LOGIC_LIST;
	}

	private boolean isValidContact(HttpServletRequest req, Contact contact) {
		if(contact.getName().isEmpty()){
			req.setAttribute("contact", contact);
			req.setAttribute("message", "Name is required!");
			return false;
		}
		return true;
	}

	private Contact populateContact(HttpServletRequest req) throws ParseException {
		Contact contact = new Contact();
		contact.setId(!req.getParameter("id").isEmpty() ? Long.parseLong(req.getParameter("id")) : null);
		contact.setName(req.getParameter("name"));
		contact.setAddress(req.getParameter("address"));
		contact.setEmail(req.getParameter("email"));
		
		String dateText = req.getParameter("birthdate");
		if(!dateText.equals("")) {
			Calendar birthdate = Calendar.getInstance();
			birthdate.setTime(new SimpleDateFormat("dd/MM/yyyy").parse(dateText));
			contact.setBirthdate(birthdate);
		}

		return contact;
	}
	
}