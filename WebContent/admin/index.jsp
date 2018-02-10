<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">  
    <title>Sarva Hitkari Admin Dashboard - Home</title>
    <meta name="description" content="">
    <meta name="author" content="templatemo">
    <!-- 
    Visual Admin Template
    http://www.templatemo.com/preview/templatemo_455_visual_admin
    -->
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
ResultSet categoryRs =null;
ResultSet countryRs =null;
ResultSet stateRs =null;
ResultSet contactDetails=null;
Control ct = new Control();
%> 

    <!-- Left column -->
    <div class="templatemo-flex-row">
      <div class="templatemo-sidebar">
        <header class="templatemo-site-header"  >
        	<!-- <a href="index.html"> --><img src="../images/logo2.png" alt=" " >  <!--    </a>  -->    
	   </header>
        <div class="profile-photo-container">
          <img src="images/profile-photo.jpg" alt="Profile Photo" class="img-responsive">  
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
            <li><a href="manageData.jsp"><i class="fa fa-home fa-fw"></i>Manage Data</a></li>
           <!--  <li><a href="data-visualization.html"><i class="fa fa-bar-chart fa-fw"></i>Charts</a></li>
            <li><a href="data-visualization.html"><i class="fa fa-database fa-fw"></i>Data Visualization</a></li>
            <li><a href="maps.html"><i class="fa fa-map-marker fa-fw"></i>Maps</a></li>
             --><li><a href="manage-users.jsp?pageNumber=1" class="active"><i class="fa fa-users fa-fw"></i>Manage Users</a></li>
            <!-- <li><a href="preferences.html"><i class="fa fa-sliders fa-fw"></i>Preferences</a></li>
            <li><a href="login.html"><i class="fa fa-eject fa-fw"></i>Sign Out</a></li>
           --></ul>  
        </nav>
      </div>
      <!-- Main content --> 
      <div class="templatemo-content col-1 light-gray-bg">
        <div class="templatemo-top-nav-container">
         <!--  <div class="row">
            <nav class="templatemo-top-nav col-lg-12 col-md-12">
              <ul class="text-uppercase">
                <li><a href="" class="active">Admin panel</a></li>
                <li><a href="">Dashboard</a></li>
                <li><a href="">Overview</a></li>
                <li><a href="login.html">Sign in form</a></li>
              </ul>  
            </nav> 
          </div> -->
        </div>
        <div class="templatemo-content-container">
          <div class="templatemo-flex-row flex-content-row">
            <div class="templatemo-content-widget white-bg col-2">
              <i class="fa fa-times"></i>
            <br>
             <!--  <h2 class="templatemo-inline-block">Visual Admin Template</h2><hr> -->
             	<form method="post" action="${pageContext.request.contextPath}/Control?action=addCategory" >
             	<input type="text" Placeholder=" Category Name"  required class="form-control" name="category">
             	 <br>
             	<input type="submit" class="form-control" value="Add Category" >
             	</form> <hr>  
              		<form action="${pageContext.request.contextPath}/Control?action=addSubCategory" method="post" >
              		 	<select required class="form-control"   name="categoryId"> 
              				<option value="0">View Categories</option>
              				<% 	Control ct= new Control(); 
              			   		categoryRs = ct.viewproductCategory();
              				%>
              				<% while(categoryRs.next() ){ %>
              					<option value="<%=categoryRs.getString("id") %>"> <%=categoryRs.getString("name") %></option>
              				<%} %> 
              			</select><br>
              		<input type="text"  required class="form-control" Placeholder="Sub Category Name" name="subCategory">
             	 	<br>
             		<input type="submit" class="form-control" value="Add Sub Category" >
             	 
              		</form><hr> 
               </div>
                <div class="templatemo-content-widget white-bg col-2">
              <i class="fa fa-times"></i>
            <br>
             <!--  <h2 class="templatemo-inline-block">Visual Admin Template</h2><hr> -->
             	<form method="post" action="${pageContext.request.contextPath}/Control?action=addCountry" >
             	<input type="text" Placeholder=" Country Name"  required class="form-control" name="countryName">
             	 <br>
             	<input type="submit" class="form-control" value="Add Country" >
             	</form> <hr>  
              		<form action="${pageContext.request.contextPath}/Control?action=addState" method="post" >
              		 	<select required class="form-control"   name="countryId"> 
              				<option value="0">View Country</option>
              				<% 	 
              			   		countryRs = ct.viewCountry();
              				%>
              				<% while(countryRs.next() ){ %>
              					<option value="<%=countryRs.getString("id") %>"> <%=countryRs.getString("name") %></option>
              				<%} %> 
              			</select><br>
              		<input type="text"  required class="form-control" Placeholder="State Name" name="stateName">
             	 	<br>
             		<input type="submit" class="form-control" value="Add State" >
             	 
              		</form><hr> 
              		<form action="${pageContext.request.contextPath}/Control?action=addCity" method="post" >
              		 	<select required class="form-control"   name="stateId"> 
              				<option value="0">View States</option>
              				<% 	 
              			   		stateRs = ct.viewState();
              				%>
              				<% while(stateRs.next() ){ %>
              					<option value="<%=stateRs.getString("id") %>"> <%=stateRs.getString("name") %></option>
              				<%} %> 
              			</select><br>
              		<input type="text"  required class="form-control" Placeholder="City Name" name="cityName">
             	 	<br>
             		<input type="submit" class="form-control" value="Add City" >
             	 
              		</form><hr> 
               </div>
            <div class="templatemo-content-widget white-bg col-2 text-center">
              <i class="fa fa-times"></i>
              <form action="${pageContext.request.contextPath}/Control?action=addFaqDetails" method="post" >
              <br>
              		<input type="text"  required class="form-control" Placeholder="FAQ Question" name="question">
              		<br>
              		<textarea  name="answer" placeholder="FAQ Answer" required class="form-control"></textarea>
              		<br>
             		<input type="submit" class="form-control" value="Add FAQ Details" >
             	 
              		</form>
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
                    <% contactDetails = ct.viewContact();  %>
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
					} %>                    
                    </tbody>
                  </table>    
                </div>                          
              </div>
            </div>           
          </div> <!-- Second row ends -->
          <!-- <div class="templatemo-flex-row flex-content-row templatemo-overflow-hidden"> overflow hidden for iPad mini landscape view
            <div class="col-1 templatemo-overflow-hidden">
              <div class="templatemo-content-widget white-bg templatemo-overflow-hidden">
                <i class="fa fa-times"></i>
                <div class="templatemo-flex-row flex-content-row">
                  <div class="col-1 col-lg-6 col-md-12">
                    <h2 class="text-center">Modular<span class="badge">new</span></h2>
                    <div id="pie_chart_div" class="templatemo-chart"></div> Pie chart div
                  </div>
                  <div class="col-1 col-lg-6 col-md-12">
                    <h2 class="text-center">Interactive<span class="badge">new</span></h2>
                    <div id="bar_chart_div" class="templatemo-chart"></div> Bar chart div
                  </div>  
                </div>                
              </div>
            </div>
          </div>
          <footer class="text-right">
            <p>Copyright &copy; 2084 Company Name 
            | Designed by <a href="http://www.templatemo.com" target="_parent">templatemo</a></p>
          </footer>         
        </div>
      </div>
    </div>
     -->
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