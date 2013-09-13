package database;

import bean.*;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;



public class includesDAO implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private Connection con;
	
	public includesDAO()
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
	//----------------------------------------Retrieve includes info----------------------------
	public ArrayList<includes> retrieveIncludesInfo( int field)
	{
		ArrayList<includes> EI=new ArrayList<includes>();
		Database d=new Database();
		
			con=d.connection();
		
		try{
			String sql="Select * from includes where field_id=?";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setInt(1, field);
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
	//----------------------------------------Retrieve includes info----------------------------
	public ArrayList<includes> retrieveIncludesInfo()
	{
		ArrayList<includes> EI=new ArrayList<includes>();
		Database d=new Database();
		
			con=d.connection();
	
		try{
			String sql="Select * from includes";
			PreparedStatement stmt=con.prepareStatement(sql);
		
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

	//-------------------------------------------------------------Add includes--------------------------------------------------------
		public void addIncludes(includes e)throws SQLException
		{
			Database d=new Database();
			
				con=d.connection();
		
			try
			{
			int field_id=e.getField_id();
			int [] course_id=e.getCourse_id();
			int size = course_id.length;
			System.out.println(size);
			int field;
			int course;
			
			String sql1="select * from field where field_id= ?";
			PreparedStatement stmt1=con.prepareStatement(sql1);
			stmt1.setInt(1,field_id);
			ResultSet rs=stmt1.executeQuery();
			rs.next();
			field=rs.getInt("field_id");
			for(int i=0;i<size;i++)
			{	
		
				
				String sql2="Select * from course where course_id=?";
				PreparedStatement stmt2=con.prepareStatement(sql2);
				stmt2.setInt(1,course_id[i]);
				ResultSet rs1=stmt2.executeQuery();
				rs1.next();
				course=rs1.getInt("course_id");	
				String sql="INSERT INTO includes Values (?,?)";
				PreparedStatement stmt=con.prepareStatement(sql);
				stmt.setInt(1,field);
				stmt.setInt(2,course);
				stmt.executeUpdate();
			}
			}
			catch(Exception er)
			{
				er.printStackTrace();
			}
			finally
			{
				d.getResource();
			}
		
			
		}
//-------------------------------------------------------------get field data------------------------------------------------------
		
		public includes getIncludesInfo(int id)
		{
			Database d=new Database();
			
				con=d.connection();
		
			includes el=new includes();
			
			try{
				String sql="Select * from includes where field_id=?";
				
				PreparedStatement stmt=con.prepareStatement(sql);
				stmt.setInt(1,id);
				ResultSet rs=stmt.executeQuery();
				
				int field_id;
				int course_id;
				rs.next();
					
					field_id=rs.getInt("field_id");
					course_id=rs.getInt("course_id");
					el.setField_id(field_id);
					el.setCourse_idd(course_id);
					
					}
			
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				d.getResource();
			}
			return el;
		}
		//-------------------------------------------------------------update--------------------------------------------------------
		public void updateIncludes(includes e)throws SQLException
		{
			Database d=new Database();
			
				con=d.connection();
		
			try
			{
			int field_id=e.getField_id();
			int course_id=e.getCourse_idd();
			int field;
			int course;
			String sql1="select * from field where field_id= ?";
			PreparedStatement stmt1=con.prepareStatement(sql1);
			stmt1.setInt(1,field_id);
			ResultSet rs=stmt1.executeQuery();
			rs.next();
			field=rs.getInt("field_id");
			
			String sql2="Select * from course where course_id=?";
			PreparedStatement stmt2=con.prepareStatement(sql2);
			stmt2.setInt(1,course_id);
			ResultSet rs1=stmt2.executeQuery();
			rs1.next();
			course=rs1.getInt("field_id");
			
			String sql="update includes SET field_id=?,course_id=? where field_id=?";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setInt(1,field);
			stmt.setInt(2,course);
			stmt.setInt(3,field_id);
			stmt.executeUpdate();
			}
			catch(Exception er)
			{
				er.printStackTrace();
			}
			finally
			{
				d.getResource();
			}
			
		}
	
		//--------------------------------------------------------------delete-------------------------------------------------------
		public void deleteIncludes(includes i)throws SQLException
		{
			Database d=new Database();
			
				con=d.connection();
		
			try
			{
			int id=i.getField_id();
			int course_id=i.getCourse_idd();
			String sql="delete from includes where field_id=? AND course_id=?";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setInt(1,id);
			stmt.setInt(2,course_id);
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



			

