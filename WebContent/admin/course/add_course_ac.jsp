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

<jsp:useBean id="d" class="database.courseDAO" scope="page"></jsp:useBean>

<!------------------------------------------------ Creating user class object to set values of class attributes------------------------------------------------------------- -->

<jsp:useBean id="c" class="bean.course" scope="page"></jsp:useBean>

<!------------------------------------------------ getting values from forms and setting values of class attributes------------------------------------------------------------- -->
<jsp:setProperty name="c" property="course_name" param="course_name"/>




</body>
</html>