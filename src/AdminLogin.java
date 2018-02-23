
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.daniel.util.DbUtil;

public class AdminLogin extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Connection connection;

	public   AdminLogin()
	{
		connection = DbUtil.getConnection();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	  
		 	java.sql.Statement adminLoginSt =  null; 
	        java.sql.ResultSet adminLoginRs = null;
	        
	        PrintWriter out;
	        RequestDispatcher rd=null;
	        
		try	{
				out = response.getWriter();
			 
				String username = request.getParameter("email");
				String password = request.getParameter("password");  
				adminLoginSt = connection.createStatement();			
				adminLoginRs = adminLoginSt.executeQuery("select * from admin where email='"+username+"' and password='"+password+"'");
				if (adminLoginRs.next())				
				{	
					
					String adminId = adminLoginRs.getString("id"); 
					String adminType = adminLoginRs.getString("admin_type");
					HttpSession session = request.getSession();
					session.setAttribute("adminId", adminId); 
					session.setAttribute("adminType", adminType); 
					session.setMaxInactiveInterval(1800); 
					if(adminType.equals("Admin")) {
						response.sendRedirect("admin/index.jsp"); 
					}
					else if(adminType.equals("Mentor")) {
						response.sendRedirect("mentorIndex.jsp"); 
					} 
				}  
				else
				{
					response.sendRedirect("adminLogin.jsp?action=UserNotValid");
				}
		}
		 catch(SQLException se){
           se.printStackTrace();
        }
        
        catch (NullPointerException e) {
     	   e.printStackTrace();
     	  }
        catch(Exception e){
           e.printStackTrace();
        }
       finally{
    	   if(adminLoginSt!=null)
				try {
					adminLoginSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			if(adminLoginRs!=null)
				try {
					adminLoginRs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
       	} 
	}

}