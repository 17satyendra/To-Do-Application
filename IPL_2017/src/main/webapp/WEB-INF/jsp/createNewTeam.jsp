<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<spring:url value="/images/static/js/jquery-1.12.4.min.js" var="orbitJs" />
<script src="${orbitJs}"></script>
<spring:url value="images/static/js/main.js" var="mainJs" />
<script src="${mainJs}"></script>
<script type="text/javascript">
	$(function() {
		function moveItems(origin, dest) {
			$(origin).find(':selected').appendTo(dest);
		}

		function moveAllItems(origin, dest) {
			$(origin).children().appendTo(dest);
		}

		$('#left').click(function() {
			moveItems('#to', '#from');
		});

		$('#right').on('click', function() {
			moveItems('#from', '#to');
		});

		$('#leftall').on('click', function() {
			moveAllItems('#to', '#from');
		});

		$('#rightall').on('click', function() {
			moveAllItems('#from', '#to');
		});
	});

	$(document).ready(function() {
		$("option").mouseenter(function() {
			$("option").css("background-color", "#FFB533");
		});

	});
</script>
<style type="text/css">
#to,#from {
	width: 150px;
}
select{
height: 300px;
}

.div1 {
	/* display: inline-block; */
	float: left;
	margin-left: 5%;
}

.div2 {
	/* display: inline-block; */
	float: left;
	margin-left: 3%;
	width: 120px;
	margin-top: 20%;
}

.div3 {
	/* display: inline-block; */
	float: left;
	margin-left: 3%;

	/* margin-top: 5%; */
}

input {
	width: 100px;
	margin-top: 5px;
	
}
.input2{
width: 150px;
}
.div{
padding-left: 216px;
}
</style>
</head>

<body bgcolor="navyblue">
	<div class="div">
	<h2>Dream Team</h2></div>
	<div class="div1">
		<h4>Player List</h4>
		<select id="from" multiple="multiple" size="35px">
			<c:forEach var="player" items="${playerList}">
				<option>${player.name}</option>
			</c:forEach>
		</select>

	</div>
	<div class="div2">
		<input type="button" id="right" value="select" /><br> <input
			type="button" id="left" value="clear" />
			


	</div>
	<form:form name="myteam" action="saveDreamTeam" method="Post">
		<div class="div3">
			<h4>Selected Player</h4>

			
			<div>
				<select id="to" name="Player" multiple="multiple" size="35px">

				</select>
			</div>

		</div>
		<div class="div2">
		<div>
				<input class="input2" id="dreamTeamNameInput" name="dreamTeamName"
					onkeyup="validate(this)" minlength="3" placeholder="Team Name"
					type="text" required="required" value="" />
			</div>
		<input class="input2" type="submit" value="Confirm"></div>
	</form:form>
</body>
</html>