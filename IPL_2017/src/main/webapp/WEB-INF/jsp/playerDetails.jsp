<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1>Player Information</h1>
	</center>
	<table bgcolor="#ffddcc" bordercolor="black" cellpadding="10px"
		cellspacing="10px" align="center">
		
			<tr>
				<th>DisplayPicture:</th>
				<td><img alt="${player.name}" src="${player.displayPicture}"
					width="180px" height="180px"></td>
			</tr>
			<tr>
				<th>ID:</th>
				<td>${player.id}</td>
			</tr>
			<tr>
				<th>Name:</th>
				<td>${player.name}</td>
			</tr>
			<tr>
				<th>Role:</th>
				<td>${player.role}</td>
			</tr>
			<tr>
				<th>BattingStyle:</th>
				<td>${player.battingStyle}</td>
			</tr>
			<tr>
				<th>BowlingStyle:</th>
				<td>${player.bowlingstyle}</td>
			</tr>
			<tr>
				<th>Nationality:</th>
				<td>${player.nationality}</td>
			</tr>
			<tr>
				<th>DOB:</th>
				<td>${player.dob}</td>
			</tr>
			<tr>
				<th>TeamId:</th>
				<td>${player.teamId}</td>
			</tr>
			<tr>
				<th>NoOfViews:</th>
				<td>${player.views}</td>
			</tr>
			<tr>

				<td><a href="<c:url value="playerList"/>?teamId=${player.teamId}">
				click here to go back Player list</a></td>

			</tr>

	</table>
</body>
</html>