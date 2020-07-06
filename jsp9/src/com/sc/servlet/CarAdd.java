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
		//获取参数值
		String gidStr=req.getParameter("gid");
		String gname=req.getParameter("gname");
		String gpriceStr=req.getParameter("gprice");
		String buynumStr=req.getParameter("buynum");
		//字符串转换其他类型
		int gid=Integer.parseInt(gidStr);
		float gprice=Float.parseFloat(gpriceStr);
		int buynum=Integer.parseInt(buynumStr);
		
		//创建对象
		Goods g=new Goods(gid, gname, gprice, buynum, 0, null);
		
		HttpSession session=req.getSession();
	    //先看session里面有无list集合
		List cars=(List)session.getAttribute("cars");
		int ishas=-1;//-1代表没有，1代表有
		if(cars==null){//第一次加入购物车
			cars=new ArrayList();
		}else{//第二次或以上加入购物车
			//解决相同商品合并
			for (int i = 0; i < cars.size(); i++) {
				Goods oldg=(Goods)cars.get(i);
				if(oldg.getGid()==gid){//有重复商品
					int num=oldg.getBuynum();
					oldg.setBuynum(num+1);//数量加一
					ishas=1;//修改为有的状态
					break;//跳出循环
				}
			}
		}
		if(ishas==-1)
		  cars.add(g);//没有此商品才加入集合
		
		//集合存入会话对象
		session.setAttribute("cars", cars);
		
		//重定向到购物车页面
		resp.sendRedirect("cars.jsp");
	}
}
