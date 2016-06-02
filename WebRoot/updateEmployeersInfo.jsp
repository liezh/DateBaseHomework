<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'updateEmployeersInfo.jsp' starting page</title>
    
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
    <h2>欢迎进入员工基本信息修改页面</h2>
    
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
  <form name="form1" method="post" action="UpdateEmployeersServlet">
      <table width="425" border="1" align="center">
        <tr>
          <td width="106">请输入需要修改的员工ID：</td>
          <td width="247"><label for="inputId"></label>
          <input name="inputId" type="text" id="inputId" size="30"></td>
        </tr>
        <tr>
          <td colspan="2" align="center"><strong>请输入需要修改的内容（不修改则不填写）</strong></td>
        </tr>
        <tr>
          <td align="left">输入个人ID：</td>
          <td align="left"><label for="inputPersonalId"></label>
          <input name="inputPersonalId" type="text" id="inputPersonalId" size="30"></td>
        </tr>
        <tr>
          <td align="left">输入姓名：</td>
          <td align="left"><label for="inputName"></label>
          <input name="inputName" type="text" id="inputName" size="30"></td>
        </tr>
        <tr>
          <td align="left">输入年龄：</td>
          <td align="left"><label for="inputAge"></label>
          <input name="inputAge" type="text" id="inputAge" size="30"></td>
        </tr>
        <tr>
          <td align="left">选择性别：</td>
          <td align="left"><label for="selectSex"></label>
            <select name="selectSex" id="selectSex" >
              <option value="男">男</option>
              <option value="女">女</option>
              <option selected="selected" value="">不修改</option>
          </select></td>
        </tr>
        <tr>
          <td align="left">选择婚姻状况：</td>
          <td align="left"><label for="selectMarriage"></label>
            <select name="selectMarriage" id="selectMarriage">
              <option value="已婚">已婚</option>
              <option value="未婚">未婚</option>
              <option value="离异">离异</option>
              <option selected="selected" value="">不修改</option>
          </select></td>
        </tr>
        <tr>
          <td align="left">选择学历：</td>
          <td align="left"><label for="selectEducation"></label>
            <select name="selectEducation" id="selectEducation">
              <option value="小学">小学</option>
              <option value="初中">初中</option>
              <option value="高中">高中</option>
              <option value="本科" >本科</option>
              <option value="研究生">研究生</option>
              <option value="博士">博士</option>
              <option selected="selected" value="">不修改</option>
          </select></td>
        </tr>
        <tr>
          <td align="left">输入毕业学校：</td>
          <td align="left"><label for="inputSchool"></label>
          <input name="inputSchool" type="text" id="inputSchool" size="30"></td>
        </tr>
        <tr>
          <td align="left">选择职称：</td>
          <td align="left"><label for="selectTitle"></label>
            <select name="selectTitle" id="selectTitle">
            <option value="临时工">临时工</option>
              <option value="职工" >职工</option>
              <option value="经理">经理</option>
              <option value="人事部主任">人事部主任</option>
              <option value="老总">老总</option>
              <option selected="selected" value="">不修改</option>
          </select></td>
        </tr>
        <tr>
          <td align="left">输入个人住址：</td>
          <td align="left"><label for="inputAddress"></label>
          <textarea name="inputAddress" id="inputAddress" cols="30" rows="5"></textarea></td>
        </tr>
        <tr>
          <td align="left">输入手机号码：</td>
          <td align="left"><label for="inputPhoneNum"></label>
          <input name="inputPhoneNum" type="text" id="inputPhoneNum" size="30"></td>
        </tr>
        <tr>
          <td colspan="2" align="center"><input type="reset" name="button2" id="button2" value="重置">            <input type="submit" name="button" id="button" value="提交"></td>
        </tr>
      </table>
      <p>
        <input name="flag" type="hidden" id="flag" value="update_employeer">
      </p>
    </form>
    <hr>
    <%=request.getAttribute("massge") %>
    
  </body>
</html>
