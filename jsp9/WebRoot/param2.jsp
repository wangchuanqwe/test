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
    
    <title>My JSP 'param2.jsp' starting page</title>
    
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
  
    姓名: ${param.Name }
    <c:if test="${param.Name=='admin' }">管理员</c:if>
    <br>
    年龄： ${param.Age }
    <c:choose>
    	<c:when test="${param.Age<18 }">
    	你是未成年</c:when>
    	<c:when test="${param.Age<30 }">
    	你是青年</c:when>
    	<c:when test="${param.Age<50 }">
    	你是中年</c:when>
    	<c:otherwise>
    	你是老年
    	</c:otherwise>
    </c:choose>
    <br>
    爱好: ${paramValue.aihao }
    <c:forEach items="${paramValue.aihao }" var="ah">
    	${ah },
    
    </c:forEach>
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  </body>
</html>
