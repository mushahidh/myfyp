<!DOCTYPE html>
<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="bean.*" %>
<%@ page import="database.*" %>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
	<meta charset="utf-8" />
	<title>University Finder</title>
	<meta content="width=device-width, initial-scale=1.0" name="viewport" />
	<meta content="" name="description" />
	<meta content="" name="author" />
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
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="../../user_resources/assets/css/jquery-ui.css" />
<script src="../../user_resources/assets/js/jquery-1.9.1.js"></script>
<script src="../../user_resources/assets/js/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css" />
<style>
/* Slider
----------------------------------*/

.ui-slider { position: relative; text-align: left;margin-top:3%;margin-left:3%;}
.ui-slider .ui-slider-handle { position: absolute; z-index: 2; width: 3%; height: 145%; cursor: default; }
.ui-slider .ui-slider-range { position: absolute;
z-index: 1;
font-size: 1%;
display: block;
border: 0;
background: #FFFFF;
}

 .slider_value
{
border: 0;
visibility:visible;
font-weight:bold;
text-align:center;
text-shadow:0 1px 1px #000;
font-weight:700;
padding:10px;
text-align:justify;
color: #FFB848; 

}
.ui-widget-content { background: #FFFFFF; width:50%; }//change color and width

.slide .ui-slider-range {
    background: #D6F5FF !important;
}

.ui-widget-content .ui-state-default { background:#FFFFF; width:20px;}// change button color


.text
{
	border: 0;
	text-align:right;
	color: #f6931f;
	font-weight: bold;
	position:relative;
	text-shadow:0 1px 1px #000;
	padding:0.5%;
	
}


</style>
<script>
$(function() {
$( "#slider-range" ).slider({
range: true,
min: 0,
max: 500,
animate:"slow",
values: [ 75, 300 ],
slide: function( event, ui ) {
$( "#amount" ).val( ui.values[ 0 ] + ui.values[ 1 ] );
$( "#amount1" ).text( "$" + ui.values[ 0 ] + " - $" + ui.values[ 1 ] );
$( "#min" ).val( ui.values[ 0 ] );
$( "#max" ).val(  ui.values[ 1] );

}
});
$( "#amount" ).val( "$" + $( "#slider-range" ).slider( "values", 0 ) +
" - $" + $( "#slider-range" ).slider( "values", 1 ) );
$( "#amount1" ).text( "$" + $( "#slider-range" ).slider( "values", 0 ) +
		" - $" + $( "#slider-range" ).slider( "values", 1));
$( "#min" ).val(  $( "#slider-range" ).slider( "values", 0 )) ;
$( "#max" ).val(  $( "#slider-range" ).slider( "values", 1 )) ;
});
</script>
</head>

<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="fixed-top" onLoad="load();" >
	<!-- BEGIN HEADER -->
	 <%@ include file="../test/header.jsp" %>
<h2 style="color:#FFFFFF;">Career Guide Of Pakistan</h2>
	
	<!-- END HEADER -->
	<!-- BEGIN CONTAINER -->
	<div class="page-container row-fluid">
		<!-- BEGIN SIDEBAR -->
		<div class="page-sidebar nav-collapse collapse">
			<!-- BEGIN RESPONSIVE QUICK SEARCH FORM -->
		
		
			
			<!-- END RESPONSIVE QUICK SEARCH FORM -->
			<!-- BEGIN SIDEBAR MENU -->
			<%@include file="sidemenu.jsp" %>
			<!-- END SIDEBAR MENU -->
		</div>
		<!-- END SIDEBAR -->
		<!-- BEGIN PAGE -->
		<div class="page-content">
			<!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->
			<div id="portlet-config" class="modal hide">
				<div class="modal-header">
					<button data-dismiss="modal" class="close" type="button"></button>
					<h3>Widget Settings</h3>
				</div>
				<div class="modal-body">
					<p>Here will be a configuration form</p>
				</div>
			</div>
			<!-- END SAMPLE PORTLET CONFIGURATION MODAL FORM-->
			<div class="container-fluid">
				<!-- BEGIN PAGE HEADER-->
				<div class="row-fluid">
					<div class="span12">
						<!-- BEGIN STYLE CUSTOMIZER-->
						
						<!-- END STYLE CUSTOMIZER--> 
						<!-- BEGIN PAGE TITLE & BREADCRUMB-->		
						<h3 class="page-title">Universities</h3>
						<ul class="breadcrumb">
							<li>
								<i class="icon-home"></i>
								<a href="../../user_resources/index.html">Home</a> 
								<i class="icon-angle-right"></i>
							</li>
							<li>University Finder<a href="../../user_resources/#"></a></li>
						</ul>
						<!-- END PAGE TITLE & BREADCRUMB-->
					</div>
				</div>
				<!-- END PAGE HEADER-->
				<!-- BEGIN PAGE CONTENT-->
				
				 <div class="control-group">
                              <label class="control-label">Select The Standard</label>
                              <div class="controls">
                                 <select id="dropdown_standard" class="span6 m-wrap" data-placeholder="Choose a Category" tabindex="1">
                                 
                                   
                                   	<option value="12" onClick="group();"/>Intermediate
                                   	<option value="16" onClick="group();"/>Bachelors
                                   	<option value="18" onClick="group();"/>Masters
                                 
                  					  
                                 </select>
                              </div>
                           </div>			
				  
                    <div class="control-group">
                              <label class="control-label">Select The Group</label>
                              <div class="controls">
                                 <select id="dropdown_group" class="span6 m-wrap" data-placeholder="Choose a Category" tabindex="1">
                                 
                                  
                                       <%
                 						groupDAO GD=new groupDAO();
                  					 	group g=null;
                    					ArrayList<group> GI=new ArrayList<group>();
                   						GI=GD.retrieveGroupInfo();
                  						for(int i=0;i<GI.size();i++)
                   						{
                            				 g=(group)GI.get(i);
                						 %>
                                    		<option value="<%= g.getGroup_id() %>"  onClick="group();" /><%= g.getGroup_name() %>
                                 
                  					   <%} %>
                                 </select>
                              </div>
                           </div>				
				<div class="row-fluid">
					<div class="span12">
                        <div class="control-group">
                             <label class="control-label">Select The Field</label>
                              <div class="controls">
                               <p id="field">
                              
                                 </p>
                              </div>
                           </div>
                            <div class="control-group">
                              <label class="control-label">Select The city</label>
                              <div class="controls">
                                 <select id="dropdown_location" class="span6 m-wrap" data-placeholder="Choose a Category" tabindex="1" >
                                    
                                    <option value="Islamabad" onClick="university();"/>Islamabad
                                    <option value="Karachi" onClick="university();"/>Karachi	
                                    <option value="Lahore" onClick="university();"/>Lahore
                                 </select>
                              </div>
                           </div>	
                           	 <label class="control-label">Select Affordance Range</label>
					<div id="slider-range" style="display: inline-block; margin-left:0px;margin-top:10px;"></div>
					<span id="amount1" class="slider_value" ></span>
					<input type="hidden" id="min"  value="min"/>
					<input type="hidden" id="max"  value="max"/>
					<br/>
					<br/>
						<!-- BEGIN INLINE NOTIFICATIONS PORTLET-->
					<div id="uni">
						
						</div>
						<!-- END INLINE NOTIFICATIONS PORTLET-->
					</div>
					
				</div>
				
				
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
			App.init();
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
 	function group()
 	{
 		
 		
 		
 		var standard = document.getElementById("dropdown_standard").value;
 		var group_id = document.getElementById("dropdown_group").value;
 		//var min = document.getElementById("min").value;
 		//var max = document.getElementById("max").value;
 		
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
 		    document.getElementById("field").innerHTML=xmlhttp.responseText;
 		   	university();
 		    }
 		  };
 		
 		xmlhttp.open("GET","get_field.jsp?group="+group_id+"&standard="+standard,true);
 		xmlhttp.send();
 		

 	}
 	function university()
 	{
 		
 		var location = document.getElementById("dropdown_location").value;
 		var field_id = parseInt(document.getElementById("dropdown_field").value);
 		
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
 		    document.getElementById("uni").innerHTML=xmlhttp.responseText;
 		    }
 		  }
 		
 		xmlhttp.open("GET","get_university.jsp?field="+field_id+"&location="+location,true);
 		xmlhttp.send();
 		
 				
 		
 	}
 	function load()
 	{
 		
 		
 		group();
 		
 				
 		
 	}
 	</script>
	<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>