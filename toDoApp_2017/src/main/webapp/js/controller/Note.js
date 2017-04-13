

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
app.controller('MyController', function($scope) {
	// This will hide the DIV by default.
	$scope.IsVisible = false;
	$scope.ShowHide = function() {
		// If DIV is visible it will be hidden and vice versa.
		$scope.IsVisible = $scope.IsVisible ? false : true;
	}
});

function openNav() {
	document.getElementById("mySidenav").style.width = "225px";
	document.getElementById("main").style.marginLeft = "225px";
}

function closeNav() {
	document.getElementById("mySidenav").style.width = "0";
	document.getElementById("main").style.marginLeft = "0";
}
var doubleClick = true;
$(document).on("click", function(e) {
	console.log(doubleClick)
	if (doubleClick) {
		if ($(e.target).is("#period_select_range_btn")) {
			$("#selectPeriodRangePanel").show();
			$("#selectPeriodRangePanel2").show();
			doubleClick = !doubleClick;
			console.log(doubleClick);

		} else {
			$("#selectPeriodRangePanel").hide();
			$("#selectPeriodRangePanel2").hide();
			doubleClick = !doubleClick;
			console.log(doubleClick)
		}
	} else {
		if ($(e.target).is("#period_select_range_btn")) {
			doubleClick = !doubleClick;
			console.log(doubleClick)
		} else {
			doubleClick = !doubleClick;
			console.log(doubleClick)

		}
	}
});

/*for search background color*/
$(document).ready(function(){
    $(".searchtab").click(function(e){
        $(".searchback").removeClass("searchback");
        $(this).addClass("searchback");
        e.stopPropagation();
    });   
    $(document).click(function(){ 
        $(".searchback").removeClass("searchback");
    });
 });
/*ends*/
/*$(document).ready(function(){
    $("#hide").mouseover(function(){
        $("#b1").show();
    });
    $("#hide").mouseout(function(){
        $("#b1").hide();
    });
});*/
