<%---<%@ page errorPage="addbookerror.jsp" %> --%>
<%@ page import="java.sql.*"  %>
 <%@ page import="bean.*" %>
<%@ page import="database.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title></title>
</head>
<body>
<!------------------------------------------------ Creating DataBase object------------------------------------------------------------- -->

<jsp:useBean id="d" class="database.interestDAO" scope="page"></jsp:useBean>

<!------------------------------------------------ Creating user class object to set values of class attributes------------------------------------------------------------- -->

<jsp:useBean id="i" class="bean.interest" scope="page"></jsp:useBean>

<!------------------------------------------------ getting values from forms and setting values of class attributes------------------------------------------------------------- -->
<jsp:setProperty name="i" property="field_id" param="field_id"/>
<jsp:setProperty name="i" property="realistic" param="realistic"/>
<jsp:setProperty name="i" property="investigative" param="investigative"/>
<jsp:setProperty name="i" property="artistic" param="artistic"/>
<jsp:setProperty name="i" property="social" param="social"/>
<jsp:setProperty name="i" property="enterprising" param="enterprising"/>
<jsp:setProperty name="i" property="conventional" param="conventional"/>



</body>
</html>