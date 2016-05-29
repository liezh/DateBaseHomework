<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'home.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  <style type="text/css">
  .main {
	position: relative;
	float:left;
	display:inline;
	width:500px;
	height:1000px;
	font-family: 宋体;
	font-size: large;
	line-height: 2em;
	width: 60%;
	height: 100%;
	border:medium;
}
  </style>
  <link href="WEB-INF/CSS/home.css" rel="stylesheet" type="text/css">
  </head>
  
  <body>
     <div class=headType>
      <form name="form1" method="post" action="">
        <h6 align="center">用户名：
          <label for="username"></label>
        <input type="text" name="username" id="username">
                         密码：
        <label for="password"></label>
        <input type="text" name="password" id="password">
        <input type="submit" name="load" id="load" value="登录"></h6></form></div>
  <h1 class="bodyHead">欢迎来到人事管理系统</h1>
   <table width="100%" border="1">
    <tr>
        <td width="16%" align="center">1.<a href="personnelHR.jsp">人事管理</a></td>
        <td width="16%" align="center">2.<a href="#">人事调动</a></td>
        <td width="16%" align="center">3. <a href="#">培训管理</a></td>
        <td width="16%" align="center">4.<a href="#">考勤管理</a></td>
        <td width="16%" align="center">5.<a href="#">职称评定</a></td>
        <td width="16%" align="center">6.<a href="#">用户管理</a></td>
      </tr>
    </table>
  <div class="main">
    <p><strong>人事管理系统功能介绍：</strong></p>
    <p>人事管理：是管理员工的最基本信息的查询。</p>
    <p>人事更改： 是管理员工的最基本信息的增加，修改，删除。</p>
    <p>培训管理：是管理员新工的培训情况以及进度。</p>
    <p>考勤管理：用于管理员工的出勤情况。</p>
    <p>信息统计：对员工工作的评分。 </p>
  </div>
    
    
  <p>&nbsp;</p>
  </body>
</html>
