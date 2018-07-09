package com.contact.filter;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.contact.jdbc.ConnectionFactory;

@WebFilter("/*")
public class FilterExecutionTime implements Filter{
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{
		try{
			long initialTime = System.currentTimeMillis();
			Connection connection = new ConnectionFactory().getConnection();
			request.setAttribute("connection", connection);
			chain.doFilter(request, response);
			String uri = ((HttpServletRequest)request).getRequestURI();
			String logic = ((HttpServletRequest)request).getParameter("logic");
			connection.close();
			long finalTime = System.currentTimeMillis();
			
			if(!uri.contains("/resources/"))
				System.out.println("Request time: " + uri + (logic!=null?("?logic=" + logic):"") + " is (ms): " + (finalTime - initialTime));
			
		}catch(SQLException | URISyntaxException e){
			System.out.println("Error SQL " + e.getMessage());
		}
	}

	@Override
	public void destroy(){
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException{
	}

}