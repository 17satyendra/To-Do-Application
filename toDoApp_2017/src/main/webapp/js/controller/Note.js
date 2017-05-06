$(document).ready(function(){
    $('[data-toggle="tooltip"]').tooltip();
    console.log($('#datetimepicker4'));
	$('#datetimepicker4').datetimepicker();
});


/*$(function () {
    $('#datetimepicker8').datetimepicker({
        icons: {
            time: "fa fa-clock-o",
            date: "fa fa-calendar",
            up: "fa fa-arrow-up",
            down: "fa fa-arrow-down"
        }
    });
});*/
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
	//console.log(doubleClick)
	if (doubleClick) {
		if ($(e.target).is("#period_select_range_btn")) {
			$("#selectPeriodRangePanel").show();
			$("#selectPeriodRangePanel2").show();
			$("#selectPeriodRangePanel3").show();
			doubleClick = !doubleClick;
			//console.log(doubleClick);

		} else {
			$("#selectPeriodRangePanel").hide();
			$("#selectPeriodRangePanel2").hide();
			$("#selectPeriodRangePanel3").hide();
			//doubleClick = !doubleClick;
			//console.log(doubleClick)
		}
	} else {
		if ($(e.target).is("#period_select_range_btn")) {
			doubleClick = !doubleClick;
		//	console.log(doubleClick)
		} else {
			doubleClick = !doubleClick;
			//console.log(doubleClick)

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
    $("#himakeNote = ->
  height = parseInt 100+Math.random()*500, 10
  '<div class="note"><div class="note-inner" style="height: '+height+'px"></div></div>'
  
$ ->
  $notes = $ ".notes"
  for x in [0..10]
    $note = $ makeNote()
    $notes.append $note
    
  $('.notes').isotope
    itemSelector: '.note',
    layoutMode: 'masonry'de").mouseover(function(){
       makeNote = ->
  height = parseInt 100+Math.random()*500, 10
  '<div class="note"><div class="note-inner" style="height: '+height+'px"></div></div>'
  
$ ->
  $notes = $ ".notes"
  for x in [0..10]
    $note = $ makeNote()
    $notes.append $note
    
  $('.notes').isotope
    itemSelector: '.note',
    layoutMode: 'masonry' $("#b1").show();
    });
    $("#hide").mouseout(function(){
        $("#b1").hide();
    });
});*/
/*Script for adjustable heiht div*/
/*var makeNote;

makeNote = function() {
  var height;
  height = parseInt(100 + Math.random() * 500, 10);
  return '<div class="note"><div class="note-inner" style="height: ' + height + 'px"></div></div>';
};

$(function() {
  var $note, $notes, i, x;
  $notes = $(".notes");
  for (x = i = 0; i <= 10; x = ++i) {
    $note = $(makeNote());
    $notes.append($note);
  }
  return $('.notes').isotope({
    itemSelector: '.note',
    layoutMode: 'masonry'
  });
});*/

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
           height: ui.item.outerHeight() + 15
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

   