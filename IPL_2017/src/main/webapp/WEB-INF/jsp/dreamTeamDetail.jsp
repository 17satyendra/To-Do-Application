<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>dreamTeamDetails</title>
</head>
<body>
	<center>
		<h1>${team.dreamTeamName} Team Information</h1>

	<table bordercolor="black" cellpadding="5px" bgcolor="WhiteSmoke "
		cellspacing="5px" align="center">

			<tr>
				<th>Id:</th>
				<td>${team.id}</td>
			</tr>
			<tr>
				<th>Name:</th>
				<td>${team.dreamTeamName}</td>
			</tr>
			
			<tr>
				<th>Owner</th>
				<td>${user.firstname} ${user.lastname}</td>
			</tr>
			
			<tr>
				<td><a
					href="dreamPlayerList?dreamId=${team.id}">Click
						here to view all players</a></td>
			</tr>
	</table>
	</center>
</body>
</html>