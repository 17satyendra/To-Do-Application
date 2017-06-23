var myApp = angular.module('todoApp')
    .controller('signupController', function($scope, $http, $state) {
        $scope.signUp = function() {
            console.log($scope.user);
            $http({
                url: "http://localhost:8080/toDoApp_2017/create",
                method: "post",
                data: $scope.user
            }).then(function(data) {
                console.log(data);
                $state.go("login");
            }).catch(function(error) {
                console.error(error);
            })
        }
    });
