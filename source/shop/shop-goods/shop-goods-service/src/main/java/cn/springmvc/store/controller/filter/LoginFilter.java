package cn.springmvc.store.controller.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;

import cn.springmvc.store.model.User;

public class LoginFilter implements Filter {
	
    private String[] excludeUrlList;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String excludeUrl = filterConfig.getInitParameter("exclude-url");
		if (StringUtils.hasText(excludeUrl)) {
			excludeUrlList = excludeUrl.split(",");
		}
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		String url = ((HttpServletRequest)request).getRequestURL().toString();
		for (String s : excludeUrlList) {
            if (url.toLowerCase().contains(s.trim().toLowerCase())) {
            	chain.doFilter(request, response);
            	return;
            }
        }
		
		User user = (User)((HttpServletRequest)request).getSession().getAttribute("user");
        if (user == null) {
        	response.setContentType("text/html;charset=UTF-8");
        	((HttpServletResponse)response).sendRedirect(
        	        request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+((HttpServletRequest)request).getContextPath()
        			+ "/login.shtml?backUrl=");
        	return;
		}
        chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
}
