package database;

import bean.*;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;





public class courseDAO implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private Connection con;
	
	public courseDAO()
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
	//----------------------------------------Retrieve student info----------------------------
	public ArrayList<course> retrieveCourseInfo()
	{
		ArrayList<course> CI=new ArrayList<course>();
		Database d=new Database();
		
			con=d.connection();
	
		try{
			String sql="Select * from course";
			PreparedStatement stmt=con.prepareStatement(sql);
		
			ResultSet rs=stmt.executeQuery();
			int course_id;
			String course_name;

			while(rs.next())
			{
				
				course_id=rs.getInt("course_id");
				course_name=rs.getString("course_name");
				
				course c=new course();
				c.setCourse_id(course_id);
				c.setCourse_name(course_name);
			
				CI.add(c);
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
		return CI;
		
	}

	//-------------------------------------------------------------Add course--------------------------------------------------------
		public void addCourse(course C)throws SQLException
		{
			Database d=new Database();
			
				con=d.connection();
		
			try
			{
			String course_name=C.getCourse_name();
		
			String sql="INSERT INTO course Values (null,?)";
			PreparedStatement stmt=con.prepareStatement(sql);
			
			stmt.setString(1,course_name);
			stmt.executeUpdate();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				d.getResource();
			}
		}
		//-------------------------------------------------------------get course data------------------------------------------------------
		
		public course getCourseInfo(int id)
		{
			course c=new course();
			Database d=new Database();
			
				con=d.connection();
		
			try{
				String sql="Select * from course where course_id=?";
				
				PreparedStatement stmt=con.prepareStatement(sql);
				stmt.setInt(1,id);
				ResultSet rs=stmt.executeQuery();
				
				int course_id;
				String course_name;
			
				rs.next();
					
					course_id=rs.getInt("course_id");
					course_name=rs.getString("course_name");
				
					c.setCourse_id(course_id);
					c.setCourse_name(course_name);
					
					
					}
			
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				d.getResource();
			}
			return c;
		}
		//-------------------------------------------------------------update--------------------------------------------------------
		public void updateCourse(course c)throws SQLException
		{
			Database d=new Database();
			
				con=d.connection();
		
			try
			{
			int course_id=c.getCourse_id();
			String course_name=c.getCourse_name();
			
			String sql="update course SET course_id=?,course_name=? where course_id=?";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setInt(1,course_id);
			stmt.setString(2,course_name);
			stmt.setInt(3,course_id);
			
			stmt.executeUpdate();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				d.getResource();
			}
			
		}
	
		//--------------------------------------------------------------delete-------------------------------------------------------
		public void deleteCourse(course c)throws SQLException
		{
			Database d=new Database();
			
				con=d.connection();
		
			try
			{
			int id=c.getCourse_id();
			
			String sql="delete from course where course_id=?";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setInt(1,id);
			

			
			stmt.executeUpdate();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				d.getResource();
			}
			
		}
		
	
	//-----------------------------------------------------------------End----------------------------------------------------------
		

}



			

