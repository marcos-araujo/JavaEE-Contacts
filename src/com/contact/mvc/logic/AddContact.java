package com.contact.mvc.logic;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.contact.dao.ContactDAO;
import com.contact.model.Contact;

public class AddContact implements Logic{
	
	public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception{
		String nome = req.getParameter("name");
		String endereco = req.getParameter("address");
		String email = req.getParameter("email");
		String dataEmTexto = req.getParameter("birthdate");
		Calendar dataNascimento = null;
		try{
			Date date =	new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(date);
		}catch(ParseException e){
			e.printStackTrace();
		}
		Contact contato = new Contact();
		contato.setName(nome);
		contato.setAddress(endereco);
		contato.setEmail(email);
		contato.setBirthdate(dataNascimento);
		Connection connection = (Connection) req.getAttribute("connection");
		ContactDAO dao = new ContactDAO(connection);
		dao.add(contato);
		System.out.println("Adding contact.");
		return "mvc?logic=ListContacts";
	}
			
}