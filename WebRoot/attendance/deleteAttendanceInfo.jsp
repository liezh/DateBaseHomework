<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'deleteWagesInfo.jsp' starting page</title>
    
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
  <h2>欢迎来到员工考勤删除页面。  </h2>
  <form name="form1" method="post" action="QueryAttendanceServlet">
    <table width="80%" border="1" align="center">
      <tr>
        <td>请选择筛选的类型：</td>
        <td><label for="conditions"></label>
          <select name="conditions" id="conditions">
            <option value="emp_id" selected="SELECTED">员工号</option>
        </select></td>
      </tr>
      <tr>
        <td width="35%">请输入条件：</td>
        <td width="65%"><label for="content"></label>
        <input type="text" name="content" id="content"></td>
      </tr>
      <tr>
        <td colspan="2"><p>该员工的考勤记录:</p>
        <%=request.getAttribute("infoStr") %>
        <p>&nbsp;</p></td>
      </tr>
      <tr>
        <td colspan="2" align="center"><input type="reset" name="button" id="button" value="重置">
        <input type="submit" name="button2" id="button2" value="提交"></td>
      </tr>
    </table>
    <p>
      <input name="flag" type="hidden" id="flag" value="delete_attendance">
    </p>
  </form>
  <h2>&nbsp; </h2>
  <form name="form2" method="post" action="DeleteAttendanceServlet">
    <table width="47%" border="1" align="center">
      <tr>
        <td width="52%">请输入要删除的员工考勤记录ID：</td>
        <td width="48%"><label for="inputAtt_id"></label>
        <input type="text" name="inputAtt_id" id="inputAtt_id"></td>
      </tr>
      <tr>
        <td align="center"><input type="reset" name="button3" id="button3" value="重置"></td>
        <td align="center"><input type="submit" name="button4" id="button4" value="提交"></td>
      </tr>
    </table>
    <p>
      <input name="flag2" type="hidden" id="flag2" value="delete_attendance">
    </p>
  </form>
  <%=request.getAttribute("massge") %>
  </body>
</html>
