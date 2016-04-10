package com.contact.mvc.logic;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.contact.dao.ContactDAO;
import com.contact.model.Contact;

public class RemoveContact implements Logic{
	
	public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception{
		long id = Long.parseLong(req.getParameter("id"));
		Contact contact = new Contact();
		contact.setId(id);
		Connection connection = (Connection) req.getAttribute("connection");
		ContactDAO dao = new ContactDAO(connection);
		dao.delete(contact);
		System.out.println("Removing Contact.");
		return "mvc?logic=ListContacts";
	}

}