<%@page import="encryption.encrypt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sarv Hitkari Store</title>
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
 
<!-- 
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css"> -->
 
<!-- <script src="js/kj.js"></script> -->
<style type="text/css">
/* @import url(https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css);
@import url(https://fonts.googleapis.com/css?family=Source+Sans+Pro:700,400,300); */
 body
 {
 margin: 0px;
 padding: 0px;
 } 
iframe
{
margin: 0px;
padding:0px;
border: none; 
}
.Message {
   display: table;
    position: absolute;     
    bottom: 7px;
    width: 502px;
    background-color: #0074D9;  
    color: #fff;     
    -webkit-transition: all 0.2s ease; 
    transition: all 0.2s ease;  
}
.Message i {
	color:white;
}
.Message.is-hidden {
  opacity: 0;
  height: 0;
  font-size: 0;
  padding: 0;
  margin: 0 auto;
  display: block;
} 
.Message--orange {
  background-color: #F39C12;
} 
.Message--red {
  background-color: #FF4136;
} 
.Message--green {
  background-color: #66bdd7;
} 
.Message-icon {
  display: table-cell;
  vertical-align: middle;
  width: 60px;
  padding: 30px;
  text-align: center;
  background-color: rgba(0, 0, 0, 0.25);
}
.Message-icon > i {
  width: 20px;
  font-size: 20px;  
} 
.Message-body {
  display: table-cell;
  vertical-align: middle;
  padding: 12px 20px 0px 10px;
}
.Message-body > p {
  line-height: 1.2;
  margin-top: 6px;
} 
.Message-button {
  position: relative;
  margin: 15px 5px -10px;
  background-color: rgba(0, 0, 0, 0.25);
  box-shadow: 0 3px rgba(0, 0, 0, 0.4);
  border: none;
  padding: 10px 15px;
  font-size: 16px;
  font-family: 'Source Sans Pro';
  color: #fff;
  outline: none;
  cursor: pointer;
}
.Message-button:hover {
  background: rgba(0, 0, 0, 0.3);
}
.Message-button:active {
  background: rgba(0, 0, 0, 0.3);
  box-shadow: 0 0px rgba(0, 0, 0, 0.4);
  top: 3px;
} 
.Message-close {
  position: absolute;
  background-color: rgba(0, 0, 0, 0.3);
  color: #fff;
  border: none;
  outline: none;
  font-size: 20px;
  right: 5px;
  top: 5px;
  opacity: 0;
  cursor: pointer;
}
.Message:hover .Message-close {
  opacity: 1;
}
.Message-close:hover {
  background-color: rgba(0, 0, 0, 0.5);
} 
.u-italic {
  font-style: italic;
} 
body
{
overflow-x:hidden;
}
#pw3ls-cart  
 {
 background-color: #66bdd7;
    color: #ffffff;
    border: none;
    padding: 10px 20px;
    font-size: 17px;
    font-family: Raleway;
    cursor: pointer;
 
 }
</style>

</head>
<body> 
<%@ page import="java.sql.*" %>
<%@page import="java.lang.reflect.Array"%>
<%@ page import ="javax.sql.*" %>
<%@ page import="com.daniel.util.control.*"  %>  
<%@ page import="java.time.LocalDate"  %>  

<%@ page import="encryption.*"  %> 
<%@ page import="java.util.Calendar"  %>

<%@ page import="java.util.Date"  %> 
 
<%! 
	String ngoStatus=null;
	ResultSet productsDetail=null,donationDetail=null,ngoDetail=null;  
	ResultSet SubCategoryRs=null,volunteerDetail=null,eventDetail=null; 
	Control ct = new Control();
	encrypt et = new encrypt();
