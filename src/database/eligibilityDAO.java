package database;

import bean.*;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;





public class eligibilityDAO implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private Connection con;
	
	public eligibilityDAO()
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
	//----------------------------------------Retrieve eligibility info----------------------------
	public ArrayList<eligibility> retrieveEligibilityInfo()
	{
		ArrayList<eligibility> EI=new ArrayList<eligibility>();
		Database d=new Database();
	
			con=d.connection();
	
		try{
			String sql="Select * from eligibility";
			PreparedStatement stmt=con.prepareStatement(sql);
		
			ResultSet rs=stmt.executeQuery();
			int field_id;
			int required_id;
			while(rs.next())
			{
				
				field_id=rs.getInt("field_id");
				required_id=rs.getInt("required_id");
			
				eligibility e=new eligibility();
				e.setField_id(field_id);
				e.setRequired_idd(required_id);
				
				EI.add(e);
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
		return EI;
		
	}

	//-------------------------------------------------------------Add eligibility--------------------------------------------------------
		public void addEligibility(eligibility e)throws SQLException
		{
			Database d=new Database();
			
				con=d.connection();
			
			try
			{
			int field_id=e.getField_id();
			int [] required_id=e.getRequired_id();
			int size = required_id.length;
		
			int field;
			int required;
			
			String sql1="select * from field where field_id= ?";
			PreparedStatement stmt1=con.prepareStatement(sql1);
			stmt1.setInt(1,field_id);
			ResultSet rs=stmt1.executeQuery();
			rs.next();
			field=rs.getInt("field_id");
			for(int i=0;i<size;i++)
			{	
		
				
				String sql2="Select * from field where field_id=?";
				PreparedStatement stmt2=con.prepareStatement(sql2);
				stmt2.setInt(1,required_id[i]);
				ResultSet rs1=stmt2.executeQuery();
				rs1.next();
				required=rs1.getInt("field_id");	
				String sql="INSERT INTO eligibility Values (?,?)";
				PreparedStatement stmt=con.prepareStatement(sql);
				stmt.setInt(1,field);
				stmt.setInt(2,required);
				stmt.executeUpdate();
			}
		}
			catch(Exception er)
			{
				er.printStackTrace();
			}
			finally
			{
				d.getResource();
			}
		
			
		}
		//-------------------------------------------------------------get field data------------------------------------------------------
		
		public eligibility getEligibilityInfo(int id)
		{
			Database d=new Database();
			
				con=d.connection();
			
			eligibility el=new eligibility();
			
			try{
				String sql="Select * from eligibility where field_id=?";
				
				PreparedStatement stmt=con.prepareStatement(sql);
				stmt.setInt(1,id);
				ResultSet rs=stmt.executeQuery();
				
				int field_id;
				int required_id;
				rs.next();
					
					field_id=rs.getInt("field_id");
					required_id=rs.getInt("required_id");
					el.setField_id(field_id);
					el.setRequired_idd(required_id);
					
					}
			
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				d.getResource();
			}
			return el;
		}
		//-------------------------------------------------------------update--------------------------------------------------------
		public void updateEligibility(eligibility e)throws SQLException
		{
			Database d=new Database();
			
				con=d.connection();
			
			try
			{
			int field_id=e.getField_id();
			int required_id=e.getRequired_idd();
			int field;
			int course;
			String sql1="select * from field where field_id= ?";
			PreparedStatement stmt1=con.prepareStatement(sql1);
			stmt1.setInt(1,field_id);
			ResultSet rs=stmt1.executeQuery();
			rs.next();
			field=rs.getInt("field_id");
			
			String sql2="Select * from course where required_id=?";
			PreparedStatement stmt2=con.prepareStatement(sql2);
			stmt2.setInt(1,required_id);
			ResultSet rs1=stmt2.executeQuery();
			rs1.next();
			course=rs1.getInt("field_id");
			
			String sql="update eligibility SET field_id=?,required_id=? where field_id=?";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setInt(1,field);
			stmt.setInt(2,course);
			stmt.setInt(3,field_id);
			
			stmt.executeUpdate();
			}
			catch(Exception er)
			{
				er.printStackTrace();
			}
			finally
			{
				d.getResource();
			}
			
		}
	
		//--------------------------------------------------------------delete-------------------------------------------------------
		public void deleteEligibility(eligibility e)throws SQLException
		{
			Database d=new Database();
			
				con=d.connection();
		
			try
			{
			int id=e.getField_id();
			int required_id=e.getRequired_idd();
			
			String sql="delete from eligibility where field_id=? AND required_id=?";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setInt(1,id);
			stmt.setInt(2,required_id);
			stmt.executeUpdate();
			}
			catch(Exception er)
			{
				er.printStackTrace();
			}
			finally
			{
				d.getResource();
			}
			
		}
		
	
	//-----------------------------------------------------------------End----------------------------------------------------------
		

}



			

