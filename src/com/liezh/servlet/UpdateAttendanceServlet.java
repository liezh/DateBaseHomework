package com.liezh.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liezh.Dao.AttendanceDAO;
import com.liezh.Dao.ItemsDAO;
import com.liezh.entity.AttendanceBean;

public class UpdateAttendanceServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UpdateAttendanceServlet() {
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
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
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		ItemsDAO itemsDAO = new ItemsDAO();
		String condition = request.getParameter("inputAtt_id");
		String emp_idStr = request.getParameter("inputEmp_id");
		String yearStr = request.getParameter("selectYear");
		String moonthStr = request.getParameter("selectMooth");
		String dayStr = request.getParameter("selectDay");
		String stateStr = request.getParameter("selectState");

		String timeStr = yearStr +  "-" + moonthStr + "-" + dayStr ;
		System.out.println("att_id:" + condition + "emp_id:" + emp_idStr + "time:" + timeStr + "state:" + stateStr);
		
		
			
		
		AttendanceDAO attendanceDAO = new AttendanceDAO();
		if(emp_idStr != ""){
			String str = "emp_id=" + emp_idStr;  
			
			boolean b = attendanceDAO.updateAttendanceInfo(str,condition);
			this.havaError(b, request, response);
		}
		if(timeStr != ""){
			String str = "time='" + timeStr + "'";   
			boolean b = attendanceDAO.updateAttendanceInfo(str,condition);
			this.havaError(b, request, response);
		}
		if(stateStr != ""){
			String str = "state=" + stateStr;  
			boolean b = attendanceDAO.updateAttendanceInfo(str,condition);
			this.havaError(b, request, response);
		}
		
		//修改好信息后就更新工资表的考勤克扣，和realWage的值
		
		
		
		
		request.setAttribute("massge", "修改成功！！");	
		RequestDispatcher dispatcher = request.getRequestDispatcher("/attendance/updateAttendanceInfo.jsp");
	    dispatcher.forward(request, response);
		
		
		
	}

	private void havaError(boolean b,HttpServletRequest request, HttpServletResponse response) {
		if(b == false){
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			try {
				dispatcher.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
