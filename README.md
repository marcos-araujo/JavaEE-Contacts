# Web Contacts 


Store, edit and delete contacts.

Design Patterns
<ul> 
	<li>Model View Controler</li>
	<li>Data Acess Object</li>
</ul>

APIs and Frameworks	
<ul>	
	<li>Servlet</li>
	<li>JSP</li>
	<li>JSTL</li>
	<li>Filter</li>
</ul>

Logic overview
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
