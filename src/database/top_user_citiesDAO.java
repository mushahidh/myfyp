package database;

import bean.*;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;





public class top_user_citiesDAO implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private Connection con;
	
	public top_user_citiesDAO()
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
	public ArrayList<top_user_cities> retrieveTop_user_citiesInfo()
	{
		ArrayList<top_user_cities> CI=new ArrayList<top_user_cities>();
		Database d=new Database();
		
			con=d.connection();
	
		try{
			String sql="Select * from top_user_cities";
			PreparedStatement stmt=con.prepareStatement(sql);
		
			ResultSet rs=stmt.executeQuery();
			String location;
			double visits;
			double visits_percentage;
			

			while(rs.next())
			{
				
				location=rs.getString("location");
				visits=rs.getDouble("visits");
				visits_percentage=rs.getDouble("visits_percentage");
				
				top_user_cities c=new top_user_cities();
				c.setLocation(location);
				c.setVisits(visits);
				c.setVisits_percentage(visits_percentage);
			
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


		
	
	//-----------------------------------------------------------------End----------------------------------------------------------
		

}



			

