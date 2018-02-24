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
<%!  
	ResultSet professionalSkillRs=null,academicSkillRs=null,lifeSkillRs=null,softSkillRs=null;
	Control ct = new Control();
%>
 
	 
<form action="Control?action=volunteerChooseSkills" method="post" onSubmit="return validateChecks()">
	<div class="container" style="paddin:0px; margin-left:150px;  ">
	    <div class="row" style="height:400px;"><br>
	        <div class="col-md-3 col-lg-3" style="text-algin:center; ">
				<h4 style="text-align:left; margin-bottom:15px;" >Academic Skills</h4>
				<% academicSkillRs = ct.getAcademicSkill(); %>
		        <% while(academicSkillRs.next() ){ %>
		           <label class="container"> <%=academicSkillRs.getString("skill_name") %> 
						  <input type="checkbox" value="<%=academicSkillRs.getString("skill_name") %>" name="skills" >
						  <span class="checkmark"></span>
					</label>
		       <%} %>  
	        </div>
	         <div class="col-md-3 col-lg-3" >
				
	           <h4 style="text-align:left; margin-bottom:15px;">Life Skills</h4>   
				 
				 
				 <% lifeSkillRs = ct.getLifeSkill(); %>
	            	<% while(lifeSkillRs.next() ){ %>
	             	<label class="container"> <%=lifeSkillRs.getString("skill_name") %> 
						  <input type="checkbox" value="<%=lifeSkillRs.getString("skill_name") %>" name="skills"  >
						  <span class="checkmark"></span>
					</label>
		       <%} %>   
	        </div>
	         <div class="col-md-3 col-lg-3" >
				<h4 style="text-align:left; margin-bottom:15px;">Professional Skills</h4> 
				 <% softSkillRs = ct.getSoftSkill(); %>
	             <% while(softSkillRs.next() ){ %>
	              	<label class="container"> <%=softSkillRs.getString("skill_name") %> 
						  <input type="checkbox"  value="<%=softSkillRs.getString("skill_name") %>" name="skills" >
						  <span class="checkmark"></span>
					</label>
		       <%} %> 
	              					 
	        </div>
	        <div class="col-md-3 col-lg-3" >
				<h4 style="text-align:left; margin-bottom:15px;">Soft Skills</h4> 
				<% professionalSkillRs = ct.getProfessionalSkill(); %>
	            <% while(professionalSkillRs.next() ){ %>
	            	<label class="container"> <%=professionalSkillRs.getString("skill_name") %> 
						  <input type="checkbox" value="<%=professionalSkillRs.getString("skill_name") %>" name="skills" >
						  <span class="checkmark"></span>
					</label>
		       <%} %> 			
	           
	        </div>
	        
	 	</div>
	 	<div class="key">
			<i class="fa fa-paragraph" aria-hidden="true"></i>
			<textarea name="additionalSkills" style="width:94%;" placeholder="Write Addtional Skills"></textarea>
			<div class="clearfix"></div>
		</div> 
		<div class="key">
			<i class="fa fa-paragraph" aria-hidden="true"></i>
			<textarea required name="background" style="width:94%;" placeholder="Write Backgorund and Achievements"></textarea>
			<div class="clearfix"></div>
		</div> 
		 <div class="row" style="margin-top:-10px;"> 
		 	<div class="col-md-9 col-lg-9" style="text-algin:right;  ">
		 	</div>
		 <div class="col-md-3 col-lg-3" >
		<input type="submit" class="form-control" style="opacity:1; width:50%;" value="Next" >
	   </div>
	       </div>
	 	
	</div>
</form>
 
 

     <br><br><br> 
<div class="footer" style="background-color:#f8f8f8;   height:50px;">
	 <p class="copy-right">© 2018 PrismVMS. All rights reserved | Design by <a href="#">Kapil Thakur & Anurag Goel</a></p>
</div> 
	     <div id="snackbar"></div>
	 <script type="text/javascript">
	  
	 function validateChecks() {
     	
  		var chks =  document.getElementsByName('vIds');
  		var checkCount = 0;
  		for (var i = 0; i < chks.length; i++) {
  			if (chks[i].checked) {
  				checkCount++;
  			}
  		}
  		if (checkCount < 1) {
  			
  			var x = document.getElementById("snackbar")
  		    x.className = "show";
  		    x.innerHTML="Select at least one skill";
  		    setTimeout(function(){ x.className = x.className.replace("show", ""); }, 3000);
  		 
  			return false;
  		}
  		return true;
  	}
	 </script>
</body>
</html>