package database;

import bean.*;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;





public class questionDAO implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private Connection con;
	
	public questionDAO()
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
	//----------------------------------------Retrieve question info----------------------------
	public ArrayList<question> retrieveQuestionInfo(String typee)
	{
		ArrayList<question> QI=new ArrayList<question>();
		Database d=new Database();
		
			con=d.connection();
		
		try{
			String sql="Select * from question where type=?";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setString(1, typee);
			ResultSet rs=stmt.executeQuery();
			String question;
			String type;
			int question_id;

			while(rs.next())
			{
				
				question_id=rs.getInt("question_id");
				question=rs.getString("question");
				type=rs.getString("type");
				question q=new question();
				q.setQuestion_id(question_id);
				q.setQuestion(question);
				q.setType(type);
				QI.add(q);
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
		return QI;
		
	}
	//----------------------------------------Retrieve question info----------------------------
		public ArrayList<question> retrieveQuestionInfo()
		{
			ArrayList<question> QI=new ArrayList<question>();
			Database d=new Database();
			
				con=d.connection();
		
			try{
				String sql="Select * from question ";
				PreparedStatement stmt=con.prepareStatement(sql);
			
				ResultSet rs=stmt.executeQuery();
				String question;
				String type;
				int question_id;

				while(rs.next())
				{
					
					question_id=rs.getInt("question_id");
					question=rs.getString("question");
					type=rs.getString("type");
					question q=new question();
					q.setQuestion_id(question_id);
					q.setQuestion(question);
					q.setType(type);
					QI.add(q);
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
			return QI;
			
		}

	//-------------------------------------------------------------Add question--------------------------------------------------------
		public void addQuestion(question q)throws SQLException
		{
			Database d=new Database();
			
				con=d.connection();
		
			try
			{
			String question=q.getQuestion();
			String type=q.getType();
		
			String sql="INSERT INTO question Values (null,?,?)";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setString(1,question);
			stmt.setString(2,type);
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
		//-------------------------------------------------------------get question data------------------------------------------------------
		
		public question getQuestionInfo(int q_id)
		{
			question q=new question();
			Database d=new Database();
			
				con=d.connection();
		
			try{
				String sql="Select * from question where question_id=?";
				
				PreparedStatement stmt=con.prepareStatement(sql);
				stmt.setInt(1,q_id);
				ResultSet rs=stmt.executeQuery();
				int question_id;
				String question;
				String type;
			
				rs.next();
					
					question_id=rs.getInt("question_id");
					question=rs.getString("question");
					type=rs.getString("type");
					q.setQuestion_id(question_id);
					q.setQuestion(question);
					q.setType(type);
					
					
					}
			
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				d.getResource();
			}
			return q;
		}
		//-------------------------------------------------------------update--------------------------------------------------------
		public void updateQuestion(question q)throws SQLException
		{
			Database d=new Database();
			
				con=d.connection();
		
			try
			{
			String question =q.getQuestion();
			String type=q.getType();
			int question_id=q.getQuestion_id();
			String sql="update question SET question_id=?,question=?,type=? where question_id=?";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setInt(1, question_id);
			stmt.setString(2,question);
			stmt.setString(3,type);
			stmt.setInt(4, question_id);
			
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
		public void deleteQuestion(question q)throws SQLException
		{
			Database d=new Database();
			
				con=d.connection();
		
			try
			{
			int question_id=q.getQuestion_id();
			String sql="delete from question where question_id=?";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setInt(1,question_id);
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



			

