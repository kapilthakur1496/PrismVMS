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
<title></title>
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


    <style type="text/css">
        
        
     
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
				 <a href="CustomerRegister.html"> <i class="fa fa-user" aria-hidden="true"></i><br>Register</a>	 
				   	 
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
  
<%!  
	ResultSet teamProjectsRs=null,branchRs=null;
	int volunteerStatus=0; 
	String volunteerId =null,  status=null;
	ResultSet teamsRs=null; 
	int volunteerCount =0, pageCount = 0;
	int pageNumber=0, nextRecordCount=10;	
	Control ct = new Control();
%>
<% 
	volunteerId = (String)session.getAttribute("volunteerId"); 
	if(volunteerId == null)
	{	
		volunteerId = (String)session.getAttribute("volunteerId"); 
	} 
	volunteerStatus  = ct.checkVolunteerStatus(request, response,volunteerId);  
} catch (Exception e){ 	 	
}
finally
{

}
if(volunteerStatus == 1){

	teamProjectsRs = ct.getVolunteerTeamProject(request, response, pageNumber, nextRecordCount);
%>
 
 	
 
<div class="container" style="paddin:0px; margin-left:0px;">
    <div class="row">
        <div class="col-md-2 col-lg-3" >

            <div class="bootstrap-vertical-nav" >
	 
 
                <div   id="collapseExample"style="paddin:0px; margin-left:0px;" >
                    <ul class="nav flex-column" id="exCollapsingNavbar3">
	                    <li   class="nav-item" style="text-algin:center">
	                     <img src="images/logo2.png" style="  width: 80px;text-aling: center;margin-top: 11px;margin-left: 63px;height: 80px;border-radius: 50%;">
	                 	</li>
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
                    		
                       	<li  class="nav-item">
                         	<a class="nav-link " href="mentorIndex.jsp">Home</a>
                        </li>
                        <li  class="nav-item">
                            <a class="nav-link active" href="individualProject.jsp">Individual Projects</a>
                        </li> 
                        <li  class="nav-item">
                            <a class="nav-link" href="teamProject.jsp">Team Projects</a>
                        </li>
                        <li  class="nav-item">
                            <a class="nav-link" href="teamProjectView.jsp?pN=1">View Team Projects</a>
                        </li>
                        <li   class="nav-item">
                            <a class="nav-link" href="workTraining.jsp">Branch Projects</a>
                        </li>
                         <li   class="nav-item">
                            <a class="nav-link" href="projectAssigned.jsp">Meeting Report</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link  " href="teamProject.jsp">Team Project</a>
                        </li>
                        <li   class="nav-item">
                            <a class="nav-link" href="branchProject.jsp">Branch Project</a>
                        </li>
                        <li   class="nav-item">
                            <a class="nav-link" href="branchProject.jsp">Grievance</a>
                        </li>
                        <li   class="nav-item">
                            <a class="nav-link" href="support.jsp">Online Support</a>
                        </li>
                          
                        
                    </ul>
                </div> 
            </div> 
        </div>
        <div class="col-md-10 col-lg-9" style="padding:22px 10px;">
	 	   <ul class="collapsible" data-collapsible="accordion" style="list-style:none; margin-left:auto; margin-right:auto;">
			 
				 <%while(teamProjectsRs.next()){ %>
				 <%  status = ct.getTeamProjectStatus(request,response, teamProjectsRs.getString("id")); %>
							 
					<li>
						<div class="collapsible-header active"><p style="padding:10px; background-color:#66bdd7; font-size:14px;">
							
							 <%if(status ==null){%>
								<span class="glyphicon glyphicon-pushpin" style="font-size:20px; color:#fff; font-size:22px; font-style: bold;"></span>&nbsp;&nbsp;
							<%} else if(status.equals("Project Assigned")){ %>
								<span class="glyphicon glyphicon-pushpin" style="font-size:20px; color:#fff; font-size:22px; font-style: bold;"></span>&nbsp;&nbsp;
							 <%}else if(status.equals("Rejected")){ %>
							 	<i class="fa fa-cross" style="color:red;"></i>
							<%}else if(status.equals("Approved")){ %> 
								<i class="fa fa-cricle-right" style="color:green;"></i>
							 <%} %>  
							<!-- <span class="glyphicon glyphicon-pushpin" style="font-size:20px; color:#fff; font-size:22px; font-style: bold;"></span>&nbsp;&nbsp;
							 --><%=teamProjectsRs.getString("tproject_title") %>
							 
					  		<span style="float: right; margin-right: 39px;" >
						  		<i class="fa fa-users"  style="text-align: right; color:#fff; font-size:22px; font-style: bold;"> </i> &nbsp;&nbsp; 
							 	<%=teamProjectsRs.getString("team") %>  
							</span> 		
				 	 	</div> 
						<div class="collapsible-body" style="background-color: #fff;">
							<div class="col-lg-12" style="margin-left:90px;">
								<div class="row"  >
									<div class="col-lg-6" style="padding:5px;  "> 
										<div class="info">
					 			 			<p><strong><i class="fa fa-calendar-o" style="font-size:20px;  "></i>  &nbsp;  &nbsp;  Start Date</strong> &nbsp; <%=teamProjectsRs.getString("tpro_start_date") %>      </p>
										</div>
									</div>
									<div class="col-lg-6" style="padding:5px;  "> 
										<div class="info">
					 			 			<p><strong><i class="fa fa-calendar-o" style="font-size:20px;  "></i> &nbsp;  &nbsp; End Date</strong> &nbsp; <%=teamProjectsRs.getString("tpro_end_date") %>   </p>
										</div>
									</div>
								</div>
								<br>
								<p style="  font-size:16px;"><%=teamProjectsRs.getString("tproject_desc") %>  </p> 
							
							
							<%if(status ==null){
							
							System.out.println("Status "+status);
							%>
								<br><a href="temProjectEnrollRequest.jsp?projectId=<%=teamProjectsRs.getString("id")%>"><i class="fa fa-plus" style="color:#fff; font-size:22px;  "></i> Enroll  Request </a>
							<%}
							else if(status.equals("Project Assigned")){ %>
							<%}else if(status.equals("Not Approved")){ %>
								<br><a href="teamProjectEnrollCancelRequest.jsp?projectId=<%=teamProjectsRs.getString("id")%>"><i class="fa fa-cross" style="color:#fff; font-size:22px;  "></i> Cancel  Request </a>
							<%}else if(status.equals("Approved")){ %>
							<i class="fa fa-cricle-right" style="color:green;"></i>
							 <%} %>
							</div> 
					</div>
				</li>
				<%} %> 
				   
	  		</ul>
	  		<div class="col-lg-12 text-center" style="margin-left:auto; margin-right:auto;">
					<ul class="pagination " >
						<% for( int k=1; k<=pageCount; k++){ %>
					    	<li><a href="viewTeamProject.jsp?pN=<%=k%>"><%=k%></a></li>
					    <% } %> 
				 	</ul>
		 		</div>
    	</div>
 	</div>
</div>
  
<%} %>
<br><br><br><br><br>
		  
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

	 <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.1/js/materialize.min.js"></script>

<script type="text/javascript">

(function($) {
	
	$(window).scroll(function() {
		
		$(window).scroll(function() {
			space = $(window).innerHeight() - $('.fab').offsetTop + $('.fab').offsetHeight;
			if(space < 200){
				$('.fab').css('margin-bottom', '150px');
			}
		})
		
	});
	
})(jQuery);

</script>
</body>
</html>