<!DOCTYPE html>
<html lang="en">
<head>
<title>Fashion Club an Ecommerce Online Shopping Category  Flat Bootstrap responsive Website Template | Login :: w3layouts</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Fashion Club Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
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
</head>
<style>
body{
overflow-x:hidden;
}

</style>
<body>
  <div class="outercontainer">
	<div class="header-bottom-w3ls">  
		<div class="row">
			<div class="col-md-2 logo-w3">
				<a href="index.jsp"><img src="images/logo2.png" alt=" " /> </a>
				<div class="clearfix"></div>
			</div>
			  
			<div class="col-md-8 navigation-agileits" style=" text-align: center;">
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
							<li><a href="about.html" class="hyper"><span>About</span></a></li>						
							<li><a href="contact.jsp" class="hyper"><span>Contact Us</span></a></li>
						</ul>
					</div>
				</nav>
			</div>
		  <script>
				$(document).ready(function(){
					$(".dropdown").hover(            
						function() {
							$('.dropdown-menu', this).stop( true, true ).slideDown("fast");
							$(this).toggleClass('open');        
						},
						function() {
							$('.dropdown-menu', this).stop( true, true ).slideUp("fast");
							$(this).toggleClass('open');       
						}
					);
				});
			</script>  
			<div class="col-md-2 cart-wthree">  
				<form action="CustomerRegister.html" method="post"  style="float: right; display: inline-block; margin-right:40px;    "  > 
					<input type="hidden" name="cmd" value="_cart" />
					<input type="hidden" name="display" value="1" />
					<button class="w3view-cart" type="submit" name="submit" value=""><i class="fa fa-user-plus" aria-hidden="true"></i></button>
				</form>   	 
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
</div> 
	<div class="login"> 
		<div class="main-agileits">
				<div class="form-w3agile">
				<% String action = request.getParameter("action");%>
						<%if(action == null){ %>
					<h3>Verify Email</h3>
					<form action="Control?action=mentorForgotPassword" method="post">
					
						<div class="key">
							<i class="fa fa-envelope" aria-hidden="true"></i>
							<input  type="text" name="email" required="true" placeholder="Email">
							<div class="clearfix"></div>
						</div>
						<input type="submit" value="Get OTP">
						 </form>
						<%}else if(action.equals("otpVarification") || action.equals("otpIsNotCorrect")){
							String email = request.getParameter("email");
							
						%>
						<h3>Set Password</h3>
						<form action="Control?action=forgotOtpVerification" method="post">
							<div class="key">
								<i class="fa fa-envelope" aria-hidden="true"></i>
								<input  type="text" readonly name="email" value="<%=email%>" required="true" placeholder="Email">
								<div class="clearfix"></div>
							</div>
							<div class="key">
								<i class="fa fa-mobile-phone" aria-hidden="true"></i>
								<input  type="text" name="otp" required="true" placeholder="OTP">
								<div class="clearfix"></div>
							</div>
							<div class="key">
								<i class="fa fa-lock" aria-hidden="true"></i>
								<input  type="password" name="password" required="true" placeholder="New Password">
								<div class="clearfix"></div>
							</div>
							<div class="key">
								<i class="fa fa-lock" aria-hidden="true"></i>
								<input  type="password" name="confirmPassword" required="true" placeholder="Confrim Password">
								<div class="clearfix"></div>
							</div>
							
						
						<input type="submit" value="Set Password">
					  <%} %>
					</form>
				</div>
				<div class="forg">
					<a href="adminLogin.jsp" class="forg-left">Login</a>
					 
				<div class="clearfix"></div>
				</div>
			</div>
		</div>

<br><br><br> 
<div class="footer" style="background-color:#f8f8f8;   height:50px;">
	 <p class="copy-right">� 2018 PrismVMS. All rights reserved | Design by <a href="#">Kapil Thakur & Anurag Goel</a></p>
</div> 
	  
<div id="snackbar"></div>
 <%  
 if(action==null){
 
 }else if(action!=null)
 { 
  
  if(action.equals("PasswordAndConfirmPasswordNotMactched")){ 
 %>
<script>
 
    var x = document.getElementById("snackbar")
    x.className = "show";
    x.innerHTML="Password and Confrim Password Does Not Match";
    setTimeout(function(){ x.className = x.className.replace("show", ""); }, 3000);
 
</script>
<%}else if(action.equals("otpVarification")){ 
	 %>
	 <script>
	  
	     var x = document.getElementById("snackbar")
	     x.className = "show";
	     x.innerHTML="Please check OTP on Your Registered Email Id";
	     setTimeout(function(){ x.className = x.className.replace("show", ""); }, 3000);
	  
	 </script>
	 <%}else if(action.equals("otpIsNotCorrect")){ 
 %>
<script>
 
    var x = document.getElementById("snackbar")
    x.className = "show";
    x.innerHTML="OTP is Wrong";
    setTimeout(function(){ x.className = x.className.replace("show", ""); }, 3000);
 
</script>
<%} else if(action.equals("OtpExpired")){ 
 %>
<script>
 
    var x = document.getElementById("snackbar")
    x.className = "show";
    x.innerHTML="Your OTP is Expired";
    setTimeout(function(){ x.className = x.className.replace("show", ""); }, 3000);
 
</script>
<%}%>
  
<% } %>
   
	 
</body>
</html>