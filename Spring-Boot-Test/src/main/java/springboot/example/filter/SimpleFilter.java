package springboot.example.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.GenericFilterBean;


import org.springframework.stereotype.Component;

@Component
public class SimpleFilter extends GenericFilterBean {
	
public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterchain) 
      throws IOException, ServletException {
	
	HttpServletRequest req = (HttpServletRequest) request;
	HttpServletResponse res = (HttpServletResponse) response;
      
	 
      System.out.println("Remote Host:"+request.getRemoteHost());
      System.out.println("Remote Address:"+request.getRemoteAddr());
    //   response.
    //  response.
      res.sendRedirect("http://localhost:12002/getdepartments");
      filterchain.doFilter(request, response);
   }




	/*
	 * @Override public void init(FilterConfig filterconfig) throws ServletException
	 * {}
	 */
}