myApp.controller("profileController",function($scope, profileService){
	$scope.getProfile=function(){
		console.log("profile loading..");
		var httpobj=profileService.profile().then(function(data){
			console.log(data);
			
		})
	}
});
myApp.service('profileService',function($http){
	this.profile=function(){
		return $http({url:"http://localhost:8080/toDoApp_2017/getProfile"});
	}
});