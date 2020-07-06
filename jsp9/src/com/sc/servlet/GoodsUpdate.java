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
		//1��ʵ��������
		SmartUpload su=new SmartUpload();
		//2����ʼ��
		su.initialize(getServletConfig(), req, resp);
		//3�������ļ����ͣ�ѡ����
		su.setAllowedFilesList("jpg,gif,png,bmp,icon,jpeg,JPG,GIF,PNG,BMP,ICON,JPEG");
		String gpic=null;
		try {
			//4���ϴ��ļ�
			su.upload();
			//5����ȡ���ļ�����
			File f=su.getFiles().getFile(0);
			//6���ж��û��Ƿ�ѡ�����ļ��ϴ�
			if(!f.isMissing()){//�û�ѡ�����ļ�
				String path=req.getServletContext().getRealPath("upload");
				System.out.println("�ļ�����ĵ�ַ��"+path);
				//���磺4123543765.jpg
				gpic=System.currentTimeMillis()+"."+f.getFileExt();
				System.out.println("�ļ����ƣ�"+gpic);
				//7���ļ���浽��������upload�ļ���
				f.saveAs(path+"/"+gpic);
			}else{//�û��������ϴ�ͼƬ�����豣����ǰͼƬ����
				gpic=su.getRequest().getParameter("gpic");
			}
			
		} catch (SmartUploadException e) {
			e.printStackTrace();
			System.out.println("�ļ��ϴ�ʧ��");
		}
		
		
		req.setCharacterEncoding("utf-8");
		//��ȡ����ֵ
		String gidStr=su.getRequest().getParameter("gid");
		String gname=su.getRequest().getParameter("gname");
		String gpriceStr=su.getRequest().getParameter("gprice");
		String gnumStr=su.getRequest().getParameter("gnum");
		//�ַ���ת����������
		int gid=Integer.parseInt(gidStr);
		float gprice=Float.parseFloat(gpriceStr);
		int gnum=Integer.parseInt(gnumStr);
		
		//��������
		Goods g=new Goods(gid, gname, gprice, 1, gnum, gpic);
		
		GoodsDao dao=new GoodsDao();
		dao.update(g);
		
		//�ض����б��servlet
		resp.sendRedirect("GoodsSelect");
		
	}
	
}
