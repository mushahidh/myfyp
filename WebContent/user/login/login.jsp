<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
  <meta charset="utf-8" />
  <title>Login</title>
  <meta content="width=device-width, initial-scale=1.0" name="viewport" />
  <meta content="" name="description" />
  <meta content="" name="author" />
  <link href="../../user_resources/assets/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
  <link href="../../user_resources/assets/css/metro.css" rel="stylesheet" />
  <link href="../../user_resources/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
  <link href="../../user_resources/assets/css/style.css" rel="stylesheet" />
  <link href="../../user_resources/assets/css/style_responsive.css" rel="stylesheet" />
  <link href="../../user_resources/assets/css/style_default.css" rel="stylesheet" id="style_color" />
  <link rel="stylesheet" type="text/css" href="../../user_resources/assets/uniform/css/uniform.default.css" />
<link rel="shortcut icon" href="../../resources/css/images/favicon.png">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>
<script src="../../user_resources/assets/js/jquery-1.8.3.min.js"></script>


<script>
$(document).ready(function(){
  

    $(".msg").fadeOut(8000);
 
});
</script>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="login">
  <!-- BEGIN LOGO -->
  <div class="logo">
   
  </div>
  <!-- END LOGO -->
  <!-- BEGIN LOGIN -->
  <div class="content">
    <!-- BEGIN LOGIN FORM -->
    <form class="form-vertical login-form" action="../../user_login_controller" >
      <h3 class="form-title">Login to your account</h3>
      <div class="control-group">
        <div class="controls">
         <%
         int message=0;
         String check=request.getParameter("msg");
         if (check!=null)
        		 {
        			  message=Integer.parseInt(request.getParameter("msg"));
        		 }
 
         if(message==2)
         {
        %>
        <span class="msg" ><i class="icon-warning-sign"></i> Please Login First</span>
        	
        <% }
         else if(message==1)
         {
        	 
         %>
        	<span class="msg" ><i class="icon-remove-circle"></i> Invalid User Name or Password</span> 
       	<% 
         }
         else
         {
        %>
       
        <% 
         }
       	%>
          <div class="input-icon left">
            <i class="icon-user"></i>
            <input class="m-wrap" type="text" placeholder="Username" name="user_email" required />
          </div>
        </div>
      </div>
      <div class="control-group">
        <div class="controls">
          <div class="input-icon left">
            <i class="icon-lock"></i>
            <input class="m-wrap" type="password" style="" placeholder="Password" name="user_password" required/>
          </div>
        </div>
      </div>
     <div class="">
        <h4>Not registered yet?</h4>
        <p>
          no worries, click <a href="../test/signup.jsp" class="" >here</a>
          to register
        </p>
      </div>
      <div class="form-actions">
   
        <span ><input id="login-btn" class="btn green pull-right" type="submit" value="Login" name="user_action"> <i class="m-icon-swapright m-icon-white"></i></span>
        
                   
      </div>
    
    </form>
    <!-- END LOGIN FORM -->        
    <!-- BEGIN FORGOT PASSWORD FORM -->
  
    <!-- END FORGOT PASSWORD FORM -->
  </div>
  <!-- END LOGIN -->
  <!-- BEGIN COPYRIGHT -->
  <div class="copyright">
    2013 &copy; ICGS.
  </div>
  <!-- END COPYRIGHT -->
  <!-- BEGIN JAVASCRIPTS -->
  <script src="../../user_resources/assets/js/jquery-1.8.3.min.js"></script>
  <script src="../../user_resources/assets/bootstrap/js/bootstrap.min.js"></script>  
  <script src="../../user_resources/assets/uniform/jquery.uniform.min.js"></script> 
  <script src="../../user_resources/assets/js/jquery.blockui.js"></script>
  <script src="../../user_resources/assets/js/app.js"></script>
  <script>
    jQuery(document).ready(function() {     
      App.initLogin();
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
</body>
<!-- END BODY -->
</html>