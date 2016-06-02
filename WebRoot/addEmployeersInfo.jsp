<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addEmployeersInfo.jsp' starting page</title>
    
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
    <h2>欢迎进入员工信息添加页面。 </h2><br>
    <form name="form1" method="post" action="AddEmployeersServlet">
      <table width="459" border="1" align="center">
        <tr>
          <td width="179">输入员工ID：</td>
          <td width="205"><label for="inputId"></label>
          <input type="text" name="inputId" id="inputId"></td>
        </tr>
        <tr>
          <td>输入个人ID：</td>
          <td><label for="inputPersonalId"></label>
          <input type="text" name="inputPersonalId" id="inputPersonalId"></td>
        </tr>
        <tr>
          <td>输入姓名：</td>
          <td><label for="inputName"></label>
          <input type="text" name="inputName" id="inputName"></td>
        </tr>
        <tr>
          <td>选择性别：</td>
          <td><label for="selectSex"></label>
            <select name="selectSex" id="selectSex">
              <option value="男">男</option>
              <option value="女">女</option>
          </select></td>
        </tr>
        <tr>
          <td>输入年龄：</td>
          <td><label for="inputAge"></label>
          <input type="text" name="inputAge" id="inputAge"></td>
        </tr>
        <tr>
          <td>选择婚姻状况：</td>
          <td><label for="selectMarriage"></label>
            <select name="selectMarriage" id="selectMarriage">
              <option value="已婚">已婚</option>
              <option value="未婚">未婚</option>
              <option value="离异">离异</option>
          </select></td>
        </tr>
        <tr>
          <td height="52">选择学历及毕业学校：</td>
          <td><label for="selectEducation"></label>
            <select name="selectEducation" id="selectEducation">
              <option value="小学">小学</option>
              <option value="初中">初中</option>
              <option value="高中">高中</option>
              <option value="本科">本科</option>
              <option value="研究生">研究生</option>
              <option value="博士">博士</option>
            </select>
            <label for="inputSchool"></label>
          <input type="text" name="inputSchool" id="inputSchool"></td>
        </tr>
        <tr>
          <td>选择职称：</td>
          <td><label for="selectTitle"></label>
            <select name="selectTitle" id="selectTitle">
              <option value="临时工">临时工</option>
              <option value="职工">职工</option>
              <option value="经理">经理</option>
              <option value="人事部主任">人事部主任</option>
              <option value="老总">老总</option>
          </select></td>
        </tr>
        <tr>
          <td>输入个人住址：</td>
          <td><label for="inputAddress"></label>
          <textarea name="inputAddress" id="inputAddress" cols="45" rows="5"></textarea></td>
        </tr>
        <tr>
          <td>输入手机号码：</td>
          <td><label for="inputPhoneNum"></label>
          <input type="text" name="inputPhoneNum" id="inputPhoneNum"></td>
        </tr>
        <tr>
          <td colspan="2" align="center"><input name="重置" type="reset" value="重置">
               <input type="submit" name="button" id="button" value="提交"></td>
        </tr>
      </table>
      <p>
        <input name="flag" type="hidden" id="flag" value="add_employeer">
      </p>
    </form>
    <br>
    <hr>
    <%=request.getAttribute("massge") %>
  </body>
</html>
