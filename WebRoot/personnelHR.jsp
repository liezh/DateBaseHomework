<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'personnelHR.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  <script src="../SpryAssets/SpryTabbedPanels.js" type="text/javascript"></script>
  <link href="../SpryAssets/SpryTabbedPanels.css" rel="stylesheet" type="text/css">
  </head>
  
  <body>
  <div id="TabbedPanels1" class="TabbedPanels">
    <ul class="TabbedPanelsTabGroup">
      <li class="TabbedPanelsTab" tabindex="0"><a href="queryEmployeersInfo.jsp">员工基本信息查询</a></li>
      <li class="TabbedPanelsTab" tabindex="0"><a href="addEmployeersInfo.jsp">员工基本信息添加</a></li>
      <li class="TabbedPanelsTab" tabindex="0">员工基本信息修改</li>
      <li class="TabbedPanelsTab" tabindex="0">员工基本信息删除</li>
    </ul>
    <div class="TabbedPanelsContentGroup">
      <div class="TabbedPanelsContent">员工基本信息查询，可以按照员工号，姓名，性别，婚姻状况等条件来进行查询。</div>
      <div class="TabbedPanelsContent">员工基本信息添加，可以添加员工的基本信息添加。</div>
      <div class="TabbedPanelsContent">员工基本信息修改，可以修改相对应的员工信息。</div>
      <div class="TabbedPanelsContent">员工基本信息删除，以员工号为条件删除相对应的员工信息。</div>
    </div>
  </div>
  <script type="text/javascript">
var TabbedPanels1 = new Spry.Widget.TabbedPanels("TabbedPanels1");
  </script>
</body>
</html>
