package database;

import java.io.*;
import java.sql.*;

import bean.user;
public class loginDAO implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private Connection con;
	
	public loginDAO()
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
		
		public user getLoginInfo(String Email,String pwd)
		{
			
			
			
			Database d=new Database();
		
				con=d.connection();
		
				int user_id;
				String user_screen_name;
				String user_encrypted_password;
				String user_email;
				user u=new user();
				connection();
				try{
					String sql="Select * from user where user_email=? AND user_encrypted_password=?";
					
					PreparedStatement stmt=con.prepareStatement(sql);
					stmt.setString(1,Email);
					stmt.setString(2,pwd);
					ResultSet rs=stmt.executeQuery();
					
					
					if (!rs.next()){
							u=null;
						}
					
					else
					{
						
						user_id=rs.getInt("user_id");
						user_screen_name=rs.getString("user_screen_name");
						user_encrypted_password=rs.getString("user_encrypted_password");
						user_email=rs.getString("user_email");
						
						
						u.setUser_id(user_id);
						u.setUser_screen_name(user_screen_name);
						u.setUser_encrypted_password(user_encrypted_password);
						u.setUser_email(user_email);
						
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
			return u;
		}
		
		
	
	//-----------------------------------------------------------------End----------------------------------------------------------
		

}



			

