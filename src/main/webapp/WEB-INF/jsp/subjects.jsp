<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html class="no-js" lang="en">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Subjects - Answer Script On Screen Marking System</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">

<%@include file="common/include.jsp"%>
<script>
	$(document).ready(function() {
		// Activate tooltips
		$('[data-toggle="tooltip"]').tooltip();

		// Filter table rows based on searched term
		$("#search").on("keyup", function() {
			var term = $(this).val().toLowerCase();
			$("table tbody tr").each(function() {
				$row = $(this);
				var name = $row.find("td:nth-child(2)").text().toLowerCase();
				console.log(name);
				if (name.search(term) < 0) {
					$row.hide();
				} else {
					$row.show();
				}
			});
		});
	});
	 function mypopup(url) {
         width = window.screen.width;
         height = window.screen.height;
         mywindow = window.open(url, "Title",
             "location=0,status=1,scrollbars=1,resizable=1,menubar=0,toolbar=no,width="
                         + width + ",height=" + height);
         mywindow.moveTo(0, 0);
         mywindow.focus();
     }
	 function openForm() {
		  document.getElementById("uploadForm").style.display = "block";
		}

		function closeForm() {
		  document.getElementById("uploadForm").style.display = "none";
		}
</script>
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
						<h3>Subjects</h3>
						<h2 class="title" style="color: green;">${success}</h2>
                    <h2 class="title" style="color: red;">${error}</h2>
					</div>
				</div>
			</div>
			<div class="row" style="margin: 2px;">
				<div class="table-responsive">
					<div class="table-wrapper">
						<div class="table-title">
							<div class="row">
								<div class="col-sm-6 action-icon">
									<a href="#" onclick='mypopup("/add-subject");return false;'
										class="add" title="Add" data-toggle="Add Subjects"><i
										class="material-icons">add</i></a> <a href="#" class="import"
										title="Import" data-toggle="Import Subjects"> <i
										class="material-icons">file_download</i></a> <a href="#"
										onclick="openForm()" class="export" title="Export"
										data-toggle="Export Subjects"> <i
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
									<th style="width: 40%;">Subject Name</th>
									<th style="width: 40%;">Subject Code</th>
									<th style="width: 10%;">Actions</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${subjects}" var="sub" varStatus="loop">
									<tr>
										<td>${loop.index+1}</td>
										<td>${sub.subjectName}</td>
										<td>${sub.subjectCode}</td>
										<td><a href="#"
											onclick='mypopup("/edit-subject/${sub.id}");return false;'
											class="edit" title="Edit" data-toggle="tooltip"><i
												class="material-icons">&#xE254;</i></a> <a href="#"
											onclick="javascript:deleteSubject(${sub.id});return false;"
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
			method="post" id="subjectUploadForm">
			<h1>Upload File</h1>
			<input type="file" name="file" id="file" placeholder="Select file"
				required="required"> <input type="submit" class="btn"
				id="ajaxCallUpload" value="Upload" />
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
