<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addAttendanceInfo.jsp' starting page</title>
    
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
  <h2>欢迎来到员工考勤添加页面。</h2>
  <br>
  <form name="form1" method="post" action="AddAttendanceServlet">
    <table width="500" border="1" align="center">
      <tr>
        <td width="194" height="34">请输入考勤员工的员工号：</td>
        <td width="290"><label for="inputEmp_id"></label>
        <input type="text" name="inputEmp_id" id="inputEmp_id"></td>
      </tr>
      <tr>
        <td height="36">请输入考勤时间：</td>
        <td><label for="selectYear"></label>
          <select name="selectYear" id="selectYear">
            <option value="2014">2014</option>
            <option value="2015">2015</option>
            <option value="2016" selected="selected">2016</option>
            <option value="2017">2017</option>
          </select>
          年
          <label for="selectMooth"></label>
          <select name="selectMooth" id="selectMooth">
            <option value="1" selected="selected">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
            <option value="6">6</option>
            <option value="7">7</option>
            <option value="8">8</option>
            <option value="9">9</option>
            <option value="10">10</option>
            <option value="11">11</option>
            <option value="12">12</option>
          </select>
          月
          <label for="selectDay"></label>
          <select name="selectDay" id="selectDay">
            <option value="1" selected="selected">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
            <option value="6">6</option>
            <option value="7">7</option>
            <option value="8">8</option>
            <option value="9">9</option>
            <option value="10">10</option>
            <option value="11">11</option>
            <option value="13">13</option>
            <option value="14">14</option>
            <option value="16">16</option>
            <option value="17">17</option>
            <option value="18">18</option>
            <option value="19">19</option>
            <option value="20">20</option>
            <option value="21">21</option>
            <option value="22">22</option>
            <option value="23">23</option>
            <option value="24">24</option>
            <option value="25">25</option>
            <option value="26">26</option>
            <option value="27">27</option>
            <option value="28">28</option>
            <option value="29">29</option>
            <option value="30">30</option>
            <option value="31">31</option>
          </select>
          日</td>
      </tr>
      <tr>
        <td height="45">考勤状态：</td>
        <td><label for="selectState"></label>
          <select name="selectState" id="selectState">
            <option value="1" selected="selected">正常</option>
            <option value="2">迟到</option>
            <option value="3">请假</option>
            <option value="4">旷工</option>
            <option value="5">早退</option>
        </select></td>
      </tr>
      <tr>
        <td height="49" colspan="2" align="center"><input type="reset" name="button" id="button" value="重置">
        <input type="submit" name="button2" id="button2" value="提交"></td>
      </tr>
    </table>
    <p>
      <input name="flag" type="hidden" id="flag" value="add_attendance">
    </p>
  </form>
  </body>
  <hr>
  <%=request.getAttribute("massge") %>
  
</html>
