<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Required meta tags-->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="author" content="Suraj Singh">

    <!-- Title Page-->
    <title>Scanning Location - Answer Script On Screen Marking System</title>

    <!-- Icons font CSS-->
    <link href="${pageContext.request.contextPath}/vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">
    <link href="${pageContext.request.contextPath}/vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <!-- Font special for pages-->
    <link href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i" rel="stylesheet">

    <!-- Vendor CSS-->
    <link href="${pageContext.request.contextPath}/vendor/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="${pageContext.request.contextPath}/vendor/datepicker/daterangepicker.css" rel="stylesheet" media="all">

    <!-- Main CSS-->
    <link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet" media="all">
    
    
</head>

<body onunload="window.opener.reload();">
    <div class="page-wrapper bg-blue p-t-100 p-b-100 font-robo">
        <div class="wrapper wrapper--w680">
            <div class="card card-1">
                <div class="card-heading"></div>
                <div class="card-body">
                    <h2 class="title">Scanning Location Info</h2>
                    
                    <h2 class="title" style="color: green;">${success}</h2>
                    <h2 class="title" style="color: red;">${error}</h2>
                    <form:form method="POST" action="/save-location" command="command">
                        <div class="input-group">
                            <form:input class="input--style-1" type="text" placeholder="SCANNING LOCATION NAME" path="locationName"/>
                            <form:hidden path="id"/>
                        </div>
                        <div class="row row-space">
                            <div class="col-2">
                                <div class="input-group">
                                    <form:input class="input--style-1" type="text" placeholder="SCANNING LOCATION CODE" path="locationCode"/>
                                </div>
                            </div>
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
    <script src="${pageContext.request.contextPath}/vendor/jquery/jquery.min.js"></script>
    <!-- Vendor JS-->
    <script src="${pageContext.request.contextPath}/vendor/select2/select2.min.js"></script>
    <script src="${pageContext.request.contextPath}/vendor/datepicker/moment.min.js"></script>
    <script src="${pageContext.request.contextPath}/vendor/datepicker/daterangepicker.js"></script>

    <!-- Main JS-->
    <script src="${pageContext.request.contextPath}/js/global.js"></script>

</body>

</html>
<!-- end document-->
