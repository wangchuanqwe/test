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
		
		//调用dao的查询方法，获取集合
		GoodsDao dao=new GoodsDao();
		List<Goods> list = dao.select();
		
		//把集合存入request对象
		req.setAttribute("goodslist", list);
		//转发到页面
		req.getRequestDispatcher("goodslist.jsp").forward(req, resp);
	}

}
