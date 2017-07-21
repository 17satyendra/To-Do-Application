$(document).ready(function(){
    $('[data-toggle="tooltip"]').tooltip();
    $('.has-clear input[type="text"]').on('input propertychange', function() {
    	  var $this = $(this);
    	  var visible = Boolean($this.val());
    	  $this.siblings('.form-control-clear').toggleClass('hidden', !visible);
    	}).trigger('propertychange');

    	$('.form-control-clear').click(function() {
    	  $(this).siblings('input[type="text"]').val('')
    	    .trigger('propertychange').focus();
    	});
    	
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

/*function openNav() {
	document.getElementById("mySidenav").style.width = "225px";
	document.getElementById("main").style.marginLeft = "225px";
}

function closeNav() {
	document.getElementById("mySidenav").style.width = "0";
	document.getElementById("main").style.marginLeft = "0";
}*/
var doubleClick = true;
