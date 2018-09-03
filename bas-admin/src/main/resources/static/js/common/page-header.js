var PageHeader = function () {
	var initComponents = function() {
		$("#change-password").click(function() {
			$("#change-password-modal").modal("show");
		});
	}
	var handleValidation = function() {
        var form = $("#form_change-password");
        var error = $("#form_change-password .alert-danger", form);
        var success = $("#form_change-password .alert-success", form);

        form.validate({
            errorElement: "span",
            errorClass: "help-block help-block-error",
            focusInvalid: false,
            ignore: "",
            debug: true,
            rules: {
            	password: {
                    required: true
                }
            },

            messages: { // custom messages for radio buttons and checkboxes
            	password: {
                    required: "Please Write Password"
                }
            },
            errorPlacement: function(error, element) { // render error placement for each input type
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

            invalidHandler: function(event, validator) { //display error alert on form submit   
                success.hide();
                error.show();
                App.scrollTo(error, -200);
            },

            highlight: function(element) { // hightlight error inputs
                $(element).closest('#form_change-password .form-group').addClass('has-error'); // set error class to the control group
            },

            unhighlight: function(element) { // revert the change done by hightlight
                $(element).closest('#form_change-password .form-group').removeClass('has-error'); // set error class to the control group
            },

            success: function(label) {
                label.closest('#form_change-password .form-group').removeClass('has-error'); // set success class to the control group
            },

            submitHandler: function(form) {
            	success.show();
                error.hide();
                
                var user = {
                		password: $("#form_change-password #password").val()
                };
                
                var result = PageHeaderAjax.changePassword(user);
                if(!result.success){
            		$("#page-error-modal .error-modal-message").text("System error, please contact the administrator");
            		$("#page-error-modal").modal("show"); 
              		return false;
              	}
                if (result.success) {
                	  $('#change-password-modal').modal('hide');
                }
            }

        });
    };
    return {
        //main function to initiate the module
        init: function () {
        	initComponents();
        	handleValidation();
        	var currentUser = PageHeaderAjax.getCurrentUser().data;
        	
        	$("#userName").text(currentUser.loginName);
        }

    };

}();

var PageHeaderAjax = function() {
	var getCurrentUser = function(leave) {
		var result = {
				success: false
		};
		$.ajax({
			url: "/api/users/me",
			type: "GET",
			async: false,
			dataType: "json"
		}).done(function(data){
			result.data = data;
			result.success = true;
		}).fail(function(data){
			console.log(data);
		});
		return result;
	};
	var changePassword = function(user) {
		var result = {
				success: false
		};
		$.ajax({
			url: "/api/users/modify-password",
			type: "PUT",
			data: JSON.stringify(user),
			async: false,
			//设置请求头信息
			contentType: 'application/json;charset=utf-8'
		}).done(function(data){
			result.data = data;
			result.success = true;
		}).fail(function(data){
			console.log(data);
		});
		return result;
	};
	return {
		getCurrentUser: function() {
			var result = getCurrentUser();
			return result;
		},
		changePassword: function(user) {
			var result = changePassword(user);
			return result;
		}
	}
}();

jQuery(document).ready(function() {
	PageHeader.init();
});