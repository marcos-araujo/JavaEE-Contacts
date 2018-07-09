<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
		
<c:import url="../general/header.jsp" />
<form action="mvc" method="POST">
	<table border="0" width="500">
		<tr>
			<td>Name</td>
			<td colspan="2"><input type="text" name="name" value="${contact.name}" size="80" maxlength="80" /></td>
		</tr>
		<tr>
			<td>E-mail</td>
			<td align="left"><input type="text" name="email" value="${contact.email}" size="50" maxlength="80" ></td>
			<td align="right">Date of Birth<mytags:fieldDate id="birthdate" value="${contact.textDate}" /></td>
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
	<span><b>${message}</b></span>
</form>
<br />
<c:import url="../general/footer.jsp" />