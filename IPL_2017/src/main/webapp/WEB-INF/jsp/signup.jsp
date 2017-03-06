<%@page import="com.bridgeit.ipl.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<spring:url value="images/static/js/main.js" var="mainJs" />
<script src="${mainJs}"></script>
<style type="text/css">
body{
    background-image: url(images/signinback.jpg);
    background-repeat: no-repeat;
    background-position: center;
    background-size: cover;
    width: 100%;
    height: 100%;
}
font{
color: white;
font-style: oblique;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>IPL-2017 SignUp page</title>
</head>
<body>
	<center>
		<h1><font>Enter the following information</font></h1></center>
	
	<form:form  method="Post" action="saveUser"
		commandName="user" onsubmit="return formValidation();">
		<table bgcolor="9e2005" cellpadding="5px" cellspacing="5px"
			align="center">

			<form:hidden path="id" id="myid" />

			<tr align="center">
				<td colspan="1"><center>
						<spring:message code="application.name" />
					</center></td>
			</tr>
			<tr>
				<td><font>UserName</font></td>
			</tr>
			<tr>
				<td><form:input type="text" path="firstname"
						id="firstNameInput" placeholder="First name" required />
					<form:errors path="firstname" cssClass="error" /></td>

				<td><form:input type="text" path="lastname" id="lastNameInput"
						placeholder="Last name" required/> <form:errors
						path="lastname" cssClass="error" /></td>
			</tr>

			<tr>
				<td><font>Email</font></td>
			</tr>
			<tr>
				<td><form:input type="text" path="email" id="emailInput"
						placeholder="Email Address" required /> <form:errors
						path="email" cssClass="error" /></td>
			</tr>

			<tr>
			<tr>
				<td><font>Password </font></td>
			</tr>
			<tr>
				<td><form:input type="password" path="password"
						placeholder="password" id="passwordInput" required="required" />
					<form:errors path="password" cssClass="error" /></td>
				<td><form:input type="password" path="confirmPassword"
						placeholder="Re-Enter Password" id="confirmPasswordInput"
						required="required" /> <form:errors path="confirmPassword"
						cssClass="error" /></td>
			</tr>

			<tr>
				<td><font>Gender</font></td>
			<tr>
			<tr>
				<td><input type="radio" name="gender" value="male" checked>
					<font>Male</font><input type="radio" name="gender" value="female">
					<font>Female</font><input type="radio" name="gender" value="other">
					<font>Other</font>
			</tr>
			<tr>
			<tr>
				<td><font>Mobile Number</font></td>
			</tr>
			<tr>
				<td><form:input type="numeric" path="mobile"
						placeholder="your mobile number" id="mobileInput"
						required /> <form:errors path="mobile"
						cssClass="error" /></td>
			</tr>
			<tr>
			<tr>
				<td><font>Address</font></td>
			</tr>
			<tr>
				<td><form:input type="text" path="city" placeholder="city"
						id="cityInput" required/> <form:errors path="city"
						cssClass="error" /></td>
				<td><form:input type="text" path="country"
						placeholder="country" id="countryInput" required/> <form:errors
						path="country" cssClass="error" />
											</td>
						
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" id="submit" /></td>
			</tr>
		</table>
	</form:form>
		<h4 align="right"><a href="signin.jsp">Already Registered??Click here to sign in!</a></h4>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>