package com.liezh.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.liezh.Dao.ItemsDAO;

public class AssountServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AssountServlet() {
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
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("�û�����"+username);
		System.out.println("���룺��"+password);

		ItemsDAO itemsDAO = new ItemsDAO();
		if(itemsDAO.getLoginSuccess(username, password) == true){
			out.println("<h1>��¼�ɹ�������</h1>");
			response.sendRedirect("home.jsp");
		}
		else{
			out.println("<h2>��¼ʧ�ܣ������µĵ�¼������</h2>");
			out.print("<script Lanuage='JavaScript'>window.alert('�û�����������û����Ͳ���ȷ���������ص�¼ҳ��')</script>"); 
            out.print("<script Lanuage='JavaScript'>window.location ='login.jsp'</script>");  
			request.getRequestDispatcher("/index.jsp").forward(request, response);
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
