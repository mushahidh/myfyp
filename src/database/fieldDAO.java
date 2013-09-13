package database;

import bean.*;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;





public class fieldDAO implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private Connection con;
	
	public fieldDAO()
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
	public ArrayList<field> retrieveFieldInfo()
	{
		ArrayList<field> FI=new ArrayList<field>();
		Database d=new Database();
		
			con=d.connection();
	
		try{
			String sql="Select * from field";
			PreparedStatement stmt=con.prepareStatement(sql);
		
			ResultSet rs=stmt.executeQuery();
			int field_id;
			String field_name;
			String field_desc;
			int field_standard;
			while(rs.next())
			{
				
				field_id=rs.getInt("field_id");
				field_name=rs.getString("field_name");
				field_desc=rs.getString("field_desc");
				field_standard=rs.getInt("field_standard");
				field f=new field();
				f.setField_id(field_id);
				f.setField_name(field_name);
				f.setField_desc(field_desc);
				f.setField_standard(field_standard);
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

	//-------------------------------------------------------------Add FIeld--------------------------------------------------------
		public void addField(field F)throws SQLException
		{
			Database d=new Database();
		
				con=d.connection();
		
			try
			{
			String field_name=F.getField_name();
			String field_desc=F.getField_desc();
			int field_standard=F.getField_standard();
			String sql="INSERT INTO field Values (null,?,?,?)";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setString(1,field_name);
			stmt.setString(2,field_desc);
			stmt.setInt(3,field_standard);
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
		//-------------------------------------------------------------get field data------------------------------------------------------
		
		public field getFieldInfo(int id)
		{
			field f=new field();
			Database d=new Database();
			
				con=d.connection();
	
			try{
				String sql="Select * from field where field_id=?";
				
				PreparedStatement stmt=con.prepareStatement(sql);
				stmt.setInt(1,id);
				ResultSet rs=stmt.executeQuery();
				
				int field_id;
				String field_name;
				String field_desc;
				int field_standard;
				rs.next();
					
					field_id=rs.getInt("field_id");
					field_name=rs.getString("field_name");
					field_desc=rs.getString("field_desc");
					field_standard=rs.getInt("field_standard");
					f.setField_id(field_id);
					f.setField_name(field_name);
					f.setField_desc(field_desc);
					f.setField_standard(field_standard);
					
					}
			
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				d.getResource();
			}
			return f;
		}
		//-------------------------------------------------------------update--------------------------------------------------------
		public void updateField(field f)throws SQLException
		{
			Database d=new Database();
			
				con=d.connection();
	
			try
			{
			int field_id=f.getField_id();
			String field_name=f.getField_name();
			String field_desc=f.getField_desc();
			int field_standard=f.getField_standard();
			String sql="update field SET field_id=?,field_name=?,field_desc=?,field_standard=? where field_id=?";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setInt(1,field_id);
			stmt.setString(2,field_name);
			stmt.setString(3,field_desc);
			stmt.setInt(4,field_standard);
			stmt.setInt(5,field_id);	
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
		public void deleteField(field f)throws SQLException
		{
			Database d=new Database();
			
				con=d.connection();
		
			try
			{
				int id=f.getField_id();
			
			String sql="delete from field where field_id=?";
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



			

