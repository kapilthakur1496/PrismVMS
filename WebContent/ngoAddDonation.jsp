<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<html lang="en">
<head>
<title>Sarvahitkari | Add Donation</title>
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
<script src="js/kj.js"></script>
<style type="text/css">
 body
 {
 overflow-x:hidden; 
 }
#regForm {
  background-color: #ffffff;
  margin: 0px auto;
  font-family: Raleway;
  padding: 40px;
  width: 70%;
  min-width: 300px;
}

h1 {
  text-align: center;  
}

input {
    padding: 10px;
  width: 90%;
  font-size: 17px;
  font-family: Raleway;
  border: none;
}
select
{
  padding: 10px;
  width: 95.2%;
  font-size: 17px;
  font-family: Raleway;
  border: none; 
}

textarea
{
  padding: 10px;
  width: 90.2%;
  height:100px;
  font-size: 17px;
  font-family: Raleway;
  border: none; 
}
input [type='date'] {
  padding: 10px;
  width: 40%;
  font-size: 17px;
  font-family: Raleway;
  border: none;
}


/* Mark input boxes that gets an error on validation: */
input.invalid,select.invalid {
  background-color: #ffdddd;
}

 

button {
  background-color: #66bdd7;
  color: #ffffff;
  border: none;
  padding: 10px 20px;
  font-size: 17px;
  font-family: Raleway;
  cursor: pointer;
}

button:hover {
  opacity: 0.8;
}

#prevBtn {
  background-color: #66bdd7;
}

/* Make circles that indicate the steps of the form: */
.step {
  height: 15px;
  width: 15px;
  margin: 0 2px;
  background-color: #bbbbbb;
  border: none;  
  border-radius: 50%;
  display: inline-block;
  opacity: 1;
}

.step.active {
  opacity: 1;   
}
.step.finish {
  opacity: 1;
  background-color: #66bdd7;
}

</style>
</head>
<body>

<%@ page import="java.sql.*" %>
<%@page import="java.lang.reflect.Array"%>
<%@ page import ="javax.sql.*" %>
<%@ page import="com.daniel.util.control.*"  %> 
   <div class="outercontainer">
	<div class="header-bottom-w3ls">  
		<div class="row">
			<div class="col-md-2 logo-w3">
				<a href="index.jsp"><img src="images/logo2.png" alt=" " /> </a>
				<div class="clearfix"></div>
			</div> 
			<div class="col-md-7 navigation-agileits" style=" text-align: center;">
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
							<li class=" "><a href="index.jsp" class="hyper "><span>Home</span></a></li>	
							<li><a href="" class="hyper"><span>Category</span></a></li>	
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
			<div class="col-md-1 cart-wthree">  
				<form action="login.html" method="post"  style="float: right; display: inline-block; margin-right:40px;    "  > 
					<input type="hidden" name="cmd" value="_cart" />
					<input type="hidden" name="display" value="1" />
					<button class="w3view-cart" type="submit" name="submit" value=""><i class="fa fa-user" aria-hidden="true"></i></button>
				</form>   	 
			</div>
			<div class="col-md-2 cart-wthree">  
				<form action="ngoPreLogout.jsp" method="post"  style="float: right; margin-top:10px; display: inline-block; margin-right:40px;    "  > 
				 
					<button class="w3view-cart"  style="color:#66bdd7;" type="submit" name="submit"  > Sign Out </button>
				</form>   	 
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
</div> 
	  		 
  
<% try{ %>
  
	<%! String ngoStatus=null;
		ResultSet ngoDetail=null;
		String ngoId=null;
		Control ct = new Control();
	%>
	<% 
		ngoId= (String)session.getAttribute("ngoId"); 
		if(ngoId == null)
		{
			ngoId= (String)session.getAttribute("NgoId"); 
		}
		
	  	ngoStatus  = ct.NgoStatus(ngoId); 
		
	} catch (Exception e){ 	 
		
	}
	%>  	 
	
 
