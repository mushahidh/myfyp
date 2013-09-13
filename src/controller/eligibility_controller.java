
package controller;
import java.io.IOException;
import java.sql.SQLException;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import database.eligibilityDAO;

import bean.eligibility;

@WebServlet("/eligibility_controller")
public class eligibility_controller extends HttpServlet{

	
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
		else if(userAction.equals("add_elig"))
		{
			Add_EligibilityRedirect(request,response);
			return;
			
		}
		else
		{
			showEligibilityRedirect(request,response);
			return;
		}
	}
	
	
	private void addUniversityRedirect(HttpServletRequest request,
			HttpServletResponse response) {
		try{
			
		
			int field_id=Integer.parseInt(request.getParameter("field_id"));
			String[] required=request.getParameterValues("required_id");
			int[] required_id = new int[required.length];
			    for (int i=0; i < required.length; i++) {
			        required_id[i] = Integer.parseInt(required[i]);
			    }
			
			eligibility e=new eligibility();
			e.setField_id(field_id);
			e.setRequired_id(required_id);
			eligibilityDAO d=new eligibilityDAO();
			try {
				d.addEligibility(e);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			response.sendRedirect("admin/eligibility/add_eligibility.jsp?msg=1");
		
		}
		catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	private void Add_EligibilityRedirect(HttpServletRequest request,
			HttpServletResponse response) {
		
			
			try {
				String msg=request.getParameter("msg");
				if(msg==null)
				{
					msg="";
				}
				response.sendRedirect("admin/eligibility/add_eligibility.jsp?msg="+msg);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	
		 
		
	}
	private void showEligibilityRedirect(HttpServletRequest request,
			HttpServletResponse response) {
		
			
			try {
				response.sendRedirect("admin/eligibility/show_eligibility.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
}
	private void editUniversityRedirect(HttpServletRequest request,
			HttpServletResponse response) {
		try{
			
		
			RequestDispatcher rd=request.getRequestDispatcher("admin/eligibility/edit_eligibility_ac.jsp");
			rd.forward(request, response);
		}
		 catch (ServletException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}


	
	

}
