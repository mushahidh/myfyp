<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="bean.*" %>
<%@ page import="database.*" %>
 



 <%
 											int id=Integer.parseInt(request.getParameter("field"));
 											fieldDAO FD=new fieldDAO();
                  							courseDAO CD=new courseDAO();
                  							testDAO TD=new testDAO();
                  							ArrayList<includes> EI=new ArrayList<includes>();
                   							EI=TD.retrieveIncludesInfo(id);
                   							field f=null;
                   							course c=null;
                   							includes in=null;
                   					 %>

<div class="label" >Course Enjoyment</div>
<div class="label" style="margin-left:425px;margin-top:-20px;" >Enjoyment level</div>

<div class="nts" style="display: inline-block; ">
										</div>
										<span id="nts1" class="slider_value"></span>
                                    
<% int j=0;


int size=EI.size();

while(j<EI.size())
{

	 
	in=(includes)EI.get(j);
	f=FD.getFieldInfo(in.getField_id());
	c=CD.getCourseInfo( in.getCourse_idd());


	%>



<div id="crsLine">
</div>

<input type="hidden" id="hiddenE<%=j%>" name="valueE<%=j%>" value="E<%=j%>"/>


<div id="crsLine">
</div>
<table border="0"   width="100%">
<tr>
<td width="8%">
<span class="block"><%=c.getCourse_name() %>:</span>
</td>
<td width="92%">
<div class="E<%=j%>" style="display: inline-block; ">
<div class="character" style="display:inline-block;">
</div>
</div>
</td>
</tr>
</table>



<input type="hidden"  name="nameE<%=j%>" value="<%=c.getCourse_name() %>"/>
<input type="hidden"  name="idE<%=j%>" value="<%=in.getCourse_idd() %>" />


<br/>
<%
j=j+1;

}
%>
<input type="hidden"  name="enjoyment_size" value="<%=EI.size()%>" />



