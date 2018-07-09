<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=10">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Grouping management</title>

		<link rel="stylesheet" type="text/css" href="/css/d_main.css" />
		<link rel="stylesheet" type="text/css" href="/css/main.css" />
		<link rel="shortcut icon" href="/assets/pages/img/bmw-32.ico" />	
	</head>

	<body style="width: 100%; height: 100%; background: url(/image/d_bg.jpg) no-repeat 0 0; background-size: cover; background-attachment: fixed;">
		<div class="content">
			<div class="d_con">
				<div class="ma">
					<div class="dm_banner">
						<img src="/image/banner.png" class="dm_banner_banner" />
					</div>
				</div>
			</div>
		</div>
		<h1 class="bba-title" align="center">BBA Data Monitor</h1>
		<div class="menu-div">
			<ul class="menu-group">
				<li class="menu">
					<a href="report">Driver<br>Dashboard</a>
				</li>
				<li class="menu">
					<a href="vehicle">Vehicle<br>Information</a>
				</li>
				<li class="menu">
					<a href="transmission">Transmission<br>Statistics</a>
				</li>
				<li class="menu">
					<a href="history">History<br>Data</a>
				</li>	
				<li class="menu not-implemented">
					<a href="javascript:void(0);">Collection<br>Statistics</a>
				</li>				
				<li class="menu not-implemented">
					<a href="javascript:void(0);">Website<br>Administration</a>
				</li>								
			</ul>
		</div>
	</body>

</html>