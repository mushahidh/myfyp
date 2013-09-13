<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="bean.*" %>
<%@ page import="database.*" %>


<%	
                                    		int gid=0;
										 	int field=0;

												int id=Integer.parseInt(request.getParameter("group"));
                                    			groupIncludesDAO GID=new groupIncludesDAO();
                                    			ArrayList<groupIncludes> gI=new ArrayList<groupIncludes>();
                      							gI=GID.retrieveGroupIncludesInfo(id);
                      							groupIncludes Gi =null;
                           						fieldDAO FGD=new fieldDAO();
                           						field fg=null;
                           						testDAO TDD=new testDAO();
                      							ArrayList<includes> EII=new ArrayList<includes>();
                       							 while(gid<gI.size())
    											{
														
    	 												Gi=(groupIncludes)gI.get(gid);
    	 												fg=FGD.getFieldInfo(Gi.getField_idd());
    	 												
    	 												if(gid==0)
    	 												{
    	 													
    	 													
    	 													EII=TDD.retrieveIncludesInfo(fg.getField_id());
    	 												%>
    	 											
    	 													
    	 												<button type="button" id="field<%=gid%>" value="12" class="btn green" onClick="javaScript:field('<%=fg.getField_name() %>','<%=gI.size()%>','<%=gid%>','<%=fg.getField_id() %>','<%=EII.size() %>');" ><%=fg.getField_name() %></button>
    	 												<%field=fg.getField_id();
    	 											
    	 												
    	 												}
    	 												else
    	 												{
    	 													
    	 													EII=TDD.retrieveIncludesInfo(fg.getField_id());
    	 												%>
    														
    											
    													<button type="button" id="field<%=gid%>" value="12" class="btn blue" onClick="javaScript:field('<%=fg.getField_name() %>','<%=gI.size()%>','<%=gid%>','<%=fg.getField_id() %>','<%=EII.size() %>');" ><%=fg.getField_name() %></button>
    													<%
    	 												}	
    													gid=gid+1;
    											}
    									
    									
                                    		
                                    		%>
                 					