var EditDefinition = function () {
	var initParentSelect = function() {
        var result = DefinitionAjax.getModules();
        if (!result) {
            return;
        }
        var optionContent = '<option value=""></option>';
        for (var item in result) {
            optionContent += '<option value='+result[item].id+'>' + result[item].name + '</option>';
        }
        $("#form_definition-edit #parent").html(optionContent);
    }
	var initComponents = function() {

	};
	
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
                loginName: {
                    required: true
                }
            },

            messages: { // custom messages for radio buttons and checkboxes
            	loginName: {
                    required: "Please write the login name."
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
                		name: $("#form_definition-edit #name").val(),
                		type: $("#form_definition-edit #type option:selected").val(),
                		icon: $("#form_definition-edit #icon").val(),
                		url: $("#form_definition-edit #url").val(),
                		parentId: $("#form_definition-edit #parent option:selected").val() || null,
                		index: $("#form_definition-edit #index").val(),
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

    	var result = DefinitionAjax.getDefinition(entity.id);
    	//从后台获取数据，原因是datatable中数据可能不全	  
    	if(!result.success){
    		$("#page-error-modal .error-modal-message").text("System error, please contact the administrator");
    		$("#page-error-modal").modal("show"); 
      		return false;
      	}
    	if (result.success) {
    		initParentSelect();
            //给table赋值
            var definitionInfo = result.data;
            $("#form_definition-edit #id").val(definitionInfo.id||"");
            $("#form_definition-edit #name").val(definitionInfo.name||"");
            $("#form_definition-edit #type").select2('val',definitionInfo.type);
            
            $("#form_definition-edit #icon").val(definitionInfo.icon||"");
            $("#form_definition-edit #url").val(definitionInfo.url||"");
    
            $("#form_definition-edit #parent").select2('val',definitionInfo.parentId);
            $("#form_definition-edit #index").val(definitionInfo.index||"");
            
       	  	$('#definition-edit-modal').modal('hide');

            $('#definition-table').DataTable().ajax.reload();
       }
    };    
    
    //更新数据
    var update = function(id, definition) {	
    	var result = DefinitionAjax.updateDefinition(id, definition);
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
        	initComponents();
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
