package database;

import bean.*;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;





public class groupDAO implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private Connection con;
	
	public groupDAO()
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
	public ArrayList<group> retrieveGroupInfo()
	{
		ArrayList<group> GI=new ArrayList<group>();
		Database d=new Database();
		
			con=d.connection();
		
		try{
			String sql="Select * from field_group";
			PreparedStatement stmt=con.prepareStatement(sql);
		
			ResultSet rs=stmt.executeQuery();
			int group_id;
			String group_name;
			int group_standard;

			while(rs.next())
			{
				
				group_id=rs.getInt("field_group_id");
				group_name=rs.getString("field_group_name");
				group_standard=rs.getInt("field_group_standard");
				group g=new group();
				g.setGroup_id(group_id);
				g.setGroup_name(group_name);
				g.setGroup_standard(group_standard);
			
				GI.add(g);
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
		return GI;
		
	}
	//--------------------------------------------------------one group--------------------------------------------------------
	public ArrayList<group> retrieveGroupInfo(int standard)
	{
		ArrayList<group> GI=new ArrayList<group>();
		Database d=new Database();
		
			con=d.connection();
		
		try{
			String sql="Select * from field_group where field_group_standard=?";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setInt(1, standard);
			ResultSet rs=stmt.executeQuery();
			int group_id;
			String group_name;
			int group_standard;
			if(!rs.next())
			{
				
			}
			else
			{
				group_id=rs.getInt("field_group_id");
				group_name=rs.getString("field_group_name");
				group_standard=rs.getInt("field_group_standard");
				group g1=new group();
				g1.setGroup_id(group_id);
				g1.setGroup_name(group_name);
				g1.setGroup_standard(group_standard);
			
				GI.add(g1);
			while(rs.next())
			{
				
				group_id=rs.getInt("field_group_id");
				group_name=rs.getString("field_group_name");
				group_standard=rs.getInt("field_group_standard");
				group g=new group();
				g.setGroup_id(group_id);
				g.setGroup_name(group_name);
				g.setGroup_standard(group_standard);
			
				GI.add(g);
			}
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
		return GI;
		
	}


	//-------------------------------------------------------------Add group--------------------------------------------------------
		public void addGroup(group G)throws SQLException
		{
			Database d=new Database();
			
				con=d.connection();
			
			try
			{
			String group_name=G.getGroup_name();
			int group_standard=G.getGroup_standard();
			String sql="INSERT INTO field_group Values (null,?,?)";
			PreparedStatement stmt=con.prepareStatement(sql);
			
			stmt.setString(1,group_name);
			stmt.setInt(2, group_standard);
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
		//-------------------------------------------------------------get group data------------------------------------------------------
		
		public group getGroupInfo(int id)
		{
			group g=new group();
			Database d=new Database();
		
				con=d.connection();
			
			try{
				String sql="Select * from field_group where field_group_id=?";
				
				PreparedStatement stmt=con.prepareStatement(sql);
				stmt.setInt(1,id);
				ResultSet rs=stmt.executeQuery();
				
				int group_id;
				String group_name;
				int group_standard;
			
				rs.next();
					
				group_id=rs.getInt("field_group_id");
				group_name=rs.getString("field_group_name");
				group_standard=rs.getInt("field_group_standard");
				g.setGroup_id(group_id);
				g.setGroup_name(group_name);
				g.setGroup_standard(group_standard);
					
					
					}
			
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				d.getResource();
			}
			return g;
		}
		//-------------------------------------------------------------update--------------------------------------------------------
		public void updateGroup(group g)throws SQLException
		{
			Database d=new Database();
			
				con=d.connection();
		
			try
			{
			int group_id=g.getGroup_id();
			String group_name=g.getGroup_name();
			int group_standard=g.getGroup_standard();
			String sql="update field_group SET field_group_id=?,field_group_name=?,field_group_standard=? where field_group_id=?";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setInt(1,group_id);
			stmt.setString(2,group_name);
			stmt.setInt(3,group_standard);
			stmt.setInt(4,group_id);
			
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
		public void deleteGroup(group g)throws SQLException
		{
			Database d=new Database();
			
				con=d.connection();
		
			try
			{
			int id=g.getGroup_id();
			
			String sql="delete from field_group where field_group_id=?";
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



			

