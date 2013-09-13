
package controller;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import database.courseDAO;

import bean.course;

@WebServlet("/course_controller")
public class course_controller extends HttpServlet{

	
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
			
			addUniversityRedirect(request,response);
			return;
			
		}
		if(userAction.equals("edit"))
		{
			editUniversityRedirect(request,response);
			return;
			
		}
		else if(userAction.equals("add_course"))
		{
			Add_CourseRedirect(request,response);
			return;
			
		}
		else
		{
			showCourseRedirect(request,response);
			return;
		}
	}
	
	
	private void addUniversityRedirect(HttpServletRequest request,
			HttpServletResponse response) {
		try{
			
		
			String course_name=request.getParameter("course_name");
			course c=new course();
			c.setCourse_name(course_name);
			courseDAO d=new courseDAO();
			try {
				d.addCourse(c);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("admin/course/add_course.jsp?msg=1");
		
		}
		catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	private void Add_CourseRedirect(HttpServletRequest request,
			HttpServletResponse response) {
		
			
			try {
				String msg=request.getParameter("msg");
				if(msg==null)
				{
					msg="";
				}
				response.sendRedirect("admin/course/add_course.jsp?msg="+msg);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	
		 
		
	}
	private void showCourseRedirect(HttpServletRequest request,
			HttpServletResponse response) {
		
			
			try {
				response.sendRedirect("admin/course/show_course.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
}
	
	private void editUniversityRedirect(HttpServletRequest request,
			HttpServletResponse response) {
		try{
			
		
			String course_name=request.getParameter("course_name");
			int course_id=Integer.parseInt(request.getParameter("course_id"));
			course c=new course();
			c.setCourse_name(course_name);
			c.setCourse_id(course_id);
			courseDAO d=new courseDAO();
			try {
				d.updateCourse(c);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("admin/course/show_course.jsp");
			
		}
		 catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}


	
	

}
