<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="caelum" %>
<!DOCTYPE html>
<html>
	<head>
		<link href="css/jquery-ui.css" rel="stylesheet">
		<link href="css/style.css" rel="stylesheet">
		<script src="js/jquery.js"></script>
		<script src="js/jquery-ui.js"></script>
		<meta charset="ISO-8859-1">
		<title>Alter Contact</title>
	</head>
	<body>
		<c:import url="header.jsp" />
		<h2>Alter Contact</h2>
		<form action="mvc" method="POST">
			Name: <input type="text" name="name" value="${contact.name}" size="70"/><br /><br />
			E-mail: <input type="text" name="email" value="${contact.email}" size="50"/><br /><br />
			Address: <input type="text" name="address" value="${contact.address}" size="50"/><br /><br />
			Date of Birth: <caelum:fieldDate id="birthdate" value="${date}" /><br /><br />
			<input type="hidden" name="id" value="${contact.id}"/>
			<input type="hidden" name="logic" value="AlterContact"/>
			<input type="submit" value="Save" />
		</form>
		<c:import url="footer.jsp" />
	</body>
</html>