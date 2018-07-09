<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<c:import url="../general/header.jsp" />
<br />

<table id="tableLista">
	<tr id="tableHeader" align="center" valign="middle">
		<th width="35%"><b>Name</b></th>
		<th width="26%"><b>E-mail</b></th>
		<th width="30%"><b>Address</b></th>
		<th width="15%"><b>Date of Birth</b></th>
		<th width="2%">&nbsp;</th>
		<th width="2%">&nbsp;</th>
	</tr>
	<c:forEach var="contact" items="${contacts}" varStatus="id">
		<tr bgcolor="#${id.count % 2 == 0 ? 'EFEFEF' : 'faf9e7'}" >
			<td>${fn:substring(contact.name, 0, 15)}</td>
			
			<td>
				<c:choose>
					<c:when test="${not empty contact.email}">
						<a href="mailto:${contact.email}">${contact.email}</a>
					</c:when>
					<c:otherwise>E-mail not informed</c:otherwise>
				</c:choose>
			</td>
			
			<td>${contact.address}</td>
			
			<td>
				<fmt:formatDate value="${contact.birthdate.time}" pattern="dd/MM/yyyy" />
			</td>
			
			<td align="center">
				<a href="mvc?logic=Show&id=${contact.id}" title="Edit">
					<img src="resources/images/edit.png" width="15"/>
				</a>
			</td>
			
			<td align="center">
				<a href="mvc?logic=Remove&id=${contact.id}" title="Delete">
					<img src="resources/images/remove.png" width="15"/>
				</a>
			</td>
		</tr>
	</c:forEach>
</table>

<br />
<a href="mvc?logic=New"><input type="button" value="New" class="button"/></a>
<c:import url="../general/footer.jsp" />