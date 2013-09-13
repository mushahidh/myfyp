
package controller;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import database.groupDAO;
import bean.group;
@WebServlet("/group_controller")
public class group_controller extends HttpServlet{

	
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
			
			addGroupRedirect(request,response);
			return;
			
		}
		if(userAction.equals("edit"))
		{
			editGroupRedirect(request,response);
			return;
			
		}
		else if(userAction.equals("add_group"))
		{
			Add_GroupRedirect(request,response);
			return;
			
		}
		else
		{
			showGroupRedirect(request,response);
			return;
		}
	}
	
	
	private void addGroupRedirect(HttpServletRequest request,
			HttpServletResponse response) {
		try{
			
		
			String group_name=request.getParameter("group_name");
			int group_standard=Integer.parseInt(request.getParameter("group_standard"));
			group g=new group();
			g.setGroup_name(group_name);
			g.setGroup_standard(group_standard);
			groupDAO d=new groupDAO();
			try {
				d.addGroup(g);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("admin/group/add_group.jsp?msg=1");


		}
		 catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	private void Add_GroupRedirect(HttpServletRequest request,
			HttpServletResponse response) {
		
			
			try {
				String msg=request.getParameter("msg");
				if(msg==null)
				{
					msg="";
				}
				response.sendRedirect("admin/group/add_group.jsp?msg="+msg);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	
		 
		
	}
	private void showGroupRedirect(HttpServletRequest request,
			HttpServletResponse response) {
		
			
			try {
				response.sendRedirect("admin/group/show_group.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
}
	
	
	private void editGroupRedirect(HttpServletRequest request,
			HttpServletResponse response) {
		try{
			
		
			int group_id=Integer.parseInt(request.getParameter("group_id"));
			String group_name=request.getParameter("group_name");
			int group_standard=Integer.parseInt(request.getParameter("group_standard"));
			group g=new group();
			g.setGroup_id(group_id);
			g.setGroup_name(group_name);
			g.setGroup_standard(group_standard);
			
			groupDAO d=new groupDAO();
			try {
				d.updateGroup(g);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("admin/group/show_group.jsp");

		}
		 catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}


	
	

}
