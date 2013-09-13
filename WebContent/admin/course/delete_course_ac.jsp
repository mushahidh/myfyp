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
<jsp:useBean id="d" class="database.courseDAO" scope="page"></jsp:useBean>
<jsp:useBean id="c" class="bean.course" scope="page"></jsp:useBean>
<jsp:setProperty name="c" property="course_id" param="course_id"/>
<%
d.deleteCourse(c);
response.sendRedirect("show_course.jsp");
%>

</body>
</html>