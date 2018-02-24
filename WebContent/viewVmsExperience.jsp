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
    
<%
    Connection connection=DbUtil.getConnection();
%>
  
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
	ResultSet vmsExperinceRs=null,vmsExperinceCommentRs=null;
	int volunteerStatus=0; 
	String volunteerId=null,name=null,comment=null;
	ResultSet SubCategoryRs=null; 
	int volunteerCount =0, pageCount = 0;
	int pageNumber=0, nextRecordCount=10;	
	Control ct = new Control();
	 
%>
<% 
	volunteerId = (String)session.getAttribute("volunteerId"); 
	if(volunteerId == null)
	{	
		volunteerId = (String)session.getAttribute("volunteerId"); 
		if(volunteerId==null){ 
			response.sendRedirect("volunteerLogin.jsp?action=LoginAgain"); 
		}
	} 
	volunteerStatus  = ct.checkVolunteerStatus(request, response,volunteerId);  
} catch (Exception e){ 	 	
}
if(volunteerStatus == 1){
	 
	pageNumber = Integer.parseInt(request.getParameter("pN")); 
	volunteerCount = ct.volunteerVmsExperienceCount(volunteerId);
	pageCount= volunteerCount/10 +1;
	vmsExperinceRs = ct.getVmsExperience(request, response,pageNumber-1, nextRecordCount);  
	/* ct.teamVolunteerDetails(pageNumber-1, nextRecordCount,adminId,branchId); */
	
%>  	
 
<div class="container" style="paddin:0px; margin-left:0px;">
    <div class="row">
        <div class="col-md-2 col-lg-3" >

            <div class="bootstrap-vertical-nav" >
	 
 
                <div   id="collapseExample"style="paddin:0px; margin-left:0px;" >
                     <ul class="nav flex-column" id="exCollapsingNavbar">
             			<li   class="nav-item" style="text-algin:center">
		                    <div class="center">
		                     <img src="DisplayVolunteerPic?name=<%=volunteerId %>" align="middle" style="  width: 80px;text-aling: center;margin-top: 11px;margin-left: 80px;height: 80px;border-radius: 50%;">
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
                         	<a class="nav-link" href="volunteerIndex.jsp">Home</a>
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
                            <a class="nav-link active" href="viewVmsExperience.jsp?pN=1">View VMS Feedback</a>
                        </li> 
                    </ul>
                </div> 
            </div> 
        </div>
        <div class="col-md-10 col-lg-9" style="padding:22px 10px;">
              <ul class="collapsible" data-collapsible="accordion" style="list-style:none; margin-left:auto; margin-right:auto;">
			 <%!int j=1; %>
			  <% while(vmsExperinceRs.next()){%>
					<li>
						<div class="collapsible-header active"><p style="padding:10px; background-color:#66bdd7; font-size:14px;">
							<span class="glyphicon glyphicon-pushpin" style="font-size:20px; color:#fff; font-size:22px; font-style: bold;"></span>&nbsp;&nbsp;
							 <%=ct.getVolunteerName(vmsExperinceRs.getString("volunteer_registration_id"))%>
							 
					  		<span style="float: right; margin-right: 39px;" >
						  		<span class="glyphicon glyphicon-record" style="color:#fff; font-size:18px;"></span> &nbsp;&nbsp; 
							<%= vmsExperinceRs.getString("request_status") %>
							</span> 		
				 	 	</div> 
						<div class="collapsible-body" style="background-color: #fff;">
							<div class="col-lg-12" style="margin-left:8px;">
							<br><%= vmsExperinceRs.getString("category") %>
								<br><br>
								<p style="font-size:16px;"><%=vmsExperinceRs.getString("description") %>  </p> 
								<br>
								<div style="text-align:center;">
									<a href="#" data-toggle="modal" data-target="#myModal<%=j%>" style="margin-left:auto; margin-right:auto;"><i class="	fa fa-comments-o" style="color:#66bdd7; font-size:22px;  "></i> Chat</a>
								</div>
							</div> 
					</div>
					<%comment = vmsExperinceRs.getString("id");%> 
					<%vmsExperinceCommentRs = ct.getVmsExperienceComment(request,response,vmsExperinceRs.getString("id"));%>
					<div class="modal fade" id="myModal<%=j%>" role="dialog">
					    <div class="modal-dialog">
					    
					      <!-- Modal content-->
					      <div class="modal-content">
					        <div class="modal-header">
					          <button type="button" class="close" data-dismiss="modal">&times;</button>
					          <h4 class="modal-title">VMS Experience Chat Box</h4>
					        </div>
					        <div class="modal-body">
					        	<%while(vmsExperinceCommentRs.next()){  
					        	if(vmsExperinceCommentRs.getString("volunteer_registration_id")!=null){%>
					        <div style="width:100%;margin:2px; background: #e5e5e5; padding:5px; border-radius:2px; border: 1px solid #cccccc;-webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075); -moz-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);    box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);    -webkit-transition: border linear 0.2s, box-shadow linear 0.2s;    -moz-transition: border linear 0.2s, box-shadow linear 0.2s;    -o-transition: border linear 0.2s, box-shadow linear 0.2s;    transition: border linear 0.2s, box-shadow linear 0.2s;  float:right; text-align:left;">
	                                
	                                <span>
                                        <img src="DisplayVolunteerPic?name=<%=vmsExperinceCommentRs.getString("volunteer_registration_id")%>" align="left" style="width:40px; height:40px; border-radius: 50%;"> &nbsp; &nbsp;
                                        <%=vmsExperinceCommentRs.getString("comment")%> <span></span>
                                        <p style="text-align: right; padding:0px;" >
                                            <span>
                                              <%=vmsExperinceCommentRs.getString("comment_time")%>
                                            </span>
                                        </p>
                                </div>
                                <%}else if(vmsExperinceCommentRs.getString("admin_id")!=null){ %>
                                <div style="width:100%;margin:2px; background: #e5e5e5; padding:5px; border-radius:2px; border: 1px solid #cccccc;-webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075); -moz-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);    box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);    -webkit-transition: border linear 0.2s, box-shadow linear 0.2s;    -moz-transition: border linear 0.2s, box-shadow linear 0.2s;    -o-transition: border linear 0.2s, box-shadow linear 0.2s;    transition: border linear 0.2s, box-shadow linear 0.2s;  float:right; text-align:left;">
	                                
	                                <span>
                                        <img src="DisplayMentorPic?name=<%=vmsExperinceCommentRs.getString("admin_id")%>" align="left" style="width:40px; height:40px; border-radius: 50%;"> &nbsp; &nbsp;
                                        <%=vmsExperinceCommentRs.getString("comment")%> <span></span>
                                        <p style="text-align: right; padding:0px;" >
                                            <span>
                                              <%=vmsExperinceCommentRs.getString("comment_time")%>
                                              
                                               
                                            </span>
                                        </p>
                                </div>
                                <%}} %>
                                
                                 <div class="row" style=" float:left; text-align:center; bottom:0px;width:100%;">
                                    <form style="width:100%" method="post" action="Control?action=addVmsExperienceComment">
                                        <input type="hidden" name="id" value="<%=comment%>">
                                        <textarea  placeholder='Comment Box'     style="  background: #ddd;  padding:5x; color:#333; width:89.5%; border-radius: 2px;
border: 1px solid #cccccc;" required name="comment" rows="3" cols="80"></textarea>
                                        <input type="submit"  style="background:transparent;width: 38px;
    margin-top: 88px; opacity:1; color:#337ab7; display: inine-block; font-size: 36px; height:48px; border: none;"   class=" glyphicon"  value="&#xe171;"> </input>
                                    </form>
                                </div>
					        </div>
					        <div class="modal-footer">
					          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					        </div>
					      </div>
					      
					    </div>
  </div>
				</li>
				<%} %> 
				 <div class="col-lg-12 text-center" style="margin-left:auto; margin-right:auto;">
					<ul class="pagination " >
						<% for( int k=1; k<=pageCount; k++){ %>
					    	<li><a href="teamProjectView.jsp?pN=<%=k%>"><%=k%></a></li>
					    <% } %> 
				 	</ul>
		 		</div>  
	  		</ul>
		 
	 
               
               
               
    	</div>
 	</div>
</div>
   <% } %>
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