package com.info.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter {
    String encoing=null;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chian) throws IOException, ServletException {
			
			response.setCharacterEncoding(encoing);
			request.setCharacterEncoding(encoing);
			chian.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		//System.out.println("init.......");
		this.encoing=config.getInitParameter("encode");

	}

}
