<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html class="no-js" lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>ASOMS - Answer Script On Screen Marking System</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">

<%@include file="common/include.jsp"%>

</head>
<body>
	<!-- Header Area Start -->
	<%@include file="common/header.jsp"%>
	<!-- Header Area End -->
	<div class="pt-150 pb-10">
		<div class="container">
			<div class="row">
				<div class="col-xs-12">
					<div class="course-title">
						<h3>Scanning Location</h3>
					</div>
				</div>
			</div>
			<div class="row" style="margin: 2px;">
				<div class="table-responsive">
					<div class="table-wrapper">
						<div class="table-title">
							<div class="row">
								<div class="col-sm-6 action-icon">
									<a href="#" class="add" title="Add" onclick='mypopup("/add-location");return false;'
										data-toggle="Add Scanning Location"><i
										class="material-icons">add</i></a> <a href="#" id="exportLocationsReportInExcel" class="import"
										title="Import" data-toggle="Import Scanning Location"><i
										class="material-icons">file_download</i></a> <a href="#"
										onclick="openForm()" class="export" title="Export"
										data-toggle="Export Scanning Location"><i
										class="material-icons">file_upload</i></a>
								</div>
								<div class="col-sm-6">
									<div class="search-box">
										<div class="input-group">
											<input type="text" id="search" class="form-control"
												placeholder="Search by Name"
												style="height: 39px !important;"> <span
												class="input-group-addon"><i class="material-icons">&#xE8B6;</i></span>
										</div>
									</div>
								</div>
							</div>
						</div>
						<table class="table table-striped">
							<thead>
								<tr>
									<th style="width: 10%;">#</th>
									<th style="width: 40%;">Location Name</th>
									<th style="width: 40%;">Location Code</th>
									<th style="width: 10%;">Actions</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${locations}" var="sub" varStatus="loop">
									<tr>
										<td>${loop.index+1}</td>
										<td>${sub.locationName}</td>
										<td>${sub.locationCode}</td>
										<td><a href="#"
											onclick='mypopup("/edit-location/${sub.id}");return false;'
											class="edit" title="Edit" data-toggle="tooltip"><i
												class="material-icons">&#xE254;</i></a> <a href="#"
											onclick="javascript:deleteLocation(${sub.id});return false;"
											class="delete" title="Delete" data-toggle="tooltip"><i
												class="material-icons">&#xE872;</i></a></td>
									</tr>
								</c:forEach>
								
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="form-popup" id="uploadForm">
		<form action="#" class="form-container" enctype="multipart/form-data"
			method="post" id="locationUploadForm">
			<h1>Upload File</h1>
			<input type="file" name="file" id="file" placeholder="Select file"
				required="required"> <input type="submit" class="btn"
				id="locationAjaxCallUpload" value="Upload" />
			<button type="button" class="btn cancel" onclick="closeForm()">Close</button>
		</form>
	</div>
	<!-- Footer Start -->

	<%@include file="common/footer.jsp"%>
	<!-- Footer End -->

	<script src="js/vendor/jquery-1.12.0.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.meanmenu.js"></script>
	<script src="js/jquery.magnific-popup.js"></script>
	<script src="js/ajax-mail.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/jquery.mb.YTPlayer.js"></script>
	<script src="js/jquery.nicescroll.min.js"></script>
	<script src="js/plugins.js"></script>
	<script src="js/main.js"></script>
	<script src="js/counter.js"></script>
	
	<script src="js/common.js"></script>
</body>

</html>
