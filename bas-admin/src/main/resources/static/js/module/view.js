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
    	$("#form_definition-view #parent").text(entity["parent"] && entity["parent"].name || "");
    	$("#form_definition-view #type").text(entity["type"] == 2 ? "Group": "Module");
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