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
<jsp:useBean id="d" class="database.fieldDAO" scope="page"></jsp:useBean>
<jsp:useBean id="f" class="bean.field" scope="page"></jsp:useBean>
<jsp:setProperty name="f" property="field_id" param="field_id"/>
<%
d.deleteField(f);
response.sendRedirect("show_field.jsp");
%>

</body>
</html>