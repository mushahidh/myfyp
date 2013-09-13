
package controller;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import database.universityDAO;
import bean.university;
@WebServlet("/university_controller")
public class university_controller extends HttpServlet{

	
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
		else if(userAction.equals("add_uni"))
		{
			Add_UniRedirect(request,response);
			return;
			
		}
		else
		{
			showUniRedirect(request,response);
			return;
		}
	}
	
	
	
	private void Add_UniRedirect(HttpServletRequest request,
			HttpServletResponse response) {
		
			
			try {
				String msg=request.getParameter("msg");
				if(msg==null)
				{
					msg="";
				}
				response.sendRedirect("admin/university/add_university.jsp?msg="+msg);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	
		 
		
	}
	private void showUniRedirect(HttpServletRequest request,
			HttpServletResponse response) {
		
			
			try {
				response.sendRedirect("admin/university/show_university.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
}

	private void addUniversityRedirect(HttpServletRequest request,
			HttpServletResponse response) {
		try{
				String uni_name=request.getParameter("uni_name");
				String uni_location=request.getParameter("uni_city");
				String uni_address=request.getParameter("uni_address");
				String uni_website=request.getParameter("uni_website");
				String uni_desc=request.getParameter("uni_desc");
				//double uni_longitude=Double.parseDouble(request.getParameter("uni_longitude"));
				//double uni_latitude=Double.parseDouble(request.getParameter("uni_latitude"));
				university u=new university();
				u.setUni_name(uni_name);
				u.setUni_location(uni_location);
				u.setUni_address(uni_address);
				u.setUni_website(uni_website);
				u.setUni_desc(uni_desc);
				//u.setUni_longitude(uni_longitude);
				//u.setUni_latitude(uni_latitude);
				universityDAO d=new universityDAO();
				try {
					d.addUniversity(u);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				response.sendRedirect("admin/university/add_university.jsp?msg=1");
				
		}
		 catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	private void editUniversityRedirect(HttpServletRequest request,
			HttpServletResponse response) {
		try{
			
			int uni_id=Integer.parseInt(request.getParameter("uni_id"));
			String uni_name=request.getParameter("uni_name");
			String uni_location=request.getParameter("uni_city");
			String uni_address=request.getParameter("uni_address");
			String uni_website=request.getParameter("uni_website");
			String uni_desc=request.getParameter("uni_desc");
			
			university u=new university();
			u.setUni_id(uni_id);
			u.setUni_name(uni_name);
			u.setUni_location(uni_location);
			u.setUni_address(uni_address);
			u.setUni_website(uni_website);
			u.setUni_desc(uni_desc);
			
			universityDAO d=new universityDAO();
			try {
				d.updateUniversity(u);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("admin/university/show_university.jsp");
			
		}
	 catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}


	
	

}
