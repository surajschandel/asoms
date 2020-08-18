<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<!-- Required meta tags-->
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="author" content="Suraj Singh">

<!-- Title Page-->
<title>Evaluation Center - Answer Script On Screen Marking
	System</title>

<!-- Icons font CSS-->
<link
	href="${pageContext.request.contextPath}/vendor/mdi-font/css/material-design-iconic-font.min.css"
	rel="stylesheet" media="all">
<link
	href="${pageContext.request.contextPath}/vendor/font-awesome-4.7/css/font-awesome.min.css"
	rel="stylesheet" media="all">
<!-- Font special for pages-->
<link
	href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i"
	rel="stylesheet">

<!-- Vendor CSS-->
<link
	href="${pageContext.request.contextPath}/vendor/select2/select2.min.css"
	rel="stylesheet" media="all">
<link
	href="${pageContext.request.contextPath}/vendor/datepicker/daterangepicker.css"
	rel="stylesheet" media="all">

<!-- Main CSS-->
<link href="${pageContext.request.contextPath}/css/main.css"
	rel="stylesheet" media="all">


</head>

<body onunload="window.opener.reload();">
	<div class="page-wrapper bg-blue p-t-100 p-b-100 font-robo">
		<div class="wrapper wrapper--w680">
			<div class="card card-1">
				<div class="card-heading"></div>
				<div class="card-body">
					<h2 class="title">Evaluation Center Info</h2>

					<h2 class="title" style="color: green;">${success}</h2>
					<h2 class="title" style="color: red;">${error}</h2>
					<form:form method="POST" action="/save-center" command="command">
						<div class="input-group">
							<form:input class="input--style-1" type="text"
								placeholder="CENTER NAME" path="centerName" />
							<form:hidden path="id" />
						</div>

						<div class="input-group">
							<form:input class="input--style-1" type="text"
								placeholder="CENTER CODE" path="centerCode" />
						</div>

						<div class="input-group">
							<div class="rs-select2 js-select-simple select--no-search">
								<form:select path="locationCode">
									<form:option value="">LOCATION CODE</form:option>
									<c:forEach items="${locations}" var="l">
										<form:option value="${l.locationCode}"> ${l.locationName }</form:option>
									</c:forEach>
								</form:select>
								<div class="select-dropdown"></div>
							</div>
						</div>
						<div class="input-group">
							<form:input class="input--style-1" type="text"
								placeholder="CONTACT PERSON" path="contactPerson" />
						</div>

						<div class="input-group">
							<form:input class="input--style-1" type="text"
								placeholder="ADDRESS" path="address" />
						</div>
						<div class="input-group">
							<form:input class="input--style-1" type="text"
								placeholder="PIN CODE" path="pinCode" />
						</div>
						<div class="input-group">
							<form:input class="input--style-1" type="text"
								placeholder="PHONE NO" path="phoneNo" />
						</div>
						<div class="input-group">
							<form:input class="input--style-1" type="text"
								placeholder="EMAIL ID" path="emailId" />
						</div>
						<div class="p-t-20">
							<button class="btn btn--radius btn--green" type="submit">Submit</button>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>

	<!-- Jquery JS-->
	<script
		src="${pageContext.request.contextPath}/vendor/jquery/jquery.min.js"></script>
	<!-- Vendor JS-->
	<script
		src="${pageContext.request.contextPath}/vendor/select2/select2.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/vendor/datepicker/moment.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/vendor/datepicker/daterangepicker.js"></script>

	<!-- Main JS-->
	<script src="${pageContext.request.contextPath}/js/global.js"></script>

</body>

</html>
<!-- end document-->
