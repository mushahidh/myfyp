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
<jsp:useBean id="d" class="database.groupDAO" scope="page"></jsp:useBean>
<jsp:useBean id="g" class="bean.group" scope="page"></jsp:useBean>
<jsp:setProperty name="g" property="group_id" param="group_id"/>
<%
d.deleteGroup(g);
response.sendRedirect("show_group.jsp");
%>

</body>
</html>