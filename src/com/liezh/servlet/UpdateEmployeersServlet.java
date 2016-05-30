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

public class UpdateEmployeersServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UpdateEmployeersServlet() {
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
		
		ItemsDAO itemsDAO = new ItemsDAO();
		String condition = request.getParameter("inputId");
		out.println("ID:" + request.getParameter("inputPersonalId"));
		out.println(request.getParameter("inputName"));
		out.println(request.getParameter("selectSex"));
		if(request.getParameter("inputPersonalId") != ""){
			String str = "personalID=" + request.getParameter("inputPersonalId");   //long
			boolean b = itemsDAO.updateEmployeersInfo(str,condition);
			this.havaError(b, request, response);
		}
		if(request.getParameter("inputName") != ""){
			String str = "name='" + request.getParameter("inputName") + "'";
			boolean b = itemsDAO.updateEmployeersInfo(str,condition);
			this.havaError(b, request, response);
		}
		if(request.getParameter("inputAge") != ""){
			String str = "age=" + request.getParameter("inputAge");   //int
			boolean b = itemsDAO.updateEmployeersInfo(str,condition);
			this.havaError(b, request, response);
		}
		if(request.getParameter("selectSex") != ""){
			String str = "sex='" + request.getParameter("selectSex") + "'";
			boolean b = itemsDAO.updateEmployeersInfo(str,condition);
			this.havaError(b, request, response);
		}
		if(request.getParameter("selectMarriage") != ""){
			String str = "marriage='" + request.getParameter("selectMarriage") + "'";
			boolean b = itemsDAO.updateEmployeersInfo(str,condition);
			this.havaError(b, request, response);
		}
		if(request.getParameter("selectEducation") != ""){
			String str = "education='" + request.getParameter("selectEducation") + "'";
			boolean b = itemsDAO.updateEmployeersInfo(str,condition);
			this.havaError(b, request, response);
		}
		if(request.getParameter("inputSchool") != ""){
			String str = "school='" + request.getParameter("inputSchool") + "'";
			boolean b = itemsDAO.updateEmployeersInfo(str,condition);
			this.havaError(b, request, response);
		}
		if(request.getParameter("selectTitle") != ""){
			String str = "title='" + request.getParameter("selectTitle") + "'";
			boolean b = itemsDAO.updateEmployeersInfo(str,condition);
			this.havaError(b, request, response);
		}
		if(request.getParameter("inputAddress") != ""){
			String str = "address='" + request.getParameter("inputAddress") + "'";
			boolean b = itemsDAO.updateEmployeersInfo(str,condition);
			this.havaError(b, request, response);
		}
		if(request.getParameter("inputPhoneNum") != ""){
			String str = "phoneNum=" + request.getParameter("inputPhoneNum");    //long
			boolean b = itemsDAO.updateEmployeersInfo(str,condition);
			this.havaError(b, request, response);
		}
		request.setAttribute("massge", "ÐÞ¸Ä³É¹¦£¡£¡");	
		RequestDispatcher dispatcher = request.getRequestDispatcher("updateEmployeersInfo.jsp");
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
