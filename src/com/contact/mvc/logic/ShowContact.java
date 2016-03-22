package com.contact.mvc.logic;

import java.sql.Connection;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.contact.dao.ContactDAO;
import com.contact.model.Contact;

public class ShowContact implements Logic{
	
	public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception{
		long id = Long.parseLong(req.getParameter("id"));
		Connection connection = (Connection) req.getAttribute("connection");
		ContactDAO dao = new ContactDAO(connection);
		Contact contact = dao.get(id);
		req.setAttribute("contact", contact);
		req.setAttribute("date", new SimpleDateFormat("dd/MM/yyyy").format(contact.getBirthdate().getTime()));
		System.out.println("Showing contact");
		return "/WEB-INF/jsp/alter-contact.jsp";
	}
			
}