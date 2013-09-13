
package controller;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import database.groupIncludesDAO;
import bean.groupIncludes;

@WebServlet("/group_includes_controller")
public class group_includes_controller extends HttpServlet{

	
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
		else if(userAction.equals("add_group_include"))
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
			
		
			int group_id=Integer.parseInt(request.getParameter("group_id"));
			String[] field=request.getParameterValues("field_id");
			int[] field_id = new int[field.length];
			    for (int i=0; i < field.length; i++) {
			        field_id[i] = Integer.parseInt(field[i]);
			    }
			groupIncludes i=new groupIncludes();
			i.setField_id(field_id);
			i.setGroup_id(group_id);
			groupIncludesDAO d=new groupIncludesDAO();
			try {
				d.addGroupIncludes(i);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("admin/groupIncludes/add_group_includes.jsp?msg=1");
		
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
				response.sendRedirect("admin/groupIncludes/add_group_includes.jsp?msg="+msg);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	
		 
		
	}
	private void showIncludeRedirect(HttpServletRequest request,
			HttpServletResponse response) {
		
			
			try {
				response.sendRedirect("admin/groupIncludes/show_group_includes.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
}
	
	
	private void editUniversityRedirect(HttpServletRequest request,
			HttpServletResponse response) {
		try{
			
		
			RequestDispatcher rd=request.getRequestDispatcher("admin/groupIncludes/edit_group_includes_ac.jsp");
			rd.forward(request, response);
		}
		 catch (ServletException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}


	
	

}
