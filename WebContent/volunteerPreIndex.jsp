<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html> 
<html lang="en">
<head>
<title>Fashion Club an Ecommerce Online Shopping Category  Flat Bootstrap responsive Website Template | Register :: w3layouts</title>
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
<style type="text/css">
 body
 {
 overflow-x:hidden; 
 }
#regForm {
  background-color: #ffffff;
  margin: 0px auto;
  font-family: Raleway;
  padding: 40px;
  width: 70%;
  min-width: 300px;
}

h1 {
  text-align: center;  
}

input {
    padding: 10px;
  width: 90%;
  font-size: 17px;
  font-family: Raleway;
  border: none;
}
select
{
  padding: 10px;
  width: 95.2%;
  font-size: 17px;
  font-family: Raleway;
  border: none; 
}

input [type='date'] {
  padding: 10px;
  width: 40%;
  font-size: 17px;
  font-family: Raleway;
  border: none;
}


/* Mark input boxes that gets an error on validation: */
input.invalid,select.invalid {
  background-color: #ffdddd;
}
 
button {
  background-color: #66bdd7;
  color: #ffffff;
  border: none;
  padding: 10px 20px;
  font-size: 17px;
  font-family: Raleway;
  cursor: pointer;
}

button:hover {
  opacity: 0.8;
}

#prevBtn {
  background-color: #66bdd7;
}

/* Make circles that indicate the steps of the form: */
.step {
  height: 15px;
  width: 15px;
  margin: 0 2px;
  background-color: #bbbbbb;
  border: none;  
  border-radius: 50%;
  display: inline-block;
  opacity: 1;
}

.step.active {
  opacity: 1;   
}
.step.finish {
  opacity: 1;
  background-color: #66bdd7;
}

</style>
</head>
<body>
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
				 
					<a href="volunteerPreLogout.jsp" class="w3view-cart"  style="color:#66bdd7;" ><br> Sign Out </a>
				  	 
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
</div> 
	  			 
 
<%@ page import="java.sql.*" %>
<%@page import="java.lang.reflect.Array"%>
<%@ page import ="javax.sql.*" %>
<%@ page import="com.daniel.util.control.*"  %>  
  
<% try{ %>
 
<% Control ct = new Control(); 
String volunteerId=(String)session.getAttribute("volunteerId");
if(volunteerId==null){ 
	response.sendRedirect("volunteerLogin.jsp?action=LoginAgain"); 
}
String status = ct.getVolunteerApplicationStatus(volunteerId);
String name = ct.getVolunteerName(volunteerId);


	  %>
	<div class="main-agileits" style="width: 45%; margin-top: 63px; margin-bottom: 12px; padding: 30px 28px;">
	
	 <%if(status.equals("Approved")){ %>
	 <h3>Welcome <%=name %>! </h3>
	<br>
	   <h4>Congratulations  your Application is  <%=status %></h4>
	  <br>
	 
	<h4> <a href="volunteerLogin.jsp">click here</a> to View Your Profile.</h4>
	 <%} else {%>
	 <h3>Welcome <%=name %>! </h3>
	  <h4>You can check you application status <a href="volunteerPreLogin.jsp">here.</a>   </h4>
	 
	 <%} %>
	 </div>
	 
	 <%
} catch (Exception e){ 	 
	
}
%>  
	<br><br><br>  <br><br><br>  <br><br><br>  <br>   
<div class="footer" style="background-color:#f8f8f8;    height:50px;">
	 <p class="copy-right">© 2018 PrismVMS. All rights reserved | Design by <a href="#">Kapil Thakur & Anurag Goel</a></p>
</div>   
 
</body>
</html>