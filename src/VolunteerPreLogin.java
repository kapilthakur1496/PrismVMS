
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

public class VolunteerPreLogin extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Connection connection;

	public   VolunteerPreLogin()
	{
	connection = DbUtil.getConnection();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	 

		
		
		 java.sql.Statement ngoDetailSt;
		 	ngoDetailSt=null;
	        java.sql.ResultSet ngoDetailRs;
	        ngoDetailRs=null;
	        PrintWriter out;

			RequestDispatcher rd=null;
		try	{
			out = response.getWriter();
			 
			String username = request.getParameter("email");
			String password = request.getParameter("password");
			  
			ngoDetailSt = connection.createStatement();			
			ngoDetailRs = ngoDetailSt.executeQuery("select * from volunteer_registration where email_id='"+username+"' and password='"+password+"'");
			if (ngoDetailRs.next())	
				
			{	
				String volunteerId=ngoDetailRs.getString("id");
				 
				HttpSession session = request.getSession();
				  
				session.setAttribute("volunteerId", volunteerId); 
				 
				session.setMaxInactiveInterval(1800);
				response.sendRedirect("volunteerPreIndex.jsp");  /*
				response.sendRedirect("volunteerindex.jsp");*/ 
			}
			else
			{
				response.sendRedirect("volunteerPreLogin.jsp?msg3=fail"); 
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
       	 
			if(ngoDetailSt!=null)
				try {
					ngoDetailSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			if(ngoDetailRs!=null)
				try {
					ngoDetailRs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
       	} 
	}

}