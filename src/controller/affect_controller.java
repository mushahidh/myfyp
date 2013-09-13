
package controller;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.affectDAO;

import bean.affect;

@WebServlet("/affect_controller")
public class affect_controller extends HttpServlet{

	
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
			
			addAffectRedirect(request,response);
			return;
			
		}
		if(userAction.equals("edit"))
		{
			editAffectRedirect(request,response);
			return;
			
		}
		else if(userAction.equals("add_affect"))
		{
			Add_AffectRedirect(request,response);
			return;
			
		}
		else
		{
			showAffectRedirect(request,response);
			return;
		}
	}
	
	
	private void addAffectRedirect(HttpServletRequest request,
			HttpServletResponse response) {
		try{
			
		
			int field_id=Integer.parseInt(request.getParameter("field_id"));
			int course_id=Integer.parseInt(request.getParameter("course_id"));
			int weight=Integer.parseInt(request.getParameter("weight"));
			affect a=new affect();
			a.setCourse_id(course_id);
			a.setField_id(field_id);
			a.setWeight(weight);
			affectDAO d=new affectDAO();
			try {
				d.addAffect(a);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("psychologist/affect/add_affect.jsp?msg=1");
			
			
		}
		catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	private void Add_AffectRedirect(HttpServletRequest request,
			HttpServletResponse response) {
		
			
			try {
				String msg=request.getParameter("msg");
				if(msg==null)
				{
					msg="";
				}
				response.sendRedirect("psychologist/affect/add_affect.jsp?msg="+msg);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	
		 
		
	}
	private void showAffectRedirect(HttpServletRequest request,
			HttpServletResponse response) {
		
			
			try {
				response.sendRedirect("psychologist/affect/show_affect.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
}
	
	
	private void editAffectRedirect(HttpServletRequest request,
			HttpServletResponse response) {
		try{
			
		
			int field_id=Integer.parseInt(request.getParameter("field_id"));
			int course_id=Integer.parseInt(request.getParameter("course_id"));
			int weight=Integer.parseInt(request.getParameter("weight"));
			affect a=new affect();
			a.setCourse_id(course_id);
			a.setField_id(field_id);
			a.setWeight(weight);
			affectDAO d=new affectDAO();
			try {
				d.updateAffect(a);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("psychologist/affect/show_affect.jsp");

		}
		catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}


	
	

}
