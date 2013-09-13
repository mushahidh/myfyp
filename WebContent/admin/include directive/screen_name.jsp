   <%@ page import="bean.*" %>
  <% 
	             admin admin=new admin();
	             admin=(admin) session.getAttribute("admin");
             %>
            <div class="title"><span class="name"><%=admin.getUser_screen_name() %></span><span class="subtitle">Admin</span></div>
            <span class="icon"><img style="height:70px; width:70px;" class="thumbnail small"  src="../../admin_image?id=<%=admin.getUser_id()%>"></span></a>