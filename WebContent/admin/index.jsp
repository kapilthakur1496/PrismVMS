<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">  
    <title>Sarva Hitkari Admin Dashboard - Home</title>
    <meta name="description" content="">
    <meta name="author" content="templatemo">
    
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,400italic,700' rel='stylesheet' type='text/css'>
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/templatemo-style.css" rel="stylesheet">
    
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

<style type="text/css">


input[type="submit"]
{
	background-color:white;
	color:#66bdd7; 
}
input[type="submit"]:hover
{
	background-color: #66bdd7; 
	color:white;
}

</style>


  </head>
  <body>  
  <%@ page import="java.sql.*" %>
<%@page import="java.lang.reflect.Array"%>
<%@ page import ="javax.sql.*" %>
<%@ page import="com.daniel.util.control.*"  %>
<%!   
ResultSet teamRs =null,branchRs=null,professionalSkillRs=null,grievanceRs=null,vmsCategoryRs=null;
ResultSet meetingRs =null,trainingRs=null,academicSkillRs=null,lifeSkillRs=null,softSkillRs=null;
ResultSet stateRs =null;
String adminId=null;
int adminStatus=0;
ResultSet contactDetails=null; 
%> 
<% 
	adminId = (String)session.getAttribute("adminId"); 
	if(adminId == null)
	{	
		adminId = (String)session.getAttribute("adminId"); 
	} 
	Control ct = new Control();
/* 	adminStatus= ct.getAdminType(request, response,adminId); */
 
