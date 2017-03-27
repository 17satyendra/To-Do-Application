<!DOCTYPE html>
<html>
  <head>
    <script src="bower_components/angular/angular.min.js" charset="utf-8"></script>
    <script src="bower_components/angular-ui-router/release/angular-ui-router.min.js" charset="utf-8"></script>
    <script src="bower_components/jquery/dist/jquery.min.js" charset="utf-8"></script>
    <script src="bower_components/bootstrap/dist/js/bootstrap.min.js" charset="utf-8"></script>
    <link rel="stylesheet" href="bower_components/bootstrap/dist/css/bootstrap.min.css">
  </head>
<body data-ng-app="todoApp">
<div class="container">
	<ui-view></ui-view>
</div>
</body>
<script src="js/app.js" charset="utf-8"></script>
<script src="js/controller/loginController.js" charset="utf-8"></script>
<script src="js/controller/signUpController.js" charset="utf-8"></script>

</html>