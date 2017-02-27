<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<div class="head" width="100%">
<span ><img class="img" src="images/IPL-2017_Logo.jpeg" style="
    margin-top: -40px;
    width: 20%;
    height: 150px;
"alt="img not found"/></span>
<span ><jsp:include page="WEB-INF/jsp/header.jsp"></jsp:include></span>
</div>
<h4>Enter the following information</h4>
	<form:form id="myform" method="post" action="saveData" commandName="user">
		<table  bgcolor="FloralWhite" cellpadding="5px" cellspacing="5px" align="left">
			<tr>
				<td>User Name</td>
				<td><form:input type="text" path="name" id="userInput" required="required" /> <form:errors
						path="name" cssClass="error" /></td>
			</tr>
			<tr>
				<td>email</td>
				<td><form:input type="text" path="email" id="emailInput" required="required" /> <form:errors
						path="email" cssClass="error" /></td>
			</tr>

			<tr>
				<td>password</td>
				<td><form:input type="password" path="password"
						id="passwordInput" required="required" /> <form:errors path="password"
						cssClass="error" /></td>
			</tr>
			<tr>
				<td>Mobile Number</td>
				<td><form:input type="text" path="mobileNumber"
						id="mobileNumberInput" required="required"/> <form:errors path="mobileNumber"
						cssClass="error" /></td>
			</tr>
			<tr>
				<td>Country</td>
				<td><form:input type="text" path="country" id="countryInput" required="required"/>
					<form:errors path="country" cssClass="error" /></td>
			</tr>
			<tr>
				<td>City</td>
				<td><form:input type="text" path="city" id="cityInput" required="required" /> 
				<form:errors
						path="city" cssClass="error" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit"
					id="submit" /></td>
			</tr>
		</table>
	</form:form>
	<a href="signin.jsp">If Account Already exist!!!</a>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>