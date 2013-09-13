 <%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="bean.*" %>
<%@ page import="database.*" %>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
   <meta charset="utf-8" />
   <title>Metronic | Form Stuff - Form Wizard</title>
   <meta content="width=device-width, initial-scale=1.0" name="viewport" />
   <meta content="" name="description" />
   <meta content="" name="author" />
   <link href="${pageContext.request.contextPath}/resources/style/test.css" rel="stylesheet" type="text/css">
   <link href="${pageContext.request.contextPath}/resources/style/slider.css" rel="stylesheet" type="text/css">
   <link href="../../user_resources/assets/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
   <link href="../../user_resources/assets/css/metro.css" rel="stylesheet" />
   <link href="../../user_resources/assets/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet" />
   <link href="../../user_resources/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
   <link href="../../user_resources/assets/css/style.css" rel="stylesheet" />
   <link href="../../user_resources/assets/css/style_responsive.css" rel="stylesheet" />
   <link href="../../user_resources/assets/css/style_default.css" rel="stylesheet" id="style_color" />
   <link rel="stylesheet" type="text/css" href="../../user_resources/assets/gritter/css/jquery.gritter.css" />
   <link rel="stylesheet" type="text/css" href="../../user_resources/assets/uniform/css/uniform.default.css" />
   <link rel="stylesheet" type="text/css" href="../../user_resources/assets/chosen-bootstrap/chosen/chosen.css" />
   <link rel="stylesheet" type="text/css" href="../../user_resources/assets/bootstrap-wysihtml5/bootstrap-wysihtml5.css" />
   <link rel="stylesheet" type="text/css" href="../../user_resources/assets/bootstrap-datepicker/css/datepicker.css" />
   <link rel="stylesheet" type="text/css" href="../../user_resources/assets/bootstrap-timepicker/compiled/timepicker.css" />
   <link rel="stylesheet" type="text/css" href="../../user_resources/assets/bootstrap-colorpicker/css/colorpicker.css" />
   <link rel="stylesheet" href="../../user_resources/assets/bootstrap-toggle-buttons/static/stylesheets/bootstrap-toggle-buttons.css" />
   <link rel="stylesheet" href="../../user_resources/assets/data-tables/DT_bootstrap.css" />
   <link rel="stylesheet" type="text/css" href="../../user_resources/assets/bootstrap-daterangepicker/daterangepicker.css" />
   <link rel="stylesheet" type="text/css" href="../../user_resources/assets/uniform/css/uniform.default.css" />
   <link rel="shortcut icon" href="../../user_resources/favicon.ico" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css" />


</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="fixed-top">

 
  <h3 class="block">Provide your Genral Data</h3>
                                    
                                    <div class="control-group">
                                    <div class="portlet-body">
								<p>				
										 <%	
                                    		int gid=0;
										 	int field=0;
										 	int group_id=0;
                                    		
                                    		
                                    			group_id=Integer.parseInt(request.getParameter("group"));
                                    			groupIncludesDAO GID=new groupIncludesDAO();
                      							ArrayList<groupIncludes> gI=new ArrayList<groupIncludes>();
                      							gI=GID.retrieveGroupIncludesInfo(group_id);
                      							groupIncludes Gi =null;
                           						fieldDAO FGD=new fieldDAO();
                           						field fg=null;
                           						System.out.println(gI.size());
                       							 while(gid<gI.size())
    											{

    	 												Gi=(groupIncludes)gI.get(gid);
    	 												fg=FGD.getFieldInfo(Gi.getField_idd());
    	 												
    	 												if(gid==0)
    	 												{
    	 												
    	 												%>
    	 												<button type="button" id="field<%=gid%>" value="12" class="btn green" onClick="javaScript:select_field('<%=fg.getField_name() %>','<%=gI.size()%>','<%=gid%>','<%=fg.getField_id() %>');" ><%=fg.getField_name() %></button>
    	 												<%field=fg.getField_id();
    	 												
    	 												%>
    	 												<% }
    	 												else
    	 												{%>
    														
    											
    													<button type="button" id="field<%=gid%>" value="12" class="btn blue" onClick="javaScript:select_field('<%=fg.getField_name() %>','<%=gI.size()%>','<%=gid%>','<%=fg.getField_id() %>');" ><%=fg.getField_name() %></button>
    													<%
    	 												}	
    										gid=gid+1;
    											}
    									
    									
                                    		
                                    		%>
                 					
								</p>
								</div>
										
                                      <input type="hidden" id="field_button" name="user_field" value=<%=field%>>
                                    
                                    </div>
                                
                                     <div class="form-actions clearfix">
                                      <a href="javascript:;" class="btn button-previous">
                                 <i class="m-icon-swapleft"></i> Back 
                                 </a>
                                 <a href="javascript:;" class="btn blue button-next">
                                 Continue <i class="m-icon-swapright m-icon-white"></i>
                                 </a>
                                
                              </div>
                              </body>
<!-- END BODY -->
</html>