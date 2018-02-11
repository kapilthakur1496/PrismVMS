package com.daniel.util.control;


import java.sql.ResultSet;
import java.sql.Array;
import java.sql.Connection; 
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;   
import java.text.DateFormat; 
import java.text.SimpleDateFormat;
import java.awt.List;
import java.util.Date;

import com.daniel.util.DbUtil;
import com.sun.mail.iap.Response;

import encryption.encrypt;

import java.sql.*;
import encryption.*;
/*import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;*/
import java.io.*;
import java.util.*;
import  javax.mail.*;
  import javax.mail.internet.*;
  import javax.activation.*;
 import javax.servlet.http.*;  

import javax.servlet.*;
  import java.sql.*;
  import com.daniel.util.DbUtil;
  import com.daniel.util.DbUtil.*; 

 
/**
 * Servlet implementation class Control
// */ 
@WebServlet(name = "Control", urlPatterns = {"/Control"}) 
@MultipartConfig

public class Control extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Connection connection;
	public static final int MYSQL_DUPLICATE_PK = 1062;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Control() {
        super();
        connection = DbUtil.getConnection();
        // TODO Auto-generated constructor stub
    } 
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	 
		HttpSession session = request.getSession();
		String action= request.getParameter("action");
		 
		  if(action.equals("addTeam"))
		{   
			addTeam(request,response); 
		}
		else if(action.equals("addBranch"))
		{   
			addBranch(request,response); 
		}
		else if(action.equals("addMeeting"))
		{   
			addMeeting(request,response); 
		}
		else if(action.equals("addTraining"))
		{   
			addTrainingType(request,response); 
		}
		else if(action.equals("addAcademicSkills"))
		{   
			addAcademicSkills(request,response); 
		}
		else if(action.equals("addLifeSkills"))
		{   
			addLifeSkills(request,response); 
		}
		else if(action.equals("addSoftSkills"))
		{   
			addSoftSkills(request,response); 
		}
		else if(action.equals("addProfessionalSkills"))
		{   
			addProfessionalSkills(request,response); 
		}
		else if(action.equals("addInterViewSlot"))
		{   
			addInterViewSlot(request,response); 
		}
		else if(action.equals("addVolunteerRegistration"))
		{   
			volunteerRegistration(request,response); 
		}
		else if(action.equals("volunteerChooseSkills"))
		{   
			volunteerChooseSkills(request,response); 
		}
		else if(action.equals("volunteerApproval"))
		{   
			volunteerApproval(request,response);
		}
		  
		  
	}
	private void addTeam( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    HttpSession session = request.getSession();
		String adminId = (String)session.getAttribute("adminId");
		if(adminId !=null) {
		String team = request.getParameter("teamName");
		Statement checkTeamSt = null;
		ResultSet checkTeamRs = null;
		 
		try {
			 	checkTeamSt = connection.createStatement();
			 	String checkQ = "select team_name from teams where team_name ='"+team+"'";
			 	checkTeamRs = checkTeamSt.executeQuery(checkQ);
				
				 if (checkTeamRs.next())	{
					 response.sendRedirect("admin/index.jsp?msg=TeamExist");
				 }
				 else   {  
					PreparedStatement addCategoryPs =null;
					String query = "insert into teams (team_name) values(?)" ;
					addCategoryPs  =  connection.prepareStatement(query);
					addCategoryPs.setString(1, team); 
					addCategoryPs.executeUpdate();	
					response.sendRedirect("admin/index.jsp");
	  
	 				  } 
			}  
		 catch (SQLException e) {
				// TODO: handle exception
			e.printStackTrace();
			}
		 catch (Exception e) {
				// TODO: handle exception
				 e.printStackTrace();
			}
		 finally {
			 
		 }
		}
		else{
			response.sendRedirect("index.jsp?action=LoginAgain");
		}
		 out.close(); 
		 
	}

