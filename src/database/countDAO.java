package database;

import bean.*;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;





public class countDAO implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private Connection con;
	
	public countDAO()
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
	//----------------------------------------Retrieve count info----------------------------
	public ArrayList<affect> retrieveAffectInfo()
	{
		Database d=new Database();
		
			con=d.connection();
	
		ArrayList<affect> AI=new ArrayList<affect>();
	
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

	//-------------------------------------------------------------Add count--------------------------------------------------------
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
		
			
		
		//-------------------------------------------------------------get count data------------------------------------------------------
		
		public int getTestCountInfo()
		{
			Database d=new Database();
			
				con=d.connection();
		
			int count = 0;
			try{
				String sql="Select * from test_page_count ";
				PreparedStatement stmt=con.prepareStatement(sql);
				ResultSet rs=stmt.executeQuery();
				if(!rs.next())
				{
					
				}
				else
				{
					count=rs.getInt("test_page_clickcount");
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
			return count;
		}
		//-------------------------------------------------------------update--------------------------------------------------------
		public void updateTestCount(testCount t)throws SQLException
		{
			Database d=new Database();
			
				con=d.connection();
	
			try
			{
				int count=t.getCount();
				if(count==1)
				{
					String sql="INSERT INTO test_page_count Values (?)";
					PreparedStatement stmt=con.prepareStatement(sql);
					stmt.setInt(1,count);
					stmt.executeUpdate();
				}
				else
				{
					String sql="update test_page_count SET test_page_clickcount=?";
					PreparedStatement stmt=con.prepareStatement(sql);
					stmt.setInt(1,count);	
					stmt.executeUpdate();
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



			

