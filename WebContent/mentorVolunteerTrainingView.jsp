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
	ResultSet workTrainingRs=null,branchRs=null;
	int volunteerStatus=0; 
	String adminId =null;
	ResultSet teamsRs=null; 
	int volunteerCount =0, pageCount = 0;
	int pageNumber=0, nextRecordCount=10;	
	Control ct = new Control();
%>
<% 
	adminId = (String)session.getAttribute("adminId"); 
	if(adminId == null)
	{	
		adminId = (String)session.getAttribute("adminId"); 
	} 
	volunteerStatus  = ct.checkMentorStatus(request, response,adminId);  
} catch (Exception e){ 	 	
}
finally
{

}
if(volunteerStatus == 1){


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
	 	  <% String id= request.getParameter("vId");
	 	 	workTrainingRs = ct.getVolunteerWorkTraining(request, response,id);
 	  		 String projectName=null;
	 	  
	 	  %> 
	 	  <table>
	 	  	<thead>
	 	  	<tr>
	 	  		<th>#</th>
	 	  		<th>Training Type</th>
	 	  		<th>training Date</th>
	 	  		<th>Training Duration</th>
	 	  		<th>Training learnings</th>
	 	  		<th>Comment</th>   
	 	  	</tr>
	 	  	</thead>
	 	  	<tbody>
	 	  	<%!int i=1; %>
	 	  	<% while(workTrainingRs.next()) { %>
	 	  	  	<tr>
	 	  	  	<form action="Control?action=addWorkTrainingComment" method="post">  
	 	  			<td><%=i %></td>
	 	  			<input type="hidden" name="wId" value="<%=workTrainingRs.getString("id")%>">
	 	  			<input type="hidden" name="trainingType" style="opacity:1;" value="<%=workTrainingRs.getString("train_type") %>">
	 	  			<td><%=workTrainingRs.getString("train_type") %></td>
	 	  			 
	 	  			<td><%=workTrainingRs.getString("train_date") %></td>
	 	  			<td><%=workTrainingRs.getString("train_time") %></td> 
 	  				<td><%=workTrainingRs.getString("train_topic") %></td>
 	  				<%if(workTrainingRs.getString("comment")==null) {%>
	 	  				<td><textarea style="width:300px;" required name="comment" placeholder="Enter Your Comment"></textarea></td>
		 	  			<td><input type="submit" style="opacity:1; margin-left:10px; width:100px;" value="Submit"></td>
 	  				<%} else if(workTrainingRs.getString("comment")!=null){ %>
	 	  				
	 	  				<td><textarea style="width:300px;" required name="comment"><%=workTrainingRs.getString("comment") %></textarea></td>
 	  				<%} %>
 	  				</form>
 	  			</tr>
 	  			
	 	  	<%i++;} %>
	 	  	
	 	  	</tbody>
	 	  
	 	  </table>
	 	   
    	</div>
 	</div>
</div>
  
<%} %>
<br><br><br> 
 
</body>
</html>