<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ attribute name="id" required="true" %>
<%@ attribute name="value" %>

<input id="${id}" name="${id}" value="${value}" size="6" readonly/>
<script>
	$("#${id}").datepicker({dateFormat: 'dd/mm/yy', changeYear:true, yearRange: '-100:+0'});
</script>