<%@page import="com.sc.bean.Goods"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'param1.jsp' starting page</title>
    
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
 <center>

     <h2>商品修改</h2>
	 <form action="GoodsUpdate" method="POST"
	       enctype="multipart/form-data">
	    <!-- 商品编号的隐藏域 -->
	    <input type="hidden" name="gid" value="${requestScope.g.gid }">
	     商品名称：
	     <input type="text" name="gname" value="${g.gname }"><br><br>
	     商品价格：
	     <input type="text" name="gprice" value="${g.gprice }"><br><br>
	     库存数量：
	     <input type="text" name="gnum" value="${g.gnum }"><br><br> 
	     商品图片：
	     <!-- 商品图片的隐藏域 -->
	     <input type="hidden" name="gpic" value="${g.gpic }">
	     <input type="file" name="upload"><br><br> 
	  <input type="submit" value="提交">
    </form>
   </center> 
  </body>
</html>
