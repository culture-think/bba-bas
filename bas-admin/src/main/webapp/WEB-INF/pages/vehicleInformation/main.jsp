<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<title>BBA BAS</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1" name="viewport" />
<meta content="" name="description" />
<meta content="" name="author" />
<!-- BEGIN GLOBAL MANDATORY STYLES -->
<link href="/assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
<link href="/assets/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css" />
<link href="/assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="/assets/global/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css" />
<link href="/assets/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css" rel="stylesheet" type="text/css" />
<!-- END GLOBAL MANDATORY STYLES -->
<!-- BEGIN PAGE LEVEL PLUGINS -->
<!-- 数据列表 -->
<link href="/assets/global/plugins/datatables/datatables.min.css" rel="stylesheet" type="text/css" />
<link href="/assets/global/plugins/datatables/plugins/bootstrap/datatables.bootstrap.css" rel="stylesheet" type="text/css" />

<!-- 模态对话框 -->
<link href="/assets/global/plugins/bootstrap-modal/css/bootstrap-modal-bs3patch.css" rel="stylesheet" />
<link href="/assets/global/plugins/bootstrap-modal/css/bootstrap-modal.css" rel="stylesheet" />

<!-- 数据表单 -->
<link href="/assets/global/plugins/select2/css/select2.min.css" rel="stylesheet" type="text/css" />
<link href="/assets/global/plugins/select2/css/select2-bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="/assets/global/plugins/bootstrap-datepicker/css/bootstrap-datepicker3.min.css" rel="stylesheet" type="text/css" />



<!-- END PAGE LEVEL PLUGINS -->
<!-- BEGIN THEME GLOBAL STYLES -->
<link href="/assets/global/css/components.min.css" rel="stylesheet" id="style_components" type="text/css" />
<link href="/assets/global/css/plugins.min.css" rel="stylesheet" type="text/css" />
<!-- END THEME GLOBAL STYLES -->
<!-- BEGIN THEME LAYOUT STYLES -->
<link href="/assets/layouts/layout/css/layout.min.css" rel="stylesheet" type="text/css" />
<link href="/assets/layouts/layout/css/themes/light.min.css" rel="stylesheet" type="text/css" id="style_color" />
<link href="/assets/layouts/layout/css/custom.css" rel="stylesheet" type="text/css" /> 
<!-- END THEME LAYOUT STYLES -->
<link rel="shortcut icon" href="/assets/pages/img/bmw-32.ico" />

<link href="/assets/global/plugins/dropzone/dropzone.min.css" rel="stylesheet" type="text/css" />
</head>
<!-- END HEAD -->

<body class="page-header-fixed page-sidebar-closed-hide-logo page-content-white">

	<!-- BEGIN HEADER -->
	<%@ include file="/page-header.html"%>
	<!-- END HEADER -->

	<!-- BEGIN HEADER & CONTENT DIVIDER -->
	<div class="clearfix"></div>
	<!-- END HEADER & CONTENT DIVIDER -->

	<!-- BEGIN CONTAINER -->
	<div class="page-container">

		<!-- BEGIN CONTENT -->
		<%@ include file="./content.html"%>
		<!-- END CONTENT -->

		<!-- BEGIN MODAL SUB PAGE-->
		<%@ include file="./add-new.html"%>
		<%@ include file="./edit.html"%>
		<%@ include file="./view.html"%>
		<%@ include file="./delete.html"%>
		<%@ include file="/page-error-modal.html"%>
		<!-- BEGIN MODAL SUB PAGE-->
	</div>
	<!-- END CONTAINER -->

	<!-- BEGIN FOOTER -->
	<%@ include file="/page-footer.html"%>
	<!-- END FOOTER -->

	<!-- BEGIN CORE PLUGINS -->
	<script src="/assets/global/plugins/jquery.min.js" type="text/javascript"></script>
	<script src="/assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="/assets/global/plugins/js.cookie.min.js" type="text/javascript"></script>
	<script src="/assets/global/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js" type="text/javascript"></script>
	<script src="/assets/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
	<script src="/assets/global/plugins/jquery.blockui.min.js" type="text/javascript"></script>
	<script src="/assets/global/plugins/uniform/jquery.uniform.min.js" type="text/javascript"></script>
	<script src="/assets/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js" type="text/javascript"></script>
	<!-- END CORE PLUGINS -->
	<!-- BEGIN PAGE LEVEL PLUGINS -->
	<script src="/assets/global/plugins/bootstrap-confirmation/bootstrap-confirmation.min.js" type="text/javascript"></script>
	<!-- 
	<script src="/assets/global/scripts/datatable.js" type="text/javascript"></script>
	 -->
	<script src="/assets/global/plugins/datatables/datatables.min.js" type="text/javascript"></script>
	<script src="/assets/global/plugins/datatables/plugins/bootstrap/datatables.bootstrap.js" type="text/javascript"></script>

	<script src="/assets/global/plugins/bootstrap-modal/js/bootstrap-modalmanager.js"></script>
	<script src="/assets/global/plugins/bootstrap-modal/js/bootstrap-modal.js"></script>

	<script src="/assets/global/plugins/select2/js/select2.full.min.js" type="text/javascript"></script>
	<script src="/assets/global/plugins/jquery-validation/js/jquery.validate.min.js" type="text/javascript"></script>
	<script src="/assets/global/plugins/jquery-validation/js/additional-methods.min.js" type="text/javascript"></script>

	<!-- END PAGE LEVEL PLUGINS -->
	<!-- BEGIN THEME GLOBAL SCRIPTS -->
	<script src="/assets/global/scripts/app.min.js" type="text/javascript"></script>
	<!-- END THEME GLOBAL SCRIPTS -->

	<!-- BEGIN PAGE LEVEL SCRIPTS -->
	<script src="/js/vehicleInformation/ajax.js" type="text/javascript"></script>
	<script src="/js/vehicleInformation/main.js" type="text/javascript"></script>
	<script src="/js/vehicleInformation/upload-picture.js" type="text/javascript"></script>
	<script src="/js/vehicleInformation/add-new.js" type="text/javascript"></script>
	<script src="/js/vehicleInformation/delete.js" type="text/javascript"></script>
	<script src="/js/vehicleInformation/edit.js" type="text/javascript"></script>
	<script src="/js/vehicleInformation/view.js" type="text/javascript"></script>

	<script src="/js/common/page-header.js" type="text/javascript"></script>
	<!-- END PAGE LEVEL SCRIPTS -->

	<!-- BEGIN THEME LAYOUT SCRIPTS -->
	<script src="/assets/layouts/layout/scripts/layout.min.js" type="text/javascript"></script>
	<!-- END THEME LAYOUT SCRIPTS -->
	<script src="/assets/global/plugins/bootstrap-datepicker/js/bootstrap-datepicker.min.js" type="text/javascript"></script>
	<script src="/assets/global/plugins/dropzone/dropzone.min.js" type="text/javascript"></script>
</body>

</html>