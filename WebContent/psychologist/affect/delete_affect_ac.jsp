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
<jsp:useBean id="d" class="database.affectDAO" scope="page"></jsp:useBean>
<jsp:useBean id="a" class="bean.affect" scope="page"></jsp:useBean>
<jsp:setProperty name="a" property="field_id" param="field_id"/>
<jsp:setProperty name="a" property="course_id" param="course_id"/>
<%
d.deleteAffect(a);
response.sendRedirect("show_affect.jsp");
%>

</body>
</html>