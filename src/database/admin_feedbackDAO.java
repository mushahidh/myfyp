package database;

import bean.*;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;





public class admin_feedbackDAO implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private Connection con;
	
	public admin_feedbackDAO()
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
	public ArrayList<admin_feedback> retrieveAdmin_feedbackInfo()
	{
		ArrayList<admin_feedback> AF=new ArrayList<admin_feedback>();
		Database d=new Database();
	
			con=d.connection();
	
		try{
			String sql="Select * from admin_feedback";
			PreparedStatement stmt=con.prepareStatement(sql);
		
			ResultSet rs=stmt.executeQuery();
			int user_id;
			String user_name;
			String user_message;

			while(rs.next())
			{
				
				user_id=rs.getInt("user_id");
				user_name=rs.getString("user_name");
				user_message=rs.getString("user_message");
				admin_feedback af=new admin_feedback();
				af.setUser_id(user_id);
				af.setUser_name(user_name);
				af.setUser_message(user_message);
			
				AF.add(af);
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
		return AF;
		
	}

	public ArrayList<admin_feedback> retrievePsychologist_feedbackInfo()
	{
		ArrayList<admin_feedback> AF=new ArrayList<admin_feedback>();
		Database d=new Database();
		
		con=d.connection();
		try{
			String sql="Select * from psychologist_feedback";
			PreparedStatement stmt=con.prepareStatement(sql);
		
			ResultSet rs=stmt.executeQuery();
			int user_id;
			String user_name;
			String user_message;

			while(rs.next())
			{
				
				user_id=rs.getInt("user_id");
				user_name=rs.getString("user_name");
				user_message=rs.getString("user_message");
				admin_feedback af=new admin_feedback();
				af.setUser_id(user_id);
				af.setUser_name(user_name);
				af.setUser_message(user_message);
			
				AF.add(af);
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
		return AF;
		
	}


	public void addAdmin_feedback(admin_feedback1 a)throws SQLException
	{
		Database d=new Database();
		
		con=d.connection();
		try
		{
		int user_id=a.getUser_id();
		String name=a.getName();
		String subject=a.getSubject();
		String email=a.getEmail();
		String message=a.getMessage();
		String sql="INSERT INTO admin_feedback Values (?,?,?)";
		PreparedStatement stmt=con.prepareStatement(sql);
		stmt.setInt(1,user_id);
		stmt.setString(2,name);
		stmt.setString(3,message);
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
	
		
	public void addPsychologist_feedback(admin_feedback1 a)throws SQLException
	{
		Database d=new Database();
		
		con=d.connection();
		try
		{
		int user_id=a.getUser_id();
		String name=a.getName();
		String subject=a.getSubject();
		String email=a.getEmail();
		String message=a.getMessage();
		String sql="INSERT INTO psychologist_feedback Values (?,?,?)";
		PreparedStatement stmt=con.prepareStatement(sql);
		stmt.setInt(1,user_id);
		stmt.setString(2,name);
		stmt.setString(3,message);
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



			

