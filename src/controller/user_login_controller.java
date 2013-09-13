
package controller;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import database.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import bean.user;
@WebServlet("/user_login_controller")
public class user_login_controller extends HttpServlet{

	
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
	{
		processRequest(request,response);
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
	{
		processRequest(request,response);
	}
	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) {
	
		String userAction=request.getParameter("user_action");
		if(userAction.equals("Login"))
		{
			
			loginDAO d=new loginDAO();
			user u=new user();
			String Email=request.getParameter("user_email");
			String pwd=request.getParameter("user_password");
			pwd=md5Java(pwd);
			//-----------------------------------------------------calling function to add user information in database------------------------------------------------------------------------
			u=d.getLoginInfo(Email, pwd);
			
			HttpSession session=request.getSession();
			
			session.setAttribute("user",u);
			if (request.getSession().getAttribute("user") == null) {
			    // Not logged in. Redirect to login page.
			    try {
					
					response.sendRedirect("user/login/login.jsp?msg=1");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			else
			{
				 try {
						response.sendRedirect("user/test/index.jsp");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
			
		
			
		}
		
	}
	
	

	   public static String md5Java(String message){
	        String digest = null;
	    
	            MessageDigest md;
				try {
					md = MessageDigest.getInstance("MD5");
				    byte[] hash = md.digest(message.getBytes("UTF-8"));
			           
		            //converting byte array to Hexadecimal String
		           StringBuilder sb = new StringBuilder(2*hash.length);
		           for(byte b : hash){
		               sb.append(String.format("%02x", b&0xff));
		           }
		          
		           digest = sb.toString();
		          
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        
	        
	        return digest;
	    }



	
	

}
