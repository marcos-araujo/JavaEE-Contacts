<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="WEB-INF/views/general/header.jsp" />

	<div id="about">

	<div class="about">Store, edit and delete contacts.</div>
	
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
	
	<div class="about">Logic overview</div>
	<ul>
		<li>The view layer is in JSP</li>
		<li >The database connection is made in ConnectionFactory class</li>
		<li>The persistence is in a DAO class, the SQL commands are mounted on the class</li>
		<li>All requests go through a Filter, where a new database connection is made</li>
		<li>Filter also audits the request times</li>
		<li>Specific classes make specific operations, they implement the Logic interface</li>
		<li>The type of logic is a URL parameter</li>
		<li>The ServletController instantiate the corresponding class and the logic is executed</li>
		<li>The class returns the JSP page and the Servlet forward to the page</li>
	</ul>
	
	<div class="about">Free Software <a target="_blank" href="https://github.com/marcos-morgado/Web-Contacts">Code</a>. Feel free to contribute.</div>
	
	<br />
	
	<a href="mvc?logic=ListContacts"><input type="button" value="Back" class="button"/></a>
	<br /><br />
	
	</div>
	
	</body>
		
</html>
