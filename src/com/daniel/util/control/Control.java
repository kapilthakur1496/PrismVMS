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
		else if(action.equals("assignTeam"))
		{   
			assignTeam(request,response);
		}
		else if(action.equals("createMentor"))
		{   
			createMentor(request,response);
		}
		else if(action.equals("mentorVarification"))
		{   
			mentorVarification(request,response);
		}
		else if(action.equals("otpVerification"))
		{   
			otpVerification(request,response);
		}
		else if(action.equals("assignIndividualProject"))
		{   
			assignIndividualProject(request,response);
		}
		else if(action.equals("createTeamProject"))
		{   
		createTeamProject(request, response); 
		}
		else if(action.equals("assignTeamProject"))
		{   
			assignTeamProject(request, response);
		}
		else if(action.equals("createBranchProject"))
		{   
			createBranchProject(request, response);
		}
		else if(action.equals("assignBranchProject"))
		{   
			assignBranchProject(request, response);
		}
		else if(action.equals("submitWorkDiary"))
		{   
			submitWorkDiary(request, response);
		}
		else if(action.equals("submitWorkDiaryForProjects"))
		{   
			submitWorkDiaryForProject(request, response);
		}
		else if(action.equals("submitMeeting"))
		{   
			submitMeeting(request, response);
		} 
		else if(action.equals("submitTraining"))
		{   
			submitTraining(request, response);
		}
		else if(action.equals("monthWorkDiray"))
		{   
			monthWorkDiray(request, response);
		}
		else if(action.equals("addGrievance"))
		{   
			addGrievance(request, response);
		}
		else if(action.equals("submitGrievance"))
		{   
			submitGrievance(request, response);
		}
		else if(action.equals("addVmsExperienceCategory"))
		{   
			addVmsExperienceCategory(request, response);
		}
		else if(action.equals("submitVmsExperience"))
		{   
			submitVmsExperience(request, response);
		}
		else if(action.equals("addVmsExperienceComment"))
		{   
			addVmsExperienceComment(request, response);
		}
		else if(action.equals("addWorkDiaryComment"))
		{   
			addWorkDiaryComment(request, response);
		}
		else if(action.equals("addWorkMeetingComment"))
		{   
			addWorkMeetingComment(request, response);
		}
		else if(action.equals("addWorkTrainingComment"))
		{   
			addWorkTrainingComment(request, response);
		}
		else if(action.equals("branchProjectApproval"))
		{   
			branchProjectApproval(request, response);
		}
		else if(action.equals("teamProjectApproval"))
		{   
			teamProjectApproval(request, response);
		}
		else if(action.equals("mentorVmsExperience"))
		{   
			mentorVmsExperience(request, response);
		}
		else if(action.equals("addMentorVmsExperienceComment"))
		{   
			addMentorVmsExperienceComment(request, response);
		}
		else if(action.equals("gradeMonthlyReport"))
		{   
			gradeMonthlyReport(request, response);
		}
		else if(action.equals("mentorForgotPassword"))
		{   
			mentorForgotPassword(request,response);
		}
		else if(action.equals("forgotOtpVerification"))
		{   
			forgotOtpVerification(request,response);
		}
		else if(action.equals("volunteerForgotPassword"))
		{   
			volunteerForgotPassword(request,response);
		}
		else if(action.equals("volunteerForgotOtpVerification"))
		{   
			volunteerForgotOtpVerification(request,response);
		}
		else if(action.equals("preVolunteerForgotPassword"))
		{   
			preVolunteerForgotPassword(request,response);
		}
		else if(action.equals("preVolunteerForgotOtpVerification"))
		{   
			preVolunteerForgotOtpVerification(request,response);
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
	public   String getMenorBranch(String id ) throws ServletException, IOException { 
		Statement getTeamsSt =null;
		ResultSet getTeamsRs = null;
		  String branchId = null;
		try {  				
			getTeamsSt = connection.createStatement();
				String query = "select branch_id  from admin where id="+id;
				getTeamsRs = getTeamsSt.executeQuery(query);
				 if(getTeamsRs.next())
				 {
					 branchId = getTeamsRs.getString("branch_id");
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
			
			 if(getTeamsSt!=null)
				try {
					getTeamsSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 if(getTeamsRs!=null)
					try {
						getTeamsRs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
		}
		return branchId;

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
public   ResultSet getApplications(HttpServletRequest request, HttpServletResponse response,String id) throws ServletException, IOException { 
	Statement getTeamsSt =null;
	ResultSet getTeamsRs = null;
	 HttpSession session = request.getSession();
		String adminId = (String)session.getAttribute("adminId");
		if(adminId !=null) {
		try {  				
			getTeamsSt = connection.createStatement();
				String query = "select *   from volunteer_registration where id ='"+id+"'";
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
		}
		else
		{
			 response.sendRedirect("adminLogin.jsp?action=LoginAgain");
		}
	return getTeamsRs;

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
@SuppressWarnings("resource")
private void volunteerRegistration( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    HttpSession session = request.getSession();
	  
    String email=request.getParameter("email");  
	Statement checkVolunteerSt = null;
	ResultSet checkVolunteerRs = null;
	Statement volunteerIdSt = null;
	ResultSet volunteerIdRs = null;
	PreparedStatement addVolunteerps =null;
	try {
			
			volunteerIdSt = connection.createStatement();
			String volunteerId=null;
		 	String checkQ = "select email_id   from volunteer_registration  where email_id ='"+email+"' ";
		 	volunteerIdRs = volunteerIdSt.executeQuery(checkQ);
			
		 	if (volunteerIdRs.next()) {
				 response.sendRedirect("volunteerRegistration.jsp?action=AlreadyRegistered");
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
		  if(volunteerIdSt!=null)
			try {
				volunteerIdSt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		  if(volunteerIdRs!=null)
				try {
					volunteerIdRs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
		  if(checkVolunteerSt!=null)
				try {
					checkVolunteerSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
		  if(addVolunteerps!=null)
				try {
					addVolunteerps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
 	 
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
		
		  if(getStatusSt!=null)
			try {
				getStatusSt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		  if(getStatusRs!=null)
				try {
					getStatusRs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
    	 
	}
	return name;

}
public   String getMentorName(String id) throws ServletException, IOException { 
	Statement getStatusSt =null;
	ResultSet getStatusRs = null;
	  String name =null;
	try {  				
		getStatusSt = connection.createStatement();
			String query = "select volunteer_name   from admin where id = "+id;
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
		
		  if(getStatusSt!=null)
			try {
				getStatusSt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		  if(getStatusRs!=null)
				try {
					getStatusRs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
    	 
	}
	return name;

}

public   int AdminVolunteerCount() throws ServletException, IOException { 
	Statement volunteerCountSt =null;
	ResultSet volunteerCountRs = null;
	int totalCount = 0; 
	
	try {  				
			volunteerCountSt = connection.createStatement();
			 
			volunteerCountRs = volunteerCountSt.executeQuery("select count(id) from volunteer_registration where approve_status ='Approved' ");
		
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
public   int volunteerApplicationCount() throws ServletException, IOException { 
	Statement volunteerCountSt =null;
	ResultSet volunteerCountRs = null;
	int totalCount = 0; 
	
	try {  				
			volunteerCountSt = connection.createStatement();
			 
			volunteerCountRs = volunteerCountSt.executeQuery("select count(id) from volunteer_registration where approve_status !='Approved' ");
		
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
public   int volunteerTeamCount(String id) throws ServletException, IOException { 
	Statement volunteerCountSt =null;
	ResultSet volunteerCountRs = null;
	int totalCount = 0; 
	
	try {  				
			volunteerCountSt = connection.createStatement();
			Control ct= new Control();
			String branchId = ct.getMentorBranch(id);
  		 	String team = ct.getMentorTeams(id);
  		 	String s = "";
  		 	String[] charArray = team.split(" , ");
  		 	for(int i=0;i<charArray.length ;i++)
	  	     {
	  	    	 s=s+"'"+charArray[i]+"'";
	  	    	 if(i<(charArray.length)-1)
	  	    	 {
	  	    		s=s+" , " ;
	  	    	 }
	  	     }
			volunteerCountRs = volunteerCountSt.executeQuery("select count(id) from volunteer_registration where team in("+s+") and branch_id ='"+branchId+"' ");
		
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
public   int volunteerTeamProjectCount(String id) throws ServletException, IOException { 
	Statement volunteerCountSt =null;
	ResultSet volunteerCountRs = null;
	int totalCount = 0; 
	
	try {  				
			volunteerCountSt = connection.createStatement();
			volunteerCountRs = volunteerCountSt.executeQuery("select count(id) from team_project where admin_id= '"+id+"' ");
		
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
public   int volunteerBranchProjectCount(String id) throws ServletException, IOException { 
	Statement volunteerCountSt =null;
	ResultSet volunteerCountRs = null;
	int totalCount = 0; 
	
	try {  				
			volunteerCountSt = connection.createStatement();
			 
			volunteerCountRs = volunteerCountSt.executeQuery("select count(id) from branch_project where admin_id= '"+id+"' ");
		
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
public   int volunteerProjectCount(String volunteerId) throws ServletException, IOException { 
	Statement volunteerCountSt =null;
	ResultSet volunteerCountRs = null;
	int totalCount = 0; 
	try {  				
			volunteerCountSt = connection.createStatement();
			volunteerCountRs = volunteerCountSt.executeQuery("select count(id) from assign_projects where volunteer_registration_id= '"+volunteerId+"' ");
		
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
public   ResultSet applicationDetails(  int pageNumber, int nextRecordCount)throws ServletException, IOException { 
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
	HttpSession session = request.getSession();
	String adminId = (String)session.getAttribute("adminId");
	if(adminId !=null) {
	int emailSentCount =0,updateCount=0;
	try {
	   	String from = "prismhack@gmail.com";
	   	String to = null;
	   	String volunteerIds[] = request.getParameterValues("volunteerId"); 
	   	String status = request.getParameter("status"); 
	   	

	   	String pageNumber = request.getParameter("pageNumber"); 
	   	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date(); 
	   	if(volunteerIds != null)
	   	{
	   		for ( int i=0; i<volunteerIds.length;i++ ) {  
		   		updateStatusPs = connection.prepareStatement("update  volunteer_registration set  approve_status = ?, approval_date =? where id ="+volunteerIds[i]);  
		   		updateStatusPs.setString(1, status); 
		   		updateStatusPs.setString(2, dateFormat.format(date));  
		   		updateStatusPs.executeUpdate(); 
		   		updateCount++;
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
	   	if(emailSentCount ==   updateCount) {
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
	}
	else
	{
		response.sendRedirect("admin/index.jsp?action=LoginAgain");
	}
	  out.close(); 
	 
}  
public   int checkVolunteerStatus(HttpServletRequest request, HttpServletResponse response,String id) throws ServletException, IOException { 
	Statement checkStatusSt =null;
	ResultSet checkStatusRs = null; 
	if(id!=null) {	
		try {  				
				checkStatusSt = connection.createStatement();
				String query = "select id from volunteer_registration where approve_status = 'Approved' ";
				checkStatusRs = checkStatusSt.executeQuery(query);
				if(checkStatusRs.next())
				{
					return 1;
				}
				else
				{
					response.sendRedirect("volunteerLogin.jsp?action=NotVolunteer"); 
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
				
				if(checkStatusSt!=null)
					try {
						checkStatusSt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
				if(checkStatusRs!=null)
					try {
						checkStatusRs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
			}
		}
	else
	{
		response.sendRedirect("volunteerLogin.jsp?action=LoginAgain"); 
	}
	return 0; 
}
public   ResultSet volunteerDetails( int pageNumber, int nextRecordCount)throws ServletException, IOException { 
  	Statement volunteerDetailsSt =null;
  	ResultSet volunteerDetailsRs = null;
  
  	try {  				
  			volunteerDetailsSt = connection.createStatement();
  			volunteerDetailsRs = volunteerDetailsSt.executeQuery("select * from volunteer_registration where approve_status='Approved' limit "+(pageNumber*10)+","+nextRecordCount);
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
public   ResultSet teamVolunteerDetails( int pageNumber, int nextRecordCount, String adminId,String branchId)throws ServletException, IOException { 
  	Statement volunteerDetailsSt =null;
  	ResultSet volunteerDetailsRs = null;
  
  	try {  				
  		 	Control ct= new Control();
  		 			
  		 	String team = ct.getMentorTeams(adminId);
  		 	String s = "";
  		 	String[] charArray = team.split(" , ");
  		 	for(int i=0;i<charArray.length ;i++)
	  	     {
	  	    	 s=s+"'"+charArray[i]+"'";
	  	    	 if(i<(charArray.length)-1)
	  	    	 {
	  	    		s=s+" , " ;
	  	    	 }
	  	     }
  			volunteerDetailsSt = connection.createStatement();
  			String query ="select * from volunteer_registration where approve_status='Approved' and team in("+s+") and branch_id = '"+branchId+"'   limit "+(pageNumber*10)+","+nextRecordCount;
  			volunteerDetailsRs = volunteerDetailsSt.executeQuery(query);
		 
  			
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
public void assignTeam( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();  
    PreparedStatement updateTeamPs = null;
	
	HttpSession session = request.getSession();
	String adminId = (String)session.getAttribute("adminId");
	if(adminId !=null) {
	 
	try { 
	   		String volunteerIds[] = request.getParameterValues("volunteerId"); 
		   	String team = request.getParameter("team");  
			String branch = request.getParameter("branch");  
		   	
		   	String pageNumber = request.getParameter("pageNumber"); 
		    
		   	if(volunteerIds != null)
		   	{
		   		 for ( int i=0; i<volunteerIds.length;i++ )
				 {  
		   			updateTeamPs = connection.prepareStatement("update  volunteer_registration set  team = ?,branch_id=? where id ="+volunteerIds[i]);  
		   			updateTeamPs.setString(1, team);  
		   			updateTeamPs.setString(2, branch);  
		   			updateTeamPs.executeUpdate(); 
				 }  
		   	}  
	   		response.sendRedirect("admin/manageUsers.jsp?pageNumber="+pageNumber);
	   	 
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
		  if(updateTeamPs!=null)
				try {
					updateTeamPs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
	 		}
		}
	else {
	response.sendRedirect("admin/index.jsp?action=LoginAgain"); 
	}
	out.close(); 
	 
	}
public void createMentor( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();   
    String email=request.getParameter("email");  
	Statement checkMentorSt = null;
	ResultSet checkMentorRs = null;
	Statement mentorIdSt=null;
	ResultSet mentorIdRs=null;	 
	PreparedStatement addVolunteerps =null;
	try {  
			checkMentorSt = connection.createStatement();
			String mentorId=null;
		 	String checkQ = "select email   from admin  where email ='"+email+"' ";
		 	checkMentorRs = checkMentorSt.executeQuery(checkQ);
			
		 	if (checkMentorRs.next()) {
				 response.sendRedirect("admin/index.jsp?msg=AlreadyRegistered");
			 }
			 else{     
		 			
			 		String fullName=request.getParameter("fullName");
			 		String userType=request.getParameter("userType");   
			 		String team[] = request.getParameterValues("team"); 
			 		String team1= "";
			 		for( int j=0; j<team.length;j++)
			 		{
			 			team1 = team1+team[j]+" , ";
			 		}
			 		team1 = team1.substring(0,team1.length()-3);
			 		System.out.println("team length ="+team.length);
			 		System.out.println("team ="+team1);
			 		String branch=request.getParameter("branch");  
			 		String status = "Approved";
			 		
					String mentorIdQ = "select max(id)+1 as maxId from admin"; 
					mentorIdSt = connection.createStatement();
					mentorIdRs = mentorIdSt.executeQuery(mentorIdQ);
			 		if (mentorIdRs.next())	{ 
			 			mentorId = mentorIdRs.getString("maxId");			 			  
			 			if(mentorId == null)
			 			{
			 				mentorId ="1";
			 			}
			 			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			 			Date date = new Date();  
						String 	query = "insert into admin (id,name,email,team,admin_type,approve_status,branch_id,approval_date) values (?,?,?,?,?,?,?,?)";
						addVolunteerps = connection.prepareStatement(query);
						addVolunteerps.setString(1, mentorId);
						addVolunteerps.setString(2, fullName);
						addVolunteerps.setString(3, email); 
						addVolunteerps.setString(4, team1); 						
						addVolunteerps.setString(5, userType);  
						addVolunteerps.setString(6, status);
						addVolunteerps.setString(7, branch);  
						addVolunteerps.setString(8,  dateFormat.format(date));
						addVolunteerps.executeUpdate();   
						
				   		  try {  
				   			  	String to = email;
				   			  	String from = "kapil.thakur1496@gmail.com";
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
				   			      message.setSubject("PrismVMS Account Details"); 
				   			      message.setText("Dear Sir/Ma'am\n "
				   			    		  +"\n\n Thanks for being a part of our orgainization"
				   			    		  +"\n\n Please    http://localhost:8081/PrismVMS/admin/updatePassword.jsp    to set your Password"
				   			    		  +"\n\nThank You" 
				   			    		  +"\nWarm Regards"
				   			    		  +"\n\nPrismVMS"
				   			    		   );
				   			      
				   			      Transport.send(message);
				   			     // result = "Sent message successfully...."; 
				   			   response.sendRedirect("admin/index.jsp"); 
								 
						   						  
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
		 if(checkMentorSt!=null) {
				try {
					checkMentorSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
	 		}
		 if(checkMentorRs!=null) {
				try {
					checkMentorRs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}
			if(mentorIdSt!=null) {
				try {
					mentorIdSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}
			if(mentorIdSt!=null) {
				try {
					mentorIdSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}
			if(addVolunteerps!=null) {
				try {
					addVolunteerps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}
			
	 }
	out.close();
}
	 
public void mentorVarification( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			response.setContentType("text/html");
		    PrintWriter out = response.getWriter();   
		    String email=request.getParameter("email");  
			Statement checkMentorSt = null;
			ResultSet checkMentorRs = null; 
			PreparedStatement updatePassDatePs =null;
	try {  
			checkMentorSt = connection.createStatement();
			String mentorId=null;
		 	String checkQ = "select id as mentorId from admin  where email ='"+email+"' and approve_status= 'Approved' and password  is null ";
		 	checkMentorRs = checkMentorSt.executeQuery(checkQ);
			
		 	if (checkMentorRs.next()) { 
		 	 mentorId = checkMentorRs.getString("mentorId");
		 	 Random rnd = new Random();
			 int rand = 100000 + rnd.nextInt(90000); 
			 
			 String otp = Integer.toString(rand);
			 
			 
	   			  
	   			     // result = "Sent message successfully....";  
					String to = email;
	   			  	String from = "kapil.thakur1496@gmail.com";
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
	   			      message.setSubject("PrismVMS Account Details"); 
	   			      message.setText("Dear Sir/Ma'am\n "
	   			    		  +"\n\n Your otp is "+otp
	   			    		    +"\n\nThank You" 
	   			    		  +"\nWarm Regards"
	   			    		  +"\n\nPrismVMS"
	   			    		   );
	   			      
	   			      Transport.send(message);
	   			     // result = "Sent message successfully....";  
	   			      
	   			   DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		 			Date date = new Date(); 
		 			 HttpSession session = request.getSession(); 
					 session.setAttribute("otp", otp); 
					String query = "update admin set password_set=? where id = "+mentorId;
					updatePassDatePs  =  connection.prepareStatement(query);
					updatePassDatePs.setString(1,  dateFormat.format(date));  
					updatePassDatePs.executeUpdate(); 
	   			      
	   			   response.sendRedirect("updatePassword.jsp?action=otpVarification&email="+email);
	  			  
			   						  
   				  } 
   			    catch (MessagingException mex) {
   			      mex.printStackTrace();
   			      //result = "Error: unable to send message....";
   			   }
		   		 
					
		 	}
		 else{     
			 response.sendRedirect("adminLogon.jsp?action=PasswordAlreadySetUseForgotOption");
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
		 if(checkMentorSt!=null) {
				try {
					checkMentorSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
	 		}
		 if(checkMentorRs!=null) {
				try {
					checkMentorRs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}
			 
			 
			if(updatePassDatePs!=null) {
				try {
					updatePassDatePs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}
			
	 }
	out.close();
}
public   void otpVerification(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
	Statement volunteerCountSt =null;
	ResultSet volunteerCountRs = null;
	 try {  				
			String otp = request.getParameter("otp");
			String email = request.getParameter("email");
			
			HttpSession session = request.getSession();   
	        String checkOtp = (String)session.getAttribute("otp");
	        if(checkOtp==null) {
	        	response.sendRedirect("updatePassword.jsp?action=OtpExpired");
	        }
	        if(checkOtp.equals(otp)) {
	        
				volunteerCountSt = connection.createStatement();
				volunteerCountRs = volunteerCountSt.executeQuery("select id  from admin where email ='"+email+"' ");
				PreparedStatement updatePassDatePs =null;
				String password = request.getParameter("password");
				String confirmPassword = request.getParameter("confirmPassword");
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	 			Date date = new Date(); 
		 			
				if(password.equals(confirmPassword) ) { 
					if(volunteerCountRs.next()) {
					
						String query = "update admin  set password=?,password_set=? where id = "+volunteerCountRs.getString("id");
						updatePassDatePs  =  connection.prepareStatement(query);
						updatePassDatePs.setString(1, password);  
						updatePassDatePs.setString(2, dateFormat.format(date));  
						
						updatePassDatePs.executeUpdate();	
						response.sendRedirect("adminLogin.jsp?action=useNewPassword");
					
					}
		        }else
		        {
		        	response.sendRedirect("updatePassword.jsp?action=PasswordAndConfirmPasswordNotMactched");
		        } 
	        }else
	        {
				 response.sendRedirect("updatePassword.jsp?action=otpIsNotCorrect&email="+email);
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
		
}
public   int getAdminType(HttpServletRequest request, HttpServletResponse response,String id) throws ServletException, IOException { 
	Statement checkStatusSt =null;
	ResultSet checkStatusRs = null; 
	  PreparedStatement assingProjectPs =null;
		HttpSession session = request.getSession();
		String adminId = (String)session.getAttribute("adminId");
		if(adminId !=null) {
	if(id!=null) {	
		try {  				
				checkStatusSt = connection.createStatement();
				String query = "select admin_type from admin where id ="+id;
				checkStatusRs = checkStatusSt.executeQuery(query);
				if(checkStatusRs.next())
				{
					
				}
				else
				{
					return 0;
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
				
				if(checkStatusSt!=null)
					try {
						checkStatusSt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
				if(checkStatusRs!=null)
					try {
						checkStatusRs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
			}
		}
	else
	{
		response.sendRedirect("adminLogin.jsp?action=notAdmin"); 
	}
		}else
		{
			response.sendRedirect("adminLogin.jsp?action=LoginAgain"); 
		}
	return 0; 
}
public   int checkMentorStatus(HttpServletRequest request, HttpServletResponse response,String id) throws ServletException, IOException { 
	Statement checkStatusSt =null;
	ResultSet checkStatusRs = null; 
	if(id!=null) {	
		try {  				
				checkStatusSt = connection.createStatement();
				String query = "select id from admin where approve_status = 'Approved' ";
				checkStatusRs = checkStatusSt.executeQuery(query);
				if(checkStatusRs.next())
				{
					return 1;
				}
				else
				{
					response.sendRedirect("adminLogin.jsp?action=NotMentor"); 
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
				
				if(checkStatusSt!=null)
					try {
						checkStatusSt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
				if(checkStatusRs!=null)
					try {
						checkStatusRs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
			}
		}
	else
	{
		response.sendRedirect("adminLogin.jsp?action=LoginAgain"); 
	}
	return 0; 
}
 
public   String  getMentorTeams(String id ) throws ServletException, IOException { 
	Statement getTeamsSt =null;
	ResultSet getTeamsRs = null;
	  String team = "";
	try {  				
		getTeamsSt = connection.createStatement();
			String query = "select team   from admin where id ="+id;
			getTeamsRs = getTeamsSt.executeQuery(query);
			if(getTeamsRs.next())
			{
				team = getTeamsRs.getString("team");
				
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
		
		 if(getTeamsSt!=null)
			try {
				getTeamsSt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 if(getTeamsRs!=null)
				try {
					getTeamsRs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    	 
	}
	return team;

}
public void assignIndividualProject( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();   
    PreparedStatement assingProjectPs =null;
	HttpSession session = request.getSession();
	String adminId = (String)session.getAttribute("adminId");
	if(adminId !=null) {
		try {  
			String projectTitle = request.getParameter("projectTitle");
			String projectStartDate = request.getParameter("projectStartDate");
			String projectEndDate = request.getParameter("projectEndDate");
			String projectDesc = request.getParameter("projectDesc");
			String vId = request.getParameter("vId");
			Control ct = new Control();
			String to = ct.getEmail(vId);
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
 			Date date = new Date(); 
 			
	       // result = "Sent message successfully....";  
			
			String query = "insert into assign_projects  (volunteer_registration_id,project_title, project_desc, project_start_date,project_end_date,admin_id,assign_date) values(?,?,?,?,?,?,?)" ;
			assingProjectPs = connection.prepareStatement(query);
			assingProjectPs.setString(1, vId); 
			assingProjectPs.setString(2, projectTitle); 
			assingProjectPs.setString(3, projectDesc); 
			assingProjectPs.setString(4, projectStartDate); 
			assingProjectPs.setString(5, projectEndDate); 
			assingProjectPs.setString(6, adminId);  
			assingProjectPs.setString(7, dateFormat.format(date));  
			assingProjectPs.executeUpdate();	
	
		  	String from = "kapil.thakur1496@gmail.com";
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
			      message.setSubject("PrismVMS Account Details"); 
			      message.setText("Dear Volunteer\n "
			    		  +"\n\n One New Project is assigned to you "+projectTitle 
			    		   +"\n\nThank You" 
			    		  +"\nWarm Regards"
			    		  +"\n\nPrismVMS"
			    		   );
			      
			      Transport.send(message);
			     // result = "Sent message successfully....";  
			       
			      response.sendRedirect("individualProject.jsp?pN=1");
			      
			  } 
		    catch (MessagingException mex) {
		      mex.printStackTrace();
		      //result = "Error: unable to send message....";
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
		 if(assingProjectPs!=null) {
				try {
					assingProjectPs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}
		} 	 
	}	 
 else{     
	 response.sendRedirect("adminLogin?action=LoginAgain");
 	}  
	out.close();
}
 
 
public   String getEmail(String id) throws ServletException, IOException { 
	Statement getTeamsSt = null;
	ResultSet getTeamsRs = null;
	  String email = null;
	try {  				
		getTeamsSt = connection.createStatement();
			String query = "select email_id from volunteer_registration where id ='"+id+"'";
			getTeamsRs = getTeamsSt.executeQuery(query);
			if(getTeamsRs.next())
			{
				email = getTeamsRs.getString("email_id");
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
		
		 if(getTeamsRs!=null)
			try {
				getTeamsRs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		 if(getTeamsSt!=null)
				try {
					getTeamsSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	return email;

	}
public   String getMentorEmail(String id) throws ServletException, IOException { 
	Statement getTeamsSt = null;
	ResultSet getTeamsRs = null;
	  String email = null;
	try {  				
		getTeamsSt = connection.createStatement();
			String query = "select email from admin where id ='"+id+"'";
			getTeamsRs = getTeamsSt.executeQuery(query);
			if(getTeamsRs.next())
			{
				email = getTeamsRs.getString("email_id");
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
		
		 if(getTeamsRs!=null)
			try {
				getTeamsRs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		 if(getTeamsSt!=null)
				try {
					getTeamsSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	return email;

	}
public   String getPhone(String id) throws ServletException, IOException { 
	Statement getTeamsSt = null;
	ResultSet getTeamsRs = null;
	  String email = null;
	try {  				
		getTeamsSt = connection.createStatement();
			String query = "select contact_num from volunteer_registration where id ='"+id+"'";
			getTeamsRs = getTeamsSt.executeQuery(query);
			if(getTeamsRs.next())
			{
				email = getTeamsRs.getString("contact_num");
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
		
		 if(getTeamsRs!=null)
			try {
				getTeamsRs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		 if(getTeamsSt!=null)
				try {
					getTeamsSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	return email;

	}
public   String getMentorPhone(String id) throws ServletException, IOException { 
	Statement getTeamsSt = null;
	ResultSet getTeamsRs = null;
	  String email = null;
	try {  				
		getTeamsSt = connection.createStatement();
			String query = "select phone from admin where id ='"+id+"'";
			getTeamsRs = getTeamsSt.executeQuery(query);
			if(getTeamsRs.next())
			{
				email = getTeamsRs.getString("phone");
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
		
		 if(getTeamsRs!=null)
			try {
				getTeamsRs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		 if(getTeamsSt!=null)
				try {
					getTeamsSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	return email;

	}
public   ResultSet getEmails(String  team) throws ServletException, IOException { 
	Statement getTeamsSt = null;
	ResultSet getTeamsRs = null;
	 
	try {  				
		getTeamsSt = connection.createStatement();
			String query = "select email_id from volunteer_registration where team  ='"+team+"'";
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
		
		/* if(getTeamsRs!=null)
			try {
				getTeamsRs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		 if(getTeamsSt!=null)
				try {
					getTeamsSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
		}
	return getTeamsRs;

	}
 
public void createTeamProject( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();   
    PreparedStatement assingProjectPs =null;
	HttpSession session = request.getSession();
	ResultSet maxIdRs=null;
	Statement maxISt=null;
	
	String adminId = (String)session.getAttribute("adminId");
	if(adminId !=null) {
		try {
			maxISt = connection.createStatement();
			String queryMaxId = "select max(id)+1 as maxId from team_project";
			maxIdRs = maxISt.executeQuery(queryMaxId);
			if(maxIdRs.next()) {
				String maxId = maxIdRs.getString("maxId");
				ResultSet emailRs =null; 
				String projectTitle = request.getParameter("projectTitle");
				String projectStartDate = request.getParameter("projectStartDate");
				String projectEndDate = request.getParameter("projectEndDate");
				String projectDesc = request.getParameter("projectDesc");
				 
				String team = request.getParameter("team"); 
				Control ct = new Control();
			
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	 			Date date = new Date(); 
	 			String branchId = ct.getMenorBranch(adminId);
		       // result = "Sent message successfully....";  
				
				String query = "insert into team_project(id,tproject_title,tproject_desc,tpro_start_date,tpro_end_date,team,project_creation_date,admin_id,branch_id) values(?,?,?,?,?,?,?,?,?)" ;
				assingProjectPs = connection.prepareStatement(query);
				assingProjectPs.setString(1, maxId); 
				assingProjectPs.setString(2, projectTitle); 
				assingProjectPs.setString(3, projectDesc); 
				assingProjectPs.setString(4, projectStartDate); 
				assingProjectPs.setString(5, projectEndDate); 
				assingProjectPs.setString(6, team); 			
				assingProjectPs.setString(7, dateFormat.format(date)); 
				assingProjectPs.setString(8, adminId);  
				assingProjectPs.setString(9, branchId);  
				assingProjectPs.executeUpdate();	
				emailRs = ct.getEmails(team);
				if(!emailRs.next())
				{
					response.sendRedirect("assignTeamProjects.jsp?projectId="+maxId+"&noData=yes");
			   		
				}else {
				while(emailRs.next()) {
					
				  	String from = "kapil.thakur1496@gmail.com";
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
					     
					      
					      message.addRecipient(Message.RecipientType.BCC,
					              new InternetAddress(emailRs.getString("email_id")));
					      message.setFrom(new InternetAddress(from)); 
	 
					 	 
					      /*message.addRecipient(Message.RecipientType.TO,
					                               new InternetAddress(to)); */
					      message.setSubject("New Team Project"); 
					      message.setText("Dear Volunteer\n "
					    		  +"\n\n One New Project is Created fot your Team "+projectTitle 
					    		  +"\n\n You can enroll yourself by sending enroll request" 
					    		  
					    		  +"\n\nThank You" 
					    		  +"\nWarm Regards"
					    		  +"\n\nPrismVMS"
					    		   );
					      
					      Transport.send(message);
					     // result = "Sent message successfully....";  
					       
					      response.sendRedirect("assignTeamProjects.jsp?projectId="+maxId);
					   			  
					   } 
					    catch (MessagingException mex) {
					      mex.printStackTrace();
					      //result = "Error: unable to send message....";
					   } 
				}
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
	 if(assingProjectPs!=null) {
			try {
				assingProjectPs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		}
	}
}	 
 else{     
	 response.sendRedirect("adminLogin?action=LoginAgain");
 	}  
	out.close();
	}
 
public   ResultSet getVolunteerForTeamProject( String  id) throws ServletException, IOException { 
	Statement getVolunteerSt = null;
	ResultSet getVolunteerRs = null;
	 
	try {  	
		Control ct = new Control();
		String branchId = ct.getTeamProjectBranch(id);
		String team = ct.getTeamProjectTeam(id);
		 
		getVolunteerSt = connection.createStatement();
		 String query = "select id, volunteer_name  from volunteer_registration where team = '"+team+"'  and branch_id='"+branchId+"' and id not in(select volunteer_registration_id from assign_projects where team_project_id ='"+id+"' ) ";
		 getVolunteerRs = getVolunteerSt.executeQuery(query);
			 
			 
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
		
		/* if(getTeamsRs!=null)
			try {
				getTeamsRs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		 if(getTeamsSt!=null)
				try {
					getTeamsSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
		}
	return getVolunteerRs;

	}

public   String getTeamProjectBranch(String  id) throws ServletException, IOException { 
	Statement getTeamProjectSt = null;
	ResultSet getTeamProjectRs = null;
	 String branchId = null;
	try {  				
		getTeamProjectSt = connection.createStatement();
	 
			String query = "select branch_id  from team_project where id = '"+id+"'";
			getTeamProjectRs = getTeamProjectSt.executeQuery(query);
			if(getTeamProjectRs.next())
			{
			branchId = getTeamProjectRs.getString("branch_id");
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
		
		  if(getTeamProjectSt!=null)
			try {
				getTeamProjectSt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		 if(getTeamProjectRs!=null)
				try {
					getTeamProjectRs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
		}
	return branchId;

	}
public   String getTeamProjectTeam(String  id) throws ServletException, IOException { 
	Statement getTeamProjectSt = null;
	ResultSet getTeamProjectRs = null;
	 String team = null;
	try {  				
		getTeamProjectSt = connection.createStatement();
	 
			String query = "select team  from team_project where id = '"+id+"'";
			getTeamProjectRs = getTeamProjectSt.executeQuery(query);
			if(getTeamProjectRs.next())
			{
			team = getTeamProjectRs.getString("team");
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
		
		  if(getTeamProjectSt!=null)
			try {
				getTeamProjectSt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		 if(getTeamProjectRs!=null)
				try {
					getTeamProjectRs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
		}
	return team;

	}
public void assignTeamProject( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();   
    PreparedStatement assingProjectPs =null;
	HttpSession session = request.getSession();
	String adminId = (String)session.getAttribute("adminId");
	if(adminId !=null) {
		try {  
			Control ct = new Control();
			String projectId = request.getParameter("projectId");
			ResultSet teamProjectRs = ct.getTeamProject(projectId);
			String projectTitle=null,projectStartDate=null,projectEndDate=null,projectDesc=null;
			while(teamProjectRs.next())
			{
			  projectTitle = teamProjectRs.getString("tproject_title") ;
			  projectStartDate = teamProjectRs.getString("tpro_start_date") ;
			  projectEndDate = teamProjectRs.getString("tpro_end_date") ;
			  projectDesc = teamProjectRs.getString("tproject_desc") ;
			}
			String vId[] = request.getParameterValues("vIds");
			for(int i=0; i<vId.length;i++) {
			
			 
			String to = ct.getEmail(vId[i]);
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
 			Date date = new Date(); 
 			
	       // result = "Sent message successfully....";  
			
			String query = "insert into assign_projects  (volunteer_registration_id,project_title, project_desc, project_start_date,project_end_date,team_project_id,admin_id,assign_date) values(?,?,?,?,?,?,?,?)" ;
			assingProjectPs = connection.prepareStatement(query);
			assingProjectPs.setString(1, vId[i]); 
			assingProjectPs.setString(2, projectTitle); 
			assingProjectPs.setString(3, projectDesc); 
			assingProjectPs.setString(4, projectStartDate); 
			assingProjectPs.setString(5, projectEndDate); 
			assingProjectPs.setString(6, projectId); 
			assingProjectPs.setString(7, adminId);  
			assingProjectPs.setString(8, dateFormat.format(date));  
			assingProjectPs.executeUpdate();	
	
		  	String from = "kapil.thakur1496@gmail.com";
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
			      message.setSubject("New Team Project"); 
			      message.setText("Dear Volunteer\n "
			    		  +"\n\n you are assigned to a new Team Project "+projectTitle 
			    		   +"\n\nThank You" 
			    		  +"\nWarm Regards"
			    		  +"\n\nPrismVMS"
			    		   );
			      
			      Transport.send(message);
			     // result = "Sent message successfully....";   
			      
			   			  
			  } 
		    catch (MessagingException mex) {
		      mex.printStackTrace();
		      //result = "Error: unable to send message....";
		   } 
			}
			response.sendRedirect("teamProjectView.jsp?pN=1");
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
		 if(assingProjectPs!=null) {
				try {
					assingProjectPs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}
		} 	 
	}	 
 else{     
	 response.sendRedirect("adminLogin.jsp?action=LoginAgain");
 	}  
	out.close();
}

public   ResultSet getTeamProject(String  id) throws ServletException, IOException { 
	Statement getTeamProjectSt = null;
	ResultSet getTeamProjectRs = null;
	 String team = null;
	try {  				
		getTeamProjectSt = connection.createStatement();
	 
			String query = "select *  from team_project where id = '"+id+"'";
			getTeamProjectRs = getTeamProjectSt.executeQuery(query);
			 
			 
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
		
		 /* if(getTeamProjectSt!=null)
			try {
				getTeamProjectSt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		 if(getTeamProjectRs!=null)
				try {
					getTeamProjectRs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} */
		}
	return getTeamProjectRs;

	}
public   ResultSet getTeamProject(HttpServletRequest request, HttpServletResponse response,int pageNumber, int nextRecordCount) throws ServletException, IOException { 
	Statement getTeamProjectSt = null; 
	ResultSet getTeamProjectRs = null;
 
	 HttpSession session = request.getSession();
		String adminId = (String)session.getAttribute("adminId");
		if(adminId !=null) {
		try {  				
				getTeamProjectSt = connection.createStatement();
				String query = "select *  from team_project where admin_id = '"+adminId+"' order by id desc limit "+(pageNumber*10)+","+nextRecordCount;
				getTeamProjectRs = getTeamProjectSt.executeQuery(query);
				  
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
			
			 /* if(getTeamProjectSt!=null)
				try {
					getTeamProjectSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			 if(getTeamProjectRs!=null)
					try {
						getTeamProjectRs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} */
			}
		}
		else
		{
			response.sendRedirect("MentorIndex.jsp?action=LoginAgain");
		}
	return getTeamProjectRs;

	}
public void createBranchProject( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();   
    PreparedStatement assingProjectPs =null;
	HttpSession session = request.getSession();
	ResultSet maxIdRs=null;
	Statement maxISt=null;
	
	String adminId = (String)session.getAttribute("adminId");
	if(adminId !=null) {
		try {
			maxISt = connection.createStatement();
			String queryMaxId = "select max(id)+1 as maxId from branch_project";
			maxIdRs = maxISt.executeQuery(queryMaxId);
			if(maxIdRs.next()) {
				String maxId = maxIdRs.getString("maxId");
				ResultSet emailRs =null; 
				String projectTitle = request.getParameter("projectTitle");
				String projectStartDate = request.getParameter("projectStartDate");
				String projectEndDate = request.getParameter("projectEndDate");
				String projectDesc = request.getParameter("projectDesc");
				 
				Control ct = new Control();
			
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	 			Date date = new Date(); 
	 			String branchId = ct.getMenorBranch(adminId);
		       // result = "Sent message successfully....";  
				
				String query = "insert into branch_project(id,bproject_title,bproject_desc,bpro_start_date,bpro_end_date, bpro_creation_date,admin_id,branch_id) values(?,?,?,?,?,?,?,?)" ;
				assingProjectPs = connection.prepareStatement(query);
				assingProjectPs.setString(1, maxId); 
				assingProjectPs.setString(2, projectTitle); 
				assingProjectPs.setString(3, projectDesc); 
				assingProjectPs.setString(4, projectStartDate); 
				assingProjectPs.setString(5, projectEndDate);  			
				assingProjectPs.setString(6, dateFormat.format(date)); 
				assingProjectPs.setString(7, adminId);  
				assingProjectPs.setString(8, branchId);  
				assingProjectPs.executeUpdate();	
				emailRs = ct.getBranchEmails(branchId);
				while(emailRs.next()) {
					
				  	String from = "kapil.thakur1496@gmail.com";
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
					     
					      
					      message.addRecipient(Message.RecipientType.BCC,
					              new InternetAddress(emailRs.getString("email_id")));
					      message.setFrom(new InternetAddress(from)); 
	 
					 	 
					      /*message.addRecipient(Message.RecipientType.TO,
					                               new InternetAddress(to)); */
					      message.setSubject("New Team Project"); 
					      message.setText("Dear Volunteer\n "
					    		  +"\n\n One New Branch Project is Created fot your Team "+projectTitle 
					    		  +"\n\n You can enroll yourself by sending enroll request" 
					    		  
					    		  +"\n\nThank You" 
					    		  +"\nWarm Regards"
					    		  +"\n\nPrismVMS"
					    		   );
					      
					      Transport.send(message);
					     // result = "Sent message successfully....";  
					       
					      response.sendRedirect("assignBranchProjects.jsp?projectId="+maxId);
					   			  
					   } 
					    catch (MessagingException mex) {
					      mex.printStackTrace();
					      //result = "Error: unable to send message....";
					   } 
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
	 if(assingProjectPs!=null) {
			try {
				assingProjectPs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		}
	}
}	 
 else{     
	 response.sendRedirect("adminLogin.jsp?action=LoginAgain");
 	}  
	out.close();
	}
public   ResultSet getVolunteerForBranchProject( String  id,String adminId) throws ServletException, IOException { 
	Statement getVolunteerSt = null;
	ResultSet getVolunteerRs = null;
	 
	try {  	
		Control ct = new Control();
		String branchId = ct.getMentorBranch(adminId);
		  
		getVolunteerSt = connection.createStatement();
		 String query = "select id, volunteer_name  from volunteer_registration where branch_id='"+branchId+"' and id not in(select volunteer_registration_id from assign_projects where bproject_id ='"+id+"' ) ";
		 getVolunteerRs = getVolunteerSt.executeQuery(query);
			 
			 
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
		
		/* if(getTeamsRs!=null)
			try {
				getTeamsRs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		 if(getTeamsSt!=null)
				try {
					getTeamsSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
		}
	return getVolunteerRs;

	}
public   String getMentorBranch(String id) throws ServletException, IOException { 
	Statement getTeamProjectSt = null;
	ResultSet getTeamProjectRs = null;
	 String branchId = null; 
	 
		try {  				
				getTeamProjectSt = connection.createStatement(); 
				String query = "select branch_id  from admin where id = '"+id+"'";
				getTeamProjectRs = getTeamProjectSt.executeQuery(query);
				if(getTeamProjectRs.next())
				{
				branchId = getTeamProjectRs.getString("branch_id");
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
			
			  if(getTeamProjectSt!=null)
				try {
					getTeamProjectSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			 if(getTeamProjectRs!=null)
					try {
						getTeamProjectRs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
			}
	 
	return branchId;

	}
public   String getVolunteerBranch(String id) throws ServletException, IOException { 
	Statement getTeamProjectSt = null;
	ResultSet getTeamProjectRs = null;
	 String branchId = null; 
	 
		try {  				
				getTeamProjectSt = connection.createStatement(); 
				String query = "select branch_id  from volunteer_registration where id = '"+id+"'";
				getTeamProjectRs = getTeamProjectSt.executeQuery(query);
				if(getTeamProjectRs.next())
				{
				branchId = getTeamProjectRs.getString("branch_id");
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
			
			  if(getTeamProjectSt!=null)
				try {
					getTeamProjectSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			 if(getTeamProjectRs!=null)
					try {
						getTeamProjectRs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
			}
	 
	return branchId;

	}
public   ResultSet getBranchEmails(String  id) throws ServletException, IOException { 
	Statement getTeamsSt = null;
	ResultSet getTeamsRs = null;
	 
	try {  				
		getTeamsSt = connection.createStatement();
			String query = "select email_id from volunteer_registration where branch_id  ='"+id+"'";
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
		
		/* if(getTeamsRs!=null)
			try {
				getTeamsRs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		 if(getTeamsSt!=null)
				try {
					getTeamsSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
		}
	return getTeamsRs;

	}
public void assignBranchProject( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();   
    PreparedStatement assingProjectPs =null;
	HttpSession session = request.getSession();
	String adminId = (String)session.getAttribute("adminId");
	if(adminId !=null) {
		try {  
			Control ct = new Control();
			String projectId = request.getParameter("projectId");
			ResultSet teamProjectRs = ct.getBranchProject(projectId);
			String projectTitle=null,projectStartDate=null,projectEndDate=null,projectDesc=null;
			while(teamProjectRs.next())
			{
			  projectTitle = teamProjectRs.getString("bproject_title") ;
			  projectStartDate = teamProjectRs.getString("bpro_start_date") ;
			  projectEndDate = teamProjectRs.getString("bpro_end_date") ;
			  projectDesc = teamProjectRs.getString("bproject_desc") ;
			}
			String vId[] = request.getParameterValues("vIds");
			for(int i=0; i<vId.length;i++) {
			
			 
			String to = ct.getEmail(vId[i]);
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
 			Date date = new Date(); 
 			
	       // result = "Sent message successfully....";  
			
			String query = "insert into assign_projects  (volunteer_registration_id,project_title, project_desc, project_start_date,project_end_date,bproject_id,admin_id,assign_date) values(?,?,?,?,?,?,?,?)" ;
			assingProjectPs = connection.prepareStatement(query);
			assingProjectPs.setString(1, vId[i]); 
			assingProjectPs.setString(2, projectTitle); 
			assingProjectPs.setString(3, projectDesc); 
			assingProjectPs.setString(4, projectStartDate); 
			assingProjectPs.setString(5, projectEndDate); 
			assingProjectPs.setString(6, projectId); 
			assingProjectPs.setString(7, adminId);  
			assingProjectPs.setString(8, dateFormat.format(date));  
			assingProjectPs.executeUpdate();	
	
		  	String from = "kapil.thakur1496@gmail.com";
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
			      message.setSubject("New Branch Project "); 
			      message.setText("Dear Volunteer\n "
			    		  +"\n\n You are assigned to a new Branch Project  "+projectTitle 
			    		   +"\n\nThank You" 
			    		  +"\nWarm Regards"
			    		  +"\n\nPrismVMS"
			    		   );
			      
			      Transport.send(message);
			     // result = "Sent message successfully....";   
			      
			   			  
			  } 
		    catch (MessagingException mex) {
		      mex.printStackTrace();
		      //result = "Error: unable to send message....";
		   } 
			}
			response.sendRedirect("branchProjectView.jsp?pN=1");
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
		 if(assingProjectPs!=null) {
				try {
					assingProjectPs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}
		} 	 
	}	 
 else{     
	 response.sendRedirect("adminLogin.jsp?action=LoginAgain");
 	}  
	out.close();
}
public   ResultSet getBranchProject(String  id) throws ServletException, IOException { 
	Statement getBranchProjectSt = null;
	ResultSet getBranchProjectRs = null;
	try {  				
			getBranchProjectSt = connection.createStatement();
			String query = "select *  from branch_project where id = '"+id+"'";
			getBranchProjectRs = getBranchProjectSt.executeQuery(query);
			 
			 
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
		
		 /* if(getTeamProjectSt!=null)
			try {
				getTeamProjectSt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		 if(getTeamProjectRs!=null)
				try {
					getTeamProjectRs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} */
		}
	return getBranchProjectRs;

	}
public   String getBranchName(String  id) throws ServletException, IOException { 
		Statement getBranchSt = null;
		ResultSet getBranchRs = null;
		String branchName=null;
		try {  				
			getBranchSt = connection.createStatement();
				String query = "select  name  from branch where id = '"+id+"'";
				getBranchRs = getBranchSt.executeQuery(query);
				if(getBranchRs.next())
				{
					branchName = getBranchRs.getString("name");
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
			
			 if(getBranchSt!=null)
				try {
					getBranchSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			 if(getBranchRs!=null)
					try {
						getBranchRs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}   
			}
		return branchName;

		}
public   ResultSet getBranchProject(HttpServletRequest request, HttpServletResponse response,int pageNumber, int nextRecordCount) throws ServletException, IOException { 
	Statement getTeamProjectSt = null; 
	ResultSet getTeamProjectRs = null;
 
	 HttpSession session = request.getSession();
		String adminId = (String)session.getAttribute("adminId");
		if(adminId !=null) {
		try {  				
				getTeamProjectSt = connection.createStatement();
				String query = "select *  from branch_project where admin_id = '"+adminId+"' limit "+(pageNumber*10)+","+nextRecordCount;
				getTeamProjectRs = getTeamProjectSt.executeQuery(query);
				  
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
			
			 /* if(getTeamProjectSt!=null)
				try {
					getTeamProjectSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			 if(getTeamProjectRs!=null)
					try {
						getTeamProjectRs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} */
			}
		}
		else
		{
			response.sendRedirect("MentorIndex.jsp?action=LoginAgain");
		}
	return getTeamProjectRs;

	}
public   ResultSet getVolunteerProject(HttpServletRequest request, HttpServletResponse response,int pageNumber, int nextRecordCount) throws ServletException, IOException { 
	Statement getTeamProjectSt = null; 
	ResultSet getTeamProjectRs = null;
 
	 HttpSession session = request.getSession();
		String volunteerId = (String)session.getAttribute("volunteerId");
		if(volunteerId !=null) {
		try {  				
				getTeamProjectSt = connection.createStatement();
				String query = "select *  from assign_projects where volunteer_registration_id = '"+volunteerId+"' limit "+(pageNumber*10)+","+nextRecordCount;
				getTeamProjectRs = getTeamProjectSt.executeQuery(query);
				  
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
			
			 /* if(getTeamProjectSt!=null)
				try {
					getTeamProjectSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			 if(getTeamProjectRs!=null)
					try {
						getTeamProjectRs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} */
			}
		}
		else
		{
			response.sendRedirect("MentorIndex.jsp?action=LoginAgain");
		}
	return getTeamProjectRs;

	}
public void submitWorkDiary( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();   
    PreparedStatement assingProjectPs =null;
	HttpSession session = request.getSession();
	String volunteerId = (String)session.getAttribute("volunteerId");
	if(volunteerId !=null) {
		try {  
			Control ct = new Control();
			String projectId = request.getParameter("projectId");
			String wdate = request.getParameter("wdate");
			String wtime = request.getParameter("wtime");
			String taskDesc = request.getParameter("taskDesc");
			 
			String team =  ct.getVolunteerTeam(volunteerId);
			 
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
 			Date date = new Date(); 
 			
	       // result = "Sent message successfully....";  
			
			String query = "insert into workdiary  ( project_id,volunteer_registration_id,wdate,work_desc,whours,submit_date) values(?,?,?,?,?,?)" ;
			assingProjectPs = connection.prepareStatement(query);
			assingProjectPs.setString(1, projectId); 
			assingProjectPs.setString(2, volunteerId); 
			assingProjectPs.setString(3, wdate); 
			assingProjectPs.setString(4, taskDesc); 
			assingProjectPs.setString(5, wtime); 
			assingProjectPs.setString(6, dateFormat.format(date));   
			assingProjectPs.executeUpdate();	
	 
		 
			response.sendRedirect("projectAssigned.jsp?pN=1");
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
		 if(assingProjectPs!=null) {
				try {
					assingProjectPs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}
		} 	 
	}	 
 else{     
	 response.sendRedirect("adminLogin.jsp?action=LoginAgain");
 	}  
	out.close();
}

 public   String getVolunteerTeam(String id ) throws ServletException, IOException { 
	Statement getTeamsSt =null;
	ResultSet getTeamsRs = null;
	  String team = null;
	try {  				
		getTeamsSt = connection.createStatement();
			String query = "select team   from volunteer_registration where id="+id;
			getTeamsRs = getTeamsSt.executeQuery(query);
			 if(getTeamsRs.next())
			 {
				 team = getTeamsRs.getString("team");
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
		
		 if(getTeamsSt!=null)
			try {
				getTeamsSt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 if(getTeamsRs!=null)
				try {
					getTeamsRs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
	}
	return team;

}
 
public   ResultSet getWorkDiaryProject( HttpServletRequest request, HttpServletResponse response,String projectId) throws ServletException, IOException { 
	Statement getTeamsSt =null;
	ResultSet getTeamsRs = null;
	 HttpSession session = request.getSession();
		String volunteerId = (String)session.getAttribute("volunteerId");
		if(volunteerId !=null) {
		
			try {  				
					getTeamsSt = connection.createStatement();
					String query = "select *   from workdiary where project_id= '"+projectId+"' and volunteer_registration_id='"+volunteerId+"'";
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
		}
	return getTeamsRs;

}

public   String getProjectName(String id) throws ServletException, IOException { 
	Statement getStatusSt =null;
	ResultSet getStatusRs = null;
	  String project_titile =null;
	try {  				
		getStatusSt = connection.createStatement();
			String query = "select project_title from assign_projects where id = "+id;
			getStatusRs = getStatusSt.executeQuery(query);
			 if(getStatusRs.next())
			 {
				 project_titile = getStatusRs.getString("project_title");
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
	return project_titile; 
}
public   ResultSet getVoluntterProjects(String id) throws ServletException, IOException { 
	Statement getProjectSt =null;
	ResultSet getProjectRs = null;

	try {  				
			getProjectSt = connection.createStatement();
			String query = "select project_title,id from assign_projects where  volunteer_registration_id = "+id;
			getProjectRs = getProjectSt.executeQuery(query);
			 
			 
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
	return getProjectRs; 
}


public void submitWorkDiaryForProject( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();   
    PreparedStatement assingProjectPs =null;
	HttpSession session = request.getSession();
	String volunteerId = (String)session.getAttribute("volunteerId");
	if(volunteerId !=null) {
		try {  
			Control ct = new Control();
			String projectId = request.getParameter("projectId");
			String wdate = request.getParameter("wdate");
			String wtime = request.getParameter("wtime");
			String taskDesc = request.getParameter("taskDesc");
			 
			String team =  ct.getVolunteerTeam(volunteerId);
			 
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
 			Date date = new Date(); 
 			
	       // result = "Sent message successfully....";  
			
			String query = "insert into workdiary  ( project_id,volunteer_registration_id,wdate,work_desc,whours,submit_date) values(?,?,?,?,?,?)" ;
			assingProjectPs = connection.prepareStatement(query);
			assingProjectPs.setString(1, projectId); 
			assingProjectPs.setString(2, volunteerId); 
			assingProjectPs.setString(3, wdate); 
			assingProjectPs.setString(4, taskDesc); 
			assingProjectPs.setString(5, wtime); 
			assingProjectPs.setString(6, dateFormat.format(date));   
			assingProjectPs.executeUpdate();	
	 
		 
			response.sendRedirect("workDiary.jsp?msg=workDiarySubmitted");
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
		 if(assingProjectPs!=null) {
				try {
					assingProjectPs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}
		} 	 
	}	 
 else{     
	 response.sendRedirect("volunteerLogin.jsp?action=LoginAgain");
 	}  
	out.close();
}

public   ResultSet getVoluntterMeetings() throws ServletException, IOException { 
	Statement getMeetingSt =null;
	ResultSet getMeetingRs = null;

	try {  				
			getMeetingSt = connection.createStatement();
			String query = "select meeting_type  from meeting_type  ";
			getMeetingRs = getMeetingSt.executeQuery(query); 
			 
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
	return getMeetingRs; 
}
public void submitMeeting( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();   
    PreparedStatement assingProjectPs =null;
	HttpSession session = request.getSession();
	String volunteerId = (String)session.getAttribute("volunteerId");
	if(volunteerId !=null) {
		try {  
			Control ct = new Control();
			String meeting = request.getParameter("meeting");
			String mdate = request.getParameter("mdate");
			String mtime = request.getParameter("mtime");
			String meetingDesc = request.getParameter("meetingDesc");
			 
			 
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
 			Date date = new Date(); 
 			
	       // result = "Sent message successfully....";  
			
			String query = "insert into work_meeting  (meeting_date,meeting_type,total_hours,meeting_discuss,volunteer_registration_id, submit_date) values(?,?,?,?,?,?)" ;
			assingProjectPs = connection.prepareStatement(query);
			assingProjectPs.setString(1, mdate); 
			assingProjectPs.setString(2, meeting); 
			assingProjectPs.setString(3, mtime); 
			assingProjectPs.setString(4, meetingDesc); 
			assingProjectPs.setString(5, volunteerId); 
			assingProjectPs.setString(6, dateFormat.format(date));   
			assingProjectPs.executeUpdate();	 
			response.sendRedirect("workMeeting.jsp?msg=meetingSubmitted");
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
		 if(assingProjectPs!=null) {
				try {
					assingProjectPs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}
		} 	 
	}	 
 else{     
	 response.sendRedirect("volunteerLogin.jsp?action=LoginAgain");
 	}  
	out.close();
}


public   ResultSet getWorkMeeting( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
	Statement getTeamsSt =null;
	ResultSet getTeamsRs = null;
	 HttpSession session = request.getSession();
		String volunteerId = (String)session.getAttribute("volunteerId");
		if(volunteerId !=null) {
		
			try {  				
					getTeamsSt = connection.createStatement();
					String query = "select *   from work_meeting where   volunteer_registration_id='"+volunteerId+"'";
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
		}
	return getTeamsRs;

}
public   ResultSet getVolunteerWorkMeeting( HttpServletRequest request, HttpServletResponse response,String id) throws ServletException, IOException { 
	Statement getTeamsSt =null;
	ResultSet getTeamsRs = null;
	 HttpSession session = request.getSession();
		String adminId = (String)session.getAttribute("adminId");
		if(adminId !=null) {
		
			try {  				
					getTeamsSt = connection.createStatement();
					String query = "select *   from work_meeting where   volunteer_registration_id='"+id+"'";
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
		}
		else
		{
			 response.sendRedirect("mentorIndex.jsp?action=LoginAgain");
		}
	return getTeamsRs;

}
public   ResultSet getVolunteerWorkTraining( HttpServletRequest request, HttpServletResponse response,String id) throws ServletException, IOException { 
	Statement getTeamsSt =null;
	ResultSet getTeamsRs = null;
	 HttpSession session = request.getSession();
		String adminId = (String)session.getAttribute("adminId");
		if(adminId !=null) {
		
			try {  				
					getTeamsSt = connection.createStatement();
					String query = "select * from work_training where volunteer_registration_id='"+id+"'";
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
		}
		else
		{
			 response.sendRedirect("mentorIndex.jsp?action=LoginAgain");
		}
	return getTeamsRs; 
}

public   ResultSet getWorkTraining( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
	Statement getTeamsSt =null;
	ResultSet getTeamsRs = null;
	 HttpSession session = request.getSession();
		String volunteerId = (String)session.getAttribute("volunteerId");
		if(volunteerId !=null) {
		
			try {  				
					getTeamsSt = connection.createStatement();
					String query = "select * from work_training where volunteer_registration_id='"+volunteerId+"'";
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
		}
	return getTeamsRs; 
}

public   String getTeamId(String name ) throws ServletException, IOException { 
	Statement getTeamsSt =null;
	ResultSet getTeamsRs = null;
	  String teamId = null;
	try {  				
		getTeamsSt = connection.createStatement();
			String query = "select id from teams where team_name='"+name+"'";
			getTeamsRs = getTeamsSt.executeQuery(query);
			 if(getTeamsRs.next())
			 {
				 teamId = getTeamsRs.getString("id");
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
		
		 if(getTeamsSt!=null)
			try {
				getTeamsSt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 if(getTeamsRs!=null)
				try {
					getTeamsRs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
	}
	return teamId;

}
public   ResultSet getTrainging(String teamId ) throws ServletException, IOException { 
	Statement getTraningSt =null;
	ResultSet getTraningRs = null;
	  
	try {  				
		getTraningSt = connection.createStatement();
			String query = "select *  from training_type where team_id="+teamId;
			getTraningRs = getTraningSt.executeQuery(query);
			  
			 
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
		
		 /*if(getTeamsSt!=null)
			try {
				getTeamsSt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 if(getTeamsRs!=null)
				try {
					getTeamsRs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} */
	}
	return getTraningRs;

}
public void submitTraining( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();   
    PreparedStatement assingProjectPs =null;
	HttpSession session = request.getSession();
	String volunteerId = (String)session.getAttribute("volunteerId");
	if(volunteerId !=null) {
		try {  
		 
			String training = request.getParameter("training");
			String tdate = request.getParameter("tdate");
			String ttime = request.getParameter("ttime");
			String meetingDesc = request.getParameter("trainingDesc");
			 
			 
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
 			Date date = new Date(); 
 			
	       // result = "Sent message successfully....";  
			
			String query = "insert into work_training  (train_date,train_type,train_time,train_topic,volunteer_registration_id ,submit_date) values(?,?,?,?,?,?)" ;
			assingProjectPs = connection.prepareStatement(query);
			assingProjectPs.setString(1, tdate); 
			assingProjectPs.setString(2, training); 
			assingProjectPs.setString(3, ttime); 
			assingProjectPs.setString(4, meetingDesc); 
			assingProjectPs.setString(5, volunteerId); 
			assingProjectPs.setString(6, dateFormat.format(date));   
			assingProjectPs.executeUpdate();	 
			response.sendRedirect("workTraining.jsp?msg=trainingSubmitted");
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
		 if(assingProjectPs!=null) {
				try {
					assingProjectPs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}
		} 	 
	}	 
 else{     
	 response.sendRedirect("volunteerLogin.jsp?action=LoginAgain");
 	}  
	out.close();
}
public void monthWorkDiray( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();   
    PreparedStatement assingProjectPs =null;
	HttpSession session = request.getSession();
	String volunteerId = (String)session.getAttribute("volunteerId");
	if(volunteerId !=null) {
		try {  
		 
			String fromDate = request.getParameter("fromDate");
			String toDate = request.getParameter("toDate");
			String skills = request.getParameter("skills");
			String progress = request.getParameter("progress");
			String futureProspects = request.getParameter("futureProspects");
			String challenges = request.getParameter("challenges"); 
			 
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
 			Date date = new Date(); 
 			String  status = "Submitted";
	       // result = "Sent message successfully....";  
			
			String query = "insert into month_workdairy  (submit_date,to_date,from_date,skillaacquired,progress,challenges,future_prospects, volunteer_registration_id,report_submission) values(?,?,?,?,?,?,?,?,?)" ;
			assingProjectPs = connection.prepareStatement(query);
			assingProjectPs.setString(1, dateFormat.format(date)); 
			assingProjectPs.setString(2, toDate); 
			assingProjectPs.setString(3, fromDate); 
			assingProjectPs.setString(4, skills); 
			assingProjectPs.setString(5, progress); 
			assingProjectPs.setString(6, challenges); 
			assingProjectPs.setString(7, futureProspects);  
			assingProjectPs.setString(8, volunteerId);			
			assingProjectPs.setString(9, status);
			assingProjectPs.executeUpdate();	 
			response.sendRedirect("monthlyReport.jsp?msg=monthlyReportSubmitted");
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
		 if(assingProjectPs!=null) {
				try {
					assingProjectPs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}
		} 	 
	}	 
 else{     
	 response.sendRedirect("volunteerLogin.jsp?action=LoginAgain");
 	}  
	out.close();
}


public   ResultSet getWorkDiary(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException { 
	Statement getTraningSt =null;
	ResultSet getTraningRs = null;
	HttpSession session = request.getSession();
	String volunteerId = (String)session.getAttribute("volunteerId");
	if(volunteerId !=null) {
	  
	try {  				
			getTraningSt = connection.createStatement();
			String query = "select *  from workdiary where volunteer_registration_id="+volunteerId;
			getTraningRs = getTraningSt.executeQuery(query);
			  
			 
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
			
			 /*if(getTeamsSt!=null)
				try {
					getTeamsSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 if(getTeamsRs!=null)
					try {
						getTeamsRs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} */
		}
		}
	else{
		response.sendRedirect("volunteerIndex.jsp?action=LoginAgain");
	}
	return getTraningRs;

}

public   ResultSet getMonthlyReport(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException { 
	Statement getMonthReportSt =null;
	ResultSet getMonthReportRs = null;
	HttpSession session = request.getSession();
	String volunteerId = (String)session.getAttribute("volunteerId");
	if(volunteerId !=null) {
	  
		try {  				
				getMonthReportSt = connection.createStatement();
				String query = "select *  from month_workdairy where volunteer_registration_id="+volunteerId;
				getMonthReportRs = getMonthReportSt.executeQuery(query);
				  
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
				
				 /*if(getTeamsSt!=null)
					try {
						getTeamsSt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				 if(getTeamsRs!=null)
						try {
							getTeamsRs.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} */
			}
		}
	else{
		response.sendRedirect("volunteerIndex.jsp?action=LoginAgain");
	}
	return getMonthReportRs;

}
public   ResultSet getMonthlyReportGrades(HttpServletRequest request, HttpServletResponse response,String id)   throws ServletException, IOException { 
	Statement getMonthReportSt =null;
	ResultSet getMonthReportRs = null;
	HttpSession session = request.getSession();
	String adminId = (String)session.getAttribute("adminId");
	if(adminId !=null) {
	  
		try {  				
				getMonthReportSt = connection.createStatement();
				String query = "select *  from month_workdairy where month_work_id="+id;
				getMonthReportRs = getMonthReportSt.executeQuery(query);
				  
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
				
				 /*if(getTeamsSt!=null)
					try {
						getTeamsSt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				 if(getTeamsRs!=null)
						try {
							getTeamsRs.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} */
			}
		}
	else{
		response.sendRedirect("mentorIndex.jsp?action=LoginAgain");
	}
	return getMonthReportRs;

}
public   ResultSet getVolunteerMonthlyReportGrades(HttpServletRequest request, HttpServletResponse response,String id)   throws ServletException, IOException { 
	Statement getMonthReportSt =null;
	ResultSet getMonthReportRs = null;
	HttpSession session = request.getSession();
	String volunteerId = (String)session.getAttribute("volunteerId");
	if(volunteerId !=null) {
	  
		try {  				
				getMonthReportSt = connection.createStatement();
				String query = "select *  from month_workdairy where month_work_id="+id;
				getMonthReportRs = getMonthReportSt.executeQuery(query);
				  
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
				
				 /*if(getTeamsSt!=null)
					try {
						getTeamsSt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				 if(getTeamsRs!=null)
						try {
							getTeamsRs.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} */
			}
		}
	else{
		response.sendRedirect("volunteerIndex.jsp?action=LoginAgain");
	}
	return getMonthReportRs;

}
public   ResultSet getVolunteerMonthlyReport(HttpServletRequest request, HttpServletResponse response,String id)   throws ServletException, IOException { 
	Statement getMonthReportSt =null;
	ResultSet getMonthReportRs = null;
	HttpSession session = request.getSession();
	String adminId = (String)session.getAttribute("adminId");
	if(adminId !=null) {
	  
		try {  				
				getMonthReportSt = connection.createStatement();
				String query = "select *  from month_workdairy where volunteer_registration_id="+id;
				getMonthReportRs = getMonthReportSt.executeQuery(query);
				  
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
				
				 /*if(getTeamsSt!=null)
					try {
						getTeamsSt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				 if(getTeamsRs!=null)
						try {
							getTeamsRs.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} */
			}
		}
	else{
		response.sendRedirect("volunteerIndex.jsp?action=LoginAgain");
	}
	return getMonthReportRs;

}
public   ResultSet getVolunteerBranchProject(HttpServletRequest request, HttpServletResponse response,int pageNumber, int nextRecordCount) throws ServletException, IOException { 
	Statement getTeamProjectSt = null; 
	ResultSet getTeamProjectRs = null;
 
	 HttpSession session = request.getSession();
		String volunteerId = (String)session.getAttribute("volunteerId");
		if(volunteerId !=null) {
		try {  				
				getTeamProjectSt = connection.createStatement();
				Control ct = new Control(); 
				String branchId  = ct.getVolunteerBranch(volunteerId); 
				
				String query = "select *  from branch_project where    branch_id ='"+branchId+"'   limit "+(pageNumber*10)+","+nextRecordCount;
				getTeamProjectRs = getTeamProjectSt.executeQuery(query);
				  
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
			
			 /* if(getTeamProjectSt!=null)
				try {
					getTeamProjectSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			 if(getTeamProjectRs!=null)
					try {
						getTeamProjectRs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} */
			}
		}
		else
		{
			response.sendRedirect("volunteerIndex.jsp?action=LoginAgain");
		}
	return getTeamProjectRs;

	}
public  String getTeamProjectStatus(HttpServletRequest request, HttpServletResponse response, String id  ) throws ServletException, IOException { 
	Statement getTeamProjectSt = null; 
	ResultSet getTeamProjectRs = null;
	Statement getAssignProjectSt = null; 
	ResultSet getAssignProjectRs = null;
	String status =null;
	 HttpSession session = request.getSession();
		String volunteerId = (String)session.getAttribute("volunteerId");
		if(volunteerId !=null) {
		try {  				
				
				getAssignProjectSt = connection.createStatement();
			  	String query = "select enroll_status  from team_project_enrollment where  volunteer_registrationg_id = '"+volunteerId+"' and team_project_id ='"+id+"'";
				String query1 = "select id  from assign_projects where team_project_id='"+id+"' and volunteer_registration_id='"+volunteerId+"'  ";
				getAssignProjectRs = getAssignProjectSt.executeQuery(query1);
				 if(!getAssignProjectRs.next())
				 {
					  getTeamProjectSt = connection.createStatement();
					  getTeamProjectRs = getTeamProjectSt.executeQuery(query);
					  if(getTeamProjectRs.next()) {
						  status = getTeamProjectRs.getString("enroll_status");
					  } 
					  System.out.println("status "+status);
				 }
				 else 
				 {
					 status="Project Assigned";
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
			
			 if(getTeamProjectSt!=null)
				try {
					getTeamProjectSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			 if(getTeamProjectRs!=null)
					try {
						getTeamProjectRs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			 if(getAssignProjectSt!=null)
					try {
						getAssignProjectSt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
			 if(getAssignProjectRs!=null)
					try {
						getAssignProjectRs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
			}
		}
		else
		{
			response.sendRedirect("volunteerLogin.jsp?action=LoginAgain");
		}
	return status;

	}
public   ResultSet getVolunteerTeamProject(HttpServletRequest request, HttpServletResponse response,int pageNumber, int nextRecordCount) throws ServletException, IOException { 
	Statement getTeamProjectSt = null; 
	ResultSet getTeamProjectRs = null;
 
	 HttpSession session = request.getSession();
		String volunteerId = (String)session.getAttribute("volunteerId");
		if(volunteerId !=null) {
		try {  				
				getTeamProjectSt = connection.createStatement();
				Control ct = new Control();
				String team = ct.getVolunteerTeam(volunteerId);
				String branchId  = ct.getVolunteerBranch(volunteerId); 
				
				String query = "select *  from team_project where team='"+team+"' and branch_id ='"+branchId+"'   limit "+(pageNumber*10)+","+nextRecordCount;
				getTeamProjectRs = getTeamProjectSt.executeQuery(query);
				  
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
			
			 /* if(getTeamProjectSt!=null)
				try {
					getTeamProjectSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			 if(getTeamProjectRs!=null)
					try {
						getTeamProjectRs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} */
			}
		}
		else
		{
			response.sendRedirect("MentorIndex.jsp?action=LoginAgain");
		}
	return getTeamProjectRs;

	}
public  String getBranchProjectStatus(HttpServletRequest request, HttpServletResponse response, String id  ) throws ServletException, IOException { 
	Statement getTeamProjectSt = null; 
	ResultSet getTeamProjectRs = null;
	Statement getAssignProjectSt = null; 
	ResultSet getAssignProjectRs = null;
	String status =null;
	 HttpSession session = request.getSession();
		String volunteerId = (String)session.getAttribute("volunteerId");
		if(volunteerId !=null) {
		try {  				
				
				getAssignProjectSt = connection.createStatement();
			  	String query = "select enroll_status  from branch_project_enrollment where  volunteer_registrationg_id = '"+volunteerId+"' and branch_project_id ='"+id+"'";
				String query1 = "select id  from assign_projects where bproject_id='"+id+"' and volunteer_registration_id='"+volunteerId+"'  ";
				getAssignProjectRs = getAssignProjectSt.executeQuery(query1);
				 if(!getAssignProjectRs.next())
				 {
					  getTeamProjectSt = connection.createStatement();
					  getTeamProjectRs = getTeamProjectSt.executeQuery(query);
					  if(getTeamProjectRs.next()) {
						  status = getTeamProjectRs.getString("enroll_status");
					  } 
					  System.out.println("status "+status);
				 }
				 else 
				 {
					 status="Project Assigned";
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
			
			 if(getTeamProjectSt!=null)
				try {
					getTeamProjectSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			 if(getTeamProjectRs!=null)
					try {
						getTeamProjectRs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			 if(getAssignProjectSt!=null)
					try {
						getAssignProjectSt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
			 if(getAssignProjectRs!=null)
					try {
						getAssignProjectRs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
			}
		}
		else
		{
			response.sendRedirect("volunteerLogin.jsp?action=LoginAgain");
		}
	return status;

	}

private void addGrievance( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    HttpSession session = request.getSession();
	String adminId = (String)session.getAttribute("adminId");
	if(adminId !=null) {
	String grievance = request.getParameter("grievance");
	Statement meetingTypeSt = null;
	ResultSet meetingTypeRs = null;
	 
	try {
			meetingTypeSt = connection.createStatement();
			String checkQ ="select grievance from grievance_type where grievance ='"+grievance+"'";
			meetingTypeRs = meetingTypeSt.executeQuery(checkQ);
			
			 if (meetingTypeRs.next())	{
				 response.sendRedirect("admin/index.jsp?msg=MeetingTypeExist");
			 }
			 else   {  
				PreparedStatement addCategoryPs =null;
				String query = "insert into grievance_type (grievance) values(?)";
				addCategoryPs  =  connection.prepareStatement(query);
				addCategoryPs.setString(1, grievance); 
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
public   ResultSet getGrievanceType() throws ServletException, IOException { 
	Statement meetingTypeSt =null;
	ResultSet meetingTypeRs = null;
	  
	try {  				
		meetingTypeSt = connection.createStatement();
			String query = "select grievance   from grievance_type";
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
public   ResultSet getVmsCategory() throws ServletException, IOException { 
	Statement meetingTypeSt =null;
	ResultSet meetingTypeRs = null;
	  
	try {  				
		meetingTypeSt = connection.createStatement();
			String query = "select category   from vms_experience_category";
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
public void submitGrievance( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();   
    PreparedStatement assingProjectPs =null;
	HttpSession session = request.getSession();
	String volunteerId = (String)session.getAttribute("volunteerId");
	if(volunteerId !=null) {
		try {  
			String grievanceType = request.getParameter("grievanceType");
			String grievanceDesc = request.getParameter("grievanceDesc");
			 
			Control ct = new Control();
			String to = ct.getEmail(volunteerId);
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
 			Date date = new Date(); 
 			
	       // result = "Sent message successfully....";  
			
			String query = "insert into grievance  (grievance,grievance_type, volunteer_registration_id, submit_date)values(?,?,?,?)" ;
			assingProjectPs = connection.prepareStatement(query);
			assingProjectPs.setString(1, grievanceDesc); 
			assingProjectPs.setString(2, grievanceType); 
			assingProjectPs.setString(3, volunteerId); 
			assingProjectPs.setString(4,  dateFormat.format(date));  
			assingProjectPs.executeUpdate();	
	
		  	String from = "kapil.thakur1496@gmail.com";
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
			      message.setSubject("Regarding Grievance  "); 
			      message.setText("Dear Volunteer\n "
			    		  +"\n\n Thank you for informing for this issue  "+grievanceDesc 
			    		  +"\n Our Team Will look forward to resolve this issue." 
			    		   +"\n\nThank You" 
			    		  +"\nWarm Regards"
			    		  +"\n\nPrismVMS"
			    		   );
			      
			      Transport.send(message);
			     // result = "Sent message successfully....";  
			       
			      response.sendRedirect("grievance.jsp");
			   			  
			  } 
		    catch (MessagingException mex) {
		      mex.printStackTrace();
		      //result = "Error: unable to send message....";
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
		 if(assingProjectPs!=null) {
				try {
					assingProjectPs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}
		} 	 
	}	 
 else{     
	 response.sendRedirect("volunteerLogin.jsp?action=LoginAgain");
 	}  
	out.close();
}
public   ResultSet getGrievance( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
	Statement getTeamsSt =null;
	ResultSet getTeamsRs = null;
	 HttpSession session = request.getSession();
		String volunteerId = (String)session.getAttribute("volunteerId");
		if(volunteerId !=null) {
		
			try {  				
					getTeamsSt = connection.createStatement();
					String query = "select *   from grievance where   volunteer_registration_id='"+volunteerId+"'";
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
		}
	return getTeamsRs;

}
private void addVmsExperienceCategory( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    HttpSession session = request.getSession();
	String adminId = (String)session.getAttribute("adminId");
	if(adminId !=null) {
	String category = request.getParameter("category");
	Statement meetingTypeSt = null;
	ResultSet meetingTypeRs = null;
	 
	try {
			meetingTypeSt = connection.createStatement();
			String checkQ ="select category from vms_experience_category where category ='"+category+"'";
			meetingTypeRs = meetingTypeSt.executeQuery(checkQ);
			
			 if (meetingTypeRs.next())	{
				 response.sendRedirect("admin/index.jsp?msg=VmsExperienceCategory");
			 }
			 else   {  
				PreparedStatement addCategoryPs =null;
				String query = "insert into vms_experience_category (category) values(?)";
				addCategoryPs  =  connection.prepareStatement(query);
				addCategoryPs.setString(1, category); 
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
		response.sendRedirect("volunteerIndex.jsp?action=LoginAgain");
	}
	 out.close(); 
	 
}
public void submitVmsExperience( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();   
    PreparedStatement assingProjectPs =null;
	HttpSession session = request.getSession();
	String volunteerId = (String)session.getAttribute("volunteerId");
	if(volunteerId !=null) {
		try {  
			String category = request.getParameter("category");
			String experienceDesc = request.getParameter("experienceDesc");
			 
			Control ct = new Control();
			String to = ct.getEmail(volunteerId);
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
 			Date date = new Date(); 
 			 String status = "Unseen";
	       // result = "Sent message successfully....";  
			
			String query = "insert into vms_experience  (category,description,request_status, volunteer_registration_id, submit_date)values(?,?,?,?,?)" ;
			assingProjectPs = connection.prepareStatement(query);
			assingProjectPs.setString(1, category); 
			assingProjectPs.setString(2, experienceDesc); 
			assingProjectPs.setString(3, status); 
			assingProjectPs.setString(4, volunteerId); 
			assingProjectPs.setString(5, dateFormat.format(date));  
			assingProjectPs.executeUpdate();	
	
		  	String from = "kapil.thakur1496@gmail.com";
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
			      message.setSubject("Regarding VMS Experience  "); 
			      message.setText("Dear Volunteer\n "
			    		  +"\n\n Thank you for your feedback We look forward to work on your ideas  "+experienceDesc 
			    		  +"\n We will stay in touch with you regarding the same" 
			    		   +"\n\nThank You" 
			    		  +"\nWarm Regards"
			    		  +"\n\nPrismVMS"
			    		   );
			      
			      Transport.send(message);
			     // result = "Sent message successfully....";  
			       
			      response.sendRedirect("vmsExperience.jsp");
			   			  
			  } 
		    catch (MessagingException mex) {
		      mex.printStackTrace();
		      //result = "Error: unable to send message....";
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
		 if(assingProjectPs!=null) {
				try {
					assingProjectPs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}
		} 	 
	}	 
 else{     
	 response.sendRedirect("volunteerLogin.jsp?action=LoginAgain");
 	}  
	out.close();
}
public   ResultSet getVmsExperience(HttpServletRequest request, HttpServletResponse response,int pageNumber, int nextRecordCount) throws ServletException, IOException { 
	Statement getTeamProjectSt = null; 
	ResultSet getTeamProjectRs = null;
 
	 HttpSession session = request.getSession();
		String volunteerId = (String)session.getAttribute("volunteerId");
		if(volunteerId !=null) {
		try {  				
				getTeamProjectSt = connection.createStatement();
				String query = "select *  from vms_experience where volunteer_registration_id = '"+volunteerId+"' limit "+(pageNumber*10)+","+nextRecordCount;
				getTeamProjectRs = getTeamProjectSt.executeQuery(query);
				  
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
			
			 /* if(getTeamProjectSt!=null)
				try {
					getTeamProjectSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			 if(getTeamProjectRs!=null)
					try {
						getTeamProjectRs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} */
			}
		}
		else
		{
			response.sendRedirect("volunteerIndex.jsp?action=LoginAgain");
		}
	return getTeamProjectRs;

	}
public   ResultSet getVmsExperienceComment(HttpServletRequest request, HttpServletResponse response,String id) throws ServletException, IOException { 
	Statement getTeamProjectSt = null; 
	ResultSet getTeamProjectRs = null;
 
	 HttpSession session = request.getSession();
		String volunteerId = (String)session.getAttribute("volunteerId");
		if(volunteerId !=null) {
		try {  				
				getTeamProjectSt = connection.createStatement();
				String query = "select *  from vms_experience_comment where vms_experince_id = '"+id+"' ";
				getTeamProjectRs = getTeamProjectSt.executeQuery(query);
				  
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
			
			 /* if(getTeamProjectSt!=null)
				try {
					getTeamProjectSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			 if(getTeamProjectRs!=null)
					try {
						getTeamProjectRs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} */
			}
		}
		else
		{
			response.sendRedirect("volunteerIndex.jsp?action=LoginAgain");
		}
	return getTeamProjectRs;

	}
public   ResultSet getVolunteerVmsExperienceComment(HttpServletRequest request, HttpServletResponse response,String id) throws ServletException, IOException { 
	Statement getTeamProjectSt = null; 
	ResultSet getTeamProjectRs = null;
 
	 HttpSession session = request.getSession();
		String adminId = (String)session.getAttribute("adminId");
		if(adminId !=null) {
		try {  				
				getTeamProjectSt = connection.createStatement();
				String query = "select *  from vms_experience_comment where vms_experince_id = '"+id+"' ";
				getTeamProjectRs = getTeamProjectSt.executeQuery(query);
				  
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
			
			 /* if(getTeamProjectSt!=null)
				try {
					getTeamProjectSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			 if(getTeamProjectRs!=null)
					try {
						getTeamProjectRs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} */
			}
		}
		else
		{
			response.sendRedirect("mentorIndex.jsp?action=LoginAgain");
		}
	return getTeamProjectRs;

	}
public void addVmsExperienceComment( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();   
    PreparedStatement assingProjectPs =null;
	HttpSession session = request.getSession();
	String volunteerId = (String)session.getAttribute("volunteerId");
	if(volunteerId !=null) {
		try {  
			String comment = request.getParameter("comment"); 
			String id = request.getParameter("id"); 
			String pN = request.getParameter("pN"); 
			 
			Control ct = new Control();
			String to = ct.getEmail(volunteerId);
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
 			Date date = new Date();  
	       // result = "Sent message successfully....";  
			
			String query = " insert into vms_experience_comment (comment,volunteer_registration_id,vms_experince_id,comment_time)  values(?,?,?,?)" ;
			assingProjectPs = connection.prepareStatement(query);
			assingProjectPs.setString(1, comment); 
			assingProjectPs.setString(2, volunteerId); 
			assingProjectPs.setString(3, id);  
			assingProjectPs.setString(4, dateFormat.format(date));  
			assingProjectPs.executeUpdate();	
	
		  	String from = "kapil.thakur1496@gmail.com";
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
			      message.setSubject("Regarding VMS Experience  "); 
			      message.setText("Dear Volunteer\n "
			    		  +"\n\n Admin has Send you new Comment on your VMS Experience feedback  "
			    		  +"\n We will keep you inform about your VMS Experience" 
			    		   +"\n\nThank You" 
			    		  +"\nWarm Regards"
			    		  +"\n\nPrismVMS"
			    		   );
			      
			      Transport.send(message);
			     // result = "Sent message successfully....";  
			       
			      response.sendRedirect("viewVmsExperience.jsp?pN="+pN);
			   			  
			  } 
		    catch (MessagingException mex) {
		      mex.printStackTrace();
		      //result = "Error: unable to send message....";
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
		 if(assingProjectPs!=null) {
				try {
					assingProjectPs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}
		} 	 
	}	 
 else{     
	 response.sendRedirect("volunteerLogin.jsp?action=LoginAgain");
 	}  
	out.close();
}
 

public   ResultSet getVolunteerWorkDiary( HttpServletRequest request, HttpServletResponse response,String id) throws ServletException, IOException { 
	Statement getTeamsSt =null;
	ResultSet getTeamsRs = null;
	 HttpSession session = request.getSession();
		String adminId = (String)session.getAttribute("adminId");
		if(adminId !=null) {
		 
			try {  				
					getTeamsSt = connection.createStatement();
					String query = "select *   from workdiary where  volunteer_registration_id='"+id+"'";
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
		}
	return getTeamsRs;

}
public void addWorkDiaryComment( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();   
    PreparedStatement assingProjectPs =null;
    ResultSet Rs=null;
	HttpSession session = request.getSession();
	String adminId = (String)session.getAttribute("adminId");
	if(adminId !=null) {
		try {  
			String comment = request.getParameter("comment"); 
			String id = request.getParameter("wId"); 
			String to=null,project=null,volunteerId=null;
			Control ct = new Control();
			  Rs = ct.getWorkDiaryVolunteerDetails(id);
			  if(Rs.next())
			  {
				  to= ct.getEmail(Rs.getString("volunteer_registration_id"));
				  project = ct.getProjectName(Rs.getString("project_id"));
				  volunteerId = Rs.getString("volunteer_registration_id");
			  }
			 
			 
	       // result = "Sent message successfully....";  
			
			String query = " update workdiary set comment = ? where id='"+id+"' ";
			assingProjectPs = connection.prepareStatement(query);
			assingProjectPs.setString(1, comment);   
			assingProjectPs.executeUpdate();	
	
		  	String from = "kapil.thakur1496@gmail.com";
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
			      message.setSubject("Regarding Your Work Diary  "); 
			      message.setText("Dear Volunteer\n "
			    		  +"\n\n Your Mentor  has Commented on your Work Diary for the  project "+project 
			    		  +"\n    " 
			    		   +"\n\nThank You" 
			    		  +"\nWarm Regards"
			    		  +"\n\nPrismVMS"
			    		   );
			      
			      Transport.send(message);
			     // result = "Sent message successfully....";  
			       
			      response.sendRedirect("mentorVolunteerWorkDiaryView.jsp?vId="+volunteerId);
			   			  
			  } 
		    catch (MessagingException mex) {
		      mex.printStackTrace();
		      //result = "Error: unable to send message....";
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
		 if(assingProjectPs!=null) {
				try {
					assingProjectPs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}
		 if(Rs!=null) {
				try {
					Rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}
		} 	 
	}	 
 else{     
	 response.sendRedirect("adminLogin.jsp?action=LoginAgain");
 	}  
	out.close();
}

public   ResultSet getWorkDiaryVolunteerDetails(String id) throws ServletException, IOException { 
	Statement getTeamsSt =null;
	ResultSet getTeamsRs = null;
	  
	try {  				
		getTeamsSt = connection.createStatement();
			String query = "select project_id, volunteer_registration_id   from workdiary where id='"+id+"' ";
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

public void addWorkMeetingComment( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();   
    PreparedStatement assingProjectPs =null;
    ResultSet Rs=null;
	HttpSession session = request.getSession();
	String adminId = (String)session.getAttribute("adminId");
	if(adminId !=null) {
		try {  
			String comment = request.getParameter("comment"); 
			String id = request.getParameter("wId"); 
			String to=null,project=null,volunteerId=null;
			Control ct = new Control();
			String meetingType =request.getParameter("meetingType"); 
			  Rs = ct.getWorkMeetingVolunteerDetails(id);
			  if(Rs.next())
			  {
				  to= ct.getEmail(Rs.getString("volunteer_registration_id")); 
				  volunteerId = Rs.getString("volunteer_registration_id");
			  }
			 
			 
	       // result = "Sent message successfully....";  
			
			String query = " update work_meeting set comment = ? where id='"+id+"' ";
			assingProjectPs = connection.prepareStatement(query);
			assingProjectPs.setString(1, comment);   
			assingProjectPs.executeUpdate();	
	
		  	String from = "kapil.thakur1496@gmail.com";
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
			      message.setSubject("Regarding Your Work Meeting  "); 
			      message.setText("Dear Volunteer\n "
			    		  +"\n\n Your Mentor  has commented on your Work Meeting for the  Meeting Type "+meetingType 
			    		  +"\n    " 
			    		   +"\n\nThank You" 
			    		  +"\nWarm Regards"
			    		  +"\n\nPrismVMS"
			    		   );
			      
			      Transport.send(message);
			     // result = "Sent message successfully....";  
			       
			      response.sendRedirect("mentorVolunteerMeetingView.jsp?vId="+volunteerId);
			   			  
			  } 
		    catch (MessagingException mex) {
		      mex.printStackTrace();
		      //result = "Error: unable to send message....";
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
		 if(assingProjectPs!=null) {
				try {
					assingProjectPs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}
		 if(assingProjectPs!=null) {
				try {
					Rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}
		} 	 
	}	 
 else{     
	 response.sendRedirect("adminLogin.jsp?action=LoginAgain");
 	}  
	out.close();
}

public   ResultSet getWorkMeetingVolunteerDetails(String id) throws ServletException, IOException { 
	Statement getTeamsSt =null;
	ResultSet getTeamsRs = null;
	  
	try {  				
		getTeamsSt = connection.createStatement();
			String query = "select  volunteer_registration_id   from work_meeting where id='"+id+"' ";
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
public void addWorkTrainingComment( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();   
    PreparedStatement assingProjectPs =null;
    ResultSet Rs=null;
	HttpSession session = request.getSession();
	String adminId = (String)session.getAttribute("adminId");
	if(adminId !=null) {
		try {  
			String comment = request.getParameter("comment"); 
			String id = request.getParameter("wId"); 
			String to=null,  volunteerId=null;
			Control ct = new Control();
			String trainingType =request.getParameter("trainingType"); 
			  Rs = ct.getWorkTrainingVolunteerDetails(id);
			  if(Rs.next())
			  {
				  to= ct.getEmail(Rs.getString("volunteer_registration_id")); 
				  volunteerId = Rs.getString("volunteer_registration_id");
			  }
			 
			 
	       // result = "Sent message successfully....";  
			
			String query = " update work_training set comment = ? where id='"+id+"' ";
			assingProjectPs = connection.prepareStatement(query);
			assingProjectPs.setString(1, comment);   
			assingProjectPs.executeUpdate();	
	
		  	String from = "kapil.thakur1496@gmail.com";
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
			      message.setSubject("Regarding Your Training  "); 
			      message.setText("Dear Volunteer\n "
			    		  +"\n\n Your Mentor  has commented on your Training for  "+trainingType 
			    		  +"\n    " 
			    		   +"\n\nThank You" 
			    		  +"\nWarm Regards"
			    		  +"\n\nPrismVMS"
			    		   );
			      
			      Transport.send(message);
			     // result = "Sent message successfully....";  
			       
			      response.sendRedirect("mentorVolunteerTrainingView.jsp?vId="+volunteerId);
			   			  
			  } 
		    catch (MessagingException mex) {
		      mex.printStackTrace();
		      //result = "Error: unable to send message....";
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
		 if(assingProjectPs!=null) {
				try {
					assingProjectPs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}
		 if(assingProjectPs!=null) {
				try {
					Rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}
		} 	 
	}	 
 else{     
	 response.sendRedirect("adminLogin.jsp?action=LoginAgain");
 	}  
	out.close();
}

public   ResultSet getWorkTrainingVolunteerDetails(String id) throws ServletException, IOException { 
	Statement getTeamsSt =null;
	ResultSet getTeamsRs = null;
	  
	try {  				
		getTeamsSt = connection.createStatement();
			String query = "select  volunteer_registration_id   from work_training where id='"+id+"' ";
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
public   int getTeamProjectEnrollRequestCount(String id) throws ServletException, IOException { 
	Statement volunteerCountSt =null;
	ResultSet volunteerCountRs = null; 
	int totalCount = 0; 
	
	try {  				
			volunteerCountSt = connection.createStatement();
			String query ="SELECT count(team_project_enrollment.id)  FROM team_project_enrollment INNER JOIN team_project ON team_project.id = team_project_enrollment.team_project_id  and team_project.admin_id='"+id+"'";
			volunteerCountRs = volunteerCountSt.executeQuery(query);
		
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
public   ResultSet getTeamProjectEnrollment(HttpServletRequest request, HttpServletResponse response,int pageNumber, int nextRecordCount) throws ServletException, IOException { 
	Statement getTeamProjectSt = null; 
	ResultSet getTeamProjectRs = null;
 
	 HttpSession session = request.getSession();
		String adminId = (String)session.getAttribute("adminId");
		if(adminId !=null) {
		try {  				
				getTeamProjectSt = connection.createStatement();
				String query = "select * from team_project_enrollment te,  team_project t, volunteer_registration v  where t.id= te.team_project_id and te.enroll_status ='Not Approved'  and t.admin_id ='"+adminId+"' limit "+(pageNumber*10)+","+nextRecordCount;
				getTeamProjectRs = getTeamProjectSt.executeQuery(query);
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
			
			 /* if(getTeamProjectSt!=null)
				try {
					getTeamProjectSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			 if(getTeamProjectRs!=null)
					try {
						getTeamProjectRs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} */
			}
		}
		else
		{
			response.sendRedirect("MentorIndex.jsp?action=LoginAgain");
		}
	return getTeamProjectRs;

	}
public   ResultSet getBranchProjectEnrollment(HttpServletRequest request, HttpServletResponse response,int pageNumber, int nextRecordCount) throws ServletException, IOException { 
	Statement getTeamProjectSt = null; 
	ResultSet getTeamProjectRs = null;
 
	 HttpSession session = request.getSession();
		String adminId = (String)session.getAttribute("adminId");
		if(adminId !=null) {
		try {  				
				getTeamProjectSt = connection.createStatement();
				String query = "select * from branch_project_enrollment be,  branch_project b, volunteer_registration v  where b.id= be.branch_project_id and be.enroll_status ='Not Approved'  and b.admin_id ='"+adminId+"' limit "+(pageNumber*10)+","+nextRecordCount;
				getTeamProjectRs = getTeamProjectSt.executeQuery(query);
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
			
			 /* if(getTeamProjectSt!=null)
				try {
					getTeamProjectSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			 if(getTeamProjectRs!=null)
					try {
						getTeamProjectRs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} */
			}
		}
		else
		{
			response.sendRedirect("MentorIndex.jsp?action=LoginAgain");
		}
	return getTeamProjectRs;

	}
public   int getBranchProjectEnrollRequestCount(String id) throws ServletException, IOException { 
	Statement volunteerCountSt =null;
	ResultSet volunteerCountRs = null; 
	int totalCount = 0; 
	
	try {  				
			volunteerCountSt = connection.createStatement();
			String query ="SELECT count(branch_project_enrollment.id)  FROM branch_project_enrollment INNER JOIN branch_project ON branch_project.id = branch_project_enrollment.branch_project_id  and branch_project.admin_id='"+id+"'";
			volunteerCountRs = volunteerCountSt.executeQuery(query);
		
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
public void branchProjectApproval ( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();   
    PreparedStatement assingProjectPs =null;
	HttpSession session = request.getSession();
	String adminId = (String)session.getAttribute("adminId");
	if(adminId !=null) {
		try {  
			Control ct = new Control();
			String projectId = request.getParameter("projectId");
			ResultSet teamProjectRs = ct.getBranchProject(projectId);
			String projectTitle=null,projectStartDate=null,projectEndDate=null,projectDesc=null;
			while(teamProjectRs.next())
			{
			  projectTitle = teamProjectRs.getString("bproject_title") ;
			  projectStartDate = teamProjectRs.getString("bpro_start_date") ;
			  projectEndDate = teamProjectRs.getString("bpro_end_date") ;
			  projectDesc = teamProjectRs.getString("bproject_desc") ;
			}
			String enrollId = request.getParameter("enrollId");
			PreparedStatement ps = null;
		 
			
			String query1 = "update branch_project_enrollment set enroll_status = ? where id ="+enrollId ;
			String status = "Approved";
			ps = connection.prepareStatement(query1);
			ps.setString(1, status ); 
			ps.executeUpdate();
			ps.close();
			
			String vId[] = request.getParameterValues("vIds");
			for(int i=0; i<vId.length;i++) {
			 
			String to = ct.getEmail(vId[i]);
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
 			Date date = new Date(); 
 			
	       // result = "Sent message successfully....";   
			
			String query = "insert into assign_projects  (volunteer_registration_id,project_title, project_desc, project_start_date,project_end_date,bproject_id,admin_id,assign_date) values(?,?,?,?,?,?,?,?)" ;
			assingProjectPs = connection.prepareStatement(query);
			assingProjectPs.setString(1, vId[i]); 
			assingProjectPs.setString(2, projectTitle); 
			assingProjectPs.setString(3, projectDesc); 
			assingProjectPs.setString(4, projectStartDate); 
			assingProjectPs.setString(5, projectEndDate); 
			assingProjectPs.setString(6, projectId); 
			assingProjectPs.setString(7, adminId);  
			assingProjectPs.setString(8, dateFormat.format(date));  
			assingProjectPs.executeUpdate();	
	
		  	String from = "kapil.thakur1496@gmail.com";
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
			      message.setSubject("Branch Project Enroll Request "); 
			      message.setText("Dear Volunteer\n "
			    		  +"\n\n Your request for the Branch Project is Approved and Project  "+projectTitle+"Also Assigned to you" 
			    		   +"\n\nThank You" 
			    		  +"\nWarm Regards"
			    		  +"\n\nPrismVMS"
			    		   );
			      
			      Transport.send(message);
			     // result = "Sent message successfully....";   
			      
			   			  
			  } 
		    catch (MessagingException mex) {
		      mex.printStackTrace();
		      //result = "Error: unable to send message....";
		   } 
			}
			response.sendRedirect("branchProjectEnrollRequestView.jsp?pN=1");
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
		 if(assingProjectPs!=null) {
				try {
					assingProjectPs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}
		} 	 
	}	 
 else{     
	 response.sendRedirect("adminLogin.jsp?action=LoginAgain");
 	}  
	out.close();
}
public void teamProjectApproval( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();   
    PreparedStatement assingProjectPs =null;
	HttpSession session = request.getSession();
	String adminId = (String)session.getAttribute("adminId");
	if(adminId !=null) {
		try {  
			Control ct = new Control();
			String projectId = request.getParameter("projectId");
			ResultSet teamProjectRs = ct.getTeamProject(projectId);
			String projectTitle=null,projectStartDate=null,projectEndDate=null,projectDesc=null;
			while(teamProjectRs.next())
			{
			  projectTitle = teamProjectRs.getString("tproject_title") ;
			  projectStartDate = teamProjectRs.getString("tpro_start_date") ;
			  projectEndDate = teamProjectRs.getString("tpro_end_date") ;
			  projectDesc = teamProjectRs.getString("tproject_desc") ;
			}
			String enrollId = request.getParameter("enrollId");
			PreparedStatement ps = null;
		  
			String query1 = "update team_project_enrollment set enroll_status = ? where id ="+enrollId ;
			String status = "Approved";
			ps = connection.prepareStatement(query1);
			ps.setString(1, status ); 
			ps.executeUpdate();
			ps.close();
		 
			String vId[] = request.getParameterValues("vIds");
			for(int i=0; i<vId.length;i++) {
			
			 
			String to = ct.getEmail(vId[i]);
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
 			Date date = new Date(); 
 			
	       // result = "Sent message successfully....";  
			
			String query = "insert into assign_projects  (volunteer_registration_id,project_title, project_desc, project_start_date,project_end_date,team_project_id,admin_id,assign_date) values(?,?,?,?,?,?,?,?)" ;
			assingProjectPs = connection.prepareStatement(query);
			assingProjectPs.setString(1, vId[i]); 
			assingProjectPs.setString(2, projectTitle); 
			assingProjectPs.setString(3, projectDesc); 
			assingProjectPs.setString(4, projectStartDate); 
			assingProjectPs.setString(5, projectEndDate); 
			assingProjectPs.setString(6, projectId); 
			assingProjectPs.setString(7, adminId);  
			assingProjectPs.setString(8, dateFormat.format(date));  
			assingProjectPs.executeUpdate();	
	
		  	String from = "kapil.thakur1496@gmail.com";
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
			      message.setSubject("Team Project Enroll Request"); 
			      message.setText("Dear Volunteer\n "
			    		  +"\n\n Your Team Project Enroll Request has been Approved and project "+projectTitle+" is also assigned to you." 
			    		   +"\n\nThank You" 
			    		  +"\nWarm Regards"
			    		  +"\n\nPrismVMS"
			    		   );
			      
			      Transport.send(message);
			     // result = "Sent message successfully....";   
			      
			   			  
			  } 
		    catch (MessagingException mex) {
		      mex.printStackTrace();
		      //result = "Error: unable to send message....";
		   } 
			}
			response.sendRedirect("teamProjectEnrollRequestView.jsp?pN=1");
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
		 if(assingProjectPs!=null) {
				try {
					assingProjectPs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}
		} 	 
	}	 
 else{     
	 response.sendRedirect("adminLogin.jsp?action=LoginAgain");
 	}  
	out.close();
}
public void mentorVmsExperience( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();   
    PreparedStatement assingProjectPs =null;
	HttpSession session = request.getSession();
	String adminId = (String)session.getAttribute("adminId");
	if(adminId !=null) {
		try {  
			String category = request.getParameter("category");
			String experienceDesc = request.getParameter("experienceDesc");
			 
			Control ct = new Control();
			String to = ct.getMentorEmail(adminId);
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
 			Date date = new Date(); 
 			 String status = "Unseen";
	       // result = "Sent message successfully....";  
			
			String query = "insert into vms_experience  (category,description,request_status, admin_id, submit_date)values(?,?,?,?,?)" ;
			assingProjectPs = connection.prepareStatement(query);
			assingProjectPs.setString(1, category); 
			assingProjectPs.setString(2, experienceDesc); 
			assingProjectPs.setString(3, status); 
			assingProjectPs.setString(4, adminId); 
			assingProjectPs.setString(5, dateFormat.format(date));  
			assingProjectPs.executeUpdate();	
	
		  	String from = "kapil.thakur1496@gmail.com";
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
			      message.setSubject("Regarding VMS Experience  "); 
			      message.setText("Dear Volunteer\n "
			    		  +"\n\n Thank you for your feedback We look forward to work on your ideas  "+experienceDesc 
			    		  +"\n We will stay in touch with you regarding the same" 
			    		   +"\n\nThank You" 
			    		  +"\nWarm Regards"
			    		  +"\n\nPrismVMS"
			    		   );
			      
			      Transport.send(message);
			     // result = "Sent message successfully....";  
			       
			      response.sendRedirect("mentorVmsExperience.jsp");
			   			  
			  } 
		    catch (MessagingException mex) {
		      mex.printStackTrace();
		      //result = "Error: unable to send message....";
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
		 if(assingProjectPs!=null) {
				try {
					assingProjectPs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}
		} 	 
	}	 
 else{     
	 response.sendRedirect("adminLogin.jsp?action=LoginAgain");
 	}  
	out.close();
}



public   int volunteerVmsExperienceCount(String id) throws ServletException, IOException { 
	Statement volunteerCountSt =null;
	ResultSet volunteerCountRs = null;
	int totalCount = 0; 
	
	try {  				
			volunteerCountSt = connection.createStatement();
			 
			volunteerCountRs = volunteerCountSt.executeQuery("select count(id) from vms_experience where volunteer_registration_id='"+id+"' ");
		
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

public   int mentorVmsExperienceCount(String id) throws ServletException, IOException { 
	Statement volunteerCountSt =null;
	ResultSet volunteerCountRs = null;
	int totalCount = 0; 
	
	try {  				
			volunteerCountSt = connection.createStatement();
			 
			volunteerCountRs = volunteerCountSt.executeQuery("select count(id) from vms_experience where admin_id='"+id+"' ");
		
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

public   ResultSet getMentorVmsExperience(HttpServletRequest request, HttpServletResponse response,int pageNumber, int nextRecordCount) throws ServletException, IOException { 
	Statement getTeamProjectSt = null; 
	ResultSet getTeamProjectRs = null;
 
	 HttpSession session = request.getSession();
		String adminId = (String)session.getAttribute("adminId");
		if(adminId !=null) {
		try {  				
				getTeamProjectSt = connection.createStatement();
				String query = "select *  from vms_experience where admin_id = '"+adminId+"' limit "+(pageNumber*10)+","+nextRecordCount;
				getTeamProjectRs = getTeamProjectSt.executeQuery(query);
				  
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
			
			 /* if(getTeamProjectSt!=null)
				try {
					getTeamProjectSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			 if(getTeamProjectRs!=null)
					try {
						getTeamProjectRs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} */
			}
		}
		else
		{
			response.sendRedirect("mentorIndex.jsp?action=LoginAgain");
		}
	return getTeamProjectRs;

	}
 
public void addMentorVmsExperienceComment( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();   
    PreparedStatement assingProjectPs =null;
	HttpSession session = request.getSession();
	String adminId = (String)session.getAttribute("adminId");
	if(adminId !=null) {
		try {  
			String comment = request.getParameter("comment"); 
			String id = request.getParameter("id"); 
			 
			Control ct = new Control();
			String to = ct.getEmail(adminId);
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
 			Date date = new Date();  
	       // result = "Sent message successfully....";  
			
			String query = " insert into vms_experience_comment (comment,admin_id,vms_experince_id,comment_time)  values(?,?,?,?)" ;
			assingProjectPs = connection.prepareStatement(query);
			assingProjectPs.setString(1, comment); 
			assingProjectPs.setString(2, adminId); 
			assingProjectPs.setString(3, id);  
			assingProjectPs.setString(4, dateFormat.format(date));  
			assingProjectPs.executeUpdate();	
	
		  	String from = "kapil.thakur1496@gmail.com";
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
			      message.setSubject("Regarding VMS Experience  "); 
			      message.setText("Dear Volunteer\n "
			    		  +"\n\n Admin has Send you new Comment on your VMS Experience feedback  "
			    		  +"\n We will keep you inform about your VMS Experience" 
			    		   +"\n\nThank You" 
			    		  +"\nWarm Regards"
			    		  +"\n\nPrismVMS"
			    		   );
			      
			      Transport.send(message);
			     // result = "Sent message successfully....";  
			       
			      response.sendRedirect("mentorVmsExperienceView.jsp?pN=1");
			   			  
			  } 
		    catch (MessagingException mex) {
		      mex.printStackTrace();
		      //result = "Error: unable to send message....";
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
		 if(assingProjectPs!=null) {
				try {
					assingProjectPs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}
		} 	 
	}	 
 else{     
	 response.sendRedirect("adminLLogin.jsp?action=LoginAgain");
 	}  
	out.close();
}
public void gradeMonthlyReport( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();   
    PreparedStatement assingProjectPs =null;
	HttpSession session = request.getSession();
	String adminId = (String)session.getAttribute("adminId");
	if(adminId !=null) {
		try {  
			Control ct = new Control();
			 
			PreparedStatement ps = null;
		  Statement st=null;
			String id=request.getParameter("monthrpt_id");
			String s1=request.getParameter("creativity");
			String s2=request.getParameter("punctuality");
			String s3=request.getParameter("work_ethic");
			String s4=request.getParameter("qual_of_work");
			String s5=request.getParameter("reliability");
			String s6=request.getParameter("decision_making");
			String s7= request.getParameter("promtness");
			String s8= request.getParameter("involvement");
			String s9= request.getParameter("up_of_skill");
			String s10= request.getParameter("overall_growth");
			String s11= request.getParameter("comment");
			String s12 = request.getParameter("total");
			String status ="Graded";
			  st= connection.createStatement(); 
			 
			 int n =st.executeUpdate("update month_workdairy set report_status='"+status+"', creativity ='"+s1+"',Punctuality='"+s2+"',work_ethics='"+s3+"',quality_work='"+s4+"',reliability='"+s5+"',decision_making='"+s6+"',promptness='"+s7+"',involvement='"+s8+"',upgradation_of_skills='"+s9+"',overall_growth='"+s10+"', comment='"+s11+"',total='"+s12+"' where month_work_id='"+id+"'"); 
			 
		 
			String vId[] = request.getParameterValues("vIds");
			for(int i=0; i<vId.length;i++) {
			
			 
			String to = ct.getEmail(vId[i]);
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
 			Date date = new Date(); 
 			
	       // result = "Sent message successfully....";  
			
			 	
	
		  	String from = "kapil.thakur1496@gmail.com";
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
			      message.setSubject("Monthly Report Grading"); 
			      message.setText("Dear Volunteer\n "
			    		  +"\n\n  Your monthly report  has been graded. Please login to check your grades." 
			    		   +"\n\nThank You" 
			    		  +"\nWarm Regards"
			    		  +"\n\nPrismVMS"
			    		   );
			      
			      Transport.send(message);
			     // result = "Sent message successfully....";   
			      
			   			  
			  } 
		    catch (MessagingException mex) {
		      mex.printStackTrace();
		      //result = "Error: unable to send message....";
		   } 
			}
			response.sendRedirect("viewVolunteerMonyhlyReport.jsp?vId=1");
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
		 if(assingProjectPs!=null) {
				try {
					assingProjectPs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}
		} 	 
	}	 
 else{     
	 response.sendRedirect("adminLogin.jsp?action=LoginAgain");
 	}  
	out.close();
}
public void mentorForgotPassword( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();   
    String email=request.getParameter("email");  
	Statement checkMentorSt = null;
	ResultSet checkMentorRs = null; 
	PreparedStatement updatePassDatePs =null;
try {  
	checkMentorSt = connection.createStatement();
	String mentorId=null;
 	String checkQ = "select id as mentorId from admin  where email ='"+email+"' and approve_status= 'Approved'  ";
 	checkMentorRs = checkMentorSt.executeQuery(checkQ);
	
 	if (checkMentorRs.next()) { 
 	 mentorId = checkMentorRs.getString("mentorId");
 	 Random rnd = new Random();
	 int rand = 100000 + rnd.nextInt(90000); 
	 
	 String otp = Integer.toString(rand);
	 
	 
			  
			     // result = "Sent message successfully....";  
			String to = email;
			  	String from = "prismhack@gmail.com";
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
			      message.setSubject("PrismVMS Update Password"); 
			      message.setText("Dear Sir/Ma'am\n "
			    		  +"\n\n Your otp is "+otp
			    		    +"\n\nThank You" 
			    		  +"\nWarm Regards"
			    		  +"\n\nPrismVMS"
			    		   );
			      
			      Transport.send(message);
			     // result = "Sent message successfully....";  
			      
			   DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
 			Date date = new Date(); 
 			 HttpSession session = request.getSession(); 
			 session.setAttribute("otp", otp); 
			String query = "update admin set password_set=? where id = "+mentorId;
			updatePassDatePs  =  connection.prepareStatement(query);
			updatePassDatePs.setString(1,  dateFormat.format(date));  
			updatePassDatePs.executeUpdate(); 
			      
			   response.sendRedirect("mentorForgotPassword.jsp?action=otpVarification&email="+email);
			  
	   						  
			  } 
		    catch (MessagingException mex) {
		      mex.printStackTrace();
		      //result = "Error: unable to send message....";
		   }
   		 
			
 	}
 else{     
	 response.sendRedirect("adminLogin.jsp?action=AccountDoesNotExist");
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
 if(checkMentorSt!=null) {
		try {
			checkMentorSt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		}
 if(checkMentorRs!=null) {
		try {
			checkMentorRs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	 
	 
	if(updatePassDatePs!=null) {
		try {
			updatePassDatePs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	
}
out.close();
}

public   void forgotOtpVerification(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
	Statement volunteerCountSt =null;
	ResultSet volunteerCountRs = null;
	 try {  				
			String otp = request.getParameter("otp");
			String email = request.getParameter("email");
			
			HttpSession session = request.getSession();   
	        String checkOtp = (String)session.getAttribute("otp");
	        if(checkOtp==null) {
	        	response.sendRedirect("mentorForgotPassword?action=OtpExpired");
	        }
	        if(checkOtp.equals(otp)) {
	        
				volunteerCountSt = connection.createStatement();
				volunteerCountRs = volunteerCountSt.executeQuery("select id  from admin where email ='"+email+"' ");
				PreparedStatement updatePassDatePs =null;
				String password = request.getParameter("password");
				String confirmPassword = request.getParameter("confirmPassword");
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	 			Date date = new Date(); 
		 			
				if(password.equals(confirmPassword) ) { 
					if(volunteerCountRs.next()) {
					
						String query = "update admin  set password=?,password_set=? where id = "+volunteerCountRs.getString("id");
						updatePassDatePs  =  connection.prepareStatement(query);
						updatePassDatePs.setString(1, password);  
						updatePassDatePs.setString(2, dateFormat.format(date));  
						
						updatePassDatePs.executeUpdate();	
						response.sendRedirect("adminLogin.jsp?action=useNewPassword");
					
					}
		        }else
		        {
		        	response.sendRedirect("mentorForgotPassword.jsp?action=PasswordAndConfirmPasswordNotMactched");
		        } 
	        }else
	        {
				 response.sendRedirect("mentorForgotPassword.jsp?action=otpIsNotCorrect");
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
		
}
public void volunteerForgotPassword( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();   
    String email=request.getParameter("email");  
	Statement checkMentorSt = null;
	ResultSet checkMentorRs = null; 
	PreparedStatement updatePassDatePs =null;
try {  
	checkMentorSt = connection.createStatement();
	String mentorId=null;
 	String checkQ = "select id as volunteerId from volunteer_registration  where email_id ='"+email+"' and approve_status= 'Approved'  ";
 	checkMentorRs = checkMentorSt.executeQuery(checkQ);
	
 	if (checkMentorRs.next()) { 
 	 mentorId = checkMentorRs.getString("volunteerId");
 	 Random rnd = new Random();
	 int rand = 100000 + rnd.nextInt(90000); 
	 
	 String otp = Integer.toString(rand);
	 
	 
			  
			     // result = "Sent message successfully....";  
			String to = email;
			  	String from = "prismhack@gmail.com";
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
			      message.setSubject("PrismVMS Update Password"); 
			      message.setText("Dear Volunteer\n "
			    		  +"\n\n Your otp is "+otp
			    		    +"\n\nThank You" 
			    		  +"\nWarm Regards"
			    		  +"\n\nPrismVMS"
			    		   );
			      
			      Transport.send(message);
			     // result = "Sent message successfully....";  
			      
			   DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
 			Date date = new Date(); 
 			 HttpSession session = request.getSession(); 
			 session.setAttribute("otp", otp); 
			String query = "update volunteer_registration set pasword_set=? where id = "+mentorId;
			updatePassDatePs  =  connection.prepareStatement(query);
			updatePassDatePs.setString(1,  dateFormat.format(date));  
			updatePassDatePs.executeUpdate(); 
			      
		   response.sendRedirect("volunteerForgotPassword.jsp?action=otpVarification&email="+email);
			   		  
			  } 
		    catch (MessagingException mex) {
		      mex.printStackTrace();
		      //result = "Error: unable to send message....";
		   }
   		 
			
 	}
 else{     
	 response.sendRedirect("volunteerLogin.jsp?action=AccountDoesNotExist");
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
 if(checkMentorSt!=null) {
		try {
			checkMentorSt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		}
 if(checkMentorRs!=null) {
		try {
			checkMentorRs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	 
	 
	if(updatePassDatePs!=null) {
		try {
			updatePassDatePs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	
}
out.close();
}

public   void volunteerForgotOtpVerification(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
	Statement volunteerCountSt =null;
	ResultSet volunteerCountRs = null;
	 try {  				
			String otp = request.getParameter("otp");
			String email = request.getParameter("email");
			
			HttpSession session = request.getSession();   
	        String checkOtp = (String)session.getAttribute("otp");
	        if(checkOtp==null) {
	        	response.sendRedirect("volunteerForgotPassword.jsp?action=OtpExpired");
	        }
	        
	        if(checkOtp.equals(otp)) {
	        
				volunteerCountSt = connection.createStatement();
				volunteerCountRs = volunteerCountSt.executeQuery("select id  from volunteer_registration where email_id ='"+email+"' ");
				PreparedStatement updatePassDatePs =null;
				String password = request.getParameter("password");
				String confirmPassword = request.getParameter("confirmPassword");
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	 			Date date = new Date(); 
		 			
				if(password.equals(confirmPassword) ) { 
					if(volunteerCountRs.next()) {
					
						String query = "update volunteer_registration  set password=?,pasword_set=? where id = "+volunteerCountRs.getString("id");
						updatePassDatePs  =  connection.prepareStatement(query);
						updatePassDatePs.setString(1, password);  
						updatePassDatePs.setString(2, dateFormat.format(date));  
						
						updatePassDatePs.executeUpdate();	
						response.sendRedirect("volunteerLogin.jsp?action=useNewPassword");
					
					}
		        }else
		        {
		        	response.sendRedirect("volunteerForgotPassword.jsp?action=PasswordAndConfirmPasswordNotMactched");
		        } 
	        }else
	        {
				 response.sendRedirect("volunteerForgotPassword.jsp?action=otpIsNotCorrect&email="+email);
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
		
}

public void preVolunteerForgotPassword( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();   
    String email=request.getParameter("email");  
	Statement checkMentorSt = null;
	ResultSet checkMentorRs = null; 
	PreparedStatement updatePassDatePs =null;
try {  
	checkMentorSt = connection.createStatement();
	String mentorId=null;
 	String checkQ = "select id as volunteerId from volunteer_registration  where email_id ='"+email+"'    ";
 	checkMentorRs = checkMentorSt.executeQuery(checkQ);
	
 	if (checkMentorRs.next()) { 
 	 mentorId = checkMentorRs.getString("volunteerId");
 	 Random rnd = new Random();
	 int rand = 100000 + rnd.nextInt(90000); 
	 
	 String otp = Integer.toString(rand);
	 
	 
			  
			     // result = "Sent message successfully....";  
			String to = email;
			  	String from = "prismhack@gmail.com";
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
			      message.setSubject("PrismVMS Update Password"); 
			      message.setText("Dear Applicant\n "
			    		  +"\n\n Your otp is "+otp
			    		    +"\n\nThank You" 
			    		  +"\nWarm Regards"
			    		  +"\n\nPrismVMS"
			    		   );
			      
			      Transport.send(message);
			     // result = "Sent message successfully....";  
			      
			   DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
 			Date date = new Date(); 
 			 HttpSession session = request.getSession(); 
			 session.setAttribute("otp", otp); 
			String query = "update volunteer_registration set pasword_set=? where id = "+mentorId;
			updatePassDatePs  =  connection.prepareStatement(query);
			updatePassDatePs.setString(1,  dateFormat.format(date));  
			updatePassDatePs.executeUpdate(); 
			      
		   response.sendRedirect("volunteerPreForgotPassword.jsp?action=otpVarification&email="+email);
			   		  
			  } 
		    catch (MessagingException mex) {
		      mex.printStackTrace();
		      //result = "Error: unable to send message....";
		   }
   		 
			
 	}
 else{     
	 response.sendRedirect("volunteerPreLogin.jsp?action=AccountDoesNotExist");
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
 if(checkMentorSt!=null) {
		try {
			checkMentorSt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		}
 if(checkMentorRs!=null) {
		try {
			checkMentorRs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	 
	 
	if(updatePassDatePs!=null) {
		try {
			updatePassDatePs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	
}
out.close();
}
public   void preVolunteerForgotOtpVerification(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
	Statement volunteerCountSt =null;
	ResultSet volunteerCountRs = null;
	 try {  				
			String otp = request.getParameter("otp");
			String email = request.getParameter("email");
			
			HttpSession session = request.getSession();   
	        String checkOtp = (String)session.getAttribute("otp");
	        if(checkOtp==null) {
	        	response.sendRedirect("volunteerPreForgotPassword.jsp?action=OtpExpired");
	        }
	        
	        if(checkOtp.equals(otp)) {
	        
				volunteerCountSt = connection.createStatement();
				volunteerCountRs = volunteerCountSt.executeQuery("select id  from volunteer_registration where email_id ='"+email+"' ");
				PreparedStatement updatePassDatePs =null;
				String password = request.getParameter("password");
				String confirmPassword = request.getParameter("confirmPassword");
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	 			Date date = new Date(); 
		 			
				if(password.equals(confirmPassword) ) { 
					if(volunteerCountRs.next()) {
					
						String query = "update volunteer_registration  set password=?,pasword_set=? where id = "+volunteerCountRs.getString("id");
						updatePassDatePs  =  connection.prepareStatement(query);
						updatePassDatePs.setString(1, password);  
						updatePassDatePs.setString(2, dateFormat.format(date));  
						
						updatePassDatePs.executeUpdate();	
						response.sendRedirect("volunteerPreLogin.jsp?action=useNewPassword");
					
					}
		        }else
		        {
		        	response.sendRedirect("volunteerPreForgotPassword.jsp?action=PasswordAndConfirmPasswordNotMactched");
		        } 
	        }else
	        {
				 response.sendRedirect("volunteerPreForgotPassword.jsp?action=otpIsNotCorrect&email="+email);
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
		
}
}
 
 