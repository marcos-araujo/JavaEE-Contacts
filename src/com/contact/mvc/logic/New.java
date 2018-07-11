package com.contact.mvc.logic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class New implements Logic{
	
	static final Logger logger = Logger.getLogger(AlterAdd.class);
	
	public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception{
		logger.info("New");
		return "/WEB-INF/views/contact/alter-add.jsp";
	}
			
}