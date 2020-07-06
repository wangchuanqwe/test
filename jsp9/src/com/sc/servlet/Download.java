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
		
		//1、实例化对象
		SmartUpload su=new SmartUpload();
		//2、初始化
		su.initialize(getServletConfig(), req, resp);
		//3、设置显示文件保存对话框
		su.setContentDisposition(null);
		//4、下载文件
		try {
			su.downloadFile("upload/"+name);
		} catch (SmartUploadException e) {
			e.printStackTrace();
			System.out.println("下载文件失败！");
		}
	}

}
