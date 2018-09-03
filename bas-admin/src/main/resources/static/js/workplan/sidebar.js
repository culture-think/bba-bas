var PageSidebar = function () {
	var projectId = $("#projectId").val();
	//初始化：currentModule，当前模块名称
	var init = function() {
		//模块树列表
		var projectList = PageSidebarAjax.getProjects().data;
		if(!projectList.length) {
			return;
		}
		if(!projectId) {
			projectId = projectList[0].id || "";
		}
		
		var $item = $('<ul class="sub-menu"></ul>');
		//构建侧边栏
		var $sidebarMenu = $("#projectList");
		$.each(projectList, function(index, project){
			//构建模块
			var theClass = '';
			if(projectId == project.id){
				theClass = 'active';
			}
			
			var url = "/workplan?projectId=" + project.id;
			$item.append('<li class="nav-item  ' + theClass + '">'
				      + '	<a href="' + url + '" class="nav-link">'
				      + '		<span class="title">' + project.name + '</span>'
				      + '	</a>'
				      + '</li>');
			
			//添加模块
			$sidebarMenu.append($item);
		});
		WorkplanMain.init(projectId);
	};
	
    return {
        //main function to initiate the module
        init: function () {
        	init();
        }
    };

}();
jQuery(document).ready(function() {
	PageSidebar.init();
});
var PageSidebarAjax = function() {
	var getProjects = function() {
		var result = {
				success: false
		};
		$.ajax({
			url: "/api/projects",
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
	return {
		getProjects: function() {
			var result = getProjects();
			return result;
		}
	}
}();