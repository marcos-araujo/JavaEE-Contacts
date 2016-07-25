package com.contact.mvc.logic;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.contact.dao.ContactDAO;
import com.contact.model.Contact;

public class ListContacts implements Logic{
	
	public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception{
		Connection connection = (Connection) req.getAttribute("connection");
		List<Contact> contacts = new ContactDAO(connection).list();
		req.setAttribute("contacts", contacts);
		System.out.println("Listing");
		return "/WEB-INF/jsp/list.jsp";
	}
			
}