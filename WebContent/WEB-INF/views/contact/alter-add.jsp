<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link href="resources/css/jquery-ui.css" rel="stylesheet">
		<link href="resources/css/contact.css" rel="stylesheet">
		<script src="resources/js/jquery.js"></script>
		<script src="resources/js/jquery-ui.js"></script>
		<link rel="shortcut icon" type="image/x-icon" href="resources/images/favicon.ico">
		<title>Contact</title>
	</head>
	<body>
		<c:import url="../general/header.jsp" />
		<br /><br />
		<form action="mvc" method="POST">
			<span><b>${message}</b></span>
			<table border="0" width="500">
				<tr>
					<td>Name:</td>
					<td colspan="2"><input type="text" name="name" value="${contact.name}" size="80" maxlength="80" /></td>
				</tr>
				<tr>
					<td>E-mail:</td>
					<td align="left"><input type="text" name="email" value="${contact.email}" size="54" maxlength="80" ></td>
					<td align="right">Date of Birth : <mytags:fieldDate id="birthdate" value="${contact.textDate}" /></td>
				</tr>
				<tr>
					<td>Address:</td>
					<td colspan="2"><input type="text" name="address" value="${contact.address}" size="80" maxlength="100" /></td>
				</tr>
			</table>

			<br />
			<input type="hidden" name="id" value="${contact.id}"/>
			<input type="hidden" name="logic" value="AlterAdd"/>
			<input type="submit" value="Save" class="button"/>
			<a href="mvc?logic=ListContacts"><input class="button" type="button" value="Cancel" /></a>
		</form>
		<br />
		<c:import url="../general/footer.jsp" />
	</body>
</html>