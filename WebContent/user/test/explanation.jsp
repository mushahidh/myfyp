<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="bean.*" %>
<%@ page import="database.*" %>
<html>
<head>
<title>ICGS EXPLANATION</title>
<link rel="shortcut icon" href="../../resources/css/images/favicon.png">
<link href="../../user_resources/assets/css/arrowsandboxes.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../../user_resources/assets/js/jquery-1.4.1.min.js"></script>
<script src="../../user_resources/assets/js/jquery_wz_jsgraphics.js" type="text/javascript"></script>
<script src="../../user_resources/assets/js/arrowsandboxes.js" type="text/javascript"></script>
</head>
<body>
											<%
											  user user=new user();
										      user = (user) session.getAttribute("user");
											%>
											<%
												explanation_courseDAO ED=new explanation_courseDAO();
												explanation e=new explanation();
												explanation_course ec=new explanation_course();
												e=ED.getExplanationInfo(user.getUser_id());
											
											%>
											
											<% 
												int gt=0;
												int gt1=0;
												groupDAO GD=new groupDAO();
	                  							ArrayList<group> GA=new ArrayList<group>();
	                   							GA=GD.retrieveGroupInfo(12);
	                   							int gt_size=GA.size();
	                       						group g=null;											
											%>
											<% 
												int gti=0;
												int gti1=0;
												ArrayList<groupIncludes> GIA=new ArrayList<groupIncludes>();
												groupIncludesDAO GDI=new groupIncludesDAO();
	                   							GIA=GDI.retrieveGroupIncludesInfo(e.getField_group_id());
	                   							int gti_size=GIA.size();
	                       						groupIncludes gi=null;	
	                       						field fgi=new field();
	                       						fieldDAO FGD=new fieldDAO();
											%>
											
											   <%
                 									
                                                    includesDAO ID=new includesDAO();
                                                    ArrayList<includes> IA=new ArrayList<includes>();
                                                   	IA=ID.retrieveIncludesInfo(e.getField_id());
                                             		int it=0;
                                             		int it1=0;
                                             		int it_size=IA.size();
                                             		includes i=null;
                                             		courseDAO CD=new courseDAO();
                                             		course c=null;
               								  %>
               								  <%
      												field f=new field();
               								  		fieldDAO FD=new fieldDAO();
                                                    affectDAO AD=new affectDAO();
                                                    ArrayList<affect> AI=new ArrayList<affect>();
                                                    affect a=null;
                                                    int at=0;
                                                   
                
                                                   	
                 							%>
                 							<% 
	                 							weightDAO WD=new weightDAO();
	                 							ArrayList<weight> WI=new ArrayList<weight>();
	                 							WI=WD.retrieveRecommendInfo(user.getUser_id());
	                 							weight w=null;
	                 							
	                 							int rt=0;
                 							%>
                 							<%
                 								UserInterest ui=new UserInterest();
                 								ui.setRealistic(e.getRealistic());
                 								ui.setSocial(e.getSocial());
                 								ui.setArtistic(e.getArtistic());
                 								ui.setConventional(e.getConventional());
                 								ui.setEnterprising(e.getEnterprising());
                 								ui.setInvestigative(e.getInvestigative());
                 								
                 								ArrayList<weight> WIE=new ArrayList<weight>();
                 								WIE=WD.explanationInterestInfo(ui);	
                 								
                 								int et=0;
                 							
                 							%>
                 						
                 										
											
<pre class="arrows-and-boxes">()()()()()()(Explanation-[n3,n2]) || 
()()()(n2: Personality-[n5,n6,n7,n8,n9,n10]) ()()()()()(n3:Standard-[n4] )||
()(n5: Realistic-[n12]) (n6: Investigative-[n13]) (n7: Social-[n14]) (n8: Artistic-[n15]) (n9: Conventional-[n16]) (n10: Enterprising-[n17])()()()()(n4: 12th-[n11]) ||
()(n12:<%=e.getRealistic()%>%-[result]) (n13:<%=e.getInvestigative()%>%-[result]) (n14:<%=e.getSocial()%>%-[result]) (n15:<%=e.getArtistic()%>%-[result])(n16:<%=e.getConventional()%>%-[result])(n17:<%=e.getEnterprising()%>%-[result])()()()() (n11:Group-[<% while(gt1<GA.size()){	g=(group)GA.get(gt1);if((gt1+1)!=gt_size){%><%=g.getGroup_name() %>,<%} else{ %><%=g.getGroup_name() %><%}gt1=gt1+1;} %>])|| ()||()||
()()()(result:result-[personality_field])()()()()()() <% while(gt<GA.size()){	g=(group)GA.get(gt);%><%if(g.getGroup_id()==e.getField_group_id()) {%>(<%=g.getGroup_name() %>:<%=g.getGroup_name() %>-[<% while(gti1<GIA.size()){	gi=(groupIncludes)GIA.get(gti1); fgi=FGD.getFieldInfo( gi.getField_idd());if((gti1+1)!=gti_size){%><%=fgi.getField_name() %>,<%} else{ %><%=fgi.getField_name() %><%}gti1=gti1+1;} %>])<%} else{%>(<%=g.getGroup_name() %>:<%=g.getGroup_name() %>)<%}%><%gt=gt+1;} %>||()||


