
package controller;
import java.io.IOException;
import java.sql.SQLException;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.groupDAO;
import database.interestDAO;

import bean.group;
import bean.interest;

@WebServlet("/interest_controller")
public class interest_controller extends HttpServlet{

	
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
			
			addInterestRedirect(request,response);
			return;
			
		}
		if(userAction.equals("edit"))
		{
			editInterestRedirect(request,response);
			return;
			
		}
		else if(userAction.equals("add_interest"))
		{
			Add_InterestRedirect(request,response);
			return;
			
		}
		else
		{
			showInterestRedirect(request,response);
			return;
		}
	}
	
	
	private void addInterestRedirect(HttpServletRequest request,
			HttpServletResponse response) {
		try{
			
		
			int field_id=Integer.parseInt(request.getParameter("field_id"));
			int artistic=Integer.parseInt(request.getParameter("artistic"));
			int conventional=Integer.parseInt(request.getParameter("conventional"));
			int enterprising=Integer.parseInt(request.getParameter("enterprising"));
			int realistic=Integer.parseInt(request.getParameter("realistic"));
			int investigative=Integer.parseInt(request.getParameter("investigative"));
			int social=Integer.parseInt(request.getParameter("social"));
			interest i=new interest();
			i.setField_id(field_id);
			i.setArtistic(artistic);
			i.setConventional(conventional);
			i.setEnterprising(enterprising);
			i.setInvestigative(investigative);
			i.setRealistic(realistic);
			i.setSocial(social);
			interestDAO d=new interestDAO();
			try {
				d.addInterest(i);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("psychologist/interest/add_interest.jsp?msg=1");
			
		}
		catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	private void Add_InterestRedirect(HttpServletRequest request,
			HttpServletResponse response) {
		
			
			try {
				String msg=request.getParameter("msg");
				if(msg==null)
				{
					msg="";
				}
				response.sendRedirect("psychologist/interest/add_interest.jsp?msg="+msg);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	
		 
		
	}
	private void showInterestRedirect(HttpServletRequest request,
			HttpServletResponse response) {
		
			
			try {
				response.sendRedirect("psychologist/interest/show_interest.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
}
	
	private void editInterestRedirect(HttpServletRequest request,
			HttpServletResponse response) {
		try{
			
			
			int field_id=Integer.parseInt(request.getParameter("field_id"));
			int realistic=Integer.parseInt(request.getParameter("realistic"));
			int social=Integer.parseInt(request.getParameter("social"));
			int enterprising=Integer.parseInt(request.getParameter("enterprising"));
			int conventional=Integer.parseInt(request.getParameter("conventional"));
			int investigative=Integer.parseInt(request.getParameter("investigative"));
			int artistic=Integer.parseInt(request.getParameter("artistic"));
			
			interest i=new interest();
			i.setField_id(field_id);
			i.setArtistic(artistic);
			i.setConventional(conventional);
			i.setEnterprising(enterprising);
			i.setInvestigative(investigative);
			i.setRealistic(realistic);
			i.setSocial(social);
			
			interestDAO d=new interestDAO();
			try {
				d.updateInterest(i);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("psychologist/interest/show_interest.jsp");

		}
		 catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}


	
	

}
