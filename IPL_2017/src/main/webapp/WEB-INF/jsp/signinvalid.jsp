<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
</head>
<body>
<h4>Enter the following Information</h4>
	<form method="post" action="signin">
<table  border="2" bordercolor="black" cellpadding="10px" cellspacing="10px" align="left">
			<tr>
				<td>Email</td>
				<td><input type="text" name="email" required/>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" required />
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="SUBMIT" /></td>
			</tr>
		</table>
	</form>
</body>
</html>
