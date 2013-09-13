package bean;
import database.*;
import java.util.*;
import java.sql.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class algo {
	
	
	public void calculator_course(HttpServletRequest request,
			HttpServletResponse response) {
		int i=0;
		String param=null;
		String id2=null;
		String id1=null;
		int id=0;
		String value1=null;
		int value=0;
		int weight=0;
		int field_id=0;
		int result=0;
		String size1=null;
		int size=0;
		HttpSession session = request.getSession();
	    user user=new user();
	    user = (user) session.getAttribute("user");
	    int user_id=user.getUser_id();
		weight w=new weight();
		size1=request.getParameter("course_size");
		size=Integer.parseInt(size1);
		for(i=0;i<size;i++)
		{
			
			param="course"+i;
			id2="id"+i;
			id1=request.getParameter(id2);
			id=Integer.parseInt(id1);
			value1=request.getParameter(param);
			value=Integer.parseInt(value1);
			weightDAO WD=new weightDAO();
            affect a=null;
            ArrayList<affect> AI=new ArrayList<affect>();
            AI=WD.retrieveAffectInfo(id);
            for(int j=0;j<AI.size();j++)
            {
                         	a=(affect)AI.get(j);
                         	field_id=a.getField_id();
                         	result=WD.getWeightResult(field_id);
                         	if(result==0)
                         	{
                         			w.setField_id(field_id);
                         			w.setUser_id(user_id);
                         			w.setWeight(value);
                         			try {
										WD.addweight(w);
									} catch (SQLException e) {
										
										e.printStackTrace();
									}
                         	}
                         	else
                         	{
                         		w=WD.getWeightInfo(field_id);
                         		weight=value;
                         		weight=weight+w.getWeight();
                         		w.setField_id(field_id);
                     			w.setUser_id(user_id);
                     			
                     			w.setWeight(weight);
                     			try {
									WD.updateWeight(w);
								} catch (SQLException e) {
									
									e.printStackTrace();
								}
                         		
                         		
                         	}
                         	
            }
           
           
			
		}
}
	//-----------------------------------------------------------Enjoyment Calculator-----------------------------------------------------
	public void calculator_enjoyment(HttpServletRequest request,
			HttpServletResponse response) {
		int i=0;
		
		
		String param=null;
		String id2=null;
		String id1=null;
		int id=0;
		String value1=null;
		int value=0;
		int weight=0;
		int field_id=0;
		int result=0;
		HttpSession session = request.getSession();
	    user user=new user();
	    user = (user) session.getAttribute("user");
	    int user_id=user.getUser_id();
		weight w=new weight();
		String size_enjoyment=request.getParameter("enjoyment_size");
		int enjoyment_course=Integer.parseInt(size_enjoyment);
		for(i=0;i<enjoyment_course;i++)
		{
			
			param="valueE"+i;
			id2="idE"+i;
			id1=request.getParameter(id2);
			id=Integer.parseInt(id1);
			value1=request.getParameter(param);
			value=Integer.parseInt(value1);
			weightDAO WD=new weightDAO();
            affect a=null;
            ArrayList<affect> AI=new ArrayList<affect>();
            AI=WD.retrieveAffectInfo(id);
            
            for(int j=0;j<AI.size();j++)
            {
                         	a=(affect)AI.get(j);
                         	field_id=a.getField_id();
                         	result=WD.getWeightResult(field_id);
                         	if(result==0)
                         	{
                         			w.setField_id(field_id);
                         			w.setUser_id(user_id);
                         			w.setWeight(value);
                         			try {
										WD.addweight(w);
									} catch (SQLException e) {
										
										e.printStackTrace();
									}
                         	}
                         	else
                         	{
                         		w=WD.getWeightInfo(field_id);
                         		weight=value;
                         		weight=weight+w.getWeight();
                         		w.setField_id(field_id);
                     			w.setUser_id(user_id);
                     			
                     			w.setWeight(weight);
                     			try {
									WD.updateWeight(w);
								} catch (SQLException e) {
									
									e.printStackTrace();
								}
                         		
                         		
                         	}
                         	
            }
           
           
			
		}
}

	//-----------------------------------------------------------Enjoyment Calculator Ends -----------------------------------------------
	public void calculator_test(HttpServletRequest request,
			HttpServletResponse response) {
		
		int realistic_total_count=0;
		int investigative_total_count=0;
		int artistic_total_count=0;
		int social_total_count=0;
		int enterprising_total_count=0;
		int conventional_total_count=0;
		int field_id=0;
		int result=0;
		int weight=0;
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
		UserInterest UI=new UserInterest();
		UI.setUser_id(user_id);
		UI.setRealistic(realistic);
		UI.setInvestigative(investigative);
		UI.setArtistic(artistic);
		UI.setSocial(social);
		UI.setEnterprising(enterprising);
		UI.setConventional(conventional);
		weight wd=new weight();
		weight wi=new weight();
		weight wu=new weight();
		weightDAO WD=new weightDAO();
		ArrayList<weight> WI=new ArrayList<weight>();
		WI=WD.retrieveInterestInfo(UI);
		
		 for(int j=0;j<WI.size();j++)
         {
                      	wi=(weight)WI.get(j);
                      	field_id=wi.getField_id();
                      	weight=wi.getWeight();
                      	result=WD.getWeightResult(field_id);
                      	if(result==0)
                      	{
                      		
                      		wu.setField_id(field_id);
                 			wu.setUser_id(user_id);
                 			wu.setWeight(weight);
                      			try {
										WD.addweight(wu);
									} catch (SQLException e) {
										
										e.printStackTrace();
									}
                      	}
                      	else
                      	{
                      		wd=WD.getWeightInfo(field_id);
                      		weight=weight+wd.getWeight();
                      		wu.setField_id(field_id);
                  			wu.setUser_id(user_id);
                  			wu.setWeight(weight);
                  			try {
									WD.updateWeight(wu);
								} catch (SQLException e) {
									
									e.printStackTrace();
								}
                      		
                      		
                      	}
                      	
         }
		
		
}
	//------------------------------------------------------------Recommend----------------------------------------------------------
	public void recommend(HttpServletRequest request,
			HttpServletResponse response) {
		int count=5;
		int i=0;
		HttpSession session = request.getSession();
	    user user=new user();
	    user = (user) session.getAttribute("user");
	    int user_id=user.getUser_id();
		weightDAO WD=new weightDAO();
		int standard=Integer.parseInt(request.getParameter("user_grade"));
		ArrayList<weight> WI=new  ArrayList<weight>();
		WI=WD. retrieveWeightInfo(user_id,standard);
		int size=WI.size();
		weight w=new weight();
		int field_id=0;
		int weight=-20000;
		int max_weight=0;
		int index=0;
		weight wd=new weight();
		
		try {
			WD.deleteReccomendation(user_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(size>0)
		{
			max_weight=-20000;
			for(i=0;i<WI.size();i++)
			{
				w=(weight)WI.get(i);
				if(w.getWeight()>max_weight)
				{
					field_id=w.getField_id();
					
				
					weight=w.getWeight();
					user_id=w.getUser_id();
					wd.setField_id(field_id);
					wd.setWeight(max_weight);
					wd.setUser_id(user_id);
					max_weight=w.getWeight();
					index=i;
				}
				
			}
			
			count=count-1;
			System.out.println("------------------Recommendation-----------------");
			System.out.println("field"+field_id);
			System.out.println("weight"+weight);
			System.out.println("user"+user_id);
			System.out.println("count"+count);
			
			
			try {
			 	WD.addRecommendation(wd);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			WI.remove(index);
			size=size-1;
			if(count<1)
			{
				
				break;
			}
		
		}
		try {
			WD.deleteWeight1(wd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
}
	//-----------------------------------------------------------Test Calculator Ends -----------------------------------------------
}
