<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.div {
	display: inline-block;
	height: 50%;
	padding: 1%;
}

.div1 {
	width: 72%;
	height: 100%;
	padding: 2%;
	background-color: #333300;
	text-align: center;
}
</style>
</head>
<body marginheight="10%">
	<center>
		<h2>IPL-10 2017 TEAMS</h2>
		<div class="div1">
			<c:forEach var="team" items="${teamInfo}">
				<div class="div">
					<a href="<c:url value="teamDetails"/>?teamName=${team.name}"><img
						src="${team.logo}" width="280px" height="280px" /></a>
				</div>
			</c:forEach>
		</div>
	</center>


</body>
</html>