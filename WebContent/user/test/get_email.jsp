<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="bean.*" %>
<%@ page import="database.*" %>


<%	
                                    		
												int flag=0;
												String Email=request.getParameter("email");
                                    			userDAO UD=new userDAO();
                                    			flag=UD.getEmailInfo(Email);
                                    			if(flag==1)
                                    			{
                                    				%>
                                    			 Available
                                    			<% }
                                    			else
                                    			{%>Not Available
                                    		<%}%>
                 					