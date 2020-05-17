# Java EE Contacts 
Create, edit, visualize and delete contacts.

## General Info
Sample project created for studying some Java EE technologies.

## Design Patterns
<ul> 
	<li>Model View Controler</li>
	<li>Data Acess Object </li>
</ul>

## APIs and Frameworks
<ul>	
	<li>Servlet</li>
	<li>JSP</li>
	<li>JSTL</li>
	<li>Filter</li>
</ul>

## How it works
The FilterExecutionTime instantiates the connection and adds it inside the request as an attribute.
The ControllerServlet receives all requests and delegates it to the logic class according to the URL parameter.
Queries are executed by Prepared Statements.
The view layer was built in JSP.