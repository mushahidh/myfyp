<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="bean.*" %>
<%@ page import="database.*" %>
<!DOCTYPE html>
<html class="sidebar_default no-js" lang="en">
<head>
<meta charset="utf-8">
<title>ICGS</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon" href="../../resources/css/images/favicon.png">
<!-- Le styles -->
<link href="../../resources/js/plugins/chosen/chosen/chosen.css" rel="stylesheet">
<link href="../../resources/css/twitter/bootstrap.css" rel="stylesheet">
<link href="../../resources/css/base.css" rel="stylesheet">
<link href="../../resources/css/twitter/responsive.css" rel="stylesheet">
<link href="../../resources/css/jquery-ui-1.8.23.custom.css" rel="stylesheet">
<script src="../../resources/js/plugins/modernizr.custom.32549.js"></script>
<link rel="stylesheet" href="../../user_resources/assets/css/jquery-ui.css" />
<script src="../../user_resources/assets/js/jquery-1.9.1.js"></script>
<script src="../../user_resources/assets/js/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css" />
  <script src="../../user_resources/assets/js/jquery-min.js">
</script>
<script>
$(document).ready(function(){
  

    $(".msg").fadeOut(5000);
 
});
</script>
<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="../../resources/../../../html5shim.googlecode.com/svn/trunk/html5.js"></script>
      <![endif]-->
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
background: #FFFFFF;
}

 .slider_value
{
border: 0;
visibility:visible;
font-weight:bold;
text-align:center;
text-shadow:0 1px 1px #000;
font-weight:700;

text-align:justify;
color: #FFFFFF; 

}
.ui-widget-content { background: #FFFFFF; width:85%; }//change color and width

.slide .ui-slider-range {
    background: #FFFFFF !important;
}

.ui-widget-content .ui-state-default { background:#FFFFFF; width:20px; height:20px;}// change button color


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

</style>
</head>

<script>
$(function() {
$( ".hssc" ).slider({
	disabled:false,
	animate:"slow",
	 range: "min",
value:60,
min: 33,
max: 90,
step: 1,

slide: function( event, ui ) {
	 $( "#hssc" ).val( ui.value );
	 $( "#hssc1" ).text( ui.value );
	 $( "#hiddenhssc" ).val( ui.value );

 
}
});
$( "#hssc" ).val(  $( ".hssc" ).slider( "value" ) );
$( "#hssc1" ).text(  $( ".hssc" ).slider( "value" ) );
$( "#hiddenhssc" ).val(  $( ".hssc" ).slider( "value" ) );


});
</script>

<script>
$(function() {
$( ".ssc" ).slider({
	disabled:false,
	animate:"slow",
	 range: "min",
value:60,
min: 33,
max: 90,
step: 1,

slide: function( event, ui ) {
	 $( "#ssc" ).val( ui.value );
	 $( "#ssc1" ).text( ui.value );
	 $( "#hiddenssc" ).val( ui.value );

 
}
});
$( "#ssc" ).val(  $( ".ssc" ).slider( "value" ) );
$( "#ssc1" ).text(  $( ".ssc" ).slider( "value" ) );
$( "#hiddenssc" ).val(  $( ".ssc" ).slider( "value" ) );


});
</script>

<script>
$(function() {
$( ".duration" ).slider({
	disabled:false,
	animate:"slow",
	 range: "min",
value:18,
min: 6,
max: 72,
step: 6,

slide: function( event, ui ) {
	 $( "#duration" ).val( ui.value );
	 $( "#duration1" ).text( ui.value );
	 $( "#hiddenduration" ).val( ui.value );

 
}
});
$( "#duration" ).val(  $( ".duration" ).slider( "value" ) );
$( "#duration1" ).text(  $( ".duration" ).slider( "value" ) );
$( "#hiddenduration" ).val(  $( ".duration" ).slider( "value" ) );


});
</script>


<body>
<div id="loading"><img src="../../resources/img/ajax-loader.gif"></div>
<div id="responsive_part">
  <div class="logo"> <a href="index.html"><span>Start</span><span class="icon"></span></a> </div>
  <ul class="nav responsive">
    <li>
      <button class="btn responsive_menu icon_item" data-toggle="collapse" data-target=".overview"> <i class="icon-reorder"></i> </button>
    </li>
  </ul>
</div>
<!-- Responsive part -->
 <%@ include file="../include directive/side_menu.jsp" %>
<div id="main">
  <div class="container">
    <div class="header row-fluid">
       <%@ include file="../include directive/header.jsp" %>
      <div class="top_right">
        <ul class="nav nav_menu">
          <li class="dropdown"> <a class="dropdown-toggle administrator" id="dLabel" role="button" data-toggle="dropdown" data-target="#" href="../../page.html">
            <%@include file="../include directive/screen_name.jsp" %></a>
          <%@include file="../include directive/logout.jsp" %>
          </li>
        </ul>
      </div>
      <!-- End top-right --> 
    </div>
    <div id="main_container">
      <div class="row-fluid">
        <div class="span7">
          <div class="box paint color_7">
            <div class="title">
              <h4> <i class="icon-book"></i><span>Add Programs Offering</span> </h4>
            </div>
            <div class="content">
              <form class="form-horizontal cmxform" id="validateForm" action="../../offers_controller">
                <%if(request.getParameter("msg").equals(""))
              {
            	  
              }
              else
              {%>
            		<span class="msg" ><i class="icon-ok-sign"></i>  Record Successfully Added</span>
            	  <% 
              }
              %>
                 <div class="form-row control-group row-fluid">
                  <label class="control-label span3">Select University*</label>
                  <div class="controls span7">
                    <select data-placeholder="Choose a field..." class="chzn-select" name="uni_id" id="uni_id" required onChange="javaScript:validate_uni();">
                      <option value=""></option>
                       <%
        		universityDAO UD=new universityDAO();
				ArrayList<university> UI=new ArrayList<university>();
				UI=UD.retrieveUniversityInfo();
				university u=null;
				for(int i=0;i<UI.size();i++)
				{
					u=(university)UI.get(i);
            %>
                      <option value="<%=u.getUni_id()%>"><%=u.getUni_name()%></option>
         	  <%} %> 
                     

                    </select>
                      <label id="uni_info"  style="color:rgba(255,255,255,0.6);font-size:13px"></label>
                  </div>
                </div>
                
                <div class="form-row control-group row-fluid">
                  <label class="control-label span3" for="inputEmail">Select Required Fields*</label>
                  <div class="controls span7">
                    <select data-placeholder="Choose a field" class="chzn-select" multiple="" tabindex="3" name="field_id" id="field_id" required onChange="javaScript:validate_field();">
                    <%
        		fieldDAO FRD=new fieldDAO();
				ArrayList<field> FRI=new ArrayList<field>();
				FRI=FRD.retrieveFieldInfo();
				field fr=null;
				for(int i=0;i<FRI.size();i++)
				{
					fr=(field)FRI.get(i);
            %>
                     <option value="<%=fr.getField_id()%>"><%=fr.getField_name()%></option>
         	  <%} %>    
                    </select>
                      <label id="field_info"  style="color:rgba(255,255,255,0.6);font-size:13px"></label>
                  </div>
                </div>
                
                
                    <div class="form-row control-group row-fluid">
                  <label class="control-label span3" for="inputEmail">HSSC Criteria*</label>
                  <div class="controls span7">
               
               <input type="hidden" id="hiddenhssc" name="hssc_criteria" value="hiddenhssc"/>
               <div class="hssc" style="display: inline-block; ">
              
                  </div>
                   <span id="hssc1" class="slider_value"></span>  <span>%</span>
                </div>
                </div>
                        <div class="form-row control-group row-fluid">
                  <label class="control-label span3" for="inputEmail">SSC Criteria*</label>
                  <div class="controls span7">
                    <input type="hidden" id="hiddenssc" name="ssc_criteria" value="hiddenssc"/>
               <div class="ssc" style="display: inline-block; ">
              
                  </div>
                   <span id="ssc1" class="slider_value"></span>  <span>%</span>
                </div>
                </div>
                  <div class="form-row control-group row-fluid">
                  <label class="control-label span3" for="inputEmail">Duration (In Months)*</label>
                  <div class="controls span7">
                 <input type="hidden" id="hiddenduration" name="duration" value="hiddenduration"/>
               <div class="duration" style="display: inline-block; ">
              
                  </div>
                   <span id="duration1" class="slider_value"></span>  <span>M</span>
                </div>
                </div>
                     <div class="form-actions row-fluid">
                  <div class="span7 offset3">
                    <button type="submit" name="user_action" value="add" class="btn btn-primary" onClick="javaScript:validate();">Save</button>
                    <button type="reset" class="btn btn-secondary">Cancel</button>
                  </div>
                </div>
              </form>
            </div>
          </div>
          <input type="hidden" id="text"  >
          
                  
                 
               
               
             
         
         
        </div>
        <!-- End .span8 --><!-- End .span4 --> 
      </div>
    </div>
    <!-- End #container --> 
  </div>
 <%@ include file="../include directive/footer.jsp" %>
<div class="background_changer dropdown">
  <div class="dropdown" id="colors_pallete"> <a data-toggle="dropdown" data-target="drop4" class="change_color"></a>
    <ul  class="dropdown-menu pull-left" role="menu" aria-labelledby="drop4">
      <li><a data-color="color_0" class="color_0" tabindex="-1">1</a></li>
      <li><a data-color="color_1" class="color_1" tabindex="-1">1</a></li>
      <li><a data-color="color_2" class="color_2" tabindex="-1">2</a></li>
      <li><a data-color="color_3" class="color_3" tabindex="-1">3</a></li>
      <li><a data-color="color_4" class="color_4" tabindex="-1">4</a></li>
      <li><a data-color="color_5" class="color_5" tabindex="-1">5</a></li>
      <li><a data-color="color_6" class="color_6" tabindex="-1">6</a></li>
      <li><a data-color="color_7" class="color_7" tabindex="-1">7</a></li>
      <li><a data-color="color_8" class="color_8" tabindex="-1">8</a></li>
      <li><a data-color="color_9" class="color_9" tabindex="-1">9</a></li>
      <li><a data-color="color_10" class="color_10" tabindex="-1">10</a></li>
      <li><a data-color="color_11" class="color_11" tabindex="-1">10</a></li>
      <li><a data-color="color_12" class="color_12" tabindex="-1">12</a></li>
      <li><a data-color="color_13" class="color_13" tabindex="-1">13</a></li>
      <li><a data-color="color_14" class="color_14" tabindex="-1">14</a></li>
      <li><a data-color="color_15" class="color_15" tabindex="-1">15</a></li>
      <li><a data-color="color_16" class="color_16" tabindex="-1">16</a></li>
      <li><a data-color="color_17" class="color_17" tabindex="-1">17</a></li>
      <li><a data-color="color_18" class="color_18" tabindex="-1">18</a></li>
      <li><a data-color="color_19" class="color_19" tabindex="-1">19</a></li>
      <li><a data-color="color_20" class="color_20" tabindex="-1">20</a></li>
      <li><a data-color="color_21" class="color_21" tabindex="-1">21</a></li>
      <li><a data-color="color_22" class="color_22" tabindex="-1">22</a></li>
      <li><a data-color="color_23" class="color_23" tabindex="-1">23</a></li>
      <li><a data-color="color_24" class="color_24" tabindex="-1">24</a></li>
      <li><a data-color="color_25" class="color_25" tabindex="-1">25</a></li>
    </ul>
  </div>
</div>
<!-- End .background_changer -->

<!-- /container --> 

<!-- Le javascript
    ================================================== --> 
<!-- General scripts --> 
<script src="../../resources/js/jquery.js" type="text/javascript"> </script> 
<script src="../../resources/js/plugins/enquire.min.js" type="text/javascript"></script> 
<script language="javascript" type="text/javascript" src="../../resources/js/plugins/jquery.sparkline.min.js"></script> 
<script src="../../resources/js/plugins/excanvas.compiled.js" type="text/javascript"></script> 
<script src="../../resources/js/bootstrap-transition.js" type="text/javascript"></script> 
<script src="../../resources/js/bootstrap-alert.js" type="text/javascript"></script> 
<script src="../../resources/js/bootstrap-modal.js" type="text/javascript"></script> 
<script src="../../resources/js/bootstrap-dropdown.js" type="text/javascript"></script> 
<script src="../../resources/js/bootstrap-scrollspy.js" type="text/javascript"></script> 
<script src="../../resources/js/bootstrap-tab.js" type="text/javascript"></script> 
<script src="../../resources/js/bootstrap-tooltip.js" type="text/javascript"></script> 
<script src="../../resources/js/bootstrap-popover.js" type="text/javascript"></script> 
<script src="../../resources/js/bootstrap-button.js" type="text/javascript"></script> 
<script src="../../resources/js/bootstrap-collapse.js" type="text/javascript"></script> 
<script src="../../resources/js/bootstrap-carousel.js" type="text/javascript"></script> 
<script src="../../resources/js/bootstrap-typeahead.js" type="text/javascript"></script> 
<script src="../../resources/js/bootstrap-affix.js" type="text/javascript"></script> 
<script src="../../resources/js/fileinput.jquery.js" type="text/javascript"></script> 
<script src="../../resources/js/jquery-ui-1.8.23.custom.min.js" type="text/javascript"></script> 
<script src="../../resources/js/jquery.touchdown.js" type="text/javascript"></script> 
<script language="javascript" type="text/javascript" src="../../resources/js/plugins/jquery.uniform.min.js"></script> 
<script language="javascript" type="text/javascript" src="../../resources/js/plugins/jquery.tinyscrollbar.min.js"></script> 
<script language="javascript" type="text/javascript" src="../../resources/js/jnavigate.jquery.min.js"></script> 
<script language="javascript" type="text/javascript" src="../../resources/js/jquery.touchSwipe.min.js"></script> 
<script language="javascript" type="text/javascript" src="../../resources/js/plugins/jquery.peity.min.js"></script> 
<script language="javascript" type="text/javascript" src="../../resources/js/plugins/wysihtml5-0.3.0.min.js"></script> 
<script language="javascript" type="text/javascript" src="../../resources/js/plugins/bootstrap-wysihtml5.js"></script> 
<script language="javascript" type="text/javascript" src="../../resources/js/plugins/jquery.peity.min.js"></script> 
<script language="javascript" type="text/javascript" src="../../resources/js/plugins/jquery.uniform.min.js"></script> 
<script language="javascript" type="text/javascript" src="../../resources/js/plugins/textarea-autogrow.js"></script> 
<script language="javascript" type="text/javascript" src="../../resources/js/plugins/character-limit.js"></script> 
<script language="javascript" type="text/javascript" src="../../resources/js/plugins/jquery.maskedinput-1.3.js"></script> 
<script language="javascript" type="text/javascript" src="../../resources/js/plugins/chosen/chosen/chosen.jquery.min.js"></script> 
<script language="javascript" type="text/javascript" src="../../resources/js/plugins/bootstrap-datepicker.js"></script> 
<script language="javascript" type="text/javascript" src="../../resources/js/plugins/bootstrap-colorpicker.js"></script> 

<!-- Custom made scripts for this template --> 
<script src="../../resources/js/scripts.js" type="text/javascript"></script> 
<script type="text/javascript">
  /**** Specific JS for this page ****/
 $(document).ready(function () {
       
        $('textarea.autogrow').autogrow();
        var elem = $("#chars");
        $("#text").limiter(100, elem);
        // Mask plugin http://digitalbush.com/projects/masked-input-plugin/
        $("#mask-phone").mask("(999) 999-9999");
        $("#mask-date").mask("99-99-9999");
        $("#mask-int-phone").mask("+33 999 999 999");
        $("#mask-tax-id").mask("99-9999999");
        $("#mask-percent").mask("99%");
        // Editor plugin https://github.com/jhollingworth/bootstrap-wysihtml5/
        $('#editor1').wysihtml5({
          "image": false,
          "link": false
          });
        // Chosen select plugin
        $(".chzn-select").chosen({
          disable_search_threshold: 10
        });
        // Datepicker
        $('#datepicker1').datepicker({
          format: 'mm-dd-yyyy'
        });
        $('#datepicker2').datepicker();
        $('.colorpicker').colorpicker();
        $('#colorpicker3').colorpicker();
    });


	function validate_field(){
		 var field = document.getElementById('field_id');
		
		 if(field.selectedIndex!=-1){

		 field_info.innerHTML="";

		 }
		 else
		 	{
		 	field_info.innerHTML="Please select a field";
		 	}
		 	
		 }

	function validate_uni(){
		 var uni = document.getElementById('uni_id');
			
		 if(uni.selectedIndex==0){

		 uni_info.innerHTML="Please select a university";

		 }
		 else
		 	{
		 	uni_info.innerHTML="";
		 	}
		 	
		 }
	function validate_hssc(){
		 var hssc = document.getElementById('hssc_criteria');
			
		 if(hssc.selectedIndex==0){

		 hssc_info.innerHTML="Please select hssc criteria";

		 }
		 else
		 	{
		 	hssc_info.innerHTML="";
		 	}
		 	
		 }
	function validate_ssc(){
		 var ssc = document.getElementById('ssc_criteria');
			
		 if(ssc.selectedIndex==0){

		 ssc_info.innerHTML="Please select ssc criteria";

		 }
		 else
		 	{
		 	ssc_info.innerHTML="";
		 	}
		 	
		 }
	function validate_duration(){
		 var duration = document.getElementById('duration');
			
		 if(duration.selectedIndex==0){

		 duration_info.innerHTML="Please select duration";

		 }
		 else
		 	{
		 	duration_info.innerHTML="";
		 	}
		 	
		 }

	function validate()
	{
		if(validate_field()==true&&validate_uni()==true&&validate_ssc()==true&&validate_hssc()==true&&validate_duration()==true)
			{
			 	return true;
			}
		return false;
		
	}


</script>
</body>
</html>