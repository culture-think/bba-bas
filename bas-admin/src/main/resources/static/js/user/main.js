var DefinitionMain = function () {
	
    var initTable = function () {
        var table = $('#definition-table');

        var fixedHeaderOffset = 0;
        if (App.getViewPort().width < App.getResponsiveBreakpoint('md')) {
            if ($('.page-header').hasClass('page-header-fixed-mobile')) {
                fixedHeaderOffset = $('.page-header').outerHeight(true);
            } 
        } else if ($('.page-header').hasClass('navbar-fixed-top')) {
            fixedHeaderOffset = $('.page-header').outerHeight(true);
        }

        var oTable = table.dataTable({
            fixedHeader: {
                header: true,
                footer: true,
                headerOffset: fixedHeaderOffset
            },

            "order": [
                [0, 'asc']
            ],
            
            "lengthMenu": [
                [5, 10, 15, 30, -1],
                [5, 10, 15, 30, "All"] // change per page values here
            ],
            // set the initial value
            "pageLength": 10,
            ajax : {
                url: '/api/users',
                dataSrc: ''
            },
            columns: [
                      { data:"id", title: "ID", visible: false, searchable: false},//0
                      { data:"loginName", title: "Login Name", visible: true, searchable: true},//1
                      { data:"project.name", title: "Project", visible: true, searchable: true}//2
            ]
      });
          
      //处理鼠标点击选中状态
		$('#definition-table tbody').on( 'click', 'tr', function () {
			if ($(this).hasClass('selected') ) {
				$(this).removeClass('selected');
		        return;
		    }
			
			table.$('tr.selected').removeClass('selected');
		    $(this).addClass('selected');
		});
      //删除数据
	  $('#definition-delete').click(function () {
    	    var entity = $('#definition-table').DataTable().row('.selected').data();
    	    if(!entity){
	    		$("#page-error-modal .error-modal-message").text("No user is selected.");
	    		$("#page-error-modal").modal("show");    	
        	  
	    		return false;
	    	}
    	    $("#to-delete-definition").data("entity", entity);
      });

      //查看用户
      $('#definition-view').click(function () {
    	    var entity = $('#definition-table').DataTable().row('.selected').data();
    	    if(!entity){
	    		$("#page-error-modal .error-modal-message").text("No user is selected.");
	    		$("#page-error-modal").modal("show");    	
        	  
	    		return false;
	    	}
    	    ViewDefinition.inject(entity);
      }); 
      //编辑数据
      $('#definition-edit').click(function () {
            var entity = $('#definition-table').DataTable().row('.selected').data();
            if(!entity){
	    		$("#page-error-modal .error-modal-message").text("No user is selected.");
	    		$("#page-error-modal").modal("show");    	
        	  
	    		return false;
	    	}
            EditDefinition.inject(entity);
      });
    }
    
    return {
        init: function () {
            if (!jQuery().dataTable) {
                return;
            }
            initTable(); 
            
            //初始化全局模态对话框
            $("#page-error-modal").modal({show: false}); 
            
            //初始化侧边栏
            PageSidebar.init("User Management");
        }

    };

}();

jQuery(document).ready(function() {
	DefinitionMain.init();
});