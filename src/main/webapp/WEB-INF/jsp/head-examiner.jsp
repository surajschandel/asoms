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
									<a href="#" class="add" title="Add"
										data-toggle="Add Scanning Location"><i
										class="material-icons">add</i></a> <a href="#" class="import"
										title="Import" data-toggle="Import Scanning Location"><i
										class="material-icons">file_download</i></a> <a href="#"
										class="export" title="Export"
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
									<th style="width: 2%;">#</th>
									<th>Name</th>
									<th>Designation</th>
									<th>Email Id</th>
									<th>Phone No.</th>
									<th>School Name</th>
									<th>User Name</th>
									<th>Center Code</th>
									<th style="width: 8%;">Actions</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>1</td>
									<td>Thomas Hardy</td>
									<td>89 Chiaroscuro Rd.</td>
									<td>Thomas Hardy</td>
									<td>89 Chiaroscuro Rd.</td>
									<td>Thomas Hardy</td>
									<td>89 Chiaroscuro Rd.</td>
									<td>Thomas Hardy</td>
									<td><a href="#" class="edit" title="Edit"
										data-toggle="tooltip"><i class="material-icons">&#xE254;</i></a>
										<a href="#" class="delete" title="Delete"
										data-toggle="tooltip"><i class="material-icons">&#xE872;</i></a>
									</td>
								</tr>
								<tr>
									<td>2</td>
									<td>Maria Anders</td>
									<td>Obere Str. 57</td>
									<td>Maria Anders</td>
									<td>Obere Str. 57</td>
									<td>Maria Anders</td>
									<td>Obere Str. 57</td>
									<td>Maria Anders</td>
									<td><a href="#" class="edit" title="Edit"
										data-toggle="tooltip"><i class="material-icons">&#xE254;</i></a>
										<a href="#" class="delete" title="Delete"
										data-toggle="tooltip"><i class="material-icons">&#xE872;</i></a>
									</td>
								</tr>
								<tr>
									<td>3</td>
									<td>Fran Wilson</td>
									<td>C/ Araquil, 67</td>
									<td>Maria Anders</td>
									<td>Obere Str. 57</td>
									<td>Maria Anders</td>
									<td>Obere Str. 57</td>
									<td>Maria Anders</td>
									<td><a href="#" class="edit" title="Edit"
										data-toggle="tooltip"><i class="material-icons">&#xE254;</i></a>
										<a href="#" class="delete" title="Delete"
										data-toggle="tooltip"><i class="material-icons">&#xE872;</i></a>
									</td>
								</tr>
								<tr>
									<td>4</td>
									<td>Dominique Perrier</td>
									<td>25, rue Lauriston</td>
									<td>Maria Anders</td>
									<td>Obere Str. 57</td>
									<td>Maria Anders</td>
									<td>Obere Str. 57</td>
									<td>Maria Anders</td>
									<td><a href="#" class="edit" title="Edit"
										data-toggle="tooltip"><i class="material-icons">&#xE254;</i></a>
										<a href="#" class="delete" title="Delete"
										data-toggle="tooltip"><i class="material-icons">&#xE872;</i></a>
									</td>
								</tr>
								<tr>
									<td>5</td>
									<td>Martin Blank</td>
									<td>Via Monte Bianco 34</td>
									<td>Maria Anders</td>
									<td>Obere Str. 57</td>
									<td>Maria Anders</td>
									<td>Obere Str. 57</td>
									<td>Maria Anders</td>
									<td><a href="#" class="edit" title="Edit"
										data-toggle="tooltip"><i class="material-icons">&#xE254;</i></a>
										<a href="#" class="delete" title="Delete"
										data-toggle="tooltip"><i class="material-icons">&#xE872;</i></a>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
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
</body>

</html>
