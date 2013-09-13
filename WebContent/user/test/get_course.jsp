<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="bean.*" %>
<%@ page import="database.*" %>

                              <%
                              				int field=Integer.parseInt(request.getParameter("field"));
                              				fieldDAO FD=new fieldDAO();
                  							courseDAO CD=new courseDAO();
                  							testDAO TD=new testDAO();
                  							ArrayList<includes> EI=new ArrayList<includes>();
                   							EI=TD.retrieveIncludesInfo(field);
                   						
                   							field f=null;
                   							course c=null;
                   							includes in=null;
                   					 %>

<div class="label" >Course Grades</div>
<div class="label" style="margin-left:390px;margin-top:-20px;" >Didn't take</div>

<% int i=0;


int size=EI.size();
String check="null";
while(i<EI.size())
{

	 
	in=(includes)EI.get(i);
	f=FD.getFieldInfo(in.getField_id());
	c=CD.getCourseInfo( in.getCourse_idd());
	check="checkbox";
	check=check+i;

	%>




<input type="hidden" id="course<%=i%>" name="course<%=i%>" value="course<%=i%>"/>

<div id="crsLine">
</div>
<table border="0"   width="100%">
<tr>
<td width="8%">
<span class="block">  <%=c.getCourse_name() %></span>
</td>
<td width="92%">
<div class="<%=i%>" style="display: inline-block; ">
</div>
<span id="1<%=i%>" class="slider_value"></span>
<input type="checkbox" id="<%=check%>">
</td>
</tr>
</table>



<input type="hidden"  name="name<%=i%>" value="<%=c.getCourse_name() %>" />
<input type="hidden"  name="id<%=i%>" value="<%=in.getCourse_idd() %>" />
<input type="hidden"  name="course_size" value="<%=size%>" />


<br/>
<%
i=i+1;
}
%>