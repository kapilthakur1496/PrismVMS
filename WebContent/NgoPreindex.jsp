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
<title>Fashion Club an Ecommerce Online Shopping Category  Flat Bootstrap responsive Website Template | Register :: w3layouts</title>
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
							<li class=" active"><a href="index.jsp" class="hyper "><span>Home</span></a></li>	
							<li><a href="contact.html" class="hyper"><span>Services</span></a></li>	
							<li><a href="about.html" class="hyper"><span>About</span></a></li>						
							<li><a href="contact.html" class="hyper"><span>Contact Us</span></a></li>
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
	  			 
 
<%@ page import="java.sql.*" %>
<%@page import="java.lang.reflect.Array"%>
<%@ page import ="javax.sql.*" %>
<%@ page import="com.daniel.util.control.*"  %>  
  
<% try{ %>
  
<%! String ngoStatus=null,ngoAprovalStatus=null;
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
	ngoAprovalStatus = ct.NgoApproveStatus(ngoId);
} catch (Exception e){ 	 
	
}
%>  
	<div class="main-agileits" style="width: 45%; margin-top: 63px; margin-bottom: 12px; padding: 30px 28px;">
		<h3><% 
			ngoDetail = ct.NgoDetail(ngoId); 
			while(ngoDetail.next())
			{	%>
			<i class="fa fa-check-square-o" style="font-size:28px;"></i>&nbsp; Email varification status of  <%=ngoDetail.getString(2) %> is 
			 <%=ngoStatus %></h3> 
			 <h3>  <i class="fa fa-check-square-o" style="font-size:28px;"></i>&nbsp;Your Status To   enable our Services <h3> <%=ngoAprovalStatus %></h3> </h5>
			 
			 <h5>	You will be able to use over services after 24 hours  </h5>
			 <h5>To check your status you can login on the below given link. Once your Status is approved you will get privilege to use our services</h5>
    	  
    	   <% } %> 
	 </div>
	 <div class="tab"> 
		<ul class="tabs col-lg-12">
			<li><a href="#">Tab01</a></li>
			<li><a href="#">Tab02</a></li>
			<li><a href="#">Tab03</a></li>
			<li><a href="#">Tab04</a></li>
			<li><a href="#">Tab05</a></li>
			<li><a href="#">Tab06</a></li>
			<li><a href="#">Tab07</a></li>
		</ul> <!-- / tabs --> 
		<div class="tab_content col-lg-12">
		
			<div class="tabs_item">
				<img src="https://cdn.dribbble.com/users/545884/screenshots/3695553/news.png">
				<h4>Tab 01 Neque ipsum dolor.</h4>
				<p>Consectetur adipisicing elit. Neque, repellat facilis totam ab eos distinctio sint atque maiores! Dignissimos, molestiae, rem accusantium iure vitae voluptatum voluptas repudiandae deserunt dolore quis! Quisquam mollitia eius sed.</p>
			</div> <!-- / tabs_item -->
	
			<div class="tabs_item">
				<img src="https://cdn.dribbble.com/users/545884/screenshots/3576036/liberosis_--_10.png">
				<h4>Tab02 Maiores, suscipit</h4>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Maiores, suscipit, eaque asperiores neque numquam nam possimus dolorem ipsa aspernatur reiciendis?</p>
			</div> <!-- / tabs_item -->
	
			<div class="tabs_item">
				<img src="https://cdn.dribbble.com/users/545884/screenshots/3557299/mo-t.png">
				<h4>Tab03</h4>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quaerat, excepturi, minima, corporis deserunt quia quae sit officiis labore inventore autem a delectus consequuntur voluptatem modi eligendi similique sed nam vitae.</p>
			</div> <!-- / tabs_item -->
			
		</div> <!-- / tab_content -->
	</div> <!-- / tab -->
	<!-- newsletter -->
	<div class="newsletter">
		<div class="container">
			<div class="col-md-6 w3agile_newsletter_left">
				<h2>Newsletter</h2>
				<p>Excepteur sint occaecat cupidatat non proident, sunt.</p>
			</div>
			<div class="col-md-6 w3agile_newsletter_right">
				<form action="Control?action=subscription" method="post">
					<input type="email" name="email" value="Email" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Email';}" required="">
					<input type="submit" value="Subscribe" />
				</form>
			</div>
			<div class="clearfix"> </div>
		</div>
	</div>
<!-- //newsletter -->
<div class="footer">
	<div class="container">
		<div class="col-md-3 footer-grids fgd1">
		<a href="index.jsp"><img src="images/logo2.png" alt=" " /> </a>
		<ul>
			<li>1234k Avenue, 4th block,</li>
			<li>Bangalore.</li>
			<li><a href="mailto:info@example.com">info@example.com</a></li>
			<a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a>
			<a href="#"><i class="fa fa-dribbble" aria-hidden="true"></i></a>
			<a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a>
			<a href="#"><i class="fa fa-linkedin" aria-hidden="true"></i></a>
		</ul>
		</div>
		<div class="col-md-3 footer-grids fgd2">
			<h4>Information</h4> 
			<ul>
				<li><a href="contact.html">Contact Us</a></li>
				<li><a href="icons.html">Web Icons</a></li>
				<li><a href="typography.html">Typography</a></li>
				<li><a href="faq.html">FAQ's</a></li>
			</ul>
		</div>
		<div class="col-md-3 footer-grids fgd3">
			<h4>Shop</h4> 
			<ul>
				<li><a href="jewellery.html">Jewellery</a></li>
				<li><a href="cosmetics.html">Cosmetics</a></li>
				<li><a href="Shoes.html">Shoes</a></li>
				<li><a href="deos.html">Deos</a></li>
			</ul>
		</div>
		<div class="col-md-3 footer-grids fgd4">
			<h4>My Account</h4> 
			<ul>
				
				<li><a href="login.html">Login</a></li>
				<li><a href="NgoRegister.jsp">Register</a></li>
				<li><a href="recommended.html">Recommended </a></li>
				<li><a href="payment.html">Payments</a></li>
			</ul>
		</div>
		<div class="clearfix"></div>
		<p class="copy-right">� 2016 Fashion Club . All rights reserved | Design by <a href="#">Kapil Thakur & Rebecca John</a></p>
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
</body>
</html>