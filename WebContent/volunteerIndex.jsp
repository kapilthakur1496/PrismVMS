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
   
  
  
   <div class="outercontainer" style="margin-top:0px; height:100px; background-color: #f8f8f8;">
	<div class="header-bottom-w3ls" style="padding:22px;">  
		<div class="row">
			<div class="col-md-2 logo-w3">
				<a href="volunteerIndex.jsp"><img src="images/logo2.png" alt=" " /> </a>
				<div class="clearfix"></div>
			</div>  
			<div class="col-md-8 cart-wthree">  
			</div>
			<div class="col-md-2 cart-wthree">  
				 
					<a href="volunteerLogout.jsp" class="w3view-cart"  style="color:#66bdd7;" ><br> Sign Out </a>
				  	 
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
</div> 
<% try{ %>
  
<%!  
	ResultSet ngoDetail=null;
	int volunteerStatus=0; 
	String volunteerId=null,  PhoneNumber =null; ;
	ResultSet SubCategoryRs=null; 
	Control ct = new Control();
%>
<% 
	volunteerId = (String)session.getAttribute("volunteerId"); 
	if(volunteerId == null)
	{	
		volunteerId = (String)session.getAttribute("NgoId"); 
	} 
	volunteerStatus  = ct.checkVolunteerStatus(request, response,volunteerId);  
} catch (Exception e){ 	 	
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
	                     <img src="DisplayVolunteerPic?name=<%=volunteerId %>" align="middle" style="  width: 80px;text-aling: center;margin-top: 11px;margin-left: 80px;height: 80px;border-radius: 50%;">
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
                         	<a class="nav-link active" href="volunteerIndex.jsp">Home</a>
                        </li>
                        <li  class="nav-item">
                            <a class="nav-link" href="workDiary.jsp">Work Diary</a>
                        </li> 
                         <li  class="nav-item">
                            <a class="nav-link" href="workDiaryView.jsp">View Work Diary</a>
                        </li> 
                        <li  class="nav-item">
                            <a class="nav-link" href="workMeeting.jsp">Work Meeting</a>
                        </li>
                         <li  class="nav-item">
                            <a class="nav-link" href="meetingView.jsp">View Work Meeting</a>
                        </li>
                        <li   class="nav-item">
                            <a class="nav-link" href="workTraining.jsp">Work Training</a>
                        </li>
                        <li   class="nav-item">
                            <a class="nav-link" href="trainingView.jsp">View Work Training</a>
                        </li>
                         <li   class="nav-item">
                            <a class="nav-link" href="projectAssigned.jsp?pN=1">Project Assigned</a>
                        </li>
                        <li   class="nav-item">
                            <a class="nav-link" href="monthlyReport.jsp">Monthly Report</a>
                        </li>
                        <li   class="nav-item">
                            <a class="nav-link" href="monthlyReportView.jsp">View Monthly Report </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link  " href="viewTeamProject.jsp">View Team Project</a>
                        </li>
                        <li   class="nav-item">
                            <a class="nav-link" href="viewBranchProject.jsp">Branch Project</a>
                        </li>
                        <li   class="nav-item">
                            <a class="nav-link" href="grievance.jsp">Grievance</a>
                        </li>
                        <li   class="nav-item">
                            <a class="nav-link" href="grievanceView.jsp">View Grievance  </a>
                        </li>
                        <li   class="nav-item">
                            <a class="nav-link" href="vmsExperience.jsp">VMS Feedback</a>
                        </li>
                         <li   class="nav-item">
                            <a class="nav-link" href="viewVmsExperience.jsp?pN=1">View VMS Feedback</a>
                        </li> 
                    </ul>
                </div> 
            </div> 
        </div>
        <div class="col-md-10 col-lg-9" style="padding:22px 10px;">
        
        <%   PhoneNumber = ct.getPhone(volunteerId);  
        
        	 
        %>
              <div class="container">
        <div class="modal fade" id="myModal" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h3 class="modal-title" >Edit Details</h3>
                        <h6 style="margin-bottom: 0;margin-top: 0">(Double click field to edit)</h6>
                    </div>
                    <form  name="f1" enctype="multipart/form-data"  action="VolunteerEditDetails" method="post" onSubmit="return validate()">

                    <div class="modal-body" style="margin-left: 18%">
                        <div class="container">

                        <div>
                             <div  class="btn btn-default" style="margin-left:0; margin-right: 0;margin-top: 0;">
                                 <label>Profile Picture: </label>
                                <input type="file" id="profile_pic" style="opacity:1; margin-top:-15px; margin-left:2px;"  name="playerphoto"  accept="image/*"  onchange="loadFile(event)">
                                </div>
                                <img id="output"/>
                        </div>
                            <br>
                            <table>

                            
                            <div>
                                <td><label>Contact Number : </label></td>
                                <td><input name=current_conact type="text" style="opacity:1; width:250px; margin-top:-22px;"  class="" readonly="true" value="<%=PhoneNumber%>" ondblclick="this.readOnly='';"></td>
                            </div>
                                 
                           
                                
                            </table>
                        </div>
                        </div>

                    <div class="modal-footer">
                        <span><p id="msg" style="color: red; font-size:17px; display: inline-block;" > </p></span>
                        <br> <input  type="submit"  class="btn btn-info" style="margin-top: -1px; margin-left:-105px; width:100px; opacity:1; margin-right: 0 "  value="Update" >
                    
                        <button type="button" class="btn btn-default" style="margin-top: 0; margin-right: 0" data-dismiss="modal">Close</button>
                        <%--<div class=" form-row col-lg-12 text-center" style="" >--%>
                            <%--<br><br>--%>
                               <%--</div>--%>
                    </div>
                    </form>
                </div>

            </div>
        </div>
    </div>
    <a href="#"  data-toggle="modal" data-target="#myModal" class="btn btn-info"> Edit Profile</a>
            
    	</div>
 	</div>
</div>
  
<%} %>
<br><br><br> 
<div class="footer" style="background-color:#f8f8f8;   height:50px;">
	 <p class="copy-right">© 2018 PrismVMS. All rights reserved | Design by <a href="#">Kapil Thakur & Anurag Goel</a></p>
</div> 
	  

	  
</body>
</html>