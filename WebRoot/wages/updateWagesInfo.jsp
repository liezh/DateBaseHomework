<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'updateWagesInfo.jsp' starting page</title>
    
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
  <h2>欢迎进入员工工资修改页面。</h2>
  <form name="form1" method="post" action="UpdateWagesInfo">
    <table width="438" border="1" align="center">
      <tr>
        <td width="180">请输入要修改的员工工资的记录ID：</td>
        <td width="242"><label for="inputWage_id"></label>
          <input type="text" name="inputWage_id" id="inputWage_id"></td>
      </tr>
      <tr>
        <td colspan="2" align="center"><strong>请输入需要修改的内容（不修改则不填写）</strong></td>
      </tr>
      <tr>
        <td>输入员工ID：</td>
        <td><label for="inputEmp_id"></label>
          <input type="text" name="inputEmp_id" id="inputEmp_id"></td>
      </tr>
      <tr>
        <td>输入考勤ID：</td>
        <td><label for="inputAtt_id"></label>
        <input type="text" name="inputAtt_id" id="inputAtt_id"></td>
      </tr>
      <tr>
        <td>输入基本工资：</td>
        <td><label for="inputBasic_wage"></label>
        <input type="text" name="inputBasic_wage" id="inputBasic_wage"></td>
      </tr>
      <tr>
        <td>输入加班工资：</td>
        <td><label for="inputOT_wage"></label>
        <input type="text" name="inputOT_wage" id="inputOT_wage"></td>
      </tr>
      <tr>
        <td>输入保险金：</td>
        <td><label for="inputInsurance"></label>
        <input type="text" name="inputInsurance" id="inputInsurance"></td>
      </tr>
      <tr>
        <td align="center"><input type="reset" name="button" id="button" value="重置"></td>
        <td align="center"><input type="submit" name="button2" id="button2" value="提交"></td>
      </tr>
    </table>
    <p>
      <input name="flag" type="hidden" id="flag" value="update_wage">
    </p>
  </form>
  <h2>&nbsp; </h2>
  <hr>
  <%=request.getAttribute("massge") %>
  
  </body>
</html>
