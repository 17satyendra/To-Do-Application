myApp.controller('homeController', function($scope,$uibModal, $state, taskService,$timeout, toaster){
	$scope.result = []; 
	var cont = this;
	
	
	$scope.facebookshare=function(todo){
		FB.init({
			appId : '1639081702785828',
			status: true,
			xfbml : true
		});
		 FB.ui({
	           method: 'share_open_graph',
	           action_type: 'og.shares',
	           action_properties: JSON.stringify({
	               object : {
	                  // your url to share
	                  'og:title': todo.title,
	                  'og:description': todo.description,
	                  /*'og:image': 'http://example.com/link/to/your/image.jpg'*/
	               }
	           })
	           },
	           // callback
	           function(response) {
	           if (response && !response.error_message) {
	               // then get post content
	               alert('successfully posted. Status id : '+response.post_id);
	           } else {
	               alert('Something went error.');
	           }
	       });
	       
	};
	
	
	$scope.changeColor=function(color, e, index, id){
		var obj = null;
		for(var i=0; i< $scope.result.length;i++){
			if($scope.result[i].id==id)
			{
			obj=$scope.result[i];
			}
		}
		obj.cardColor=color;
		taskService.updateToDo(id, obj);
		
		$(e.target).closest( ".card" ).css( "background-color", color);
	};
	
	
	
	$scope.getNote=function(){
		$state.reload();
	};
	$scope.remindfilter=function(){
		var date = new Date();
		date.setHours(0,0,0,0);
		$scope.result = $scope.result.filter(function(data){
			return (data.reminder>date.getTime());
		});
// console.log("inside reminder filter",$scope.result);
	};
	
	
		  
	var accessData = window.localStorage['user'];
	var userjson=JSON.parse(accessData);
	$scope.userData=userjson.data;
	// console.log(userjson);
	// console.log(userjson.data.email);
	
	$("#menu").hover(function(){// selector
	    $('.flyout').removeClass('hidden');
	},function(){
	    $('.flyout').addClass('hidden');
	});
	$("#menu").click(function(){
		 $('.flyout').addClass('hidden');
	});
	
	$scope.todoDisplay= false;
	// Http call Then server kal ka data
	
	$scope.isList = false;
	// read from cookie
	
	var cView = readCookie('view');
	// console.log('view',cView)
	if( 'true' == cView )
	{
		// console.log('if');
		$scope.isList = true;
	}
	else
	{	// console.log('else');
		$scope.isList = false;
	}
	// console.log('is list ', $scope.isList);
	
	this.changeView = function(){
		// store in cookie
		// isList = !isList;
		// console.log('change view', $scope.isList);
		writeCookie('view', $scope.isList);
		writeCookie('sideMenu','jhhh');
	}
	
	 function writeCookie (cname, cvalue)
	 {
	        var d = new Date();
	        d.setTime(d.getTime() + (30*24*60*60*1000));
	        var expires = "expires="+d.toUTCString();
	        document.cookie = cname + "=" + cvalue + "; " + expires;
	 }
	 function readCookie (name)
	 {
	        if (document.cookie.indexOf(name) > -1) 
	        {
	            return document.cookie.split(name)[1].split("; ")[0].substr(1);
	        } else {
	            return "";
	        }
	 } 
	
	$(".slides").sortable({
	    placeholder: 'slide-placeholder',
	   axis: "z",
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

	$scope.hoverIn = function(){
        this.hoverEdit = true;
    };

    $scope.hoverOut = function(){
        this.hoverEdit = false;
    };
	this.refresh=function(){
		$state.reload();
	};
	 
	

	$scope.load_modal_sms = function (data, index) {
		console.log(data);
	       var modal = $uibModal.open({
	         templateUrl: "template/popup.html",
	         ariaLabelledBy: 'modal-title-bottom',
	         ariaDescribedBy: 'modal-body-bottom',
	         size: 'sm',
	         controller:function($uibModalInstance,$scope){
	        	 this.title=data.title;
	        	 this.id = data.id;
	        	 this.reminder=data.reminder;
	        	 this.cardColor=data.cardColor;
	        	 this.index=index;
	        	 var $ctrl = this;
	        	 this.description = data.description;
	      	     
	        	 this.del = function(id, index){
	        		 
	        		 cont.deleteTask(id, index);
	        		 $uibModalInstance.dismiss("delete");
	        	 };
	        	 $scope.changeColor=function(color){
	        		 $ctrl.cardColor= color;
	        	 }
	        	 this.copytodo=function(todo){
	        		 console.log(todo);
	        		 $scope.copy(todo);
	        	 }
	        	 
	        	 this.ok = function () {
	        		 $uibModalInstance.close({title:$ctrl.title,description:$ctrl.description,id:$ctrl.id,reminder:$ctrl.reminder, cardColor:$ctrl.cardColor});
	        	 };

	        	 this.cancel = function () {
	        		    $uibModalInstance.dismiss('cancel');
	        	 };
	        	  
	         },
	         controllerAs:"$ctrl"
	          // scope: data
	         });
	       
	        
	         modal.result.catch(function(error){
	        	console.log("error::",error);   	
	         }).then(function(data){
	        	 console.log(data);
//	        	$state.reload();
	        	if(data) {
	        		
	        		console.log(data);
	        		$scope.result.splice(index, 1, data);
	        		console.log(data)
	        		
	        		cont.updateTask(index, data.id,data.reminder);
	        	}
	        })
	        
	 };

	 this.signout=function(){
		console.log("signout");
		var httpobj=taskService.signoutUser().then(function(data){
			if(data.data.status==1){
				$state.go("login");
				toaster.success('User LogOut successfully');
			}
		})
	 };
	
	this.deleteTask=function(id, index){
		var httpObj=taskService.deleteTodo(id).then(function(data){
			if(data.data.status==1){
				if(index>-1){
					$scope.result.splice(index, 1);
					toaster.success('ToDo Deleted successfully');
				}
			}
		})
	};
	
	this.updateEnable=function(index){
		$scope.result=$scope.result.map(function(ret){
			ret.update=false
			return ret;
		}); // Reset To all update
		
		$scope.result[index].update=true; // set only one field
	};
	var cont = this;
	this.updateTask=function(index , id, date){
		
		$scope.result[index].update=true;
		$scope.todoDisplay= false;
		var obj = $scope.result[index];
		 obj.reminder=date;
		// console.log(obj);
		
		var httpobj = taskService.updateToDo(id, obj).then(function(data){
			// console.log(data);
			if(data.data.status==1){
				// console.log(data.data.message);
				toaster.success('ToDo Updated successfully');
				$state.reload();
			}
		});
	}
	
	this.deleteReminder=function(id, index){
		
		var object = $scope.result[index];
		object.reminder=null;
		var httpobj =taskService.updateToDo(id,object).then(function (data) {
			
			if(data.data.status==1){
				
				//$state.reload();
				toaster.success('Reminder Deleted successfully');
			}
		});
		}
		this.doReminder=function(id,index,day){
		// console.log(id,index,day,time);
		var obj = $scope.result[index];
		if(day== "Today"){
		var date = new Date();
		date.setHours(20, 0, 0);
		cont.updateTask(index,id,date);
		// console.log(date);
		}
		else{
		if(day== "Tomorrow"){
			var tomorrow = new Date();
			tomorrow.setDate(tomorrow.getDate() + 1);
			tomorrow.setHours(08, 0, 0);
			cont.updateTask(index,id,tomorrow);
			// console.log(tomorrow);
			}else{
				var nextweek = new Date();
				nextweek.setDate(nextweek.getDate() + 7);
				nextweek.setHours(08, 0, 0);
				cont.updateTask(index,id,nextweek);
				console.log(nextweek);
			}
		}
		
	}
	
	taskService.getAllTask().then(function(data){
		 console.log('getAllTask');
		
		// console.log(data);
		if(data.data.status == 1)
		{
			$scope.result = data.data.list;
			console.log($scope.result);
			// console.log(todos);signoutUser
			// if( todos )
			// {
			// for(var i=0;hidden i<todos.length; i++ )
			// {
			// $scope.result.push(todos[i]);
			//					 
			// console.log(todos[i]);
			// }
			// }
		}
		else{
			$state.go("login");
		}
	}).catch(function(){});
	
	$scope.copy=function(todo){
		console.log(todo);
		todo.id=null;
		
		taskService.createTask(todo).then(function(data){
			if(data.data.status==1){
				$scope.result.push( data.data.doTask );
				
				toaster.success('ToDo Copied successfully');
			}
		})
		
	}
	
	this.save = function(){
		if($scope.todo.reminder!=null){
			$scope.todo.reminder=new Date($scope.todo.reminder);
		}
		 //$scope.result.push( $scope.todo );
		 $("#ToggleToDoSection").hide();
         $('#OpenToDoSecton').show();
		 var httpObj = taskService.createTask($scope.todo).then(function(data){
			 
			 console.log(data);
			 $scope.todoDisplay= false;
			 if(data.data.status==1)
			 {
				 $scope.result.push( data.data.doTask );
				
				 $scope.todo.title=null;
				 $scope.todo.reminder=null;
				 $scope.todo.description=null;
				 
				 toaster.success('ToDo created successfully');
			 }
			 else{
				 $state.go("login"); // Nothidden action Remain in same page or error page
			 }
			 console.log($scope.result);
		 }).catch(function(){});
	}
	
	
	
	
	this.ShowHide = function(){
		$scope.todoDisplay= true;
	}
	/*
	 * this.doshow = function(){ $scope.todoDisplay= true; } this.dohide =
	 * function(){ $scope.todoDisplay= false; }
	 */
});


myApp.service('taskService',function($http){
	this.createTask = function(todo){ 
		return $http({
			url:"http://localhost:8080/toDoApp_2017/createtask",method:"post",data:todo});
	}
	
	this.getAllTask = function(todo){ 
		return $http({url:"http://localhost:8080/toDoApp_2017/todoList"});
	}
	
	this.deleteTodo=function(id){
		return $http({url:"http://localhost:8080/toDoApp_2017/delete/"+id, method:"post"});
	}
	
	this.updateToDo=function(id, todo){
		return $http({url:"http://localhost:8080/toDoApp_2017/update/"+id, method:"post",data:todo});
	}
	
	this.signoutUser=function(){
		return $http({url:"http://localhost:8080/toDoApp_2017/signout"});
	}
	
});
function jqueryFunction(){
	/*
	 * $('#products').mouseenter(function() { $('#products')
	 * $('#ButtonChange').show(); }).mouseout(function() {
	 * $('#ButtonChange').hide(); })
	 */
}

/*
 * When the user clicks on the button, toggle between hiding and showing the
 * dropdown content
 */
function myFunction() {
    document.getElementById("myDropdown").classList.toggle("show");
}

// Close the dropdown if the user clicks outside of it
window.onclick = function(event) {
  if (!event.target.matches('.dropbtn')) {

    var dropdowns = document.getElementsByClassName("dropdown-content");
    var i;
    for (i = 0; i < dropdowns.length; i++) {
      var openDropdown = dropdowns[i];
      if (openDropdown.classList.contains('show')) {
        openDropdown.classList.remove('show');
      }
    }
  }
}

