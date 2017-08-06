package com.neuq.web.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuq.bean.Paper;
import com.neuq.db.DBUtil;

/**
 * Servlet implementation class ShowPaper
 */

public class ShowPaper extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowPaper() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                 doPost(request, response);
                 
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�Ѿ������Ŀ���
		List<Paper> before=new ArrayList<Paper>();

		//δ���Ŀ���
		List<Paper> after=new ArrayList<Paper>();

		//��ǰ���Խ��еĿ���
		List<Paper> now=new ArrayList<Paper>();
		//�������ڸ�ʽ
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// new Date()Ϊ��ȡ��ǰϵͳʱ��
		String d=df.format(new Date());
		
		String sql="select * from paper";
		Connection con=DBUtil.getConnection();
		PreparedStatement pr =null;
		ResultSet rs =null;
		Paper p=new Paper();
		try {
			 pr = con.prepareStatement(sql);
			 rs = pr.executeQuery();
			 while (rs.next()) {
				//����ֵ
				 //17������
				 
				 
				 
				if (p.getStarttime().toString()<d) {
					before.add(p);
				}else if (p.getStarttime()>d) {
					after.add(p);
				}else {
					now.add(p);
				}
				
			}
			 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
            DBUtil.CloseConnection(rs, pr, con);
		}
		
		request.setAttribute("PaperBefore",before);
		request.setAttribute("PaperAfter",after);
		request.setAttribute("PaperNow",now);
		//��ת���Ծ�ҳ
		request.getRequestDispatcher("/paper.jsp").forward(request, response);
		
		
		
	}

}
