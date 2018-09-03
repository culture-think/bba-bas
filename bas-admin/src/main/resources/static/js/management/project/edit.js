var EditProject = function () {  
	var initComponents = function() {
	};
	
	//重置父产品选择框选项，不包含当前被编辑产品
	var resetParentProjectOptions = function(exludeEntity){
		//从后台获取数据，原因是datatable中数据可能不全	  
    	$.ajax({
    		url: "/projects",
            type: "GET",
            async: false,
            dataType: "json"
        })
        .done(function(data) {
        	if(!data){
          		return false;
          	}
        	
        	$("#form_edit #parent.select2me option").remove();
        	$("#form_edit #parent.select2me").append("<option value=''></option>");
        	$.each(data, function() { 
        		if(exludeEntity.id != this.id){
        			$("#form_edit #parent.select2me").append("<option value='" + this.id + "'>" + this.name + "</option>");
        		}
        	});
          	
        })
        .fail(function() {
        	return false;
        });
    	
	};
	
    // advance validation
    var handleValidation = function() {
        // for more info visit the official plugin documentation: 
        // http://docs.jquery.com/Plugins/Validation

        var form = $("#form_edit");
        var error = $("#form_edit .alert-danger", form);
        var success = $("#form_edit .alert-success", form);

        //项目编号格式：2017-001-001 
        $.validator.addMethod("isProjectCode", function(value, element) {       
        	var projectCode = /^P\d{4}-?\d{3}-?\d{3}$/;  
        	return this.optional(element) || (projectCode.test(value));       
        }, "Please input correct project code"); 

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
            	name: {
                    required: "Please Write Project Name"
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
               $(element).closest('#form_edit .form-group').addClass('has-error'); // set error class to the control group
            },

            unhighlight: function (element) { // revert the change done by hightlight
                $(element).closest('#form_edit .form-group').removeClass('has-error'); // set error class to the control group
            },

            success: function (label) {
                label.closest('#form_edit .form-group').removeClass('has-error'); // set success class to the control group
            },

            submitHandler: function (form) {
                success.show();
                error.hide();
                var id = $("#form_edit #id").val();
                var project = {
            		"name": $("#form_edit #name").val(),
            		"pictureId": $("#form_edit #pictureId").val(),
                };
                update(id, project);
                          
                return false;
            }

        });

         //apply validation on select2 dropdown value change, this only needed for chosen dropdown integration.
        $('#form_edit .select2me', form).change(function () {
            form.validate().element($(this)); //revalidate the chosen dropdown value and show error or success message for the input
        });

        //initialize datepicker
        $('#form_edit .date-picker').datepicker({
            rtl: App.isRTL(),
            autoclose: true
        });
        $('#form_edit .date-picker .form-control').change(function() {
            form.validate().element($(this)); //revalidate the chosen dropdown value and show error or success message for the input 
        })
    };
    
    //inject a entity
    var inject = function(entity) {
    	//重置父产品选择框选项，不包含当前被编辑产品
    	resetParentProjectOptions(entity);

    	var result = ProjectAjax.getProject(entity.id);
    	//从后台获取数据，原因是datatable中数据可能不全	  
    	if(!result.success){
    		$("#page-error-modal .error-modal-message").text("System error, please contact the administrator");
    		$("#page-error-modal").modal("show"); 
      		return false;
      	}
    	if (result.success) {
    		//初始化下拉菜单
            //给table赋值
            var entity = result.data;
            $("#form_edit #id").val(entity.id||"");
    		$("#form_edit #name").val(entity.name||"");
    		$("#form_edit #pictureId").val(entity.pictureId||"");
       	  	$('#edit-modal').modal('hide');

            $('#data-table').DataTable().ajax.reload();
       }
    };    
    
    //更新数据
    var update = function(id, project) {	
    	var result = ProjectAjax.updateProject(id, project);
        	if(!result.success){
            	$("#page-error-modal .error-modal-message").text(result.message);
            	$("#page-error-modal").modal("show"); 
        		return;
        	}
        	//后台自动生成代码suceess拼写错误，将错就错
            if (result.success) {
            	$("#form_edit .form-control").val(null);

            	$('#edit-modal').modal('hide');  
            	
            	$("#data-table").dataTable().api().ajax.reload();
            	return;
            };

        	$("#page-error-modal .error-modal-message").text(result.message);
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
	EditProject.init();
});
