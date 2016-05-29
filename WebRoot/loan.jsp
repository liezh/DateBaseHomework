<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'loan.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  <link href="WEB-INF/CSS/loan.css" rel="stylesheet" type="text/css">
  </head>
  
  <body>
  <form name="form1" method="post" action="AssountServlet">
    <div class="loanWindow">
    <p>
    用户名：
      <label for="username"></label>
      <input name="username" type="text" id="username" size="25">
      </p>
    <p>
    密&nbsp;&nbsp;&nbsp;&nbsp;码：
        <input name="password" type="password" id="password" size="25">
      </p>
    <input type="submit" name="registered" id="registered" value="注册">
    <input type="submit" name="login" id="login" value="登录">
    <div>
  </form>
  

  
</body>
</html>
