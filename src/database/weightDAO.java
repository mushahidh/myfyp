package database;

import bean.*;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;





public class weightDAO implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private Connection con;
	
	public weightDAO()
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
	//----------------------------------------Retrieve weight info----------------------------
	public ArrayList<course> retrieveCourseInfo()
	{
		ArrayList<course> CI=new ArrayList<course>();
		Database d=new Database();
		
			con=d.connection();
		
		try{
			String sql="Select * from course";
			PreparedStatement stmt=con.prepareStatement(sql);
		
			ResultSet rs=stmt.executeQuery();
			int course_id;
			String course_name;

			while(rs.next())
			{
				
				course_id=rs.getInt("course_id");
				course_name=rs.getString("course_name");
				
				course c=new course();
				c.setCourse_id(course_id);
				c.setCourse_name(course_name);
			
				CI.add(c);
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
		return CI;
		
	}

	//-------------------------------------------------------------Add weight--------------------------------------------------------
		public void addweight(weight w )throws SQLException
		{
			Database d=new Database();
			
				con=d.connection();
		
			try
			{
			int user_id=w.getUser_id();
			int field_id=w.getField_id();
			int weight=w.getWeight();
		
			String sql="INSERT INTO weight_calculation Values (?,?,?)";
			PreparedStatement stmt=con.prepareStatement(sql);
			
			stmt.setInt(1,user_id);
			stmt.setInt(2,field_id);
			stmt.setInt(3,weight);
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
		//-------------------------------------------------------------Add weight--------------------------------------------------------
				public void addRecommendation(weight w )throws SQLException
				{
					Database d=new Database();
					
						con=d.connection();
					
					try
					{
					int user_id=w.getUser_id();
					int field_id=w.getField_id();
				
					String sql="INSERT INTO recommendation Values (?,?)";
					PreparedStatement stmt=con.prepareStatement(sql);
					
					stmt.setInt(1,user_id);
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
		//-------------------------------------------------------------get weight result------------------------------------------------------
		
		public int getWeightResult(int id)
		{
			
			int result=0;
			Database d=new Database();
			
				con=d.connection();
		
			try{
				String sql="Select * from weight_calculation where field_id=?";
				
				PreparedStatement stmt=con.prepareStatement(sql);
				stmt.setInt(1,id);
				ResultSet rs=stmt.executeQuery();
				
			
				if (!rs.next()){
					result=0;
				}
				else{
					result=1;
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
			return result;
		}
		//-------------------------------------------------------------get result info-----------------------------------------------
		public weight getWeightInfo(int id)
		{
			weight w=new weight();
			Database d=new Database();
			
				con=d.connection();
		
			try{
				String sql="Select * from weight_calculation where field_id=?";
				
				PreparedStatement stmt=con.prepareStatement(sql);
				stmt.setInt(1,id);
				ResultSet rs=stmt.executeQuery();
				
				int user_id;
				int field_id;
				int weight;
				
				
			
					rs.next();
					user_id=rs.getInt("user_id");
					field_id=rs.getInt("field_id");
					weight=rs.getInt("weight");
					w.setUser_id(user_id);
					w.setField_id(field_id);
					w.setWeight(weight);
					}
			
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				d.getResource();
			}
			return w;
		}
		//---------------------------------------------------------------retreive weights of user------------------------------------
		public ArrayList<weight> retrieveWeightInfo(int user_idd,int standard)
		{
			ArrayList<weight> WI=new ArrayList<weight>();
			fieldDAO FD=new fieldDAO();
			field f=null;
			Database d=new Database();
			
				con=d.connection();
		
			try{
				String sql="Select * from weight_calculation ";
				PreparedStatement stmt=con.prepareStatement(sql);
				
				ResultSet rs=stmt.executeQuery();
				int user_id;
				int field_id;
				int weight;

				while(rs.next())
				{
					
					
					user_id=rs.getInt("user_id");
					field_id=rs.getInt("field_id");
					weight=rs.getInt("weight");
					weight w=new weight();
					w.setUser_id(user_id);
					w.setField_id(field_id);
					w.setWeight(weight);
					f=FD.getFieldInfo(field_id);
					if(standard==12)
					{
						if(f.getField_standard()==16)
						{
							WI.add(w);
						}
					}
					else if(standard==16)
					{
						if(f.getField_standard()==18)
						{
							WI.add(w);
						}
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
			return WI;
			
		}
		//-------------------------------------------------------------update--------------------------------------------------------
		public void updateWeight(weight w)throws SQLException
		{
			Database d=new Database();
			
				con=d.connection();
			
			try
			{
			int field_id=w.getField_id();
			int user_id=w.getUser_id();
			int weight=w.getWeight();
			String sql="update weight_calculation SET weight=? where field_id=? AND user_id=?";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setInt(1,weight);
			stmt.setInt(2,field_id);
			stmt.setInt(3,user_id);
			
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
	
	
		//-----------------------------------------------------------------affect course----------------------------------------------------
		public ArrayList<affect> retrieveAffectInfo(int id)
		{
			ArrayList<affect> AI=new ArrayList<affect>();
			Database d=new Database();
			
				con=d.connection();
	
			try{
				String sql="Select * from affect where course_id=?";
				PreparedStatement stmt=con.prepareStatement(sql);
				stmt.setInt(1, id);
				ResultSet rs=stmt.executeQuery();
				int field_id;
				int course_id;
				int weight;
				while(rs.next())
				{
					
					field_id=rs.getInt("field_id");
					course_id=rs.getInt("course_id");
					weight=rs.getInt("weight");
				
					affect a=new affect();
					a.setField_id(field_id);
					a.setCourse_id(course_id);
					a.setWeight(weight);
					
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

	//-----------------------------------------------------------------------------------------------------------------------------
		public ArrayList<weight> retrieveInterestInfo(UserInterest UI)
		{
			
			Database d=new Database();
			
				con=d.connection();
	
			ArrayList<weight> WI =new ArrayList<weight>();
			weight w=new weight();
			int realistic=UI.getRealistic();
			int investigative=UI.getInvestigative();
			int artistic=UI.getArtistic();
			int social=UI.getSocial();
			int enterprising=UI.getEnterprising();
			int conventional=UI.getConventional();
			int i=0;
			int flag=0;
			int weight=25000;
			int interest_variables=0;
			
			
			try{
				
				while(interest_variables<=100)
				{
					
					String sql="Select * from holland_codes where realistic BETWEEN ? AND ? AND investigative BETWEEN ? AND ? AND artistic BETWEEN ? AND ? AND social BETWEEN ? AND ? AND enterprising BETWEEN ? AND ? AND conventional BETWEEN ? AND ? ";
					PreparedStatement stmt=con.prepareStatement(sql);
					stmt.setInt(1, realistic-interest_variables);
					stmt.setInt(2, realistic+interest_variables);
					stmt.setInt(3, investigative-interest_variables);
					stmt.setInt(4, investigative+interest_variables);
					stmt.setInt(5, artistic-interest_variables);
					stmt.setInt(6, artistic+interest_variables);
					stmt.setInt(7, social-interest_variables);
					stmt.setInt(8, social+interest_variables);
					stmt.setInt(9, enterprising-interest_variables);
					stmt.setInt(10, enterprising+interest_variables);
					stmt.setInt(11, conventional-interest_variables);
					stmt.setInt(12, conventional+interest_variables);
					ResultSet rs=stmt.executeQuery();
					if (rs.next()){
						for(i=0;i<WI.size();i++)
						{
							w=(weight)WI.get(i);
							
							if((rs.getInt("field_id"))==w.getField_id())
							{
								flag=1;
								break;
							}
						}
						if(flag!=1)
						{
							 	w=new weight();
								w.setField_id(rs.getInt("field_id"));
								w.setWeight(weight);
								WI.add(w);			
								System.out.println(rs.getInt("field_id"));
								flag=0;
						}
							
						while(rs.next())
						{
							
							flag=0;
							for(i=0;i<WI.size();i++)
							{
								w=(weight)WI.get(i);
								
								
							}
							for(i=0;i<WI.size();i++)
							{
								w=(weight)WI.get(i);
								
								if((rs.getInt("field_id"))==w.getField_id())
								{
									flag=1;
									break;
								}
							}
							if(flag!=1)
							{
								 	w=new weight();
									w.setField_id(rs.getInt("field_id"));
									w.setWeight(weight);
									WI.add(w);
									
									flag=0;
							}
							
								
							
						}
					
					}
					interest_variables=interest_variables+2;
					weight=weight-500;
					
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
			return WI;
			
			
		}
		//-----------------------------------------------------------------------------------------------------------------------------
				public ArrayList<weight> explanationInterestInfo(UserInterest UI)
				{
					
					Database d=new Database();
					
						con=d.connection();
					
					ArrayList<weight> WI =new ArrayList<weight>();
					weight w=new weight();
					int realistic=UI.getRealistic();
					int investigative=UI.getInvestigative();
					int artistic=UI.getArtistic();
					int social=UI.getSocial();
					int enterprising=UI.getEnterprising();
					int conventional=UI.getConventional();
					int i=0;
					int flag=0;
					int weight=5000;
					int interest_variables=0;
					int count=6;
					
					
					try{
						
						while(interest_variables<=100)
						{
							
							String sql="Select * from holland_codes where realistic BETWEEN ? AND ? AND investigative BETWEEN ? AND ? AND artistic BETWEEN ? AND ? AND social BETWEEN ? AND ? AND enterprising BETWEEN ? AND ? AND conventional BETWEEN ? AND ? ";
							PreparedStatement stmt=con.prepareStatement(sql);
							stmt.setInt(1, realistic-interest_variables);
							stmt.setInt(2, realistic+interest_variables);
							stmt.setInt(3, investigative-interest_variables);
							stmt.setInt(4, investigative+interest_variables);
							stmt.setInt(5, artistic-interest_variables);
							stmt.setInt(6, artistic+interest_variables);
							stmt.setInt(7, social-interest_variables);
							stmt.setInt(8, social+interest_variables);
							stmt.setInt(9, enterprising-interest_variables);
							stmt.setInt(10, enterprising+interest_variables);
							stmt.setInt(11, conventional-interest_variables);
							stmt.setInt(12, conventional+interest_variables);
							ResultSet rs=stmt.executeQuery();
							
								while(rs.next())
								{
									
									flag=0;
								
									for(i=0;i<WI.size();i++)
									{
										w=(weight)WI.get(i);
										
										if((rs.getInt("field_id"))==w.getField_id())
										{
											flag=1;
											break;
										}
									}
									if(flag!=1)
									{
										 	w=new weight();
											w.setField_id(rs.getInt("field_id"));
											w.setWeight(weight);
											WI.add(w);
											flag=0;
											count=count-1;
											if(count==0)
											{
												break;
											}
											
									}
									
										
									
								}
								interest_variables=interest_variables+1;
								weight=weight-50;
								
								
								if(count==0)
								{
									break;
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
					return WI;
					
					
				}
		//--------------------------------------------------------------delete-------------------------------------------------------
		public void deleteWeight(weight w)throws SQLException
		{
			Database d=new Database();
			
				con=d.connection();
		
			try
			{
			int user_id=w.getUser_id();
			int field_id=w.getField_id();
			
			String sql="delete from weight_calculation where user_id=? AND field_id=?";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setInt(1,user_id);
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
		//--------------------------------------------------------------delete-------------------------------------------------------
		public void deleteWeight1(weight w)throws SQLException
		{
			Database d=new Database();
		
				con=d.connection();
		
			try
			{
			int user_id=w.getUser_id();
			
			
			String sql="delete from weight_calculation where user_id=? ";
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
		//--------------------------------------------------------------delete-------------------------------------------------------
				public void deleteReccomendation(int user_id)throws SQLException
				{
					
					Database d=new Database();
					
						con=d.connection();
				
					try
					{
					String sql="delete from recommendation where user_id=? ";
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
		


public ArrayList<weight> retrieveRecommendInfo(int id)
{
	ArrayList<weight> WI=new ArrayList<weight>();
	Database d=new Database();
	
		con=d.connection();

	try{
		String sql="Select * from recommendation where user_id=?";
		PreparedStatement stmt=con.prepareStatement(sql);
		stmt.setInt(1, id);
		ResultSet rs=stmt.executeQuery();
		int field_id;
		while(rs.next())
		{
			
			field_id=rs.getInt("field_id");
			
		
			weight w=new weight();
			w.setField_id(field_id);
			
			
			WI.add(w);
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
	return WI;
	
}
//-----------------------------------------------------------------End----------------------------------------------------------


}



			

