var NewDefinition = function() {
	var initSelect2 = function($element, data, idText, nameText){
    	if(!data){
    		return;
    	}
    	
    	var optionContent = '';
        for (var item in data) {
            optionContent += '<option value=' + data[item][idText] + '>' + data[item][nameText] + '</option>';
        }
        
        $element.html(optionContent);
        
        $element.select2({
            placeholder: "Please select a item.",
            width: "auto"
        });
    };
    var initComponents = function() {
    	var modules = DefinitionAjax.getModules();
    	modules.unshift({id: "", name: ""});
        initSelect2($("#form_definition-add-new #parent"), modules, "id", "name");
    };
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
                },
                index: {
                    required: true,
                    number:true
                },
                icon: {
                	required: true
                }
            },

            messages: { // custom messages for radio buttons and checkboxes
            	name: {
                    required: "Please write the name."
                },
                index: {
                    required: "Please write the index."
                },
                icon: {
                    required: "Please write the icon."
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
                		name: $("#form_definition-add-new #name").val(),
                		type: $("#form_definition-add-new #type option:selected").val(),
                		icon: $("#form_definition-add-new #icon").val(),
                		url:  $("#form_definition-add-new #url").val(),
                		index: $("#form_definition-add-new #index").val(),
                		parentId: $("#form_definition-add-new #parent option:selected").val() || null,
                		
                };
                var result = DefinitionAjax.addDefinition(definition);
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
            initComponents();
            handleValidation();
        }
    };

} ();

jQuery(document).ready(function() {
    NewDefinition.init();
});