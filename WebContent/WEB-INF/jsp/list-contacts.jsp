<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>List</title>
	</head>
	<body>
		<c:import url="header.jsp" />
		<h2>List of Contacts</h2>
		<table>
			<tr>
				<td><b>Name</b></td>
				<td><b>E-mail</b></td>
				<td><b>Address</b></td>
				<td><b>Date of birth</b></td>
				<td></td>
				<td></td>
			</tr>
			<c:forEach var="contact" items="${contacts}" varStatus="id">
				<tr bgcolor="#${id.count % 2 == 0 ? 'aaee88' : 'ffffff'}" >
					<td><a href="mvc?logic=ShowContact&id=${contact.id}">${contact.name}</a></td>
					<td>
						<c:choose>
							<c:when test="${not empty contact.email}">
								<a href="mailto:${contact.email}">${contact.email}</a>
							</c:when>
							<c:otherwise>
								E-mail not informed
							</c:otherwise>
						</c:choose>
					</td>
					<td>${contact.address}</td>
					<td><fmt:formatDate value="${contact.birthdate.time}" pattern="dd/MM/yyyy" /></td>
					<td><a href="mvc?logic=RemoveContact&id=${contact.id}">Remove</a></td>
				</tr>
			</c:forEach>
		</table>
		<br />
		<a href="mvc?logic=NewContact">New Contact</a>
		<c:import url="footer.jsp" />
	</body>
</html>