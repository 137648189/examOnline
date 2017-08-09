package com.neuq.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuq.bean.Paper;
import com.neuq.bean.PaperString;
import com.neuq.dao.I.TeacherInterfaceDao;
import com.neuq.dao.Impl.TeacherInterfaceImplDao;
import com.neuq.service.I.PaperInterfaceBiz;
import com.neuq.service.Impl.PaperInterfaceImplBiz;
import com.neuq.util.QuestionInstance;

/**
 * Servlet implementation class ShowAllPaper
 */
public class ShowAllPaper extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public ShowAllPaper() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Paper> lista   = new ArrayList<Paper>();
		List<Paper> listb   = new ArrayList<Paper>();
		lista = null;
		listb = null;
		PaperInterfaceBiz pif= new PaperInterfaceImplBiz();
		String selectpoint = request.getParameter("selectpoint");
		if(Integer.parseInt(selectpoint) == 1) {
			lista = pif.select();
			request.setAttribute("list",lista);
			request.getRequestDispatcher("/teacher/showpaper.jsp").forward(request, response);
		}
		else {
			lista = pif.select("java");
			listb = pif.select("c++");
			request.setAttribute("java",lista);
			request.setAttribute("c++",listb);
			//��֪ʶ����ʾ�Ծ����Ƶ���Ϣ
			request.getRequestDispatcher("/teacher/showpaper.jsp").forward(request, response);
		}
		String papername = request.getParameter("papername");
		TeacherInterfaceDao teacherInterfaceDao = new TeacherInterfaceImplDao();
		try {
			PaperString pString =teacherInterfaceDao.showPaper(papername);
			request.setAttribute("paper",pString);
			//��ʾ��ѡ���Ծ����ݣ�jsp����
			request.getRequestDispatcher("/teacher/XXXX.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		doGet(request, response);
	}

}