if(adminId !=null){
%>  

    <!-- Left column -->
    <div class="templatemo-flex-row">
      <div class="templatemo-sidebar">
        <header class="templatemo-site-header"  >
        	<!-- <a href="index.html"> --><img src="../images/logo2.png" alt=" " >  <!--    </a>  -->    
	   </header>
        <div class="profile-photo-container">
          <img src="DisplayMentorPic?name=<%=2%>" alt="Profile Photo" class="img-responsive">  
          <div class="profile-photo-overlay"></div>
        </div>      
        <!-- Search box -->
        <form class="templatemo-search-form" role="search">
          <div class="input-group">
              <button type="submit" class="fa fa-search"></button>
              <input type="text" class="form-control" placeholder="Search" name="srch-term" id="srch-term">           
          </div>
        </form>
        <div class="mobile-menu-icon">
            <i class="fa fa-bars"></i>
        </div>
        <nav class="templatemo-left-nav">          
          <ul>
          	<li><a href="index.jsp" class="active"><i class="fa fa-users fa-fw"></i>Home</a></li>
            
            <li><a href="manageData.jsp"><i class="fa fa-home fa-fw"></i>Manage Data</a></li>
           <!--  <li><a href="data-visualization.html"><i class="fa fa-bar-chart fa-fw"></i>Charts</a></li>
            <li><a href="data-visualization.html"><i class="fa fa-database fa-fw"></i>Data Visualization</a></li>
            <li><a href="maps.html"><i class="fa fa-map-marker fa-fw"></i>Maps</a></li>
             -->
			
             <li><a href="manageUsers.jsp?pageNumber=1" ><i class="fa fa-users fa-fw"></i>Manage Users</a></li>
            <!-- <li><a href="preferences.html"><i class="fa fa-sliders fa-fw"></i>Preferences</a></li>
            <li><a href="login.html"><i class="fa fa-eject fa-fw"></i>Sign Out</a></li>
           --></ul>  
        </nav>
      </div>
      <!-- Main content --> 
      <div class="templatemo-content col-1 light-gray-bg">
        <div class="templatemo-top-nav-container">
           <div class="row">
            <nav class="templatemo-top-nav col-lg-12 col-md-12">
              <ul class="text-uppercase">
                <li><a href="" class="active">Admin panel</a></li>
                <li><a href="">Dashboard</a></li>
                <li><a href="">Overview</a></li>
                <li><a href="login.html">Sign in form</a></li>
              </ul>  
            </nav> 
          </div> 
        </div>
        <div class="templatemo-content-container">
          <div class="templatemo-flex-row flex-content-row">
            <div class="templatemo-content-widget white-bg col-2">
              <i class="fa fa-times"></i>
            <br>
             <!--  <h2 class="templatemo-inline-block">Visual Admin Template</h2><hr> -->
             	<form method="post" action="${pageContext.request.contextPath}/Control?action=addTeam" >
             	<input type="text" Placeholder=" Team Name"  required class="form-control" name="teamName">
             	 <br>
             	<input type="submit" class="form-control" value="Add Team" >
             	</form> <hr>  
              		<form action="${pageContext.request.contextPath}/Control?action=addSubCategory" method="post" >
              		 	  <select required class="form-control"   name="categoryId"> 
              				<option value="0">View Teams</option>
              				<%  
              					teamRs = ct.getTeams();
              				%>
              				<% while(teamRs.next() ){ %>
              					<option value="<%=teamRs.getString("id") %>"> <%=teamRs.getString("team_name") %></option>
              				<%} %> 
              			</select>  <br>
              	 
             		<input type="submit"   class="form-control" value="View" >
           
              		</form><hr> 
              		<form method="post" action="${pageContext.request.contextPath}/Control?action=addBranch" >
             	<input type="text" Placeholder=" Branch Name"  required class="form-control" name="branchName">
             	 <br>
             	<input type="submit" class="form-control" value="Add Branch" >
             	</form> <hr> 
             	<form action="${pageContext.request.contextPath}/Control?action=addSubCategory" method="post" >
              		 	  <select required class="form-control"   name="categoryId"> 
              				<option value="0">View Branch</option>
              				<% 	 
              				branchRs = ct.getBranch();
              				%>
              				<% while(branchRs.next() ){ %>
              					<option value="<%=branchRs.getString("id") %>"> <%=branchRs.getString("name") %></option>
              				<%} %> 
              			</select>  <br>
              	 
             		<input type="submit"   class="form-control" value="View" >
           
              		</form>
               </div>
                <div class="templatemo-content-widget white-bg col-2">
              <i class="fa fa-times"></i>
            <br>
             <!--  <h2 class="templatemo-inline-block">Visual Admin Template</h2><hr> -->
             	<form method="post" action="${pageContext.request.contextPath}/Control?action=addMeeting" >
	             	<input type="text" Placeholder="Meeting Type"  required class="form-control" name="meetingType">
	             	 <br>
	             	<input type="submit" class="form-control" value="Add Meeting Type" >
             	</form> <hr>  
              		<form action="" method="post" >
              		 	<select required class="form-control"   name="meetingType"> 
              				<option value="0">View Meeting</option>
              			  	<% 	 
              			   		meetingRs = ct.getMeetingType();
              				%>
              				<% while(meetingRs.next() ){ %>
              					<option value="<%=meetingRs.getString("id") %>"><%=meetingRs.getString("meeting_type") %></option>
              				<%} %>   
              			</select><br> 
             		<input type="submit" class="form-control" value="View" > 
              		</form><hr> 
              		<form action="${pageContext.request.contextPath}/Control?action=addTraining" method="post" >
              		 	<select required class="form-control"   name="teamId"> 
              				<option value="0">Choose Team  </option>
              				<% teamRs = ct.getTeams(); %>
              				<% while(teamRs.next() ){ %>
              					<option value="<%=teamRs.getString("id") %>"> <%=teamRs.getString("team_name") %></option>
              				<%} %> 
              			</select><br>
              		<input type="text"  required class="form-control" Placeholder="Training Type" name="trainingType">
             	 	<br>
             		<input type="submit" class="form-control" value="Add  Training Type" >
             	 
              		</form><hr>
              		 
              		<form name="getTrainingForm" action="${pageContext.request.contextPath}/Control?action=addTraining" method="post" >
              		 	<select required class="form-control"  onchange="loadXMLDoc()"  name="teamId"> 
              				<option value="0">Choose Team  </option>
              				<% teamRs = ct.getTeams();
              				%>
              				<% while(teamRs.next() ){ %>
              					<option value="<%=teamRs.getString("id") %>"> <%=teamRs.getString("team_name") %></option>
              				<%} %> 
              			</select><br>
	              		<input type="text"  required class="form-control" Placeholder="Training Type" name="trainingType">
	             	 	<br>
	             		<input type="submit" class="form-control" value="Add  Training Type" >
	             	<!-- 	<script type="text/javascript">
							function loadXMLDoc()
							{
								var xmlhttp;
								var keys=document.getTrainingForm.teamId.value;
								var urls="getTrainingType.jsp?teams="+keys;
								if (window.XMLHttpRequest)
								{// code for IE7+, Firefox, Chrome, Opera, Safari
								xmlhttp=new XMLHttpRequest();
								}
								else
								{// code for IE6, IE5
								xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
								}
								xmlhttp.onreadystatechange=function()
								{
									if (xmlhttp.readyState==4)
									{
										xmlDocumentElement =xmlhttp.responseXML.documentElement;
									 	document.getElementById("b").innerHTML=xmlDocumentElement.getElementsByTagName("trainingId")[0].childNodes[0].nodeValue;
										document.getElementById("c").innerHTML=xmlDocumentElement.getElementsByTagName("trainingName")[0].childNodes[0].nodeValue;
									}
								}
								xmlhttp.open("GET",urls,true);
								xmlhttp.send();
							}
						</script> -->
					  
 <!-- 
id: <span id="a"></span><br>
name: <span id="b"></span><br>
address: <span id="c"></span>
  -->
             	 	</form>
               </div>
            <div class="templatemo-content-widget white-bg col-2 text-center">
              	<i class="fa fa-times"></i>
              	<form method="post" action="${pageContext.request.contextPath}/Control?action=addGrievance" >
	             	<input type="text" Placeholder="Grievance Type"  required class="form-control" name="grievance">
	             	 <br>
	             	<input type="submit" class="form-control" value="Add Grievance Type" >
             	</form> <hr> 
             	<form action="" method="post" >
              		 	<select required class="form-control"   name="meetingType"> 
              				<option value="0">View Grievance Type</option>
              			  	<% 	 
              			  grievanceRs = ct.getGrievanceType();
              				%>
              				<% while(grievanceRs.next() ){ %>
              					<option value="<%=grievanceRs.getString("grievance") %>"><%=grievanceRs.getString("grievance") %></option>
              				<%} %>   
              			</select><br> 
             		<input type="submit" class="form-control" value="View" > 
              	</form><hr> 
              	<form method="post" action="${pageContext.request.contextPath}/Control?action=addVmsExperienceCategory" >
	             	<input type="text" Placeholder="VMS Experience Category  "  required class="form-control" name="category">
	             	 <br>
	             	<input type="submit" class="form-control" value="Add Category" >
             	</form> <hr> 
             	<form action="" method="post" >
              		 	<select required class="form-control"   name="meetingType"> 
              				<option value="0">View VMS Experience Category</option>
              			  	<%  vmsCategoryRs = ct.getVmsCategory(); %>
              				<% while(vmsCategoryRs.next() ){ %>
              					<option value="<%=vmsCategoryRs.getString("category") %>"><%=vmsCategoryRs.getString("category") %></option>
              				<%} %>   
              			</select><br> 
             		<input type="submit" class="form-control" value="View" > 
              	</form> 
              <%-- 	<form action="${pageContext.request.contextPath}/Control?action=addFaqDetails" method="post" >
              		<br>
              		<input type="text"  required class="form-control" Placeholder="FAQ Question" name="question">
              		<br>
              		<textarea  name="answer" placeholder="FAQ Answer" required class="form-control"></textarea>
              		<br>
             		<input type="submit" class="form-control" value="Add FAQ Details" >
             	</form> --%>
             	 
           	</div> 
    	</div>
         <div class="templatemo-flex-row flex-content-row">
          <!--  <div class="col-1">              
             <div class="templatemo-content-widget orange-bg">
               <i class="fa fa-times"></i>                
               <div class="media">
                 <div class="media-left">
                   <a href="#">
                     <img class="media-object img-circle" src="images/sunset.jpg" alt="Sunset">
                   </a>
                 </div>
                 <div class="media-body">
                   <h2 class="media-heading text-uppercase">Consectur Fusce Enim</h2>
                   <p>Phasellus dapibus nulla quis risus auctor, non placerat augue consectetur.</p>  
                 </div>        
               </div>                
             </div>            
             <div class="templatemo-content-widget white-bg">
               <i class="fa fa-times"></i>
               <div class="media">
                 <div class="media-left">
                   <a href="#">
                     <img class="media-object img-circle" src="images/sunset.jpg" alt="Sunset">
                   </a>
                 </div>
                 <div class="media-body">
                   <h2 class="media-heading text-uppercase">Consectur Fusce Enim</h2>
                   <p>Phasellus dapibus nulla quis risus auctor, non placerat augue consectetur.</p>  
                 </div>
               </div>                
             </div>            
           </div> -->
           <div class="col-2">
             <div class="panel panel-default templatemo-content-widget white-bg no-padding templatemo-overflow-hidden">
               <i class="fa fa-times"></i>
               <div class="panel-heading templatemo-position-relative"><h2 class="text-uppercase">User Table</h2></div>
               <div class="table-responsive">
                 <table class="table table-striped table-bordered">
                   <thead>
                     <tr>
                       <td>No.</td>
                       <td>Name</td>
                       <td>Email</td>
                       <td>Phone</td>
                       <td>Subject</td>
                       <td>Message</td>
                     </tr>
                   </thead>
                   <tbody>
                <%--    <% contactDetails = ct.viewContact();  %>
			<%! int j=1; %>
			
				<% while(contactDetails.next()){
					 %> 
                     <tr>
                       <td><%=j%>.</td>
                       <td><%=contactDetails.getString("name")%></td>
                       <td><%=contactDetails.getString("email")%></td>
                       <td><%=contactDetails.getString("phone")%></td>
                       <td><%=contactDetails.getString("subject")%></td>
                       <td><%=contactDetails.getString("message")%></td>
                     </tr>
                     <%j++; 
				} %>  --%>                   
                   </tbody>
                 </table>    
               </div>                          
             </div>
           </div>           
         </div> <!-- Second row ends -->
          <div class="templatemo-flex-row flex-content-row">
            <div class="templatemo-content-widget white-bg col-2">
              <i class="fa fa-times"></i>
            <br>
              	<form method="post" action="${pageContext.request.contextPath}/Control?action=addAcademicSkills" >
             	<input type="text" Placeholder="Academic Skill"  required class="form-control" name="academicSkill">
             	 <br>
             	<input type="submit" class="form-control" value="Add Academic Skill" >
             	</form><hr>  
              		<form action="${pageContext.request.contextPath}/Control?action=addSubCategory" method="post" >
              		 	  <select required class="form-control"   name="skillId"> 
              				<option value="0">View Academic Skill</option> 
              				<% academicSkillRs = ct.getAcademicSkill(); %>
              				<% while(academicSkillRs.next() ){ %>
              					<option value="<%=academicSkillRs.getString("skill_id") %>"> <%=academicSkillRs.getString("skill_name") %></option>
              				<%} %> 
              			</select>  <br>
              	 
             		<input type="submit"   class="form-control" value="View Academic Skill" >
           
              		</form><hr> 
              		<form method="post" action="${pageContext.request.contextPath}/Control?action=addLifeSkills" >
             	<input type="text" Placeholder=" Life Skill"  required class="form-control" name="lifeSkill">
             	 <br>
             	<input type="submit" class="form-control" value="Add Life Skill" >
             	</form> <hr> 
             	<form action="${pageContext.request.contextPath}/Control?action=addSubCategory" method="post" >
              		 	  <select required class="form-control"   name="categoryId"> 
              				<option value="0">ViewLife Skill</option>
              				 <% lifeSkillRs = ct.getLifeSkill(); %>
              				<% while(lifeSkillRs.next() ){ %>
              					<option value="<%=lifeSkillRs.getString("skill_id") %>"> <%=lifeSkillRs.getString("skill_name") %></option>
              				<%} %> 
              			</select>  <br>
              	 
             		<input type="submit"   class="form-control" value="View Life Skill" >
           
              		</form>
               </div>
                <div class="templatemo-content-widget white-bg col-2">
              <i class="fa fa-times"></i>
            	<br>
               
             	<form method="post" action="${pageContext.request.contextPath}/Control?action=addSoftSkills" >
             	<input type="text" Placeholder="Soft Skill"  required class="form-control" name="softSkill">
             	 <br>
             	<input type="submit" class="form-control" value="Add Soft Skill" >
             	</form> <hr>  
              		<form action="" method="post" >
              		 	<select required class="form-control"   name="softSkill"> 
              				<option value="0">View Soft Skills</option>
              			     <% softSkillRs = ct.getSoftSkill(); %>
              				<% while(softSkillRs.next() ){ %>
              					<option value="<%=softSkillRs.getString("skill_id") %>"> <%=softSkillRs.getString("skill_name") %></option>
              				<%} %> 
              			</select><br> 
             		<input type="submit" class="form-control" value="View Soft Skill" > 
              		</form><hr> 
              		<form action="${pageContext.request.contextPath}/Control?action=addProfessionalSkills" method="post" >
              		 	 
              		<input type="text"  required class="form-control" Placeholder="Professional Skill" name="professionalSkill">
             	 	<br>
             		<input type="submit" class="form-control" value="Add  Professional Skill" >
             	 
              		</form><hr>
              		 
              		<form  action="${pageContext.request.contextPath}/Control?action=addTraining" method="post" >
              		 	<select required class="form-control"    > 
              				<option value="0">Choose Professional Skill </option>
           				  	<% professionalSkillRs = ct.getProfessionalSkill(); %>
              				<% while(professionalSkillRs.next() ){ %>
              					<option value="<%=professionalSkillRs.getString("skill_id") %>"> <%=professionalSkillRs.getString("skill_name") %></option>
              				<%} %> 
              			</select><br>
	              		 
	             		<input type="submit" class="form-control" value="View  Professional Skill" >
	       
             	 	</form>
               </div>
            <div class="templatemo-content-widget white-bg col-2 text-center">
              	<i class="fa fa-times"></i>
              	<form action="${pageContext.request.contextPath}/Control?action=addInterViewSlot" method="post" >
              		<br>
              		 
              		<input type="date"  required class="form-control" Placeholder="Interview Date" name="interViewDate">
              		<br>
              		<input type="number" min="1"    required class="form-control" Placeholder="Available Seats" name="availableSeats">
              		<br>
              		<select required class="form-control" name="slotTime"  >
              		 		<option>Select InterView Time</option>
	           				<option value="09:00 AM">09:00 AM</option>
	           				<option value="10:00 AM">10:00 AM</option>
	           				<option value="11:00 AM">11:00 AM</option>
	           				<option value="12:00 PM">12:00 PM</option>
	           				<option value="01:00 PM">01:00 PM</option>
	           				<option value="02:00 PM">02:00 PM</option>
	           				<option value="03:00 PM">03:00 PM</option>
	           				<option value="04:00 PM">04:00 PM</option>
	           				<option value="05:00 PM">05:00 PM</option> 
	             		 
             		</select> <br> 
             		<textarea  name="venue" required class="form-control" placeholder="Interview Venue" ></textarea>
              		 <br> 
              		 <input type="submit" class="form-control" value="Add Interview Slot" >
	       
             	</form>
           	</div> 
    	</div>
    	 <div class="templatemo-flex-row flex-content-row">
          	<div class="col-2">
              <div class="panel panel-default templatemo-content-widget white-bg  templatemo-overflow-hidden">
               <i class="fa fa-times"></i>  
                     <h2 class="margin-bottom-10">Create Mentors </h2>
		            <p></p>
	           		<form action="${pageContext.request.contextPath}/Control?action=createMentor" class="templatemo-login-form" method="post" enctype="multipart/form-data">
		              	<div class="row form-group">
			                <div class="col-lg-4 col-md-4 form-group">                  
			                    <label for="inputFullName">Full Name</label>
			                    <input type="text" name="fullName"  required class="form-control" id="inputFullName" placeholder="Kapil Thakur">                  
			                </div>
			                 <div class="col-lg-4 col-md-4 form-group">                  
			                    <label for="inputEmail">Email</label>
			                    <input type="email" name="email" required class="form-control" id="inputEmail" placeholder="prism.mentor@gmail.com">                  
			                </div> 
			                 <div class="col-lg-4 col-md-4 form-group"> 
			                  	<label class="control-label templatemo-block">Select Teams</label>                 
			                  	<select required multiple name="team" class="templatemo-multi-select form-control" style="overflow-y: scroll;">
	                				<% 	teamRs = ct.getTeams();  %>
	              					<% while(teamRs.next() ){ %>
	              					<option value="<%=teamRs.getString("team_name") %>"><%=teamRs.getString("team_name") %></option>
	              					<% } %>  
           						</select> 
		              		</div>
		              	</div>
		              	<div class="row form-group"> 
		              		<div class="col-lg-4 col-md-4 form-group"> 
			                  	<label class="control-label templatemo-block">Select Branch</label>                 
			                  	<select required  name="branch" class="  form-control" style="overflow-y: scroll;">
	                				<% 	branchRs = ct.getBranch();  %>
	              					<% while(branchRs.next() ){ %>
	              					<option value="<%=branchRs.getString("id") %>"><%=branchRs.getString("name")%></option>
	              					<% } %>  
           						</select> 
		              		</div>
		              		<div class="col-lg-4 col-md-4 form-group"> 
	                  			<label class="control-label templatemo-block">Select User Type</label>                 
			                  	<select name="userType" class="form-control">
				                    <option value="Mentor">Mentor</option>                     
			                  	</select>
			                </div>
		              		<div class=" col-lg-4 col-md-4 form-group "><br>
		              		<label class="control-label templatemo-block"> </label>       
			                	<button type="submit" class="templatemo-blue-button" style="padding:8px 10px;">Create Mentor</button>
				                <button type="reset" class="templatemo-blue-button" style="padding:8px 35px;">Reset</button>
              				</div>
	              		</div>               
		            </form>                    
             	</div>
           	</div>           
         </div>  
      </div>
    </div>
     <%} %>
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
      
      // Callback that creates and populates a data table,
      // instantiates the pie chart, passes in the data and
      // draws it.
      function drawChart() {

          // Create the data table.
          var data = new google.visualization.DataTable();
          data.addColumn('string', 'Topping');
          data.addColumn('number', 'Slices');
          data.addRows([
            ['Mushrooms', 3],
            ['Onions', 1],
            ['Olives', 1],
            ['Zucchini', 1],
            ['Pepperoni', 2]
          ]);

          // Set chart options
          var options = {'title':'How Much Pizza I Ate Last Night'};

          // Instantiate and draw our chart, passing in some options.
          var pieChart = new google.visualization.PieChart(document.getElementById('pie_chart_div'));
          pieChart.draw(data, options);

          var barChart = new google.visualization.BarChart(document.getElementById('bar_chart_div'));
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
          });  
        }   
      });
      
    </script>
    <script type="text/javascript" src="js/templatemo-script.js"></script>      <!-- Templatemo Script -->

  </body>
</html>