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
<jsp:useBean id="d" class="database.eligibilityDAO" scope="page"></jsp:useBean>
<jsp:useBean id="e" class="bean.eligibility" scope="page"></jsp:useBean>
<jsp:setProperty name="e" property="field_id" param="field_id"/>
<jsp:setProperty name="e" property="required_idd" param="required_idd"/>
<%
d.deleteEligibility(e);
response.sendRedirect("show_eligibility.jsp");
%>

</body>
</html>