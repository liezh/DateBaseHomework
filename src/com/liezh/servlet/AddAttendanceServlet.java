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
import com.liezh.entity.Items;

public class AddAttendanceServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddAttendanceServlet() {
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
		String emp_idStr = request.getParameter("inputEmp_id");
		String yearStr = request.getParameter("selectYear");
		String moonthStr = request.getParameter("selectMooth");
		String dayStr = request.getParameter("selectDay");
		String stateStr = request.getParameter("selectState");
		
		String timeStr = yearStr + "-" + moonthStr + "-" + dayStr ;
		
		//把从表单的到的数据添加大AttendanceBean当中，并传递到AttendanceDAO.addAttendanceInfo当中处理。
		AttendanceBean attendanceBean = new AttendanceBean();    
		attendanceBean.setEmp_id(Integer.parseInt(emp_idStr));
		attendanceBean.setTime(timeStr);
		attendanceBean.setState(Integer.parseInt(stateStr));	
		AttendanceDAO attendanceDAO = new AttendanceDAO();
		if(attendanceDAO.addAttendanceInfo(attendanceBean)){
			
			//添加成功后就更新对应的员工的工资表，当中的考勤克扣，并更新realWage
			
			request.setAttribute("massge", "添加成功！！");	
		}else{
			request.setAttribute("massge", "添加失败！！");
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/attendance/addAttendanceInfo.jsp");
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