private void addMeeting( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    HttpSession session = request.getSession();
		String adminId = (String)session.getAttribute("adminId");
		if(adminId !=null) {
		String meetingType = request.getParameter("meetingType");
		Statement meetingTypeSt = null;
		ResultSet meetingTypeRs = null;
		 
		try {
				meetingTypeSt = connection.createStatement();
				String checkQ ="select meeting_type from meeting_type where meeting_type ='"+meetingType+"'";
				meetingTypeRs = meetingTypeSt.executeQuery(checkQ);
				
				 if (meetingTypeRs.next())	{
					 response.sendRedirect("admin/index.jsp?msg=MeetingTypeExist");
				 }
				 else   {  
					PreparedStatement addCategoryPs =null;
					String query = "insert into meeting_type (meeting_type) values(?)";
					addCategoryPs  =  connection.prepareStatement(query);
					addCategoryPs.setString(1, meetingType); 
					addCategoryPs.executeUpdate();	
					response.sendRedirect("admin/index.jsp");
	  
	 				  } 
			}  
		 catch (SQLException e) {
				// TODO: handle exception
			e.printStackTrace(); 
			}
		 catch (Exception e) {
				// TODO: handle exception
				 e.printStackTrace();
			}
		 finally {
			 
		 }
		}
		else{
			response.sendRedirect("index.jsp?action=LoginAgain");
		}
		 out.close(); 
		 
	}
private void addBranch( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    HttpSession session = request.getSession();
		String adminId = (String)session.getAttribute("adminId");
		if(adminId !=null) {
		String branchName = request.getParameter("branchName");
		Statement branchNameSt = null;
		ResultSet branchNameRs = null;
		 
		try {
				branchNameSt = connection.createStatement();
				String checkQ ="select name from branch where name ='"+branchNameSt+"'";
				branchNameRs = branchNameSt.executeQuery(checkQ);
				
				 if (branchNameRs.next())	{
					 response.sendRedirect("admin/index.jsp?msg=BranchExist");
				 }
				 else   {  
					PreparedStatement addCategoryPs =null;
					String query = "insert into branch (name) values(?)";
					addCategoryPs  =  connection.prepareStatement(query);
					addCategoryPs.setString(1, branchName); 
					addCategoryPs.executeUpdate();	
					response.sendRedirect("admin/index.jsp");
	  
	 				  } 
			}  
		 catch (SQLException e) {
				// TODO: handle exception
			e.printStackTrace();
			}
		 catch (Exception e) {
				// TODO: handle exception
				 e.printStackTrace();
			}
		 finally {
			 
		 }
		}
		else{
			response.sendRedirect("index.jsp?action=LoginAgain");
		}
		 out.close(); 
		 
	}
