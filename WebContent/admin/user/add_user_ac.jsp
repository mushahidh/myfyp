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

<jsp:useBean id="d" class="database.userDAO" scope="page"></jsp:useBean>

<!------------------------------------------------ Creating user class object to set values of class attributes------------------------------------------------------------- -->

<jsp:useBean id="u" class="bean.user" scope="page"></jsp:useBean>

<!------------------------------------------------ getting values from forms and setting values of class attributes------------------------------------------------------------- -->
<jsp:setProperty name="u" property="user_screen_name" param="user_screen_name"/>
<jsp:setProperty name="u" property="user_encrypted_password" param="user_password"/>
<jsp:setProperty name="u" property="user_first_name" param="user_first_name"/>
<jsp:setProperty name="u" property="user_last_name" param="user_last_name"/>
<jsp:setProperty name="u" property="user_gender" param="user_gender"/>
<jsp:setProperty name="u" property="user_city" param="user_city"/>
<jsp:setProperty name="u" property="user_email" param="user_email"/>
<jsp:setProperty name="u" property="user_cell_number" param="user_cell_number"/>
<jsp:setProperty name="u" property="user_city" param="user_city"/>
<jsp:setProperty name="u" property="user_DOB" param="user_DOB"/>
<%
InputStream inputStream = null; // input stream of the upload file
// obtains the upload file part in this multipart request
Part filePart = request.getPart("user_profile_picture");
u.setUser_profile_picture(filePart);

%>

</body>
</html>