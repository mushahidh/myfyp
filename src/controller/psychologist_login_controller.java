
package controller;
import java.io.IOException;
import database.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import bean.psychologist;
@WebServlet("/psychologist_login_controller")
public class psychologist_login_controller extends HttpServlet{

	
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
			
			psychologistLoginDAO d=new psychologistLoginDAO();
			psychologist p=new psychologist();
			String Email=request.getParameter("user_email");
			String pwd=request.getParameter("user_password");
			//-----------------------------------------------------calling function to add user information in database------------------------------------------------------------------------
			p=d.getLoginInfo(Email, pwd);
			
			HttpSession session=request.getSession();
			
			session.setAttribute("psychologist",p);
			if (request.getSession().getAttribute("psychologist") == null) {
			    // Not logged in. Redirect to login page.
			    try {
					response.sendRedirect("psychologist/login/login.jsp?msg=1");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			else
			{
				 try {
						response.sendRedirect("psychologist/index/index.jsp");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
			
		
			
		}
		
	}
	
	



	
	

}
