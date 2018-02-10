<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head> 
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	</head>
	<body>
	  
		<%
		session.removeAttribute("ngoId"); 
		session.removeAttribute("NgoId"); 
		session.invalidate(); 	
		response.sendRedirect("ngoPreLogin.jsp");
		%>
		  
		<script type="text/javascript">
		        history.pushState(null, null, document.URL);
		        window.addEventListener('popstate', function () {
		            history.pushState(null, null, document.URL);
		        });
		</script>
	 </body> 
</html>