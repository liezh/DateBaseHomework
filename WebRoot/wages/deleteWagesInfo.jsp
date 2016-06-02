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
  <h2>欢迎进入员工工资删除页面。</h2>
  <form name="form1" method="post" action="QueryWagesInfo">
    <table width="500" border="1" align="center">
      <tr>
        <td>请选择筛选的类型：</td>
        <td><label for="conditions"></label>
          <select name="conditions" id="conditions">
            <option value="emp_id" selected="selected">员工号</option>
</select></td>
      </tr>
      <tr>
        <td width="212">请输入条件：</td>
        <td width="272"><label for="content"></label>
        <input type="text" name="content" id="content"></td>
      </tr>
      <tr>
        <td height="163" colspan="2" valign="top">&nbsp;<%=request.getAttribute("infoStr") %></td>
      </tr>
      <tr>
        <td align="center"><input type="reset" name="button" id="button" value="重置"></td>
        <td align="center"><input type="submit" name="button2" id="button2" value="提交"></td>
      </tr>
    </table>
    <p>
      <input name="flag" type="hidden" id="flag" value="delete_wage">
    </p>
  </form>
  <form name="form2" method="post" action="DeleteWagesInfo">
    <table width="322" border="1" align="center">
      <tr>
        <td width="178">请输入要删除的工资Id:</td>
        <td width="128"><label for="inputWage_id2"></label>
        <input type="text" name="inputWage_id2" id="inputWage_id2"></td>
      </tr>
      <tr>
        <td colspan="2" align="center"><input type="submit" name="button4" id="button4" value="提交"></td>
      </tr>
    </table>
    <p>
      <input name="flag2" type="hidden" id="flag2" value="delete_wage">
    </p>
    </form>
    <hr>
    <%=request.getAttribute("massge") %>
  </body>
</html>
