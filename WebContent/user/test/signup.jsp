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
	<link href="../../user_resources/../../user_resources/assets/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
	<link href="../../user_resources/assets/css/metro.css" rel="stylesheet" />
	<link href="../../user_resources/assets/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet" />
	<link href="../../user_resources/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
	<link href="../../user_resources/assets/fullcalendar/fullcalendar/bootstrap-fullcalendar.css" rel="stylesheet" />
	<link href="../../user_resources/assets/css/style.css" rel="stylesheet" />
	<link href="../../user_resources/assets/css/style_responsive.css" rel="stylesheet" />
	<link href="../../user_resources/assets/css/style_default.css" rel="stylesheet" id="style_color" />
	<link rel="stylesheet" type="text/css" href="../../user_resources/assets/chosen-bootstrap/chosen/chosen.css" />
	<link rel="stylesheet" type="text/css" href="../../user_resources/assets/uniform/css/uniform.default.css" />
	<link rel="shortcut icon" href="../../resources/css/images/favicon.png">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="fixed-top">
<h1 style="color:#FFFFFF;">Career Guide Of Pakistan</h1>
	<!-- BEGIN HEADER -->
	
	<!-- END HEADER -->
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
			<%@include file="loginsidemenu.jsp" %>
			<!-- END SIDEBAR MENU -->
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
						<!-- BEGIN PAGE TITLE & BREADCRUMB-->		
						<h3 class="page-title">
							Create User Account Form
							<small>Fields Mark with * are required</small>
						</h3>
						
						<!-- END PAGE TITLE & BREADCRUMB-->
					</div>
				</div>
				<!-- END PAGE HEADER-->
				<!-- BEGIN PAGE CONTENT-->
				
               <div class="portlet box blue">
                     <div class="portlet-title">
                        <h4><i class="icon-reorder"></i>User Registration Form</h4>
                      
                     </div>
                     <div class="portlet-body form">
                        <!-- BEGIN FORM-->
                        <form action="../../user_controller" class="form-horizontal" onsubmit="javaScript: return validate();" >
                           <div class="control-group">
                              <label class="control-label">First Name*</label>
                              <div class="controls">
                                 <input type="text" class="span6 m-wrap" name="user_first_name" id="first_name" required onkeyup="javaScript:validate_first_name();"/>
                                <label id="first_name_info"  style="color:rgba(0,0,0,0.6);font-size:13px">
  								  </label>
  								 
                              </div>
                           </div>
						   <div class="control-group">
                              <label class="control-label" >Last Name</label>
                              <div class="controls">
                                 <input type="text" class="span6 m-wrap" id="last_name" name="user_last_name"  onkeyup="javaScript:validate_last_name();" />
                                 <label id="last_name_info"  style="color:rgba(0,0,0,0.6);font-size:13px">
  								  </label>
                              </div>
                           </div>
						  <div class="control-group">
                              <label class="control-label">Gender*</label>
                              <div class="controls">
                                 <label class="radio">
                                 <input type="radio" name="user_gender" value="male" />
                                 Male
                                 </label>
                                 <label class="radio">
                                 <input type="radio" name="user_gender" value="female" checked="" />
                                 Female
                                 </label>  
                              </div>
                           </div>
						   <div class="control-group">
                              <label class="control-label">Password*</label>
                              <div class="controls">
                                 <input type="password" class="span6 m-wrap" name="user_password" id="password" required onkeyup="javaScript:validatePwd();"/>
                                <label id="password_info"  style="color:rgba(0,0,0,0.6);font-size:13px"></label>
                              </div>
                           </div>
						    <div class="control-group">
                              <label class="control-label">Confirm Password*</label>
                              <div class="controls">
                                 <input type="password" class="span6 m-wrap" name="user_confirm_password" id="confirm_password" required onkeyup="javaScript:validateConfirmPwd();" />
                                <label id="confirm_password_info"  style="color:rgba(0,0,0,0.6);font-size:13px"></label>
                              </div>
                           </div>
						    <div class="control-group">
                              <label class="control-label">Email*</label>
                              <div class="controls">
                                 <input type="email" class="span6 m-wrap" name="user_email" id="email" required onkeyup="validateEmail()" />
                                 <label id="email_info"  style="color:rgba(0,0,0,0.6);font-size:13px"></label>
                              </div>
                              
                           </div>
						      <div class="control-group">
                              <label class="control-label">City</label>
                              <div class="controls">
                                 <select data-placeholder="Enter your city" class="chosen-with-diselect span6" name="user_city" id="user_city" tabindex="-1" id="selCSI">
                                  <option  ></option>
                                 <option value="Islamabad" >Islamabad</option>
			                      <option value="Lahore">Lahore</option>
			                      <option value="Karachi">Karachi</option>
			                      <option value="Faisalabad">Faislabad</option>
			                      <option value="Rawalpindi">Rawalpindi</option>
			                      <option value="Multan">Multan</option>
                                 
                                 </select><p>
                                            <label id="user_city_info"  style="color:rgba(0,0,0,0.6);font-size:13px">
      
   											 </label>
   											 </p>
                              </div>
                           </div>
                          
                             <div class="control-group">
                              <label class="control-label">Screen Name*</label>
                              <div class="controls">
                                 <input type="text" class="span6 m-wrap" id="screen_name" name="user_screen_name" onkeyup="javaScript:validate_screen_name();" required/>
                               <label id="screen_name_info"  style="color:rgba(0,0,0,0.6);font-size:13px">
      							</label>
                              </div>
                           </div>
                            <br/>
                           <br/>
						    <div class="form-actions">
                              <button type="submit" class="btn blue" name="user_action" value="add_user1">Submit</button>
                                 <button type="reset" class="btn">Cancel</button>
                              <br/>
                              <br/>
                           </div>
                        </form>
                        </div>
                        </div>
                    </div>
                    </div>
                    </div>
	<!-- BEGIN FOOTER -->
	
	<!-- END FOOTER -->
	<!-- BEGIN JAVASCRIPTS -->
	<!-- Load javascripts at bottom, this will reduce page load time -->
	<script src="../../user_resources/assets/js/jquery-1.8.3.min.js"></script>			
	<script src="../../user_resources/assets/breakpoints/breakpoints.js"></script>			
	<script src="../../user_resources/assets/jquery-slimscroll/jquery-ui-1.9.2.custom.min.js"></script>	
	<script src="../../user_resources/assets/bootstrap/js/bootstrap.min.js"></script>
	<script src="../../user_resources/assets/js/jquery.blockui.js"></script>
	<script src="../../user_resources/assets/fullcalendar/fullcalendar/fullcalendar.min.js"></script>	
	<script type="text/javascript" src="../../user_resources/assets/uniform/jquery.uniform.min.js"></script>
	<script type="text/javascript" src="../../user_resources/assets/chosen-bootstrap/chosen/chosen.jquery.min.js"></script>
	<!-- ie8 fixes -->
	<!--[if lt IE 9]>
	<script src="../../user_resources/assets/js/excanvas.js"></script>
	<script src="../../user_resources/assets/js/respond.js"></script>
	<![endif]-->
	<script src="../../user_resources/assets/js/app.js"></script>		
	<script>
		jQuery(document).ready(function() {			
			// initiate layout and plugins
			App.setPage('calendar');
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
	<!-- END JAVASCRIPTS -->
<script>
  
function validate_user_city(){

var dropdown = document.getElementById('user_city');

if(dropdown.selectedIndex==0){

user_city_info.innerHTML="Please select your city";
return false;
}
	
		user_city_info.innerHTML="";
		return true;
	

}

function validate_first_name(){
	
	 var TCode = document.getElementById('first_name').value;
	 if(TCode.length==0)
	 {
		 first_name_info.innerHTML="This field is required";
		 return false;
	 }
   	first_name_info.innerHTML=" ";
	    if( /[^a-zA-Z ]/.test( TCode ) ) {
	    	first_name_info.innerHTML="Please Enter Only Alphabets ";
	       return false;
	    }
	    first_name_info.innerHTML=" ";
	    return true;  

	}
function validate_last_name(){

	 var TCode = document.getElementById('last_name').value;
	 if(TCode.length==0)
		 {
			 last_name_info.innerHTML="This field is required";
			 return false;
		 }
	   last_name_info.innerHTML=" ";
	    if( /[^a-zA-Z ]/.test( TCode ) ) {
	    	last_name_info.innerHTML="Please Enter Only Alphabets ";
	       return false;
	    }
	    last_name_info.innerHTML=" ";
	    return true;  

	}
function validate_screen_name(){
	
	 var TCode = document.getElementById('screen_name').value;
	 if(TCode.length==0)
	 {
		 screen_name_info.innerHTML="This field is required";
		 return false;
	 }
   		screen_name_info.innerHTML=" ";
	    if( /[^a-zA-Z1-9@ _-]/.test( TCode ) ) {
	    	
	    	screen_name_info.innerHTML="Please Enter Only Alphanumeric or @,_,-,' '  ";
	       return false;
	    }
	    screen_name_info.innerHTML=" ";
	    return true;  

	}
function validateEmail(){
	
	 var TCode = document.getElementById('email').value;
	var flag=0;
		
	 if(TCode.length==0)
	 {
		 email_info.innerHTML="This field is required";
		 return false;
	 }
  		email_info.innerHTML=" ";
  		var atpos=TCode.indexOf("@");
  		var dotpos=TCode.lastIndexOf(".");
  		if (atpos<1 || dotpos<atpos+2 || dotpos+2>=TCode.length)
  		  {
  			 email_info.innerHTML="Not a valid e-mail address";
  		  return false;
  		  
  		  }
  		email(function(check){
  	        if(check.indexOf("Not") !== -1)
  	        	{
  	        		
  	        		flag=1;
  	        	}
  	    });
  		if(flag==1)
  			{
  				email_info.innerHTML="User already Registered With This Email";
  				return false;
  			}
 		return true;
 	 

}

function email(callback)
{
	var TCode = document.getElementById('email').value;
	var result="hey";
	$.ajax({
		type: "POST",
		async: false,
		url: "get_email.jsp",
		data: "email="+TCode,
		success: function(html){
		
		result=html;
		
		callback(result);
		}
		});
	
	
	
}

function validatePwd() {
var minLength = 4; // Minimum length
var pw1 = document.getElementById('password').value;
if(pw1.length==0)
{
	 password_info.innerHTML="This field is required";
	 return false;
}
password_info.innerHTML=" ";

// check for minimum length
if (pw1.length < minLength) {

	password_info.innerHTML="Your password must be at least "  + minLength +  " characters long. ";
return false;
}
password_info.innerHTML=" ";
validateConfirmPassword();
return true;
}
function validateConfirmPwd() {
	
	
	var pw2 = document.getElementById('confirm_password').value;
	if(pw2.length==0)
	{
		 confirm_password_info.innerHTML="This field is required";
		 return false;
	}
	confirm_password_info.innerHTML=" ";
	// check for minimum length

	
	validateConfirmPassword();
	return true;
	   
	}
function validateConfirmPassword() {
	
	var pw1 = document.getElementById('password').value;
	var pw2 = document.getElementById('confirm_password').value;

	
	if (pw1 != pw2) {
		confirm_password_info.innerHTML="You did not enter the same password";
	return false;
	}
	confirm_password_info.innerHTML="";
	return true;
	   
	}
function validate(){
		if( validateEmail()==true&&validateConfirmPwd()&&validatePwd()==true&&validate_user_city()==true && validate_first_name()==true&&validate_last_name()==true&&validate_screen_name()==true)
			{
				return true;
			}
		return false;

	//return validatePwd();
}
</script>
</body>
<!-- END BODY -->
</html>