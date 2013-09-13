   <%@ page import="bean.*" %>
  <% 
  user user1=new user();
  user1 = (user) session.getAttribute("user");
             %>
            <span class="name" style="color:white;"><%=user1.getUser_screen_name() %></span>
           