private void addTrainingType( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    HttpSession session = request.getSession();
	String adminId = (String)session.getAttribute("adminId");
	if(adminId !=null) {
	String training_type = request.getParameter("trainingType");
	String teamId = request.getParameter("teamId");
	Statement trainingTypeSt = null;
	ResultSet trainingTypeRs = null;
	 
	try {
			trainingTypeSt = connection.createStatement();
			String checkQ ="select training_type from training_type where training_type ='"+training_type+"' and team_id='"+teamId+"'";
			trainingTypeRs = trainingTypeSt.executeQuery(checkQ);
			
			 if (trainingTypeRs.next())	{
				 response.sendRedirect("admin/index.jsp?msg=BranchExist");
			 }
			 else   {  
				PreparedStatement addCategoryPs =null;
				String query = "insert into training_type (training_type,team_id) values(?,?)";
				addCategoryPs  =  connection.prepareStatement(query);
				addCategoryPs.setString(1, training_type); 
				addCategoryPs.setString(2, teamId); 
				addCategoryPs.executeUpdate();	
				response.sendRedirect("admin/index.jsp");
  
 				  } 
		}  
	 catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
	 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
	 finally {
		 
	 }
	}
	else{
		response.sendRedirect("index.jsp?action=LoginAgain");
	}
	 out.close(); 
	 
}
	public   ResultSet getTeams() throws ServletException, IOException { 
		Statement getTeamsSt =null;
		ResultSet getTeamsRs = null;
		  
		try {  				
			getTeamsSt = connection.createStatement();
				String query = "select *   from teams";
				getTeamsRs = getTeamsSt.executeQuery(query);
				 
		} 
	catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
	 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		finally {
			
			/*if(NgoDetailSt!=null)
				try {
					NgoDetailSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
	    	 
		}
		return getTeamsRs;

	}
	public   ResultSet getBranch() throws ServletException, IOException { 
		Statement getTeamsSt =null;
		ResultSet getTeamsRs = null;
		  
		try {  				
			getTeamsSt = connection.createStatement();
				String query = "select *   from branch";
				getTeamsRs = getTeamsSt.executeQuery(query);
				 
		} 
	catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
	 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		finally {
			
			/*if(NgoDetailSt!=null)
				try {
					NgoDetailSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
	    	 
		}
		return getTeamsRs;

	}
	public   ResultSet getMeetingType() throws ServletException, IOException { 
		Statement meetingTypeSt =null;
		ResultSet meetingTypeRs = null;
		  
		try {  				
			meetingTypeSt = connection.createStatement();
				String query = "select *   from meeting_type";
				meetingTypeRs = meetingTypeSt.executeQuery(query);
				 
		} 
	catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
	 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		finally {
			
			/*if(NgoDetailSt!=null)
				try {
					NgoDetailSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
	    	 
		}
		return meetingTypeRs;

	}
private void addAcademicSkills( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    HttpSession session = request.getSession();
		String adminId = (String)session.getAttribute("adminId");
		if(adminId !=null) {
		String academicSkill = request.getParameter("academicSkill");
		Statement checkAcademicSkillSt = null;
		ResultSet checkAcademicSkillRs = null;
		 
		try {
			checkAcademicSkillSt = connection.createStatement();
			 	String checkQ = "select skill_name from academic_skills where skill_name ='"+academicSkill+"'";
			 	checkAcademicSkillRs = checkAcademicSkillSt.executeQuery(checkQ);
				
			 	if (checkAcademicSkillRs.next()) {
					 response.sendRedirect("admin/index.jsp?msg=TeamExist");
				 }
				 else   {  
							PreparedStatement addCategoryPs =null;
							String query = "insert into academic_skills (skill_name) values(?)";
							addCategoryPs  =  connection.prepareStatement(query);
							addCategoryPs.setString(1, academicSkill); 
							addCategoryPs.executeUpdate();	
							response.sendRedirect("admin/index.jsp"); 
	 				  }  
			}  
		 catch (SQLException e) {
				// TODO: handle exception
			e.printStackTrace();
			}
		 catch (Exception e) {
				// TODO: handle exception
				 e.printStackTrace();
			}
		 finally {
			 
		 }
		}
		else{
			response.sendRedirect("index.jsp?action=LoginAgain");
		}
		 out.close(); 
		 
	}
public   ResultSet getAcademicSkill() throws ServletException, IOException { 
	Statement getTeamsSt =null;
	ResultSet getTeamsRs = null;
	  
	try {  				
		getTeamsSt = connection.createStatement();
			String query = "select *   from academic_skills";
			getTeamsRs = getTeamsSt.executeQuery(query);
			 
	} 
catch (SQLException e) {
		// TODO: handle exception
	e.printStackTrace();
	}
 catch (Exception e) {
		// TODO: handle exception
		 e.printStackTrace();
	}
	finally {
		
		/*if(NgoDetailSt!=null)
			try {
				NgoDetailSt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
    	 
	}
	return getTeamsRs;

	}
private void addLifeSkills( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    HttpSession session = request.getSession();
	String adminId = (String)session.getAttribute("adminId");
	if(adminId !=null) {
	String lifeSkill = request.getParameter("lifeSkill");
	Statement checkLifeSkillSt = null;
	ResultSet checkLifeSkillRs = null;
	 
	try {
		checkLifeSkillSt = connection.createStatement();
		 	String checkQ = "select skill_name from life_skills where skill_name ='"+lifeSkill+"'";
		 	checkLifeSkillRs = checkLifeSkillSt.executeQuery(checkQ);
			
		 	if (checkLifeSkillRs.next()) {
				 response.sendRedirect("admin/index.jsp?msg=TeamExist");
			 }
			 else   {  
						PreparedStatement addCategoryPs =null;
						String query = "insert into life_skills (skill_name) values(?)";
						addCategoryPs  =  connection.prepareStatement(query);
						addCategoryPs.setString(1, lifeSkill); 
						addCategoryPs.executeUpdate();	
						response.sendRedirect("admin/index.jsp"); 
 				  }  
		}  
	 catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
	 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
	 finally {
		 
	 }
	}
	else{
		response.sendRedirect("index.jsp?action=LoginAgain");
	}
	 out.close(); 
	 
}
public   ResultSet getLifeSkill() throws ServletException, IOException { 
	Statement getLifeSkillSt =null;
	ResultSet getLifeSkillRs = null;
	  
	try {  				
			getLifeSkillSt = connection.createStatement();
			String query = "select *   from life_skills";
			getLifeSkillRs = getLifeSkillSt.executeQuery(query);
			 
	} 
catch (SQLException e) {
		// TODO: handle exception
	e.printStackTrace();
	}
 catch (Exception e) {
		// TODO: handle exception
		 e.printStackTrace();
	}
	finally {
		
		/*if(NgoDetailSt!=null)
			try {
				NgoDetailSt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
    	 
	}
	return getLifeSkillRs;

	}
private void addSoftSkills( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    HttpSession session = request.getSession();
	String adminId = (String)session.getAttribute("adminId");
	if(adminId !=null) {
	String softSkill = request.getParameter("softSkill");
	Statement checkSoftSkillSt = null;
	ResultSet checkSoftSkillRs = null;
	 
	try {
			checkSoftSkillSt = connection.createStatement();
		 	String checkQ = "select skill_name from soft_skills where skill_name ='"+softSkill+"'";
		 	checkSoftSkillRs = checkSoftSkillSt.executeQuery(checkQ);
			
		 	if (checkSoftSkillRs.next()) {
				 response.sendRedirect("admin/index.jsp?msg=TeamExist");
			 }
			 else   {  
						PreparedStatement addCategoryPs =null;
						String query = "insert into soft_skills (skill_name) values(?)";
						addCategoryPs  =  connection.prepareStatement(query);
						addCategoryPs.setString(1, softSkill); 
						addCategoryPs.executeUpdate();	
						response.sendRedirect("admin/index.jsp"); 
 				  }  
		}  
	 catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
	 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
	 finally {
		 
	 }
	}
	else{
		response.sendRedirect("index.jsp?action=LoginAgain");
	}
	 out.close(); 
	 
}
public   ResultSet getSoftSkill() throws ServletException, IOException { 
	Statement getSoftSkillSt =null;
	ResultSet getSoftSkilRs = null;
	  
	try {  				
			getSoftSkillSt = connection.createStatement();
			String query = "select *   from soft_skills";
			getSoftSkilRs = getSoftSkillSt.executeQuery(query);
			 
	} 
catch (SQLException e) {
		// TODO: handle exception
	e.printStackTrace();
	}
 catch (Exception e) {
		// TODO: handle exception
		 e.printStackTrace();
	}
	finally {
		
		/*if(NgoDetailSt!=null)
			try {
				NgoDetailSt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
    	 
	}
	return getSoftSkilRs;

	}
private void addProfessionalSkills( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    HttpSession session = request.getSession();
	String adminId = (String)session.getAttribute("adminId");
	if(adminId !=null) {
	String professionalSkill = request.getParameter("professionalSkill");
	Statement checkprofessionalSkillSt = null;
	ResultSet checkprofessionalSkillRs = null;
	 
	try {
			checkprofessionalSkillSt = connection.createStatement();
		 	String checkQ = "select skill_name from professional_skills where skill_name ='"+professionalSkill+"'";
		 	checkprofessionalSkillRs = checkprofessionalSkillSt.executeQuery(checkQ);
			
		 	if (checkprofessionalSkillRs.next()) {
				 response.sendRedirect("admin/index.jsp?msg=TeamExist");
			 }
			 else   {  
						PreparedStatement addCategoryPs =null;
						String query = "insert into professional_skills (skill_name) values(?)";
						addCategoryPs  =  connection.prepareStatement(query);
						addCategoryPs.setString(1, professionalSkill); 
						addCategoryPs.executeUpdate();	
						response.sendRedirect("admin/index.jsp"); 
 				  }  
		}  
	 catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
	 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
	 finally {
		 
	 }
	}
	else{
		response.sendRedirect("index.jsp?action=LoginAgain");
	}
	 out.close(); 
	 
}
public   ResultSet getProfessionalSkill() throws ServletException, IOException { 
	Statement getSoftSkillSt =null;
	ResultSet getSoftSkilRs = null;
	  
	try {  				
			getSoftSkillSt = connection.createStatement();
			String query = "select *   from professional_skills";
			getSoftSkilRs = getSoftSkillSt.executeQuery(query);
			 
	} 
catch (SQLException e) {
		// TODO: handle exception
	e.printStackTrace();
	}
 catch (Exception e) {
		// TODO: handle exception
		 e.printStackTrace();
	}
	finally {
		
		/*if(NgoDetailSt!=null)
			try {
				NgoDetailSt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
    	 
	}
	return getSoftSkilRs;

	}
private void addInterViewSlot( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    HttpSession session = request.getSession();
	String adminId = (String)session.getAttribute("adminId");
	if(adminId !=null) {
		   String interViewDate = request.getParameter("interViewDate"); 
        String availableSeats = request.getParameter("availableSeats");  
        String slotTime = request.getParameter("slotTime");  
       
        String venue=request.getParameter("venue");
        
		Statement checkinterViewSt = null;
		ResultSet checkinterViewRs = null;
		 
	try {
		checkinterViewSt = connection.createStatement();
		 	String checkQ = "select slotdate from interviewslot where slotdate ='"+interViewDate+"' and inttimefrom='"+slotTime+"'    venue='"+venue+"'";
		 	checkinterViewRs = checkinterViewSt.executeQuery(checkQ);
			
		 	if (checkinterViewRs.next()) {
				 response.sendRedirect("admin/index.jsp?msg=InterViewSlotsExist");
			 }
			 else   {   
						PreparedStatement addInterViewSlotPs =null;
						addInterViewSlotPs = connection.prepareStatement("insert into interviewslot (slotdate,availableseats,inttimefrom,venue) values (?,?,?,?)");
						addInterViewSlotPs.setString(1, interViewDate);
						addInterViewSlotPs.setString(2, availableSeats);
						addInterViewSlotPs.setString(3, slotTime);  
			            addInterViewSlotPs.setString(4, venue ); 
			            addInterViewSlotPs.executeUpdate(); 
			             
						response.sendRedirect("admin/index.jsp"); 
 				  }  
		}  
	 catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
	 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
	 finally {
		 
	 }
	}
	else{
		response.sendRedirect("index.jsp?action=LoginAgain");
	}
	 out.close(); 
	 
}
private void volunteerRegistration( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    HttpSession session = request.getSession();
	  
    String email=request.getParameter("email");  
	Statement checkVolunteerSt = null;
	ResultSet checkVolunteerRs = null;
		 
	try {
			Statement volunteerIdSt = null;
			ResultSet volunteerIdRs = null;
			volunteerIdSt = connection.createStatement();
			String volunteerId=null;
		 	String checkQ = "select email_id   from volunteer_registration  where email_id ='"+email+"' ";
		 	volunteerIdRs = volunteerIdSt.executeQuery(checkQ);
			
		 	if (volunteerIdRs.next()) {
				 response.sendRedirect("admin/index.jsp?msg=AlreadyRegistered");
			 }
			 else   {    
					 String fullName=request.getParameter("fullName");
					 String phone=request.getParameter("phone");
					 String password=request.getParameter("password"); 
					 String gender=request.getParameter("gender");
					 String whyVolunteer=request.getParameter("whyVolunteer");					 
					 String volunteerIdQ = "select max(id)+1 as maxId from volunteer_registration"; 
					 volunteerIdRs = volunteerIdSt.executeQuery(volunteerIdQ);
			 		if (volunteerIdRs.next())	{
			 			
			 			volunteerId = volunteerIdRs.getString("maxId");			 			  
			 			if(volunteerId == null)
			 			{
			 				volunteerId ="1";
			 			}
			 			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			 			Date date = new Date(); 
						PreparedStatement addVolunteerps =null;
						String 	query = "insert into volunteer_registration (id,volunteer_name,password,contact_num,email_id,why_volunteer,gender,registration_date) values (?,?,?,?,?,?,?,?)";
						addVolunteerps = connection.prepareStatement(query);
						addVolunteerps.setString(1, volunteerId);
						addVolunteerps.setString(2, fullName);
						addVolunteerps.setString(3, password); 
						addVolunteerps.setString(4, phone);  
						addVolunteerps.setString(5, email);
						addVolunteerps.setString(6, whyVolunteer);  
						addVolunteerps.setString(7, gender);
						addVolunteerps.setString(8,  dateFormat.format(date));
						addVolunteerps.executeUpdate();  
						session.setAttribute("volunteerId", volunteerId);
						request.setAttribute("volunteerId",volunteerId);
						response.sendRedirect("volunteerChooseSkill.jsp"); 
				  }
			 }
		}  
	 catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
	 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
	 finally {
		 
	 }
	 
	 out.close(); 
	 
}
public   ResultSet getInterViewSlot() throws ServletException, IOException { 
	Statement interViewSt =null;
	ResultSet interViewRs = null;
	  
	try {  				
			interViewSt = connection.createStatement();
			String query = "select *   from interviewslot";
			interViewRs = interViewSt.executeQuery(query);  
		} 
	catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
	 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
	finally {
		
		/*if(NgoDetailSt!=null)
			try {
				NgoDetailSt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
    	 
	}
	return interViewRs;

	}
private void volunteerChooseSkills( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    HttpSession session = request.getSession();
	String volunteerId = (String)session.getAttribute("volunteerId");
	if(volunteerId !=null) {
		String skills="";
		String lang[]=request.getParameterValues("skills");
		if(lang.length!=0) {
			for(int i=0;i<lang.length;i++){
				skills+=lang[i]+" , ";
			}
		}
		/*
		String lang1[]=request.getParameterValues("lifeSkill");
		if(lang1.length!=0) {
			for(int i=0;i<lang1.length;i++){
				skills+=lang1[i]+" , ";
			}
		}*/
		/*String lang2[]=request.getParameterValues("skills");
		if(lang2.length!=0) {
			for(int i=0;i<lang2.length;i++){
				skills+=lang2[i]+" , ";
			}
		}*/
		/*String lang3[]=request.getParameterValues("professinalSkill");
		if(lang3.length!=0) {
			for(int i=0;i<lang3.length;i++){
				skills+=lang3[i]+" , ";
			}
		}*/
		skills = skills.substring(0,skills.length()-2);
		String addi_skill = request.getParameter("additionalSkills");
		String background = request.getParameter("background");
  
		try {   
				PreparedStatement addCategoryPs =null;
				String query = "update volunteer_registration set skills = ?, addi_skills=?,backgrounds_achivements=? where id = "+volunteerId;
				addCategoryPs  =  connection.prepareStatement(query);
				addCategoryPs.setString(1, skills); 
				addCategoryPs.setString(2, addi_skill); 
				addCategoryPs.setString(3, background); 
				addCategoryPs.executeUpdate();	
				response.sendRedirect("volunteerPreIndex.jsp"); 
	 				    
			}  
		 catch (SQLException e) {
				// TODO: handle exception
			e.printStackTrace();
			}
		 catch (Exception e) {
				// TODO: handle exception
				 e.printStackTrace();
			}
		 finally {
			 
		 }
	}
	else{
		response.sendRedirect("index.jsp?action=LoginAgain");//send redirect to Volunteer Registration
	}
	 out.close(); 
	 
}


