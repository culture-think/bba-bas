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
                [1, 'asc']
            ],
            
            "lengthMenu": [
                [5, 10, 15, 30, -1],
                [5, 10, 15, 30, "All"] // change per page values here
            ],
            // set the initial value
            "pageLength": 10,
            ajax : {
                url: '/api/modules',
                dataSrc: ''
            },
            columns: [
                      { data:"id", title: "ID", visible: false, searchable: false},//0
                      { data:"index", title: "Index", visible: false, searchable: false},//1
                      { data:"index", title: "Index", visible: true, searchable: true},//2
                      { data:"name", title: "Name", visible: true, searchable: true},//3
                      { data:"type", title: "Type", visible: true, searchable: true},//4
                      { data:"icon", title: "Icon", visible: true, searchable: true},//5
                      { data:"url", title: "URL", visible: true, searchable: true},//6
                      { data:"parent", title: "Parent", visible: true, searchable: true}//-1
                      
            ],
            columnDefs: [
                         {
                         	"render": function ( data, type, row, a, b, c ) {
                         		
                         		if(!data){
                             		return data;
                             	}
                         		
                             	return data.name;
                             },
                             "targets": -1
                           },
                           {
                            	"render": function ( data, type, row, a, b, c ) {
                                	return data == 2 ? "Group" : "Module";
                                },
                                "targets": 4
                            }
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
	    		$("#page-error-modal .error-modal-message").text("No module is selected.");
	    		$("#page-error-modal").modal("show");    	
        	  
	    		return false;
	    	}
    	    $("#to-delete-definition").data("entity", entity);
      });

      //查看用户
      $('#definition-view').click(function () {
    	    var entity = $('#definition-table').DataTable().row('.selected').data();
    	    if(!entity){
	    		$("#page-error-modal .error-modal-message").text("No module is selected.");
	    		$("#page-error-modal").modal("show");    	
        	  
	    		return false;
	    	}
    	    ViewDefinition.inject(entity);
      }); 
      //编辑数据
      $('#definition-edit').click(function () {
            var entity = $('#definition-table').DataTable().row('.selected').data();
            if(!entity){
	    		$("#page-error-modal .error-modal-message").text("No module is selected.");
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
            PageSidebar.init("Module Management");
        }

    };

}();

jQuery(document).ready(function() {
	DefinitionMain.init();
});