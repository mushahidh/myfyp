package database;

import bean.*;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;





public class fundraiserDAO implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private Connection con;
	
	public fundraiserDAO()
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
	public ArrayList<fundraiser> retrieveFundraiserInfo()
	{
		ArrayList<fundraiser> FI=new ArrayList<fundraiser>();
		Database d=new Database();
		
			con=d.connection();
		
		try{
			String sql="Select * from fund_raiser";
			PreparedStatement stmt=con.prepareStatement(sql);
		
			ResultSet rs=stmt.executeQuery();
			int number;
			double impression;
			int bar;

			while(rs.next())
			{
				
				number=rs.getInt("number");
				impression=rs.getDouble("impression");
				bar=rs.getInt("bar");
				fundraiser f=new fundraiser();
				f.setNumber(number);
				f.setImpression(impression);
				f.setBar(bar);
			
				FI.add(f);
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
		return FI;
	}


		
	
	//-----------------------------------------------------------------End----------------------------------------------------------
		

}



			

