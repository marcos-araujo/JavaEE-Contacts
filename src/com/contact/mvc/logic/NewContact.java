package com.contact.mvc.logic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NewContact implements Logic{
	
	public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception{
		System.out.println("New contact.");
		return "/WEB-INF/jsp/add-contact.jsp";
	}
			
}