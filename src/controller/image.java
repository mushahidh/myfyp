package controller;



import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/image")
public class image extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public image() {
        super();
       
    }
private Connection con;
	
	
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
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int id = Integer.parseInt(request.getParameter("id"));
		
	
		
try{
			
			connection();
			String sql="Select * from user where user_id=?";
			java.sql.PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setInt(1, id);
			java.sql.ResultSet resultset=stmt.executeQuery();
			resultset.next();
			java.sql.Blob bl = resultset.getBlob("user_profile_picture");
			if(bl !=null)
			{
				byte[] pict = bl.getBytes(1,(int)bl.length());
				OutputStream o = response.getOutputStream();
				response.setContentType("image/*");
				o.write(pict);
				o.flush();
				o.close();
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			getResource();
		}

	}



}
