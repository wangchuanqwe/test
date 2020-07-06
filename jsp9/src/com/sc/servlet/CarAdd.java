package com.sc.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sc.bean.Goods;

@WebServlet("/CarAdd")
public class CarAdd extends HttpServlet {
   
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
		//��ȡ����ֵ
		String gidStr=req.getParameter("gid");
		String gname=req.getParameter("gname");
		String gpriceStr=req.getParameter("gprice");
		String buynumStr=req.getParameter("buynum");
		//�ַ���ת����������
		int gid=Integer.parseInt(gidStr);
		float gprice=Float.parseFloat(gpriceStr);
		int buynum=Integer.parseInt(buynumStr);
		
		//��������
		Goods g=new Goods(gid, gname, gprice, buynum, 0, null);
		
		HttpSession session=req.getSession();
	    //�ȿ�session��������list����
		List cars=(List)session.getAttribute("cars");
		int ishas=-1;//-1����û�У�1������
		if(cars==null){//��һ�μ��빺�ﳵ
			cars=new ArrayList();
		}else{//�ڶ��λ����ϼ��빺�ﳵ
			//�����ͬ��Ʒ�ϲ�
			for (int i = 0; i < cars.size(); i++) {
				Goods oldg=(Goods)cars.get(i);
				if(oldg.getGid()==gid){//���ظ���Ʒ
					int num=oldg.getBuynum();
					oldg.setBuynum(num+1);//������һ
					ishas=1;//�޸�Ϊ�е�״̬
					break;//����ѭ��
				}
			}
		}
		if(ishas==-1)
		  cars.add(g);//û�д���Ʒ�ż��뼯��
		
		//���ϴ���Ự����
		session.setAttribute("cars", cars);
		
		//�ض��򵽹��ﳵҳ��
		resp.sendRedirect("cars.jsp");
	}
}
