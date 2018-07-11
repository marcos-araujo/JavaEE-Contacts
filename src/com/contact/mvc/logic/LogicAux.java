package com.contact.mvc.logic;

import org.apache.log4j.Logger;

public class LogicAux {

	static final Logger logger = Logger.getLogger(AlterAdd.class);
	
	private LogicAux() {}
	
	public static Logic getLogic(String className) throws ClassNotFoundException {
		String packageString = "com.contact.mvc.logic.";
		
		Class<?> classLogic = null;
		Logic logic = null;
		
	    try {
	    	classLogic = Class.forName(packageString + className);
	    } catch (ClassNotFoundException e) {
	    	logger.error("Logic not found", e);
	    	classLogic = Class.forName("com.contact.mvc.logic.ListContacts");
	    }
	    
	    try {
	    	logic = (Logic) classLogic.newInstance();
	    } catch (InstantiationException | IllegalAccessException e) {
	    	logger.error("Error to instantiate new Logic", e);
	    }
	    
	    return logic;
	}

}