%>
<div class="outercontainer">
	<div class="header-bottom-w3ls">  
		<div class="row">
			<div class="col-md-2 logo-w3">
				<a href="index.jsp"><img src="images/logo2.png" alt=" " /> </a>
				<div class="clearfix"></div>
			</div> 
			<div class="col-md-4 navigation-agileits">
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
							<li class="dropdown ">
								<a href="#" class="dropdown-toggle  hyper" data-toggle="dropdown" ><span>Category<b class="caret"></b></span></a>
									<ul class="dropdown-menu multi">
										<div class="row">
											<div class="col-sm-4">
												<ul class="multi-column-dropdown">					
													<li><a href="women.html"><i class="fa fa-angle-right" aria-hidden="true"></i>Women's Clothing</a></li>
													<li><a href="men.html"><i class="fa fa-angle-right" aria-hidden="true"></i>Men's Clothing</a></li>
													<li><a href="kids.html"> <i class="fa fa-angle-right" aria-hidden="true"></i>Kid's Wear</a></li>
														<li><a href="party.html"><i class="fa fa-angle-right" aria-hidden="true"></i>Party Wear</a></li>
											
												</ul>
											
											</div>
											<div class="col-sm-4">
												<ul class="multi-column-dropdown">
													<li><a href="casuals.html"><i class="fa fa-angle-right" aria-hidden="true"></i>Casuals</a></li>
													<li><a href="night.html"><i class="fa fa-angle-right" aria-hidden="true"></i>Night Wear</a></li>
													<li><a href="formals.html"><i class="fa fa-angle-right" aria-hidden="true"></i>Formals</a></li>
													<li><a href="inner.html"><i class="fa fa-angle-right" aria-hidden="true"></i>Inner Wear</a></li>
											
												</ul>						
											</div>
											<div class="col-sm-4 w3l">
												<a href="women.html"><img src="images/menu1.jpg" class="img-responsive" alt=""></a>
											</div>
											<div class="clearfix"></div>
										</div>	
									</ul>
							</li>
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
			 <div class="col-md-2 search-agileinfo">
				<form action="#" method="post">
					<input type="search" name="Search" placeholder="Search for a Product..." required="">
					<button type="submit" class="btn btn-default search" aria-label="Left Align">
						<i class="fa fa-search" aria-hidden="true"> </i>
					</button>
				</form>
			</div>
			  	<div class="col-md-4 cart-wthree"> 
					<ul style="list-style:none;">
						<li></li>
						<li style="float:left;margin-right:10px;  "><a href="CustomerRegister.html"> <i class="fa fa-user-plus" style="margin-left:15px;"aria-hidden="true"></i><br>Customer </a></li>  
						<li style="float:left;margin-right:10px; "><span class="w3off"><a href="NgoRegister.jsp"> <i class="fa fa-user-plus" aria-hidden="true"></i> <br>NGO</a></span></li> 
						<li style="float:left;margin-right:10px; "><a href="userLogin.jsp"> <i class="fa fa-user" style="margin-left:15px;" aria-hidden="true"></i> <br>Customer</a></li>
						<li style="float:left;margin-right:10px; "><a href="ngoLogin.jsp"> <i class="fa fa-user" aria-hidden="true"></i><br>NGO </a></li>
						<li style="float:left;margin-right:10px; "><a href="ngoPreLogin.jsp"> <i class="fa fa-check-square-o" style="margin-left:38px;" aria-hidden="true"></i><br>NGO Check Status </a></li>
					</ul> 
			 	</div>    
			<div class="clearfix"></div>
		</div>
	</div>
</div>
 
<div class="banner-bootom-w3-agileits">
	<div class="container">
		<div class="col-md-5 bb-grids bb-left-agileits-w3layouts">
			<div class="bb-left-agileits-w3layouts-inner">
					<h3>HELP</h3>
					<h4>Eradicate<span>Child Labour</span></h4>
			</div>
		</div>
		<div class="col-md-4 bb-grids bb-middle-agileits-w3layouts">
			<div class="bb-middle-top">
				<h3>FIGHT</h3>
				<h4>against<span>Child Marriage</span></h4>
			</div>
			<div class="bb-middle-bottom">
				<h3>ASSIST</h3>
				<h4>the<span>Old</span></h4>
			</div>
		</div>
		<div class="col-md-3 bb-grids bb-right-agileits-w3layouts">
			<div class="bb-right-top">
				<h3>EDUCATE</h3>
				<h4>the<span>Poor</span></h4>
			</div>
			<div class="bb-right-bottom">
				<h3>REBUILD</h3>
				<h4>the<span>Villages</span></h4>
			</div>
		</div>
		<div class="clearfix"></div>
	</div>
