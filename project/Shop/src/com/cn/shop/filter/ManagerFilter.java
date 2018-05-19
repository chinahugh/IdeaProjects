package com.cn.shop.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cn.shop.common.Constants;
import com.cn.shop.model.Administrator;
import com.cn.shop.model.User;

public class ManagerFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) request ;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		
		String contextPath = req.getContentType();
		
		/*if( session.isNew() || session.getAttribute(Constants.SESSION_USER) == null )
		{
			User user = (User)session.getAttribute(Constants.SESSION_USER);
			
			if( !( user instanceof Administrator ))
			{

				
				res.sendRedirect("http://localhost:8080/Shop/login.jsp");
				
				System.out.println(contextPath+"/login.jsp" );
				
				return;
			}
		}*/
		
		if( session.isNew() || session.getAttribute(Constants.SESSION_USER) == null )
		{
						
				res.sendRedirect("http://localhost:8080/Shop/login.jsp");
				
				System.out.println(contextPath+"/login.jsp" );
				
				return;
			
		}
		
		
		else if( session.getAttribute(Constants.SESSION_USER) != null)
		{
			
			User user = (User)session.getAttribute(Constants.SESSION_USER);
			
			//System.out.println( ( user instanceof Administrator ) );
			
			//if( ( user instanceof Administrator ))
			
			System.out.println( user.getName() );
			
			//??????bug??? ?????????????? 2014??8??18
			
			//if( (user.equals("throne212")))
			
			//??????bug??? ?????????????? 2014??8??30, ????getName ???
			
			//if( (user.getName().equals("throne212")) == false  )
			
			//2014.9.1  ?????????bug  ??????? Administrator,??????
			
			if ( ( user instanceof Administrator ) == false )			
			{

				
				res.sendRedirect("http://localhost:8080/Shop/login.jsp");
				
				System.out.println(contextPath+"/login.jsp" );
				
				return;
			}
			
		}
		
		
				
		
		chain.doFilter(request, response);
		
		
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
