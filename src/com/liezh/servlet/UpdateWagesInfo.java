package com.liezh.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liezh.Dao.ItemsDAO;
import com.liezh.Dao.WagesDAO;

public class UpdateWagesInfo extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UpdateWagesInfo() {
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
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		WagesDAO wagesDAO = new WagesDAO();
		String condition = request.getParameter("inputWage_id");
		String emp_idStr = request.getParameter("inputEmp_id");
		String att_idStr = request.getParameter("inputAtt_id");
		String basic_wageStr = request.getParameter("inputBasic_wage");
		String ot_wageStr = request.getParameter("inputOT_wage");
		String insuranceStr = request.getParameter("inputInsurance");
		
		if(emp_idStr != ""){
			String str = "emp_id=" + emp_idStr;   //long
			boolean b = wagesDAO.updateWagesInfo(str,condition);
			this.havaError(b, request, response);
		}
		if(att_idStr != ""){
			String str = "attendance_id=" + att_idStr;   //long
			boolean b = wagesDAO.updateWagesInfo(str,condition);
			System.out.println("Update:"+b);
			this.havaError(b, request, response);
		}
		if(basic_wageStr != ""){
			String str = "basic_wage=" + basic_wageStr;   //long
			boolean b = wagesDAO.updateWagesInfo(str,condition);
			this.havaError(b, request, response);
		}
		if(ot_wageStr != ""){
			String str = "ot_wage=" + ot_wageStr;   //long
			boolean b = wagesDAO.updateWagesInfo(str,condition);
			this.havaError(b, request, response);
		}
		if(insuranceStr != ""){
			String str = "insurance=" + insuranceStr;   //long
			boolean b = wagesDAO.updateWagesInfo(str,condition);
			this.havaError(b, request, response);
		}
		
		double sum_wageDouble = 0.0;
		double realWageDouble = 0.0;
		if(basic_wageStr != "" || ot_wageStr != ""){
		//进行计算总工资的操作
			if(basic_wageStr == ""){
				basic_wageStr = "0.0";
			}
			if(ot_wageStr == ""){
				ot_wageStr = "0.0";
			}			
			sum_wageDouble = Double.parseDouble(basic_wageStr) + Double.parseDouble(ot_wageStr);
			String str = "sum_wage=" + sum_wageDouble;
			boolean b = wagesDAO.updateWagesInfo(str,condition);
			this.havaError(b, request, response);
		}
		//进行计算真实工资的操作
		if(insuranceStr != ""){
			double attendSkimp = wagesDAO.getAttendanceVlue(condition);
			realWageDouble = sum_wageDouble - Double.parseDouble(insuranceStr) - attendSkimp;
			String str = "realWage=" + realWageDouble;
			boolean b = wagesDAO.updateWagesInfo(str,condition);
			this.havaError(b, request, response);
		}

		request.setAttribute("massge", "修改成功！！");	
		RequestDispatcher dispatcher = request.getRequestDispatcher("/wages/updateWagesInfo.jsp");
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
