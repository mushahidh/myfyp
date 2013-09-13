package database;

import bean.*;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;





public class top_userDAO implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private Connection con;
	
	public top_userDAO()
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
	public ArrayList<top_user> retrieveTop_userInfo()
	{
		ArrayList<top_user> TU=new ArrayList<top_user>();
		Database d=new Database();
		
			con=d.connection();
	
		try{
			String sql="Select * from top_users";
			PreparedStatement stmt=con.prepareStatement(sql);
		
			ResultSet rs=stmt.executeQuery();
			int user_id;
			double user_clicks;
			double total_percentage;
			String user_name;

			while(rs.next())
			{
				
				user_id=rs.getInt("user_id");
				user_clicks=rs.getDouble("user_clicks");
				total_percentage=rs.getDouble("total_percentage");
				user_name=rs.getString("user_name");
				top_user tu=new top_user();
				tu.setTotal_percentage(total_percentage);
				tu.setUser_clicks(user_clicks);
				tu.setUser_id(user_id);
				tu.setUser_name(user_name);
				TU.add(tu);
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
		return TU;
		
	}


		
	
	//-----------------------------------------------------------------End----------------------------------------------------------
		

}



			

