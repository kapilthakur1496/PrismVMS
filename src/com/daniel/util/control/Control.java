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
import java.util.ArrayList;
import java.awt.List;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

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
		if(action.equals("ngoverification"))
		{   
			NgoVerification(request,response);
		}
		else if(action.equals("subscription"))
		{  
			subscribe(request,response);
		}
		else if(action.equals("ngoapproval"))
		{  
			NgoApproval(request,response);
		}
		else if(action.equals("addCategory"))
		{   
			addCategory(request,response); 
		}
		else if(action.equals("addSubCategory"))
		{   
			addSubCategory(request,response); 
		} 
		else if(action.equals("addProducts"))
		{   
			addProducts(request,response); 
		} 
		else if(action.equals("updateProductDetail"))
		{   
			updateProductDetails(request,response); 
		}
		else if(action.equals("addToCart"))
		{   
			addToCart(request,response); 
		}
		else if(action.equals("orderPlace"))
		{   
			orderPlace(request,response); 
		}
		else if(action.equals("addCountry"))
		{   
			addCountry(request,response); 
		}
		else if(action.equals("addState"))
		{   
			addState(request,response); 
		} 
		else if(action.equals("addCity"))
		{   
			addCity(request,response); 
		} 
		else if(action.equals("addAddress"))
		{   
			addAddress(request,response); 
		}
		else if(action.equals("confirmOrder"))
		{   
			confirmOrder(request,response); 
		}
		else if(action.equals("addDonation"))
		{   
			addDonation(request,response); 
		}
		else if(action.equals("donateAmount"))
		{   
			donateAmount(request,response); 
		} 
		else if(action.equals("applyForVolunteer"))
		{   
			applyForVoluneer(request,response); 
		}
		else if(action.equals("addProductReview"))
		{   
			addProductReview(request,response); 
		}
		else if(action.equals("updateInterst"))
		{   
			updateEventInterst(request,response); 
		}
		else if(action.equals("addFaqDetails"))
		{   
			addFaqDetails(request,response); 
		}
		else if(action.equals("addContactDetails"))
		{   
			addContactDetails(request,response); 
		}
		else if(action.equals("updateDonationDetail"))
		{   
			updateDonationDetail(request,response); 
		}
		else if(action.equals("updateVolunteerDetail"))
		{   
			updateVolunteerDetail(request,response); 
		}
		else if(action.equals("updateEventDetail"))
		{   
			updateEventDetail(request,response); 
		}
		
	}
	public String  NgoStatus(String ngoId)throws ServletException, IOException {
		
		Statement NgoStatusSt =null;
		ResultSet NgoStatusRs = null;
		String status =null; 
	 
		try {
				NgoStatusSt = connection.createStatement();
				NgoStatusRs = NgoStatusSt.executeQuery("select registration_status from ngo_details where id="+ngoId);
			 
						 
				
				if(!NgoStatusRs.next())
				{
				}  
				else 
				{ 
					status= NgoStatusRs.getString(1); 
					 
				}
	 
		}  catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
	 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		finally{
        	/*if(NgoStatusSt!=null)
				try {
					NgoStatusSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
//        	if(NgoStatusRs!=null)
//				try {
//					NgoStatusRs.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} 
        	 
        	}
		return status;

	}
public String  NgoApproveStatus(String ngoId)throws ServletException, IOException {
		
		Statement NgoStatusSt =null;
		ResultSet NgoStatusRs = null;
		String status =null; 
	 
		try {
				NgoStatusSt = connection.createStatement();
				NgoStatusRs = NgoStatusSt.executeQuery("select approve_status from ngo_details where id="+ngoId);
			 
						 
				
				if(!NgoStatusRs.next())
				{
				}  
				else 
				{ 
					status= NgoStatusRs.getString(1); 
					 
				}
	 
		}  catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
	 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		finally{
        	/*if(NgoStatusSt!=null)
				try {
					NgoStatusSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
//        	if(NgoStatusRs!=null)
//				try {
//					NgoStatusRs.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} 
        	 
        	}
		return status;

	}
	/* *public String  NgoEmail(String ngoId)throws ServletException, IOException {
		
		Statement NgoStatusSt =null;
		ResultSet NgoStatusRs = null;
		String email =null; 
	 
		try {
				 
			 NgoStatusSt = connection.createStatement();
			 NgoStatusRs = NgoStatusSt.executeQuery("select email from ngo_details where id="+ngoId);
			  		 
				
			if(!NgoStatusRs.next())
			{
			}  
			else 
			{ 
				email= NgoStatusRs.getString(1); 
			}
	 
		}  catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
	 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		finally{
        	 if(NgoStatusSt!=null)
				try {
					NgoStatusSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			 	} 
         	if(NgoStatusRs!=null)
 				try {
 				NgoStatusRs.close();
 				} catch (SQLException e) {
 				// TODO Auto-generated catch block
 					e.printStackTrace();
 				} 
         	 
        	}
		return email;

	}*/
	public   ResultSet NgoDetail(String ngoId) throws ServletException, IOException { 
		Statement NgoDetailSt =null;
		ResultSet NgoDetailRs = null;
		  
		try {  				
				NgoDetailSt = connection.createStatement();
				NgoDetailRs = NgoDetailSt.executeQuery("select * from ngo_details where id="+ngoId);
				 
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
		return NgoDetailRs;

	}
	public void NgoVerification( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
         
		HttpSession session = request.getSession();
		String ngoId= (String)session.getAttribute("NgoId");
		
		String otp = request.getParameter("otp");
		Statement otpVerifySt = null;
		ResultSet otpVeifyRs = null;
		String otpCheck = null;
		String status = null;
		try {
			 otpVerifySt = connection.createStatement();
			 otpVeifyRs = otpVerifySt.executeQuery("select otp from ngo_verification where ngo_details_id="+ngoId);
		
		 if (otpVeifyRs.next()) {
			 otpCheck = otpVeifyRs.getString("otp");
		}
		 
		 if(otpCheck.equals(otp))
		 {
			status= "Verified";
			PreparedStatement ngoStatusUpdate =null;
			ngoStatusUpdate  =  connection.prepareStatement("update ngo_details set registration_status ='"+status+"' ");
			ngoStatusUpdate.executeUpdate();  
			javax.servlet.RequestDispatcher dispatcher=request.getRequestDispatcher("NgoPreindex.jsp");
			dispatcher.forward(request, response); 
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
			/* if(otpVerifySt!=null)
					try {
						otpVerifySt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}*/
	        	/*if(otpVeifyRs!=null)
					try {
						otpVeifyRs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}*/
		 }
		 out.close();
		 
	}   
	
public void subscribe( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
     	String result;
	    
	   	String from = "kapil.thakur1496@gmail.com";
		 
		String  to = request.getParameter("email");
		PreparedStatement subsribePs = null;
		 
		try {
			subsribePs = connection.prepareStatement("insert into subscribers (email) values (?)");  
			subsribePs.setString(1,  to); 
			subsribePs.executeUpdate();	 
			   
			String theMessage = request.getParameter(" ");

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
			final String username = "kapil.thakur1496@gmail.com";
			final String password = "kapil@thakur#1496";
		       
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
			      
			      message.setSubject("Sarvahitkari Registration Process");
			      
			      message.setText("Dear Sir/Ma'am\n\n"
			    		  +"\n\nThank You for subscribe with us." 
			    		 
			    		  +"\n\nThank You"
			    		  +"\nWarm Regards"
			    		   );
			      
			      Transport.send(message);
			      result = "Sent message successfully....";
			      
			      javax.servlet.RequestDispatcher dispatcher=request.getRequestDispatcher("index.jsp?subscriber=Success");
			      dispatcher.forward(request, response); 
						  
				  } 
			    catch (MessagingException mex) {
			      mex.printStackTrace();
			      result = "Error: unable to send message....";
			   }
		  
			javax.servlet.RequestDispatcher dispatcher=request.getRequestDispatcher("index.jsp?subscriber=Success");
			dispatcher.forward(request, response); 
		  
	}  
		 catch (SQLException e) {
			 if(e.getErrorCode() ==  MYSQL_DUPLICATE_PK  ){
				 javax.servlet.RequestDispatcher dispatcher=request.getRequestDispatcher("index.jsp?subscriberfail=fail");
					dispatcher.forward(request, response); 
				}
			}
		 catch (Exception e) {
				// TODO: handle exception
				 e.printStackTrace();
			}
		 finally {
			/* if(otpVerifySt!=null)
					try {
						otpVerifySt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}*/
	        	/*if(otpVeifyRs!=null)
					try {
						otpVeifyRs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}*/
		 }
		 out.close();
		 
	}  

public   ResultSet NgoDetails(String id)throws ServletException, IOException { 
	  	Statement NgoDetailsSt =null;
	  	ResultSet NgoDetailsRs = null;
	  
	  	try {  				
				NgoDetailsSt = connection.createStatement();
				NgoDetailsRs = NgoDetailsSt.executeQuery("select * from   ngo_details where id ="+id);
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
	return NgoDetailsRs;

}
public   ResultSet NgoDetails( int pageNumber, int nextRecordCount)throws ServletException, IOException { 
  	Statement NgoDetailsSt =null;
  	ResultSet NgoDetailsRs = null;
  
  	try {  				
			NgoDetailsSt = connection.createStatement();
			NgoDetailsRs = NgoDetailsSt.executeQuery("select * from ngo_details limit "+(pageNumber*10)+","+nextRecordCount);
		  
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
return NgoDetailsRs;

}
public   int ngoCount() throws ServletException, IOException { 
		Statement ngoCountSt =null;
		ResultSet ngoCountRs = null;
		int totalCount = 0; 
		try {  				
				ngoCountSt = connection.createStatement();
				ngoCountRs = ngoCountSt.executeQuery("select count(id) from ngo_details ");
			
				if(ngoCountRs.next())
				{
					totalCount = Integer.parseInt(ngoCountRs.getString(1));
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
				
				 if(ngoCountSt!=null)
					try {
						ngoCountSt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
				 if(ngoCountRs!=null)
						try {
							ngoCountRs.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 
			}
	return totalCount; 
}

public void NgoApproval( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter(); 
	
	Statement ngoEmailSt = null;
	ResultSet ngoEmailRs = null;
	PreparedStatement updateStatusPs = null;
	int emailSentCount =0;
	try {
	   	String from = "kapil.thakur1496@gmail.com";
	   	String to = null;
	   	String ngoIds[] = request.getParameterValues("ngoId"); 
	   	String status = request.getParameter("status"); 
	   	
	   	String pageNumber = request.getParameter("pageNumber"); 
	   	System.out.println("length "+ngoIds.length);
		System.out.println("Status "+status);
	   	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date(); 
	   	if(ngoIds != null)
	   	{
	   		
		   	for ( int i=0; i<ngoIds.length;i++ )
			 {  
		   		updateStatusPs = connection.prepareStatement("update  ngo_details set  approve_status = ?, verification_date =? where id ="+ngoIds[i]);  
		   		updateStatusPs.setString(1, status); 
		   		updateStatusPs.setString(2, dateFormat.format(date));  
		   		updateStatusPs.executeUpdate(); 
			 } 
	   	
		   	for(int j=0; j<ngoIds.length;j++)
		   		{  
		   		 ngoEmailSt = connection.createStatement();
		   		 ngoEmailRs = ngoEmailSt.executeQuery("select email from ngo_details where id = '"+ngoIds[j]+ "' and approve_status = '"+status+"'");	   		  
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
			   			final String username = "kapil.thakur1496@gmail.com";
			   			final String password = "kapil@thakur#1496";
		   		       
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
		   			      message.setSubject("Sarvahitkari Registration Process"); 
		   			      message.setText("Dear Sir/Ma'am\n\n"
		   			    		  +"\n\nYour status has been "+status 
		   			    		 
		   			    		  +"\n\nThank You"
		   			    		  +"\nWarm Regards"
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
	   	if(emailSentCount == ngoIds.length) {
	   		response.sendRedirect("admin/manage-users.jsp?pageNumber="+pageNumber);
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
public void addCategory( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();
      
	String categoryName = request.getParameter("category");
	Statement checkCategorySt = null;
	ResultSet checkCategoryRs = null;
	 
	try {
		 	checkCategorySt = connection.createStatement();
			checkCategoryRs = checkCategorySt.executeQuery("select name from category where name ='"+categoryName+"'");
			
				 if (checkCategoryRs.next())	{
					 response.sendRedirect("admin/manageData.jsp?msg=CategoryExist");
				 }
				 else   {  
						PreparedStatement addCategoryPs =null;
						addCategoryPs  =  connection.prepareStatement("insert into category (name) values(?)");
						addCategoryPs.setString(1, categoryName); 
						addCategoryPs.executeUpdate();	
 						response.sendRedirect("admin/manageData.jsp");
  
 				/*	javax.servlet.RequestDispatcher dispatcher=request.getRequestDispatcher("adminIndex.jsp?pageNumber=1#tab2");
						dispatcher.forward(request, response);*/
						/*
						RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("adminIndex.jsp?pageNumber=1#tab2");
						*/
						/*RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("adminIndex.jsp?pageNumber=1#section02");
				*/ } 
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
		/* if(otpVerifySt!=null)
				try {
					otpVerifySt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
        	/*if(otpVeifyRs!=null)
				try {
					otpVeifyRs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
	 }
	 out.close(); 
	 
}
 
public  ResultSet viewproductCategory()throws ServletException, IOException { 
	  		Statement CategorySt =null;
	  		ResultSet CategoryRs = null;
	  
		  	try {  				
		  		CategorySt = connection.createStatement();
					CategoryRs = CategorySt.executeQuery("select * from category  ");
				  
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
		return CategoryRs;

}
public void addSubCategory( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();  
	String subCategoryName = request.getParameter("subCategory");
	String categoryId = request.getParameter("categoryId");
	Statement checkSubCategorySt = null;
	ResultSet checkSubCategoryRs = null;
	 
	try {
		 	checkSubCategorySt = connection.createStatement();
			checkSubCategoryRs = checkSubCategorySt.executeQuery("select name from sub_category where name ='"+subCategoryName+"'");
			
		 		if (checkSubCategoryRs.next())	{
		 			response.sendRedirect("admin/manageData.jsp?msg=SubCategoryExist");
				 }
				 else   { 
					 PreparedStatement addSubCategoryPs =null;
					 try {
						
						addSubCategoryPs  =  connection.prepareStatement("insert into sub_category (name,category_id) values(?,?)");
						addSubCategoryPs.setString(1, subCategoryName); 
						addSubCategoryPs.setString(2, categoryId); 
						addSubCategoryPs.executeUpdate();	
 						 
  
						response.sendRedirect("admin/manageData.jsp");
						/*
						RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("adminIndex.jsp?pageNumber=1#tab2");
						*/
						/*RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("adminIndex.jsp?pageNumber=1#section02");
				*/ }   
				 catch (SQLException e) {
						// TODO: handle exception
					e.printStackTrace();
					}
				 catch (Exception e) {
						// TODO: handle exception
						 e.printStackTrace();
					} finally {
						  if(addSubCategoryPs!=null)  
								try {
									addSubCategoryPs.close();
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
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
			  if(checkSubCategorySt!=null)
					try {
						checkSubCategorySt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
	        	 if(checkSubCategoryRs!=null)
					try {
						checkSubCategoryRs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
		 }
	 out.close();  
}
public  ResultSet viewSubCategory()throws ServletException, IOException { 
		Statement SubCategorySt =null;
		ResultSet SubCategoryRs = null;

  	try {  				
  			SubCategorySt = connection.createStatement();
			SubCategoryRs = SubCategorySt.executeQuery("select * from sub_category  ");
			 
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
return SubCategoryRs;

}
public void addProducts( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();  
	String subCategoryName = request.getParameter("productName");
	String productPrice = request.getParameter("productPrice");
	HttpSession session = request.getSession();
	String ngoId = (String)session.getAttribute("NgoId");
	
	String totalQty = request.getParameter("totalQty");
	String manufacturerCredit = request.getParameter("manufacturerCredit");

	String productDescription = request.getParameter("productDescription");
	String subCategory = request.getParameter("subCategory");
	  
 
	 Statement productIdSt = null;
	 ResultSet productIdRs = null;
	 PreparedStatement addProductPs = null;
	  String productId = null;
		try {
				productIdSt = connection.createStatement();
				String productIdQ = "select max(id)=1 as maxProductId from product_details";
				productIdRs = productIdSt.executeQuery(productIdQ);
				
				if(productIdRs.next()) {
					productId = productIdRs.getString("maxProductId");
				}
				if(productId == null)
				{
					productId =  "1";
				}
				
				 
				
				String addProductQ = "insert into product_details (id,name,description,price,quantity,manufacturere_credit,sub_category_id,ngo_details_id) values(?,?,?,?,?,?,?,?)";
				 
				addProductPs  =  connection.prepareStatement(addProductQ);
				addProductPs.setString(1, productId); 
				addProductPs.setString(2, subCategoryName); 
				addProductPs.setString(3, productDescription); 
				addProductPs.setString(4, productPrice); 
				addProductPs.setString(5, totalQty); 
				addProductPs.setString(6, manufacturerCredit); 
				addProductPs.setString(7, subCategory); 
				addProductPs.setString(8, ngoId);  
				addProductPs.executeUpdate();	
				response.sendRedirect("ngoAddProduct.jsp?pId="+productId+"&picSection=1");
					 
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

public   ResultSet productDetails(int pId) throws ServletException, IOException { 
	Statement productDetailSt =null;
	ResultSet productDetailRs = null;
 
	/*String pId= encrypt.decryption(pId.getBytes());*/
	try  { 				
			productDetailSt = connection.createStatement();
			String query = "select * from product_details where id="+pId;
			productDetailRs = productDetailSt.executeQuery(query);
			 
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
	return productDetailRs;

}

public void updateProductDetails( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();  
	String subCategoryName = request.getParameter("productName");
	String productPrice = request.getParameter("productPrice");
	HttpSession session = request.getSession();
	String ngoId = (String)session.getAttribute("NgoId");
	
	String totalQty = request.getParameter("totalQty");
	String manufacturerCredit = request.getParameter("manufacturerCredit");

	String productDescription = request.getParameter("productDescription");
	String subCategory = request.getParameter("subCategory");
	String pId = request.getParameter("productId");
	
 
	 
		try {
		      
			 PreparedStatement addProductPs = null;
		 
			 addProductPs  =  connection.prepareStatement("update   product_details set  name=?,description=?,price=?,quantity=?,manufacturer_credit=?,sub_category_id=?,ngo_details_id=?   where id = '"+pId+"' " );
			 addProductPs.setString(1, subCategoryName); 
			 addProductPs.setString(2, productDescription); 
			 addProductPs.setString(3, productPrice); 
			 addProductPs.setString(4, totalQty); 
			 addProductPs.setString(5, manufacturerCredit); 
			 addProductPs.setString(6, subCategory); 
			 addProductPs.setString(7, ngoId);  
			 addProductPs.executeUpdate();	
			 response.sendRedirect("ngoAddProductPreview.jsp?pId="+pId);
					 
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


public   ResultSet getProduct() throws ServletException, IOException { 
	Statement getDetailSt =null;
	ResultSet getDetailRs = null;
	  
	try {  				
			getDetailSt = connection.createStatement();
			String query = "select id,name,price,image1  from product_details";
			getDetailRs = getDetailSt.executeQuery(query);
			 
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
	return getDetailRs;

}

public void addToCart( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    encrypt et = new encrypt();
    String  quantity = request.getParameter("quantity");
    String pId = request.getParameter("pId"); 
    
    String value = getServletContext().getInitParameter("EncryptionKey");
	String letter = getServletContext().getInitParameter("EncryptionLetters");
	String length = getServletContext().getInitParameter("EncryptionLength");
  	int decId = et.decryption(request, response,pId,value );
  	
    Double productAmount = Double.parseDouble(request.getParameter("productAmount"));
    double qty= Double.parseDouble(quantity);
    double totalAmount =  qty * productAmount ;   
    HttpSession session = request.getSession();
	String userId =   (String)session.getAttribute("userId");  
	Statement checkCartSt = null;
	
	ResultSet checkCartRs = null;
	PreparedStatement addCartPs = null;
 
	try {
		
		checkCartSt  = connection.createStatement();
		String checkCartQ = "select id from cart where customer_id="+userId+" and product_details_id="+decId;
		checkCartRs = checkCartSt.executeQuery(checkCartQ);
		if(checkCartRs.next()){
			 
			PreparedStatement updateCartPs = null;
			String updatePsQ = "update cart set quantity =? , total_amount =? where id="+checkCartRs.getString("id");
			updateCartPs = connection.prepareStatement(updatePsQ);
			updateCartPs.setString(1, quantity);
			updateCartPs.setDouble(2, totalAmount);
			updateCartPs.executeUpdate();
			response.sendRedirect("productViewCart.jsp?quantity="+quantity+"&pId="+pId);	 
			
		} else { 
			
			String insertCartQ = "insert into cart (quantity,total_amount,product_details_id,customer_id) values (?,?,?,?)"; 
			addCartPs = connection.prepareStatement(insertCartQ);   
			addCartPs.setString(1,  quantity); 
			addCartPs.setDouble(2,  totalAmount);  
			addCartPs.setInt(3, decId); 
			addCartPs.setString(4,  userId); 
			addCartPs.executeUpdate();  
			response.sendRedirect("productViewCart.jsp?quantity="+quantity+"&pId="+pId);	 
			
		}
	}catch (SQLException e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	catch (NumberFormatException e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	 catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	finally {
		if(checkCartRs!=null)
			try {
				checkCartRs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
    	 if(checkCartSt!=null)
			try {
				checkCartSt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	} 
	 out.close(); 
}   

public void orderPlace( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    encrypt et = new encrypt();
    String  quantity = request.getParameter("quantity");
    String pId = request.getParameter("pId"); 
    String value = getServletContext().getInitParameter("EncryptionKey");
   	String letter = getServletContext().getInitParameter("EncryptionLetters");
   	String length = getServletContext().getInitParameter("EncryptionLength");
     	int decId = et.decryption(request, response,pId,value );
    
    Double productAmount = Double.parseDouble(request.getParameter("productAmount"));
    double qty= Double.parseDouble(quantity);
    double totalAmount =  qty * productAmount ;   
    HttpSession session = request.getSession();
	String userID =   (String)session.getAttribute("userId"); 
	
	Statement checkCartSt = null;
	
	ResultSet checkCartRs = null;
	PreparedStatement addCartPs = null;
 
	try {
		if(userID != null) {
			
		 
		checkCartSt  = connection.createStatement();
		String checkCartQ = "select id from cart where customer_id="+userID+" and product_details_id="+decId;
		checkCartRs = checkCartSt.executeQuery(checkCartQ);
		if(checkCartRs.next()){
			 
			PreparedStatement updateCartPs = null;
			String updatePsQ = "update cart set quantity =? , total_amount =? where id="+checkCartRs.getString("id");
			updateCartPs = connection.prepareStatement(updatePsQ);
			updateCartPs.setString(1, quantity);
			updateCartPs.setDouble(2, totalAmount);
			updateCartPs.executeUpdate();
			response.sendRedirect("productPlaceOrder.jsp?pId="+pId+"&quantity="+quantity); 
			 /*
			 	PreparedStatement orderPs = null;
				String orderQ = "insert into order (order_date,delivery_date,address_id,shipper_id,cart_id,customer_id,) values (?,?,?,?,?,?)";
			 */
			 /* orderPs = connection.prepareStatement(orderQ);
			    orderPs.setString(1, order_date);
			    orderPs.setString(2, order_date);
			    orderPs.setString(3, order_date);
			    orderPs.setString(4, order_date);
			    orderPs.setString(5, order_date);
			    orderPs.setString(6, order_date); 
			 */
		     
			}
		} 
		else
		{
			response.sendRedirect("productViewCart.jsp?action=loginAgain");
		}
	}catch (SQLException e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	catch (NumberFormatException e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	 catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	finally {
		if(checkCartRs!=null)
			try {
				checkCartRs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
    	 if(checkCartSt!=null)
			try {
				checkCartSt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	} 
	 out.close(); 
} 

public   ResultSet addressDetail(String userId) throws ServletException, IOException { 
	Statement addressDetailSt =null;
	ResultSet addressDetailRs = null;
	  
	try  { 				
		System.out.println("user = "+userId);
		
			addressDetailSt = connection.createStatement();
			String query = "select * from address where customer_id="+userId;
			addressDetailRs = addressDetailSt.executeQuery(query);
			 
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
	return addressDetailRs;

}
public void addCountry( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();
      
	String countryName = request.getParameter("countryName");
	Statement countrySt = null;
	ResultSet countryRs = null;
	 
	try {
		 countrySt = connection.createStatement();
		 countryRs =  countrySt.executeQuery("select name from country where name ='"+countryName+"'");
			
				 if (countryRs.next())	{
					 response.sendRedirect("admin/manageData.jsp?msg=CountryExist");
				 }
				 else   {  
						PreparedStatement addCategoryPs =null;
						addCategoryPs  =  connection.prepareStatement("insert into country (name) values(?)");
						addCategoryPs.setString(1, countryName); 
						addCategoryPs.executeUpdate();	
 						response.sendRedirect("admin/manageData.jsp");
  
 				/*	javax.servlet.RequestDispatcher dispatcher=request.getRequestDispatcher("adminIndex.jsp?pageNumber=1#tab2");
						dispatcher.forward(request, response);*/
						/*
						RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("adminIndex.jsp?pageNumber=1#tab2");
						*/
						/*RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("adminIndex.jsp?pageNumber=1#section02");
				*/ } 
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
		  if(countrySt!=null)
				try {
					countrySt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
        	 if(countryRs!=null)
				try {
					countryRs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
	 }
	 out.close(); 
	 
}
public  ResultSet viewCountry()throws ServletException, IOException { 
		Statement countrySt =null;
		ResultSet countryRs = null;

  	try {  				
  		countrySt = connection.createStatement();
  		countryRs = countrySt.executeQuery("select * from country  ");
		  
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
return countryRs;

}
public void addState( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();  
	String stateName = request.getParameter("stateName");
	String countryId = request.getParameter("countryId");
	Statement StateSt = null;
	ResultSet StateRs = null;
	 
	try {
		StateSt = connection.createStatement();
		StateRs = StateSt.executeQuery("select name from sub_category where name ='"+stateName+"'");
			
		 		if (StateRs.next())	{
		 			response.sendRedirect("admin/manageData.jsp?msg=StateExist");
				 }
				 else   { 
					 PreparedStatement addstatePs =null;
					 try {
						 String addstateQ ="insert into state (name,country_id) values(?,?)";
						
						 addstatePs  =  connection.prepareStatement(addstateQ);
						 addstatePs.setString(1, stateName); 
						 addstatePs.setString(2, countryId); 
						 addstatePs.executeUpdate();	
 						  
						response.sendRedirect("admin/manageData.jsp");
						/*
						RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("adminIndex.jsp?pageNumber=1#tab2");
						*/
						/*RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("adminIndex.jsp?pageNumber=1#section02");
				*/ }   
				 catch (SQLException e) {
						// TODO: handle exception
					e.printStackTrace();
					}
				 catch (Exception e) {
						// TODO: handle exception
						 e.printStackTrace();
					} finally {
						if(addstatePs!=null)  
						  try {
								addstatePs.close();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
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
			  if(StateSt!=null)
					try {
						StateSt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
	        	 if(StateRs!=null)
					try {
						StateRs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
		 }
	 out.close();  
}

public  ResultSet viewState()throws ServletException, IOException { 
	Statement stateSt =null;
	ResultSet stateRs = null;

	try {  				
		stateSt = connection.createStatement();
		String stateQ ="select * from state";
		stateRs = stateSt.executeQuery(stateQ);
	  
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
return stateRs;

}
public void addCity( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();  
	String cityName = request.getParameter("cityName");
	String stateId = request.getParameter("stateId");
	Statement citySt = null;
	ResultSet cityRs = null;
	 
	try {
		citySt = connection.createStatement();
		String checkCityQ = "select name from city where name ='"+cityName+"' ";
		cityRs = citySt.executeQuery(checkCityQ);
			
		 		if (cityRs.next())	{
		 			response.sendRedirect("admin/manageData.jsp?msg=cityExist");
				 }
				 else   { 
					 PreparedStatement addcityPs =null;
					 try {
						 String addstateQ ="insert into city (name,state_id) values(?,?)";
						
						 addcityPs  =  connection.prepareStatement(addstateQ);
						 addcityPs.setString(1, cityName); 
						 addcityPs.setString(2, stateId); 
						 addcityPs.executeUpdate();	
 						  
						response.sendRedirect("admin/manageData.jsp");
						/*
						RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("adminIndex.jsp?pageNumber=1#tab2");
						*/
						/*RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("adminIndex.jsp?pageNumber=1#section02");
				*/ }   
				 catch (SQLException e) {
						// TODO: handle exception
					e.printStackTrace();
					}
				 catch (Exception e) {
						// TODO: handle exception
						 e.printStackTrace();
					} finally {
						if(addcityPs!=null)  
						  try {
							  addcityPs.close();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
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
			  if(citySt!=null)
					try {
						citySt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
	        	 if(cityRs!=null)
					try {
						cityRs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
		 		}
	 	out.close();  
	}

public  ResultSet viewCity()throws ServletException, IOException { 
	Statement citySt =null;
	ResultSet cityRs = null;

	try {  				
		citySt = connection.createStatement();
		String cityQ ="select * from city";
		cityRs = citySt.executeQuery(cityQ);
	  
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
return cityRs;

}
public void addFaqDetails( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();  
	String faqQuestion = request.getParameter("question");
	String faqAnswer = request.getParameter("answer");
	Statement faqSt = null;
	ResultSet faqRs = null;
	 
	try {
		faqSt = connection.createStatement();
		String checkFaqQ = "select question from faq_details where question = '"+faqQuestion+"'";
		faqRs = faqSt.executeQuery(checkFaqQ);
			
		 		if (faqRs.next())	{
		 			response.sendRedirect("admin/manageData.jsp?msg=faqExists");
				 }
				 else   { 
					 PreparedStatement addfaqPs =null;
					 try {
						 String addfaqQ ="insert into faq_details (question,answer) values(?,?)";
						
						 addfaqPs  =  connection.prepareStatement(addfaqQ);
						 addfaqPs.setString(1, faqQuestion); 
						 addfaqPs.setString(2, faqAnswer); 
						 addfaqPs.executeUpdate();	
 						  
						response.sendRedirect("admin/manageData.jsp");
						/*
						RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("adminIndex.jsp?pageNumber=1#tab2");
						*/
						/*RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("adminIndex.jsp?pageNumber=1#section02");
				*/ }   
				 catch (SQLException e) {
						// TODO: handle exception
					e.printStackTrace();
					}
				 catch (Exception e) {
						// TODO: handle exception
						 e.printStackTrace();
					} finally {
						if(addfaqPs!=null)  
						  try {
							  addfaqPs.close();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
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
			  if(faqSt!=null)
					try {
						faqSt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
	        	 if(faqSt!=null)
					try {
						faqSt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
		 		}
	 	out.close();  
	}
public  ResultSet viewFaq()throws ServletException, IOException { 
	Statement faqSt =null;
	ResultSet faqRs = null;

	try {  				
		faqSt = connection.createStatement();
		String faqQ ="select * from faq_details";
		faqRs = faqSt.executeQuery(faqQ);
	  
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
return faqRs;

}
public void addContactDetails( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();  
	String contactName = request.getParameter("name");
	String contactEmail = request.getParameter("email");
	String contactPhone = request.getParameter("phone");
	String contactSubject = request.getParameter("subject");
	String contactMessage = request.getParameter("message");
	
 
	 
	try { 
		
		 PreparedStatement addcontactPs =null;
					 try {
						 String addContactQ ="insert into contact_details (name,email,phone,subject,message) values(?,?,?,?,?)";
						
						 addcontactPs  =  connection.prepareStatement(addContactQ);
						 addcontactPs.setString(1, contactName); 
						 addcontactPs.setString(2, contactEmail); 
						 addcontactPs.setString(3, contactPhone); 
						 addcontactPs.setString(4, contactSubject); 
						 addcontactPs.setString(5, contactMessage); 
						 addcontactPs.executeUpdate();	
 						  
						response.sendRedirect("contact.jsp");
						/*
						RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("adminIndex.jsp?pageNumber=1#tab2");
						*/
						/*RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("adminIndex.jsp?pageNumber=1#section02");
				*/ }   
				 catch (SQLException e) {
						// TODO: handle exception
					e.printStackTrace();
					}
				 catch (Exception e) {
						// TODO: handle exception
						 e.printStackTrace();
					} finally {
						if(addcontactPs!=null)  
						  try {
							  addcontactPs.close();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}  
					 }  
				  
			}
		  
		 catch (Exception e) {
				// TODO: handle exception
				 e.printStackTrace();
			}
		 
	 	out.close();  
	}
public  ResultSet viewContact()throws ServletException, IOException { 
	Statement contactSt =null;
	ResultSet contactRs = null;

	try {  				
		contactSt = connection.createStatement();
		String faqQ ="select * from contact_details";
		contactRs = contactSt.executeQuery(faqQ);
	  
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
return contactRs;

}
public void addAddress( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();
	String pId = request.getParameter("pId");
	String quantity = request.getParameter("quantity");
	String line1 = request.getParameter("line1");
	String line2 = request.getParameter("line2");
	String landmark = request.getParameter("landmark");
	String pincode = request.getParameter("pincode");
	String cityName = request.getParameter("cityName");
	String stateName = request.getParameter("stateName");
	String countryName = request.getParameter("countryName");
	String addressType = request.getParameter("addressType");
	HttpSession session = request.getSession();
	String userId= (String)session.getAttribute("userId");
	
	Statement addressIdSt = null;
	ResultSet addressIdRs = null;
	PreparedStatement addAddressPs =null;
	try {  
		
			String addressId=null;
			addressIdSt = connection.createStatement();
			String checkCityQ = "select max(id)+1 as maxAddressId from address";
			addressIdRs = addressIdSt.executeQuery(checkCityQ);
				
		 		if (addressIdRs.next())	{
		 			 
		 			  addressId = addressIdRs.getString("maxAddressId");
		 			  
		 			if(addressId == null)
		 			{
		 				addressId ="1";
		 			}
				
				String addAddressQ ="insert into address (id,line1,line2,landmark,city,state,country,pincode,adress_type,customer_id) values(?,?,?,?,?,?,?,?,?,?)";
				addAddressPs  =  connection.prepareStatement(addAddressQ);
				addAddressPs.setString(1, addressId); 
				addAddressPs.setString(2, line1); 
				addAddressPs.setString(3, line2);
				addAddressPs.setString(4, landmark);
				addAddressPs.setString(5, cityName); 
				addAddressPs.setString(6, stateName); 
				addAddressPs.setString(7, countryName); 
				addAddressPs.setString(8, pincode); 
				addAddressPs.setString(9, addressType); 
				addAddressPs.setString(10, userId);  
				addAddressPs.executeUpdate();	
				response.sendRedirect("productPlaceOrder.jsp?pId="+pId+"&quantity="+quantity);
	  
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
		  if(addressIdSt!=null)
				try {
					addressIdSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
        	 if(addressIdRs!=null)
				try {
					addressIdRs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	 if(addAddressPs!=null)
 				try {
 					addAddressPs.close();
 				} catch (SQLException e) {
 					// TODO Auto-generated catch block
 					e.printStackTrace();
 				} 
	 	}
	 out.close(); 
	 
}



public   ResultSet productCheckoutDetail(String pId,String userId) throws ServletException, IOException { 
	Statement productCheckoutSt =null;
	ResultSet productCheckoutRs = null;
 
	try  { 				
			productCheckoutSt = connection.createStatement();
			String productCheckoutQ =  "select * from product_details p inner join cart c on c.product_details_id = p.id where c.product_details_id='"+pId+"' and c.customer_id='"+userId+"' "  ;
			productCheckoutRs = productCheckoutSt.executeQuery(productCheckoutQ);
			 
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
	return productCheckoutRs;

}
public void confirmOrder( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();
	String cartId = request.getParameter("cart_id");
	String shipperId = request.getParameter("shipper_id");
	String addressId = request.getParameter("address_id");
	String deliveryDate = request.getParameter("delivery_date");
	
	HttpSession session = request.getSession();
	String userId= (String)session.getAttribute("userId");
	
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		 
	 
	  
	Statement orderIdSt = null;
	ResultSet orderIdRs = null;
	PreparedStatement orderDetailPs =null;
	try {  
		
			String orderId=null;
			orderIdSt = connection.createStatement();
			String orderIdQ = "select max(id)+1 as maxordeId from order_detail";
			orderIdRs = orderIdSt.executeQuery(orderIdQ);
				
		 		if( orderIdRs.next())	{
		 			 orderId = orderIdRs.getString("maxordeId");
		 			 if(orderId == null)
		 			 	{
		 				 	orderId = "1";
		 			 	} 
				String orderDetailQ ="insert into order_detail (id,order_date,delivery_date,address_id,shipper_id,cart_id,customer_id) values(?,?,?,?,?,?,?)";
				orderDetailPs  =  connection.prepareStatement(orderDetailQ);
				orderDetailPs.setString(1, orderId); 
				orderDetailPs.setString(2,  dateFormat.format(date)); 
				orderDetailPs.setString(3, deliveryDate);
				orderDetailPs.setString(4, addressId);
				orderDetailPs.setString(5, shipperId); 
				orderDetailPs.setString(6, cartId); 
				orderDetailPs.setString(7, userId); 
				orderDetailPs.executeUpdate();	
				response.sendRedirect("productPayment.jsp");
	  
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
		  if(orderIdRs!=null)
				try {
					orderIdRs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
        	 if(orderIdSt!=null)
				try {
					orderIdSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	 if(orderDetailPs!=null)
 				try {
 					orderDetailPs.close();
 				} catch (SQLException e) {
 					// TODO Auto-generated catch block
 					e.printStackTrace();
 				} 
	 	}
	 out.close(); 
	 
}
public void addDonation( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();
	String name = request.getParameter("name");
	String age = request.getParameter("age");
	String amount = request.getParameter("amount");
	String purpose = request.getParameter("purpose");
	String description = request.getParameter("description");
	 
	HttpSession session = request.getSession();
	String ngoId= (String)session.getAttribute("ngoId");
	
	Statement donationIdSt = null;
	ResultSet donationIdRs = null;
	PreparedStatement addDonationPs =null;
	try {  
		
			String donationId=null;
			donationIdSt = connection.createStatement();
			String donationIdQ = "select max(id)+1 as maxDonationId from donation_details";
			donationIdRs = donationIdSt.executeQuery(donationIdQ);
				
		 		if (donationIdRs.next())	{
		 			 
		 			  donationId = donationIdRs.getString("maxdonationId");
		 			  
		 			if(donationId == null)
		 			{
		 				donationId ="1";
		 			}
				
				String adddonationQ ="insert into donation_details (id,name,age,description,purpose,total_amount,ngo_details_id) values( ?,?,?,?,?,?,?)";
				addDonationPs  =  connection.prepareStatement(adddonationQ);
				addDonationPs.setString(1, donationId); 
				addDonationPs.setString(2, name); 
				addDonationPs.setString(3, age);
				addDonationPs.setString(4, description);
				addDonationPs.setString(5, purpose); 
				addDonationPs.setString(6, amount); 
				addDonationPs.setString(7, ngoId);    
				addDonationPs.executeUpdate();	
				response.sendRedirect("ngoAddDonation.jsp?donationId="+donationId+"&picSection=1");
	  
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
		  if(donationIdSt!=null)
				try {
					donationIdSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
        	 if(donationIdRs!=null)
				try {
					donationIdRs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	 if(addDonationPs!=null)
 				try {
 					addDonationPs.close();
 				} catch (SQLException e) {
 					// TODO Auto-generated catch block
 					e.printStackTrace();
 				} 
	 		}
	 out.close();  
}
public   ResultSet getDonationDetail(String id) throws ServletException, IOException { 
	Statement getDonationSt =null;
	ResultSet getDonationRs = null;
	  
	try {  				
			getDonationSt = connection.createStatement();
			String getDonationQ = "select *  from donation_details where total_amount >0 where id ="+id;
			getDonationRs = getDonationSt.executeQuery(getDonationQ);
			 
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
	return getDonationRs;

}
public   ResultSet getDonationDetail() throws ServletException, IOException { 
	Statement getDonationSt =null;
	ResultSet getDonationRs = null;
	  
	try {  				
			getDonationSt = connection.createStatement();
			String getDonationQ = "select *  from donation_details where total_amount >0";
			getDonationRs = getDonationSt.executeQuery(getDonationQ);
			 
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
	return getDonationRs;

}
 
public   ResultSet getNgoDonations(String ngoId) throws ServletException, IOException { 
	Statement getDonationSt =null;
	ResultSet getDonationRs = null;
	  
	try {  				
			getDonationSt = connection.createStatement();
			String getDonationQ = "select *  from donation_details where total_amount >0 and ngo_details_id="+ngoId;
			getDonationRs = getDonationSt.executeQuery(getDonationQ); 
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
	return getDonationRs;

}
public   ResultSet getOtherDonationDetail(String ngoId,String dId) throws ServletException, IOException { 
	Statement getDonationSt =null;
	ResultSet getDonationRs = null;
	  
	try {  				
			getDonationSt = connection.createStatement();
			String getDonationQ = "select *  from donation_details where total_amount >0 and id!='"+dId+"' and ngo_details_id = "+ngoId;
			getDonationRs = getDonationSt.executeQuery(getDonationQ);
			 
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
	return getDonationRs;

}
 

public   ResultSet getNgoDonationDetail(String dId) throws ServletException, IOException { 
	Statement getDonationSt =null;
	ResultSet getDonationRs = null;
	  
	try {  				
			getDonationSt = connection.createStatement();
			String getDonationQ = "select *  from donation_details where id="+dId;
			getDonationRs = getDonationSt.executeQuery(getDonationQ);
			 
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
	return getDonationRs;

}

public void donateAmount( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();
	String dId = request.getParameter("dId");
	String amount = request.getParameter("amount");
	String donationAmount = null;
	 
	HttpSession session = request.getSession();
	String uId= (String)session.getAttribute("userId");
	if(uId != null) {
		Statement donationAmountSt = null;
		ResultSet donationAmountRs = null;
		PreparedStatement updateDonationPs =null;
		  
		try {   
				String donationId=null;
				donationAmountSt = connection.createStatement();
				String donationAmountQ = "select total_amount from donation_details where id = "+dId;
				donationAmountRs = donationAmountSt.executeQuery(donationAmountQ);
					
		 		if (donationAmountRs.next()) {
			 		
		 				donationAmount = donationAmountRs.getString("total_amount");
		 				int flag = donationPayment(uId,amount); 
			 			 if(flag == 1)
			 			 {
			 				 int updateAmount = Integer.parseInt(donationAmount) - Integer.parseInt(amount);
			 				 donationAmountQ ="update  donation_details set total_amount =? where id = "+dId;
			 				 updateDonationPs  =  connection.prepareStatement(donationAmountQ);
			 				 updateDonationPs.setInt(1, updateAmount); 
			 				 updateDonationPs.executeUpdate();	
			 				 response.sendRedirect("index.jsp?dId="+dId);
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
			  if(donationAmountSt!=null)
					try {
						donationAmountSt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
	        	 if(donationAmountRs!=null)
					try {
						donationAmountRs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	        	 if(updateDonationPs!=null)
	 				try {
	 					updateDonationPs.close();
	 				} catch (SQLException e) {
	 					// TODO Auto-generated catch block
	 					e.printStackTrace();
	 				} 
		 		}
	}
	else
	{
		response.sendRedirect("index.jsp?action=LoginAgain");
	}
	 out.close();  
}
public int donationPayment(String uId, String amount) throws ServletException, IOException {
		
	return 1;
	
	
	

}
public   ResultSet getVolunteerDetail() throws ServletException, IOException { 
	Statement volunteerSt =null;
	ResultSet volunteerRs = null;
	  
	try {  				
		volunteerSt = connection.createStatement();
			String getVolunteerQ = "select *  from volunteer_details";
			 volunteerRs =  volunteerSt.executeQuery(getVolunteerQ);
			 
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
	return volunteerRs;

}
 
 

public   ResultSet getNgoVolunteerDetail(String id, String pId) throws ServletException, IOException { 
	Statement volunteerSt =null;
	ResultSet volunteerRs = null;
	  
	try {  				
		volunteerSt = connection.createStatement();
			String getVolunteerQ = "select *  from volunteer_details where id !='"+pId+"' and ngo_details_id ="+id;
			 volunteerRs =  volunteerSt.executeQuery(getVolunteerQ);
			 
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
	return volunteerRs;

}
public   ResultSet getNgoVolunteerDetail(String id) throws ServletException, IOException { 
	Statement volunteerSt =null;
	ResultSet volunteerRs = null;
	  
	try {  				
		volunteerSt = connection.createStatement();
			String getVolunteerQ = "select *  from volunteer_details where ngo_details_id ="+id;
			 volunteerRs =  volunteerSt.executeQuery(getVolunteerQ);
			 
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
	return volunteerRs;

}
public   ResultSet getSimilarJobs(String id) throws ServletException, IOException { 
	Statement volunteerSt =null;
	ResultSet volunteerRs = null;
	  
	try {  				
		volunteerSt = connection.createStatement();
			String getVolunteerQ = "select *  from volunteer_details where id !="+id;
			 volunteerRs =  volunteerSt.executeQuery(getVolunteerQ);
			 
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
	return volunteerRs;

}

public   ResultSet getOtherNgos(String id) throws ServletException, IOException { 
	Statement otherNgosSt =null;
	ResultSet otherNgosRs = null;
	  
	try {  				
		otherNgosSt = connection.createStatement();
			String getVolunteerQ = "select *  from ngo_details where id !="+id;
			otherNgosRs =  otherNgosSt.executeQuery(getVolunteerQ);
			 
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
	return otherNgosRs;

}
public   ResultSet getVolunteerDetail(String vId) throws ServletException, IOException { 
	Statement volunteerSt =null;
	ResultSet volunteerRs = null;
	  
	try {  				
			volunteerSt = connection.createStatement();
			String getVolunteerQ = "select *  from volunteer_details where id ="+vId;
			volunteerRs =  volunteerSt.executeQuery(getVolunteerQ);
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
	return volunteerRs;

}
public void applyForVoluneer( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    String vId = "2"; /* request.getParameter("vId");*/
 
	 
	HttpSession session = request.getSession();
	String userId= (String)session.getAttribute("userId"); 
	 if(userId == null)
	{
		response.sendRedirect("volunteerPostView.jsp?action=LoginAgain"); 
	}else
	{ 
		 
		String resume = request.getParameter("resume");
		 
		 String saveFile="";
	    String contentType = request.getContentType();
	    if((contentType != null)&&(contentType.indexOf("multipart/form-data") >= 0)){
	    DataInputStream in = new DataInputStream(request.getInputStream());
	    int formDataLength = request.getContentLength();
	    byte dataBytes[] = new byte[formDataLength];
	    int byteRead = 0;
	    int totalBytesRead = 0;
	    while(totalBytesRead < formDataLength){
	    byteRead = in.read(dataBytes, totalBytesRead,formDataLength);
	    totalBytesRead += byteRead;
	    }
	    String file = new String(dataBytes);
	    saveFile = file.substring(file.indexOf("filename=\"") + 10);
	    saveFile = saveFile.substring(0, saveFile.indexOf("\n"));
	    saveFile = saveFile.substring(saveFile.lastIndexOf("\\") + 1,saveFile.indexOf("\""));
	    int lastIndex = contentType.lastIndexOf("=");
	    String boundary = contentType.substring(lastIndex + 1,contentType.length());
	    
	    int pos; 
	    pos = file.indexOf("filename=\"");
	    pos = file.indexOf("\n", pos) + 1; 
	    pos = file.indexOf("\n", pos) + 1;
	    pos = file.indexOf("\n", pos) + 1; 
	    String fileName = "";
	    int boundaryLocation = file.indexOf(boundary, pos) - 4;
	    int startPos = ((file.substring(0, pos)).getBytes()).length;
	    int endPos = ((file.substring(0, boundaryLocation)).getBytes()).length;
	     
	    		   for(int i=saveFile.length()-1; i>=0; i--) { 	    			 
	    			 if(saveFile.charAt(i) == '.' ) {
	    				 fileName = "resume_"+vId+"_"+resume+saveFile.substring(i, saveFile.length()).toString();
	    				 System.out.println("File Name"+fileName);
	    				break; 
		    		 }
	    		 }  
	    File ff = new File("D:/6BCA/project/Git Repository/sarv_hitkari/WebContent/images/"+saveFile);
	     if(ff.exists())
	    {
	    	File filename= new File("D:/6BCA/project/Git Repository/sarv_hitkari/WebContent/images/"+fileName);
	    	ff.renameTo(filename);
	    	FileOutputStream fileOut = new FileOutputStream(ff); 
		    fileOut.write(dataBytes, startPos, (endPos - startPos));
		    fileOut.flush();
		    fileOut.close(); 
	    }
	    if(!ff.exists())
	    { 
	    	FileOutputStream fileOut = new FileOutputStream(ff); 
		    fileOut.write(dataBytes, startPos, (endPos - startPos));
		    fileOut.flush();
		    fileOut.close(); 
	    } 
	    /*FileOutputStream fileOut = new FileOutputStream(ff); 
	    fileOut.write(dataBytes, startPos, (endPos - startPos));
	    fileOut.flush();
	    fileOut.close(); */
	    
	    try{
	        
	    	Statement volunteerIdSt = null;
			ResultSet volunteerIdRs = null;
			PreparedStatement volunteerIdPs =null;
			try {  
				
					String volunteerId=null;
					volunteerIdSt = connection.createStatement();
					String volunteerIdQ = "select max(id)+1 as maxDonationId from volunteer_apply";
					volunteerIdRs = volunteerIdSt.executeQuery(volunteerIdQ);
						
				 		if (volunteerIdRs.next())	{
				 			 
				 			volunteerId = volunteerIdRs.getString("maxdonationId");
				 			  
				 			if(volunteerId == null)
				 			{
				 				volunteerId ="1";
				 			}
						String status = "Applied";
						DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
						Date date = new Date(); 
						String adddonationQ ="insert into volunteer_apply (id,apply_date,application_status,resume,volunteer_details_id,customer_id) values(?,?,?,?,?,?)";
						volunteerIdPs  =  connection.prepareStatement(adddonationQ);
						volunteerIdPs.setString(1, volunteerId); 
						volunteerIdPs.setString(2, dateFormat.format(date)); 
						volunteerIdPs.setString(3, status); 
						volunteerIdPs.setString(4, fileName);  
						volunteerIdPs.setString(5, vId);  
						volunteerIdPs.setString(6, userId);  
						volunteerIdPs.executeUpdate();	
						response.sendRedirect("volunteerPostView.jsp?vId="+vId+"");
			  
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
		        	 if(volunteerIdPs!=null)
		 				try {
		 					volunteerIdPs.close();
		 				} catch (SQLException e) {
		 					// TODO Auto-generated catch block
		 					e.printStackTrace();
		 				} 
			 		}
	        
	    }  catch (Exception e){
	    
	    }
	    }

		
		
		
		
		
		
		
	 
	
 	}
	 out.close();  
}
public int  volunteerApplicationStatus(HttpServletRequest request, HttpServletResponse response,String vId)throws ServletException, IOException {
	
	Statement volunteerSt =null;
	ResultSet volunteerRs = null;
	
	String status =null; 
 int st = 0;
	try {
		HttpSession session = request.getSession();
		String userId= (String)session.getAttribute("userId");
		
		volunteerSt = connection.createStatement();
		volunteerRs = volunteerSt.executeQuery("select application_status from volunteer_apply where volunteer_details_id='"+vId+"' and customer_id ='"+userId+"' ");
		  
			if(!volunteerRs.next())
			{
			}  
			else 
			{ 
				status= volunteerRs.getString(1); 
				 if(status.equals("Applied"));
				 {
					 st =1;	 
				 }
			}
 
	}  catch (SQLException e) {
		// TODO: handle exception
	e.printStackTrace();
	}
 catch (Exception e) {
		// TODO: handle exception
		 e.printStackTrace();
	}
	finally{
    	/*if(NgoStatusSt!=null)
			try {
				NgoStatusSt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
//    	if(NgoStatusRs!=null)
//			try {
//				NgoStatusRs.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} 
    	 
    	}
	return st;

}

public void addProductReview( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();
	String pId = request.getParameter("pId");
	String rating = request.getParameter("rating");
	String review = request.getParameter("review");
	 
	HttpSession session = request.getSession();
	String userId= (String)session.getAttribute("userId"); 
	if(userId == null)
	{
		response.sendRedirect("volunteerPostView.jsp?action=LoginAgain"); 
	}else
	{ 
		PreparedStatement reviewPs =null;
		try {   	 
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				Date date = new Date(); 
				String reviewQ ="insert into product_review (review,rating,review_date,customer_id,product_details_id) values(?,?,?,?,?)";
				reviewPs  = connection.prepareStatement(reviewQ);
				reviewPs.setString(1, review ); 
				reviewPs.setString(2, rating ); 
				reviewPs.setString(3, dateFormat.format(date)); 
				reviewPs.setString(4, userId );  
				reviewPs.setString(5, pId); 
				reviewPs.executeUpdate();	
				response.sendRedirect("index.jsp");
		   	  
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
	        	 if(reviewPs!=null)
	 				try {
	 					reviewPs.close();
	 				} catch (SQLException e) {
	 					// TODO Auto-generated catch block
	 					e.printStackTrace();
	 				} 
		 		}
	}
	 out.close();  
}


public int  getReviewCount(String pId)throws ServletException, IOException {
	Statement reviewCountSt =null;
	ResultSet reviewCountRs = null;
	int count = 0;  
	try {
		reviewCountSt = connection.createStatement();
		reviewCountRs = reviewCountSt.executeQuery("select count(*) as count from product_review where product_details_id = "+pId);
		  
			if(!reviewCountRs.next())
			{
			}  
			else 
			{ 
				count= Integer.parseInt(reviewCountRs.getString("count")); 
			 }
 
	}  catch (SQLException e) {
		// TODO: handle exception
	e.printStackTrace();
	}
 catch (Exception e) {
		// TODO: handle exception
		 e.printStackTrace();
	}
	finally{
    	 if(reviewCountSt!=null)
			try {
				reviewCountSt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
     	if(reviewCountRs!=null)
			try {
				reviewCountRs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
    	 
    	}
	return count; 
}
public int  getReviewAvg(String pId)throws ServletException, IOException {
	Statement reviewAvgSt =null;
	ResultSet reviewAvgRs = null;
	int avg = 0;  
	try {
			reviewAvgSt = connection.createStatement();
			reviewAvgRs = reviewAvgSt.executeQuery("select sum(rating) as count from product_review where product_details_id = "+pId);
			if(!reviewAvgRs.next()) { 
			}  
			else  {  
				avg = Integer.parseInt(reviewAvgRs.getString("count")); 
				avg = avg / getReviewCount(pId);
			} 
	}  catch (SQLException e) {
		// TODO: handle exception
	e.printStackTrace();
	}
 catch (Exception e) {
		// TODO: handle exception
		 e.printStackTrace();
	}
	finally{
    	 if(reviewAvgSt!=null)
			try {
				reviewAvgSt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
     	if(reviewAvgRs!=null)
			try {
				reviewAvgRs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
    	}
	return avg;

}
public ResultSet  getProductReview(int pId)throws ServletException, IOException {
	Statement reviewSt =null;
	ResultSet reviewRs = null;
	int avg = 0;  
	try {
			reviewSt = connection.createStatement();
			reviewRs = reviewSt.executeQuery("select *  from product_review where product_details_id = "+pId);
			 
	}  catch (SQLException e) {
		// TODO: handle exception
	e.printStackTrace();
	}
 catch (Exception e) {
		// TODO: handle exception
		 e.printStackTrace();
	}
	finally{
    	 
    	}
	return  reviewRs;

}
public int  getReviewRatingCount(int pId,int rating)throws ServletException, IOException {
	Statement reviewAvgSt =null;
	ResultSet reviewAvgRs = null;
	int count = 0;  
	try {
			reviewAvgSt = connection.createStatement();
			reviewAvgRs = reviewAvgSt.executeQuery("select count(*) as count from product_review where product_details_id = '"+pId+"' and rating='"+rating+"'");
			if(!reviewAvgRs.next()) { 
			}  
			else  {  
				count = Integer.parseInt(reviewAvgRs.getString("count")); 
				 
			} 
	}  catch (SQLException e) {
		// TODO: handle exception
	e.printStackTrace();
	}
 catch (Exception e) {
		// TODO: handle exception
		 e.printStackTrace();
	}
	finally{
    	 if(reviewAvgSt!=null)
			try {
				reviewAvgSt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
     	if(reviewAvgRs!=null)
			try {
				reviewAvgRs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
    	}
	return count;

}
public double  getReviewRatingPer(int pId,int ratingCount)throws ServletException, IOException {
	Statement reviewAvgSt =null;
	ResultSet reviewAvgRs = null;
	int count = 0;  
	double per =0;
	try {
		if(ratingCount!=0)
		{
			System.out.println("ratingCount "+ratingCount);
		count = getReviewRatingSum(pId);
		System.out.println("sum "+count);
		per =   ( Double.parseDouble(String.valueOf(ratingCount))  /   Double.parseDouble(String.valueOf(count)))*100 ;
		System.out.println("percentage "+per);
		}
	}  
 catch (Exception e) {
		// TODO: handle exception
		 e.printStackTrace();
	}
	finally{
    	 if(reviewAvgSt!=null)
			try {
				reviewAvgSt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
     	if(reviewAvgRs!=null)
			try {
				reviewAvgRs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
    	}
	return per;

}
public int  getReviewRatingSum(int pId)throws ServletException, IOException {
	Statement reviewAvgSt =null;
	ResultSet reviewAvgRs = null;
	int count = 0;  
	try {
			reviewAvgSt = connection.createStatement();
			reviewAvgRs = reviewAvgSt.executeQuery("select sum(rating) as count from product_review where product_details_id = '"+pId+"' ");
			if(!reviewAvgRs.next()) { 
			}  
			else  {  
				count = Integer.parseInt(reviewAvgRs.getString("count")); 
				 
			} 
	}  catch (SQLException e) {
		// TODO: handle exception
	e.printStackTrace();
	}
 catch (Exception e) {
		// TODO: handle exception
		 e.printStackTrace();
	}
	finally{
    	 if(reviewAvgSt!=null)
			try {
				reviewAvgSt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
     	if(reviewAvgRs!=null)
			try {
				reviewAvgRs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
    	}
	return count;

}

public String  getCustomerName(String cId)throws ServletException, IOException {
	Statement  cNameSt =null;
	ResultSet cNameRs = null;
	String name = null;  
	try {
			cNameSt = connection.createStatement();
			cNameRs = cNameSt.executeQuery("select name   from customer where id = '"+cId+"' ");
			if(!cNameRs.next()) { 
			}  
			else  {  
				name =  cNameRs.getString("name"); 
				 
			} 
	}  catch (SQLException e) {
		// TODO: handle exception
	e.printStackTrace();
	}
 catch (Exception e) {
		// TODO: handle exception
		 e.printStackTrace();
	}
	finally{
    	 if(cNameSt!=null)
			try {
				cNameSt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
     	if(cNameRs!=null)
			try {
				cNameRs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
    	}
	return name;

}
public ResultSet  getNgoDetail()throws ServletException, IOException {
	Statement ngoDetailSt =null;
	ResultSet ngoDetailRs = null;  
	try {
		ngoDetailSt = connection.createStatement();
		ngoDetailRs = ngoDetailSt.executeQuery("select id,logo from ngo_details where approve_status= 'Approved'");
			 
	}  catch (SQLException e) {
		// TODO: handle exception
	e.printStackTrace();
	}
 catch (Exception e) {
		// TODO: handle exception
		 e.printStackTrace();
	}
	finally{
    	/* if(ngoDetailSt!=null)
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
			}  */
    	}
	return ngoDetailRs;

}
public String  getNgoName(String id)throws ServletException, IOException {
	Statement ngoDetailSt =null;
	ResultSet ngoDetailRs = null;  
	String logo="";
	try {
		ngoDetailSt = connection.createStatement();
		ngoDetailRs = ngoDetailSt.executeQuery("select name from ngo_details where id="+id);
			 
		if(ngoDetailRs.next())
		{
			logo= ngoDetailRs.getString("name");
		}
	}  catch (SQLException e) {
		// TODO: handle exception
	e.printStackTrace();
	}
 catch (Exception e) {
		// TODO: handle exception
		 e.printStackTrace();
	}
	finally{
    	/* if(ngoDetailSt!=null)
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
			}  */
    	}
	return logo;

}
public String  getNgoLogo(String id)throws ServletException, IOException {
	Statement ngoDetailSt =null;
	ResultSet ngoDetailRs = null;  
	String logo="";
	try {
		ngoDetailSt = connection.createStatement();
		ngoDetailRs = ngoDetailSt.executeQuery("select logo from ngo_details where id="+id);
			 
		if(ngoDetailRs.next())
		{
			logo= ngoDetailRs.getString("logo");
		}
	}  catch (SQLException e) {
		// TODO: handle exception
	e.printStackTrace();
	}
 catch (Exception e) {
		// TODO: handle exception
		 e.printStackTrace();
	}
	finally{
    	/* if(ngoDetailSt!=null)
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
			}  */
    	}
	return logo;

}
public   ResultSet getProductOfCategory(String SubCategoryId,int pId) throws ServletException, IOException { 
	Statement getDetailSt =null;
	ResultSet getDetailRs = null;
	  
	try {  				
			getDetailSt = connection.createStatement();
			String query = "select id,name,price,image1  from product_details where sub_category_id = '"+SubCategoryId+"' and id != "+pId ;
			getDetailRs = getDetailSt.executeQuery(query);
			 
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
	return getDetailRs;

}
public String  getCustomerPhoto(String cId)throws ServletException, IOException {
	Statement  cPhotoSt =null;
	ResultSet cPhotoRs = null;
	String name = null;  
	try {
		cPhotoSt = connection.createStatement();
		cPhotoRs = cPhotoSt.executeQuery("select photo   from customer where id = '"+cId+"' ");
			if(!cPhotoRs.next()) { 
			}  
			else  {  
				name =  cPhotoRs.getString("name"); 
				 
			} 
	}  catch (SQLException e) {
		// TODO: handle exception
	e.printStackTrace();
	}
 catch (Exception e) {
		// TODO: handle exception
		 e.printStackTrace();
	}
	finally{
    	 if(cPhotoSt!=null)
			try {
				cPhotoSt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
     	if(cPhotoRs!=null)
			try {
				cPhotoRs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
    	}
	return name;

}
public   ResultSet getNgoProduct(String ngoId) throws ServletException, IOException { 
	Statement getDetailSt =null;
	ResultSet getDetailRs = null;
	  
	try {  				
			getDetailSt = connection.createStatement();
			String query = "select id,name,price,image1  from product_details where ngo_details_id ="+ngoId;
			getDetailRs = getDetailSt.executeQuery(query);
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
		return getDetailRs;

}
public   ResultSet getNgoOtherProduct(String ngoId,String id) throws ServletException, IOException { 
	Statement getDetailSt =null;
	ResultSet getDetailRs = null;
	  
	try {  				
			getDetailSt = connection.createStatement();
			String query = "select id,name,price,image1  from product_details where id != '"+id+"' and ngo_details_id ="+ngoId;
			getDetailRs = getDetailSt.executeQuery(query);
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
		return getDetailRs;

}
public   ResultSet getEventDetail() throws ServletException, IOException { 
	Statement eventSt =null;
	ResultSet eventRs = null;
	  
	try {  				
		 java.text.DateFormat formatter = new java.text.SimpleDateFormat("MM/dd/YYYY");
		 java.util.Date newDate = new java.util.Date();
		eventSt = connection.createStatement();
		 
			String getVolunteerQ = "select *  from event_details where event_date >= '"+formatter.format(newDate )+"'";
			eventRs =  eventSt.executeQuery(getVolunteerQ);
			 
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
	return eventRs;

}
public   ResultSet getNgoEventDetails(String ngoId , String id) throws ServletException, IOException { 
	Statement eventSt =null;
	ResultSet eventRs = null;
	  
	try {  				
		 java.text.DateFormat formatter = new java.text.SimpleDateFormat("MM/dd/YYYY");
		 java.util.Date newDate = new java.util.Date();
		eventSt = connection.createStatement();
		 
			String getVolunteerQ = "select *  from event_details where event_date >= '"+formatter.format(newDate )+"' and id!='"+id+"' and ngo_details_id= '"+ngoId+"'";
			eventRs =  eventSt.executeQuery(getVolunteerQ);
			 
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
	return eventRs;

}
public   ResultSet getNgoEventDetail(String id) throws ServletException, IOException { 
	Statement eventSt =null;
	ResultSet eventRs = null;
	  
	try {  				
		 java.text.DateFormat formatter = new java.text.SimpleDateFormat("MM/dd/YYYY");
		 java.util.Date newDate = new java.util.Date();
		eventSt = connection.createStatement();
		 
			String getVolunteerQ = "select *  from event_details where event_date >= '"+formatter.format(newDate )+"' and id="+id;
			eventRs =  eventSt.executeQuery(getVolunteerQ);
			 
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
	return eventRs;

}
public   ResultSet getEventDetail(String id) throws ServletException, IOException { 
	Statement eventSt =null;
	ResultSet eventRs = null;
	  
	try {  				
		 java.text.DateFormat formatter = new java.text.SimpleDateFormat("MM/dd/YYYY");
		 java.util.Date newDate = new java.util.Date();
		eventSt = connection.createStatement();
		 
			String getVolunteerQ = "select *  from event_details where event_date >= '"+formatter.format(newDate )+"' and id="+id;
			eventRs =  eventSt.executeQuery(getVolunteerQ);
			 
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
	return eventRs;

}
public   ResultSet getSimilarEvent(String id) throws ServletException, IOException { 
	Statement eventSt =null;
	ResultSet eventRs = null;
	  
	try {  				
		 java.text.DateFormat formatter = new java.text.SimpleDateFormat("MM/dd/YYYY");
		 java.util.Date newDate = new java.util.Date();
		eventSt = connection.createStatement();
		 
			String getVolunteerQ = "select *  from event_details where event_date >= '"+formatter.format(newDate )+"' and id !="+id;
			eventRs =  eventSt.executeQuery(getVolunteerQ);
			 
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
	return eventRs;

}
public void updateEventInterst( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();  
	String interst = request.getParameter("interst");
	String eId = request.getParameter("eId");
	HttpSession session = request.getSession();
	String userId = (String)session.getAttribute("userId");
	if(userId == null) {
		response.sendRedirect("index.jsp?action=LoginAgain");
	} else if(userId != null) {
		 
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date(); 
		PreparedStatement addEventPs = null; 
			try { 
					String addEventQ = "insert into event_transaction (customer_status ,apply_date,customer_id,event_details_id) values(?,?,?,?)";
					addEventPs  =  connection.prepareStatement(addEventQ);
					addEventPs.setString(1, interst); 
					addEventPs.setString(2, dateFormat.format(date));
					addEventPs.setString(3, userId); 
					addEventPs.setString(4, eId);
					addEventPs.executeUpdate();	
					response.sendRedirect("index.jsp"); 
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
		 out.close();  
}
public void eventInterst( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();  
	String interst = request.getParameter("interst");
	String eId = request.getParameter("eId");
	HttpSession session = request.getSession();
	String userId = (String)session.getAttribute("userId");
	if(userId == null) {
		response.sendRedirect("index.jsp?action=LoginAgain");
	} else if(userId != null) {
		 
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date(); 
		PreparedStatement addEventPs = null; 
			try { 
					String addEventQ = "insert into event_transaction (staus ,apply_date,customer_id,event_details_id) values(?,?,?,?)";
					addEventPs  =  connection.prepareStatement(addEventQ);
					addEventPs.setString(1, interst); 
					addEventPs.setString(2, dateFormat.format(date));
					addEventPs.setString(3, userId); 
					addEventPs.setString(4, eId);
					addEventPs.executeUpdate();	
					response.sendRedirect("index.jsp"); 
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
		 out.close();  
}

public String  getEventStatus( HttpServletRequest request, HttpServletResponse response,String eId)throws ServletException, IOException {
	
	Statement eventStatusSt =null;
	ResultSet eventStatusRs = null;
	String status =null; 
 
	try {
		 HttpSession session = request.getSession();
			String userId =   (String)session.getAttribute("userId");  
			
			eventStatusSt = connection.createStatement();
			String query ="select customer_status from event_transaction where event_details_id = '"+eId+"' and  customer_id = "+userId;
			eventStatusRs = eventStatusSt.executeQuery(query);
		  
			if(!eventStatusRs.next())
			{
			}  
			else 
			{ 
				status= eventStatusRs.getString(1); 
				 System.out.println("status = "+status);
			}
 
	}  catch (SQLException e) {
		// TODO: handle exception
	e.printStackTrace();
	}
 catch (Exception e) {
		// TODO: handle exception
		 e.printStackTrace();
	}
	finally{
    	/*if(NgoStatusSt!=null)
			try {
				NgoStatusSt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
//    	if(NgoStatusRs!=null)
//			try {
//				NgoStatusRs.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} 
    	 
    	}
	return status;

}
public String  eventInterestStatus(HttpServletRequest request, HttpServletResponse response,String vId)throws ServletException, IOException {
	
	Statement volunteerSt =null;
	ResultSet volunteerRs = null;
	
	String status =null; 
  
	try {
		HttpSession session = request.getSession();
		String userId= (String)session.getAttribute("userId");
		 
		volunteerSt = connection.createStatement();
		volunteerRs = volunteerSt.executeQuery("select customer_status from event_transaction where event_details_id='"+vId+"' and customer_id ='"+userId+"' ");
		  
			if(!volunteerRs.next())
			{
			}  
			else 
			{ 
				status= volunteerRs.getString(1); 
				 
			}
 
	}  catch (SQLException e) {
		// TODO: handle exception
	e.printStackTrace();
	}
 catch (Exception e) {
		// TODO: handle exception
		 e.printStackTrace();
	}
	finally{
    	/*if(NgoStatusSt!=null)
			try {
				NgoStatusSt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
//    	if(NgoStatusRs!=null)
//			try {
//				NgoStatusRs.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} 
    	 
    	}
	return status;

}
public   ResultSet getNgoEvents(String id) throws ServletException, IOException { 
	Statement volunteerSt =null;
	ResultSet volunteerRs = null;
	  
	try {  				
		volunteerSt = connection.createStatement();
			String getVolunteerQ = "select *  from event_details where ngo_details_id ="+id;
			 volunteerRs =  volunteerSt.executeQuery(getVolunteerQ);
			 
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
	return volunteerRs;

}


public void updateDonationDetail( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();  
	String donationName = request.getParameter("donationName");
	String purpose = request.getParameter("purpose");
	HttpSession session = request.getSession();
	String ngoId = (String)session.getAttribute("NgoId");
	String amountNeeded = request.getParameter("amountNeeded");
	String description = request.getParameter("description");
	String dId = request.getParameter("dId");
	  
		try { 
			 PreparedStatement updateDonationPs = null;
			 updateDonationPs  =  connection.prepareStatement("update   donation_details set  name=?,description=?,purpose=?,total_amount=?   where id = '"+dId+"' " );
			 updateDonationPs.setString(1, donationName); 
			 updateDonationPs.setString(2, description); 
			 updateDonationPs.setString(3, purpose); 
			 updateDonationPs.setString(4, amountNeeded);  
			 updateDonationPs.executeUpdate();	
			 response.sendRedirect("ngoAddDonationPreview.jsp?dId="+dId); 
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



public void updateVolunteerDetail( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();  
	String position = request.getParameter("position");
	String jobType = request.getParameter("jobType");
	HttpSession session = request.getSession();
	String ngoId = (String)session.getAttribute("NgoId");
	String stipend = request.getParameter("stipend");
	String experience = request.getParameter("experience");
	String location = request.getParameter("location");
	String skills = request.getParameter("skills");
	String lastdate = request.getParameter("lastdate");

	String description = request.getParameter("description");
	 
	String dId = request.getParameter("dId");
	  
		try { 
			String query = "update   volunteer_details set  position=?,skills=?,volunteer_type=?,description=?, lastdate=?,stipend=?,experience=?,location=?  where id = '"+dId+"' ";
			 PreparedStatement updateDonationPs = null;
			 updateDonationPs  =  connection.prepareStatement(query );
			 updateDonationPs.setString(1, position); 
			 updateDonationPs.setString(2, skills); 
			 updateDonationPs.setString(3, jobType); 
			 updateDonationPs.setString(4, description);   
			 updateDonationPs.setString(5, lastdate); 
			 updateDonationPs.setString(6, stipend ); 
			 updateDonationPs.setString(7,experience ); 
			 updateDonationPs.setString(8,location );    
			 updateDonationPs.executeUpdate();	
			 response.sendRedirect("ngoVolunteerPreview.jsp?vId="+dId); 
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
public void updateEventDetail( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();  
    String websiteLink =null;
	
	String description = request.getParameter("description");
	HttpSession session = request.getSession();
	String ngoId = (String)session.getAttribute("NgoId");
	String eventName = request.getParameter("eventName");
	String registration = request.getParameter("registration");
	if(registration.equals("Yes")) {
	 websiteLink = request.getParameter("websiteLink");
	}
	String eventDuration = request.getParameter("eventDuration");
	String eventDate = request.getParameter("eventDate");
	String eventStartTime = request.getParameter("eventStartTime");
	String venue = request.getParameter("venue");
	 
	String dId = request.getParameter("pId");
	  
		try { 
			String query = "update   event_details set  event_name=?,event_date=?,event_start_time=?,event_description=?, registration_status=?,website_link=?,event_duration=?,venue=?  where id = '"+dId+"' ";
			 PreparedStatement updateDonationPs = null;
			 updateDonationPs  =  connection.prepareStatement(query );
			 updateDonationPs.setString(1, eventName); 
			 updateDonationPs.setString(2, eventDate); 
			 updateDonationPs.setString(3, eventStartTime); 
			 updateDonationPs.setString(4, description); 
			 updateDonationPs.setString(5, registration);   
			 updateDonationPs.setString(6, websiteLink); 
			 updateDonationPs.setString(7, eventDuration ); 
			 updateDonationPs.setString(8,venue );    
			 updateDonationPs.executeUpdate();	
			 response.sendRedirect("ngoEventPreview.jsp?vId="+dId); 
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

}

 