
package controller;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import database.fieldDAO;

import bean.field;

@WebServlet("/field_controller")
public class field_controller extends HttpServlet{

	
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
		else if(userAction.equals("add_field"))
		{
			Add_FieldRedirect(request,response);
			return;
		}
		else
		{
			showFieldRedirect(request,response);
			return;
		}
	}
	
	
	private void addUniversityRedirect(HttpServletRequest request,
			HttpServletResponse response) {
		try{
			
		
			
			String field_name=request.getParameter("field_name");
			String field_desc=request.getParameter("field_desc");
			int field_standard=Integer.parseInt(request.getParameter("field_standard"));
			field f=new field();
			f.setField_name(field_name);
			f.setField_desc(field_desc);
			f.setField_standard(field_standard);
			fieldDAO d=new fieldDAO();
			try {
				d.addField(f);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("admin/field/add_field.jsp?msg=1");
		
		}
		 catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	private void Add_FieldRedirect(HttpServletRequest request,
			HttpServletResponse response) {
		
			
			try {
				String msg=request.getParameter("msg");
				if(msg==null)
				{
					msg="";
				}
				response.sendRedirect("admin/field/add_field.jsp?msg="+msg);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	
		 
		
	}
	private void showFieldRedirect(HttpServletRequest request,
			HttpServletResponse response) {
		
			
			try {
				response.sendRedirect("admin/field/show_field.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
}
	private void editUniversityRedirect(HttpServletRequest request,
			HttpServletResponse response) {
		try{
			
			int field_id=Integer.parseInt(request.getParameter("field_id"));
			String field_name=request.getParameter("field_name");
			String field_desc=request.getParameter("field_desc");
			int field_standard=Integer.parseInt(request.getParameter("field_standard"));
			field f=new field();
			f.setField_name(field_name);
			f.setField_desc(field_desc);
			f.setField_standard(field_standard);
			f.setField_id(field_id);
			
			fieldDAO d=new fieldDAO();
			try {
				d.updateField(f);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("admin/field/show_field.jsp");

		}
		 catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}


	
	

}
