package com.contacts.mvc.logic;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.contacts.dao.ContactsDAO;
import com.contacts.model.Contact;
import com.contacts.mvc.logic.aux.Constant;

public class List implements Logic{
	
    private static final Logger logger = LogManager.getLogger(List.class);
    
	public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception{
		Connection connection = (Connection) req.getAttribute("connection");
		java.util.List<Contact> contacts = new ContactsDAO(connection).list();
		req.setAttribute("contacts", contacts);
		logger.info("Listing");
		return Constant.PAGE_LIST;
	}
			
}