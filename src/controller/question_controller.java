
package controller;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import database.questionDAO;
import bean.question;
@WebServlet("/question_controller")
public class question_controller extends HttpServlet{

	
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
			
			addQuestionRedirect(request,response);
			return;
			
		}
		if(userAction.equals("edit"))
		{
			editQuestionRedirect(request,response);
			return;
			
		}
		else if(userAction.equals("add_question"))
		{
			Add_QuestionRedirect(request,response);
			return;
			
		}
		else
		{
			showQuestionRedirect(request,response);
			return;
		}
	}
	
	
	private void addQuestionRedirect(HttpServletRequest request,
			HttpServletResponse response) {
		try{
			
			
			String question=request.getParameter("question");
			String type=request.getParameter("type");
			question q=new question();
			q.setQuestion(question);
			q.setType(type);
			questionDAO d=new questionDAO();
			try {
				d.addQuestion(q);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("psychologist/question/add_question.jsp?msg=1");
			
		}
		catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	private void Add_QuestionRedirect(HttpServletRequest request,
			HttpServletResponse response) {
		
			
			try {
				String msg=request.getParameter("msg");
				if(msg==null)
				{
					msg="";
				}
				response.sendRedirect("psychologist/question/add_question.jsp?msg="+msg);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	
		 
		
	}
	private void showQuestionRedirect(HttpServletRequest request,
			HttpServletResponse response) {
		
			
			try {
				response.sendRedirect("psychologist/question/show_question.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
}
	
	private void editQuestionRedirect(HttpServletRequest request,
			HttpServletResponse response) {
		try{
			
			int question_id=Integer.parseInt(request.getParameter("question_id"));
			String question=request.getParameter("question");
			String type=request.getParameter("type");
			question q=new question();
			q.setQuestion_id(question_id);
			q.setQuestion(question);
			q.setType(type);
			questionDAO d=new questionDAO();
			try {
				d.updateQuestion(q);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("psychologist/question/show_question.jsp");

		}
		 catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}


	
	

}
