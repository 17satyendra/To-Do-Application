function show(){
	document.getElementById('cointainer-note1').style.display = 'block';
	document.getElementById('cointainer-note2').style.display = 'block';
}

function ClickToEditCtrl($scope) {
	  $scope.title = "Welcome to this demo!";
	  $scope.editorEnabled = false;
	  
	  $scope.enableEditor = function() {
	    $scope.editorEnabled = true;
	    $scope.editableTitle = $scope.title;
	  };
	  
	  $scope.disableEditor = function() {
	    $scope.editorEnabled = false;
	  };
	  
	  $scope.save = function() {
	    $scope.title = $scope.editableTitle;
	    $scope.disableEditor();
	  };
	}

var app = angular.module('MyApp', [])
app.controller('MyController', function ($scope) {
    //This will hide the DIV by default.
    $scope.IsVisible = false;
    $scope.ShowHide = function () {
        //If DIV is visible it will be hidden and vice versa.
        $scope.IsVisible = $scope.IsVisible ? false : true;
    }
});

