
package controller;
import java.io.IOException;
import java.sql.SQLException;

import bean.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.explanation_courseDAO;
@WebServlet("/test_controller")
public class test_controller extends HttpServlet{

	
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
	{
		Explanation(request,response);
		ExplanationCourse(request,response);
		processRequest(request,response);
		
	}

	protected void doPost(HttpServletRequest request,HttpServletResponse response)
	{
		
		Explanation(request,response);
		processRequest(request,response);
		return;
	}
	private void Explanation(HttpServletRequest request,
			HttpServletResponse response) {
		int realistic_total_count=0;
		int investigative_total_count=0;
		int artistic_total_count=0;
		int social_total_count=0;
		int enterprising_total_count=0;
		int conventional_total_count=0;
		int standard=Integer.parseInt(request.getParameter("user_grade"));
		int field_group_id=Integer.parseInt(request.getParameter("user_group"));
		int field_id=Integer.parseInt(request.getParameter("user_field"));
		realistic_total_count=Integer.parseInt(request.getParameter("realistic_total"));
		investigative_total_count=Integer.parseInt(request.getParameter("investigative_total"));
		artistic_total_count=Integer.parseInt(request.getParameter("artistic_total"));
		social_total_count=Integer.parseInt(request.getParameter("social_total"));
		enterprising_total_count=Integer.parseInt(request.getParameter("enterprising_total"));
		conventional_total_count=Integer.parseInt(request.getParameter("conventional_total"));
		
		int realistic=0;
		int investigative=0;
		int artistic=0;
		int social=0;
		int enterprising=0;
		int conventional=0;
		HttpSession session = request.getSession();
	    user user=new user();
	    user = (user) session.getAttribute("user");
	    int user_id=user.getUser_id();
		realistic=Integer.parseInt(request.getParameter("realistic_count"));
		investigative=Integer.parseInt(request.getParameter("investigative_count"));
		artistic=Integer.parseInt(request.getParameter("artistic_count"));
		social=Integer.parseInt(request.getParameter("social_count"));
		enterprising=Integer.parseInt(request.getParameter("enterprising_count"));
		conventional=Integer.parseInt(request.getParameter("conventional_count"));
	
		realistic=(realistic*100)/realistic_total_count;
		investigative=(investigative*100)/investigative_total_count;
		artistic=(artistic*100)/artistic_total_count;
		social=(social*100)/social_total_count;
		enterprising=(enterprising*100)/enterprising_total_count;
		conventional=(conventional*100)/conventional_total_count;
		explanation e=new explanation();
		e.setUser_id(user_id);
		e.setStandard(standard);
		e.setField_group_id(field_group_id);
		e.setField_id(field_id);
		e.setRealistic(realistic);
		e.setInvestigative(investigative);
		e.setArtistic(artistic);
		e.setSocial(social);
		e.setEnterprising(enterprising);
		e.setConventional(conventional);
		explanation_courseDAO d=new explanation_courseDAO();
		try {
			explanation ecg=new explanation();
			ecg=d.getExplanationInfo(user_id);
			if(ecg!=null)
			{
				d.deleteExplanation(user_id);
			}
			d.addExplanation(e);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	private void ExplanationCourse(HttpServletRequest request,
			HttpServletResponse response) {
	
		explanation_course ec=new explanation_course();
		int i=0;
		String param=null;
		String value2=null;
		int value3=0;
		String parame=null;
		String id2=null;
		String id1=null;
		int id=0;
		String value1=null;
		int value=0;
		String size1=null;
		int size=0;
		HttpSession session = request.getSession();
	    user user=new user();
	    user = (user) session.getAttribute("user");
	    int user_id=user.getUser_id();
		size1=request.getParameter("course_size");
		size=Integer.parseInt(size1);
		ec.setUser_id(user_id);
		
	    int[] course_id = new int[size];
	    int[] course_marks = new int[size];
	    int[] course_enjoyment_value = new int[size];
		for(i=0;i<size;i++)
		{
			
			param="course"+i;
			id2="id"+i;
			parame="valueE"+i;
			id1=request.getParameter(id2);
			id=Integer.parseInt(id1);
			value1=request.getParameter(param);
			value=Integer.parseInt(value1);
			value2=request.getParameter(parame);
			value3=Integer.parseInt(value2);
			course_id[i] = id;
			course_marks[i] = value;
			course_enjoyment_value[i] = value3;
			
		}
		ec.setCourse_id(course_id);
		ec.setCourse_marks(course_marks);
		ec.setCourse_enjoyment_value(course_enjoyment_value);
		explanation_courseDAO d=new explanation_courseDAO();
		try {
			explanation_course ecg=new explanation_course();
			ecg=d.getExplanationCourseInfo(user_id);
			if(ecg!=null)
			{
				d.deleteExplanationCourse(user_id);
			}
			d.addExplanationCourse(ec);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	
		
	}
	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) {
		algo a=new algo();
		a.calculator_course(request,response);
		a.calculator_enjoyment(request, response);
		a.calculator_test(request,response);	
		a.recommend(request, response);
		try {
			
			response.sendRedirect("user/test/reccomendation.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
			
		
	}
	
	
	


	
	

}
