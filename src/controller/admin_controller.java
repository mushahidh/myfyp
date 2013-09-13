
package controller;
import java.io.IOException;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/admin_controller")
@MultipartConfig(maxFileSize = 16177215)    // upload file's size up to 16MB
public class admin_controller extends HttpServlet{

	
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
		else
		{
			showUserRedirect(request,response);
			return;
		}
	}
	
	
	private void addUserRedirect(HttpServletRequest request,
			HttpServletResponse response) {
		try{
			
		
			RequestDispatcher rd=request.getRequestDispatcher("admin/admin/add_user_ac.jsp");
			rd.forward(request, response);
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
				response.sendRedirect("admin/admin/add_user.jsp?msg="+msg);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	
		 
		
	}
	private void showUserRedirect(HttpServletRequest request,
			HttpServletResponse response) {
		
			
			try {
				response.sendRedirect("admin/admin/show_user.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
}
	private void editUserRedirect(HttpServletRequest request,
			HttpServletResponse response) {
		try{
			
		
			RequestDispatcher rd=request.getRequestDispatcher("admin/admin/edit_user_ac.jsp");
			rd.forward(request, response);
		}
		 catch (ServletException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}


	
	

}
