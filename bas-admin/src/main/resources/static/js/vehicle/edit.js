var EditDefinition = function () {
    // advance validation
    var handleValidation = function() {
        // for more info visit the official plugin documentation: 
        // http://docs.jquery.com/Plugins/Validation

        var form = $("#form_definition-edit");
        var error = $("#form_definition-edit .alert-danger", form);
        var success = $("#form_definition-edit .alert-success", form);


        form.validate({
            errorElement: "span", //default input error message container
            errorClass: "help-block help-block-error", // default input error message class
            focusInvalid: false, // do not focus the last invalid input
            ignore: "", // validate all fields including form hidden input
            rules: {
                name: {
                    required: true
                }
            },

            messages: { // custom messages for radio buttons and checkboxes
            	vinCode: {
                    required: "Please input the VIN#"
                }
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
                success.hide();
                error.show();
                App.scrollTo(error, -200);
            },

            highlight: function (element) { // hightlight error inputs
               $(element).closest('#form_definition-edit .form-group').addClass('has-error'); // set error class to the control group
            },

            unhighlight: function (element) { // revert the change done by hightlight
                $(element).closest('#form_definition-edit .form-group').removeClass('has-error'); // set error class to the control group
            },

            success: function (label) {
                label.closest('#form_definition-edit .form-group').removeClass('has-error'); // set success class to the control group
            },

            submitHandler: function (form) {
                success.show();
                error.hide();
                var id = $("#form_definition-edit #id").val();
                var definition = {
                		vinCode: $("#form_definition-edit #vinCode").val(),
                		vCode: $("#form_definition-edit #vCode").val(),

                		edrMlogSn: $("#form_definition-edit #edrMlogSn").val(),
                		edrWifiModuleSn: $("#form_definition-edit #edrWifiModuleSn").val(),
                		arcosSn: $("#form_definition-edit #arcosSn").val(),
                		carOwner: $("#form_definition-edit #carOwner").val(),
                		edrType: $("#form_definition-edit #edrType").val(),
                        
                		picName: $("#form_definition-edit #picName").val(),
                		arcosFilePath: $("#form_definition-edit #arcosFilePath").val(),
                		edrFilePath: $("#form_definition-edit #edrFilePath").val(),
                		arcosTransmissionPath: $("#form_definition-edit #arcosTransmissionPath").val(),
                		edrTransmissionPath: $("#form_definition-edit #edrTransmissionPath").val(), 
                		arcosBackupPath: $("#form_definition-edit #arcosBackupPath").val(),
                		edrBackupPath: $("#form_definition-edit #edrBackupPath").val(), 
                		available: $("#form_definition-edit #available").prop("checked") || false,
                };
                update(id, definition);
                          
                return false;
            }

        });

         //apply validation on select2 dropdown value change, this only needed for chosen dropdown integration.
        $('#form_definition-edit .select2me', form).change(function () {
            form.validate().element($(this)); //revalidate the chosen dropdown value and show error or success message for the input
        });

        //initialize datepicker
        $('#form_definition-edit .date-picker').datepicker({
            rtl: App.isRTL(),
            autoclose: true
        });
        $('#form_definition-edit .date-picker .form-control').change(function() {
            form.validate().element($(this)); //revalidate the chosen dropdown value and show error or success message for the input 
        })
    };
    
    //inject a entity
    var inject = function(entity) {
    	var result = VehicleAjax.getVehicle(entity.id);
    	//从后台获取数据，原因是datatable中数据可能不全	  
    	if(!result.success){
    		$("#page-error-modal .error-modal-message").text("System error, please contact the administrator");
    		$("#page-error-modal").modal("show"); 
      		return false;
      	}
    	if (result.success) {
            //给table赋值
            var definitionInfo = result.data;
            $("#form_definition-edit #id").val(definitionInfo.id||"");
            $("#form_definition-edit #vinCode").val(definitionInfo.vinCode||"");
            $("#form_definition-edit #vCode").val(definitionInfo.vCode||"");
            
            $("#form_definition-edit #edrMlogSn").val(definitionInfo.edrMlogSn||"");
            $("#form_definition-edit #edrWifiModuleSn").val(definitionInfo.edrWifiModuleSn||"");
            $("#form_definition-edit #arcosSn").val(definitionInfo.arcosSn||"");
            $("#form_definition-edit #carOwner").val(definitionInfo.carOwner||"");
            $("#form_definition-edit #edrType").val(definitionInfo.edrType||"");
                        
            $("#form_definition-edit #picName").val(definitionInfo.picName||"");
            $("#form_definition-edit #arcosFilePath").val(definitionInfo.arcosFilePath||"");
            $("#form_definition-edit #edrFilePath").val(definitionInfo.edrFilePath||"");
            
            $("#form_definition-edit #arcosTransmissionPath").val(definitionInfo.arcosTransmissionPath||"");
            $("#form_definition-edit #edrTransmissionPath").val(definitionInfo.edrTransmissionPath||"");            
            $("#form_definition-edit #arcosBackupPath").val(definitionInfo.arcosBackupPath||"");
            $("#form_definition-edit #edrBackupPath").val(definitionInfo.edrBackupPath||"");   
            
            $("#form_definition-edit #available").prop("checked", !definitionInfo.available);
            $("#form_definition-edit #available").trigger('click');
            
       	  	$('#definition-edit-modal').modal('hide');

            $('#definition-table').DataTable().ajax.reload();
       }
    };    
    
    //更新数据
    var update = function(id, definition) {	
    	var result = VehicleAjax.updateVehicle(id, definition);
        	if(!result.success){
            	$("#page-error-modal .error-modal-message").text("System error, please contact the administrator");
            	$("#page-error-modal").modal("show"); 
        		return;
        	}
        	//后台自动生成代码suceess拼写错误，将错就错
            if (result.success) {
            	$("#form_definition-edit .form-control").val(null);

            	$('#definition-edit-modal').modal('hide');  
            	
            	$("#definition-table").dataTable().api().ajax.reload();
            	return;
            };

        	$("#page-error-modal .error-modal-message").text("System error, please contact the administrator");
        	$("#page-error-modal").modal("show"); 
    };
    return {
        //main function to initiate the module
        init: function () {
            handleValidation();
        },
        inject: function (entity) {
        	inject(entity);
        }
    };

}();

jQuery(document).ready(function() {
	EditDefinition.init();
});
