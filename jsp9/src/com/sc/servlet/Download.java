package com.sc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

@WebServlet("/Download")
public class Download extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		
		//1��ʵ��������
		SmartUpload su=new SmartUpload();
		//2����ʼ��
		su.initialize(getServletConfig(), req, resp);
		//3��������ʾ�ļ�����Ի���
		su.setContentDisposition(null);
		//4�������ļ�
		try {
			su.downloadFile("upload/"+name);
		} catch (SmartUploadException e) {
			e.printStackTrace();
			System.out.println("�����ļ�ʧ�ܣ�");
		}
	}

}
