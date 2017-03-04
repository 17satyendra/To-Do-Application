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
<div>
<span ><img class="img" src="images/logo.jpeg" style="
    margin-top: -40px;
    width: 20%;
    height: 150px;
"alt="img not found"/></span>
<span >
<jsp:include page="afterloginheader.jsp"></jsp:include></span>
</div>
<center>
<a href="http://www.news18.com/cricketnext/news/ipl-2017-full-schedule-date-time-of-all-the-matches-1355365.html">
<h3>IPL-10 2017 TEAM LIST</h3></a>
	
		
		<div class="div1">
			<c:forEach var="team" items="${teamList}">
				<div class="div">
					<a href="<c:url value="teamDetails"/>?teamName=${team.name}"><img
						src="${team.logo}" width="250px" height="250px" /></a>
				</div>
			</c:forEach>
		</div>
	</center>


</body>
</html>