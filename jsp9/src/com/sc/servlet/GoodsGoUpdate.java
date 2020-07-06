package com.sc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sc.bean.Goods;
import com.sc.dao.GoodsDao;

@WebServlet("/GoodsGoUpdate")
public class GoodsGoUpdate extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String gidStr=req.getParameter("gid");
		int gid=Integer.parseInt(gidStr);
		
		GoodsDao dao=new GoodsDao();
		Goods g = dao.get(gid);
		
		req.setAttribute("g", g);
		req.getRequestDispatcher("goodsupdate.jsp").forward(req, resp);
	}

}
