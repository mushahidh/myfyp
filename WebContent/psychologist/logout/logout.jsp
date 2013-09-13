<%
session.setAttribute("userId",null);
session.invalidate();
response.sendRedirect("../login/login.jsp?msg=0");

%>