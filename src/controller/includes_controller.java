
package controller;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import database.includesDAO;
import bean.includes;
@WebServlet("/includes_controller")
public class includes_controller extends HttpServlet{

	
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
		else if(userAction.equals("add_include"))
		{
			Add_IncludeRedirect(request,response);
			return;
			
		}
		else
		{
			showIncludeRedirect(request,response);
			return;
		}
	}
	
	
	private void addUniversityRedirect(HttpServletRequest request,
			HttpServletResponse response) {
		try{
			
		
			int field_id=Integer.parseInt(request.getParameter("field_id"));
			String[] course=request.getParameterValues("course_id");
			int[] course_id = new int[course.length];
			    for (int i=0; i < course.length; i++) {
			        course_id[i] = Integer.parseInt(course[i]);
			    }
			
			includes i=new includes();
			i.setCourse_id(course_id);
			i.setField_id(field_id);
			includesDAO d=new includesDAO();
			try {
				d.addIncludes(i);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("admin/includes/add_includes.jsp?msg=1");
			
		}
		 catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	private void Add_IncludeRedirect(HttpServletRequest request,
			HttpServletResponse response) {
		
			
			try {
				String msg=request.getParameter("msg");
				if(msg==null)
				{
					msg="";
				}
				response.sendRedirect("admin/includes/add_includes.jsp?msg="+msg);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	
		 
		
	}
	private void showIncludeRedirect(HttpServletRequest request,
			HttpServletResponse response) {
		
			
			try {
				response.sendRedirect("admin/includes/show_includes.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
}
	
	
	private void editUniversityRedirect(HttpServletRequest request,
			HttpServletResponse response) {
		try{
			
		
			RequestDispatcher rd=request.getRequestDispatcher("admin/includes/edit_includes_ac.jsp");
			rd.forward(request, response);
		}
		 catch (ServletException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}


	
	

}
