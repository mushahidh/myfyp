<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="bean.*" %>
<%@ page import="database.*" %>


<%	
                                    		int gid=0;
										 	int field=0;
											int standard=Integer.parseInt(request.getParameter("standard"));
											int id=Integer.parseInt(request.getParameter("group"));
                                    		groupIncludesDAO GID=new groupIncludesDAO();
                                    		ArrayList<groupIncludes> gI=new ArrayList<groupIncludes>();
                      						gI=GID.retrieveGroupIncludesFieldInfo(id,standard);
                      						groupIncludes Gi =null;
                           					fieldDAO FGD=new fieldDAO();
                           					field f=null;
                           					int i=0;
%>
                           					 <select id="dropdown_field" class="span6 m-wrap" data-placeholder="Choose a Category" tabindex="1">
                           					 
                           					 <% 
                           						for(i=0;i<gI.size();i++)
                           						{
                           							Gi=(groupIncludes)gI.get(i);
	 												f=FGD.getFieldInfo(Gi.getField_idd());
	 											%>
	 												 <option value="<%= f.getField_id() %>" onClick="university();" /><%= f.getField_name() %>
	 												
    											<% }
                           							
    											%>
    								
    									</select>
    									
   
                                    		
                                    	
                 					