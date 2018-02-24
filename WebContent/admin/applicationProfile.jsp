<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">  
    <title>PrismVMS Admin</title>
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

  </head>
  <body>  
  <%@ page import="java.sql.*" %>
	<%@page import="java.lang.reflect.Array"%>
	<%@ page import ="javax.sql.*" %>
	<%@ page import="com.daniel.util.control.*"  %> 
	<%!   
		String adminId=null;
		int adminStatus=0; 
	%> 
				<%! 
					ResultSet volunteerDetailsRs=null,teamRs=null,branchRs=null;
				 	int volunteerCount =0, pageCount = 0;
					Control ct = new Control();
					int pageNumber=0, nextRecordCount=10;	
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
	Control ct = new Control();
  	adminStatus= ct.getAdminType(request, response,adminId);  
if(adminId !=null){
%> 
    <!-- Left column -->
    <div class="templatemo-flex-row">
      <div class="templatemo-sidebar">
        <header class="templatemo-site-header">
          <header class="templatemo-site-header"  >
        	<!-- <a href="index.html"> --><img src="../images/logo2.png" alt=" " >   <!--   </a>   -->   
	   </header>
        </header>
        <div class="profile-photo-container">
          <img src="DisplayMentorPic?name=<%=adminId%>" alt="Profile Photo" class="img-responsive">  
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
            <li><a href="index.jsp"><i class="fa fa-home fa-fw"></i>Home</a></li>
            <li><a href="manage-users.jsp?pageNumber=1" class="active"><i class="fa fa-users fa-fw"></i>Manage Users</a></li>
         </ul>  
        </nav>
      </div>
      <!-- Main content --> 
      <div class="templatemo-content col-1 light-gray-bg">
        <div class="templatemo-top-nav-container">
        	 <div class="row">
            <nav class="templatemo-top-nav col-lg-12 col-md-12">
              <a href="adminlogout.jsp" style="margin-right:20px; color:1B606c; font-weight:700;  float:right;" >Sign Out</a>
            </nav> 
          </div> 
          </div>
	 
        <div class="templatemo-content-container" style="padding:0px 0px;">
          <div class="templatemo-content-widget no-padding">
             
                <tbody>
                
			  
				
			  
            <div class="panel panel-default table-responsive">
            <form id="regForm" action="${pageContext.request.contextPath}/Control?action=assignTeam" method="post" style="margin-top:0px; padding-top:30px;">  
			  <table class="table table-striped table-bordered templatemo-user-table">
                <thead>
                  <tr>
                    <td><a href="" class="white-text templatemo-sort-by">Name </a></td>
                    <td><a href="" class="white-text templatemo-sort-by">Email</a></td>
                    <td><a href="" class="white-text templatemo-sort-by">Contact Number</a></td>
                    <td><a href="" class="white-text templatemo-sort-by">Gender</a></td>
                    <td><a href="" class="white-text templatemo-sort-by">Reason </a></td>
                    <td><a href="" class="white-text templatemo-sort-by">Skills  </a></td>
                    <td><a href="" class="white-text templatemo-sort-by">Additional Skill   </a></td>
                    
                  </tr>
                </thead>
                <tbody>
                <% try{ %> 
				<%  
				 	 	  String aId = request.getParameter("aId");
					volunteerDetailsRs = ct.getApplications(request,response,aId);
			} catch (Exception e)	{
				}
			%>
			 
			 <%  while(volunteerDetailsRs.next()){  %>
			
							<tr>
								 
								<td> 
									<input type="text" readonly class="form-control" style="padding:10px 5px;" name="name" value="<%=volunteerDetailsRs.getString("volunteer_name") %>" >					
								</td>
								<td>
									<input type="text" readonly name="email" style="padding:10px 5px;"  class="form-control"  value="<%=volunteerDetailsRs.getString("email_id") %>" >
								</td>  
								<td>
									<input type="text" readonly name="email_status" style="padding:10px 5px;" class="form-control"   value="<%=volunteerDetailsRs.getString("contact_num") %>" >
								</td>
								<td>
									<input type="text" readonly name="email_status" style="padding:10px 5px;" class="form-control" style="width:90px;"   value="<%=volunteerDetailsRs.getString("gender") %>" >
								</td> 	
								<td>
									 <textarea readonly style="padding:10px 5px;" rows="2" class="form-control" ><%=volunteerDetailsRs.getString("why_volunteer") %></textarea>
								</td>  
								<td>
									<textarea readonly style="padding:10px 5px;"   rows="2" class="form-control" ><%=volunteerDetailsRs.getString("skills") %></textarea>
								</td> 
								<td>
									<textarea readonly style="padding:10px 5px;"  rows="2" class="form-control"><%=volunteerDetailsRs.getString("addi_skills") %></textarea>
								</td> 
								 
								 
							</tr>
						 
							<%  } %> 
                </tbody>
              </table>  
            
					</form> 
			 
            </div>                          
          </div> 
                   
               
          <footer class="text-right">
            <p>Copyright &copy; 2018 SarvaHitkari 
            | Designed by <a href="/sarv_hitkari/about.html" target="_parent">Kapil Thakur and Anurag Goel</a></p>
          </footer>         
        </div>
      </div>
    </div>
    <%} %>
    <!-- JS -->
    <script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>      <!-- jQuery -->
    <script type="text/javascript" src="js/templatemo-script.js"></script>      <!-- Templatemo Script -->
    <script>
      $(document).ready(function(){
        // Content widget with background image
        var imageUrl = $('img.content-bg-img').attr('src');
        $('.templatemo-content-img-bg').css('background-image', 'url(' + imageUrl + ')');
        $('img.content-bg-img').hide();        
      });
    </script>
  </body>
</html>