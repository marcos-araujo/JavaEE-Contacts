package com.contact.mvc.logic;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.contact.dao.ContactDAO;
import com.contact.model.Contact;

public class ListContacts implements Logic{
	
	static final Logger logger = Logger.getLogger(AlterAdd.class);
	
	public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception{
		Connection connection = (Connection) req.getAttribute("connection");
		List<Contact> contacts = new ContactDAO(connection).list();
		req.setAttribute("contacts", contacts);
		logger.info("Listing");
		return "/WEB-INF/views/contact/list.jsp";
	}
			
}