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

<jsp:useBean id="d" class="database.universityDAO" scope="page"></jsp:useBean>

<!------------------------------------------------ Creating user class object to set values of class attributes------------------------------------------------------------- -->

<jsp:useBean id="u" class="bean.university" scope="page"></jsp:useBean>

<!------------------------------------------------ getting values from forms and setting values of class attributes------------------------------------------------------------- -->
<jsp:setProperty name="u" property="uni_name" param="uni_name"/>
<jsp:setProperty name="u" property="uni_location" param="uni_city"/>
<jsp:setProperty name="u" property="uni_address" param="uni_address"/>
<jsp:setProperty name="u" property="uni_website" param="uni_website"/>
<jsp:setProperty name="u" property="uni_desc" param="uni_desc"/>



</body>
</html>