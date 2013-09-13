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
<jsp:useBean id="d" class="database.userDAO" scope="page"></jsp:useBean>
<jsp:useBean id="u" class="bean.user" scope="page"></jsp:useBean>
<jsp:setProperty name="u" property="user_id" param="user_id"/>
<%
d.deleteStudent(u);
response.sendRedirect("show_user.jsp");
%>

</body>
</html>