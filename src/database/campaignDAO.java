package database;

import bean.*;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;





public class campaignDAO implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private Connection con;
	
	public campaignDAO()
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
	public ArrayList<campaign> retrieveCampaignInfo()
	{
		ArrayList<campaign> CI=new ArrayList<campaign>();
		Database d=new Database();
		
			con=d.connection();
	
		try{
			String sql="Select * from campaign";
			PreparedStatement stmt=con.prepareStatement(sql);
		
			ResultSet rs=stmt.executeQuery();
			int number;
			double ctr;
			double impression;
			int bar;

			while(rs.next())
			{
				
				number=rs.getInt("number");
				ctr=rs.getDouble("ctr");
				impression=rs.getDouble("impression");
				bar=rs.getInt("bar");
				campaign c=new campaign();
				c.setNumber(number);
				c.setCtr(ctr);
				c.setImpression(impression);
				c.setBar(bar);
			
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



			

