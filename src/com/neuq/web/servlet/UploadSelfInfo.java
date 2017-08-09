package com.neuq.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuq.bean.Manager;
import com.neuq.bean.Student;
import com.neuq.bean.Teacher;
import com.neuq.bean.User;

/**
 * ���¸�����Ϣ��������
 * 
 * @author Administrator
 *
 */
public class UploadSelfInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadSelfInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String type = request.getParameter("usertype");

		String username = (String) request.getAttribute("username");
		String pwd = (String) request.getAttribute("pwd");
		String name = (String) request.getAttribute("name");
		String sex = (String) request.getAttribute("sex");
		String telephone = (String) request.getAttribute("telephone");
		String email = (String) request.getAttribute("email");
		if (type.equals("3")) {
			String studentclass = (String) request.getAttribute("studentclass");
			Student s = new Student(username, pwd, name, sex, studentclass, telephone, email);
			
			request.getSession().setAttribute("Student", s);

			// ���º��ض���ѧ����ҳ��
			response.sendRedirect("Student/index.jsp");
			return;
		}
		if (type.equals("2")) {

			Teacher t = new Teacher(username, pwd, name, sex, telephone, email);

			request.getSession().setAttribute("Teacher", t);

			// ���º��ض�������ʦ��ҳ��
			response.sendRedirect("Teacher/index.jsp");
			return;
		}
		if (type.equals("1")) {

			Manager m = new Manager(username, pwd, name, sex, telephone, email);

			request.getSession().setAttribute("Manager", m);

			// ���º��ض���������Ա��ҳ��
			response.sendRedirect("Manager/index.jsp");
			return;
		}

	}

}
