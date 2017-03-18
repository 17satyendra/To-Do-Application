<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
<span ><img class="img" src="images/logo.jpeg" style="
    margin-top: -40px;
    width: 20%;
    height: 150px;
    float: left;
"alt="img not found"/>
<jsp:include page="afterloginheader.jsp"></jsp:include></span>
</div>
<center>
<h1> User Profile Information</h1>

	<table bordercolor="black" cellpadding="5px" bgcolor="WhiteSmoke "
		cellspacing="5px" align="center">

			<tr>
				<th>Id:</th>
				<td>${user.id}</td>
			</tr>
			<tr>
				<th>Name:</th>
				<td>${user.firstname} ${user.lastname}</td>
			</tr>
			<tr>
				<th>Email:</th>
				<td>${user.email}</td>
			</tr>
			<tr>
				<th>Contact:</th>
				<td>${user.mobile}</td>
			</tr>
			<tr>
				<th>Address</th>
				<td>${user.city}</td>
			</tr>
			<tr>
				<th>Country:</th>
				<td>${user.country}</td>
			</tr>
			
			<tr>
				<td align="center"><a
					href="teamList"> back </a></td>
				</tr>
			</table>
</center>
</body>
</html>