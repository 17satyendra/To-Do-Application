<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script> 
$(document).ready(function(){
    $("#flip").mouseenter(function(){
        $("#panel").slideToggle("slow");
    });
});

</script>
<style type="text/css">
.img {
	margin-top: 60px;
	position: relative;
	z-index: 9;
	opacity: 0.5;
}

#panel, #flip {
	padding: 5px;
	position:static;
	text-align: center;
	background-color: highlight;
	border-bottom:1px solid black;
	width: 500px;
}

#panel {
	position:absolute;
	display: none;
	width: 500px;
	float: left;
	z-index: 10;
}
</style>
</head>
<div class="head" width="100%">
	<span><img class="img" src="images/logo.jpeg"
		style="margin-top: -40px; width: 20%; height: 150px;"
		alt="img not found" /></span> <span><jsp:include
			page="WEB-INF/jsp/header.jsp"></jsp:include></span>
</div>
<body background="images/dubai-cricket-stadium-2.jpg">


	<div id="flip">Welcome to IPL-10 2017</div>
	<div id="panel"><p align="left">The 2017 season of the Indian Premier League,
		also known as IPL 10, will be the tenth season of the IPL, a
		professional Twenty20 cricket league established by the Board of
		Control for Cricket in India in 2007</p>
		<p></p>
		<p align="left">Dates: 5 Apr 2017 – 21 May 2017</p>
		<p></p>
		<p align="left">Location: India</p>
			<p></p>
		<p align="left"><b>Administrator: Board of Control for Cricket in India (BCCI)</b></p>	
		</div>



	<img class="img" src="images/ipl_cover2017.jpeg" width="800"
		height="400" align="right" alt="img not found" />

	<jsp:include page="WEB-INF/jsp/footer.jsp"></jsp:include>
</body>
</html>
