   <%@ page import="bean.*" %>
 			 <% 
	             psychologist psychologist=new psychologist();
 				 psychologist=(psychologist) session.getAttribute("psychologist");
             %>
            <div class="title"><span class="name"><%=psychologist.getUser_screen_name() %></span><span class="subtitle">Psychologist</span></div>
            <span class="icon"><img  style="height:70px; width:70px;" class="thumbnail small" src="../../psychologist_image?id=<%=psychologist.getUser_id() %>" ></span></a>