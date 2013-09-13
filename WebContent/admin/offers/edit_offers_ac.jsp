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

<jsp:useBean id="d" class="database.offersDAO" scope="page"></jsp:useBean>

<!------------------------------------------------ Creating user class object to set values of class attributes------------------------------------------------------------- -->

<jsp:useBean id="o" class="bean.offers" scope="page"></jsp:useBean>

<!------------------------------------------------ getting values from forms and setting values of class attributes------------------------------------------------------------- -->
<jsp:setProperty name="o" property="uni_id" param="uni_id"/>
<jsp:setProperty name="o" property="field_idd" param="field_id"/>
<jsp:setProperty name="o" property="hssc_criteria" param="hssc_criteria"/>
<jsp:setProperty name="o" property="ssc_criteria" param="ssc_criteria"/>
<jsp:setProperty name="o" property="duration" param="duration"/>



</body>
</html>