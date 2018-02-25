<!DOCTYPE html>
<html lang="en">
<head>
<title>PrismVMS</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Teach For India , PrismVMS "nyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- css -->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
<link rel="stylesheet" href="css/font-awesome.min.css" type="text/css" media="all" />
<!--// css -->
<!-- font -->
<link href="//fonts.googleapis.com/css?family=Source+Sans+Pro" rel="stylesheet">
<link href='//fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
<!-- //font -->
<script src="js/jquery-1.11.1.min.js"></script>
<script src="js/bootstrap.js"></script>
<link rel="shortcut icon" href="images/logo2_.ico" />
<style type="text/css">
	body
	{
	overflow-x:hidden;
	}
</style>
</head>

<body>
<div class="outercontainer">
	<div class="header-bottom-w3ls">  
		<div class="row">
			<div class="col-md-2 logo-w3">
				<a href="index.jsp"><img src="images/logo2.png" alt=" " /> </a>
				<div class="clearfix"></div>
			</div> 
			<div class="col-md-8 navigation-agileits">
				<nav class="navbar navbar-default">
					<div class="navbar-header nav_2">
						<button type="button" class="navbar-toggle collapsed navbar-toggle1" data-toggle="collapse" data-target="#bs-megadropdown-tabs">
							<span class="sr-only">Toggle navigation</span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
					</div> 
					<div class="collapse navbar-collapse" id="bs-megadropdown-tabs">
						<ul class="nav navbar-nav ">
							<li><a href="index.jsp" class="hyper "><span>Home</span></a></li>	
							<li class=" active"><a href="about.html" class="hyper"><span>About</span></a></li>
							<li ><a href="contact.jsp" class="hyper"><span>Contact Us</span></a></li>
							<li class=" "><a href="faq.jsp" class="hyper"><span>FAQ</span></a></li>
						 </ul>
					</div>
				</nav>
			</div>  
			  
			  	    
			<div class="clearfix"></div>
		</div>
	</div>
</div>	 
	<div class="login">
		<div class="main-agileits">
				<div class="form-w3agile">
					<h3>Login</h3>
					<form action="VolunteerLogin" method="post">
						<div class="key input-group">
							<span class="input-group-addon"><i class="fa fa-envelope" aria-hidden="true"></i></span>
							<input  type="text" name="email" required="" placeholder="Email" class="form-control">
							<div class="clearfix"></div>
						</div>
						<div class="key input-group">
							<span class="input-group-addon"><i class="fa fa-lock" aria-hidden="true"></i></span>
							<input  type="password" name="password" required="" placeholder="Password" class="form-control">
							<div class="clearfix"></div>
						</div>
						<input type="submit" value="Login">
					</form>
				</div>
				<div class="forg">
					<a href="volunteerForgotPassword.jsp" class="forg-left">Forgot Password</a>
					<a href="volunteerRegistration.jsp" class="forg-right">Register</a>
				<div class="clearfix"></div>
				</div>
			</div>
		</div> 
<!--team-->
 <hr style="color:#eee; height:15px;">
<div class="footer">
	<div class="container">
		<div class="col-md-3 footer-grids fgd1">
		<a href="index.jsp"><img src="images/logo2.png" alt=" " /> </a>
		<ul>
			<li>Christ University</li>
			<li>Bangalore-560029</li>
			<li><a href="mailto:info@example.com">prismhack@gmail.com</a></li>
			<a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a>
			<a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a>
			<a href="#"><i class="fa fa-linkedin" aria-hidden="true"></i></a>
		</ul>
		</div>
		<div class="col-md-3 footer-grids fgd2">
			<h4>Information</h4> 
			<ul>
				<li><a href="contact.jsp">Contact Us</a></li>
				<li><a href="about.html">About</a></li>
				<li><a href="faq.jsp">FAQ's</a></li>
			</ul>
		</div>
		<div class="col-md-3 footer-grids fgd4">
			<h4>My Account</h4> 
			<ul>
				<li><a href="volunteerRegistration.jsp">Volunteer Registration</a></li>
				<li><a href="volunteerLogin.jsp">Volunteer Login</a></li>
				<li><a href="adminLogin.jsp">Mentor Login</a></li>
				<li><a href="volunteerPreLogin.jsp">Volunteer Application Status</a></li>
		
			</ul>
		</div>
		<div class="clearfix"></div>
		 </div>
</div>

	 <div class="footer" style="background-color:#2A3F54;   height:50px;">
	 <p class="copy-right">� 2018 PrismVMS. All rights reserved | Design by <a href="#">Kapil Thakur & Anurag Goel</a></p>
</div>  
	  
<div id="snackbar"></div>

 <% 
 String action =request.getParameter("action");
 if(action==null){
 
 }else if(action!=null)
 {
	 
  
  %><%if(action.equals("useNewPassword")){ 
 %>
	 <script>
 
    var x = document.getElementById("snackbar")
    x.className = "show";
    x.innerHTML="Use New Password to Login";
    setTimeout(function(){ x.className = x.className.replace("show", ""); }, 3000);
 
</script>
<%}else if(action.equals("AccountDoesNotExist")){ 
 %>
	 <script>
 
    var x = document.getElementById("snackbar")
    x.className = "show";
    x.innerHTML="Your Account Does not Exist";
    setTimeout(function(){ x.className = x.className.replace("show", ""); }, 3000);
 
</script>
<%}else if(action.equals("UserNotValid")){ 
 %>
	 <script>
 
    var x = document.getElementById("snackbar")
    x.className = "show";
    x.innerHTML="Email or Password is Incorrect";
    setTimeout(function(){ x.className = x.className.replace("show", ""); }, 3000);
 
</script>
<%}else if(action.equals("NotVolunteer")){ 
 %>
	 <script>
 
    var x = document.getElementById("snackbar")
    x.className = "show";
    x.innerHTML="Your Account has been Archived. Please Check with Adminstrator";
    setTimeout(function(){ x.className = x.className.replace("show", ""); }, 3000);
 
</script>
<%}else if(action.equals("LoginAgain")){ 
 %>
	 <script>
 
    var x = document.getElementById("snackbar")
    x.className = "show";
    x.innerHTML="Your Session has been Expired Please Login Again!";
    setTimeout(function(){ x.className = x.className.replace("show", ""); }, 3000);
 
</script>
<%}%>
  
 <%}%>

</body>
</html>