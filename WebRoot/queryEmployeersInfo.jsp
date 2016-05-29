<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.liezh.Dao.ItemsDAO" %>
<%@ page import="com.liezh.entity.Items" %>
<%@ page import="util.DBHelper" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="dis" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <link href="WEB-INF/CSS/home.css" rel="stylesheet" type="text/css">
  </head>
  
  <body>
    <h4>欢迎进入员工信息查询页面.</h4>
  <table width="100%" border="1">
    <tr>
        <td width="16%" align="center">1.<a href="#">人事管理</a></td>
        <td width="16%" align="center">2.<a href="#">人事调动</a></td>
        <td width="16%" align="center">3. <a href="#">培训管理</a></td>
        <td width="16%" align="center">4.<a href="#">考勤管理</a></td>
        <td width="16%" align="center">5.<a href="#">职称评定</a></td>
        <td width="16%" align="center">6.<a href="#">用户管理</a></td>
      </tr>
    </table>
    <p>&nbsp;</p>
  <div>
  
  
    <form name="form1" method="post" action="SearchEmployeersInfo">
        <table width="311" border="1">
          <tr>
            <td width="132">请选择查询条件：</td>
            <td width="163"><label for="conditions"></label>
              <select name="conditions" id="conditions">
                <option value="id">员工号</option>
                <option value="name">姓名</option>
                <option value="sex">性别</option>
                <option value="marriage">婚姻状况</option>
                <option value="education">学历</option>
                <option value="title">职位</option>
            </select></td>
          </tr>
          <tr>
            <td>请输入查询内容：</td>
            <td><label for="content"></label>
            <input type="text" name="content" id="content"></td>
          </tr>
          <tr>
            <td colspan="2" align="center"><input type="submit" name="button" id="button" value="提交"></td>
          </tr>
        </table>
      </form>
    </div>
    <hr>
    <%=request.getAttribute("infoStr") %>
  </body>
</html>
