package database;
import bean.*;
import java.io.*;
import java.sql.*;
public class explanation_courseDAO implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private Connection con;
	
	public explanation_courseDAO()
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


	//-------------------------------------------------------------Add question--------------------------------------------------------
		public void addExplanationCourse(explanation_course ec)throws SQLException
		{
			Database d=new Database();
			
				con=d.connection();
		
			try
			{
			int user_id=ec.getUser_id();
			int [] course_id=ec.getCourse_id();
			int [] course_marks=ec.getCourse_marks();
			int [] course_enjoyment_value=ec.getCourse_enjoyment_value();
			int size = course_id.length;
			for(int i=0;i<size;i++)
			{	
			
				String sql="INSERT INTO explanation_course Values (?,?,?,?)";
				PreparedStatement stmt=con.prepareStatement(sql);
				stmt.setInt(1,user_id);
				stmt.setInt(2,course_id[i]);
				stmt.setInt(3,course_marks[i]);
				stmt.setInt(4,course_enjoyment_value[i]);
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
		//-------------------------------------------------------------get question data------------------------------------------------------
		
		public explanation_course getExplanationCourseInfo(int u_id)
		{
			explanation_course ec=new explanation_course();
			Database d=new Database();
			
				con=d.connection();
		
			try{
					String sql="Select * from explanation_course where user_id=?";
					
					PreparedStatement stmt=con.prepareStatement(sql);
					stmt.setInt(1,u_id);
					ResultSet rs=stmt.executeQuery();
					int user_id;
					
				
					if(!rs.next())
					{
						ec=null;
						
					}
					else
					{
						user_id=rs.getInt("user_id");
						ec.setUser_id(user_id);
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
			return ec;
		}

	//-------------------------------------------------------------get question data------------------------------------------------------
		
		public explanation_course getExplanationCourseInfo(int u_id,int c_id)
		{
			explanation_course ec=new explanation_course();
			Database d=new Database();
			
				con=d.connection();
		
			try{
					String sql="Select * from explanation_course where user_id=? and course_id=?";
					
					PreparedStatement stmt=con.prepareStatement(sql);
					stmt.setInt(1,u_id);
					stmt.setInt(2,c_id);
					ResultSet rs=stmt.executeQuery();
					int user_id;
					int course_id;
					int course_marks;
					int course_enjoyment_marks;
					
				
					if(!rs.next())
					{
						ec=null;
						
					}
					else
					{
						user_id=rs.getInt("user_id");
						course_id=rs.getInt("course_id");
						course_marks=rs.getInt("course_value");
						course_enjoyment_marks=rs.getInt("course_enjoyment_value");
						ec.setUser_id(user_id);
						ec.setCourse_idd(course_id);
						ec.setCourse_markss(course_marks);
						ec.setCourse_enjoyment_valuee(course_enjoyment_marks);
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
			return ec;
		}

	
		//--------------------------------------------------------------delete-------------------------------------------------------
		public void deleteExplanationCourse(int user_id)throws SQLException
		{
			Database d=new Database();
			
				con=d.connection();
		
			try
			{
			
			String sql="delete from explanation_course where user_id=?";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setInt(1,user_id);
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
		//-------------------------------------------------------------Add question--------------------------------------------------------
				public void addExplanation(explanation e)throws SQLException
				{
					Database d=new Database();
				
						con=d.connection();
				
					try
					{
						int user_id=e.getUser_id();
						int standard=e.getStandard();
						int field_id=e.getField_id();
						int field_group_id=e.getField_group_id();
						int realistic=e.getRealistic();
						int artistic=e.getArtistic();
						int conventional=e.getConventional();
						int social=e.getSocial();
						int investigative=e.getInvestigative();
						int enterprising=e.getEnterprising();
						String sql="INSERT INTO explanation Values (?,?,?,?,?,?,?,?,?,?)";
						PreparedStatement stmt=con.prepareStatement(sql);
						stmt.setInt(1,user_id);
						stmt.setInt(2,standard);
						stmt.setInt(3,field_group_id);
						stmt.setInt(4,field_id);
						stmt.setInt(5,realistic);
						stmt.setInt(6,artistic);
						stmt.setInt(7,social);
						stmt.setInt(8,enterprising);
						stmt.setInt(9,conventional);
						stmt.setInt(10,investigative);
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
				public explanation getExplanationInfo(int u_id)
				{
					explanation e=new explanation();
					Database d=new Database();
				
						con=d.connection();
				
					try{
							String sql="Select * from explanation where user_id=?";
							
							PreparedStatement stmt=con.prepareStatement(sql);
							stmt.setInt(1,u_id);
							ResultSet rs=stmt.executeQuery();
							int user_id;
							int standard;
							int field_group_id;
							int field_id;
							int realistic;
							int artistic;
							int social;
							int enterprising;
							int conventional;
							int investigative;
							
						
							if(!rs.next())
							{
								e=null;
								
							}
							else
							{
								user_id=rs.getInt("user_id");
								standard=rs.getInt("standard");
								field_group_id=rs.getInt("field_group_id");
								field_id=rs.getInt("field_id");
								realistic=rs.getInt("realistic");
								artistic=rs.getInt("artistic");
								social=rs.getInt("social");
								enterprising=rs.getInt("enterprising");
								conventional=rs.getInt("conventional");
								investigative=rs.getInt("investigative");
								
								e.setUser_id(user_id);
								e.setStandard(standard);
								e.setField_group_id(field_group_id);
								e.setField_id(field_id);
								e.setRealistic(realistic);
								e.setArtistic(artistic);
								e.setSocial(social);
								e.setEnterprising(enterprising);
								e.setConventional(conventional);
								e.setInvestigative(investigative);
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
					return e;
				}

				public void deleteExplanation(int user_id)throws SQLException
				{
					Database d=new Database();
					
						con=d.connection();
				
					try
					{
					
					String sql="delete from explanation where user_id=?";
					PreparedStatement stmt=con.prepareStatement(sql);
					stmt.setInt(1,user_id);
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



			

