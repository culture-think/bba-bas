var UserMain = function () {
	
    var initTable = function () {
        var table = $('#data-table');
        $.fn.dataTable.ext.errMode = 'none';
        
//        $('#example').on('error.dt', function(e, settings, techNote, message) {
//			console.log('An error has been reported by DataTables: ', message);
//		}).DataTable();
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
                      { data:"loginName", title: "LoginName", visible: true, searchable: true},//1
                      { data:"password", title: "Password", visible: true, searchable: true},//2
                      { data:"type", title: "Type", visible: true, searchable: true}//3
            ],
            columnDefs: [
                          {
                           	"render": function ( data, type, row, a, b, c ) {
                           		if(!data) {
                           			return"";
                           		}
                               	return data == 1 ? "Admin":"Normal User";
                               },
                               "targets": [3]
                           }]
            
      });
          
      //处理鼠标点击选中状态
		$('#data-table tbody').on( 'click', 'tr', function () {
			if ($(this).hasClass('selected') ) {
				$(this).removeClass('selected');
		        return;
		    }
			
			table.$('tr.selected').removeClass('selected');
		    $(this).addClass('selected');
		});
      //删除数据
      $('#data-delete').click(function () {
    	    var entity = $('#data-table').DataTable().row('.selected').data();
    	    if(!entity){
	    		$("#page-error-modal .error-modal-message").text("No role is selected.");
	    		$("#page-error-modal").modal("show");    	
      	  
	    		return false;
	    	}
    	    $("#to-delete").data("entity", entity);
      });

      //查看用户
      $('#data-view').click(function () {
    	    var entity = $('#data-table').DataTable().row('.selected').data();
    	    if(!entity){
	    		$("#page-error-modal .error-modal-message").text("No role is selected.");
	    		$("#page-error-modal").modal("show");    	
      	  
	    		return false;
	    	}
    	    ViewUser.inject(entity);
      }); 
    //编辑数据
      $('#data-edit').click(function () {
            var entity = $('#data-table').DataTable().row('.selected').data();
            if(!entity){
	    		$("#page-error-modal .error-modal-message").text("No role is selected.");
	    		$("#page-error-modal").modal("show");    	
      	  
	    		return false;
	    	}
            EditUser.inject(entity);
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
        }

    };

}();

jQuery(document).ready(function() {
	UserMain.init();
});