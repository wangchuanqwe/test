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

			String encoding=null;//����ı���
		
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("��ʼ���ַ����������");
		//��ȡ�����ļ��еĳ�ʼ��������ֵ����ȡ�ľ���UTF-8
			this.encoding=arg0.getInitParameter("encode");
	}


	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		System.out.println("�ַ�������������ñ�������������");
		HttpServletRequest req=(HttpServletRequest)arg0;
		req.setCharacterEncoding(encoding);
		arg2.doFilter(arg0, arg1);//����������������
	}

@Override
public void destroy() {
	System.out.println("׼�������ַ����������");

}
}