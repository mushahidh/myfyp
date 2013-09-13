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

import bean.admin;

/**
 * Servlet Filter implementation class FilterAdmin
 */
@WebFilter("/AdminFilter")
public class AdminFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AdminFilter() {
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
	      admin admin=new admin();
	      admin = (admin) session.getAttribute("admin");
	      
	     
	      // Allow access to login functionality.
	      if (servletPath.equals("/admin/login/login.jsp"))
	      {
	    	 
	    	 chain.doFilter(req, resp);
	         return;
	      }
	     
	      // All other functionality requires authentication.
	     
	      if (admin != null)
	      {
	         // User is logged in.
	    	 
	    	  resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
	          resp.setHeader("Pragma", "no-cache"); // HTTP 1.0.
	          resp.setDateHeader("Expires", 0);
	         chain.doFilter(req, resp);
	         return;
	      }
	      
	      else
	      {
	    	  
	    	  resp.sendRedirect("/final/admin/login/login.jsp?msg=2");
	    	  return;
	     } 
	      
	   }   
	
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
