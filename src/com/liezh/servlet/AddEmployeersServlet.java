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

public class AddEmployeersServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddEmployeersServlet() {
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
		String idStr = request.getParameter("inputId");
		String personalIdStr = request.getParameter("inputPersonalId");
		String nameStr = request.getParameter("inputName");
		String sexStr = request.getParameter("selectSex");
		String ageStr = request.getParameter("inputAge");
		String marriageStr = request.getParameter("selectMarriage");
		String educationStr = request.getParameter("selectEducation");
		String schoolStr = request.getParameter("inputSchool");
		String titleStr = request.getParameter("selectTitle");
		String addressStr = request.getParameter("inputAddress");
		String phoneNumStr = request.getParameter("inputPhoneNum");
		
		int idInt = Integer.parseInt(idStr);
		long personalIdLong = Long.parseLong(personalIdStr);
		int ageInt = Integer.parseInt(ageStr);
		long phoneNumLong = Long.parseLong(phoneNumStr);
		
		Items item = new Items();     //员工基本信息javabean集合
		item.setId(idInt);
		item.setPersonalID(personalIdLong);
		item.setName(nameStr);
		item.setSex(sexStr);
		item.setAge(ageInt);
		item.setMarriage(marriageStr);
		item.setEducation(educationStr);
		item.setSchool(schoolStr);
		item.setTitle(titleStr);
		item.setAddress(addressStr);
		item.setPhoneNum(phoneNumLong);
		
		ItemsDAO itemsDAO = new ItemsDAO();
		if(itemsDAO.addEmployeersInfo(item)){
			request.setAttribute("massge", "添加成功！！");	
		}else{
			request.setAttribute("massge", "添加失败！！");
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("addEmployeersInfo.jsp");
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
