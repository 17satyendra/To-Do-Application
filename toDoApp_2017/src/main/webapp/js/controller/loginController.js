//var myApp = angular.module('todoApp')

myApp.controller("loginController",function ($scope,  $state, loginService,profileService ) {	
	
	this.login = function () {
		var user = {};
		user.email = $scope.email;
		user.password = $scope.password;
		var httpObje = loginService.login(user);
		
		httpObje.then(function (data) {
			
			if( data.data.status == 1 ){
				var httpobj=profileService.profile().then(function(data1){
					window.localStorage['user'] = angular.toJson(data1);
					$state.go("home");
				});
				
			}
			else
			{
				$scope.emailError = data.data.emailError;
				
				var message = data.data.message;
				$scope.errorMessage = message;
			}
		})
		.catch( function(error){
			console.log(error);
		});
	}	
});


myApp.service("loginService",function ($http) {
	this.login = function(user){ 
		return $http({
			url:"http://localhost:8080/toDoApp_2017/login",
			method:"post",
			data:user
		});
	}
});