<div class="container" style="paddin:0px; margin-left:0px;">
    <div class="row">
        <div class="col-md-2 col-lg-3" >

            <div class="bootstrap-vertical-nav" >
 
                <div   id="collapseExample"style="paddin:0px;margin-left:0px;" >
                    <ul class="nav flex-column" id="exCollapsingNavbar3">
                       <li class="nav-item">
                         <form action="#" method="post">
								<div class="key" style="margin:10px;">
									<input  type="text"   name="productPrice" required="" placeholder="Search Feature">
									<div class="clearfix"></div>
								</div>
								<button type="submit" class="btn btn-default search" aria-label="Left Align">
									<i class="fa fa-search" aria-hidden="true"> </i>
								</button> 
							</form>	
                    	</li>
                       	<li   class="nav-item">
                         	<a class="nav-link active" href="NgoIndex.jsp">Home</a>
                        </li>
                        <li  class="nav-item">
                            <a class="nav-link" href="ngoAddProduct.jsp">Add Products</a>
                        </li> <li  class="nav-item">
                            <a class="nav-link" href="ngoProductView.jsp">View Products</a>
                        </li>
                        <li   class="nav-item">
                            <a class="nav-link" href="ngoAddDonation.jsp">Ask For Donation</a>
                        </li>
                         <li   class="nav-item">
                            <a class="nav-link" href="ngoDonationView.jsp">View Donations</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link  " href="ngoAddVolunteering.jsp">Volunteer Job</a>
                        </li>
                        <li   class="nav-item">
                            <a class="nav-link" href="ngoVolunteerView.jsp">View Volunteer Job</a>
                        </li>
                        <li   class="nav-item">
                            <a class="nav-link" href="ngoAddEvent.jsp">Add Event</a>
                        </li>
                        <li   class="nav-item">
                            <a class="nav-link" href="ngoEventView.jsp">View View Events</a>
                        </li>
                    </ul>
                </div> 
            </div> 
        </div>
        <div class="col-md-10 col-lg-9">
       <%  String uploadPicture =  request.getParameter("picSection"); 
	      if(uploadPicture == null) {
	  %>
<form action="Control?action=addDonation" method="post">
	 <div class="container">
	 	<div class="login" > 
	 	 	<div class="main-agileits" style="width: 50%;  margin-top: -20px;  margin-left:200px;">
	 			<div class="key">
					<i class="fa fa-envelope" aria-hidden="true"></i>
					<input  type="text" name="name" required="" placeholder="Name ">
					<div class="clearfix"></div>
				</div>
				<div class="key">
					<i class="fa fa-envelope" aria-hidden="true"></i>
					<input  type="text" name="age" required="" placeholder="Age">
					<div class="clearfix"></div>
				</div> 
				<div class="key">
					<i class="fa fa-envelope" aria-hidden="true"></i>
					<input  type="text" name="amount" required="" placeholder="Amount Needed">
					<div class="clearfix"></div>
				</div> 
				<div class="key">
					<i class="fa fa-envelope" aria-hidden="true"></i>
					<input  type="text" name="purpose" required="" placeholder="Purpose">
					<div class="clearfix"></div>
				</div> 
				<div class="key">
					<i class="fa fa-envelope" aria-hidden="true"></i>
					<textarea name="description" required="" placeholder="Description"></textarea>
					<div class="clearfix"></div>
				</div>
				<input type="submit" style=" width:100%;" class="button" value="Next">
			</div>
	 	</div> 
  	</div>
</form>
<%}
	      else if(uploadPicture.equals("1")) {
	      String dId = request.getParameter("donationId");
	      %>
	 	<div class="main-agileits" style=" width: 64%; margin-top: 63px;margin-bottom: 12px; padding: 30px 28px; margin-top: 63px; margin-bottom: 12px; padding: 30px 28px;">
	
		  <h3>Add Picture of person Who Need Donation</h3>
		<form id="uploadPicture" enctype="multipart/form-data" action="UploadDonationPicture?donationId=<%=dId%>" method="post">
		<br>
		  	<input required style="width:50%;"type="file" name="file" id="imgInp1" > 
		   	<img id="productimage1" src="#"  style="width:100px; height:100px;" />  
		  	<br><br>
		  	<input type="submit" value="Submit" >
		<br>
		</form> 
		</div>
		<%} %>
		<br>
		<br> 
    	</div>
 	</div>
