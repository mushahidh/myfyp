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
<jsp:useBean id="d" class="database.universityDAO" scope="page"></jsp:useBean>
<jsp:useBean id="u" class="bean.university" scope="page"></jsp:useBean>
<jsp:setProperty name="u" property="uni_id" param="uni_id"/>
<%
d.deleteUniversity(u);
response.sendRedirect("show_university.jsp");
%>

</body>
</html>