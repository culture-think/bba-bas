ViewDefinition = function () {
    // inject a entity
    var inject = function(entity) {
    	var children = $("#form_definition-view").find("p.form-control-static");
    	children.each(function(i, control) {
    		if(entity[control.id] == null){
    			return true;
    		}
			$(control).text(entity[control.id]);
		});
    	$("#form_definition-view #project").text(entity["project"].name);
    };
    // 清空数据
    var empty = function() {
    	var children = $("#form_definition-view").find("p.form-control-static");
    	children.each(function(i, control) {
			$(control).text(null);
		});
    };

    return {
        //
    	inject: function (entity) {
    		inject(entity); 
        },
        empty: function () {
        	empty(); 
        }
        
    };

}();