</div>
<div class="top-products">
	<div class="container">
		<h3>Products</h3>
		<div class="sap_tabs">			
			<div id="horizontalTab">
				<div class="clearfix"> </div>	
				<div class="resp-tabs-container">
				<%   productsDetail = ct.getProduct();  %> 
				<%! int i=1;String imgSR1=null; %>
					<% while(productsDetail.next()){ %>
					<%
					 	String id =productsDetail.getString("id");
						String value = getServletContext().getInitParameter("EncryptionKey");
						String letter = getServletContext().getInitParameter("EncryptionLetters");
						String length = getServletContext().getInitParameter("EncryptionLength");
						String ids = et.service(request, response,id,value,letter,length);
					%>
					<div class="tab-1 resp-tab-content">
						<div class="col-md-3 top-product-grids tp<%=i%> animated wow slideInUp" style="border-" data-wow-delay=".5s">
							<a href="productView.jsp?pId=<%=ids%>">
							<div class="product-img">
						  	 	<%
								  imgSR1 = "images/"+productsDetail.getString("image1"); 
						 		%>
					 	 			<img style="height:300px;"  alt="" src="<%=imgSR1%>" > 
							  	<div class="p-mask"> 
									<form action="#" method="post">
										<input type="hidden" name="cmd" value="_cart" />
										<input type="hidden" name="add" value="1" /> 
										<input type="hidden" name="w3ls1_item" value="Formal shoes" /> 
										<input type="hidden" name="amount" value="220.00" /> 
										<button type="submit" class="w3ls-cart pw3ls-cart"><i class="fa fa-cart-plus" aria-hidden="true"></i> Add to cart</button>
									</form>
								</div>
							</div></a> 
							<div class="single-rating" style="border-style:none; margin:5px 0px;"> 
								<ul style="list-style:none; margin-left:90px;">
									<% int count = ct.getReviewCount(productsDetail.getString("id")); 
								 	int avg = ct.getReviewAvg(productsDetail.getString("id")); 
								 	for(int l=0;l<count;l++) {  %>
									 <li style="float:left;" ><i style="display: table-row;"  class="fa fa-star yellow-star" aria-hidden="true"></i></li>		
									<% } %>
									<% for(int m = count; m<5; m++){ %>
										<li style="float:left;" ><i style="display: table-row;" class="fa fa-star-o" aria-hidden="true"></i></li>
									<% } %> 					
								</ul>
						 </div> 
						 <h4 style="text-align:center;"><%=productsDetail.getString("name")%></h4>
						
							<h5 style="text-align:center;"><%=productsDetail.getString("price")%></h5>
						<br>
						 </div> 
					</div>
					<% 
					i++; 
					} %> 			
				</div>
			</div>
		</div>	
	</div>
</div> 
<div class="top-products">
	<div class="container">
		<h3>Money Needed</h3>
		<div class="sap_tabs">			
			<div id="horizontalTab">
				 	
				<div class="clearfix"> </div>	
				<div class="resp-tabs-container">
				<% donationDetail = ct.getDonationDetail();  %>
				<%! int j=1; String donateImg=null; %>
					<% while(donationDetail.next()){ %> 
					<div class="tab-1 resp-tab-content">
						<div class="col-md-3 top-product-grids tp<%=j%> animated wow slideInUp" data-wow-delay=".5s">
							<a href="donationView.jsp?dId=<%=donationDetail.getString("id")%>">
 
								<div class="product-img">
							  	 <%
							  		donateImg = "images/"+donationDetail.getString("image"); 
							  	 %>
						 	 	<img style="height:200px;" alt="" src="<%=donateImg%>" > 
						 	 	</div>
									 <div class="p-mask"> 
										 <button type="submit" class="w3ls-cart pw3ls-cart"><i class="fa fa-cart-plus" aria-hidden="true"></i> Donate</button>
									 </div> 
							 
							</a>
							 
							<h4><%=donationDetail.getString("name")%></h4>
							<h5><%=donationDetail.getString("total_amount")%></h5>
						</div> 
					</div>
					<%j++; 
					} %> 			
				</div>
			</div>
		</div>	
	</div>
