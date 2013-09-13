
package controller;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import database.userDAO;
import bean.user;
import javax.servlet.http.Part;
@WebServlet("/user_controller")
@MultipartConfig(maxFileSize = 16177215)    // upload file's size up to 16MB
public class user_controller extends HttpServlet{

	
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
		if(userAction.equals("add"))
		{
			
			addUserRedirect(request,response);
			return;
			
		}
		else if(userAction.equals("edit"))
		{
			editUserRedirect(request,response);
			return;
			
		}
		else if(userAction.equals("add_user"))
		{
			Add_UserRedirect(request,response);
			return;
			
		}
		else if(userAction.equals("add_user1"))
		{
			Add_User1Redirect(request,response);
			return;
			
		}
		else
		{
			showUserRedirect(request,response);
			return;
		}
	}
	
	
	private void Add_User1Redirect(HttpServletRequest request,
			HttpServletResponse response) {
try{
			
		
			
			user u=new user();
			userDAO d=new userDAO();
			
			String user_screen_name=request.getParameter("user_screen_name");
			String user_password=request.getParameter("user_password");
			String user_email=request.getParameter("user_email");
		
			String user_first_name=request.getParameter("user_first_name");
			String user_last_name=request.getParameter("user_last_name");
			String user_city=request.getParameter("user_city");
			String user_gender=request.getParameter("user_gender");
			user_password=md5Java(user_password);
			
			
			u.setUser_screen_name(user_screen_name);
			u.setUser_encrypted_password(user_password);
			u.setUser_email(user_email);
		
			u.setUser_first_name(user_first_name);
			u.setUser_last_name(user_last_name);
			u.setUser_city(user_city);
			
			u.setUser_gender(user_gender);
		
			
			
			try {
				d.addUser(u);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			response.sendRedirect("user/login/login.jsp?msg=0");
			
		
		}
		 catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	private void addUserRedirect(HttpServletRequest request,
			HttpServletResponse response) {
		try{
			
		
			
			user u=new user();
			userDAO d=new userDAO();
			
			String user_screen_name=request.getParameter("user_screen_name");
			String user_password=request.getParameter("user_password");
			String user_email=request.getParameter("user_email");
			String user_DOB=request.getParameter("user_DOB");
			String user_first_name=request.getParameter("user_first_name");
			String user_last_name=request.getParameter("user_last_name");
			String user_city=request.getParameter("user_city");
			String user_gender=request.getParameter("user_gender");
			String user_cell_number=request.getParameter("user_cell_number");
			Part filePart = request.getPart("user_profile_picture");
			user_password=md5Java(user_password);
			u.setUser_screen_name(user_screen_name);
			u.setUser_encrypted_password(user_password);
			u.setUser_email(user_email);
			u.setUser_DOB(user_DOB);
			u.setUser_first_name(user_first_name);
			u.setUser_last_name(user_last_name);
			u.setUser_city(user_city);
			u.setUser_cell_number(user_cell_number);
			u.setUser_gender(user_gender);
			u.setUser_profile_picture(filePart);
			
			
			try {
				d.addUser(u);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			response.sendRedirect("admin/user/add_user.jsp?msg=1");
			
		
		}
		 catch (ServletException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	private void Add_UserRedirect(HttpServletRequest request,
			HttpServletResponse response) {
		
			
			try {
				String msg=request.getParameter("msg");
				if(msg==null)
				{
					msg="";
				}
				response.sendRedirect("admin/user/add_user.jsp?msg="+msg);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	
		 
		
	}
	private void showUserRedirect(HttpServletRequest request,
			HttpServletResponse response) {
		
			
			try {
				response.sendRedirect("admin/user/show_user.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
}
	private void editUserRedirect(HttpServletRequest request,
			HttpServletResponse response) {
		try{
			
		
			
			user u=new user();
			userDAO d=new userDAO();
			int user_id=Integer.parseInt(request.getParameter("user_id"));
			String user_screen_name=request.getParameter("user_screen_name");
			String user_password=request.getParameter("user_password");
			user_password=md5Java(user_password);
			String user_email=request.getParameter("user_email");
			String user_DOB=request.getParameter("user_DOB");
			String user_first_name=request.getParameter("user_first_name");
			String user_last_name=request.getParameter("user_last_name");
			String user_city=request.getParameter("user_city");
			String user_gender=request.getParameter("user_gender");
			String user_cell_number=request.getParameter("user_cell_number");
			Part filePart = request.getPart("user_profile_picture");
			if(filePart.getSize()==0)
			{
				filePart=null;
			}
			u.setUser_id(user_id);
			u.setUser_screen_name(user_screen_name);
			u.setUser_encrypted_password(user_password);
			u.setUser_email(user_email);
			u.setUser_DOB(user_DOB);
			u.setUser_first_name(user_first_name);
			u.setUser_last_name(user_last_name);
			u.setUser_city(user_city);
			u.setUser_cell_number(user_cell_number);
			u.setUser_gender(user_gender);
			u.setUser_profile_picture(filePart);
			try {
				d.updateUser(u);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("admin/user/show_user.jsp");
			
		}
		 catch (ServletException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
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
