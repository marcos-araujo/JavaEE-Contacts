<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link href="css/jquery-ui.css" rel="stylesheet">
		<link href="css/style.css" rel="stylesheet">
		<script src="js/jquery.js"></script>
		<script src="js/jquery-ui.js"></script>
		<link rel="shortcut icon" type="image/x-icon" href="images/favicon.ico">
		<title>Alter Contact</title>
	</head>
	<body>
		<c:import url="header.jsp" />
		<h2>Alter Contact</h2>
		<a href="mvc?logic=ListContacts">Cancel</a>
		<br /><br />
		<form action="mvc" method="POST">
			Name: <input type="text" name="name" value="${contact.name}" size="70"/><br /><br />
			E-mail: <input type="text" name="email" value="${contact.email}" size="50"/><br /><br />
			Address: <input type="text" name="address" value="${contact.address}" size="50"/><br /><br />
			Date of Birth: <mytags:fieldDate id="birthdate" value="${date}" /><br /><br />
			<input type="hidden" name="id" value="${contact.id}"/>
			<input type="hidden" name="logic" value="AlterContact"/>
			<input type="submit" value="Save" />
		</form>
		<c:import url="footer.jsp" />
	</body>
</html>