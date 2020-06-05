package com.servlet.contacts.mvc.logic.aux;

public class Constant {

	public final static String PACKAGE_LOGIC = "com.servlet.contacts.mvc.logic.";
	public final static String PACKAGE_LIST = "com.servlet.contacts.mvc.logic.List";
	
	public final static String PAGE_LIST = "/WEB-INF/views/contacts/list.jsp";
	public final static String PAGE_EDIT = "/WEB-INF/views/contacts/edit.jsp";
	public final static String PAGE_ABOUT = "/WEB-INF/views/general/about.jsp";
	
	public final static String LOGIC_LIST = "mvc?logic=List";
	
	public static final String BIRTHDATE = "birthdate";
	public static final String ADDRESS = "address";
	public static final String EMAIL = "email";
	public static final String NAME = "name";
	public static final String ID = "id";

	public static final String UPDATE = "UPDATE CONTACTS SET NAME=?, EMAIL=?, ADDRESS=?, BIRTHDATE=? WHERE ID=?";
	public static final String INSERT = "INSERT INTO CONTACTS (NAME, EMAIL, ADDRESS, BIRTHDATE) VALUES (?,?,?,?)";
	public static final String SELECT = "SELECT ID, NAME, EMAIL, ADDRESS, BIRTHDATE FROM CONTACTS";
	public static final String SELECT_ID = "SELECT ID, NAME, EMAIL, ADDRESS, BIRTHDATE FROM CONTACTS WHERE ID = ?";
	public static final String DELETE = "DELETE FROM CONTACTS WHERE ID = ?";

}
