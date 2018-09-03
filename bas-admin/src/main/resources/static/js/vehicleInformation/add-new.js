var NewVehicle = function() {
    //初始化添加页面的组件
    var initComponents = function() {
    	//初始化项目编号和项目名称
    	$("#form_add-new #name").val(""); 
    };
    
    // advance validation
    var handleValidation = function() {
        var form = $("#form_add-new");
        var error = $("#form_add-new .alert-danger", form);
        var success = $("#form_add-new .alert-success", form);

        //项目编号格式：2017-001-001 
        $.validator.addMethod("isVehicleCode", function(value, element) {       
        	var projectCode = /^P\d{4}-?\d{3}-?\d{3}$/;  
        	return this.optional(element) || (projectCode.test(value));       
        }, "Please input correct project code");  

        //添加页面的盘空条件
        form.validate({
            errorElement: "span",
            errorClass: "help-block help-block-error",
            focusInvalid: false,
            ignore: "",
            debug: true,
            rules: {
            	loginName: {
            		required: true
            	}
            },
            messages: { // custom messages for radio buttons and checkboxes
            	loginName: {
                    required: "Please Write LoginName"
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
                $(element).closest('#form_add-new .form-group').addClass('has-error'); // set error class to the control group
            },

            unhighlight: function(element) { // revert the change done by hightlight
                $(element).closest('#form_add-new .form-group').removeClass('has-error'); // set error class to the control group
            },

            success: function(label) {
                label.closest('#form_add-new .form-group').removeClass('has-error'); // set success class to the control group
            },

            submitHandler: function(form) {
            	success.show();
                error.hide();
                var vehicle = {
                		order: $("#form_add-new #order").val(),
                		type: $("#form_add-new #type").val(),
                		engine: $("#form_add-new #engine").val(),
                		tire: $("#form_add-new #tire").val(),
                		vin: $("#form_add-new #vin").val(),
                		iLevel: $("#form_add-new #iLevel").val()
                };
                var result = VehicleAjax.addVehicle(vehicle);
                if(!result.success){
                	$("#page-error-modal .error-modal-message").text("用户账号已经存在");
//            		$("#page-error-modal .error-modal-message").text("System error, please contact the administrator");
            		$("#page-error-modal").modal("show"); 
              		return false;
              	}
                if (result.success) {
                	  $('#add-new-modal').modal('hide');

                      $('#data-table').DataTable().ajax.reload();
                }
            }

        });

        //initialize datepicker
        $('#form_add-new .date-picker').datepicker({
            rtl: App.isRTL(),
            autoclose: true
        });
    };

    return {
        init: function() {
            initComponents();
            handleValidation();
        }
    };

} ();

jQuery(document).ready(function() {
    NewVehicle.init();
});