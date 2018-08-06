var NewVehicle = function() {
    // advance validation
    var handleValidation = function() {
        var form = $("#form_definition-add-new");
        var error = $("#form_definition-add-new .alert-danger", form);
        var success = $("#form_definition-add-new .alert-success", form);

        form.validate({
            errorElement: "span",
            errorClass: "help-block help-block-error",
            focusInvalid: false,
            ignore: "",
            debug: true,
            rules: {
                name: {
                    required: true
                }
            },

            messages: { // custom messages for radio buttons and checkboxes
            	vinCode: {
                    required: "Please input the VIN Number."
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
                $(element).closest('#form_definition-add-new .form-group').addClass('has-error'); // set error class to the control group
            },

            unhighlight: function(element) { // revert the change done by hightlight
                $(element).closest('#form_definition-add-new .form-group').removeClass('has-error'); // set error class to the control group
            },

            success: function(label) {
                label.closest('#form_definition-add-new .form-group').removeClass('has-error'); // set success class to the control group
            },

            submitHandler: function(form) {
            	success.show();
                error.hide();
                var definition = {
                		vinCode: $("#form_definition-add-new #vinCode").val(),
                		vCode: $("#form_definition-add-new #vCode").val(),
                		
                		edrMlogSn: $("#form_definition-add-new #edrMlogSn").val(),
                		edrWifiModuleSn: $("#form_definition-add-new #edrWifiModuleSn").val(),
                		arcosSn: $("#form_definition-add-new #arcosSn").val(),
                		carOwner: $("#form_definition-add-new #carOwner").val(),
                		edrType: $("#form_definition-add-new #edrType").val(),                		
                		
                		picName: $("#form_definition-add-new #picName").val(),
                		arcosFilePath: $("#form_definition-add-new #arcosFilePath").val(),
                		edrFilePath: $("#form_definition-add-new #edrFilePath").val(),
                		arcosTransmissionPath: $("#form_definition-add-new #arcosTransmissionPath").val(),
                		edrTransmissionPath: $("#form_definition-add-new #edrTransmissionPath").val(), 
                		arcosBackupPath: $("#form_definition-add-new #arcosBackupPath").val(),
                		edrBackupPath: $("#form_definition-add-new #edrBackupPath").val(),                   		
                		available: $("#form_definition-add-new #available").prop("checked") || false,
                };
                var result = VehicleAjax.addVehicle(definition);
                if(!result.success){
            		$("#page-error-modal .error-modal-message").text("System error, please contact the administrator");
            		$("#page-error-modal").modal("show"); 
              		return false;
              	}
                if (result.success) {
                	  $('#definition-add-new-modal').modal('hide');

                      $('#definition-table').DataTable().ajax.reload();
                }
            }

        });

        //initialize datepicker
        $('#form_definition-add-new .date-picker').datepicker({
            rtl: App.isRTL(),
            autoclose: true
        });
    };

    return {
        init: function() {
            handleValidation();
        }
    };

} ();

jQuery(document).ready(function() {
    NewVehicle.init();
});