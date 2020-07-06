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
     
     <h2>商品添加</h2>
	 <form action="GoodsAdd" method="POST"
	       enctype="multipart/form-data">
	     商品名称：
	     <input type="text" name="gname" ><br><br>
	     商品价格：
	     <input type="text" name="gprice" ><br><br>
	     库存数量：
	     <input type="text" name="gnum" ><br><br> 
	     商品图片：
	     <input type="file" name="upload"><br><br> 
	  <input type="submit" value="提交">
    </form>
   </center> 
  </body>
</html>
