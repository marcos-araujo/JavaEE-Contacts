package com.servlet.contacts.mvc.logic;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Optional;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.servlet.contacts.mvc.logic.aux.Constant;

public class LogicAux {

    private static final Logger logger = LogManager.getLogger(LogicAux.class);
	
	private LogicAux() {}
	
	public static Logic getLogic(String className) {
		
		try {

			Class<?> classLogic = Class.forName(Constant.PACKAGE_LOGIC + className);
	    	
	    	Stream<Constructor<?>> constructors = Stream.of(classLogic.getDeclaredConstructors());
	    	
			Optional<Constructor<?>> defaultConstructor = constructors
					.filter(constructor -> constructor.getParameterCount() == 0).findFirst();
	    	
			return (Logic) defaultConstructor.get().newInstance();
			
	    } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | 
	    		IllegalArgumentException | InvocationTargetException e) {
	    	logger.error("Logic not found", e);
	    	throw new RuntimeException("Error instantiating new Logic", e);
	    }
	    
	}

}