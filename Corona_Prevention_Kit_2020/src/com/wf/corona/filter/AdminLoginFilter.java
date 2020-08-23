package com.wf.corona.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


@WebFilter("/login")
public class AdminLoginFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain)
			throws IOException, ServletException {
		System.out.println("login id " + (String)req.getParameter("loginid"));
		System.out.println("password " + (String)req.getParameter("password"));
		
		if("admin".equalsIgnoreCase((String)req.getParameter("loginid")) && "admin".equalsIgnoreCase((String)req.getParameter("password")))
		{
			System.out.println("in filter if");
			filterChain.doFilter(req, res);
			
		
		}
		else
		{
			System.out.println("in filter else");
			req.setAttribute("loginsuccess", false);
			req.setAttribute("msg", "Invalid Credentials");
			req.getRequestDispatcher("AdminUserLogin.jsp").forward(req, res);
			
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
