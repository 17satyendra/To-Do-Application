<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="images/static/css/main.css">

</head>
<body bgcolor="#d4efdf">
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
<div class="div"><h3><a href="http://www.news18.com/cricketnext/news/ipl-2017-full-schedule-date-time-of-all-the-matches-1355365.html">
IPL-10 2017 TEAM LIST</a></h3></div>
	
		
		<div class="div1">
			<c:forEach var="team" items="${teamList}">
				<div class="div">
					<a href="<c:url value="teamDetails"/>?teamId=${team.id}"><img
						src="${team.logo}" width="250px" height="250px" /></a>
				</div>
			</c:forEach>
		</div>
	</center>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>