<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta charset="UTF-8">
<title></title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link rel="stylesheet" href="../css/base.css" />
<link rel="stylesheet" href="../css/VE.css" />
<link rel="shortcut icon" href="/img/logo.png" />
</head>

<body>
	<div class="context">
		<!-- 1.left menu list -->
		<div class="left_menu">
			<div class="left_menu_head">
				<li>
					<a>Project List</a>
					<input type="hidden" id="vehicleID" value="" />
				</li>
			</div>
			<ul id="leftMenuList" class="left_menu_list">
			</ul>
		</div>
	</div>
	<!-- 1.left menu list end-->

	<!-- 2. middle content -->
	<div class="middle_content">
		<div class="middle_vehicle" style="display: block">
			<table cellpadding="0" cellspacing="0" id="nve-table">
				<thead class="nve-table-thead">
					<tr>
						<th>No.</th>
						<th>Problem Description</th>
						<th>BAS BI</th>
						<th>Tester</th>
						<th>Status</th>
						<th>Analyse Dep.</th>
						<th>New or Old</th>
						<th>Specialist</th>
						<th>Specialist BI</th>
						<th>PQM/ALM No.</th>
						<th>ATG-IT No.</th>
						<th>Remark</th>
						<th>Option</th>
					</tr>
				</thead>
				<tbody id="topic-table">
<!-- 					<tr class="nve-table-tr" id=""> -->
<!-- 						<td style="width : 50px;"><input type="number"></td> -->
<!-- 						<td><textarea id="" rows="" cols="" disabled="disabled"></textarea></td> -->
<!-- 						<td style="width : 50px;"><input type="number" disabled="disabled"></td> -->
<!-- 						<td><textarea id="" rows="" cols="" disabled="disabled"></textarea></td> -->
<!-- 						<td><textarea id="" rows="" cols="" disabled="disabled"></textarea></td> -->
<!-- 						<td><textarea id="" rows="" cols=""></textarea></td> -->
<!-- 						<td><textarea id="" rows="" cols=""></textarea></td> -->
<!-- 						<td><textarea id="" rows="" cols=""></textarea></td> -->
<!-- 						<td><textarea id="" rows="" cols=""></textarea></td> -->
<!-- 						<td><textarea id="" rows="" cols=""></textarea></td> -->
<!-- 						<td><textarea id="" rows="" cols=""></textarea></td> -->
<!-- 						<td><textarea id="" rows="" cols=""></textarea></td> -->
<!-- 						<td><a class="delete-btn" id="delete">DELETE</a><a class="save-btn" id="save">SAVE</a></td> -->
<!-- 					<tr/> -->
				</tbody>
			</table>
		</div>

	</div>
	<div style="width: 100%; height: 50px;"></div>
	<!-- 2. middle content -->
	<!-- footer menu list-->
	<div class="btn-bottom">
		<a class="href-home" href="/">Home Page</a>
		<a class="href-home" href="/topic">Refresh</a>
<!-- 		<a class="href-home" href="/newVehicleEvaluation">Export</a> -->
<!-- 		<a class="href-home" href="javascript:;" id="nve-add">Add New</a> -->
	</div>
	<div class="pop-div" style="display: none;">
		<!-- 		<div class="shade"></div> -->
		<div class="Layer1">
			<div class="win_top">
				<a href="javascript:;" id="close-pop">Close</a>
			</div>
			<div class="pop-img"></div>
		</div>
	</div>
	<!-- footer menu list end-->
	<script src="/js/common/jquery.min.js" type="text/javascript"></script>
	<script src="/js/topic/ajax.js" type="text/javascript"></script>
	<script src="/js/topic/sidebar.js" type="text/javascript"></script>
	<script src="/js/topic/main.js" type="text/javascript"></script>
</body>

</html>