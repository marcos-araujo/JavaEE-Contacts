<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link href="resources/css/contact.css" rel="stylesheet">
		<link rel="shortcut icon" type="image/x-icon" href="resources/images/favicon.ico">
		<title>List of Contacts</title>
	</head>
	<body>
		<c:import url="../general/header.jsp" />
		<br /><br />
		<table id="tableLista" width="100%">
			<tr id="tableHeader" align="center" valign="middle">
				<th width="30%"><b>Name</b></th>
				<th width="30%"><b>E-mail</b></th>
				<th width="30%"><b>Address</b></th>
				<th width="6%"><b>Birthday</b></th>
				<th width="2%">&nbsp;</th>
				<th width="2%">&nbsp;</th>
			</tr>
			<c:forEach var="contact" items="${contacts}" varStatus="id">
				<tr bgcolor="#${id.count % 2 == 0 ? 'D3D3D3' : 'EFEFEF'}" >
					<td>${fn:substring(contact.name, 0, 15)}</td>
					<td>
						<c:choose>
							<c:when test="${not empty contact.email}"><a href="mailto:${contact.email}">${contact.email}</a></c:when>
							<c:otherwise>E-mail not informed</c:otherwise>
						</c:choose>
					</td>
					<td>${contact.address}</td>
					<td><fmt:formatDate value="${contact.birthdate.time}" pattern="dd/MM/yyyy" /></td>
					<td align="center"><a href="mvc?logic=Show&id=${contact.id}" title="Edit"><img src="resources/images/edit.png" width="15"/></a></td>
					<td align="center"><a href="mvc?logic=Remove&id=${contact.id}" title="Delete"><img src="resources/images/remove.png" width="15"/></a></td>
				</tr>
			</c:forEach>
		</table>
		<br />
		<a href="mvc?logic=New"><input type="button" value="New Contact" class="button"/></a>
		<c:import url="../general/footer.jsp" />
	</body>
</html>