package com.kb.org.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.kb.org.ConnectionPool;

public class MemberDAO {

	private static MemberDAO md = new MemberDAO();
	public static MemberDAO getInstance() {
		return md;		
	}
	// list member select
	public void select(HttpServletRequest request) {
		String number = request.getParameter("pageNum");
		
		int num = number == null ? 1: Integer.parseInt(number);
		
		/*
		 * num == 1 num = 0;
		 * num == 2 num = 10;
		 * num == 3 num = 20;
		 * num == 4 num = 30;
		 */
		
		num = 10*(num-1);
			
		try {
			List<MemberVO> list = new ArrayList<>();
			Connection conn = ConnectionPool.getConnection();	//context.xml 에 DB연결
			PreparedStatement pstmt = conn.prepareStatement(" select * from member " + 
															" order by seq desc " + 
															" limit ?,10 ");
			pstmt.setInt(1, num);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				list.add(
					new MemberVO(
						rs.getString("name"),
						rs.getString("id"),
						rs.getString("pwd"),
						rs.getInt("seq"),
						rs.getString("joindate"),
						rs.getString("gender")
					)
				);
			}
			request.setAttribute("myList", list);
			
		}catch (Exception e) {
			e.printStackTrace();
		}	
	}
	// member insert
	public void insert(HttpServletRequest request) {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String gender = request.getParameter("gender");
		
		try {
			Connection conn = ConnectionPool.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(" insert into member " + 
															" (id,name,pwd,gender) " + 
															" values " + 
															" (?,?,?,?) ");
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, pwd);
			pstmt.setString(4, gender);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// member table row count
	public void cntmember(HttpServletRequest request) {
		try {
			int cnt = 0;
			Connection conn = ConnectionPool.getConnection();	//context.xml 에 DB연결
			PreparedStatement pstmt = conn.prepareStatement(" select count(seq)  from member ");
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next())
				cnt = rs.getInt(1);
			
			if(cnt%10 != 0 ) {
				cnt = cnt / 10+1;
			} else {
				cnt = cnt / 10;				
			}
			
			request.setAttribute("membercnt", cnt);
			
		}catch (Exception e) {
			e.printStackTrace();
		}	
	}
	public void selectRow(HttpServletRequest request) {
		String seq = request.getParameter("seq");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = ConnectionPool.getConnection();
			pstmt = conn.prepareStatement(" select * from member where seq = ? ");
			pstmt.setInt(1, Integer.parseInt(seq));
				
			rs = pstmt.executeQuery();
			if(rs.next()) {
				MemberVO mv = new MemberVO();
				mv.setId(rs.getString("id"));
				mv.setJoindate(rs.getString("joindate"));
				mv.setGender(rs.getString("gender"));
				mv.setPwd(rs.getString("pwd"));
				mv.setSeq(rs.getInt("seq"));
				mv.setName(rs.getString("name"));
				
				request.setAttribute("row", mv);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void updateRow(HttpServletRequest request) {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String gender = request.getParameter("gender");
		String seq = request.getParameter("seq");
		
		try {
			Connection conn = ConnectionPool.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(" update member " + 
															" set id = ?, " + 
															"	  name = ?, " + 
															"     pwd = ?, " + 
															"     gender = ? " + 
															" where seq = ? ");
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, pwd);
			pstmt.setString(4, gender);
			pstmt.setInt(5, Integer.parseInt(seq));
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
