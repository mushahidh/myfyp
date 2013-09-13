package database;

import bean.*;
import java.io.*;
import java.sql.*;






public class total_clicksDAO implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private Connection con;
	
	public total_clicksDAO()
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
	public total_clicks retrieveTotal_clicksInfo()
	{
		
		Database d=new Database();
		
			con=d.connection();
	
		total_clicks t=new total_clicks();
		try{
			String sql="Select * from total_clicks";
			PreparedStatement stmt=con.prepareStatement(sql);
		
			ResultSet rs=stmt.executeQuery();
		
			double total_clicks;
			double total_impressions;

			while(rs.next())
			{
				
				
				total_clicks=rs.getDouble("total_clicks");
				total_impressions=rs.getDouble("total_impressions");
			
				t.setTotal_clicks(total_clicks);
				t.setTotal_impressions(total_impressions);
				
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
		return t;
	}


		
	
	//-----------------------------------------------------------------End----------------------------------------------------------
		

}



			

