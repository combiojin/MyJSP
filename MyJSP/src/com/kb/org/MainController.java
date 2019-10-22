package com.kb.org;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kb.org.member.MemberDAO;
import com.kb.org.member.MemberVO;

@WebServlet("*.do")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MemberDAO dm = MemberDAO.getInstance();
    
    public MainController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = null;
		request.setCharacterEncoding("UTF-8");
		String reqURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String cmd = reqURI.substring(contextPath.length());

		if( cmd.equals("/index.do")) {
			rd = request.getRequestDispatcher("index.jsp");
		}
		else if(cmd.equals("/member.do")) {
			dm.select(request);
			dm.cntmember(request);
			rd = request.getRequestDispatcher("member.jsp");
		}
		else if(cmd.equals("/freeboard.do")) {
			rd = request.getRequestDispatcher("freeboard.jsp");
		}
		else if(cmd.equals("/memberInsert.do")) {
			rd = request.getRequestDispatcher("memberInsert.jsp");
		}
		else if(cmd.equals("/memberInsertProc.do")) {
			dm.insert(request);
			dm.select(request);
			dm.cntmember(request);
			rd = request.getRequestDispatcher("member.jsp");
		}
		else if(cmd.equals("/memberUpdate.do")) {
			dm.selectRow(request);
			rd = request.getRequestDispatcher("memberUpdate.jsp");
		}
		else if(cmd.equals("/memberUpdateProc.do")) {
			dm.updateRow(request);
			dm.select(request);
			rd = request.getRequestDispatcher("member.jsp");
		}
		else {
			rd = request.getRequestDispatcher("error404.jsp");
		}
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}









