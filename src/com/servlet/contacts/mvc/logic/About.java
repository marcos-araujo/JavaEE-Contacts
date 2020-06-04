package com.servlet.contacts.mvc.logic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.servlet.contacts.mvc.logic.aux.Constant;

public class About implements Logic{
	
    private static final Logger logger = LogManager.getLogger(About.class);
	
	public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception{
		logger.info("About");
		return Constant.PAGE_ABOUT;
	}
			
}