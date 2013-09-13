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
<jsp:useBean id="d" class="database.questionDAO" scope="page"></jsp:useBean>
<jsp:useBean id="q" class="bean.question" scope="page"></jsp:useBean>
<jsp:setProperty name="q" property="question_id" param="question_id"/>
<%
d.deleteQuestion(q);
response.sendRedirect("show_question.jsp");
%>

</body>
</html>