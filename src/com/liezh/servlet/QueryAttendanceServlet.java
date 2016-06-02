package com.liezh.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liezh.Dao.AttendanceDAO;
import com.liezh.Dao.ItemsDAO;
import com.liezh.entity.AttendanceBean;
import com.liezh.entity.Items;

public class QueryAttendanceServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public QueryAttendanceServlet() {
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
		String conditions = request.getParameter("conditions");
		String content = request.getParameter("content");
		System.out.println(conditions + "===" + content);
		
		String str = "<div><table width='100%' border='1'> <tr><td>考勤号</td> <td>员工号</td> <td>时间</td> <td>状态</td> </tr>";
		AttendanceDAO attendanceDAO = new AttendanceDAO();
		String flag = conditions + "='" + content + "'" ;
		ArrayList<AttendanceBean> list = attendanceDAO.getAllAttendance(flag);
   
		if(list!=null&&list.size()>0)
		{
		   for(int i=0;i<list.size();i++)
          {
    	      out.print("================="+i + "===" + list.size());
             AttendanceBean attendanceBean = list.get(i);  
             str += "<tr><td>" + attendanceBean.getAtt_id() + "</td><td>" + attendanceBean.getEmp_id() + "</td><td>"
             + attendanceBean.getTime() + "</td><td>" + attendanceBean.getState() + "</td></tr>" ;
             System.out.println(str);
          }
		}else{
      		str = "获取失败！！"+content;
		}
		str += "</table></div>";
		request.setAttribute("infoStr", str);
      
		String flagStr = (String) request.getParameter("flag");
		System.out.println("111111111111"+flagStr);
		if(flagStr.equals("query_attendance")){
			RequestDispatcher dispatcher = request.getRequestDispatcher("/attendance/queryAttendanceInfo.jsp");
			dispatcher.forward(request, response);
		}else{
		  RequestDispatcher dispatcher = request.getRequestDispatcher("/attendance/deleteAttendanceInfo.jsp");
          dispatcher.forward(request, response);
		}
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
