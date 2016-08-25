<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link href="resources/css/jquery-ui.css" rel="stylesheet">
		<link href="resources/css/contact.css" rel="stylesheet">
		<script src="resources/js/jquery.js"></script>
		<script src="resources/js/jquery-ui.js"></script>
		<link rel="shortcut icon" type="image/x-icon" href="images/favicon.ico">
		<title>About the project</title>
	</head>
	<body>
		<c:import url="/WEB-INF/views/header.jsp" />
		<h2>Concepts</h2> 
		<ul> 
			<li>Model View Controler</li>
			<li>Data Acess Object</li>
			<li>Servlet</li>
			<li>JSP</li>
			<li>JSTL</li>
			<li>Filter</li>
		</ul>
		<a href="mvc?logic=ListContacts"><input type="button" value="Back" class="button"/></a>
		<c:import url="/WEB-INF/views/footer.jsp" />
	</body>
</html>