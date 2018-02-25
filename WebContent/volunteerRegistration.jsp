<!DOCTYPE html>
<html lang="en">
<head>
<title>PrismVMS</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Teach For India , PrismVMS " />
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
<style>
.tab{

width:100%;
}

.key input[type="text"],.key input[type="password"] {
    padding: 10px;
  width: 85%;
  font-size: 17px;
  font-family: Raleway;
  border: none;
}
select
{
  padding: 10px;
  width: 82%;
  font-size: 17px;
  font-family: Raleway;
  border: none; 
}
textarea
{
width:85%;

}
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
			
			<div class="clearfix"></div>
		</div>
	</div>
</div> 
	<div class="login">
	
		<div class="main-agileits">
				<div class="form-w3agile">
					<h4 style="font-size:30px;">Volunteer Registration</h4><br>
					<form id="regForm" action="Control?action=addVolunteerRegistration" method="post" style="">  
						<div class="tab">
					 		 <div class="key input-group">
								<span class="input-group-addon"><i class="fa fa-user " aria-hidden="true"></i></span>
								<input  type="text"  name="fullName"  required=""  placeholder="Full Name" class="form-control">
								<div class="clearfix"></div>
							</div> 
							<div class="key input-group">
								<span class="input-group-addon"><i class="fa fa-envelope" aria-hidden="true"></i></span>
								<input  type="email"  name="email"  required=""  placeholder="Email" class="form-control" id="email">
								<div class="clearfix"></div>
							</div>
							<div class="key input-group">
								<span class="input-group-addon"><i class="fa fa-phone" aria-hidden="true"></i></span>
								<input  type="text"  name="phone"  required=""  placeholder="Mobile No." class="form-control" id="phone">
								<div class="clearfix"></div>
							</div>
							<div class="key input-group">
								<span class="input-group-addon"><i class="fa fa-lock" aria-hidden="true"></i></span>
								<input  type="password"  name="password" required placeholder="Password" class="form-control" value="" id="password">
								<div class="clearfix"></div>
							</div>
							<div class="key input-group">
								<span class="input-group-addon"><i class="fa fa-lock" aria-hidden="true"></i></span>
								<input  type="password" name="Confirm Password" required placeholder="Confirm Password" class="form-control" value="" id="confirmPassword">
								<div class="clearfix"></div>
							</div>
						</div>
						<div class="tab">
					  		  
							<div class="key">
								<i class="fa fa-group" aria-hidden="true"></i>
								<select name="gender" required  >
									<option value="">Select Your Gender</option>
									<option>Male</option>
									<option>Female</option>
									<option>Other</option> 
									<option>Prefer not to say</option> 
								</select>
								<div class="clearfix"></div>
							</div> 
							 <div class="key"  >   				
								<i class="fa fa-paragraph" aria-hidden="true"></i> 
								<textarea height="auto;" placeholder="Why do you wish to join as a volunteer" oninput="this.className = ''" style="height:135px;" name="whyVolunteer" required></textarea>
								<div class="clearfix"></div>
							</div>  
							 
						</div> 
					  <div style="overflow:auto;">
					    <div style="float:left;">
					      <button type="button" id="prevBtn" onclick="nextPrev(-1)" class="btn btn-primary">Prev</button>      
					    </div>
					    <div style="float:right;">
					      <button type="button" id="nextBtn" onclick="nextPrev(1)" class="btn btn-primary">Next</button> 
					    </div> 
					  </div>
					  
					  <!-- Circles which indicates the steps of the form: -->
					  <div style="text-align:center;margin-top:40px;">
					    <span class="step"></span>
					    <span class="step"></span> 
					  </div>
				</form> 
				</div>
				<div class="forg">
					  
					<a href="volunteerLogin.jsp" class="forg-right"><span>Already a member? &nbsp;</span>Sign In</a>
					 
				<div class="clearfix"></div>
				</div>
			</div>
		</div>
		 <br><br><br> 
<div class="footer" style="background-color:#f8f8f8;   height:50px;">
	 <p class="copy-right">© 2018 PrismVMS. All rights reserved | Design by <a href="#">Kapil Thakur & Anurag Goel</a></p>
</div> 
	  
	 
	
<div id="snackbar"></div>
	
	
		
