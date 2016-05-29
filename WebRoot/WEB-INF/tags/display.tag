<%@ tag pageEncoding="UTF-8" %>
<%@ tag import="com.liezh.Dao.ItemsDAO" %>
<%@ tag import="com.liezh.entity.Items" %>
<%@ tag import="util.DBHelper" %>
<%@ tag import="java.util.ArrayList" %>
<%@ attribute name="flag" required="true"%>
<%@ variable name-given="string" scope="AT_END" %>



		<%
        	//这里是显示头啖汤的逻辑代码！
        	String str = "<div><table> <tr><td>员工号</td> <td>身份证号</td> <td>姓名</td> <td>性别</td> <td>年龄</td> " +
        	             "<td>婚姻状况</td> <td>学历</td> <td>职称</td> <td>住址</td> <td>电话号码</td></tr>";
        	ItemsDAO itemsDao = new ItemsDAO();
        	
            ArrayList<Items> list = itemsDao.getAllItems(flag);
            
               if(list!=null&&list.size()>0)
               {
         		   for(int i=0;i<list.size();i++)
	               {
	         	      out.print("================="+i + "===" + list.size());
	                  Items item = list.get(i);  
	                  str += "<tr><td>" + item.getId() + "</td><td>" + item.getPersonalID() + "</td><td>" +item.getName() + "</td><td>"
	                  + item.getSex() + "</td><td>" + item.getAge() + "</td><td>" + item.getMarriage() + "</td><td>" + item.getEducation()
	                   + "</td><td>" + item.getTitle() +  "</td><td>" + item.getAddress() + "</td><td>" + item.getPhoneNum() + "</td></tr>" ;
	                  System.out.println(str);
	               }
	           }else{
	           		str = "获取失败！！"+flag;
	           }
	           str += "</table></div>";
	           jspContext.setAttribute("string",str);
	     %>
	  
         
         