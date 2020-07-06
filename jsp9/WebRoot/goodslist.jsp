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
    
    <title>My JSP 'goodslist.jsp' starting page</title>
    
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
        <h2>商品列表</h2>
        <h3>
          <a href="goodsadd.jsp">添加商品</a>
        </h3>
        
        <%
            List list=(List)request.getAttribute("goodslist");
            if(list==null||list.size()==0){
         %>
              <h2>暂无商品信息！</h2>
         <%}else{ %>     
              <table border="1" width="80%" style="text-align: center;">
                <tr>
                  <th>编号</th>
                  <th>商品图片</th>
                  <th>商品名称</th>
                  <th>商品价格</th>
                  <th>购买数量</th>
                  <th>库存数量</th>
                  <th>操作</th>
                </tr>
                <%
                   for(int i=0;i<list.size();i++){
                     Goods g=(Goods)list.get(i);
                 %>
                    <tr>
                       <td><%=g.getGid() %></td>
                       <td>
                          <%if(g.getGpic()!=null){ %>
                            <a href="Download?name=<%=g.getGpic() %>">
                             <img src="upload/<%=g.getGpic() %>" width="50px" height="50px">
                            </a> 
                          <%}else{ %>
                             <img src="images/nopicture.png" width="50px" height="50px">
                          <%} %>
                       </td>
                       <td><%=g.getGname() %></td>
                       <td><%=g.getGprice() %></td>
                       <td><%=g.getBuynum() %></td>
                       <td><%=g.getGnum() %></td>
                       <td>
                         <a href="GoodsDelete?gid=<%=g.getGid() %>"
                            onclick="return window.confirm('是否确定删除？')">删除</a>
                            /
                          <a href="GoodsGoUpdate?gid=<%=g.getGid() %>">修改</a>  
                       </td>
                    </tr>
                 <%} %>
              </table>
         <%} %>
       
     
     </center>
  </body>
</html>
