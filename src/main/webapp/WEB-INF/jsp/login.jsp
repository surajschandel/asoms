<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html class="no-js" lang="en" >
    
<head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Login - Answer Script On Screen Marking System</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">

           <%@include file="common/include.jsp" %>
    </head>
    <body>
        <!--[if lt IE 8]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->

        <!-- Header Area Start -->
		<header class="top">
			<div class="header-area two header-sticky">
				<div class="container">
					<div class="row">
						<div class="col-md-4 col-sm-4 col-xs-6">
							
						</div>
						<div class="col-md-8 col-sm-8 col-xs-12" style="padding-left: 5%">
						<div class="logo">
								<a href="#"><img src="img/logo/logo.png" alt="asoms" /></a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</header>
        <!-- Login start -->
        <div class="login-area pt-30 pb-90">
            <div class="container">
                <div class="row">
                    <div class="col-md-6 col-md-offset-3 text-center">
                        <div class="login">
                            <div class="login-form-container">
                                <div class="login-text">
                                    <h2>login</h2>
                                    <span>Please login using account detail bellow.</span>
                                </div>
                                <div class="login-form">
                                    <form action="/login" method="post">
                                        <input type="text" name="username" id="username" placeholder="UserName">
                                        <input type="password" name="password" id="password" placeholder="Password">
                                        <div class="button-box">
                                            <div class="login-toggle-btn">
                                                <input type="checkbox" id="remember">
                                                <label for="remember">Remember me</label>
                                                <a href="#">Forgot Password?</a>
                                            </div>
                                            <button type="submit" class="default-btn">Login</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Login end --> 
        <!-- Footer Start -->
        <footer>
        <div class="footer-bottom text-center">
                <div class="container">
                    <div class="row">
                        <div class="col-xs-12">
                            <p>Copyright © <a href="#" target="_blank">LakeACR</a> 2017. All Right Reserved By LakeACR.</p>
                        </div> 
                    </div>
                </div>    
            </div>
        </footer>
        <!-- Footer End -->

    </body>

<!-- Mirrored from preview.hasthemes.com/eduhome/login.html by HTTrack Website Copier/3.x [XR&CO'2014], Sun, 26 Jul 2020 06:26:45 GMT -->
</html>