public   String getVolunteerApplicationStatus(String id) throws ServletException, IOException { 
	Statement getStatusSt =null;
	ResultSet getStatusRs = null;
	  String status =null;
	try {  				
		getStatusSt = connection.createStatement();
			String query = "select approve_status   from volunteer_registration where id = "+id;
			getStatusRs = getStatusSt.executeQuery(query);
			 if(getStatusRs.next())
			 {
				 status = getStatusRs.getString("approve_status");
			 }
			 
	} 
catch (SQLException e) {
		// TODO: handle exception
	e.printStackTrace();
	}
 catch (Exception e) {
		// TODO: handle exception
		 e.printStackTrace();
	}
	finally {
		
		/*if(NgoDetailSt!=null)
			try {
				NgoDetailSt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
    	 
	}
	return status; 
}
public   String getVolunteerName(String id) throws ServletException, IOException { 
	Statement getStatusSt =null;
	ResultSet getStatusRs = null;
	  String name =null;
	try {  				
		getStatusSt = connection.createStatement();
			String query = "select volunteer_name   from volunteer_registration where id = "+id;
			getStatusRs = getStatusSt.executeQuery(query);
			 if(getStatusRs.next())
			 {
				 name = getStatusRs.getString("volunteer_name");
			 }
			 
	} 
catch (SQLException e) {
		// TODO: handle exception
	e.printStackTrace();
	}
 catch (Exception e) {
		// TODO: handle exception
		 e.printStackTrace();
	}
	finally {
		
		/*if(NgoDetailSt!=null)
			try {
				NgoDetailSt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
    	 
	}
	return name;

}
public   int volunteerCount() throws ServletException, IOException { 
	Statement volunteerCountSt =null;
	ResultSet volunteerCountRs = null;
	int totalCount = 0; 
	try {  				
			volunteerCountSt = connection.createStatement();
			volunteerCountRs = volunteerCountSt.executeQuery("select count(id) from volunteer_registration ");
		
			if(volunteerCountRs.next())
			{
				totalCount = Integer.parseInt(volunteerCountRs.getString(1));
			}
		  
		} 
		catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		finally {
			
			 if(volunteerCountSt!=null)
				try {
					volunteerCountSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			 if(volunteerCountRs!=null)
					try {
						volunteerCountRs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
		}
return totalCount; 
}
public   ResultSet volunteerDetails( int pageNumber, int nextRecordCount)throws ServletException, IOException { 
  	Statement volunteerDetailsSt =null;
  	ResultSet volunteerDetailsRs = null;
  
  	try {  				
  			volunteerDetailsSt = connection.createStatement();
  			volunteerDetailsRs = volunteerDetailsSt.executeQuery("select * from volunteer_registration limit "+(pageNumber*10)+","+nextRecordCount);
		  
  		} 
  	catch (SQLException e) {
		// TODO: handle exception
  		e.printStackTrace();
			}
  	catch (Exception e) {
		// TODO: handle exception
  		e.printStackTrace();
  		}
	finally {
		
		/*if(NgoDetailSt!=null)
			try {
				NgoDetailSt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
    	 
	}
return volunteerDetailsRs;

}
public void volunteerApproval( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter(); 
	
	Statement ngoEmailSt = null;
	ResultSet ngoEmailRs = null;
	PreparedStatement updateStatusPs = null;
	int emailSentCount =0;
	try {
	   	String from = "kapil.thakur1496@gmail.com";
	   	String to = null;
	   	String volunteerIds[] = request.getParameterValues("volunteerId"); 
	   	String status = request.getParameter("status"); 
	   	

	   	String pageNumber = request.getParameter("pageNumber"); 
	   	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date(); 
	   	if(volunteerIds != null)
	   	{
	   		
		   	for ( int i=0; i<volunteerIds.length;i++ )
			 {  
		   		updateStatusPs = connection.prepareStatement("update  volunteer_registration set  approve_status = ?, approval_date =? where id ="+volunteerIds[i]);  
		   		updateStatusPs.setString(1, status); 
		   		updateStatusPs.setString(2, dateFormat.format(date));  
		   		updateStatusPs.executeUpdate(); 
			 } 
	   	
		   	for(int j=0; j<volunteerIds.length;j++)
		   		{  
		   		 ngoEmailSt = connection.createStatement();
		   		 ngoEmailRs = ngoEmailSt.executeQuery("select email_id from volunteer_registration where id = '"+volunteerIds[j]+ "' and approve_status = '"+status+"'");	   		  
		   		 if(ngoEmailRs.next())
		   		 {
		   			 to = ngoEmailRs.getString(1);
		   		 }
		   		  try {  
			   			Properties props = System.getProperties();
			   			props.setProperty("mail.smtp.host", "smtp.gmail.com");
			   			props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			   			props.setProperty("mail.smtp.socketFactory.fallback", "false");
			   			props.setProperty("mail.smtp.port", "465");
			   			props.setProperty("mail.smtp.socketFactory.port", "465");
			   			props.put("mail.smtp.auth", "true");
			   			props.put("mail.debug", "true");
			   			props.put("mail.store.protocol", "pop3");
			   			props.put("mail.transport.protocol", "smtp");
			   			final String username = "prismhack@gmail.com";
			   			final String password = "code2win";
		   		       
		   			   try{
	   				   		Session mySession = Session.getInstance(props, new Authenticator(){
	   				   			
	   				   			protected PasswordAuthentication getPasswordAuthentication() {
	   				   				return new PasswordAuthentication(username, password);
		   						}
	   				   			
		   					});
	 
		   			      MimeMessage message = new MimeMessage(mySession); 
		   			      message.setFrom(new InternetAddress(from)); 
		   			      message.addRecipient(Message.RecipientType.TO,
		   			                               new InternetAddress(to)); 
		   			      message.setSubject("Volunteer Application Status"); 
		   			      message.setText("Dear Sir/Ma'am\n\n"
		   			    		  +"\n\nYour status has been "+status 
		   			    		 
		   			    		  +"\n\nThank You"
		   			    		  
		   			    		  
		   			    		  +"\nWarm Regards"
		   			    		  +"\n\nPrismVMS"
		   			    		   );
		   			      
		   			      Transport.send(message);
		   			     // result = "Sent message successfully...."; 
		   			      emailSentCount++;
				   						  
	   				  } 
	   			    catch (MessagingException mex) {
	   			      mex.printStackTrace();
	   			      //result = "Error: unable to send message....";
	   			   }
			   		 	 
			   		 }
			   		catch (Exception e) {
			   			// TODO: handle exception
			   		}
		   		}
   
   	
	   	
   	} 
	   	if(emailSentCount == volunteerIds.length) {
	   		response.sendRedirect("admin/manageUsers.jsp?pageNumber="+pageNumber);
	   		/*dispatcher.forward(request, response); */
	   	}
}  
	 catch (SQLException e) {
		// TODO: handle exception
		 e.printStackTrace();
		}
	 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
	 finally {
		  if(ngoEmailSt!=null)
				try {
					ngoEmailSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
        	 if(ngoEmailRs!=null)
				try {
					ngoEmailRs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
	 }
	  out.close(); 
	 
}  
}

 