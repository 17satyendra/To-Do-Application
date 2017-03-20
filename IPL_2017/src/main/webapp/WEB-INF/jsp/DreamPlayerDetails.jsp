<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
tr {
	float: left;
	padding-left: 95px;
}
h1{
text-align: center;
font-family: serif;
color: #696969
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="head" width="100%">
<span ><img class="img" src="images/logo.jpeg" style="
    margin-top: -40px;
    width: 18%;
    height: 150px;
"alt="img not found"/></span>
<span ><jsp:include page="afterloginheader.jsp"></jsp:include></span></div>
	
		<center><h2>IPL 2017 ${teamName} Team Player List</h2></center>
	
	<table bordercolor="black" cellpadding="10px" cellspacing="10px"
		align="left">
		<c:forEach var="player" items="${dreamPlayerList}">
			<tr>
				<td><a
					href="<c:url value="playerDetails"/>?playerId=${player.id}"><img
						src="${player.displayPicture}" width="250px" height="200px" /></a></td>

			</tr>
		</c:forEach>
	</table>
</body>
</html>