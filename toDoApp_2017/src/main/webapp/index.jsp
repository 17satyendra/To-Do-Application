<!DOCTYPE html>
<html>
<meta charset="utf-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <title>todo</title>
<head>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="bower_components/angular-ui-bootstrap/dist/ui-bootstrap-csp.css">
<link rel="stylesheet" href="bower_components/bootstrap/dist/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="bower_components/AngularJS-Toaster/toaster.min.css">
<link rel="stylesheet" href="bower_components/font-awesome/css/font-awesome.css">
<link rel="stylesheet" href="bower_components/angular-bootstrap-datetimepicker/src/css/datetimepicker.css">
<link rel="stylesheet" href="bower_components/gridly/stylesheets/jquery.gridly.css">

<link rel="stylesheet" type="text/css" href="css/main.css">
<link rel="stylesheet" type="text/css" href="css/displaycard.css">
<link rel="stylesheet" type="text/css" href="css/loading.css">
<link rel="stylesheet" type="text/css" href="css/slide.css">
<link rel="stylesheet" type="text/css" href="css/login.css">
<link rel="stylesheet" type="text/css" href="css/Registration.css">
<link rel="stylesheet" type="text/css" href="css/collaborator.css">
<link rel="stylesheet" type="text/css" href="css/archive.css">
<link rel="stylesheet" type="text/css" href="css/sideNavigation.css">

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
	<toaster-container toaster-options="{'time-out': 1000,'position-class': 'toast-bottom-full-width'}"></toaster-container>
</body>
<script src="bower_components/moment/moment.js" charset="utf-8"></script>
<script src="bower_components/angular/angular.min.js" charset="utf-8"></script>
<script src="bower_components/angular-ui-router/release/angular-ui-router.min.js"charset="utf-8"></script>
<script src="bower_components/angular-ui-bootstrap/dist/ui-bootstrap-tpls.js"></script>
<script src="bower_components/jquery/dist/jquery.min.js" charset="utf-8"></script>
<script src="bower_components/jquery/dist/jquery-ui.js" charset="utf-8"></script>
<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"charset="utf-8"></script>
<script src="bower_components/angular-animate/angular-animate.min.js" charset="utf-8"></script>
<script src="bower_components/angular-sanitize/angular-sanitize.min.js" charset="utf-8"></script>
<script src="bower_components/angular-spinner/dist/angular-spinner.min.js" charset="utf-8"></script>
<script src="bower_components/angular-bootstrap-datetimepicker/src/js/datetimepicker.js"></script>
<script src="bower_components/angular-bootstrap-datetimepicker/src/js/datetimepicker.templates.js"></script>
<script src="bower_components/ng-file-upload/ng-file-upload.min.js" type="text/javascript"></script>
<script src="bower_components/ng-file-upload-shim/ng-file-upload-shim.min.js"type="text/javascript"></script>
<script src="bower_components/gridly/javascripts/jquery.gridly.js"type="text/javascript"></script>
<script src="bower_components/AngularJS-Toaster/toaster.min.js"></script>
<script src="https://connect.facebook.net/enUS/all.js"></script>

<script src="js/app.js" charset="utf-8"></script>
<script src="js/controller/loginController.js" charset="utf-8"></script>
<script src="js/controller/signUpController.js" charset="utf-8"></script>
<script src="js/controller/homeController.js" charset="utf-8"></script>
<script src="js/controller/Note.js" charset="utf-8"></script>
<script src="js/controller/profileController.js" charset="utf-8"></script>
<script src="js/Directives/pinup.js" charset="utf-8"></script>
<script src="js/Directives/mycard.js" charset="utf-8"></script>
</html>
