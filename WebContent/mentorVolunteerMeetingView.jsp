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
<link rel="shortcut icon" href="images/logo2_.ico" />
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
	ResultSet workMeetingRs=null,branchRs=null;
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
		if(adminId==null){ 
			response.sendRedirect("adminLogin.jsp?action=LoginAgain"); 
		}
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
	                    	<div class="center">
	                     <img src="DisplayMentorPic?name=<%=adminId%>" align="middle" style="  width: 80px;text-aling: center;margin-top: 11px;margin-left: 80px;height: 80px;border-radius: 50%;">
	                 	</div>
	                 	</li>
                      	<li class="nav-item" style="margin-bottom:17px;">
                         	<form action="#" method="post">
								<div    >
									<input  type="text" style="opacity:1; cursor:text; height:40px;"  name="productPrice" required="" placeholder="Search Feature">
									<div class="clearfix"></div>
								</div>
								<button type="submit" style="height:40px; margin-top:6px;" class="btn btn-default search" aria-label="Left Align">
									<i class="fa fa-search" aria-hidden="true"> </i>
								</button> 
							</form>	
							<br><br>
                    	</li > 
                       	<li   class="nav-item">
                         	<a class="nav-link" href="mentorIndex.jsp">Home</a>
                        </li>
                        <li   class="nav-item">
                         	<a class="nav-link" href="mentorVolunteerWorkDiary.jsp?pN=1">Work Diary</a>
                        </li>
                        <li   class="nav-item">
                         	<a class="nav-link active" href="mentorVolunteerMeeting.jsp?pN=1">Work Meeting</a>
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
                            <a class="nav-link" href="teamProjectEnrollRequestView.jsp?pN=1"> Team Project Enroll Request</a>
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
	 	  <% String id= request.getParameter("vId");
	 	 	workMeetingRs = ct.getVolunteerWorkMeeting(request, response,id);
 	  		 String projectName=null;
	 	  
	 	  %> 
	 	  <table class="table table-bordered">
	 	  	<thead>
	 	  	<tr>
	 	  		<th>#</th>
	 	  		<th>Meeting Type</th>
	 	  		<th>Meeting Date</th>
	 	  		<th>Meeting Durations</th>
	 	  		<th>Comment</th>  
				<th>Meeting Discussion</th>
	 	  	</tr>
	 	  	</thead>
	 	  	<tbody>
	 	  	<%!int i=1; %>
	 	  	<% while(workMeetingRs.next()) { %>
	 	  	  	<tr>
	 	  	  	<form action="Control?action=addWorkMeetingComment" method="post">  
	 	  			<td><%=i %></td>
	 	  			<input type="hidden" name="wId" value="<%=workMeetingRs.getString("id")%>">
	 	  			<input type="hidden" name="meetingType" style="opacity:1; " value="<%=workMeetingRs.getString("meeting_type") %>">
	 	  			<td> <%=workMeetingRs.getString("meeting_type") %></td>
	 	  			<td><%=workMeetingRs.getString("meeting_date") %></td>
	 	  			<td><%=workMeetingRs.getString("total_hours") %></td> 
 	  				<td><%=workMeetingRs.getString("meeting_discuss") %></td>
 	  				
 	  				<%if(workMeetingRs.getString("comment")==null) {%>
	 	  				<td><textarea style="width:300px;" required name="comment" placeholder="Enter Your Comment"></textarea></td>
		 	  			<td><input type="submit" style="opacity:1; margin-left:10px; width:100px;" value="Submit"></td>
	 	  				<%} else if(workMeetingRs.getString("comment")!=null){ %>
	 	  				
	 	  				<td><textarea style="width:300px;" required name="comment"><%=workMeetingRs.getString("comment") %></textarea></td>
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