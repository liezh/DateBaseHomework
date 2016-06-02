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
import com.liezh.Dao.WagesDAO;
import com.liezh.entity.AttendanceBean;
import com.liezh.entity.Items;
import com.liezh.entity.WagesBean;

public class AddWagesInfo extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddWagesInfo() {
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
		String wage_idStr = request.getParameter("inputWage_id");
		String emp_idStr = request.getParameter("inputEmp_id");
		String att_idStr = request.getParameter("inputAtt_id");
//		String attendSkimpStr = request.getParameter("");
		String basic_wageStr = request.getParameter("inputBasic_wage");
		String ot_wageStr = request.getParameter("inputOT_wage");
//		String sum_wageStr = request.getParameter("");
		String insuranceStr = request.getParameter("inputInsurance");
//		String realWageStr = request.getParameter("");
		
		int wage_idInt = Integer.parseInt(wage_idStr);
		int emp_idInt = Integer.parseInt(emp_idStr);
		int att_idInt = Integer.parseInt(att_idStr);
		double basic_wageDouble = Double.parseDouble(basic_wageStr);
		double ot_wageDouble = Double.parseDouble(ot_wageStr);
		double insuranceDouble = Double.parseDouble(insuranceStr);
		//通过AttendanceDAO获取相应的员工的考勤信息来计算attendSkimp的值。
		ArrayList<AttendanceBean> list = new ArrayList<AttendanceBean>();
		AttendanceDAO attendanceDAO = new AttendanceDAO();
		list = attendanceDAO.getAllAttendance("emp_id=" + emp_idInt);
		Double attendSkimpDouble = 0.0;
		if(list!=null&&list.size()>0)
	      {
			   for(int i=0;i<list.size();i++)
	          {
	    	      out.print("================="+i + "===" + list.size());
	    	      AttendanceBean attendanceBean = list.get(i);
	    	      if(attendanceBean.getState() == 1 || attendanceBean.getState() == 3)
	    	    	  attendSkimpDouble += 0.0;
	    	      else if(attendanceBean.getState() == 2 || attendanceBean.getState() == 5)
	    	    	  attendSkimpDouble += 50.0;
	    	      else if(attendanceBean.getState() == 4)
	    	    	  attendSkimpDouble += 100.0;      
	          }
	      }
		double sum_wageDouble = basic_wageDouble + ot_wageDouble ;
		double realWageDouble = sum_wageDouble - attendSkimpDouble - insuranceDouble ;
		
		//将所有信息装入到WageBean当中再提交到WagesDAO中插入数据。
		WagesBean wagesBean = new WagesBean();
		wagesBean.setWage_id(wage_idInt);
		wagesBean.setEmp_id(emp_idInt);
		wagesBean.setAttendance_id(att_idInt);
		wagesBean.setAttendSkimp(attendSkimpDouble);
		wagesBean.setBasic_wage(basic_wageDouble);
		wagesBean.setOt_wage(ot_wageDouble);
		wagesBean.setSum_wage(sum_wageDouble);
		wagesBean.setInsurance(insuranceDouble);
		wagesBean.setRealWage(realWageDouble);
		
		//用WagesDAO处理添加的操作。
		WagesDAO wagesDAO = new WagesDAO();
		if(wagesDAO.addWagesInfo(wagesBean)){
			request.setAttribute("massge", "添加成功！！");	
		}else{
			request.setAttribute("massge", "添加失败！！");
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/wages/addWagesInfo.jsp");
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
