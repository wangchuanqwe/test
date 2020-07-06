package com.sc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.sc.bean.Goods;
import com.sc.dao.GoodsDao;

@WebServlet("/GoodsUpdate")
public class GoodsUpdate extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1、实例化对象
		SmartUpload su=new SmartUpload();
		//2、初始化
		su.initialize(getServletConfig(), req, resp);
		//3、限制文件类型（选做）
		su.setAllowedFilesList("jpg,gif,png,bmp,icon,jpeg,JPG,GIF,PNG,BMP,ICON,JPEG");
		String gpic=null;
		try {
			//4、上传文件
			su.upload();
			//5、获取到文件对象
			File f=su.getFiles().getFile(0);
			//6、判断用户是否选择了文件上传
			if(!f.isMissing()){//用户选择了文件
				String path=req.getServletContext().getRealPath("upload");
				System.out.println("文件保存的地址："+path);
				//形如：4123543765.jpg
				gpic=System.currentTimeMillis()+"."+f.getFileExt();
				System.out.println("文件名称："+gpic);
				//7、文件另存到服务器的upload文件夹
				f.saveAs(path+"/"+gpic);
			}else{//用户不再新上传图片，还需保留以前图片名称
				gpic=su.getRequest().getParameter("gpic");
			}
			
		} catch (SmartUploadException e) {
			e.printStackTrace();
			System.out.println("文件上传失败");
		}
		
		
		req.setCharacterEncoding("utf-8");
		//获取参数值
		String gidStr=su.getRequest().getParameter("gid");
		String gname=su.getRequest().getParameter("gname");
		String gpriceStr=su.getRequest().getParameter("gprice");
		String gnumStr=su.getRequest().getParameter("gnum");
		//字符串转换其他类型
		int gid=Integer.parseInt(gidStr);
		float gprice=Float.parseFloat(gpriceStr);
		int gnum=Integer.parseInt(gnumStr);
		
		//创建对象
		Goods g=new Goods(gid, gname, gprice, 1, gnum, gpic);
		
		GoodsDao dao=new GoodsDao();
		dao.update(g);
		
		//重定向到列表的servlet
		resp.sendRedirect("GoodsSelect");
		
	}
	
}
