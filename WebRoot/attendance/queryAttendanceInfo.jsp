<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'queryAttendanceInfo.jsp' starting page</title>
    
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
  <h2>欢迎进入员工考勤记录查询页面。
  </h2>
  <form name="form1" method="post" action="QueryAttendanceServlet">
    <table width="359" border="1" align="center">
      <tr>
        <td width="139">请选择查询条件：</td>
        <td width="204"><label for="conditions">
          <select name="conditions" id="conditions">
            <option value="att_id">考勤ID</option>
            <option value="emp_id">员工ID</option>
          </select>
        </label></td>
      </tr>
      <tr>
        <td>请输入查询内容：</td>
        <td><input type="text" name="content" id="content"></td>
      </tr>
      <tr>
        <td colspan="2" align="center"><input type="submit" name="button" id="button" value="提交"></td>
      </tr>
    </table>
    <p>
      <input name="flag" type="hidden" id="flag" value="query_attendance">
    </p>
  </form>
  <p>&nbsp;</p>
  <hr>
  <%=request.getAttribute("infoStr") %>
  </body>
</html>
