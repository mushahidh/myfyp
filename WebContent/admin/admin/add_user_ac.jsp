<%---<%@ page errorPage="addbookerror.jsp" %> --%>
<%@ page import="java.sql.*"  %>
<%@ page import="java.io.*"  %>
 <%@ page import="bean.*" %>
<%@ page import="database.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title></title>
</head>
<body>
<!------------------------------------------------ Creating DataBase object------------------------------------------------------------- -->

<jsp:useBean id="d" class="database.adminDAO" scope="page"></jsp:useBean>

<!------------------------------------------------ Creating user class object to set values of class attributes------------------------------------------------------------- -->

<jsp:useBean id="u" class="bean.admin" scope="page"></jsp:useBean>

<!------------------------------------------------ getting values from forms and setting values of class attributes------------------------------------------------------------- -->
<jsp:setProperty name="u" property="user_screen_name" param="user_screen_name"/>
<jsp:setProperty name="u" property="user_encrypted_password" param="user_password"/>
<jsp:setProperty name="u" property="user_email" param="user_email"/>


<%
InputStream inputStream = null; // input stream of the upload file

// obtains the upload file part in this multipart request
Part filePart = request.getPart("user_profile_picture");
u.setUser_profile_picture(filePart);

System.out.println(filePart);
//-----------------------------------------------------calling function to add user information in databse------------------------------------------------------------------------

d.addUser(u);
//-----------------------------------------------------redirecting page to add_user page-------------------------------------------------------------------------------------------
response.sendRedirect("admin/admin/add_user.jsp?msg=1");
%>

</body>
</html>