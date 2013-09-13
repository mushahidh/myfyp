<%
session.setAttribute("user",null);
session.invalidate();
response.sendRedirect("../login/login.jsp?msg=0");

%>