
package controller;
import bean.*;

import java.io.IOException;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/weight_servlet")
public class weight_servlet extends HttpServlet{

	
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
		
		String userAction=request.getParameter("action");
		if(userAction.equals("Submit Credentials"))
		{
			credentialProcessing(request,response);
			return;
			
		}
		else if(userAction.equals("Submit Values"))
		{
			enjoymentProcessing(request,response);
			return;
			
		}
	
		
		
		
	}


	

	private void credentialProcessing(HttpServletRequest request,
			HttpServletResponse response) {
		
		algo a=new algo();
		a.calculator_course( request,response);
		try{
			
			
			RequestDispatcher rd=request.getRequestDispatcher("admin/test/enjoyment.jsp");
			rd.forward(request, response);
		}
		 catch (ServletException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	
		
	}
	
	private void enjoymentProcessing(HttpServletRequest request,
			HttpServletResponse response) {
		
		algo a=new algo();
		a.calculator_course( request,response);
		try{
			
			
			RequestDispatcher rd=request.getRequestDispatcher("admin/test/enjoyment.jsp");
			rd.forward(request, response);
		}
		 catch (ServletException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	
		
	}


}
