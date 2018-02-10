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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<style type="text/css">
 body
 {
 overflow-x:hidden; 
 }
#regForm {
  background-color: #ffffff;
  margin: 0px auto;
  font-family: Raleway;
  
  width: 70%;
  min-width: 300px;
}

h1 {
  text-align: center;  
}
 .key img
 {
	margin-left: 14px;
	margin-bottom: 14px;
	
 }
 
 
</style>
 
</head>
<body>

<%@ page import="java.sql.*" %>
<%@page import="java.lang.reflect.Array"%>
<%@ page import ="javax.sql.*" %>
<%@ page import="com.daniel.util.control.*"  %> 
   
  
  
   <div class="outercontainer" style="margin-top:0px;">
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

<%@ page import="encryption.*"  %> 
 <%@ page import="java.sql.*" %>
<%@page import="java.lang.reflect.Array"%>
<%@ page import ="javax.sql.*" %>
<%@ page import="com.daniel.util.control.*"  %>
<%! 
	ResultSet volunteerDetail=null,similarJobs=null; 
	String vId=null ,ngoId=null, imgPath = null; 
	Control  ct = new  Control();  
%>

<% try{ %>
   
 
 <% 
		vId = request.getParameter("vId"); 
	volunteerDetail =  ct.getVolunteerDetail(vId);
	%>
<% 
	ngoId= (String)session.getAttribute("ngoId"); 
	if(ngoId == null)
	{	
		ngoId= (String)session.getAttribute("ngoId"); 
	} 
	 	
	/* ngoStatus  = ct.NgoStatus(ngoId);  */ 
} catch (Exception e){ 	 	
}
%>  	
<div class="container" style="paddin:0px; margin-left:0px;">
    <div class="row">
        <div class="col-md-2 col-lg-3" >

            <div class="bootstrap-vertical-nav" >
	 
 
                <div   id="collapseExample"style="paddin:0px; margin-left:0px;" >
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
                            <a class="nav-link " href="ngoAddVolunteering.jsp">Volunteer Job</a>
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
              	

<%try{ %>	
  <%while(volunteerDetail.next()){ %>
  <form action="Control?action=updateVolunteerDetail"  method="post">
	<div class="container">  
		<div class="single-page">
			<div class="single-page-row" id="detail-21">
				 <div class="col-md-2 text-center single-top-left">	
					 
				</div>
				<div class="col-md-8 single-top-right" style="margin-left:19%;">
					 <input style="width:auto; font-size:34px; color:#66bdd7;" type="text" readonly="true" ondblclick="this.readOnly='';"  name="position" value="<%=volunteerDetail.getString("position")%>"> 
					  
							<div class="single-price"> 
								<ul>
								<li style="font-size:30px; font-size:18px;" ><p style="color:black; font-size:14px;">Job Type</p>  <input style=" " type="text"  readonly="true" ondblclick="this.readOnly='';"  name="jobType" value="<%=volunteerDetail.getString("volunteer_type")%>"></li>  
									<li style="font-size:30px;"> <p style="color:black; font-size:14px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Stipend</p> &nbsp;&nbsp;<input  type="text"  readonly="true" ondblclick="this.readOnly='';"  name="stipend" value="<%=volunteerDetail.getString("stipend")%>"></li>  
									<li style="font-size:30px;"> <p style="color:black; font-size:14px;">Experience in Years</p> <input  type="text"  readonly="true" ondblclick="this.readOnly='';"  name="experience" value="<%=volunteerDetail.getString("experience")%>"></li>  
									 <li style="font-size:30px;"><p style="color:black; font-size:14px;">Job Location</p>   <input  type="text"  readonly="true" ondblclick="this.readOnly='';"  name="location" value="<%=volunteerDetail.getString("location")%>"></li>   
									 <li style="font-size:30px;"><p style="color:black; font-size:14px;">lastdate</p>   <input  type="date"  readonly="true" ondblclick="this.readOnly='';"  name="lastdate" value="<%=volunteerDetail.getString("lastdate")%>"></li>   
								<li style="font-size:30px; font-size:18px;" ><p style="color:black; font-size:14px;">Skillls</p><input style="width:300px;; font-size:14px; color:#999999;" type="text" readonly="true" ondblclick="this.readOnly='';"  name="skills" value="<%= volunteerDetail.getString("skills")%>"> </li>
						
								</ul>
								<p> 
									<input type="hidden" name="dId" value="<%=volunteerDetail.getString("id")%>"  >
							  	</p>	
							</div> 
						<p class="single-price-text">
							<textarea readonly="true" style="width:600px;" name="description" ondblclick="this.readOnly='';" >	<%= volunteerDetail.getString("description")%>  </textarea>
						</p>
					   	<input type="hidden" name="pId" value="<%=volunteerDetail.getString("id")%>" >
						<input type="submit" class="w3ls-cart " value="Update ">
					</div>
			   <div class="clearfix"></div>  
			</div>
		</div> 
	</div>	 
</form>
	<%}  } catch (Exception e){}
	%> 






		</div>
	</div>
</div>
  
<div class="top-products">
	<div class="container"> 
		<div class="sap_tabs">			
			<div id="horizontalTab">
				 	
				<div class="clearfix"> </div>	
				<div class="resp-tabs-container">
				<% volunteerDetail = ct.getNgoVolunteerDetail(ngoId,vId);  %>
				<%! int k=1;  %>
					<% while(volunteerDetail.next()){ %> 
					<div class="tab-1 resp-tab-content">
						<div class="col-md-3 top-product-grids tp<%=k%> animated wow slideInUp" data-wow-delay=".5s">
							<a href="ngoVolunteerPreview.jsp?vId=<%=volunteerDetail.getString("id")%>">
						<%String logo = ct.getNgoLogo(volunteerDetail.getString("ngo_details_id"));%>
							<div class="product-img" >
						  	  
					 	 	<img alt="" src="images/<%=logo%>" > 
								 <div class="p-mask"> 
									 
								</div>
							</div>
							</a>
							 <div class="p-mask"> 
							  	<!-- <button type="button" class="w3ls-cart pw3ls-cart"><i class="fa fa-cart-plus" aria-hidden="true"></i> Apply</button>
								 --> 
								</div>
							<h4><%=volunteerDetail.getString("position")%></h4>
							<h5><%=volunteerDetail.getString("location")%></h5>
								<br>	
						</div> 
					</div>
					<%k++;
					
					} %> 			
				</div>
			</div>
		</div>	
	</div>
</div>

		  
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
		<p class="copy-right">© 2016 Fashion Club . All rights reserved | Design by <a href="#">Kapil Thakur & Rebecca John</a></p>
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