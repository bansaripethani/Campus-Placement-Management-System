<%-- 
    Document   : index
    Created on : 16 Oct, 2008, 12:44:25 PM
    Author     : root
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Authentication Page</title>
          <meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Transit Login Form template Responsive, Login form web template,Flat Pricing tables,Flat Drop downs  Sign up Web Templates, Flat Web Templates, Login sign up Responsive web template, SmartPhone Compatible web template, free WebDesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- Custom Theme files -->
<link href="./loginresources/css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href="./loginresources/css/font-awesome.css" rel="stylesheet"> <!-- Font-Awesome-Icons-CSS -->

<!-- //Custom Theme files -->
<!-- web font --> 
<link href="//fonts.googleapis.com/css?family=Acme" rel="stylesheet"> 
    </head>
    <body>

 	<div class="main">
<!--		<h1>Transit Login Form</h1>-->
		<div class="main-w3lsrow">
			<!-- login form -->
			<div class="login-form login-form-left"> 
				<div class="agile-row">
					<h2>Login Form</h2> 
                                        <% if(request.getAttribute("error")!=null) {%>
        <div style="color:red"> ** <%=request.getAttribute("error")%></div>
        <% } %>
					<div class="login-agileits-top"> 	
						<form method="post"> 
							<p>User Name </p>
							<input type="text" class="name" name="username" />
							<p>Password</p>
							<input type="password" class="password" name="password" />  
<!--							<label class="anim">
								<input type="checkbox" class="checkbox">
								<span> Remember me ?</span> 
							</label>   -->
<!--                                			<input type="submit" value="Login"> -->
                                                        <input type="submit" name="submit" value="submit"/>
						</form> 	
					</div> 
<!--					<div class="login-agileits-bottom"> 
						<h6><a href="#">Forgot password?</a></h6>
					</div> -->
					<div class="login-agileits-bottom1"> 
						<h3>(or)</h3>

					</div> 
					<div class="social_icons agileinfo">
						<ul class="top-links">
									<li><a href="#"><i class="fa fa-facebook"></i></a></li>
									<li><a href="#"><i class="fa fa-twitter"></i></a></li>
									<li><a href="#"><i class="fa fa-linkedin"></i></a></li>
									<li><a href="#"><i class="fa fa-google-plus"></i></a></li>
								</ul>
					</div>
                                        <div class="login-agileits-bottom"> 
                                            <h6>Don't have an Account?<a href="register.xhtml">Sign Up</a></h6>
					</div> 
 
				</div>  
			</div>  
		</div>	
		<!-- copyright -->
		<div class="copyright">
<!--			<p> © 2017 Transit Login Form. All rights reserved | Design by <a href="http://w3layouts.com/" target="_blank">W3layouts</a></p>-->
		</div>
		<!-- //copyright --> 
	</div>
        
<!--        <form method="POST">
            <table>
                <tr>
                    <td colspan="2">Login:</td>
                </tr>
                <tr>
                    <td>User Name:</td>
                    <td><input type="text" name="username"/></td>
                </tr>

                <tr>
                    <td>Password:</td>
                    <td><input type="password" name="password"/></td>
                </tr>
                <tr>
                    <td><input type="submit" name="submit" value="submit"/></td>
                    <td><input type="reset"/></td>
                </tr>
            </table>
        </form>-->

        <br>
        <% if(request.getAttribute("error")!=null) {%>
        <div style="color:red"> ** <%=request.getAttribute("error")%></div>
        <% } %>
        
     
    </body>
</html>