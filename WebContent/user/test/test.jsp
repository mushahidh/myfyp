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
   <link rel="shortcut icon" href="../../resources/css/images/favicon.png">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="../../user_resources/assets/css/jquery-ui.css" />
<script src="../../user_resources/assets/js/jquery-1.8.3.min.js"></script>
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
background: #8DC6FF;
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
color: #8DC6FF; 

}
.ui-widget-content { background: #FFFFFF; width:29%; }//change color and width

.slide .ui-slider-range {
    background: #D6F5FF !important;
}

.ui-widget-content .ui-state-default { background:#98d8f0; width:20px;}// change button color


.text
{
	border: 0;
	text-align:right;
	color: #29A3CC;
	font-weight: bold;
	position:relative;
	text-shadow:0 1px 1px #000;
	padding:0.5%;
	
}
.character
{
position:relative;
margin-top:-4.8%;
margin-left:155%;
height:51px;
width:51px;

background-image:url(../../resources/images/characters/0.png);
background-position:center;
background-repeat:repeat-y;
}

</style>
<script>

$(function(){
    $('#check').click(function() {
        if(!$(this).is(':checked'))
		{
        	
        	$(".nts").slider( "option", "disabled", false );
        	  $("#nts").css("background-color","hidden");
        	 
        	
        	}
        else
        	{
        		$(".nts").slider( "option", "disabled", true );
      			 $("#nts").css("background-color","visible");
      			 $( "#hiddenNts" ).val( 0 );
      			$( "#nts1" ).text(  0 );
      			
        		
        	}
        	
          
        });
    
 
}); 
</script>
<script>
$(function() {
$( ".nts" ).slider({
	disabled:false,
	animate:"slow",
	 range: "min",
value:60,
min: 0,
max: 100,
step: 1,

slide: function( event, ui ) {
	 $( "#nts" ).val( ui.value );
	 $( "#nts1" ).text( ui.value );
	 $( "#hiddenNts" ).val( ui.value );

 
}
});
$( "#nts" ).val(  $( ".nts" ).slider( "value" ) );
$( "#nts1" ).text(  $( ".nts" ).slider( "value" ) );
$( "#hiddenNts" ).val(  $( ".nts" ).slider( "value" ) );


});
</script>
</head>
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
         <%@ include file="sidemenu.jsp" %>      <!-- END SIDEBAR MENU -->
      </div>
      <!-- END SIDEBAR -->
      <!-- BEGIN PAGE -->  
      <div class="page-content">
         <!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->
       
         <!-- END SAMPLE PORTLET CONFIGURATION MODAL FORM-->
         <!-- BEGIN PAGE CONTAINER-->
         <div class="container-fluid">
            <!-- BEGIN PAGE HEADER-->   
            <div class="row-fluid">
               <div class="span12">
                  <!-- BEGIN STYLE CUSTOMIZER-->
                
                  <!-- END STYLE CUSTOMIZER-->  
                  <h3 class="page-title">
                     Career Assesment
                     <small>Have a go!</small>
                  </h3>
                  <ul class="breadcrumb">
                     <li>
                        <i class="icon-home"></i>
                        <a href="">Home</a> 
                        <span class="icon-angle-right"></span>
                     </li>
                     
                     <li><a href="">Test</a></li>
                  </ul>
               </div>
            </div>
            <!-- END PAGE HEADER-->
            <!-- BEGIN PAGE CONTENT-->
            <div class="row-fluid">
               <div class="span12">
                  <div class="portlet box blue" id="form_wizard_1">
                     <div class="portlet-title">
                        <h4>
                           <i class="icon-reorder"></i><span class="step-title">Step 1 of 11</span>
                        </h4>
                        
                     </div>
                     <div class="portlet-body form">
                       <form action="../../test_controller" class="form-horizontal" >
                           <div class="form-wizard">
                              <div class="navbar steps">
                                 <div class="navbar-inner">
                                    <ul class="row-fluid">
                                       <li class="span3">
                                          <a href="../../user_resources/#tab1" data-toggle="tab" class="step active">
                                          <span class="number">1</span>
                                          <span class="desc"><i class="icon-ok"></i>Grade Level</span>   
                                          </a>
                                       </li>
                                       <li class="span3">
                                          <a href="../../user_resources/#tab2" data-toggle="tab" class="step">
                                          <span class="number">2</span>
                                          <span class="desc"><i class="icon-ok"></i> General data</span>   
                                          </a>
                                       </li>
                                       <li class="span3">
                                          <a href="../../user_resources/#tab3" data-toggle="tab" class="step">
                                          <span class="number">3</span>
                                          <span class="desc"><i class="icon-ok"></i> General data</span>   
                                          </a>
                                       </li>
                                       <li class="span3">
                                          <a href="../../user_resources/#tab4" data-toggle="tab" class="step">
                                          <span class="number">4</span>
                                          <span class="desc"><i class="icon-ok"></i>Course Achivment</span>   
                                          </a>
                                       </li>
                                       <li class="span3" style="margin-left:0px;" >
                                          <a href="../../user_resources/#tab5" data-toggle="tab" class="step" >
                                          <span class="number">5</span>
                                          <span class="desc"><i class="icon-ok" ></i> Course Enjoyment</span>   
                                          </a> 
                                       </li>
                                        <li class="span3">
                                          <a href="../../user_resources/#tab6" data-toggle="tab" class="step">
                                          <span class="number">6</span>
                                          <span class="desc"><i class="icon-ok"></i>Realistic</span>   
                                          </a> 
                                       </li>
                                         <li class="span3">
                                          <a href="../../user_resources/#tab7" data-toggle="tab" class="step">
                                          <span class="number">7</span>
                                          <span class="desc"><i class="icon-ok"></i>Investigiavtive</span>   
                                          </a> 
                                       </li>
                                         <li class="span3">
                                          <a href="../../user_resources/#tab8" data-toggle="tab" class="step">
                                          <span class="number">8</span>
                                          <span class="desc"><i class="icon-ok"></i>Artistic</span>   
                                          </a> 
                                       </li>
                                         <li class="span3" style="margin-left:0px;" >
                                          <a href="../../user_resources/#tab9" data-toggle="tab" class="step">
                                          <span class="number">9</span>
                                          <span class="desc"><i class="icon-ok"></i>Social</span>   
                                          </a> 
                                       </li>
                                       <li class="span3">
                                          <a href="../../user_resources/#tab10" data-toggle="tab" class="step">
                                          <span class="number">10</span>
                                          <span class="desc"><i class="icon-ok"></i>Enterprising</span>   
                                          </a> 
                                       </li>
                                       <li class="span3">
                                          <a href="../../user_resources/#tab11" data-toggle="tab" class="step">
                                          <span class="number">11</span>
                                          <span class="desc"><i class="icon-ok"></i>Conventional</span>   
                                          </a> 
                                       </li>
                                    </ul>
                                 </div>
                              </div>
                              <div id="bar" class="progress progress-success progress-striped active">
                                 <div class="bar"></div>
                              </div>
                              <div class="tab-content">
                                 <div class="tab-pane active" id="tab1">
                                    <h3 class="block">Select your Grade Level</h3>
                                    
                                    <div class="control-group">
                                    <div class="portlet-body">
								<p>				
												
									<button type="button" id="grade_12" value="12" class="btn green" onClick="javaScript:select_grade('1');" >12th grade</button>
									<button type="button" id="bachelors" value="bachelors" class="btn blue" onClick="javaScript:select_grade('2');" >Bacelors</button>
									<button type="button" id="masters" value="masters" class="btn blue" onClick="javaScript:select_grade('3');" >Master</button>
									
								</p>
								</div>
                                      <input type="hidden" id="grade_button" name="user_grade" value="12">
										
										
                                    </div>
                                
                                     <div class="form-actions clearfix">
                                 <a href="javascript:;" class="btn blue button-next">
                                 Continue <i class="m-icon-swapright m-icon-white"></i>
                                 </a>
                                
                              </div>
                                 
                                 </div>
                                 <div class="tab-pane" id="tab2">
                                    <h3 class="block">Provide your General Data</h3>
                                    
                                    <div class="control-group">
                                    <div class="portlet-body">
								<p>				
										 <%	
                                    		int gt=0;
										 	int group=0;
                                    		
                                    	
                 							groupDAO GD=new groupDAO();
                  							ArrayList<group> GI=new ArrayList<group>();
                   							GI=GD.retrieveGroupInfo(12);
                       						group g=null;
                   						
                   							 while(gt<GI.size())
											{

	 												g=(group)GI.get(gt);
	 												
	 												if(gt==0)
	 												{
	 												
	 												%>
	 												<button type="button" id="group<%=gt%>" value="12" class="btn green" onClick="group('<%=g.getGroup_name() %>','<%=GI.size()%>','<%=gt%>','<%=g.getGroup_id() %>');"  ><%=g.getGroup_name() %></button>
	 												<%group=g.getGroup_id();
	 												
	 												%>
	 												<% }
	 												else
	 												{%>
														
											
													<button type="button" id="group<%=gt%>" value="12" class="btn blue" onClick="group('<%=g.getGroup_name() %>','<%=GI.size()%>','<%=gt%>','<%=g.getGroup_id() %>');" ><%=g.getGroup_name() %></button>
													<%
	 												}	
										gt=gt+1;
											}
									%>
									
								</p>
								</div>
										<input type="hidden" id="hiddenNts" name="NTS" value="hiddenNts"/>
                                      <input type="hidden" id="group_button" name="user_group" value=<%=group%>>
                                     Nts: <input type="checkbox" id="check">
										<div class="nts" style="display: inline-block; ">
										</div>
										<span id="nts1" class="slider_value"></span>
                                    </div>
                                
                                     <div class="form-actions clearfix">
                                      <a href="javascript:;" class="btn button-previous">
                                 <i class="m-icon-swapleft"></i> Back 
                                 </a>
                                 <a href="javascript:;" class="btn blue button-next" id="button">
                                 Continue <i class="m-icon-swapright m-icon-white"></i>
                                 </a>
                                
                                
                              </div>
                                  
                                 </div>
                                 <div class="tab-pane" id="tab3">
                                    <h3 class="block">Provide your General Data</h3>
                                    
                                    <div class="control-group">
                                    <div class="portlet-body">
								<p id="group">				
										 <%	
                                    		int gid=0;
										 	int field=0;
										 	int courseSize=0;
												groupIncludesDAO GID=new groupIncludesDAO();
                      							ArrayList<groupIncludes> gI=new ArrayList<groupIncludes>();
                      							gI=GID.retrieveGroupIncludesInfo(group);
                      							groupIncludes Gi =null;
                           						fieldDAO FGD=new fieldDAO();
                           						testDAO TDD=new testDAO();
                      							ArrayList<includes> EII=new ArrayList<includes>();
                           						field fg=null;
                           						
                           						
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
    	 												
    	 												%>
    	 												<% }
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
                                  
                                 </div>
                                 <div class="tab-pane" id="tab4">
                                 
                                    <h3 class="block">Provide Your Grades Marks </h3>
                                   <div id="field">
                                    <!-- start -->
                                     <%
                 							fieldDAO FD=new fieldDAO();
                  							courseDAO CD=new courseDAO();
                  							testDAO TD=new testDAO();
                  							ArrayList<includes> EI=new ArrayList<includes>();
                   							EI=TD.retrieveIncludesInfo(field);
                   						
                   							field f=null;
                   							course c=null;
                   							includes in=null;
                   					 %>

<div class="label" >Course Grades</div>


<% int i=0;
String check="null";

int size=EI.size();

while(i<EI.size())
{

	 
	in=(includes)EI.get(i);
	f=FD.getFieldInfo(in.getField_id());
	c=CD.getCourseInfo( in.getCourse_idd());
	check="checkbox";
	check=check+i;
	%>

<script>
$(function() {
$( ".<%=i%>" ).slider({
	disabled:false,
	animate:"slow",
	 range: "min",
value:60,
min: 33,
max: 100,
step: 1,

slide: function( event, ui ) {
	 $( "#<%=i%>" ).val( ui.value );
	 $( "#1<%=i%>" ).text( ui.value );
	 $( "#course<%=i%>" ).val( ui.value );
	
 
}
});
$( "#<%=i%>" ).val(  $( ".<%=i%>" ).slider( "value" ) );
$( "#1<%=i%>" ).text(  $( ".<%=i%>" ).slider( "value" ) );
$( "#course<%=i%>" ).val(  $( ".<%=i%>" ).slider( "value" ) );


});
</script>


<input type="hidden" id="course<%=i%>" name="course<%=i%>" value="course<%=i%>"/>
<script>

$(function(){
    $('#<%=check%>').click(function() {
        if(!$(this).is(':checked'))
		{

        	$(".<%=i%>").slider( "option", "disabled", false );
      	  	$("#<%=i%>").css("background-color","hidden");
        	 
        	
        	}
        else
        	{
        		$(".<%=i%>").slider( "option", "disabled", true );
      			 $("#<%=i%>").css("background-color","visible");
      			 $( "#course<%=i%>" ).val( 0 );
        		
        	}
        	
          
        });
    
 
}); 
</script>
<div id="crsLine">
</div>
<table border="0"   width="100%">
<tr>
<td width="8%">
<span class="block">  <%=c.getCourse_name() %></span>
</td>
<td width="92%">
<div class="<%=i%>" style="display: inline-block; ">
</div>
<span id="1<%=i %>" class="slider_value"></span>

</td>
</tr>
</table>



<input type="hidden"  name="name<%=i%>" value="<%=c.getCourse_name() %>" />
<input type="hidden"  name="id<%=i%>" value="<%=in.getCourse_idd() %>" />
<input type="hidden"  name="course_size" value="<%=size%>" />


<br/>
<%
i=i+1;
}
%>

                   					</div> 
                                    <!-- end -->
                                 <div class="form-actions clearfix">
                                 <a href="javascript:;" class="btn button-previous">
                                 <i class="m-icon-swapleft"></i> Back 
                                 </a>
                                 <a href="javascript:;" class="btn blue button-next">
                                 Continue <i class="m-icon-swapright m-icon-white"></i>
                                 </a> 
                                 </div>
                                
                                   </div>
                                 <div class="tab-pane" id="tab5">
                                    <h3 class="block">Provide Your Course Enjoyment</h3>
                                      <!-- Start -->
                                      <div id="course_enjoyment">
                                      <div class="label" >Course Enjoyment</div>
                                      <div class="label" style="margin-left:510px;margin-top:-20px;" >Enjoyment level</div>


<% int j=0;

String param=null;
String value1=null;
int value=0;
int size1=0;
size1=EI.size();

while(j<EI.size())
{


in=(includes)EI.get(j);
f=FD.getFieldInfo(in.getField_id());
c=CD.getCourseInfo( in.getCourse_idd());


%>
<script>
$(function () {
    $(".E<%=j%>").slider({
        disabled: false,
        animate: "slow",
        range: "min",
        value: 0,
        min: -2500,
        max: 2500,
        step: 500,
        slide: function (event, ui) {
            $("#E<%=j%>").val(ui.value);
            $("#hiddenE<%=j%>").val(ui.value);
        },
        change: function(event, ui){
           
          
        	$('.character', this).css("background-image", "url(../../resources/images/characters/"+ui.value+".png)");
            
        }
    });
    $("#E<%=j%>").val($(".E<%=j%>").slider("value"));
    $("#hiddenE<%=j%>").val($(".E<%=j%>").slider("value"));
   
});
</script>


<input type="hidden" id="hiddenE<%=j%>" name="valueE<%=j%>" value="E<%=j%>"/>


<div id="crsLine">
</div>
<table border="0"   width="100%">
<tr>
<td width="8%">
<span class="block"><%=c.getCourse_name() %>:</span>
</td>
<td width="92%">
<div class="E<%=j%>" style="display: inline-block; ">
<div class="character" style="display:inline-block;">
</div>
</div>
</td>
</tr>
</table>



<input type="hidden"  name="nameE<%=j%>" value="<%=c.getCourse_name() %>"/>
<input type="hidden"  name="idE<%=j%>" value="<%=in.getCourse_idd() %>" />


<br/>
<%
j=j+1;

}
%>
<input type="hidden"  name="enjoyment_size" value="<%=size1%>" />
	</div>
               							<!-- End -->
               							      <div class="form-actions clearfix">
                                 <a href="javascript:;" class="btn button-previous">
                                 <i class="m-icon-swapleft"></i> Back 
                                 </a>
                                 <a href="javascript:;" class="btn blue button-next">
                                 Continue <i class="m-icon-swapright m-icon-white"></i>
                                 </a>
                                
                              </div>
                                 </div>
                                 
                                 <div class="tab-pane" id="tab6">




                                                  				 
                                    <h3 class="block">Realistic</h3>
                                    <%	
                                    		int k=0;
                                    		
                                    		int realistic_count=0;
                                    		int realistic_total=0;
                 							questionDAO QD=new questionDAO();
                  							ArrayList<question> QI=new ArrayList<question>();
                   							QI=QD.retrieveQuestionInfo("Realistic");
                   							realistic_count=QI.size();
                   							realistic_total=QI.size();
                   							question q=null;
                   						
                   							 while(k<QI.size())
											{

	 												q=(question)QI.get(k);
	 												
	 												
											%>
											
											<table border="0"   width="100%">
											<tr>
											<td width="50%">
											<span class="block"><%=q.getQuestion() %></span>
											</td>
											<td width="50%">
											    <div class="control-group">
                              					<div class="controls">
                               					<div class="success-toggle-button">
                            					 <input type="checkbox" id="realistic<%=k%>" class="toggle" checked="checked" onchange="javaScript:realistic('<%=k%>');" />
                                                 </div>
                                                 </div>
                        						 </div>
											</td>
											</tr>
											</table>

											<%
													k=k+1;
											} %>
											<input type="hidden" id="realistic_count" name="realistic_count" value="<%=realistic_count%>"/>
                            				<input type="hidden"  name="realistic_total" value="<%=realistic_total%>"/>

                                 <div class="form-actions clearfix">
                                 <a href="javascript:;" class="btn button-previous">
                                 <i class="m-icon-swapleft"></i> Back 
                                 </a>
                                 <a href="javascript:;" class="btn blue button-next">
                                 Continue <i class="m-icon-swapright m-icon-white"></i>
                                 </a>
                                 
                                
                                
                                
                              </div>
                                 </div>
                                 <!-- ENds here -->
                                     <div class="tab-pane" id="tab7">




                                                  				 
                                    <h3 class="block">Investigative</h3>
                                    <%	
                                    		int v=0;
                                    		
                                    		int investigative_count=0;
                                    		int investigative_total=0;
                 							
                  							ArrayList<question> QII=new ArrayList<question>();
                   							QII=QD.retrieveQuestionInfo("Investigative");
                   							investigative_count=QII.size();
                   							investigative_total=QII.size();
                   							
                   						
                   							 while(v<QII.size())
											{

	 												q=(question)QII.get(v);
	 												
	 												
											%>
											
											<table border="0"   width="100%">
											<tr>
											<td width="50%">
											<span class="block"><%=q.getQuestion() %></span>
											</td>
											<td width="50%">
											    <div class="control-group">
                              					<div class="controls">
                               					<div class="success-toggle-button">
                            					 <input type="checkbox" id="investigative<%=v%>" class="toggle" checked="checked" onchange="javaScript:investigative('<%=v%>');" />
                                                 </div>
                                                 </div>
                        						 </div>
											</td>
											</tr>
											</table>

											<%
													v=v+1;
											} %>
											<input type="hidden" id="investigative_count" name="investigative_count" value="<%=investigative_count%>"/>
                            				<input type="hidden"  name="investigative_total" value="<%=investigative_total%>"/>

                                 <div class="form-actions clearfix">
                                 <a href="javascript:;" class="btn button-previous">
                                 <i class="m-icon-swapleft"></i> Back 
                                 </a>
                                 <a href="javascript:;" class="btn blue button-next">
                                 Continue <i class="m-icon-swapright m-icon-white"></i>
                                 </a>
                                 
                                
                                
                                
                              </div>
                                 </div>
                                 <!-- ENds here -->
                                     <div class="tab-pane" id="tab8">




                                                  				 
                                    <h3 class="block">Artistic</h3>
                                    <%	
                                    		int w=0;
                                    		
                                    		int artistic_count=0;
                                    		int artistic_total=0;
                 							
                  							ArrayList<question> QA=new ArrayList<question>();
                   							QA=QD.retrieveQuestionInfo("Artistic");
                   							artistic_count=QA.size();
                   							artistic_total=QA.size();
                   							
                   						
                   							 while(w<QA.size())
											{

	 												q=(question)QA.get(w);
	 												
	 												
											%>
											
											<table border="0"   width="100%">
											<tr>
											<td width="50%">
											<span class="block"><%=q.getQuestion() %></span>
											</td>
											<td width="50%">
											    <div class="control-group">
                              					<div class="controls">
                               					<div class="success-toggle-button">
                            					 <input type="checkbox" id="artistic<%=w%>" class="toggle" checked="checked" onchange="javaScript:artistic('<%=w%>');" />
                                                </div>
                                                 </div>
                        						 </div>
											</td>
											</tr>
											</table>

											<%
													w=w+1;
											} %>
											<input type="hidden" id="artistic_count" name="artistic_count" value="<%=artistic_count%>"/>
                            				<input type="hidden"  name="artistic_total" value="<%=artistic_total%>"/>

                                 <div class="form-actions clearfix">
                                 <a href="javascript:;" class="btn button-previous">
                                 <i class="m-icon-swapleft"></i> Back 
                                 </a>
                                 <a href="javascript:;" class="btn blue button-next">
                                 Continue <i class="m-icon-swapright m-icon-white"></i>
                                 </a>
                                 
                                
                                
                                
                              </div>
                                 </div>
                                 <!-- ENds here -->
                                     <div class="tab-pane" id="tab9">




                                                  				 
                                    <h3 class="block">Social</h3>
                                    <%	
                                    		int x=0;
                                    		
                                    		int social_count=0;
                                    		int social_total=0;
                 							
                  							ArrayList<question> QS=new ArrayList<question>();
                   							QS=QD.retrieveQuestionInfo("Social");
                   							social_count=QS.size();
                   							social_total=QS.size();
                   							
                   						
                   							 while(x<QS.size())
											{

	 												q=(question)QS.get(x);
	 												
	 												
											%>
											
											<table border="0"   width="100%">
											<tr>
											<td width="50%">
											<span class="block"><%=q.getQuestion() %></span>
											</td>
											<td width="50%">
											    <div class="control-group">
                              					<div class="controls">
                               					<div class="success-toggle-button">
                            					 <input type="checkbox" id="social<%=x%>" class="toggle" checked="checked" onchange="javaScript:social('<%=x%>');" />
                                                 </div>
                                                 </div>
                        						 </div>
											</td>
											</tr>
											</table>

											<%
													x=x+1;
											} %>
											<input type="hidden" id="social_count" name="social_count" value="<%=social_count%>"/>
                            				<input type="hidden"  name="social_total" value="<%=social_total%>"/>

                                 <div class="form-actions clearfix">
                                 <a href="javascript:;" class="btn button-previous">
                                 <i class="m-icon-swapleft"></i> Back 
                                 </a>
                                 <a href="javascript:;" class="btn blue button-next">
                                 Continue <i class="m-icon-swapright m-icon-white"></i>
                                 </a>
                                 
                                
                                
                                
                              </div>
                                 </div>
                                 <!-- ENds here -->
                                     <div class="tab-pane" id="tab10">




                                                  				 
                                    <h3 class="block">Enterprising</h3>
                                    <%	
                                    		int y=0;
                                    		
                                    		int enterprising_count=0;
                                    		int enterprising_total=0;
                 							
                  							ArrayList<question> QE=new ArrayList<question>();
                   							QE=QD.retrieveQuestionInfo("Enterprising");
                   							enterprising_count=QE.size();
                   							enterprising_total=QE.size();
                   							
                   						
                   							 while(y<QE.size())
											{

	 												q=(question)QE.get(y);
	 												
	 												
											%>
											
											<table border="0"   width="100%">
											<tr>
											<td width="50%">
											<span class="block"><%=q.getQuestion() %></span>
											</td>
											<td width="50%">
											    <div class="control-group">
                              					<div class="controls">
                               					<div class="success-toggle-button">
                            					 <input type="checkbox" id="enterprising<%=y%>" class="toggle" checked="checked" onchange="javaScript:enterprising('<%=y%>');" />
                                                 </div>
                                                 </div>
                        						 </div>
											</td>
											</tr>
											</table>

											<%
													y=y+1;
											} %>
											<input type="hidden" id="enterprising_count" name="enterprising_count" value="<%=enterprising_count%>"/>
                            				<input type="hidden"  name="enterprising_total" value="<%=enterprising_total%>"/>

                                 <div class="form-actions clearfix">
                                 <a href="javascript:;" class="btn button-previous">
                                 <i class="m-icon-swapleft"></i> Back 
                                 </a>
                                 <a href="javascript:;" class="btn blue button-next">
                                 Continue <i class="m-icon-swapright m-icon-white"></i>
                                 </a>
                                 
                                
                                
                                
                              </div>
                                 </div>
                                 <!-- ENds here -->
                                     <div class="tab-pane" id="tab11">




                                                  				 
                                    <h3 class="block">conventional</h3>
                                    <%	
                                    		int z=0;
                                    		
                                    		int conventional_count=0;
                                    		int conventional_total=0;
                 							
                  							ArrayList<question> QC=new ArrayList<question>();
                   							QC=QD.retrieveQuestionInfo("Conventional");
                   							conventional_count=QC.size();
                   							conventional_total=QC.size();
                   							
                   						
                   							 while(z<QC.size())
											{

	 												q=(question)QC.get(z);
	 												
	 												
											%>
											
											<table border="0"   width="100%">
											<tr>
											<td width="50%">
											<span class="block"><%=q.getQuestion() %></span>
											</td>
											<td width="50%">
											    <div class="control-group">
                              					<div class="controls">
                               					<div class="success-toggle-button">
                            					 <input type="checkbox" id="conventional<%=z%>" class="toggle" checked="checked" onchange="javaScript:conventional('<%=z%>');" />
                                                </div>
                                                 </div>
                        						 </div>
											</td>
											</tr>
											</table>

											<%
													z=z+1;
											} %>
											<input type="hidden" id="conventional_count" name="conventional_count" value="<%=conventional_count%>"/>
                            				<input type="hidden"  name="conventional_total" value="<%=conventional_total%>"/>

                                 <div class="form-actions clearfix">
                                 <a href="javascript:;" class="btn button-previous">
                                 <i class="m-icon-swapleft"></i> Back 
                                 </a>
                                 <a href="javascript:;" class="btn blue button-next">
                                 Continue <i class="m-icon-swapright m-icon-white"></i>
                                 </a>
                                 <input class="btn green button-submit " type="submit" value="Submit" >
                                
                                
                                
                              </div>
                                 </div>
                                 <!-- ENds here -->
                                 
                              </div>
                             
                           </div>
                           <!-- content ends here -->
                                  </form>
                             
                     </div>
                  </div>
               </div>
            </div>
            <!-- END PAGE CONTENT-->         
         </div>
         <!-- END PAGE CONTAINER-->
      </div>
      <!-- END PAGE -->  
   </div>
   <!-- END CONTAINER -->
   <!-- BEGIN FOOTER -->
  <%@ include file="footer.jsp" %>
   <!-- END FOOTER -->
   <!-- BEGIN JAVASCRIPTS -->    
   <!-- Load javascripts at bottom, this will reduce page load time -->

   <script src="../../user_resources/assets/breakpoints/breakpoints.js"></script>       
   <script src="../../user_resources/assets/bootstrap/js/bootstrap.min.js"></script>
   <script src="../../user_resources/assets/bootstrap-wizard/jquery.bootstrap.wizard.min.js"></script>
   <script src="../../user_resources/assets/js/jquery.blockui.js"></script>

   <!-- ie8 fixes -->
   <!--[if lt IE 9]>
   <script src="../../user_resources/assets/js/excanvas.js"></script>
   <script src="../../user_resources/assets/js/respond.js"></script>
   <![endif]-->
   <script type="text/javascript" src="../../user_resources/assets/chosen-bootstrap/chosen/chosen.jquery.min.js"></script>
   <script type="text/javascript" src="../../user_resources/assets/uniform/jquery.uniform.min.js"></script>
   <script type="text/javascript" src="../../user_resources/assets/bootstrap-wysihtml5/wysihtml5-0.3.0.js"></script> 
   <script type="text/javascript" src="../../user_resources/assets/bootstrap-wysihtml5/bootstrap-wysihtml5.js"></script>
   <script type="text/javascript" src="../../user_resources/assets/bootstrap-toggle-buttons/static/js/jquery.toggle.buttons.js"></script>
   <script type="text/javascript" src="../../user_resources/assets/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
   <script type="text/javascript" src="../../user_resources/assets/bootstrap-daterangepicker/date.js"></script>
   <script type="text/javascript" src="../../user_resources/assets/bootstrap-daterangepicker/daterangepicker.js"></script> 
   <script type="text/javascript" src="../../user_resources/assets/bootstrap-colorpicker/js/bootstrap-colorpicker.js"></script>  
   <script type="text/javascript" src="../../user_resources/assets/bootstrap-timepicker/js/bootstrap-timepicker.js"></script>
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
     
     
 	function select_grade(value ){
 		if(value==1)
 			{
 				document.getElementById('grade_12').className="btn green";
 				document.getElementById('bachelors').className="btn blue";
 				document.getElementById('masters').className="btn blue";
 				document.getElementById('grade_button').value="12";
 			}
 		else if(value==2)
 			{
 				document.getElementById('grade_12').className="btn blue";
				document.getElementById('bachelors').className="btn green";
				document.getElementById('masters').className="btn blue";
				document.getElementById('grade_button').value="bachelors";
 			}
 		else
 			{
 				document.getElementById('grade_12').className="btn blue";
				document.getElementById('bachelors').className="btn blue";
				document.getElementById('masters').className="btn green";
				document.getElementById('grade_button').value="masters";
 			}
	 	
		 }

 	function realistic(value)
 	{
 		
 		var realistic="realistic"+value;
 		var realistic_count=parseInt(document.getElementById('realistic_count').value);
 		
 		var check=document.getElementById(realistic);
 		if(check.checked)
 			{
 				realistic_count=realistic_count+1;
 			}
 		else 
 			{
 				realistic_count=realistic_count-1;
 			}
 		
 		document.getElementById('realistic_count').value=realistic_count;
 	}
 	
	function investigative(value)
 	{
 		var investigative="investigative"+value;
 		var interest_count=parseInt(document.getElementById('investigative_count').value);
 		
 		var check=document.getElementById(investigative);
 		if(check.checked)
 			{
 				investigative_count=investigative_count+1;
 			}
 		else 
 			{
 				investigative_count=interest_count-1;
 			}
 	
 		document.getElementById('investigative_count').value=investigative_count;
 	}
	
	function artistic(value)
 	{
 		var artistic="artistic"+value;
 		var artistic_count=parseInt(document.getElementById('artistic_count').value);
 		
 		var check=document.getElementById(artistic);
 		if(check.checked)
 			{
 				artistic_count=artistic_count+1;
 			}
 		else 
 			{
 				artistic_count=artistic_count-1;
 			}
 		
 		document.getElementById('artistic_count').value=artistic_count;
 	}
	function social(value)
 	{
 		var social="social"+value;
 		var social_count=parseInt(document.getElementById('social_count').value);
 		
 		var check=document.getElementById(social);
 		if(check.checked)
 			{
 			social_count=social_count+1;
 			}
 		else 
 			{
 			social_count=social_count-1;
 			}

 		document.getElementById('social_count').value=social_count;
 	}
	function enterprising(value)
 	{
 		var enterprising="enterprising"+value;
 		var enterprising_count=parseInt(document.getElementById('enterprising_count').value);
 		
 		var check=document.getElementById(enterprising);
 		if(check.checked)
 			{
 			enterprising_count=enterprising_count+1;
 			}
 		else 
 			{
 			enterprising_count=enterprising_count-1;
 			}
 	
 		document.getElementById('enterprising_count').value=enterprising_count;
 	}
	function conventional(value)
 	{
 		var conventional="conventional"+value;
 		var conventional_count=parseInt(document.getElementById('conventional_count').value);
 		
 		var check=document.getElementById(conventional);
 		if(check.checked)
 			{
 			conventional_count=conventional_count+1;
 			}
 		else 
 			{
 			conventional_count=conventional_count-1;
 			}
 		
 		document.getElementById('conventional_count').value=conventional_count;
 	}
	
	

 	
 	</script>

   <script>
 	function group(group,size,id,group_id)
 	{
 		
 		var i=0;
 		
 		for(i=0;i<size;i++)
 			{
 					document.getElementById("group"+i).className="btn blue";
 			}
 					document.getElementById("group"+id).className="btn green";
 					document.getElementById('group_button').value=group_id;
 					
 					
 					
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
 			
 		    document.getElementById("group").innerHTML=xmlhttp.responseText;
 		
 		    }
 		  }
 		
 		xmlhttp.open("GET","get_field.jsp?group="+group_id,true);
 		xmlhttp.send();

 	}
 	function field(field,size,id,field_id,loop_size){
 		
 		
 		
 	
	
 		var i=0;
 		
 		for(i=0;i<size;i++)
 			{
 					document.getElementById("field"+i).className="btn blue";
 			}
 					document.getElementById("field"+id).className="btn green";
 					document.getElementById('field_button').value=field_id;
 			
 					
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
 			 		
 			 		  <%
 	 			 		
 			 		  int slide=0;
 			 		  
 			 		  while(slide<50)
 			 		  {
 			 			check="checkbox";
 			 			check=check+slide;
 			 			  %>
 			 		    	
 			 		    	
 			 			$( ".<%=slide%>" ).slider({
 			 				disabled:false,
 			 				animate:"slow",
 			 				 range: "min",
 			 			value:60,
 			 			min: 33,
 			 			max: 100,
 			 			step: 1,

 			 			slide: function( event, ui ) {
 			 				 $( "#<%=slide%>" ).val( ui.value );
 			 				 $( "#1<%=slide%>" ).text( ui.value );
 			 				 $( "#course<%=slide%>" ).val( ui.value );
 			 				
 			 			}
 			 			});
 			 			$( "#<%=slide%>" ).val(  $( ".<%=slide%>" ).slider( "value" ) );
 			 			$( "#1<%=slide%>").text(  $( ".<%=slide%>" ).slider( "value" ) );
 			 			$( "#course<%=slide%>").val(  $( ".<%=slide%>" ).slider( "value" ) );
 			 			
 			 			//-------------------------------------chech boc-------------------------
 		$('#<%=check%>').click(function() {
        if(!$(this).is(':checked'))
		{

        	$(".<%=slide%>").slider( "option", "disabled", false );
      	  	$("#<%=slide%>").css("background-color","hidden");
        	 
        	
        	}
        else
        	{
        		$(".<%=slide%>").slider( "option", "disabled", true );
      			 $("#<%=slide%>").css("background-color","visible");
      			 $( "#course<%=slide%>" ).val( 0 );
        		
        	}
        	
          
        });
    
 			 		    	<%
 			 		  slide=slide+1;  	
 			 		  }%>
 			 		    }
 			 		  }
 			 		
 			 		xmlhttp.open("GET","get_course.jsp?field="+field_id,true);
 			 		xmlhttp.send();
 			 		
 			 		enjoyment_course(field_id,loop_size);
 		
		 }
	
	function enjoyment_course(field_id,loop_size){
	 	
	 		var xmlhttp;    
 		var m=0;
 	
 		
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

 			

 		    document.getElementById("course_enjoyment").innerHTML=xmlhttp.responseText;
 		  	<% int slide_enjoyment=0;	
 		   while(slide_enjoyment<50)
 		    	{%>
 		    	
 		    	
 		    	
 		    	    $(".E<%=slide_enjoyment%>").slider({
 		    	        disabled: false,
 		    	        animate: "slow",
 		    	        range: "min",
 		    	        value: 0,
 		    	        min: -2500,
 		    	        max: 2500,
 		    	        step: 500,
 		    	        slide: function (event, ui) {
 		    	            $("#E<%=slide_enjoyment%>").val(ui.value);
 		    	            $("#hiddenE<%=slide_enjoyment%>").val(ui.value);
 		    	        },
 		    	        change: function(event, ui){
 		    	           
 		    	            	$('.character', this).css("background-image", "url(../../resources/images/characters/"+ui.value+".png)");
 		    	            
 		    	        }
 		    	    });
 		    	    $("#E<%=slide_enjoyment%>").val($(".E<%=slide_enjoyment%>").slider("value"));
 		    	    $("#hiddenE<%=slide_enjoyment%>").val($(".E<%=slide_enjoyment%>").slider("value"));
 		    	   
 		    	<%
 		    	slide_enjoyment=slide_enjoyment+1;
 		    	}%>
 		    

 		    	}
 		    }
 	xmlhttp.open("GET","get_course_enjoyment.jsp?field="+field_id,true);
 		xmlhttp.send();
		

			

}
 
 
</script>

   <!-- END JAVASCRIPTS -->   
</body>
<!-- END BODY -->
</html>