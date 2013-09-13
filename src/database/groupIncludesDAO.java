package database;

import bean.*;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;





public class groupIncludesDAO implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private Connection con;
	
	public groupIncludesDAO()
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
	//----------------------------------------Retrieve groupincludes info----------------------------
	public ArrayList<groupIncludes> retrieveGroupIncludesInfo()
	{
		ArrayList<groupIncludes> EI=new ArrayList<groupIncludes>();
		Database d=new Database();
		
			con=d.connection();
	
		try{
			String sql="Select * from group_includes";
			PreparedStatement stmt=con.prepareStatement(sql);
		
			ResultSet rs=stmt.executeQuery();
			int group_id;
			int field_id;
			while(rs.next())
			{
				
				group_id=rs.getInt("group_id");
				field_id=rs.getInt("field_id");
			
				groupIncludes e=new groupIncludes();
				e.setGroup_id(group_id);
				e.setField_idd(field_id);
				
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
	//-------------------------------------------------------------------for university finder page field info-----------------------------------------------------------
		public ArrayList<groupIncludes> retrieveGroupIncludesFieldInfo(int id,int standard)
		{
			
			ArrayList<groupIncludes> EI=new ArrayList<groupIncludes>();
			Database d=new Database();
			
				con=d.connection();
		
			try{
				String sql="SELECT * FROM group_includes JOIN field ON group_includes.field_id=field.field_id WHERE field_standard=? and group_id=? ";
				PreparedStatement stmt=con.prepareStatement(sql);
				stmt.setInt(1, standard);
				stmt.setInt(2, id);
				ResultSet rs=stmt.executeQuery();
				int group_id;
				int field_id;
				while(rs.next())
				{
					
					group_id=rs.getInt("group_id");
					field_id=rs.getInt("field_id");
				
					groupIncludes e=new groupIncludes();
					e.setGroup_id(group_id);
					e.setField_idd(field_id);
					
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

//-------------------------------------------------------------------retreive one-----------------------------------------------------------
	public ArrayList<groupIncludes> retrieveGroupIncludesInfo(int id)
	{
		ArrayList<groupIncludes> EI=new ArrayList<groupIncludes>();
		Database d=new Database();
	
			con=d.connection();
	
		try{
			String sql="Select * from group_includes where group_id=?";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs=stmt.executeQuery();
			int group_id;
			int field_id;
			while(rs.next())
			{
				
				group_id=rs.getInt("group_id");
				field_id=rs.getInt("field_id");
			
				groupIncludes e=new groupIncludes();
				e.setGroup_id(group_id);
				e.setField_idd(field_id);
				
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

	//-------------------------------------------------------------Add groupincludes--------------------------------------------------------
		public void addGroupIncludes(groupIncludes e)throws SQLException
		{
			Database d=new Database();
		
				con=d.connection();
		
			try
			{
			int group_id=e.getGroup_id();
			int [] field_id=e.getField_id();
			int size = field_id.length;
			System.out.println(size);
			int group;
			int field;
			
			String sql1="select * from field_group where field_group_id= ?";
			PreparedStatement stmt1=con.prepareStatement(sql1);
			stmt1.setInt(1,group_id);
			ResultSet rs=stmt1.executeQuery();
			rs.next();
			group=rs.getInt("field_group_id");
			for(int i=0;i<size;i++)
			{	
		
				
				String sql2="Select * from field where field_id=?";
				PreparedStatement stmt2=con.prepareStatement(sql2);
				stmt2.setInt(1,field_id[i]);
				ResultSet rs1=stmt2.executeQuery();
				rs1.next();
				field=rs1.getInt("field_id");	
				String sql="INSERT INTO group_includes Values (?,?)";
				PreparedStatement stmt=con.prepareStatement(sql);
				stmt.setInt(1,group);
				stmt.setInt(2,field);
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
		//-------------------------------------------------------------get group data------------------------------------------------------
		
		public groupIncludes getGroupIncludesInfo(int id)
		{
			Database d=new Database();
			
				con=d.connection();
		
			groupIncludes el=new groupIncludes();
			
			try{
				String sql="Select * from group_includes where group_id=?";
				
				PreparedStatement stmt=con.prepareStatement(sql);
				stmt.setInt(1,id);
				ResultSet rs=stmt.executeQuery();
				
				int group_id;
				int field_id;
				rs.next();
					
					group_id=rs.getInt("group_id");
					field_id=rs.getInt("field_id");
					el.setGroup_id(group_id);
					el.setField_idd(field_id);
					
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
		public void updateGroupIncludes(groupIncludes e)throws SQLException
		{
			Database d=new Database();
			
				con=d.connection();
			
			try
			{
			int group_id=e.getGroup_id();
			int field_id=e.getField_idd();
			int group;
			int field;
			String sql1="select * from field_group where field_group_id= ?";
			PreparedStatement stmt1=con.prepareStatement(sql1);
			stmt1.setInt(1,group_id);
			ResultSet rs=stmt1.executeQuery();
			rs.next();
			group=rs.getInt("field_group_id");
			
			String sql2="Select * from field where field_id=?";
			PreparedStatement stmt2=con.prepareStatement(sql2);
			stmt2.setInt(1,field_id);
			ResultSet rs1=stmt2.executeQuery();
			rs1.next();
			field=rs1.getInt("group_id");
			
			String sql="update group_includes SET group_id=?,field_id=? where group_id=?";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setInt(1,group);
			stmt.setInt(2,field);
			stmt.setInt(3,group_id);
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
		public void deleteGroupIncludes(groupIncludes i)throws SQLException
		{
			Database d=new Database();
			
				con=d.connection();
		
			try
			{
			int id=i.getGroup_id();
			int field_id=i.getField_idd();
			String sql="delete from group_includes where group_id=? AND field_id=?";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setInt(1,id);
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



			

