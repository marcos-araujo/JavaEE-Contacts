package com.servlet.contacts.mvc.logic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.servlet.contacts.mvc.logic.aux.Constant;

public class New implements Logic{
	
    private static final Logger logger = LogManager.getLogger(New.class);

	public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception{
		logger.info("New");
		return Constant.PAGE_EDIT;
	}
			
}