</div>
	 
	<!-- newsletter -->
	<div class="newsletter">
	<div class="container">
		<div class="col-md-6 w3agile_newsletter_left">
			<h2>Newsletter</h2>
			<p>Subscribe to our newsletter and get updates about all our features and offers.</p>
		</div>
		<div class="col-md-6 w3agile_newsletter_right">
			<form action="Control?action=subscription" method="post">
				<input type="email" name="email" value="Email" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Email';}" required="">
				<input type="submit" value="Subscribe" />
			</form>
		</div>
		<div class="clearfix"></div>
	</div>
</div>
<!-- //newsletter -->
<div class="footer">
	<div class="container">
		<div class="col-md-3 footer-grids fgd1">
		<a href="index.jsp"><img src="images/logo2.png" alt=" " /> </a>
		<ul>
			<li>Christ University</li>
			<li>Bangalore-560029</li>
			<li><a href="mailto:info@example.com">info@sarvahitkari.com</a></li>
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
				<li><a href="NgoRegister.jsp">NGO Registration</a></li>
				<li><a href="login.html">NGO Login</a></li>
				<li><a href="CustomerRegister.html">Customer Registration </a></li>
				<li><a href="userLogin.jsp">Customer Login</a></li>
			</ul>
		</div>
		<div class="clearfix"></div>
		<p class="copy-right">© 2018 Sarvahitkari . All rights reserved | Design by <a href="#">Kapil Thakur & Rebecca John</a></p>
	</div>
</div>

	<!-- cart-js -->
	<script src="js/minicart.js"></script>
	<!-- <script>
        w3ls1.render();

        w3ls1.cart.on('w3sb1_checkout', function (evt) {
        	var items, len, i;

        	if (this.subtotal() > 0) {
        		items = this.items();

        		for (i = 0, len = items.length; i < len; i++) {
        			items[i].set('shipping', 0);
        			items[i].set('shipping2', 0);
        		}
        	}
        });
    </script> -->  
	<!-- //cart-js -->  

<%
	String registered =request.getParameter("ngomsg");
	if(registered != null){
%>
<div class="Message Message--green">
  <div class="Message-icon">
    <i class="fa fa-check "></i>
  </div>
  <div class="Message-body">
    <p>Thank You for registering with us. Please check your mail to verify your account</p>   
  </div>
  <button class="Message-close js-messageClose"><i class="fa fa-times"></i></button>
</div>
<%} %>


	<!-- cart-js -->
	<script src="js/minicart.js"></script>
	<script>
        w3ls1.render();

        w3ls1.cart.on('w3sb1_checkout', function (evt) {
        	var items, len, i;

        	if (this.subtotal() > 0) {
        		items = this.items();

        		for (i = 0, len = items.length; i < len; i++) {
        			items[i].set('shipping', 0);
        			items[i].set('shipping2', 0);
        		}
        	}
        });
    </script>  
	<!-- //cart-js -->  
	
 
<script type="text/javascript">

function closeMessage(el) {
	  el.addClass('is-hidden');
	}

	$('.js-messageClose').on('click', function(e) {
	  closeMessage($(this).closest('.Message'));
	});

	$('#js-helpMe').on('click', function(e) {
	  alert('Help you we will, young padawan');
	  closeMessage($(this).closest('.Message'));
	});

	$('#js-authMe').on('click', function(e) {
	  alert('Okelidokeli, requesting data transfer.');
	  closeMessage($(this).closest('.Message'));
	});

	$('#js-showMe').on('click', function(e) {
	  alert("You're off to our help section. See you later!");
	  closeMessage($(this).closest('.Message'));
	});

	$(document).ready(function() {
	  setTimeout(function() {
	    closeMessage($('#js-timer'));
	  }, 5000);
	}); 
</script>

<script type="text/javascript">
 
 function readURL(input,id) {

	  if (input.files && input.files[0]) {
	    var reader = new FileReader();

	    reader.onload = function(e) {
	      $(id).attr('src', e.target.result);
	    } 
	    reader.readAsDataURL(input.files[0]);
	  }
	}

	$("#imgInp1").change(function() {
	  readURL(this,productimage1);
	});
	 
 </script>
  	
</body>
</html>