<%@page import="com.sc.bean.Goods"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'main.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    
     
    <%
     //暂时模拟商品数据
      Goods g1=new Goods(2,"费列罗",299.91f,1,40,"2.jpg");
      Goods g2=new Goods(3,"好时",66.65f,1,70,"usertile37.bmp");
      Goods g3=new Goods(4,"老坛酸菜",38f,1,100,"error.gif");
      Goods g4=new Goods(5,"士力架",58.99f,1,100,null);
      List list=new ArrayList();
      list.add(g1);
      list.add(g2);
      list.add(g3);
      list.add(g4);
      pageContext.setAttribute("list", list);
    %>
    
    <center>
       <h1>欢迎来到我的商城</h1>
       <h3>
          <a href="cars.jsp">我的购物车</a>
          <br>
          <a href="GoodsSelect">后台管理-商品列表</a>
       </h3>
       <h2>商品列表</h2>
       <table width="80%" border="1" style="text-align: center;">
          <tr>
             <c:forEach items="${pageScope.list }" var="g" varStatus="st">
                   <td>
                      <img src="images/${st.index+1 }.jpg" width="220px" height="220px">
                      <br> <br>
                      ${g.gname }&nbsp;&nbsp;&nbsp;¥${g.gprice }
                      <br> <br>
                      <a href="CarAdd?gid=${g.gid }&gname=${g.gname }&gprice=${g.gprice }&buynum=${g.buynum}">加入购物车</a>
                   </td>
              </c:forEach>
          </tr>
       </table>
    </center>
    
  </body>
</html>
