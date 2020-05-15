package com.contacts.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.contacts.mvc.logic.Logic;
import com.contacts.mvc.logic.LogicAux;

@SuppressWarnings("serial")
@WebServlet("/mvc")
public class ControllerServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String logicParameter = request.getParameter("logic");
		try {
			Logic logic = LogicAux.getLogic(logicParameter);
			String page = logic.execute(request, response);
			request.getRequestDispatcher(page).forward(request, response);
		}catch(Exception e){
			throw new ServletException("The business logic caused an exception:", e);
		}
	}
	
}