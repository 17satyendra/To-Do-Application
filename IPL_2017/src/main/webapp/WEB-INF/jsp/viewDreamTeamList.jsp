<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>dream Team List</title>
<link rel="stylesheet" type="text/css" href="images/static/css/main.css">
</head>
<body bgcolor="#d4efdf">
	<center>
		<div>
			<span><img class="img" src="images/logo.jpeg"
				style="margin-top: -40px; width: 20%; height: 150px; float: left;"
				alt="img not found" /> <jsp:include page="afterloginheader.jsp"></jsp:include></span>
		</div>
		<div class="div">
			<h3>IPL-10 2017 DREAM TEAM LIST</h3>
		</div>
		<div class="div1">
			<c:forEach var="dream" items="${dreamList}">
				<div class="divDream">
					<a class="aDream" href="<c:url value="dreamTeamDetails"/>?dreamteamId=${dream.id}">${dream.dreamTeamName}</a>
				</div>
			</c:forEach>
		</div>
	</center>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>