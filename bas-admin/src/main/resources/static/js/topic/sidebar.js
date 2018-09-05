var PageSidebar = function () {
	var workplanId = $("#projectId").val();
	//初始化：currentModule，当前模块名称
	var init = function() {
		//模块树列表
		var workplanList = TopicAjax.getProjects().data;
		if(!workplanList.length) {
			return;
		}
		if(!workplanId) {
			workplanId = workplanList[0].id || "";
		}
		
		var $item = $('<ul class="sub-menu"></ul>');
		//构建侧边栏
		var $sidebarMenu = $("#leftMenuList");
		$.each(workplanList, function(index, workplan){
			//构建模块
			var theClass = '';
			if(workplanId == workplan.id){
				theClass = 'topic-selected';
			}
			
			$item.append('<li><a id="projectNo'+ index +'" class="vehicle '+ theClass +' "><input type="hidden" id="project'+index+'" value="'+ workplan.id +'">'+ workplan.project.name +'</a>');
			//添加模块
			$sidebarMenu.html($item);
		});
		TopicMain.initContent(workplanId);
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
