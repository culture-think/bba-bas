var WorkplanMain = function () {
	var projectId = "";
	var handleValidation = function() {
        // for more info visit the official plugin documentation: 
        // http://docs.jquery.com/Plugins/Validation

        var form = $("#workplan_form");
        form.validate({
            errorElement: "span", //default input error message container
            errorClass: "help-block help-block-error", // default input error message class
            focusInvalid: false, // do not focus the last invalid input
            ignore: "", // validate all fields including form hidden input
            rules: {
            },
            messages: { // custom messages for radio buttons and checkboxes
            },
            errorPlacement: function (error, element) { // render error placement for each input type
                if (element.parent(".input-group").size() > 0) {
                    error.insertAfter(element.parent(".input-group"));
                } else if (element.attr("data-error-container")) { 
                    error.appendTo(element.attr("data-error-container"));
                } else if (element.parents('.radio-list').size() > 0) { 
                    error.appendTo(element.parents('.radio-list').attr("data-error-container"));
                } else if (element.parents('.radio-inline').size() > 0) { 
                    error.appendTo(element.parents('.radio-inline').attr("data-error-container"));
                } else if (element.parents('.checkbox-list').size() > 0) {
                    error.appendTo(element.parents('.checkbox-list').attr("data-error-container"));
                } else if (element.parents('.checkbox-inline').size() > 0) { 
                    error.appendTo(element.parents('.checkbox-inline').attr("data-error-container"));
                } else {
                    error.insertAfter(element); // for other inputs, just perform default behavior
                }
            },

            invalidHandler: function (event, validator) { //display error alert on form submit   
                App.scrollTo(error, -200);
            },

            highlight: function (element) { // hightlight error inputs
               $(element).closest('#workplan_form .form-group').addClass('has-error'); // set error class to the control group
            },

            unhighlight: function (element) { // revert the change done by hightlight
                $(element).closest('#workplan_form .form-group').removeClass('has-error'); // set error class to the control group
            },

            success: function (label) {
                label.closest('#workplan_form .form-group').removeClass('has-error'); // set success class to the control group
            },

            submitHandler: function (form) {
            	var userIds = $("#workplan_form #usersMultiSelect").val();
            	var users = new Array();
            	$.each(userIds, function(index, userId){
            		users.push({
            			"userId":userId
            		});
            	});
            	var vehicleIds = $("#workplan_form #vehiclesMultiSelect").val();
            	var vehicles = new Array();
            	$.each(vehicleIds, function(index, vehicleId){
            		vehicles.push({
            			"vehicleId":vehicleId
            		});
            	});
            	var workplan = {
            		"projectId":projectId,
            		"users": users,
            		"vehicles": vehicles
                };
                var id = $("#workplan_form #id").val();
                if(!id) {
                    WorkplanAjax.addWorkPlan(workplan);
                    $("#usersMultiSelect").multiSelect('refresh');
                	$("#vehiclesMultiSelect").multiSelect('refresh');
                    return false;
                }
                WorkplanAjax.updateWorkplan(id, workplan);
                $("#usersMultiSelect").multiSelect('refresh');
            	$("#vehiclesMultiSelect").multiSelect('refresh');
                return false;
            }

        });

         //apply validation on select2 dropdown value change, this only needed for chosen dropdown integration.
        $('#workplan_form .select2me', form).change(function () {
            form.validate().element($(this)); //revalidate the chosen dropdown value and show error or success message for the input
        });
    };
    var init = function() {
    	loadVehiclesMultiSelect();
    	loadUsersMultiSelect();
    	initWorkplan(projectId);
    }
    var loadVehiclesMultiSelect = function(){
    	var vehicleList = WorkplanAjax.getVehicles();
    	var htmlText = "";
    	$.each(vehicleList, function(index, vehicle){
    		htmlText += '<option value="'+ vehicle.id +'">' + vehicle.vin + '</option>';
    	});
    	$("#vehiclesMultiSelect").html(htmlText);
    	$("#vehiclesMultiSelect").multiSelect('refresh');
	};
	var loadUsersMultiSelect = function(){
    	var userList = WorkplanAjax.getUsers();
    	var htmlText = "";
    	$.each(userList, function(index, user){
    		htmlText += '<option value="'+ user.id +'">' + user.loginName + '</option>';
    	});
    	$("#usersMultiSelect").html(htmlText);
    	$("#usersMultiSelect").multiSelect('refresh');
	};
	var initWorkplan = function(projectId) {
		var workplans = WorkplanAjax.getWorkplans(projectId);
		if(workplans.length == 0) {
			return;
		}
		var workplan = workplans[0];
		$("#workplan_form #id").val(workplan.id)
		var users = workplan.users;
		var userIds = new Array();
		$.each(users, function(index, user){
			userIds.push(user.userId);
    	});
		$("#usersMultiSelect").multiSelect('select', userIds);
//		$("#usersMultiSelect").multiSelect('select', ["5d358a9211ff4922a7ea47c73f8a38f7", "a8912154096244acb12d0d649398cd3a"]);
		var vehicles = workplan.vehicles;
		var vehicleIds = new Array();
		$.each(vehicles, function(index, vehicle){
			vehicleIds.push(vehicle.vehicleId);
    	});
		$("#vehiclesMultiSelect").multiSelect('select', vehicleIds);
    }
    return {
        init: function (_projectId) {
        	projectId = _projectId;
        	init();
            handleValidation();
            $("#page-error-modal").modal({show: false}); 
        }

    };

}();
