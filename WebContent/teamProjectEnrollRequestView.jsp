<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
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
   
  
  
<div class="outercontainer" style="margin-top:0px; height:100px; background-color: #f8f8f8;">
	<div class="header-bottom-w3ls" style="padding:22px;">  
		<div class="row">
			<div class="col-md-2 logo-w3">
				<a href="mentorIndex.jsp"><img src="images/logo2.png" alt=" " /> </a>
				<div class="clearfix"></div>
			</div>  
			<div class="col-md-8 cart-wthree">  
			</div>
			<div class="col-md-2 cart-wthree">  
				 
					<a href="mentorLogout.jsp" class="w3view-cart"  style="color:#66bdd7;" ><br> Sign Out </a>
				  	 
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
</div>  
<% try{ %>
  
<%!  
	ResultSet teamProjectsRs=null;
	int mentorStatus=0; 
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
		if(adminId==null){ 
			response.sendRedirect("adminLogin.jsp?action=LoginAgain"); 
		}
	} 
	mentorStatus  = ct.checkMentorStatus(request, response,adminId);  
} catch (Exception e){ 	 	
}
if(mentorStatus == 1){
	pageNumber = Integer.parseInt(request.getParameter("pN")); 
	volunteerCount = ct.getTeamProjectEnrollRequestCount(adminId);
	pageCount= volunteerCount/10 +1;
	teamProjectsRs = ct.getTeamProjectEnrollment(request, response,pageNumber-1, nextRecordCount);  
 %>
 
 	
 
<div class="container" style="paddin:0px; margin-left:0px;">
    <div class="row">
        <div class="col-md-2 col-lg-3" >

            <div class="bootstrap-vertical-nav" >
	 
 
                <div   id="collapseExample"style="paddin:0px; margin-left:0px;" >
                    <ul class="nav flex-column" id="exCollapsingNavbar">
             			<li   class="nav-item" style="text-algin:center">
		                    <div class="center">
		                     <img src="DisplayMentorPic?name=<%=adminId %>" align="middle" style="  width: 80px;text-aling: center;margin-top: 11px;margin-left: 80px;height: 80px;border-radius: 50%;">
		                 	</div>
                 		</li>
                		<li class="nav-item" style="margin-bottom:17px;">
                       		<form action="#" method="post">
								<div   >
								 	<input    id="myInput" onkeyup="search()" type="text" style="opacity:1; padding: 12px 20px 12px 40px; background-image: url('images/searchicon.png'); background-position: 10px 10px; background-repeat: no-repeat; cursor:text; height:40px;"  name="productPrice" required="" placeholder="Search Feature">
									 <div class="clearfix"></div>
								</div> 
							</form>	
							<br><br>
                    	</li >
                   	</ul>
                    <ul class="nav flex-column" id="exCollapsingNavbar3">
	                      
                       	<li   class="nav-item">
                         	<a class="nav-link" href="mentorIndex.jsp">Home</a>
                        </li>
                        <li   class="nav-item">
                         	<a class="nav-link" href="mentorVolunteerWorkDiary.jsp?pN=1">Work Diary</a>
                        </li>
                        <li   class="nav-item">
                         	<a class="nav-link" href="mentorVolunteerMeeting.jsp?pN=1">Work Meeting</a>
                        </li>
                        <li   class="nav-item">
                         	<a class="nav-link" href="mentorVolunteerTraining.jsp?pN=1">Work Training</a>
                        </li>                       	 
                        <li  class="nav-item">
                            <a class="nav-link" href="individualProject.jsp?pN=1">Individual Projects</a>
                        </li> 
                        <li  class="nav-item">
                            <a class="nav-link" href="teamProject.jsp">Team Projects</a>
                        </li>
                        <li  class="nav-item">
                            <a class="nav-link" href="teamProjectView.jsp?pN=1">View Team Projects</a>
                        </li>
                        <li  class="nav-item">
                            <a class="nav-link active" href="teamProjectEnrollRequestView.jsp?pN=1"> Team Project Enroll Request</a>
                        </li>
                        <li   class="nav-item">
                            <a class="nav-link" href="branchProject.jsp">Branch Projects</a>
                        </li>
                        <li   class="nav-item">
                            <a class="nav-link" href="branchProjectView.jsp?pN=1">View Branch Projects</a>
                        </li>
                        <li  class="nav-item">
                            <a class="nav-link" href="branchProjectEnrollRequestView.jsp?pN=1"> Branch Project Enroll Request</a>
                        </li>   
                        <li   class="nav-item">
                            <a class="nav-link" href="viewMonthlyReport.jsp?pN=1">View Monthly Report</a>
                        </li>  
                        <li   class="nav-item">
                            <a class="nav-link" href="mentorVmsExperience.jsp">VMS Feedback</a>
                        </li>
                        <li   class="nav-item">
                            <a class="nav-link" href="mentorVmsExperienceView.jsp?pN=1">View VMS Feedback</a>
                        </li> 
                    </ul>
                </div> 
            </div> 
        </div>
        <div class="col-md-10 col-lg-9" style="padding:22px 10px;"> 
				<ul class="collapsible" data-collapsible="accordion" style="list-style:none; margin-left:auto; margin-right:auto;">
			 
				 <%while(teamProjectsRs.next()){ %>
					<li>
						<div class="collapsible-header active"><p style="padding:10px; background-color:#66bdd7; font-size:14px;">
							<span class="glyphicon glyphicon-pushpin" style="font-size:20px; color:#fff; font-size:22px; font-style: bold;"></span>&nbsp;&nbsp;
							<%=teamProjectsRs.getString("t.tproject_title") %>
							 
					  		<span style="float: right; margin-right: 39px;" >
						  		<i class="fa fa-users"  style="text-align: right; color:#fff; font-size:22px; font-style: bold;"> </i> &nbsp;&nbsp; 
							 	<%=teamProjectsRs.getString("v.team") %>  
							</span> 		
				 	 	</div> 
						<div class="collapsible-body" style="background-color: #fff;">
							<div class="col-lg-12"  >
							<div class="row"  >
									<div class="col-lg-4" style="padding:5px;  "> 
										<div class="info">
					 			 			<p><strong><i class="fa fa-user" style="font-size:20px; color:#fff;  "></i>  &nbsp;  &nbsp; Name</strong> &nbsp; <%=teamProjectsRs.getString("v.volunteer_name") %>      </p>
										</div>
									</div>
									<div class="col-lg-4" style="padding:5px;  "> 
										<div class="info">
					 			 			<p><strong><i class="fa phone" style="font-size:20px;  color:#fff;"></i> &nbsp;  &nbsp; Phone</strong> &nbsp; <%=teamProjectsRs.getString("v.contact_num") %>   </p>
										</div>
									</div>
									<div class="col-lg-4" style="padding:5px;  "> 
										<div class="info">
					 			 			<p><strong><i class="fa fa-fa-envelope" style="font-size:20px; color:#fff; "></i> &nbsp;  &nbsp; Email</strong> &nbsp; <%=teamProjectsRs.getString("v.email_id") %>   </p>
										</div>
									</div>
								</div>
								<div class="row"  >
									<div class="col-lg-6" style="padding:5px;  "> 
										<div class="info">
					 			 			<p><strong><i class="fa fa-calendar-o" style="font-size:20px;  "></i>  &nbsp;  &nbsp;  Start Date</strong> &nbsp; <%=teamProjectsRs.getString("t.tpro_start_date") %>      </p>
										</div>
									</div>
									<div class="col-lg-6" style="padding:5px;  "> 
										<div class="info">
					 			 			<p><strong><i class="fa fa-calendar-o" style="font-size:20px;  "></i> &nbsp;  &nbsp; End Date</strong> &nbsp; <%=teamProjectsRs.getString("t.tpro_end_date") %>   </p>
										</div>
									</div>
								</div>
								<br>
								<p style="font-size:16px;"><%=teamProjectsRs.getString("t.tproject_desc") %>  </p> 
								<br>
								<div style="text-align:center;  margin-left:-120px;"   >
								 	
								 	<form action="Control?action=teamProjectApproval" method="post">
								 		<input type="hidden" name="projectId" value="<%=teamProjectsRs.getString("t.id")%>">
								 		<input type="hidden" name="enrollId" value="<%=teamProjectsRs.getString("te.id")%>">
								  		<input type="hidden" name="vIds" value="<%=teamProjectsRs.getString("v.id")%>">
								  		
									  	<input type="submit"   ><i class="fa fa-check" style="color:#fff; font-size:22px;  "></i>Approve  
										&nbsp;&nbsp;&nbsp;&nbsp; 
								 	</form>
								 	
								 	<br>
									<a href="branchProjectEnrollRequestStatus.jsp?projectId=<%=teamProjectsRs.getString("te.id")%>&project=<%=teamProjectsRs.getString("t.tproject_title") %>&email=<%=teamProjectsRs.getString("v.email_id")%>"  ><i class="fa fa-close"   style="color:#fff; font-size:22px;  "></i>Reject </a>
								  
								</div>
							</div> 
					</div>
				</li>
				<%} %> 
				 <div class="col-lg-12 text-center" >
					<ul class="pagination " >
						<% for( int k=1; k<=pageCount; k++){ %>
					    	<li><a href="teamProjectEnrollRequestView.jsp?pN=<%=k%>"><%=k%></a></li>
					    <% } %> 
				 	</ul>
		 		</div>  
	  		</ul>
		 
	 
	 	 
	 
  
 			 
    	</div>
 	</div>
</div>
  
<%} %>

<br><br><br>  
<div class="footer" style="background-color:#f8f8f8;   height:50px;">
	 <p class="copy-right">� 2018 PrismVMS. All rights reserved | Design by <a href="#">Kapil Thakur & Anurag Goel</a></p>
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