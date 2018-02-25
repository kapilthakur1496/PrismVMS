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
	int workDiary=0, workMeeting=0,workTraining=0,project=0,teamprojects=0,branchProject=0;
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
        
        <%   PhoneNumber = ct.getPhone(volunteerId);  %>
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
             <div class="templatemo-flex-row flex-content-row templatemo-overflow-hidden"> <!-- overflow hidden for iPad mini landscape view-->
            <div class="col-1 templatemo-overflow-hidden">
              <div class="templatemo-content-widget white-bg templatemo-overflow-hidden">
                 
                <div class="templatemo-flex-row flex-content-row">
                  <div class="col-1 col-lg-6 col-md-12">
                    <h2 class="text-center">Modular<span class="badge">new</span></h2>
                    <div id="pie_chart_div" class="templatemo-chart"></div> <!-- Pie chart div -->
                  </div>
                  <div class="col-1 col-lg-6 col-md-12">
                    <h2 class="text-center">Interactive<span class="badge">new</span></h2>
                    <div id="bar_chart_div" class="templatemo-chart"></div> <!-- Bar chart div -->
                  </div>  
                </div>    
                <div class="templatemo-flex-row flex-content-row">
                  <div class="col-1 col-lg-6 col-md-12">
                    <h2 class="text-center">Modular<span class="badge">new</span></h2>
                    <div id="pie_chart_div1" class="templatemo-chart"></div> <!-- Pie chart div -->
                  </div>
                  <div class="col-1 col-lg-6 col-md-12">
                    <h2 class="text-center">Interactive<span class="badge">new</span></h2>
                    <div id="bar_chart_div1" class="templatemo-chart"></div> <!-- Bar chart div -->
                  </div>  
                </div>              
              </div>
            </div>
          </div>
    	</div>
 	</div>
</div>
  
<%}%>
<br><br><br> 
<div class="footer" style="background-color:#2A3F54;   height:50px;">
	 <p class="copy-right">� 2018 PrismVMS. All rights reserved | Design by <a href="#">Kapil Thakur & Anurag Goel</a></p>
</div> 
	 <% workDiary = ct.getWorkDiaryCount(request,response);
	workMeeting = ct.getWorkMeetingCount(request,response);
	workTraining = ct.getWorkTrainingCount(request,response);
	project = ct.getVolunteerProjectCount(request,response);
	teamprojects = ct.getVolunteerTeamProjectCount(request,response);
	branchProject = ct.getVolunteerBranchProjectCount(request,response); %>
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
	  
    <!-- JS -->
    <script src="js/jquery-1.11.2.min.js"></script>      <!-- jQuery -->
    <script src="js/jquery-migrate-1.2.1.min.js"></script> <!--  jQuery Migrate Plugin -->
    <script src="https://www.google.com/jsapi"></script> <!-- Google Chart -->
    <script>
      /* Google Chart 
      -------------------------------------------------------------------*/
      // Load the Visualization API and the piechart package.
      google.load('visualization', '1.0', {'packages':['corechart']});

      // Set a callback to run when the Google Visualization API is loaded.
      google.setOnLoadCallback(drawChart); 
      google.setOnLoadCallback(drawChart); 
      
      // Callback that creates and populates a data table,
      // instantiates the pie chart, passes in the data and
      // draws it.
      function drawChart() {

          // Create the data table.
          var data = new google.visualization.DataTable();
          data.addColumn('string', 'Topping');
          data.addColumn('number', 'Work Diary'); 
          
          data.addRows([
            ['Work Diary', <%=workDiary%>],
            ['Work Meeting', <%=workMeeting%>],
            ['Work Training', <%=workTraining%>] 
             
          ]);

          // Set chart options
          var options = {'title':'How Many Work Diaries, Work Meeting and Work Trainings Submitted'};

          // Instantiate and draw our chart, passing in some options.
          var pieChart = new google.visualization.PieChart(document.getElementById('pie_chart_div'));
          pieChart.draw(data, options);

          var barChart = new google.visualization.BarChart(document.getElementById('bar_chart_div'));
          barChart.draw(data, options);
      }
      function drawChart1() {

          // Create the data table.
          var data = new google.visualization.DataTable();
          data.addColumn('string', 'Topping');
          data.addColumn('number', 'Projects'); 
          
          data.addRows([
            ['Individual ', <%=project%>],
            ['Team', <%=teamprojects%>],
            ['Branch', <%=branchProject%>] 
             
          ]);

          // Set chart options
          var options = {'title':'How Indvidual Projects, Team Projects and Branch Projects are Assigned'};

          // Instantiate and draw our chart, passing in some options.
          var pieChart = new google.visualization.PieChart(document.getElementById('pie_chart_div1'));
          pieChart.draw(data, options);

          var barChart = new google.visualization.BarChart(document.getElementById('bar_chart_div1'));
          barChart.draw(data, options);
      }

      $(document).ready(function(){
        if($.browser.mozilla) {
          //refresh page on browser resize
          // http://www.sitepoint.com/jquery-refresh-page-browser-resize/
          $(window).bind('resize', function(e)
          {
            if (window.RT) clearTimeout(window.RT);
            window.RT = setTimeout(function()
            {
              this.location.reload(false); /* false to get page from cache */
            }, 200);
          });      
        } else {
          $(window).resize(function(){
            drawChart();
            drawChart1();
          });  
        }   
      });
      
    </script>
</body>
</html>