<script>
var currentTab = 0; // Current tab is set to be the first tab (0)
showTab(currentTab); // Display the crurrent tab

function showTab(n) {
  // This function will display the specified tab of the form...
  var x = document.getElementsByClassName("tab");
  x[n].style.display = "block";
  //... and fix the Previous/Next buttons:
  if (n == 0) {
    document.getElementById("prevBtn").style.display = "none";
  } else {
    document.getElementById("prevBtn").style.display = "inline";
  }
  if (n == (x.length - 1)) {
    document.getElementById("nextBtn").innerHTML = "Next";
  } else {
    document.getElementById("nextBtn").innerHTML = "Next";
  }
  //... and run a function that will display the correct step indicator:
  fixStepIndicator(n)
}

function nextPrev(n) {
  // This function will figure out which tab to display
  var x = document.getElementsByClassName("tab");
  // Exit the function if any field in the current tab is invalid:
  if (n == 1 && !validateForm()) return false;
  // Hide the current tab:
  x[currentTab].style.display = "none";
  // Increase or decrease the current tab by 1:
  currentTab = currentTab + n;
  // if you have reached the end of the form...
  if (currentTab >= x.length) {
    // ... the form gets submitted:
    document.getElementById("regForm").submit();
    return false;
  }
  // Otherwise, display the correct tab:
  showTab(currentTab);
}

function validateForm() {
  // This function deals with validation of the form fields
  var valid=true; 

  var x, y, i;
  x = document.getElementsByClassName("tab");
  y = x[currentTab].getElementsByTagName("input");
  // A loop that checks every input field in the current tab:
  for (i = 0; i < y.length; i++) {
    // If a field is empty...
    if (y[i].value == "") {
      // add an "invalid" class to the field:
      y[i].className += " invalid";
      // and set the current valid status to false
      valid = false;
    } 
  }
	var emailRe = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	var phoneRe= /^\d{10}$/;
	var email=document.getElementById("email");
	var phone=document.getElementById("phone");
	if(!emailRe.test(email.value)){
		var x = document.getElementById("snackbar"); 
    x.className = "show";
    x.innerHTML="Please enter a valid email address";
    setTimeout(function(){ x.className = x.className.replace("show", ""); }, 3000);
	    valid=false;
	}
	if(!phoneRe.test(phone.value)){
		var x = document.getElementById("snackbar"); 
    x.className = "show";
    x.innerHTML="Please enter a valid phone number";
    setTimeout(function(){ x.className = x.className.replace("show", ""); }, 3000);
	    valid=false;
	}
	var password = document.getElementById("password")
, confirm_password = document.getElementById("confirmPassword");
  if(password.value != confirm_password.value) {
		var x = document.getElementById("snackbar"); 
    x.className = "show";
    x.innerHTML="Password does not match";
    setTimeout(function(){ x.className = x.className.replace("show", ""); }, 3000);
	    valid=false;
	  }
	if(password.value.length < 6) {
		var x = document.getElementById("snackbar");
		x.className = "show";
    x.innerHTML="Password should be longer than 6 characters";
    setTimeout(function(){ x.className = x.className.replace("show", ""); }, 3000);
        
        valid=false;
      }

  
  // If the valid status is true, mark the step as finished and valid:
  if (valid) {
    document.getElementsByClassName("step")[currentTab].className += " finish";
  }
  return valid; // return the valid status
}


function fixStepIndicator(n) {
  // This function removes the "active" class of all steps...
  var i, x = document.getElementsByClassName("step");
  for (i = 0; i < x.length; i++) {
    x[i].className = x[i].className.replace(" active", "");
  }
  //... and adds the "active" class on the current step:
  x[n].className += " active";
}
</script>
<div id="snackbar"></div>

 <% 
 String action =request.getParameter("action");
 if(action==null){
 
 }else if(action!=null)
 {
	 
  
  %><%if(action.equals("AlreadyRegistered")){ 
 %>
	 <script>
 
    var x = document.getElementById("snackbar")
    x.className = "show";
    x.innerHTML="You have already register with us";
    setTimeout(function(){ x.className = x.className.replace("show", ""); }, 3000);
 
</script>
<%}}%>
	
</body>
</html>