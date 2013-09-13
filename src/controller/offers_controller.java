
package controller;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import database.offersDAO;
import bean.offers;
@WebServlet("/offers_controller")
public class offers_controller extends HttpServlet{

	
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
	{
		processRequest(request,response);
		
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
	{
		processRequest(request,response);
	}
	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) {
		
		
		String userAction=request.getParameter("user_action");
		if(userAction.equals("add"))
		{
			
			addUniversityRedirect(request,response);
			return;
			
		}
		if(userAction.equals("edit"))
		{
			editUniversityRedirect(request,response);
			return;
			
		}
		else if(userAction.equals("add_offer"))
		{
			Add_OfferRedirect(request,response);
			return;
			
		}
		else
		{
			showOfferRedirect(request,response);
			return;
		}
	}
	
	
	private void addUniversityRedirect(HttpServletRequest request,
			HttpServletResponse response) {
		try{
			
		
			String[] field=request.getParameterValues("field_id");
			int[] field_id = new int[field.length];
			    for (int i=0; i < field.length; i++) {
			        field_id[i] = Integer.parseInt(field[i]);
			    }
			
			int uni_id=Integer.parseInt(request.getParameter("uni_id"));;
			int duration=Integer.parseInt(request.getParameter("duration"));;
			int hssc_criteria=Integer.parseInt(request.getParameter("hssc_criteria"));;
			int ssc_criteria=Integer.parseInt(request.getParameter("ssc_criteria"));;
			offers o=new offers();
			o.setField_id(field_id);
			o.setDuration(duration);
			o.setUni_id(uni_id);
			o.setHssc_criteria(hssc_criteria);
			o.setSsc_criteria(ssc_criteria);
			offersDAO d=new offersDAO();
			try {
				d.addOffers(o);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("admin/offers/add_offers.jsp?msg=1");
			
		}
		catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	private void Add_OfferRedirect(HttpServletRequest request,
			HttpServletResponse response) {
		
			
			try {
				String msg=request.getParameter("msg");
				if(msg==null)
				{
					msg="";
				}
				response.sendRedirect("admin/offers/add_offers.jsp?msg="+msg);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	
		 
		
	}
	private void showOfferRedirect(HttpServletRequest request,
			HttpServletResponse response) {
		
			
			try {
				response.sendRedirect("admin/offers/show_offers.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
}
	
	private void editUniversityRedirect(HttpServletRequest request,
			HttpServletResponse response) {
		try{
			
		
			
			int field_id=Integer.parseInt(request.getParameter("field_id"));;
			int uni_id=Integer.parseInt(request.getParameter("uni_id"));;
			int duration=Integer.parseInt(request.getParameter("duration"));;
			int hssc_criteria=Integer.parseInt(request.getParameter("hssc_criteria"));;
			int ssc_criteria=Integer.parseInt(request.getParameter("ssc_criteria"));;
			offers o=new offers();
			o.setField_idd(field_id);
			o.setDuration(duration);
			o.setUni_id(uni_id);
			o.setHssc_criteria(hssc_criteria);
			o.setSsc_criteria(ssc_criteria);
			offersDAO d=new offersDAO();
			try {
				d.updateOffers(o);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("admin/offers/show_offers.jsp");
			
		}
		 catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}


	
	

}
