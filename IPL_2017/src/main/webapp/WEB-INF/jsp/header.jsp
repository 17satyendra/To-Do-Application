<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style type="text/css">
.menu{
	list-style-type: none;
	width: 100px;
	background-color: green;
	text-align: center;
	line-height: 30px;
	border-radius: 22px;
}

.menu_a{
	text-decoration: none;
	color: white;
	display: block;
	width: 100px;
	
}

.menu_a:hover{
	background-color: white;
	color: green;
	border-radius: 22px;
}

.tab {
 width:80%;
 font-stretch: wider;
 font-family: fantasy;
 font: bold;
 background: transparent; 

}
input{
color: #696969;

}
</style>

<table class=tab align="right" cellpadding="15px" cellspacing="20px">
<tr>
<td><li class="menu"><a class="menu_a" href="index.jsp">Home</a></li></td>
<td><li class="menu"><a class="menu_a" href="about">About</a></li></td>
<td><li class="menu"><a class="menu_a" href="signin">Signin</a></li></td>
<td><li class="menu"><a class="menu_a" href="signup">SignUp</a></li></td>
</tr>
</table>