var myApp = angular.module('todoApp')
.controller("loginController",function ($scope,$http,$state) {
$scope.login = function () {
$http({
  url:"http://localhost:8080/toDoApp_2017/login",
  method:"post",
  data:$scope.user
}).then(function (data) {
$state.go("home");
})
}
});
