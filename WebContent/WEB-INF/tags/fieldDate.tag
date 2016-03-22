<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ attribute name="id" required="true" %>
<%@ attribute name="value" %>

<input id="${id}" name="${id}" value="${value}" size="8"/>
<script>
	$("#${id}").datepicker({dateFormat: 'dd/mm/yy'});
</script>