()()()(personality_field:means you are good in-[<%et=0; while(et<WIE.size()){w=(weight)WIE.get(et); f=FD.getFieldInfo(w.getField_id());if(et+1!=WIE.size()){%><%=f.getField_name()%>_e,<%}else{ %><%=f.getField_name()%>_e <%}et=et+1;} %>])()()()()()()<% while(gti<GIA.size()){	gi=(groupIncludes)GIA.get(gti); fgi=FGD.getFieldInfo( gi.getField_idd());%><%if(gi.getField_idd()==e.getField_id()) {%>(<%=fgi.getField_name() %>:<%=fgi.getField_name() %>-[<% while(it1<IA.size()){	i=(includes)IA.get(it1);c=CD.getCourseInfo(i.getCourse_idd());if((it1+1)!=it_size){%><%=c.getCourse_name() %>,<%} else{ %><%=c.getCourse_name() %><%}it1=it1+1;} %>])<%} else{%>(<%=fgi.getField_name() %>:<%=fgi.getField_name() %>)<%}%><%gti=gti+1;} %>||()||

<%et=0; while(et<WIE.size()){w=(weight)WIE.get(et); f=FD.getFieldInfo(w.getField_id());%>(<%=f.getField_name()%>_e:<%=f.getField_name() %>-[recommend])<%et=et+1;} %>()()()()()()()()() <% while(it<IA.size()){	i=(includes)IA.get(it); c=CD.getCourseInfo(i.getCourse_idd());%><%if(i.getField_id()==e.getField_id()) {%>(<%=c.getCourse_name() %>:<%=c.getCourse_name() %>-[<%=c.getCourse_name() %>_m,<%=c.getCourse_name() %>_l])<%} else{%>(<%=c.getCourse_name() %>:<%=c.getCourse_name() %>)<%}%><%it=it+1;} %>||

()()()()()()() <%it=0; while(it<IA.size()){	i=(includes)IA.get(it); ec=ED.getExplanationCourseInfo(user.getUser_id(), i.getCourse_idd()); c=CD.getCourseInfo(i.getCourse_idd());%><%if(i.getField_id()==e.getField_id()) {%>(<%=c.getCourse_name() %>_m:Marks:<%=ec.getCourse_markss() %>-[<%=c.getCourse_name()%>_r])(<%=c.getCourse_name() %>_l:Enjoyment:<%=ec.getCourse_enjoyment_valuee() %>-[<%=c.getCourse_name()%>_r])<%} else{%>(<%=c.getCourse_name() %>_m:Marks:<%=ec.getCourse_markss() %>)(<%=c.getCourse_name() %>_l:Enjoyment:<%=ec.getCourse_enjoyment_valuee() %>)<%}%><%it=it+1;} %>||

()()()()()()() <%it=0; while(it<IA.size()){	i=(includes)IA.get(it); c=CD.getCourseInfo(i.getCourse_idd());%>(<%=c.getCourse_name() %>_r:result you are average at this subject and you liked that subject-[<%=c.getCourse_name()%>_re])()<%it=it+1;} %>||

()()()()()()() <%int diff=0; it=0; while(it<IA.size()){	i=(includes)IA.get(it); c=CD.getCourseInfo(i.getCourse_idd());%>(<%=c.getCourse_name() %>_re:means you can be good in-[<%   at=0; AI=AD.retrieveAffectInfo(i.getCourse_idd()); while(at<AI.size()){	a=(affect)AI.get(at);f=FD.getFieldInfo(a.getField_id());if((at+1)!=AI.size()){%><%=f.getField_name()+diff%>,<%} else{ %><%=f.getField_name()+diff%><%}at=at+1;diff=diff+1;} %>])()<%it=it+1;} %>||

()()()()()() <% diff=0; it=0; while(it<IA.size()){	i=(includes)IA.get(it); c=CD.getCourseInfo(i.getCourse_idd());%><%  at=0; AI=AD.retrieveAffectInfo(i.getCourse_idd()); while(at<AI.size()){	a=(affect)AI.get(at);f=FD.getFieldInfo(a.getField_id());%>(<%=f.getField_name()+diff%>:<%=f.getField_name() %>-[recommend])<%at=at+1;diff=diff+1;} %><%it=it+1;} %>||()||()||()||()||

()()(recommend:recommendation-[<% while(rt<WI.size()){	w=(weight)WI.get(rt);  f=FD.getFieldInfo(w.getField_id()); if(rt+1!=WI.size()){%><%=f.getField_name()%>_rec,<%}else{%><%=f.getField_name()%>_rec<%}rt=rt+1;}%>])||()||()||
() <%rt=0; while(rt<WI.size()){	w=(weight)WI.get(rt);  f=FD.getFieldInfo(w.getField_id());%>(<%=f.getField_name()%>_rec:<%=f.getField_name()%>)<%rt=rt+1;} %>||
</pre>
</body>
</html>