</div>
<div class="top-products">
	<div class="container">
		<h3>Jobs Available</h3>
		<div class="sap_tabs">			
			<div id="horizontalTab">
				 	
				<div class="clearfix"> </div>	
				<div class="resp-tabs-container">
				<% volunteerDetail = ct.getVolunteerDetail();  %>
				<%! int k=1;  %>
					<% while(volunteerDetail.next()){ %> 
					<div class="tab-1 resp-tab-content">
						<div class="col-md-3 top-product-grids tp<%=k%> animated wow slideInUp" data-wow-delay=".5s">
							<a href="jobView.jsp?vId=<%=volunteerDetail.getString("id")%>">
						<%String logo = ct.getNgoLogo(volunteerDetail.getString("ngo_details_id"));%>
							<div class="product-img" >
						  	  
					 	 	<img style="height:200px;"alt="" src="images/<%=logo%>" > 
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
<!-- Event Details  -->
<div class="top-products" >
	<div class="container">
		<h3>Upcoming Events</h3>
		<div class="sap_tabs">			
			<div id="horizontalTab">
				 	
				<div class="clearfix"> </div>	
				<div class="resp-tabs-container">
				<% eventDetail = ct.getEventDetail();  %>
				<%! int n=1;  %>
					<% while(eventDetail.next()){ %> 
					<div class="tab-1 resp-tab-content">
						<div class="col-md-3 top-product-grids tp<%=n%> animated wow slideInUp" data-wow-delay=".5s">
							<a href="eventView.jsp?vId=<%=eventDetail.getString("id")%>">
						<%String logo =  eventDetail.getString("poster");%>
							<div class="product-img" >
						  	  
					 	 	<img style="height:300px;" alt="" src="images/<%=logo%>"  > 
								 <div class="p-mask"> 
									 
								</div>
							</div>
							</a>
							 <div class="p-mask"> 
							 <form action="Control?action=updateInterst" method="post">
							<%
								String eventInterstStatus = ct.getEventStatus(request, response,eventDetail.getString("id"));
							if(eventInterstStatus == null){ %>
							 	<input type="hidden" name="eId" value="<%=eventDetail.getString("id")%>">
								 <select required id="linkSelect" name="interst">
									<option value="0">Select Your Interest</option>
								 	<option>Going</option>
								 	<option>Interested</option>
								 	<option>Not Going</option>
								 </select>
								
							  	<button   type="submit"   class="w3ls-cart pw3ls-cart"> Submit</button>
							 <%} else if(eventInterstStatus.equals("Interested")) {%>
							   
							  <p  class="w3ls-cart pw3ls-cart" id="pw3ls-cart"> <span class="fa fa-thumbs-o-up" style="font-size:22px; float:left;"></span> <%=eventInterstStatus %></p>
							 <%} else if(eventInterstStatus.equals("Going")) {%>
							   
							  <p  class="w3ls-cart pw3ls-cart" id="pw3ls-cart"><img align="left" src="images/going.png" style="width:40px; height:auto; padding:0px; margin-top:-8px;"><%=eventInterstStatus %></p>
							 <%} else if(eventInterstStatus.equals("Not Going")) {%>
							   
							  <p  class="w3ls-cart pw3ls-cart" id="pw3ls-cart"><span class="fa fa-thumbs-o-down" style="font-size:22px; float:left;"></span>  <%=eventInterstStatus %></p>
							 <%} %>
							</form>
								<!-- <button style="display:block;" type="button" id="view_details" class="w3ls-cart pw3ls-cart"> View Details</button>
								 --> 
								</div>
								<h4><%=eventDetail.getString("event_name")%></h4>
								<h5><%=eventDetail.getString("venue")%></h5>
								<h5><%=eventDetail.getString("event_date")%></h5> 
						</div> 
					</div>
					<%  n++; 
					} %> 			
				</div>
			</div>
		</div>	
	</div>
</div>
<!-- Event Details  -->
<!-- top-brands -->
	<div class="top-brands">
		<div class="container">
			<h3>NGO Associated</h3>
			<div class="sliderfig">
				<ul id="flexiselDemo1">		
				<% ngoDetail = ct.getNgoDetail(); %>	
					<%  while(ngoDetail.next()) {
					String imgSR1= "images/"+ngoDetail.getString("logo");%>
					
					
					<li><a href="viewNgoProfile.jsp?ngoId=<%=ngoDetail.getString("id")%>">
						<img src="<%=imgSR1%>" alt=" "    />
					</a>
					</li>
					<%} %>
					 
				</ul>
				 
			</div> 
			<script type="text/javascript">
					$(window).load(function() {
						$("#flexiselDemo1").flexisel({
							visibleItems: 3,
							animationSpeed: 500,
							autoPlay: false,
							autoPlaySpeed: 2000,    		
							pauseOnHover: true,
							enableResponsiveBreakpoints: true,
							responsiveBreakpoints: { 
								portrait: { 
									changePoint:480,
									visibleItems: 1
								}, 
								landscape: { 
									changePoint:640,
									visibleItems:2
								},
								tablet: { 
									changePoint:768,
									visibleItems: 3
								}
							}
						});
						
					});
			</script>
			<script type="text/javascript" src="js/jquery.flexisel.js"></script>
		</div>
	</div>
<!-- //top-brands -->

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

<script src="js/easyResponsiveTabs.js" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function () {
		$('#horizontalTab').easyResponsiveTabs({
			type: 'default', //Types: default, vertical, accordion           
			width: 'auto', //auto or any width like 600px
			fit: true   // 100% fit in a container
		});
	});		
