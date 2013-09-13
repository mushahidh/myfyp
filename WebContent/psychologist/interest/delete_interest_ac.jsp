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
<jsp:useBean id="d" class="database.interestDAO" scope="page"></jsp:useBean>
<jsp:useBean id="i" class="bean.interest" scope="page"></jsp:useBean>
<jsp:setProperty name="i" property="field_id" param="field_id"/>
<%
d.deleteInterest(i);
response.sendRedirect("show_interest.jsp");
%>

</body>
</html>