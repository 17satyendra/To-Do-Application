<%@page import="org.apache.jasper.tagplugins.jstl.core.If"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
ul {
	padding: 0;
	list-style: none;
	background: #f2f2f2;
	display: inline-block;
	width: 80%;
	text-align: right;
	margin-top: 73px;
}

ul li {
	display: inline-block;
	position: relative;
	line-height: 21px;
	text-align: left;
}

ul li a {
	display: block;
	padding: 8px 25px;
	color: #333;
	text-decoration: none;
}

ul li a:hover {
	color: #fff;
	background: #939393;
}

ul li ul.dropdown-menu {
	min-width: 100%; /* Set width of the dropdown */
	background: #f2f2f2;
	display: none;
	margin-top: 0px;
	position: absolute;
	z-index: 999;
	left: 0;
}

ul li ul.dropdown-menu li {
	display: block;
}

.dropWiddth {
	width: 200px;
	margin-left: -88px;
}

.more {
	width: auto;
}
</style>
<script type="text/javascript"
	src="http://code.jquery.com/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		// Show hide popover
		$(".dropdown").hover(function() {
			$(this).find(".dropdown-menu").slideToggle("fast");
		});
	});
	$(document).on("click", function(event) {
		var $trigger = $(".dropdown");
		if ($trigger !== event.target && !$trigger.has(event.target).length) {
			$(".dropdown-menu").slideUp("fast");
		}
	});
	
</script>

</head>
<body>


	<ul>
		<li><a href="index.jsp">Home</a></li>
		<li><a href="upload">AddNewTeam</a></li>
		<li><a href="newAddPlayer">AddNewPlayer</a></li>
		<li><a href="teamList">Teams</a></li>

		<li class="dropdown"><a href="#">More &#9662;</a>
			<ul class="dropdown-menu more">
				<li><a href="userDetails">Profile</a></li>
				<% Boolean isPresent = (Boolean)session.getAttribute("isCreated");%>
				<li>${isPresent}</li>

				<c:choose>
					<c:when test="${isPresent}">
						<li style="display: none;"><a href="createTeam">CreateDreamTeam</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="createTeam">CreateDreamTeam</a></li>
					</c:otherwise>
				</c:choose>


				<li><a href="viewDreamTeam">ViewDreamTeam</a></li>
				<li><a href="signout">SignOut</a></li>
			</ul></li>
		<li class="dropdown"><a href="#">Contact &#9662;</a>

			<ul class="dropWiddth dropdown-menu">
				<li><div>
						BCCI-IPL 4th Floor, <br> Cricket Centre WankhedeStadium ‘D’
						Road,<br> Churchgate Mumbai- 400020 India T +91-22-22800300<br>
						T +91 22 61580300<br> F +91 22 22800354
					</div></li>
			</ul></li>

	</ul>
</body>
</html>