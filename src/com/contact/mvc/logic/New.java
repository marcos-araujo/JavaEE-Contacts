package com.contact.mvc.logic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class New implements Logic{
	
	public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception{
		System.out.println("New");
		return "/WEB-INF/jsp/alter-add.jsp";
	}
			
}