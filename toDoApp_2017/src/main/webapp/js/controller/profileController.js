myApp.controller("profileController",function($scope, profileService){
	$scope.getProfile=function(){
		//console.log("profile loading..");
		var userDetails="";
		var httpobj=profileService.profile().then(function(data){
			
			var em=data.data.email;
			console.log(data);
			$scope.userDetails=data.data;
			
			
			
			window.localStorage['user'] = angular.toJson(data);
			//console.log(data);
			//console.log(window.localStorage['user']);
		});
	}
});
myApp.service('profileService',function($http){
	this.profile=function(){
		return $http({url:"/getProfile"});
	}
});