<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
		
<c:import url="../general/header.jsp" />
<form action="mvc" method="POST">
	
	<fmt:formatDate pattern = "dd/MM/yyyy" value ="${contact.birthdate.time}" var="strDate"/> 
	
	<table>
		<tr>
			<td>Name</td>
			<td colspan="2"><input type="text" name="name" value="${contact.name}" size="80" maxlength="80" /></td>
		</tr>
		<tr>
			<td>E-mail</td>
			<td align="left"><input type="text" name="email" value="${contact.email}" size="50" maxlength="80" ></td>
			
			<td align="right">Date of Birth<mytags:fieldDate id="birthdate" value="${strDate}" /></td>
		</tr>
		<tr>
			<td>Address</td>
			<td colspan="2"><input type="text" name="address" value="${contact.address}" size="80" maxlength="100" /></td>
		</tr>
	</table>

	<br />
	<input type="hidden" name="id" value="${contact.id}"/>
	<input type="hidden" name="logic" value="AlterAdd"/>
	<input type="submit" value="Save" class="button"/>
	<a href="mvc?logic=ListContacts"><input class="button" type="button" value="Cancel" /></a>
	<br /><br />
	<span id="message"><b>${message}</b></span>
</form>
<br />
<c:import url="../general/footer.jsp" />