package com.contact.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.contact.mvc.logic.Logic;

@WebServlet("/mvc")
public class ControllerServlet extends HttpServlet{
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String parametro = request.getParameter("logic");
		String nomeDaClasse = "com.contact.mvc.logic." + parametro;
		try{
			Class classe = Class.forName(nomeDaClasse);
			Logic logic = (Logic) classe.newInstance();
			String page = logic.execute(request, response);
			request.getRequestDispatcher(page).forward(request, response);
		}catch(Exception e){
			throw new ServletException("The business logic caused an exception", e);
		}
	}
	
}