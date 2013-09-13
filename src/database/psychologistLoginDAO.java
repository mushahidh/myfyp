package database;

import java.io.*;
import java.sql.*;

import bean.psychologist;







public class psychologistLoginDAO implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private Connection con;
	
	public psychologistLoginDAO()
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
		//-------------------------------------------------------------get login data------------------------------------------------------
		
		public psychologist getLoginInfo(String Email,String pwd)
		{
		
			int user_id;
			String user_screen_name;
			String user_encrypted_password;
			String user_email;
			psychologist p=new psychologist();
			Database d=new Database();
			
				con=d.connection();
		
			try{
				String sql="Select * from psychologist where user_email=? AND user_encrypted_password=?";
				
				PreparedStatement stmt=con.prepareStatement(sql);
				stmt.setString(1,Email);
				stmt.setString(2,pwd);
				ResultSet rs=stmt.executeQuery();
				
				
				if (!rs.next()){
						p=null;
					}
				
				else
				{
					
					user_id=rs.getInt("user_id");
					user_screen_name=rs.getString("user_screen_name");
					user_encrypted_password=rs.getString("user_encrypted_password");
					user_email=rs.getString("user_email");
					
					
					p.setUser_id(user_id);
					p.setUser_screen_name(user_screen_name);
					p.setUser_encrypted_password(user_encrypted_password);
					p.setUser_email(user_email);
					
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
			return p;
		}
		
		
	
	//-----------------------------------------------------------------End----------------------------------------------------------
		

}



			

