package com.servlet.filter;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.servlet.contacts.jdbc.ConnectionFactory;

@WebFilter("/*")
public class FilterExecutionTime implements Filter{
	
    private static final Logger logger = LogManager.getLogger(FilterExecutionTime.class);
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{
		try{
			long initialTime = System.currentTimeMillis();
			Connection connection = new ConnectionFactory().getConnection();
			request.setAttribute("connection", connection);
			String logic = ((HttpServletRequest)request).getParameter("logic");
			String uri = ((HttpServletRequest)request).getRequestURI();
			
			if(logic == null && !uri.contains("/resources/")) {
				 RequestDispatcher rd = request.getRequestDispatcher("/mvc?logic=List");
                 rd.include(request, response);
			}else { 
				chain.doFilter(request, response);
			}
			
			connection.close();
			long finalTime = System.currentTimeMillis();
			
			if(!uri.contains("/resources/"))
				logger.info("Request time: " + uri + (logic!=null?("?logic=" + logic):"") + " is (ms): " + (finalTime - initialTime));
			
		}catch(SQLException | URISyntaxException e){
			logger.error(e);
		}
	}

	@Override
	public void destroy(){
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException{
	}

}