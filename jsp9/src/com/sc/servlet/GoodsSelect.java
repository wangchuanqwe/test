package com.sc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sc.bean.Goods;
import com.sc.dao.GoodsDao;

@WebServlet("/GoodsSelect")
public class GoodsSelect extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//����dao�Ĳ�ѯ��������ȡ����
		GoodsDao dao=new GoodsDao();
		List<Goods> list = dao.select();
		
		//�Ѽ��ϴ���request����
		req.setAttribute("goodslist", list);
		//ת����ҳ��
		req.getRequestDispatcher("goodslist.jsp").forward(req, resp);
	}

}
