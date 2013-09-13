package database;

import bean.*;
import java.io.*;
import java.sql.*;






public class audience_reachDAO implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private Connection con;
	
	public audience_reachDAO()
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
	public audience_reach retrieveAudience_reachInfo()
	{
		
		Database d=new Database();
		
		con=d.connection();
	
		audience_reach a=new audience_reach();
		try{
			String sql="Select * from audience_reach";
			PreparedStatement stmt=con.prepareStatement(sql);
		
			ResultSet rs=stmt.executeQuery();
		
			double audience_reach;
			double ctr_average;

			while(rs.next())
			{
				
				
				audience_reach=rs.getDouble("audience_reach");
				ctr_average=rs.getDouble("average_ctr");
			
				a.setAudience_reach(audience_reach);
				a.setCtr_average(ctr_average);
				
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
		return a;
	}


		
	
	//-----------------------------------------------------------------End----------------------------------------------------------
		

}



			

