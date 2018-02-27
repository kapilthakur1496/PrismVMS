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
   
<div class="outercontainer" style="margin-top:0px; height:100px; background-color: #2A3F54;">
	<div class="header-bottom-w3ls" style="padding:22px;">  
		<div class="row">
			<div class="col-md-2 logo-w3">
				<a href="mentorIndex.jsp"><img src="images/logo2.png" alt=" " /> </a>
				<div class="clearfix"></div>
			</div>  
			<div class="col-md-8 cart-wthree">  
			</div>
			<div class="col-md-2 cart-wthree">  
				 
					<a href="mentorLogout.jsp" class="w3view-cart"  style="color:#fff;" ><br> Sign Out </a>
				  	 
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
</div>   
<% try{ %>
  
<%!  
	ResultSet ngoDetail=null;
	int mentorStatus=0; 
	String adminId =null,PhoneNumber=null;
	ResultSet SubCategoryRs=null; 
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
	int branchProjectcount = ct.volunteerBranchProjectCount(adminId);
	int teamProjectcount = ct.volunteerTeamProjectCount(adminId);
	
%>  	
 
<div class="outercontainer" style="padding-top:0px;  padding-right:10px; margin-left:10px; margin-top:10px; margin-right:15px;">
    <div class="row">
        <div class="col-md-2 col-lg-3 col-sm-4 col-xs-12" >

            <div class="bootstrap-vertical-nav" >
 
                <div   id="collapseExample" style="margin-top:3px;" >
                    <ul class="nav flex-column" id="exCollapsingNavbar">
             			<li   class="nav-item" style="text-algin:center">
		                    <div class="text-center">
		                     <img src="DisplayMentorPic?name=<%=adminId %>" align="middle" style="  width: 80px;text-aling: center;margin-top: 11px; height: 80px;border-radius: 50%;">
		                 	</div>
                 		</li>
                		<li class="nav-item" >
                       		<form action="#" method="post">
								<div   >
								 	<input    id="myInput" onkeyup="search()" type="text" style="opacity:1; padding: 12px 20px 12px 40px; background-image: url('images/searchicon.png'); background-position: 10px 10px; background-repeat: no-repeat; cursor:text; height:40px;"  name="productPrice" required="" placeholder="Search Feature">
									 <div class="clearfix"></div>
								</div> 
							</form>
                    	</li >
                   	</ul>
                    <ul class="nav flex-column" id="exCollapsingNavbar3">
	                     
                       	<li   class="nav-item">
                         	<a class="nav-link active" href="mentorIndex.jsp">Home</a>
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
         
        <div  class="col-md-10 col-lg-9 col-sm-9 col-xs-12" style="padding:3px 0px;">
        <%   PhoneNumber = ct.getMentorPhone(adminId);   %>
             <div class="container">
		        <div class="modal fade" id="myModal" role="dialog">
		            <div class="modal-dialog">
		                <div class="modal-content">
		                    <div class="modal-header">
		                        <button type="button" class="close" data-dismiss="modal">&times;</button>
		                        <h3 class="modal-title" >Edit Details</h3>
		                        <h6 style="margin-bottom: 0;margin-top: 0">(Double click field to edit)</h6>
		                    </div>
		                    <form  name="f1" enctype="multipart/form-data"  action="MentorEditDetails" method="post" onSubmit="return validate()">
		
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
    		<a href="#"  data-toggle="modal" data-target="#myModal"  class="btn btn-info btn-block"> Edit Profile</a>
         </div>
 	</div>
</div>
  
  
  
<%} %>
<br><br><br>  
<div class="footer" style="background-color:#2A3F54;   height:50px;">
	 <p class="copy-right">� 2018 PrismVMS. All rights reserved | Design by <a href="#">Kapil Thakur & Anurag Goel</a></p>
</div> 

<script type="text/javascript">
    function validate()
    {

        var fld = document.f1.current_conact.value;

        if (isNaN(fld)) {
             
            document.getElementById('msg').innerHTML = "Contact number is not valid";


            return false;
        }
        else if (!(fld.length == 10)) {
             
            document.getElementById('msg').innerHTML = "Contact number is not valid";
            return false;
        }

        var fuData = document.getElementById('profile_pic');
        var FileUploadPath = fuData.value;

        var Extension = FileUploadPath.substring(FileUploadPath.lastIndexOf('.') + 1).toLowerCase();


        if(FileUploadPath == '')
        {
            return true
        }
        else {

            if (Extension == "gif" || Extension == "png" || Extension == "bmp"
                || Extension == "jpeg" || Extension == "jpg") {


                if (fuData.files && fuData.files[0]) {

                    var size = fuData.files[0].size;

                    if(size >500000 ){
                        
                        document.getElementById('msg').innerHTML = "File too large (Max Picture Size 500KB)";

                        return false;
                    }else{
                        var reader = new FileReader();

                        reader.onload = function(e) {
                            $('#blah').attr('src', e.target.result);
                        };

                        reader.readAsDataURL(fuData.files[0]);
                    }
                }

            }
            else {
                document.getElementById('msg').innerHTML = "Photo only allows file types of GIF, PNG, JPG, JPEG and BMP.";
                return false;
            }}


    }

</script>
 
	 
</body>
</html>