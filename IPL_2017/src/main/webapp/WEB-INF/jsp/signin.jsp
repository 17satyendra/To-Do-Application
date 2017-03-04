<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<style type="text/css">
h3{
padding-right:100px;
}
h4{
padding-right:100px;
padding-top:15px; 
}
table
{
margin-top: 20%
}
body{
    background-image: url(images/signinback.jpg);
    background-repeat: no-repeat;
    background-position: center;
    background-size: cover;
    width: 100%;
    height: 100%;
}
</style>
</head>
<body>
<%-- <h3>${Message}</h3> --%>
	<form method="post" action="signin">
<table  bgcolor="FloralWhite" cellpadding="5px" cellspacing="5px" align="center">
			<tr>
				<td>Email</td>
				<td><input type="text" name="email" placeholder="Enter Your Email"   required/>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" placeholder="Enter Your Password"  required />
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Signin" /></td>
			</tr>
		</table>
       </form>
	<a href="signup"><h4 align="right">New user??Click here to sign up!</h4></a>
</body>
</html>
