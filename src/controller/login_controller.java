
package controller;
import java.io.IOException;
import database.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import bean.admin;
@WebServlet("/login_controller")
public class login_controller extends HttpServlet{

	
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
		if(userAction.equals("Login"))
		{
			
			adminLoginDAO d=new adminLoginDAO();
			admin a=new admin();
			String Email=request.getParameter("user_email");
			String pwd=request.getParameter("user_password");
			
			//-----------------------------------------------------calling function to add user information in database------------------------------------------------------------------------
			
			a=d.getLoginInfo(Email, pwd);
			
			HttpSession session=request.getSession();
			
			session.setAttribute("admin",a);
			
			if (request.getSession().getAttribute("admin") == null) {
			    // Not logged in. Redirect to login page.
			    try {
					response.sendRedirect("admin/login/login.jsp?msg=1");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			else
			{
				 try {
						response.sendRedirect("admin/index/index.jsp");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
			
		
			
		}
		
	}
	
	



	
	

}
