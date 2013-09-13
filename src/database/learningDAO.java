package database;

import bean.*;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;





public class learningDAO implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private Connection con;
	
	public learningDAO()
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
	public ArrayList<Learning> retrieveLearningInfo()
	{
		ArrayList<Learning> LI=new ArrayList<Learning>();
		Database d=new Database();
		
			con=d.connection();
	
		try{
			String sql="Select * from psychologist_learning";
			PreparedStatement stmt=con.prepareStatement(sql);
		
			ResultSet rs=stmt.executeQuery();
			int field_id;
			int total_average;
			int counter_average;

			while(rs.next())
			{
				
				field_id=rs.getInt("field_id");
				total_average=rs.getInt("total_average");
				counter_average=rs.getInt("counter_average");
				
				
				Learning L=new Learning();
				L.setField_id(field_id);
				L.setCounter_average(counter_average);
				L.setTotal_average(total_average);
			
				LI.add(L);
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
		return LI;
		
	}

	//-------------------------------------------------------------Add course--------------------------------------------------------
		public void addUserLearning(Learning L)throws SQLException
		{
			Database d=new Database();
			
				con=d.connection();
			
			try
			{
				int field_id=L.getField_id();
				float counter_average=L.getCounter_average();
				float total_average=L.getTotal_average();
				int counter=L.getCounter();
				int total_rating=L.getTotal_rating();
				int total_user_rating=L.getTotal_user_rating();
				int total_counter_rating=L.getTotal_counter_rating();
				int user_counter_rating=L.getUser_counter_rating();
				int total_counter=L.getTotal_counter();
				
		
			String sql="INSERT INTO user_learning Values (?,?,?,?,?,?,?,?,?)";
			PreparedStatement stmt=con.prepareStatement(sql);
			
			stmt.setInt(1,field_id);
			stmt.setFloat(2,total_average);
			stmt.setFloat(3,counter_average);
			stmt.setInt(4,counter);
			stmt.setInt(5,total_rating);
			stmt.setInt(6,total_user_rating);
			stmt.setInt(7,total_counter_rating);
			stmt.setInt(8,user_counter_rating);
			stmt.setInt(9,total_counter);
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
		//-------------------------------------------------------------Add course--------------------------------------------------------
				public void addPsychologistLearning(Learning L)throws SQLException
				{
					Database d=new Database();
					
						con=d.connection();
			
					try
					{
						int field_id=L.getField_id();
						float counter_average=L.getCounter_average();
						float total_average=L.getTotal_average();
					
						
				
					String sql="INSERT INTO psychologist_learning Values (?,?,?)";
					PreparedStatement stmt=con.prepareStatement(sql);
					
					stmt.setInt(1,field_id);
					stmt.setFloat(2,total_average);
					stmt.setFloat(3,counter_average);
					
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
				
		public Learning getLearningUserInfo(int id)
		{
			Learning l=new Learning();
			Database d=new Database();
		
				con=d.connection();
		
			try{
				String sql="Select * from user_learning where field_id=?";
				
				PreparedStatement stmt=con.prepareStatement(sql);
				stmt.setInt(1,id);
				ResultSet rs=stmt.executeQuery();
				
						int field_id;
						float total_average;
						float counter_average;
						int counter;
						int total_rating;
						int total_user_rating;
						int total_counter_rating;
						int user_counter_rating;
						int total_counter;
						if(!rs.next())
						{
							l=null;
						}
						else
						{
							field_id=rs.getInt("field_id");
							total_average=rs.getFloat("total_average");
							counter_average=rs.getFloat("counter_average");
							total_rating=rs.getInt("total_rating");
							total_user_rating=rs.getInt("user_total_rating");
							total_counter_rating=rs.getInt("total_counter_rating");
							user_counter_rating=rs.getInt("user_counter_rating");
							counter=rs.getInt("counter");
							total_counter=rs.getInt("total_counter");
							l.setField_id(field_id);
							l.setTotal_average(total_average);
							l.setCounter_average(counter_average);
							l.setCounter(counter);
							l.setTotal_rating(total_rating);
							l.setTotal_user_rating(total_user_rating);
							l.setUser_counter_rating(user_counter_rating);
							l.setTotal_counter_rating(total_counter_rating);
							l.setTotal_counter(total_counter);
							
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
			return l;
		}
		//-------------------------------------------------------------update--------------------------------------------------------
		public void updateUserLearning(Learning L)throws SQLException
		{
			Database d=new Database();
		
				con=d.connection();
		
			try
			{
				int field_id=L.getField_id();
				float counter_average=L.getCounter_average();
				float total_average=L.getTotal_average();
				int counter=L.getCounter();
				int total_rating=L.getTotal_rating();
				int total_user_rating=L.getTotal_user_rating();
				int total_counter_rating=L.getTotal_counter_rating();
				int user_counter_rating=L.getUser_counter_rating();
				int total_counter=L.getTotal_counter();
			
			String sql="update user_learning SET field_id=?,total_average=?,counter_average=?,counter=?,total_rating=?,user_total_rating=?,total_counter_rating=?,user_counter_rating=?,total_counter=? where field_id=?";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setInt(1,field_id);
			stmt.setFloat(2,total_average);
			stmt.setFloat(3,counter_average);
			stmt.setInt(4,counter);
			stmt.setInt(5,total_rating);
			stmt.setInt(6,total_user_rating);
			stmt.setInt(7,total_counter_rating);
			stmt.setInt(8,user_counter_rating);
			stmt.setInt(9,total_counter);
			stmt.setInt(10,field_id);
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
		public void deleteLearning()throws SQLException
		{
			Database d=new Database();
			
				con=d.connection();
		
			try
			{
			
			
			String sql="delete from psychologist_learning";
			PreparedStatement stmt=con.prepareStatement(sql);
			
			

			
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



			

