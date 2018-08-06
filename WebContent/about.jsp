<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="WEB-INF/views/general/header.jsp" />

	<div id="about">

	<div class="about">Store, edit and delete contacts</div>
	
	<div class="about">Design Patterns</div>
	<ul> 
		<li>Model View Controler</li>
		<li>Data Acess Object</li>
	</ul>
	
	<div class="about">APIs and Frameworks</div>	
	<ul>	
		<li>Servlet</li>
		<li>JSP</li>
		<li>JSTL</li>
		<li>Filter</li>
	</ul>
	
	<div class="about">Free Software <a target="_blank" href="https://github.com/marcos-morgado/Web-Contacts">Code</a>.</div>
	
	<br />
	
	<a href="mvc?logic=ListContacts"><input type="button" value="Back" class="button"/></a>
	<br /><br />
	
	</div>
	
	</body>
		
</html>
