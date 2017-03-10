<%@page import="com.country.model.Country"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<style>
body {
	background: lightblue
}

h1 {
	font-family: Verdana, Geneva, sans-serif;
	font-size: 1.1em;
	font-weight: normal;
	color: white;
	margin: 1em 1em 1em 1em;
}

a {
	color: Green;
	font-weight: normal;
	text-decoration: none;
}

a:hover {
	color: orange;
	font-weight: normal;
	text-decoration: none;
}

table.silver {
	margin: 0em 0em 1em 2em;
	background: WhiteSmoke;
	border-collapse: collapse;
}

table.silver th {
	color: DarkSlateGray;
	background: Gainsboro;
	text-align: left;
}

table.silver th, table.silver td {
	border: 1px Silver solid;
	padding: 0.2em;
}

errors {
	color: Redmarone;
	font-weight: bold;
}

</style>
</head>
<body>
	<center>
	<h1>Enter the following information</h1>
	</center>
	<%-- <% 
	Country c = (Country) request.getAttribute("country");
	if( c == null)
	{
		c = new Country();
	}
	%>
	
	<form action="saveCountry" method="post">
		<input type="hidden" name="id" value="<%=c.getId()%>">
		<input type="text" name="name" id="nameInput" required="required" value="<%=c.getName()%>"/> 
	</form>
	 --%>
	
	<form:form id="myform" method="Post" action="saveCountry"
		commandName="country">
		<table bgcolor="FloralWhite" cellpadding="5px" cellspacing="5px"
			align="center">
			
			<form:hidden path="id" id="myid"/>
			
			<tr align="center">
				<td colspan="1"><center>
						<spring:message code="application.name" />
					</center></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><form:input type="text" path="name" id="nameInput"
						required="required" /> <form:errors path="name" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Area</td>
				<td><form:input type="numeric" path="area" id="areaInput"
						required="required" /> <form:errors path="area" cssClass="error" /></td>
			</tr>

			<tr>
				<td>Population</td>
				<td><form:input type="numeric" path="population"
						id="populationInput" required="required" /> <form:errors
						path="area" cssClass="error" /></td>
			</tr>
			<tr>

				<td>currerncy</td>
				<td><form:input type="text" path="currerncy"
						id="currerncyInput" required="required" /> <form:errors
						path="currerncy" cssClass="error" /></td>
			</tr>
			<tr>
				<td>lastModified</td>
				<td><form:input type="text" path="lastModified"
						id="lastModifiedInput" required="required" /> <form:errors
						path="lastModified" cssClass="error" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" id="submit" /></td>
			</tr>
			<tr>
				<td><a href="listOfCountries.html"> &lt;&lt;<spring:message
							code="navigation.back" />
				</a></td>
			</tr>
		</table>
	</form:form>
</body>
</html>



