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
<jsp:useBean id="d" class="database.offersDAO" scope="page"></jsp:useBean>
<jsp:useBean id="o" class="bean.offers" scope="page"></jsp:useBean>
<jsp:setProperty name="o" property="uni_id" param="uni_id"/>
<jsp:setProperty name="o" property="field_idd" param="field_id"/>
<%
d.deleteOffers(o);
response.sendRedirect("show_offers.jsp");
%>

</body>
</html>