<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="bean.*" %>
<%@ page import="database.*" %>
<div class="portlet box yellow">
							<div class="portlet-title">
								<h4><i class="icon-cogs"></i>System Has Recommended You The Following Universities</h4>
							
							</div>
							
			  				 <%
			  						int field_id=Integer.parseInt(request.getParameter("field"));
									String location=request.getParameter("location");
			  				 		universityDAO UD=new universityDAO();
									ArrayList<university> UI=new ArrayList<university>();
									UI=UD.universityFinder(location,field_id);
									university u=null;
									int k=0;
									for(int i=0;i<UI.size();i++)
									{
										u=(university)UI.get(i);
          				  %>
									
									<% if(k==0)
									{%>
									<div class="portlet box yellow">
									<div class="portlet-body">
									<div class="row-fluid">
									<% }%>
									<div class="span3">
										<div class="pricing-table">
											<h3><%=u.getUni_name() %></h3>
											<div class="desc">
												
											</div>
											<ul>
												<li>Courses</li>
												<li>English</li>
												<li>Numerical Computation</li>
												<li>Software Engineering</li>
												<li>Calculus</li>
												<li>ECA</li>
												<li>&nbsp;</li>
												<li>&nbsp;</li>
												<li>&nbsp;</li>
												<li>&nbsp;</li>
											</ul>
										</div>
									</div>
									<%if(k==3||(UI.size()==i+1))
									{%>
									<div class="spance10 visible-phone"></div>
									<div class="span3"></div>
                                    <div class="span3"></div>
                                    <div class="span3"></div>
									<div class="spance10 visible-phone"></div>
									<div class="span3"></div>
									<div class="spance10 visible-phone"></div>
									<div class="span3"></div>
								</div>
							</div>
						</div>
						</div>
                        <% }%>
                        <%
									k=k+1;
                        if(k==4)
                        {
                        	k=0;
                        }
									} %>
						