$(document).ready(function(){
    $('[data-toggle="tooltip"]').tooltip();
});

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

/*
$(document).on("click", function(e) {
	console.log(doubleClick)
	if ( doubleClick ) {
		if ($(e.target).is("#period_select_range_btn")) {
			//doubleClick = false;	
			$("#selectPeriodRangePanel").show();
			$("#selectPeriodRangePanel2").show();
			$("#selectPeriodRangePanel3").show();
		}
		else {
			$("#selectPeriodRangePanel").hide();
			$("#selectPeriodRangePanel2").hide();
			$("#selectPeriodRangePanel3").hide();
			//doubleClick = !doubleClick;
			//console.log(doubleClick)
		}
	} else {
		doubleClick = !doubleClick;
	}
});
*/
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
    
    $("#OpenToDoSecton").on("click", function() {
    	$('#OpenToDoSecton').hide();
    	$("#ToggleToDoSection").show();
    });
    
    $(document).on("click", function(e) {
    	var l = $(e.target).closest('#ToggleToDoSection').length
    	if( l == 0 )
    	{
    		var l2 = $(e.target).closest('#OpenToDoSecton').length
    		if( l2 == 1)
    		{
    			$('#OpenToDoSecton').hide();
    	    	$("#ToggleToDoSection").show();
    		}
    		else
    		{
    			$("#ToggleToDoSection").hide();
    			$('#OpenToDoSecton').show();
        	}
        	
    	}
    });    
 });

/*ends*/
$(".slides").sortable({
    placeholder: 'slide-placeholder',
   axis: "y",
   revert: 150,
   
   start: function(e, ui){
       
       placeholderHeight = ui.item.outerHeight();
       ui.placeholder.height(placeholderHeight + 15);
       $('<div class="slide-placeholder-animator" data-height="' + placeholderHeight + '"></div>').insertAfter(ui.placeholder);
   
   },
   change: function(event, ui) {
       
       ui.placeholder.stop().height(0).animate({
           height: ui.item.outerHeigClickht() + 15
       }, 300);
       
       placeholderAnimatorHeight = parseInt($(".slide-placeholder-animator").attr("data-height"));
       
       $(".slide-placeholder-animator").stop().height(placeholderAnimatorHeight + 15).animate({
           height: 0
       }, 300, function() {
           $(this).remove();
           placeholderHeight = ui.item.outerHeight();
           $('<div class="slide-placeholder-animator" data-height="' + placeholderHeight + '"></div>').insertAfter(ui.placeholder);
       });
       
   },
   stop: function(e, ui) {
       
       $(".slide-placeholder-animator").remove();
       
   },
});
