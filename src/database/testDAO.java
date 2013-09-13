package database;

import bean.*;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





public class testDAO implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private Connection con;
	
	public testDAO()
	{
		//connection();
	}
	public void connection()
	{
		String url="jdbc:mysql://localhost:3306/fyp";
		String uName="root";
		String pwd="root";
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con=DriverManager.getConnection(url,uName,pwd);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	public void getResource()
	{
		 try {
				con.close();
			} catch (SQLException e) {
				
				
			}
	}
	//----------------------------------------Retrieve testDAO info----------------------------
	public ArrayList<includes> retrieveIncludesInfo(int field_idd)
	{
		ArrayList<includes> EI=new ArrayList<includes>();
		Database d=new Database();
		
			con=d.connection();
		
		try{
			String sql="Select * from includes where field_id=?";
		
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setInt(1, field_idd);
			ResultSet rs=stmt.executeQuery();
			int field_id;
			int course_id;
			while(rs.next())
			{
				
				field_id=rs.getInt("field_id");
				course_id=rs.getInt("course_id");
			
				includes e=new includes();
				e.setField_id(field_id);
				e.setCourse_idd(course_id);
				
				EI.add(e);
			}
		
					
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			d.getResource();
		}
		return EI;
		
	}

	


//----------------------------------------------------------Inserting Test Data in database--------------------------------------------------

public void addTestInfo(HttpServletRequest request,HttpServletResponse response)
{
	int user_standard=Integer.parseInt(request.getParameter("user_grade"));
	System.out.println(user_standard);
	String user_field=request.getParameter("user_field");
	System.out.println(user_field);
	int nts=Integer.parseInt(request.getParameter("NTS"));
	System.out.println(nts);
	

}
//----------------------------------------------------------Class End-----------------------------------------------------------------------
}


			

