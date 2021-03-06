<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html class="no-js" lang="en">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Head Examiner - Answer Script On Screen Marking System</title>
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
						<h3>Head Examiner</h3>
					</div>
				</div>
			</div>
			<div class="row" style="margin: 2px;">
				<div class="table-responsive">
					<div class="table-wrapper">
						<div class="table-title">
							<div class="row">
								<div class="col-sm-6 action-icon">
									<a href="#" onclick='mypopup("/add-head-examiner");return false;'
										class="add" title="Add" data-toggle="Add Head Examiner"><i
										class="material-icons">add</i></a> <a href="#"
										id="exportHeadExaminerReportInExcel" class="import" title="Import"
										data-toggle="Import Head Examiner"> <i class="material-icons">file_download</i></a>
									<a href="#" onclick="openForm()" class="export" title="Export"
										data-toggle="Export Head Examiner"> <i class="material-icons">file_upload</i></a>
										<a href="#" onclick="refreshForm()" class="refresh" title="Refresh"
										data-toggle="Refresh Page"> <i class="material-icons">refresh</i></a>
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
									<th style="width: 2%;">#</th>
									<th>Name</th>
									<th>Designation</th>
									<th>Email Id</th>
									<th>Phone No.</th>
									<th>School Name</th>
									<th>Location Name</th>
									<th>User Name</th>
									<th>Center Code</th>
									<th style="width: 8%;">Actions</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${headExaminers}" var="sub" varStatus="loop">
									<tr>
										<td>${loop.index+1}</td>
										<td>${sub.name}</td>
										<td>${sub.designation}</td>
										<td>${sub.emailId}</td>
										<td>${sub.phoneNo}</td>
										<td>${sub.schoolName}</td>
										<td>${sub.locations.locationName}</td>
										<td>${sub.userName}</td>
										<td>${sub.centers.centerCode}</td>
										<td><a href="#"
											onclick='mypopup("/edit-head-examiner/${sub.id}");return false;'
											class="edit" title="Edit" data-toggle="tooltip"><i
												class="material-icons">&#xE254;</i></a> <a href="#"
											onclick="javascript:deleteHeadExaminer(${sub.id});return false;"
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
			method="post" id="headExaminerUploadForm">
			<h1>Upload File</h1>
			<input type="file" name="file" id="file" placeholder="Select file"
				required="required"> <input type="submit" class="btn"
				id="headExaminerAjaxCallUpload" value="Upload" />
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