</script> 
<%
	String registered =request.getParameter("msg");
	if(registered != null){
%>
<div class="Message Message--green">
  <div class="Message-icon">
    <i class="fa fa-check "></i>
  </div>
  <div class="Message-body">
    <p>Thank You for registering with us.</p>   
  </div>
  <button class="Message-close js-messageClose"><i class="fa fa-times"></i></button>
</div>
<%} %>

<%
	String NgoRegistered =request.getParameter("ngomsg");
	if(NgoRegistered != null){
%>
<div class="Message Message--green">
  <div class="Message-icon">
    <i class="fa fa-check "></i>
  </div>
  <div class="Message-body">
    <p>Thank You, Now follow the process given on the mail</p>   
  </div>
  <button class="Message-close js-messageClose"><i class="fa fa-times "></i></button>
</div>
<%} %>
<%
	String subscriber =request.getParameter("subscriber");
	if(subscriber != null){
%>
<div class="Message Message--green">
  <div class="Message-icon">
    <i class="fa fa-check "></i>
  </div>
  <div class="Message-body">
    <p>Thank You for registering with us Please check your mail</p>   
  </div>
  <button class="Message-close js-messageClose"><i class="fa fa-times "></i></button>
</div>
<%} %>
<%
	String subscriberfail =request.getParameter("subscriberfail");
	if(subscriberfail != null){
%>
<div class="Message Message--green">
  <div class="Message-icon">
    <i class="fa fa-check "></i>
  </div>
  <div class="Message-body">
    <p>You have already registered with us</p>   
  </div>
  <button class="Message-close js-messageClose"><i class="fa fa-times "></i></button>
</div>
<%} %>

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