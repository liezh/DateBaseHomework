<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addWagesInfo.jsp' starting page</title>
    
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
  <h2>欢迎进入员工工资表添加页面。  </h2>
  <form name="form1" method="post" action="AddWagesInfo">
    <table width="422" border="1" align="center">
      <tr>
        <td width="194">请输入员工工资ID：</td>
        <td width="212"><label for="inputWage_id"></label>
        <input type="text" name="inputWage_id" id="inputWage_id"></td>
      </tr>
      <tr>
        <td>请输入员工ID：</td>
        <td><label for="inputEmp_id"></label>
        <input type="text" name="inputEmp_id" id="inputEmp_id"></td>
      </tr>
      <tr>
        <td>请输入考勤ID：</td>
        <td><label for="inputAtt_id"></label>
        <input type="text" name="inputAtt_id" id="inputAtt_id"></td>
      </tr>
      <tr>
        <td>请输入基本工资：</td>
        <td><label for="inputBasic_wage"></label>
        <input type="text" name="inputBasic_wage" id="inputBasic_wage"></td>
      </tr>
      <tr>
        <td>请输入加班工资：</td>
        <td><label for="inputOT_wage"></label>
        <input type="text" name="inputOT_wage" id="inputOT_wage"></td>
      </tr>
      <tr>
        <td>请输入保险扣除金额：</td>
        <td><label for="inputInsurance"></label>
        <input type="text" name="inputInsurance" id="inputInsurance"></td>
      </tr>
      <tr>
        <td align="center"><input type="reset" name="button" id="button" value="重置"></td>
        <td align="center"><input type="submit" name="button2" id="button2" value="提交"></td>
      </tr>
    </table>
    <p>
      <input name="flag" type="hidden" id="flag" value="add_wage">
    </p>
  </form>
  <h2>&nbsp; </h2>
  <%=request.getAttribute("massge") %>
  </body>
</html>
