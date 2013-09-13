package database;

import bean.*;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;





public class universityDAO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Connection con;
	
	public universityDAO()
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
	//----------------------------------------Retrieve university info----------------------------
	public ArrayList<university> retrieveUniversityInfo()
	{
		ArrayList<university> UI=new ArrayList<university>();
		Database d=new Database();

			con=d.connection();

		try{
			String sql="Select * from universities";
			PreparedStatement stmt=con.prepareStatement(sql);
		
			ResultSet rs=stmt.executeQuery();
			int uni_id;
			String uni_name;
			String uni_location;
			String uni_address;
			String uni_website;
			String uni_desc;
			double uni_longitude;
			double uni_latitude;
			while(rs.next())
			{
				
				uni_id=rs.getInt("uni_id");
				uni_name=rs.getString("uni_name");
				uni_location=rs.getString("uni_location");
				uni_address=rs.getString("uni_address");
				uni_website=rs.getString("uni_website");
				uni_desc=rs.getString("uni_desc");
				uni_longitude=rs.getDouble("uni_longitude");
				uni_latitude=rs.getDouble("uni_latitude");
				
				university u=new university();
				u.setUni_id(uni_id);
				u.setUni_name(uni_name);
				u.setUni_location(uni_location);
				u.setUni_address(uni_address);
				u.setUni_website(uni_website);
				u.setUni_desc(uni_desc);
				u.setUni_longitude(uni_longitude);
				u.setUni_latitude(uni_latitude);
				UI.add(u);
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
		return UI;
		
	}
	//----------------------------------------Retrieve university finder info----------------------------
		public ArrayList<university> universityFinder(String unii_location,int uni_field)
		{
			ArrayList<university> UI=new ArrayList<university>();
			Database d=new Database();
		
				con=d.connection();
		
			try{
				String sql="SELECT * FROM universities JOIN offers ON universities.uni_id=offers.uni_id WHERE uni_location=? and field_id=? ";
				PreparedStatement stmt=con.prepareStatement(sql);
				stmt.setString(1,unii_location);
				stmt.setInt(2,uni_field);
				ResultSet rs=stmt.executeQuery();
				int uni_id;
				String uni_name;
				String uni_location;
				String uni_address;
				String uni_website;
				String uni_desc;
				double uni_longitude;
				double uni_latitude;
				while(rs.next())
				{
					
					uni_id=rs.getInt("uni_id");
					uni_name=rs.getString("uni_name");
					uni_location=rs.getString("uni_location");
					uni_address=rs.getString("uni_address");
					uni_website=rs.getString("uni_website");
					uni_desc=rs.getString("uni_desc");
					uni_longitude=rs.getDouble("uni_longitude");
					uni_latitude=rs.getDouble("uni_latitude");
					
					university u=new university();
					u.setUni_id(uni_id);
					u.setUni_name(uni_name);
					u.setUni_location(uni_location);
					u.setUni_address(uni_address);
					u.setUni_website(uni_website);
					u.setUni_desc(uni_desc);
					u.setUni_longitude(uni_longitude);
					u.setUni_latitude(uni_latitude);
					UI.add(u);
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
			return UI;
			
		}
	//-------------------------------------------------------------Add University--------------------------------------------------------
		public void addUniversity(university U)throws SQLException
		{
		
			Database d=new Database();
			
				con=d.connection();
		
			try
			{
			String uni_name=U.getUni_name();
			String uni_location=U.getUni_location();
			String uni_address=U.getUni_address();
			String uni_website=U.getUni_website();
			String uni_desc=U.getUni_desc();
			double uni_longitude=U.getUni_longitude();
			double uni_latitude=U.getUni_latitude();
			String sql="INSERT INTO universities Values (null,?,?,?,?,?,?,?)";
			PreparedStatement stmt=con.prepareStatement(sql);
			
			stmt.setString(1,uni_name);
			stmt.setString(2,uni_location);
			stmt.setString(3,uni_address);
			stmt.setString(4,uni_website);
			stmt.setString(5,uni_desc);
			stmt.setDouble(6,uni_longitude);
			stmt.setDouble(7,uni_latitude);

			
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
		//-------------------------------------------------------------get uni data------------------------------------------------------
		
		public university getUniversityInfo(int id)
		{
			university U=new university();
			Database d=new Database();
			
				con=d.connection();
		
			try{
				String sql="Select * from universities where uni_id=?";
			
				PreparedStatement stmt=con.prepareStatement(sql);
				stmt.setInt(1,id);
				ResultSet rs=stmt.executeQuery();
				
				int uni_id;
				String uni_name;
				String uni_location;
				String uni_address;
				String uni_website;
				String uni_desc;
				double uni_longitude;
				double uni_latitude;
				
				rs.next();
					
				uni_id=rs.getInt("uni_id");
				uni_name=rs.getString("uni_name");
				uni_location=rs.getString("uni_location");
				uni_address=rs.getString("uni_address");
				uni_website=rs.getString("uni_website");
				uni_desc=rs.getString("uni_desc");
				uni_longitude=rs.getDouble("uni_longitude");
				uni_latitude=rs.getDouble("uni_latitude");
				
					U.setUni_id(uni_id);
					U.setUni_name(uni_name);
					U.setUni_location(uni_location);
					U.setUni_address(uni_address);
					U.setUni_website(uni_website);
					U.setUni_desc(uni_desc);
					U.setUni_longitude(uni_longitude);
					U.setUni_latitude(uni_latitude);
					
					}
			
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				d.getResource();
			}
			return U;
		}
		//-------------------------------------------------------------update uni data--------------------------------------------------------
		public void updateUniversity(university U)throws SQLException
		{
			Database d=new Database();
		
				con=d.connection();
		
			try
			{
			int uni_id=U.getUni_id();
			String uni_name=U.getUni_name();
			String uni_location=U.getUni_location();
			String uni_address=U.getUni_address();
			String uni_website=U.getUni_website();
			String uni_desc=U.getUni_desc();
			double uni_longitude=U.getUni_longitude();
			double uni_latitude=U.getUni_latitude();
	
			String sql="update universities SET uni_id=?,uni_name=?,uni_location=?,uni_address=?,uni_website=?,uni_desc=?,uni_longitude=?,uni_latitude=? where uni_id=?";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setInt(1,uni_id);
			stmt.setString(2,uni_name);
			stmt.setString(3,uni_location);
			stmt.setString(4,uni_address);
			stmt.setString(5,uni_website);
			stmt.setString(6,uni_desc);
			stmt.setDouble(7,uni_longitude);
			stmt.setDouble(8,uni_latitude);
			stmt.setInt(9,uni_id);
			
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
		public void deleteUniversity(university u)throws SQLException
		{
			Database d=new Database();
			
				con=d.connection();
		
			try
			{
			int id=u.getUni_id();
			
			String sql="delete from universities where uni_id=?";
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



			

