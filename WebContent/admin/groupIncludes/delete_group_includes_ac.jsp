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
<jsp:useBean id="d" class="database.groupIncludesDAO" scope="page"></jsp:useBean>
<jsp:useBean id="i" class="bean.groupIncludes" scope="page"></jsp:useBean>
<jsp:setProperty name="i" property="group_id" param="group_id"/>
<jsp:setProperty name="i" property="field_idd" param="field_idd"/>
<%
d.deleteGroupIncludes(i);
response.sendRedirect("show_group_includes.jsp");
%>

</body>
</html>