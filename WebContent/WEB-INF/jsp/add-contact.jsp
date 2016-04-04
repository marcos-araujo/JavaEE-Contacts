<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="caelum" %>
<!DOCTYPE html>
<html>
	<head>
		<link href="css/jquery-ui.css" rel="stylesheet">
		<link href="css/script.css" rel="stylesheet">
		<script src="js/jquery.js"></script>
		<script src="js/jquery-ui.js"></script>
		<meta charset="ISO-8859-1">
		<title>New Contact</title>
	</head>
	<body>
		<c:import url="header.jsp" />
		<h2>New Contact</h2>
		<form action="mvc" method="POST">
			Name: <input type="text" name="name" size="70"/><br /><br />
			E-mail: <input type="text" name="email" size="50"/><br /><br />
			Address: <input type="text" name="address" size="50"/><br /><br />
			Date of Birth: <caelum:fieldDate id="birthdate" /><br /><br />
			<input type="hidden" name="logic" value="AddContact"/>
			<input type="submit" value="Save" />
		</form>
		<c:import url="footer.jsp" />
	</body>
</html>