
package controller;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;





import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import bean.admin_feedback1;

import database.admin_feedbackDAO;



@WebServlet("/admin_feedback_controller")

public class admin_feedback_controller extends HttpServlet{

	
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
			
			addAdminFeedbackRedirect(request,response);
			return;
			
		}
		else
		{
			addPsychologistFeedbackRedirect(request,response);
			return;
			
		}
		
	}
	
	
	private void addAdminFeedbackRedirect(HttpServletRequest request,
			HttpServletResponse response) {
		try{
			
			
			String name=request.getParameter("name");
			String subject=request.getParameter("subject");
			String email=request.getParameter("email");
			String message=request.getParameter("message");
			int user_id=Integer.parseInt(request.getParameter("user_id"));
			
			admin_feedback1 a=new admin_feedback1();
			a.setUser_id(user_id);
			a.setName(name);
			a.setSubject(subject);
			a.setEmail(email);
			a.setMessage(message);
			admin_feedbackDAO d=new admin_feedbackDAO();
			try {
				d.addAdmin_feedback(a);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("user/test/feedback_admin.jsp");


		}
		 catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	private void addPsychologistFeedbackRedirect(HttpServletRequest request,
			HttpServletResponse response) {
		try{
			
		
			String name=request.getParameter("name");
			String subject=request.getParameter("subject");
			String email=request.getParameter("email");
			String message=request.getParameter("message");
			int user_id=Integer.parseInt(request.getParameter("user_id"));
			
			admin_feedback1 a=new admin_feedback1();
			a.setUser_id(user_id);
			a.setName(name);
			a.setSubject(subject);
			a.setEmail(email);
			a.setMessage(message);
			admin_feedbackDAO d=new admin_feedbackDAO();
			try {
				d.addPsychologist_feedback(a);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("user/test/feedback_psychologist.jsp");


		}
		 catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	


	
	

}
