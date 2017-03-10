<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title><spring:message code="country.plural" /></title>
<style type="text/css">
body{
background:orange
}
</style>
</head>
<body>
<center>
	<h1>
		<spring:message code="application.name" />
	</h1>

	<table>
		<tr>
			<td align="right" valign="bottom">
				<button onclick="window.location='createCountry.html'">Create</button>
			</td>
		</tr>
		<tr>
			<td>
				<table class="silver" width="180">
					<tr>
						<th></th>
						<th><spring:message code="country.plural" /></th>
					</tr>
					<c:forEach items="${countries}" var="country">

						<tr>
							<td width="20">
								<img src="images/india.jpeg" style="border-style: ;" width="50border-bottom-color: x" height="40px" />
							</td>
							<td><a href="countryDetails?id=${country.id}">
									${country.name} </a></td>
						</tr>
					</c:forEach>
				</table>
			</td>
		</tr>
		<tr>
				<td><a href="index.jsp"> &lt;&lt;<spring:message
							code="navigation.back" />
				</a></td>
			</tr>
	</table>
	</center>
</body>
</html>