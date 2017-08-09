package com.neuq.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.neuq.dao.I.PaperInterfaceDao;
import com.neuq.dao.Impl.PaperInterfaceImplDao;

public class ShowPaper extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ShowPaper() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                 doPost(request, response);
                 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PaperInterfaceDao pif=new PaperInterfaceImplDao();
		request.setAttribute("PaperBefore",pif.showbeforePaper());
		request.setAttribute("PaperAfter",pif.showafterPaper());
		request.setAttribute("PaperNow",pif.shownowPaper());
		//��ת���Ծ�ҳ
		request.getRequestDispatcher("/paper.jsp").forward(request, response);
	}
}
