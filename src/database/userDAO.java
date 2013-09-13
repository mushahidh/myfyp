package database;

import bean.*;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.http.Part;





public class userDAO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Connection con;
	
	public userDAO()
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
	public ArrayList<user> retrieveUserInfo()
	{
		ArrayList<user> UI=new ArrayList<user>();
		Database d=new Database();
		
			con=d.connection();
	
		try{
			String sql="Select * from user";
			PreparedStatement stmt=con.prepareStatement(sql);
		
			ResultSet rs=stmt.executeQuery();
			int user_id;
			String user_screen_name;
			String user_encrypted_password;
			String user_email;
			String user_DOB;
			String user_first_name;
			String user_last_name;
			String user_city;
			String user_gender;
			String user_cell_number;
			
			while(rs.next())
			{
				
				user_id=rs.getInt("user_id");
				user_screen_name=rs.getString("user_screen_name");
				user_encrypted_password=rs.getString("user_encrypted_password");
				user_email=rs.getString("user_email");
				user_DOB=rs.getString("user_DOB");
				user_first_name=rs.getString("user_first_name");
				user_last_name=rs.getString("user_last_name");
				user_city=rs.getString("user_city");
				user_gender=rs.getString("user_gender");
				user_cell_number=rs.getString("user_cell_number");
				
				user u=new user();
				u.setUser_id(user_id);
				u.setUser_screen_name(user_screen_name);
				u.setUser_encrypted_password(user_encrypted_password);
				u.setUser_email(user_email);
				u.setUser_DOB(user_DOB);
				u.setUser_first_name(user_first_name);
				u.setUser_first_name(user_first_name);
				u.setUser_last_name(user_last_name);
				u.setUser_city(user_city);
				u.setUser_gender(user_gender);
				u.setUser_cell_number(user_cell_number);
			
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

	//-------------------------------------------------------------Add User--------------------------------------------------------
		public void addUser(user U)throws SQLException
		{
			Database d=new Database();
			
				con=d.connection();
		
			try{
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
			String sql="INSERT INTO user Values (null,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement stmt=con.prepareStatement(sql);
			
			stmt.setString(1,screen_name);
			stmt.setString(2,password);
			stmt.setString(3,email);
			stmt.setString(4,DOB);
			stmt.setString(5,first_name);
			stmt.setString(6,last_name);
			stmt.setString(7,city);
			stmt.setString(8,gender);
			stmt.setString(9,cell_number);
		     if (inputStream != null) {
                 // fetches input stream of the upload file for the blob column
             	//System.out.println(inputStream);
             	  stmt.setBinaryStream(10, inputStream, (int) filePart.getSize());
             }
		     else
		     {
		    	 stmt.setString(10,null);
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
		
		public user getUserInfo(int id)
		{
			user u=new user();
			Database d=new Database();
			
				con=d.connection();
		
			try{
				String sql="Select * from user where user_id=?";
				
				PreparedStatement stmt=con.prepareStatement(sql);
				stmt.setInt(1,id);
				ResultSet rs=stmt.executeQuery();
				
				int user_id;
				String user_screen_name;
				String user_encrypted_password;
				String user_email;
				String user_DOB;
				String user_first_name;
				String user_last_name;
				String user_city;
				String user_gender;
				String user_cell_number;
				
				
				rs.next();
					
					user_id=rs.getInt("user_id");
					user_screen_name=rs.getString("user_screen_name");
					user_encrypted_password=rs.getString("user_encrypted_password");
					user_email=rs.getString("user_email");
					user_DOB=rs.getString("user_DOB");
					user_first_name=rs.getString("user_first_name");
					user_last_name=rs.getString("user_last_name");
					user_city=rs.getString("user_city");
					user_gender=rs.getString("user_gender");
					user_cell_number=rs.getString("user_cell_number");
					
					
					u.setUser_id(user_id);
					u.setUser_screen_name(user_screen_name);
					u.setUser_encrypted_password(user_encrypted_password);
					u.setUser_email(user_email);
					u.setUser_DOB(user_DOB);
					u.setUser_first_name(user_first_name);
					u.setUser_last_name(user_last_name);
					u.setUser_city(user_city);
					u.setUser_gender(user_gender);
					u.setUser_cell_number(user_cell_number);
				
					
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
		//-------------------------------------------------------------get user data------------------------------------------------------
		
				public int getEmailInfo(String Email)
				{
					int flag=0;
					Database d=new Database();
					
						con=d.connection();
				
					try{
						String sql="Select * from user where user_email=?";
						
						PreparedStatement stmt=con.prepareStatement(sql);
						stmt.setString(1,Email);
						ResultSet rs=stmt.executeQuery();
												
						if(!rs.next())
						{
							flag=1;
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
					return flag;
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
					
				inputStream = filePart.getInputStream();
               
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



			

