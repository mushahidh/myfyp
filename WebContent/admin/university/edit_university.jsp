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
<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="../../resources/../../../html5shim.googlecode.com/svn/trunk/html5.js"></script>
      <![endif]-->
</head>

<body>
<div id="loading"><img src="../../resources/img/ajax-loader.gif"></div>
<div id="responsive_part">
  <div class="logo"> <a href="../../resources/index.html"><span>Start</span><span class="icon"></span></a> </div>
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
          <li class="dropdown"> <a class="dropdown-toggle administrator" id="dLabel" role="button" data-toggle="dropdown" data-target="#" href="../../resources/../../page.html">
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
          <div class="box paint color_4">
            <div class="title">
              <h4> <span>Edit University</span> <span style="font-size:11px;">(Fields marked with * are required)</span> </h4>
            </div>
            <div class="content">
              <form class="form-horizontal cmxform" id="validateForm" method="get" onsubmit="javaScript: return validate();" action="../../university_controller" autocomplete="off">
               <%
        				universityDAO UD=new universityDAO();
     	 				String idd=request.getParameter("uni_id");
     					int id=Integer.parseInt(idd);
						university u=UD.getUniversityInfo(id);
        		 %>
                 <div class="form-row control-group row-fluid">
                  <label class="control-label span3" for="with-tooltip">Name*</label>
                  <div class="controls span7">
                    <input type="text" id="uni_name" name="uni_name" value="<%=u.getUni_name()%>"  placeholder="Enter university Name..." class="row-fluid" required onkeyup="javaScript:validate_uni_name();">
                     <input type="hidden" name="uni_id" value="<%=u.getUni_id()%>">
                     <label id="uni_name_info"  style="color:rgba(255,255,255,0.6);font-size:13px">
  					  </label>
                  </div>
                </div>
                
                 <div class="form-row control-group row-fluid">
                  <label class="control-label span3">Select City*</label>
                  <div class="controls span7">
                    <select data-placeholder="Choose a City..." class="chzn-select" name="uni_city" id="uni_city" required onChange="javaScript:validate_uni_city();">
                      <option value="<%=u.getUni_location()%>"><%=u.getUni_location()%></option>
                      <option value="Islamabad">Islamabad</option>
                      <option value="Lahore">Lahore</option>
                      <option value="Karachi">Karachi</option>
                      <option value="Faisalabad">Faislabad</option>
                      <option value="Rawalpindi">Rawalpindi</option>
                      <option value="Multan">Multan</option>
                        </select>
                        <label id="uni_city_info"  style="color:rgba(255,255,255,0.6);font-size:13px"></label>
                  </div>
                </div>
                  <div class="form-row control-group row-fluid">
                  <label class="control-label span3" for="with-tooltip">Address*</label>
                  <div class="controls span7">
                    <input type="text" id="uni_address" name="uni_address" value="<%=u.getUni_address()%>" placeholder="Enter university Address..." class="row-fluid" required>
                  
                  </div>
                </div>
                
                 <div class="form-row control-group row-fluid">
                  <label class="control-label span3">Website <span class="help-block">http://www.envato.com</span> </label>
                  <div class="controls span7">
                    <input id="curl" type="url" name="uni_website" value="<%=u.getUni_website()%>" required class="row-fluid"/>
                  </div>
                </div>
                
                  <div class="form-row control-group row-fluid">
                  <label class="control-label span3" for="with-tooltip">Description</label>
                  <div class="controls span7">
                    <input type="text" id="with-tooltip" name="uni_desc" value="<%=u.getUni_desc()%>"  placeholder="Enter university Description..." class="row-fluid" >
                  </div>
                </div>
               
             
            
                
              <div class="form-actions row-fluid">
                  <div class="span7 offset3">
                    <button type="submit" name="user_action" value="edit" class="btn btn-primary" onClick="javaScript:validate();">Save</button>
                    <button type="reset" class="btn btn-secondary">Cancel</button>
                  </div>
                </div>
         

              </form>
            </div>
          </div>
          <!-- End .box --> 
        </div>
        <!-- End .span8 -->
        
      </div>
      <!-- End .row-fluid --> 
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
</div>
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

<!-- Validation plugin --> 
<script src="../../resources/js/plugins/validation/dist/jquery.validate.min.js" type="text/javascript"></script> 

<!-- Custom made scripts for this template --> 
<script src="../../resources/js/scripts.js" type="text/javascript"></script> 
<script type="text/javascript">
  /**** Specific JS for this page ****/

  //Validation things

$().ready(function() {
	 $("#mask-phone").mask("(999) 999-9999");
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
  // validate the comment form when it is submitted
  // validate signup form on keyup and submit
  $("#validateForm").validate({
    rules: {
     uni_name:{
        required: true,
      },
      uni_address:{
          required: true,
        },
        uni_city:{
            required: true,
          },
      email: {
        required: true,
        email: true
      },
      uni_address: {
          required: true,
        },
      user_password: {
        required: true,
        minlength: 5
      },
      user_confirm_password: {
        required: true,
        minlength: 5,
        equalTo: "#password"
      },
      topic: {
        required: "#newsletter:checked",
        minlength: 2
      },
      agree: "required",
      uni_city:"required",
    
    },
    messages: {
      firstname: "Please enter your firstname",
      lastname: "Please enter your lastname",
      username: {
        required: "Please enter a username",
        minlength: "Your username must consist of at least 2 characters"
      },
   
      password: {
        required: "Please provide a password",
        minlength: "Your password must be at least 5 characters long"
      },
      confirm_password: {
        required: "Please provide a password",
        minlength: "Your password must be at least 5 characters long",
        equalTo: "Please enter the same password as above"
      },
      email: "Please enter a valid email address",
      agree: "Please accept our policy",
    }
  });
  // propose username by combining first- and lastname
  $("#username").focus(function() {
    var firstname = $("#firstname").val();
    var lastname = $("#lastname").val();
    if(firstname && lastname && !this.value) {
      this.value = firstname + "." + lastname;
    }
  });
  //code to hide topic selection, disable for demo
  var newsletter = $("#newsletter");
  // newsletter topics are optional, hide at first
  var inital = newsletter.is(":checked");
  var topics = $("#newsletter_topics")[inital ? "removeClass" : "addClass"]("gray");
  var topicInputs = topics.find("input").attr("disabled", !inital);
  // show when newsletter is checked
  newsletter.click(function() {
    topics[this.checked ? "removeClass" : "addClass"]("gray");
    topicInputs.attr("disabled", !this.checked);
  });
});

function validate_uni_city(){
	var dropdown = document.getElementById('uni_city');

	if(dropdown.selectedIndex==0){

	uni_city_info.innerHTML="Please select city of university";
	return false;
	}
	
		uni_city_info.innerHTML="";
		return true;
		
	}
function validate_uni_name(){
	
	 var TCode = document.getElementById('uni_name').value;
	    if( /[^a-zA-Z1-9 _-]/.test( TCode ) ) {
	    	
	    	uni_name_info.innerHTML="Please Enter Only Alphanumeric or _,-,' '  ";
	       return false;
	    }
	    uni_name_info.innerHTML=" ";
	    return true;  

	}
function validate()
{
	if(validate_uni_city()==true&&validate_uni_name()==true)
		{
		 	return true;
		}
	return false;
	
}
</script>

</body>
</html>