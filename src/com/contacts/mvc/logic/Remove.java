package com.contacts.mvc.logic;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.contacts.dao.ContactsDAO;
import com.contacts.model.Contact;
import com.contacts.mvc.logic.aux.Constants;

public class Remove implements Logic{
	
    private static final Logger logger = LogManager.getLogger(Remove.class);
	
	public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception{
		long id = Long.parseLong(req.getParameter("id"));
		Contact contact = new Contact();
		contact.setId(id);
		Connection connection = (Connection) req.getAttribute("connection");
		ContactsDAO dao = new ContactsDAO(connection);
		dao.delete(contact);
		logger.info("Remove");
		return Constants.LOGIC_LIST;
	}

}