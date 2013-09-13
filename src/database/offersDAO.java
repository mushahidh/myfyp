package database;

import bean.*;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;





public class offersDAO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Connection con;
	
	public offersDAO()
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
	//----------------------------------------Retrieve offers info----------------------------
	public ArrayList<offers> retrieveOffersInfo()
	{
		ArrayList<offers> OI=new ArrayList<offers>();
		Database d=new Database();
		
			con=d.connection();
	
		try{
			String sql="Select * from offers";
			PreparedStatement stmt=con.prepareStatement(sql);
		
			ResultSet rs=stmt.executeQuery();
			int field_id;
			int uni_id;
			int duration;
			int hssc_criteria;
			int ssc_criteria;
			while(rs.next())
			{
				
				field_id=rs.getInt("field_id");
				uni_id=rs.getInt("uni_id");
				duration=rs.getInt("duration");
				hssc_criteria=rs.getInt("hssc_criteria");
				ssc_criteria=rs.getInt("ssc_criteria");
				offers o=new offers();
				o.setUni_id(uni_id);
				o.setField_idd(field_id);
				o.setDuration(duration);
				o.setHssc_criteria(hssc_criteria);
				o.setSsc_criteria(ssc_criteria);
				OI.add(o);
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
		return OI;
		
	}

	//-------------------------------------------------------------Add Offer--------------------------------------------------------
		public void addOffers(offers O)throws SQLException
		{
			Database d=new Database();
			
				con=d.connection();
	
			try
			{
			int[] field_id=O.getField_id();
			int size = field_id.length;
			int uni_id=O.getUni_id();
			int duration=O.getDuration();
			int hssc_criteria=O.getHssc_criteria();
			int ssc_criteria=O.getSsc_criteria();
			int field;
			int uni;
			
			String sql2="Select * from universities where uni_id=?";
			PreparedStatement stmt2=con.prepareStatement(sql2);
			stmt2.setInt(1,uni_id);
			ResultSet rs1=stmt2.executeQuery();
			rs1.next();
			uni=rs1.getInt("uni_id");
			for(int i=0;i<size;i++)
			{
				String sql1="select * from field where field_id= ?";
				PreparedStatement stmt1=con.prepareStatement(sql1);
				stmt1.setInt(1,field_id[i]);
				ResultSet rs=stmt1.executeQuery();
				rs.next();
				field=rs.getInt("field_id");
				String sql="INSERT INTO offers Values (?,?,?,?,?)";
				PreparedStatement stmt=con.prepareStatement(sql);
				stmt.setInt(1,duration);
				stmt.setInt(2,hssc_criteria);
				stmt.setInt(3,ssc_criteria);
				stmt.setInt(4,field);
				stmt.setInt(5,uni);
				stmt.executeUpdate();
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
			
		}
		//-------------------------------------------------------------get offers data------------------------------------------------------
		
		public offers getOffersInfo(int uni_idd,int field_idd)
		{
			offers o=new offers();
			Database d=new Database();
			
				con=d.connection();
			
			try{
				String sql="Select * from offers where uni_id=? AND field_id=?";
				
				PreparedStatement stmt=con.prepareStatement(sql);
				stmt.setInt(1,uni_idd);
				stmt.setInt(2,field_idd);
				ResultSet rs=stmt.executeQuery();
				
				int field_id;
				int uni_id;
				int duration;
				int hssc_criteria;
				int ssc_criteria;
				
				rs.next();
					
					field_id=rs.getInt("field_id");
					uni_id=rs.getInt("uni_id");
					duration=rs.getInt("duration");
					hssc_criteria=rs.getInt("hssc_criteria");
					ssc_criteria=rs.getInt("ssc_criteria");
					o.setUni_id(uni_id);
					o.setField_idd(field_id);
					o.setDuration(duration);
					o.setHssc_criteria(hssc_criteria);
					o.setSsc_criteria(ssc_criteria);
					}
			
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				d.getResource();
			}
			return o;
		}
		//-------------------------------------------------------------update--------------------------------------------------------
		public void updateOffers(offers O)throws SQLException
		{
			Database d=new Database();
			
				con=d.connection();
		
			try
			{
			int field_id=O.getField_idd();
			int uni_id=O.getUni_id();
			int duration=O.getDuration();
			int hssc_criteria=O.getHssc_criteria();
			int ssc_criteria=O.getSsc_criteria();
			int field;
			int uni;
		
			
			String sql1="select * from field where field_id= ?";
			PreparedStatement stmt1=con.prepareStatement(sql1);
			stmt1.setInt(1,field_id);
			ResultSet rs=stmt1.executeQuery();
			rs.next();
			field=rs.getInt("field_id");
			
			String sql2="Select * from universities where uni_id=?";
			PreparedStatement stmt2=con.prepareStatement(sql2);
			stmt2.setInt(1,uni_id);
			ResultSet rs1=stmt2.executeQuery();
			rs1.next();
			uni=rs1.getInt("uni_id");
			
			String sql="update offers SET uni_id=?,field_id=?,duration=?,hssc_criteria=?,ssc_criteria=? where uni_id=? AND field_id=?";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setInt(1,uni);
			stmt.setInt(2,field);
			stmt.setInt(3,duration);
			stmt.setInt(4,hssc_criteria);
			stmt.setInt(5,ssc_criteria);
			stmt.setInt(6,uni);
			stmt.setInt(7,field);
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
		public void deleteOffers(offers o)throws SQLException
		{
			Database d=new Database();
			
				con=d.connection();
		
			try
			{
			int uni_id=o.getUni_id();
			int field_id=o.getField_idd();
			String sql="delete from offers where uni_id=? AND field_id=?";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setInt(1,uni_id);
			stmt.setInt(2,field_id);
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



			

