# Java EE Contacts 
Create, edit, visualize and delete contacts.

## General Info
Sample project created for studying some Java EE technologies.



## Design Patterns
<ul> 
	<li>Model View Controler</li>
	<li>Data Acess Object </li>
</ul>

## Technologies
<ul>	
	<li>Servlet</li>
	<li>JSP</li>
	<li>JSTL</li>
	<li>Filter</li>
</ul>

## How it works
The FilterExecutionTime filter instantiates the connection and adds it as an attribute in the request.
The ControllerServlet receives all requests and delegates it to the logic class according to the parameter passed in the url.
Queries are made with PreparedStatement.
The view layer is made with jsp.