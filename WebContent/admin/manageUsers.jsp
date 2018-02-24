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
            <div class="panel panel-default table-responsive">
            <form id="regForm" action="${pageContext.request.contextPath}/Control?action=volunteerApproval" method="post" style="margin-top:0px; padding-top:30px;">  
			  <table class="table table-striped table-bordered templatemo-user-table">
                <thead>
                  <tr>
                    <td><a href="" class="white-text templatemo-sort-by"># <span class="caret"></span></a></td>
                    <td><a href="" class="white-text templatemo-sort-by">First Name <span class="caret"></span></a></td>
                    <td><a href="" class="white-text templatemo-sort-by">Email<span class="caret"></span></a></td>
                    <td><a href="" class="white-text templatemo-sort-by">  Status <span class="caret"></span></a></td>
                    <td><a href="" class="white-text templatemo-sort-by">Profile <span class="caret"></span></a></td>
                     
                    
                  </tr>
                </thead>
                <tbody>
                <% try{ %>
			  
				
				<%  
				 	pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
					volunteerCount = ct.volunteerApplicationCount();
					pageCount= volunteerCount/10 +1;		  
					volunteerDetailsRs = ct.applicationDetails(pageNumber-1, nextRecordCount);
			} catch (Exception e)	{
				}
			%> <%!  int i=1; %>
			 <%  while(volunteerDetailsRs.next()){  %>
			
							<tr>
								<td>
								  	<input type="checkbox" name="volunteerId" id="u<%=i%>" value="<%=volunteerDetailsRs.getString("id") %>">
                      				<label for="u<%=i%>" class="font-weight-400"><span></span> </label> 
								 				
								</td>
								<td> 
									<input type="text" readonly class="form-control" name="name" value="<%=volunteerDetailsRs.getString("volunteer_name") %>" >					
								</td>
								<td>
									<input type="text" readonly name="email"  class="form-control"  value="<%=volunteerDetailsRs.getString("email_id") %>" >
								</td>  
								<td>
									<input type="text" readonly name="email_status"  class="form-control"   value="<%=volunteerDetailsRs.getString("approve_status") %>" >
								</td> 
								 <td>
									<a href="applicationProfile.jsp?aId=<%=volunteerDetailsRs.getString("id")%>" target="_blank" >View </a>
								</td> 
								 
							</tr>
							<input type="hidden" name="pageNumber"  value="<%=pageNumber %>">
							<% ++i; }  %> 
                </tbody>
              </table>  
              <div style="margin:10px;">
						<div class="col-lg-5">
							<select   class="form-control" name="status">
							<option>Select the Status</option>
								<option>Approved</option>
								<option>Under Process</option>
								<option>Rejected </option> 
								<option>Pending</option>
								<option>On InterView</option>
								<option>Archived</option>
							</select>
						</div>  
						<div  class="col-lg-5">
							<input type="submit"  class="form-control"  value="Update Application Status" >
						</div> 
					</div>
					</form> 
			 <div class="col-lg-12 text-center" style="margin-left:auto; margin-right:auto;">
				<ul class="pagination " >
					<% for( int k=1; k<=pageCount; k++){ %>
				    	<li><a href="manage-users.jsp?pageNumber=<%=k%>"><%=k%></a></li>
				    <% } %> 
			 	</ul>
		 	</div>  
            </div>
            <div class="panel panel-default table-responsive">
            <form id="regForm" action="${pageContext.request.contextPath}/Control?action=assignTeam" method="post" style="margin-top:0px; padding-top:30px;">  
			  <table class="table table-striped table-bordered templatemo-user-table">
                <thead>
                  <tr>
                    <td><a href="" class="white-text templatemo-sort-by"># <span class="caret"></span></a></td>
                    <td><a href="" class="white-text templatemo-sort-by">First Name <span class="caret"></span></a></td>
                    <td><a href="" class="white-text templatemo-sort-by">Email<span class="caret"></span></a></td>
                    <td><a href="" class="white-text templatemo-sort-by">  Status <span class="caret"></span></a></td>
                    <td><a href="" class="white-text templatemo-sort-by">Profile <span class="caret"></span></a></td>
                     
                    
                  </tr>
                </thead>
                <tbody>
                <% try{ %> 
				<%  
				 	pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
					volunteerCount = ct.AdminVolunteerCount();
					pageCount= volunteerCount/10 +1;		  
					volunteerDetailsRs = ct.volunteerDetails(pageNumber-1, nextRecordCount);
			} catch (Exception e)	{
				}
			%>
			 <%!  int j=i; %>
			 <%  while(volunteerDetailsRs.next()){  %>
			
							<tr>
								<td>
								  	<input type="checkbox" name="volunteerId" id="t<%=j%>" value="<%=volunteerDetailsRs.getString("id") %>">
                      				<label for="t<%=j%>" class="font-weight-400"><span></span> </label> 
								 				
								</td>
								<td> 
									<input type="text" readonly class="form-control" name="name" value="<%=volunteerDetailsRs.getString("volunteer_name") %>" >					
								</td>
								<td>
									<input type="text" readonly name="email"  class="form-control"  value="<%=volunteerDetailsRs.getString("email_id") %>" >
								</td>  
								<td>
									<input type="text" readonly name="email_status"  class="form-control"   value="<%=volunteerDetailsRs.getString("approve_status") %>" >
								</td> 
								 <td>
									<a href="#" >View </a>
								</td> 
								 
							</tr>
							<input type="hidden" name="pageNumber"  value="<%=pageNumber %>">
							<% ++j; } %> 
                </tbody>
              </table>  
              <div style="margin:10px;">
						<div class="col-lg-4">
							<select   class="form-control" name="team">
							<option value="0">Select the Team</option>
								<%	teamRs = ct.getTeams();
              					%>
              				<% while(teamRs.next() ){ %>
              					<option> <%=teamRs.getString("team_name") %></option>
              				<%} %> 
							</select>
						</div>  
						<div class="col-lg-4">
							<select   class="form-control" name="branch">
							<option value="0">Select the Branch</option>
								<%	branchRs = ct.getBranch();
              					%>
              				<% while(branchRs.next() ){ %>
              					<option value="<%=branchRs.getString("id") %>" > <%=branchRs.getString("name") %></option>
              				<%} %> 
							</select>
						</div>
						<div  class="col-lg-4">
							<input type="submit"  class="form-control"  value="Assign Team" >
						</div> 
					</div>
					</form> 
			 <div class="col-lg-12 text-center" style="margin-left:auto; margin-right:auto;">
				<ul class="pagination " >
					<% for( int k=1; k<=pageCount; k++){ %>
				    	<li><a href="manage-users.jsp?pageNumber=<%=k%>"><%=k%></a></li>
				    <% } %> 
			 	</ul>
		 	</div>  
            </div>                          
          </div> 
                   
          <!-- <div class="templatemo-flex-row flex-content-row">
            <div class="col-1">
              <div class="panel panel-default margin-10">
                <div class="panel-heading"><h2 class="text-uppercase">Login Form</h2></div>
                <div class="panel-body">
                  <form action="index.html" class="templatemo-login-form">
                    <div class="form-group">
                      <label for="inputEmail">Email address</label>
                      <input type="email" class="form-control" id="inputEmail" placeholder="Enter email">
                    </div>
                    <div class="form-group">                      
                      <label for="inputEmail">Password</label>
                      <input type="password" class="form-control" placeholder="Enter password">                                 
                    </div>              
                    <div class="form-group">
                        <div class="checkbox squaredTwo">
                            <label>
                              <input type="checkbox"> Remember me
                            </label>
                        </div>            
                    </div>
                    <div class="form-group">
                      <button type="submit" class="templatemo-blue-button">Submit</button>
                    </div>
                  </form>
                </div>                
              </div>              
            </div>
            <div class="col-1">              
              <div class="templatemo-content-widget pink-bg">
                <i class="fa fa-times"></i>                
                <h2 class="text-uppercase margin-bottom-10">Latest Data</h2>
                <p class="margin-bottom-0">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc mi sapien, fringilla at orci nec, viverra rhoncus leo. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus rhoncus erat non purus commodo, sit amet varius dolor sagittis.</p>                  
              </div>            
              <div class="templatemo-content-widget blue-bg">
                <i class="fa fa-times"></i>
                <h2 class="text-uppercase margin-bottom-10">Older Data</h2>
                <p class="margin-bottom-0">Phasellus dapibus nulla quis risus auctor, non placerat augue consectetur. Aliquam convallis pharetra odio, in convallis erat molestie sed. Fusce mi lacus, semper sit amet mattis eu, volutpat vitae enim.</p>                
              </div>            
            </div>                       
          </div> Second row ends
          <div class="templatemo-flex-row flex-content-row">
            <div class="templatemo-content-widget white-bg col-2">
              <i class="fa fa-times"></i>
              <div class="media margin-bottom-30">
                <div class="media-left padding-right-25">
                  <a href="#">
                    <img class="media-object img-circle templatemo-img-bordered" src="images/person.jpg" alt="Sunset">
                  </a>
                </div>
                <div class="media-body">
                  <h2 class="media-heading text-uppercase blue-text">John Barnet</h2>
                  <p>Project Manager</p>
                </div>        
              </div>
              <div class="table-responsive">
                <table class="table">
                  <tbody>
                    <tr>
                      <td><div class="circle green-bg"></div></td>
                      <td>New Task Issued</td>
                      <td>02</td>                    
                    </tr> 
                    <tr>
                      <td><div class="circle pink-bg"></div></td>
                      <td>Task Pending</td>
                      <td>22</td>                    
                    </tr>  
                    <tr>
                      <td><div class="circle blue-bg"></div></td>
                      <td>Inbox</td>
                      <td>13</td>                    
                    </tr>  
                    <tr>
                      <td><div class="circle yellow-bg"></div></td>
                      <td>New Notification</td>
                      <td>18</td>                    
                    </tr>                                      
                  </tbody>
                </table>
              </div>             
            </div>
            <div class="templatemo-content-widget white-bg col-1 text-center templatemo-position-relative">
              <i class="fa fa-times"></i>
              <img src="images/person.jpg" alt="Bicycle" class="img-circle img-thumbnail margin-bottom-30">
              <h2 class="text-uppercase blue-text margin-bottom-5">Paul Smith</h2>
              <h3 class="text-uppercase margin-bottom-70">Managing Director</h3>
              <div class="templatemo-social-icons-container">
                <div class="social-icon-wrap">
                  <i class="fa fa-facebook templatemo-social-icon"></i>  
                </div>
                <div class="social-icon-wrap">
                  <i class="fa fa-twitter templatemo-social-icon"></i>  
                </div>
                <div class="social-icon-wrap">
                  <i class="fa fa-google-plus templatemo-social-icon"></i>  
                </div>                
              </div>
            </div>
            <div class="templatemo-content-widget white-bg col-1 templatemo-position-relative templatemo-content-img-bg">
              <img src="images/sunset-big.jpg" alt="Sunset" class="img-responsive content-bg-img">
              <i class="fa fa-heart"></i>
              <h2 class="templatemo-position-relative white-text">Sunset</h2>
              <div class="view-img-btn-wrap">
                <a href="" class="btn btn-default templatemo-view-img-btn">View</a>  
              </div>              
            </div>
          </div>
          <div class="pagination-wrap">
            <ul class="pagination">
              <li><a href="#">1</a></li>
              <li><a href="#">2</a></li>
              <li class="active"><a href="#">3 <span class="sr-only">(current)</span></a></li>
              <li><a href="#">4</a></li>
              <li><a href="#">5</a></li>
              <li>
                <a href="#" aria-label="Next">
                  <span aria-hidden="true"><i class="fa fa-play"></i></span>
                </a>
              </li>
            </ul>
          </div>  -->         
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