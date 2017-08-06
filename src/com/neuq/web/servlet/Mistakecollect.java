package com.neuq.web.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuq.bean.Mistakes;
import com.neuq.db.DBUtil;
public class Mistakecollect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Mistakecollect() {
        super();

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		con = DBUtil.getConnection();
		//����һ��ArrayList.�������Book���е�����
		ArrayList<Mistakes> list = new ArrayList<Mistakes>();
		try {
			// where username = ?
			String sql="select * from mistakes where username = ?";
			pst = con.prepareStatement(sql);
			pst.setString(1, (String)request.getParameter("username"));
			rs = pst.executeQuery();
			while (rs.next()) {
				//������һ��ʵ����,������Ŵ����ݿ����õ�������
				Mistakes mis=new Mistakes();
				mis.setId(rs.getInt(1));
				mis.setUsername(rs.getString(2));
				mis.setQuestiontype(rs.getString(3));
				mis.setQuestionid(rs.getInt(4));
				list.add(mis);
			}
			//��list���ݴ��
			request.setAttribute("list", list);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//��list���ݷ��͵�.jsp�ļ���
		request.getRequestDispatcher("mistakecollect.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

