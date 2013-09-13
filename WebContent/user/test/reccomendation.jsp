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
	<title>ICGS</title>
	<meta content="width=device-width, initial-scale=1.0" name="viewport" />
	<meta content="" name="description" />
	<meta content="" name="author" />
	
 	<link href="../../rating/jquery.rating.css" type="text/css" rel="stylesheet"/>
	<link href="../../user_resources/assets/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
	<link href="../../user_resources/assets/css/metro.css" rel="stylesheet" />
	<link href="../../user_resources/assets/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet" />
	<link href="../../user_resources/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
	<link href="../../user_resources/assets/css/style.css" rel="stylesheet" />
	<link href="../../user_resources/assets/css/style_responsive.css" rel="stylesheet" />
	<link href="../../user_resources/assets/css/style_default.css" rel="stylesheet" id="style_color" />
	<link rel="stylesheet" type="text/css" href="../../user_resources/assets/gritter/css/jquery.gritter.css" />
	<link rel="stylesheet" type="text/css" href="../../user_resources/assets/uniform/css/uniform.default.css" />
	<link rel="shortcut icon" href="../../resources/css/images/favicon.png">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="fixed-top">
 <%@ include file="header.jsp" %>
<h2 style="color:#FFFFFF;">Career Guide Of Pakistan</h2>
	<!-- BEGIN HEADER -->

	<!-- END HEADER -->
	<!-- BEGIN CONTAINER -->
	<div class="page-container row-fluid">
		<!-- BEGIN SIDEBAR -->
		<div class="page-sidebar nav-collapse collapse">
			<!-- BEGIN RESPONSIVE QUICK SEARCH FORM -->
			<div class="slide hide">
				<i class="icon-angle-left"></i>
			</div>
			
			<div class="clearfix"></div>
			<!-- END RESPONSIVE QUICK SEARCH FORM -->
			<!-- BEGIN SIDEBAR MENU -->
			<%@include file="sidemenu.jsp" %>
			<!-- END SIDEBAR MENU -->
		</div>
		<!-- END SIDEBAR -->
		<!-- BEGIN PAGE -->
		<div class="page-content">
			<!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->
			
			<!-- END SAMPLE PORTLET CONFIGURATION MODAL FORM-->
			<div class="container-fluid">
				<!-- BEGIN PAGE HEADER-->
				<div class="row-fluid">
					<div class="span12">
						<!-- BEGIN STYLE CUSTOMIZER-->
					
						<!-- END STYLE CUSTOMIZER--> 
						<!-- BEGIN PAGE TITLE & BREADCRUMB-->		
						<h3 class="page-title">Recommendations <small>System Recommendations</small>
						</h3>
						<ul class="breadcrumb">
							<li>
								<i class="icon-home"></i>
								<a href="index.jsp">Home</a> 
								<i class="icon-angle-right"></i>
							</li>
							
						</ul>
						<!-- END PAGE TITLE & BREADCRUMB-->
					</div>
				</div>
				<!-- END PAGE HEADER-->
				<!-- BEGIN PAGE CONTENT-->				
				<div class="row-fluid">
					<div class="span12">
						<!-- BEGIN INLINE NOTIFICATIONS PORTLET-->
						<div class="portlet box yellow">
							<div class="portlet-title">
								<h4><i class="icon-cogs"></i>System Has Recommended You The Following Fields</h4>
							
							</div>
							
								       <%
								        courseDAO CD=new courseDAO();
                                  	 	includesDAO ID=new includesDAO();
                           				ArrayList<includes> EI=new ArrayList<includes>();
								     	course c=null;
                                	   	includes in=null;
										weightDAO WD=new weightDAO();
										ArrayList<weight> WI=new ArrayList<weight>();
										int check=0;
									    user user=new user();
									    user = (user) session.getAttribute("user"); 
										WI=WD.retrieveRecommendInfo(user.getUser_id());
										weight w=null;
										
										int field_id;
										int k=0;
										fieldDAO FD=new fieldDAO();
			
			for(int i=0;i<WI.size();i++)
			{
				w=(weight)WI.get(i);
				
				field_id=w.getField_id();
				
				field f=FD.getFieldInfo(field_id);
				
            %>
            
									<% if(k==0)
									{%>
									<div class="portlet box yellow">
									<div class="portlet-body">
									<div class="row-fluid">
									
									<% }%>
									<div class="span3">
										<div class="pricing-table">
											<h3><%=f.getField_name() %></h3>
											
															
														
													   
											 
											<div class="desc">
												
											</div>
											<ul>
												<li>Courses</li>
												<%
										      	
                                        
                                    	EI=ID.retrieveIncludesInfo(f.getField_id());
                                    	
                                    	check=0;
                                    	while(check<EI.size())
                                    	{
                							in=(includes)EI.get(check);
                                    		f=FD.getFieldInfo(in.getField_id());
                                    		c=CD.getCourseInfo( in.getCourse_idd());
												%>
												<li ><%=c.getCourse_name() %></li>
												<%
												check=check+1;
												if(check==7)
												{
													break;
												}
												}
												%>
												<li>Rate Recommendation:
												<div>
												<br/>	  	
													  
<a name="rating<%=i%>" id="<%=f.getField_id()%>" value="<%=i%>" class="link_star"><input class="hover-star" type="radio" name="rating<%=i%>" value="1" title="Very poor" /></a>
												
<a name="rating<%=i%>" id="<%=f.getField_id()%> class="link_star"><input class="hover-star" type="radio" name="rating<%=i%>" value="2" title="Poor"/></a>
												
<a name="rating<%=i%>" id="<%=f.getField_id()%> class="link_star"><input class="hover-star" type="radio" name="rating<%=i%>" value="3" title="OK"/></a>
												
<a name="rating<%=i%>" id="<%=f.getField_id()%> class="link_star"><input class="hover-star" type="radio" name="rating<%=i%>" value="4" title="Good"/></a>
													
<a name="rating<%=i%>" id="<%=f.getField_id()%> class="link_star"><input class="hover-star" type="radio" name="rating<%=i%>" value="5" title="Very Good"/></a>
													    
    												</div>
    											</li>
											
												<li>&nbsp;</li>
												<li>&nbsp;</li>
												
											</ul>
											
										</div>
									</div>
									
									<%if(k==3||(WI.size()==i+1))
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
						
												
						<!-- END INLINE NOTIFICATIONS PORTLET-->
					</div>
				</div>
				<h3 >Want To Know Why System Recommended You These Fields? click  <a href="explanation.jsp">here</a></h3>
                <div class="row-fluid">
					<div class="span12">
						<!-- BEGIN INLINE NOTIFICATIONS PORTLET--><!-- END INLINE NOTIFICATIONS PORTLET-->
					</div>
				</div>
				<!-- END PAGE CONTENT-->
			</div>
			<!-- END PAGE CONTAINER-->			
		</div>
		<!-- BEGIN PAGE -->	 	
	</div>
	<!-- END CONTAINER -->
	<!-- BEGIN FOOTER -->
	<div class="footer">
		2013 &copy; ICGS.
		<div class="span pull-right">
			<span class="go-top"><i class="icon-angle-up"></i></span>
		</div>
	</div>
	<!-- END FOOTER -->
	<!-- BEGIN JAVASCRIPTS -->
	<!-- Load javascripts at bottom, this will reduce page load time -->
	<script src="../../rating/jquery.js" type="text/javascript"></script>
 	<script src="../../rating/jquery.rating.js" type="text/javascript" language="javascript"></script>
	<script src="../../user_resources/assets/breakpoints/breakpoints.js"></script>
	<script src="../../user_resources/assets/bootstrap/js/bootstrap.min.js"></script>
	<script src="../../user_resources/assets/js/jquery.blockui.js"></script>
	<!-- ie8 fixes -->
	<!--[if lt IE 9]>
	<script src="../../user_resources/assets/js/excanvas.js"></script>
	<script src="../../user_resources/assets/js/respond.js"></script>
	<![endif]-->
	<script type="text/javascript" src="../../user_resources/assets/uniform/jquery.uniform.min.js"></script>
	<script type="text/javascript" src="../../user_resources/assets/gritter/js/jquery.gritter.js"></script>
	<script type="text/javascript" src="../../user_resources/assets/js/jquery.pulsate.min.js"></script>
	<script src="../../user_resources/assets/js/app.js"></script>		
	<script>
		jQuery(document).ready(function() {			
			// initiate layout and plugins
			//App.init();
		});
	</script>
	<script type="text/javascript">
	  var _gaq = _gaq || [];
	  _gaq.push(['_setAccount', 'UA-37564768-1']);
	  _gaq.push(['_setDomainName', 'keenthemes.com']);
	  _gaq.push(['_setAllowLinker', true]);
	  _gaq.push(['_trackPageview']);
	  (function() {
	    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
	    ga.src = ('https:' == document.location.protocol ? 'https://' : 'http://') + 'stats.g.doubleclick.net/dc.js';
	    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
	  })();
	</script>
	<script>
$(function(){
 $('.hover-star').rating({
  focus: function(value, link){
    // 'this' is the hidden form element holding the current value
    // 'value' is the value selected
    // 'element' points to the link element that received the click.
    var tip = $('.hover-test');
    tip[0].data = tip[0].data || tip.html();
    tip.html(link.title || 'value: '+value);
  },
  blur: function(value, link){
    var tip = $('.hover-test');
    $('.hover-test').html(tip[0].data || '');
  }
 });
});
</script>
<script>
$(document).ready(function(){ 
	$(".link_star").click(function(){ 
	var a = $(this).attr('name');
	var value=$('input:radio[name='+a+']:checked').val();
	var field_id=$(this).attr('id');
	
		
	
		var xmlhttp;    
		
		if (window.XMLHttpRequest)
		  {// code for IE7+, Firefox, Chrome, Opera, Safari
		  xmlhttp=new XMLHttpRequest();
		  }
		else
		  {// code for IE6, IE5
		  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		  }
		xmlhttp.onreadystatechange=function()
		  {
		  if (xmlhttp.readyState==4 && xmlhttp.status==200)
		    {
			
			
		   // document.getElementById("group").innerHTML=xmlhttp.responseText;
		
		    }
		  }
		
		xmlhttp.open("GET","learning.jsp?field_id="+field_id+"&value="+value,true);
		xmlhttp.send();
	});
});
</script>



	
	<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>