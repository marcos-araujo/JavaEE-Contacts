package com.contact.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.contact.mvc.logic.Logic;

@SuppressWarnings("serial")
@WebServlet("/mvc")
public class ControllerServlet extends HttpServlet{
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String logicParameter = request.getParameter("logic");
		String packageString = "com.contact.mvc.logic.";
		Class<?> classLogic;
		try{
			
			try{
				classLogic = Class.forName(packageString + logicParameter);
			}catch(Exception e){
				classLogic = Class.forName(packageString + "ListContacts");
			}
			Logic logic = (Logic) classLogic.newInstance();
			String page = logic.execute(request, response);
			request.getRequestDispatcher(page).forward(request, response);
		
		}catch(Exception e){
			throw new ServletException("The business logic caused an exception:", e);
		}
	}
	
}