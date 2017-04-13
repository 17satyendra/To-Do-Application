<!DOCTYPE html>
<html>
<head>
<script src="bower_components/angular/angular.min.js" charset="utf-8"></script>
<script src="bower_components/angular-ui-router/release/angular-ui-router.min.js"charset="utf-8"></script>
<script src="bower_components/jquery/dist/jquery.min.js" charset="utf-8"></script>
<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"charset="utf-8"></script>
<!-- <script src="bower_components/angular-ui-bootstrap/dist/ui-bootstrap.js"></script>-->
<script src="bower_components/angular-ui-bootstrap/dist/ui-bootstrap-tpls.js"></script>
<script src="bower_components/angular-animate/angular-animate.min.js"></script>
<script src="bower_components/angular-sanitize/angular-sanitize.min.js"></script>

 <link rel="stylesheet" href="bower_components/angular-ui-bootstrap/dist/ui-bootstrap-csp.css">
<link rel="stylesheet"
	href="bower_components/bootstrap/dist/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<link rel="stylesheet" href="bower_components/font-awesome/css/font-awesome.css">
<style>
/* @media (min-width: 1200px) {
  .container {
    width: 1000px;
  }
} */
</style>
</head>
<body class="body" data-ng-app="todoApp" style="background: #E8E8E8;">
	<ui-view></ui-view>
</body>
<script src="js/app.js" charset="utf-8"></script>
<script src="js/controller/loginController.js" charset="utf-8"></script>
<script src="js/controller/signUpController.js" charset="utf-8"></script>
<script src="js/controller/homeController.js" charset="utf-8"></script>
<script src="js/controller/Note.js" charset="utf-8"></script>
<script src="js/controller/profileController.js" charset="utf-8"></script>


</html>
