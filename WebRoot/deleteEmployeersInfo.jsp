<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'deleteEmployeersInfo.jsp' starting page</title>
    
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
    <h2>欢迎进入员工基本信息删除页面</h2> <br>
    <form name="form1" method="post" action="SearchEmployeersInfo">
    
    
      <table width="80%" border="1" align="center">
        <tr>
          <td width="187">请选择筛选的类型：</td>
          <td width="166"><label for="conditions"></label>
            <select name="conditions" id="conditions">
            <option value="id" selected="selected">员工号</option>
                <option value="name">姓名</option>
                <option value="sex">性别</option>
                <option value="marriage">婚姻状况</option>
                <option value="education">学历</option>
                <option value="title">职位</option>
          </select></td>
        </tr>
        <tr>
          <td>请输入筛选的条件：</td>
          <td><label for="content"></label>
          <input type="text" name="content" id="content"></td>
        </tr>
        <tr>
          <td height="163" colspan="2" valign="top"><p>下列是符合的信息：</p>
          <%=request.getAttribute("infoStr") %>
          </td>
        </tr>
        <tr>
          <td height="42" colspan="2" align="center" valign="middle"><input type="reset" name="button4" id="button4" value="重置">            <input type="submit" name="button3" id="button3" value="提交"></td>
        </tr>
      </table>
      <input name="flag" type="hidden" id="flag" value="delete_employeer">
    </form>
    <form name="form2" method="post" action="deleteEmployeersServlet">
      <table width="400" border="1" align="center">
        <tr>
          <td>请输入要删除的记录的Id:</td>
          <td><label for="inputId"></label>
          <input type="text" name="inputId" id="inputId"></td>
        </tr>
        <tr>
          <td align="center"><input type="reset" name="button" id="button" value="重置"></td>
          <td align="center"><input type="submit" name="button2" id="button2" value="提交"></td>
        </tr>
      </table>
      <p>
        <input name="flag2" type="hidden" id="flag2" value="delete_employeer">
      </p>
    </form>
    <p>&nbsp;</p>
    <hr>
    <%=request.getAttribute("massge") %>
  </body>
</html>
