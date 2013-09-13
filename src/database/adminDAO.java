package database;

import bean.*;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.http.Part;





public class adminDAO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Connection con;
	
	public adminDAO()
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
	
	//----------------------------------------Retrieve user info----------------------------
	public ArrayList<admin> retrieveUserInfo()
	{
		ArrayList<admin> AI=new ArrayList<admin>();
		Database d=new Database();
		
			con=d.connection();
	
		try{
			String sql="Select * from admin";
			PreparedStatement stmt=con.prepareStatement(sql);
		
			ResultSet rs=stmt.executeQuery();
			int user_id;
			String user_screen_name;
			String user_encrypted_password;
			String user_email;
			
			
			while(rs.next())
			{
				
				user_id=rs.getInt("user_id");
				user_screen_name=rs.getString("user_screen_name");
				user_encrypted_password=rs.getString("user_encrypted_password");
				user_email=rs.getString("user_email");
			
				
				admin a=new admin();
				a.setUser_id(user_id);
				a.setUser_screen_name(user_screen_name);
				a.setUser_encrypted_password(user_encrypted_password);
				a.setUser_email(user_email);
		
			
				AI.add(a);
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
		return AI;
		
	}

	//-------------------------------------------------------------Add User--------------------------------------------------------
		public void addUser(admin U)throws SQLException
		{
			Database d=new Database();
			
				con=d.connection();
		
			try{
			String screen_name=U.getUser_screen_name();
			String password=U.getUser_encrypted_password();
			String email=U.getUser_email();
			
			InputStream inputStream = null;
			Part filePart = U.getUser_profile_picture();
			
			if (filePart != null) {
	                // prints out some information for debugging
	                //System.out.println(filePart.getName());
	                //System.out.println(filePart.getSize());
	                //System.out.println(filePart.getContentType());

	                // obtains input stream of the upload file
	                inputStream = filePart.getInputStream();
	               
	                //System.out.println(inputStream);
	            }
			String sql="INSERT INTO psychologist Values (null,?,?,?,?)";
			PreparedStatement stmt=con.prepareStatement(sql);
			
			stmt.setString(1,screen_name);
			stmt.setString(2,email);
			stmt.setString(3,password);
		
		     if (inputStream != null) {
                 // fetches input stream of the upload file for the blob column
             	//System.out.println(inputStream);
             	  stmt.setBinaryStream(4, inputStream, (int) filePart.getSize());
             }
		     else
		     {
		    	 stmt.setString(4,null);
		     }
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
		//-------------------------------------------------------------get user data------------------------------------------------------
		
		public admin getUserInfo(int id)
		{
			admin u=new admin();
			Database d=new Database();
			
				con=d.connection();
	
			try{
				String sql="Select * from psychologist where user_id=?";
				
				PreparedStatement stmt=con.prepareStatement(sql);
				stmt.setInt(1,id);
				ResultSet rs=stmt.executeQuery();
				
				int user_id;
				String user_screen_name;
				String user_encrypted_password;
				String user_email;
				
				
				
				if(!rs.next())
				{
					
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
		//-------------------------------------------------------------update--------------------------------------------------------
		public void updateUser(user U)throws SQLException
		{
			Database d=new Database();
		
				con=d.connection();
		
			try{
			int user_id=U.getUser_id();
			String screen_name=U.getUser_screen_name();
			String password=U.getUser_encrypted_password();
			String email=U.getUser_email();
			String DOB=U.getUser_DOB();
			String first_name=U.getUser_first_name();
			String last_name=U.getUser_last_name();
			String city=U.getUser_city();
			String gender=U.getUser_gender();
			String cell_number=U.getUser_cell_number();
			InputStream inputStream = null;
			Part filePart = U.getUser_profile_picture();
			if (filePart != null) {
                // prints out some information for debugging
                //System.out.println(filePart.getName());
                //System.out.println(filePart.getSize());
                //System.out.println(filePart.getContentType());

                // obtains input stream of the upload file
                inputStream = filePart.getInputStream();
               
                //System.out.println(inputStream);
            }
			 if (inputStream != null) {
				 String sql="update user SET user_id=?,user_screen_name=?,user_encrypted_password=?,user_email=?,user_DOB=?,user_first_name=?,user_last_name=?,user_city=?,user_gender=?,user_cell_number=?,user_profile_picture=? where user_id=?";
					PreparedStatement stmt=con.prepareStatement(sql);
					stmt.setInt(1,user_id);
					stmt.setString(2,screen_name);
					stmt.setString(3,password);
					stmt.setString(4,email);
					stmt.setString(5,DOB);
					stmt.setString(6,first_name);
					stmt.setString(7,last_name);
					stmt.setString(8,city);
					stmt.setString(9,gender);
					stmt.setString(10,cell_number);
					 stmt.setBinaryStream(11, inputStream, (int) filePart.getSize());
					stmt.setInt(12,user_id);
					stmt.executeUpdate();
              
             }
			 else
			 {
				 String sql="update user SET user_id=?,user_screen_name=?,user_encrypted_password=?,user_email=?,user_DOB=?,user_first_name=?,user_last_name=?,user_city=?,user_gender=?,user_cell_number=? where user_id=?";
					PreparedStatement stmt=con.prepareStatement(sql);
					stmt.setInt(1,user_id);
					stmt.setString(2,screen_name);
					stmt.setString(3,password);
					stmt.setString(4,email);
					stmt.setString(5,DOB);
					stmt.setString(6,first_name);
					stmt.setString(7,last_name);
					stmt.setString(8,city);
					stmt.setString(9,gender);
					stmt.setString(10,cell_number);
					stmt.setInt(11,user_id);
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
	
		//--------------------------------------------------------------delete-------------------------------------------------------
		public void deleteStudent(user u)throws SQLException
		{
			
			Database d=new Database();
			
				con=d.connection();
		
			try
			{
				int id=u.getUser_id();
			
			
			String sql="delete from user where user_id=?";
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
		//-------------------------------------------------------------full update--------------------------------------------------
	
	//-----------------------------------------------------------------End----------------------------------------------------------
		

}



			

