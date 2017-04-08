var myApp = angular.module('todoApp', ['ui.router','ui.bootstrap','ngSanitize','ngAnimate'])
.config(function ($stateProvider, $urlRouterProvider) {
  $stateProvider
  .state("profile",{
	  url:"/profile",
	  templateUrl:"template/profile.html"
  })
  .state("home",{
    url:"/home",
    templateUrl:"template/home.html"
  })
  .state("about",{
    url:"/about",
    templateUrl:"template/about.html"
  })
  .state("login",{
    url:"/login",
    templateUrl:"template/login.html",
    controller:"loginController"
  })
  .state("signUp",{
    url:"/create",
    templateUrl:"template/signUp.html",
    controller:"signupController"
  });
  $urlRouterProvider.otherwise('/login');

});


