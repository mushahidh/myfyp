package database;

import bean.*;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;

public class affectDAO implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private Connection con;
	
	public affectDAO()
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
	public ArrayList<affect> retrieveAffectInfo()
	{
		ArrayList<affect> AI=new ArrayList<affect>();
		Database d=new Database();
	
			con=d.connection();
	
		try{
			String sql="Select * from affect";
			PreparedStatement stmt=con.prepareStatement(sql);
		
			ResultSet rs=stmt.executeQuery();
			int field_id;
			int course_id;
			int weight;
			while(rs.next())
			{
				
				field_id=rs.getInt("field_id");
				course_id=rs.getInt("course_id");
				weight=rs.getInt("weight");
			
				affect a=new affect();
				a.setField_id(field_id);
				a.setCourse_id(course_id);
				a.setWeight(weight);
				
				AI.add(a);
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
		return AI;
		
	}
	//----------------------------------------Retrieve includes info----------------------------
		public ArrayList<affect> retrieveAffectInfo(int course)
		{
			ArrayList<affect> AI=new ArrayList<affect>();
			Database d=new Database();
			
				con=d.connection();
			
			try{
				String sql="Select * from affect Where course_id=?";
				PreparedStatement stmt=con.prepareStatement(sql);
				stmt.setInt(1, course);
				ResultSet rs=stmt.executeQuery();
				int field_id;
				int course_id;
				int weight;
				while(rs.next())
				{
					
					field_id=rs.getInt("field_id");
					course_id=rs.getInt("course_id");
					weight=rs.getInt("weight");
				
					affect a=new affect();
					a.setField_id(field_id);
					a.setCourse_id(course_id);
					a.setWeight(weight);
					
					AI.add(a);
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
			return AI;
			
		}

	//-------------------------------------------------------------Add includes--------------------------------------------------------
		public void addAffect(affect a)throws SQLException
		{
			Database d=new Database();
			
				con=d.connection();
			
			try
			{
				int field_id=a.getField_id();
			int course_id=a.getCourse_id();
			int weight=a.getWeight();
			String sql="INSERT INTO affect Values (?,?,?)";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setInt(1,field_id);
			stmt.setInt(2,course_id);
			stmt.setInt(3,weight);
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
		
			
		
		//-------------------------------------------------------------get field data------------------------------------------------------
		
		public affect getAffectInfo(int field_idd,int course_idd)
		{
			affect a=new affect();
			Database d=new Database();
			
				con=d.connection();
	
			try{
				String sql="Select * from affect where field_id=? AND course_id=?";
				
				PreparedStatement stmt=con.prepareStatement(sql);
				stmt.setInt(1,field_idd);
				stmt.setInt(2,course_idd);
				ResultSet rs=stmt.executeQuery();
				
				int field_id;
				int course_id;
				int weight;
				rs.next();
					
					field_id=rs.getInt("field_id");
					course_id=rs.getInt("course_id");
					weight=rs.getInt("weight");
					
					a.setField_id(field_id);
					a.setCourse_id(course_id);
					a.setWeight(weight);
					
					}
			
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				d.getResource();
			}
			return a;
		}
		//-------------------------------------------------------------update--------------------------------------------------------
		public void updateAffect(affect a)throws SQLException
		{
			Database d=new Database();
		
				con=d.connection();
		
			try
			{
				int field_id=a.getField_id();
			
			int course_id=a.getCourse_id();
			int weight=a.getWeight();
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
			course=rs1.getInt("course_id");
			
			String sql="update affect SET field_id=?,course_id=?,weight=? where field_id=? AND course_id=?";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setInt(1,field);
			stmt.setInt(2,course);
			stmt.setInt(3,weight);
			stmt.setInt(4,field_id);
			stmt.setInt(5,course_id);
			
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
		public void deleteAffect(affect a)throws SQLException
		{
			Database d=new Database();
			
				con=d.connection();
			
			try
			{
			int id=a.getField_id();
			int course_id=a.getCourse_id();
			
			String sql="delete from affect where field_id=? AND course_id=?";
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



			

