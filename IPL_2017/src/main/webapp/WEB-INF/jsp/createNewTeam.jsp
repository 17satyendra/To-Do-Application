<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.div2 {
	display: inline-block;
	margin-left: 10%;
}

.div1 {
	display: inline-block;
	margin-left: 5%;
}
</style>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="div1">
		<h3>All Player List</h3>
		<select multiple="multiple" size="35px">
			<c:forEach var="player" items="${playerList}">
				<option>${player.name}</option>
			</c:forEach>
		</select>
	</div>
	<div class="div2">

		<form action="create" method="post">
		<h3>Selected Player</h3>
			<select size="35px">
				<option></option>
			</select>


		</form>



	</div>
</body>
</html>