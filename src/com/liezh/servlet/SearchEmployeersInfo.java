package com.liezh.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liezh.Dao.ItemsDAO;
import com.liezh.entity.Items;

public class SearchEmployeersInfo extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public SearchEmployeersInfo() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
//		String select=request.getParameter("selectName")；
		String conditions = request.getParameter("conditions");
		String content = request.getParameter("content");
		System.out.println(conditions + "===" + content);
		
		String str = "<div><table width='100%' border='1'> <tr><td>员工号</td> <td>身份证号</td> <td>姓名</td> <td>性别</td> <td>年龄</td> " +
	             "<td>婚姻状况</td> <td>学历</td> <td>职称</td> <td>住址</td> <td>电话号码</td></tr>";
	ItemsDAO itemsDao = new ItemsDAO();
	String flag = conditions + "='" +content + "'" ;
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
      		str = "获取失败！！"+content;
      }
      str += "</table></div>";
      request.setAttribute("infoStr", str);
      RequestDispatcher dispatcher = request.getRequestDispatcher("queryEmployeersInfo.jsp");
      dispatcher.forward(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
