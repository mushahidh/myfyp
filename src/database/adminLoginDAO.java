package database;

import java.io.*;
import java.sql.*;

import bean.admin;







public class adminLoginDAO implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private Connection con;
	
	public adminLoginDAO()
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
		
		public admin getLoginInfo(String Email,String pwd)
		{
		
			int user_id;
			String user_screen_name;
			String user_encrypted_password;
			String user_email;
			admin a=new admin();
			Database d=new Database();
			
				con=d.connection();
		
			try{
				String sql="Select * from admin where user_email=? AND user_encrypted_password=?";
				
				PreparedStatement stmt=con.prepareStatement(sql);
				stmt.setString(1,Email);
				stmt.setString(2,pwd);
				ResultSet rs=stmt.executeQuery();
				
				
				if (!rs.next()){
						a=null;
					}
				
				else
				{
					
					user_id=rs.getInt("user_id");
					user_screen_name=rs.getString("user_screen_name");
					user_encrypted_password=rs.getString("user_encrypted_password");
					user_email=rs.getString("user_email");
					
					
					a.setUser_id(user_id);
					a.setUser_screen_name(user_screen_name);
					a.setUser_encrypted_password(user_encrypted_password);
					a.setUser_email(user_email);
					
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
			return a;
		}
		
		
	
	//-----------------------------------------------------------------End----------------------------------------------------------
		

}



			

