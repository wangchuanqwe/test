package com.sc.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class Encoding implements Filter {

			String encoding=null;//编码的变量
		
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("初始化字符编码过滤器");
		//获取配置文件中的初始化参数的值，获取的就是UTF-8
			this.encoding=arg0.getInitParameter("encode");
	}


	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		System.out.println("字符编码过滤器设置编码解决中文乱码");
		HttpServletRequest req=(HttpServletRequest)arg0;
		req.setCharacterEncoding(encoding);
		arg2.doFilter(arg0, arg1);//过滤器链继续过滤
	}

@Override
public void destroy() {
	System.out.println("准备销毁字符编码过滤器");

}
}