<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="WEB-INF/views/general/header.jsp" />

	<div id="about">

	<div class="about">Sample project created for studying some Java EE technologies.</div>
	
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
	
	<div class="about">How it works</div>
	<ul>	
		<li>The FilterExecutionTime instantiates the connection and adds it inside the request as an attribute.</li>
		<li>The ControllerServlet receives all requests and delegates it to the logic class according to the URL parameter.</li>
		<li>Queries are executed by Prepared Statements.</li>
		<li>The view layer was built in JSP.</li>
	</ul>
	
	<div class="about">Free Software <a target="_blank" href="https://github.com/marcos-araujo/JavaEE-Contacts">Code</a>.</div>
	
	<br />
	
	<a href="mvc?logic=List"><input type="button" value="Back" class="button"/></a>
	<br /><br />
	
	</div>
	
	</body>
		
</html>
