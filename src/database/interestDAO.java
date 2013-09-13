package database;

import bean.*;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;





public class interestDAO implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private Connection con;
	
	public interestDAO()
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
	public ArrayList<interest> retrieveInterestInfo()
	{
		ArrayList<interest> FI=new ArrayList<interest>();
		Database d=new Database();
		
			con=d.connection();

		try{
			String sql="Select * from holland_codes";
			PreparedStatement stmt=con.prepareStatement(sql);
		
			ResultSet rs=stmt.executeQuery();
			int field_id;
			int realistic;
			int artistic;
			int social;
			int investigative;
			int enterprising;
			int conventional;
			while(rs.next())
			{
				
				field_id=rs.getInt("field_id");
				realistic=rs.getInt("realistic");
				artistic=rs.getInt("artistic");
				investigative=rs.getInt("investigative");
				social=rs.getInt("social");
				enterprising=rs.getInt("enterprising");
				conventional=rs.getInt("conventional");
				
				interest i=new interest();
				i.setField_id(field_id);
				i.setRealistic(realistic);
				i.setArtistic(artistic);
				i.setInvestigative(investigative);
				i.setSocial(social);
				i.setEnterprising(enterprising);
				i.setConventional(conventional);
				FI.add(i);
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

	//-------------------------------------------------------------Add interest--------------------------------------------------------
		public void addInterest(interest i)throws SQLException
		{
			Database d=new Database();
			
				con=d.connection();
		
			try
			{
			int field_id=i.getField_id();
			int artistic=i.getArtistic();
			int conventional=i.getConventional();
			int enterprising=i.getEnterprising();
			int realistic=i.getRealistic();
			int investigative=i.getInvestigative();
			int social=i.getSocial();
			String sql="INSERT INTO holland_codes Values (?,?,?,?,?,?,?)";
			PreparedStatement stmt=con.prepareStatement(sql);
			
			stmt.setInt(1, field_id);
			stmt.setInt(2, realistic);
			stmt.setInt(3, investigative);
			stmt.setInt(4, artistic);
			stmt.setInt(5, social);
			stmt.setInt(6, enterprising);
			stmt.setInt(7, conventional);
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
		//-------------------------------------------------------------get interest data------------------------------------------------------
		
		public interest getInterestInfo(int id)
		{
			interest i=new interest();
			Database d=new Database();
		
				con=d.connection();
		
			try{
				String sql="Select * from holland_codes where field_id=?";
				
				PreparedStatement stmt=con.prepareStatement(sql);
				stmt.setInt(1,id);
				ResultSet rs=stmt.executeQuery();
				
				int field_id;
				int realistic;
				int artistic;
				int social;
				int investigative;
				int enterprising;
				int conventional;
				rs.next();
					
					field_id=rs.getInt("field_id");
					artistic=rs.getInt("artistic");
					conventional=rs.getInt("conventional");
					enterprising=rs.getInt("enterprising");
					realistic=rs.getInt("realistic");
					investigative=rs.getInt("investigative");
					social=rs.getInt("social");
					i.setField_id(field_id);
					i.setRealistic(realistic);
					i.setArtistic(artistic);
					i.setInvestigative(investigative);
					i.setSocial(social);
					i.setEnterprising(enterprising);
					i.setConventional(conventional);
					
					}
			
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				d.getResource();
			}
			return i;
		}
		//-------------------------------------------------------------update--------------------------------------------------------
		public void updateInterest(interest i)throws SQLException
		{
			Database d=new Database();
			
				con=d.connection();
			
			try
			{
			int field_id=i.getField_id();
			int artistic=i.getArtistic();
			int conventional=i.getConventional();
			int enterprising=i.getEnterprising();
			int realistic=i.getRealistic();
			int investigative=i.getInvestigative();
			int social=i.getSocial();
			String sql="update holland_codes SET field_id=?,realistic=?,investigative=?,artistic=?,social=?,enterprising=?,conventional=? where field_id=?";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setInt(1, field_id);
			stmt.setInt(2, realistic);
			stmt.setInt(3, investigative);
			stmt.setInt(4, artistic);
			stmt.setInt(5, social);
			stmt.setInt(6, enterprising);
			stmt.setInt(7, conventional);
			stmt.setInt(8, field_id);
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
		public void deleteInterest(interest i)throws SQLException
		{
			Database d=new Database();
		
				con=d.connection();
		
			try
			{
			int id=i.getField_id();
			String sql="delete from holland_codes where field_id=?";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setInt(1,id);
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



			

