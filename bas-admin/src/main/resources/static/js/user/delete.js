var DeleteDefinition = function () {
	
	var init = function() {
        //删除用户模态对话框确认按钮点击事件
        $("#delete-definition-ok").on("click", function () {
        	var entity =  $("#to-delete-definition").data("entity");
        	if(!entity){
        		return;
      	  	}
      	  
        	var result = DefinitionAjax.deleteDefinition(entity.id);
            	if(!result.success){
                	$("#page-error-modal .error-modal-message").text("System error, please contact the administrator");
                	$("#page-error-modal").modal("show"); 
            		return;
            	}
            	//后台自动生成代码suceess拼写错误，将错就错
                if (result.success) {
                	$("#definition-table").dataTable().api().ajax.reload();
                	return;
                };
            	$("#page-error-modal .error-modal-message").text("System error, please contact the administrator");
            	$("#page-error-modal").modal("show"); 
            })
      	  $("#to-delete-definition").data("definitionId", null);
    }
    
    return {
        //main function to initiate the module
        init: function () {
        	init();
        }
    };

}();

jQuery(document).ready(function() {
	DeleteDefinition.init();
});
