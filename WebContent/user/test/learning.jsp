<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="bean.*" %>
<%@ page import="database.*" %>
<%
		
		 int field_id=Integer.parseInt(request.getParameter("field_id"));
		 int value=Integer.parseInt(request.getParameter("value"));
	

		 float total_average=0;
		 float counter_average=0;
		 int counter=0;
	 	 int total_rating=0;
		 int total_user_rating=0;
		 int total_counter_rating=0;
		 int user_counter_rating=0;
		 int total_counter=0;
		 Learning l=new Learning();
		 Learning L=new Learning();
		 learningDAO ld=new learningDAO();
		 L=ld.getLearningUserInfo(field_id);
		 if(L==null)
		 {
			 counter=1;
			 total_counter=1;
			 total_rating=5;
			 total_user_rating=value;
			 total_average=(total_user_rating*100)/total_rating;
			 total_counter_rating=0+5;
			 user_counter_rating=0+value;	 
			 counter_average=(user_counter_rating*100)/total_counter_rating;
			 l.setCounter(counter);
			 l.setCounter_average(counter_average);
			 l.setField_id(field_id);
			 l.setTotal_average(total_average);
			 l.setTotal_counter_rating(total_counter_rating);
			 l.setTotal_rating(total_rating);
			 l.setTotal_user_rating(total_user_rating);
			 l.setUser_counter_rating(user_counter_rating);
			 l.setTotal_counter(total_counter);
			 ld.addUserLearning(l);
		 }
		 else
		 {
			 
			 counter=L.getCounter()+1;
		
			 total_rating=L.getTotal_rating()+5;
			 total_counter=L.getTotal_counter()+1;
			 total_user_rating=L.getTotal_user_rating()+value;
			 user_counter_rating=L.getUser_counter_rating()+value;
			 total_average=(total_user_rating*100)/total_rating;
			 total_counter_rating=L.getTotal_counter_rating()+5;
			 counter_average=(user_counter_rating*100)/total_counter_rating;
			 
			 l.setCounter_average(counter_average);
			 l.setField_id(field_id);
			 l.setTotal_average(total_average);
			 l.setTotal_counter_rating(total_counter_rating);
			 l.setTotal_rating(total_rating);
			 l.setTotal_user_rating(total_user_rating);
			 l.setUser_counter_rating(user_counter_rating);
			 l.setTotal_counter(total_counter);
			 if(counter==10)
			 {
				 ld.addPsychologistLearning(l);
				 counter=0;
				 
			 }
			 l.setCounter(counter);
			 ld.updateUserLearning(l);
		 }
		
		 
		
	%>