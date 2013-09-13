package filter;

import java.io.IOException;




import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import bean.psychologist;

/**
 * Servlet Filter implementation class FilterAdmin
 */
@WebFilter("/FilterPsychologist")
public class FilterPsychologist implements Filter {

    /**
     * Default constructor. 
     */
    public FilterPsychologist() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		
		HttpServletResponse resp = (HttpServletResponse) response;
	      HttpServletRequest req = (HttpServletRequest) request;
	      String servletPath = req.getServletPath();
	      HttpSession session = req.getSession();
	      psychologist psychologist=new psychologist();
	      psychologist = (psychologist) session.getAttribute("psychologist");
	      // Allow access to login functionality.
	      if (servletPath.equals("/psychologist/login/login.jsp"))
	      {
	    	 chain.doFilter(req, resp);
	         return;
	      }
	     
	      // All other functionality requires authentication.
	      
	      if (psychologist != null)
	      {
	         // User is logged in.
	    	  resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
	          resp.setHeader("Pragma", "no-cache"); // HTTP 1.0.
	          resp.setDateHeader("Expires", 0);
	         chain.doFilter(req, resp);
	         return;
	      }
	      
	      else
	      resp.sendRedirect("/final/psychologist/login/login.jsp?msg=2");
	   }   
	

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
