<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
   <table border="1">
     
	     <%
	      //使用request请求对象的setCharacterEncoding设置utf-8的编码，解决中文乱码问题
	       request.setCharacterEncoding("UTf-8");
	        //通过request请求对象的getParameter方法获取参数的值，需要提供参数名称
	       String s=request.getParameter("username");
	       if(s==null){
	          out.println("<a href='login.jsp'>请先登录</a>");
	       }else{
		       for(int i=0;i<5;i++){
		          out.println("<tr>");
		            out.println("<td>");
		               out.println("你好，"+s+"!");
		            out.println("</td>");
		          out.println("</tr>");
		       }
	       }
	      %>
	     
   </table>
  </body>
</html>
