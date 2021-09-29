package com.javasiyeon.ex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberDAO {
	
	public static final int MEMBER_NONEXISTENT = 0;		//* member가 존재하지 않을 때 0으로 반환하겠당.
	public static final int MEMBER_EXISTENT = 1;		//* member가 존재할 때 1로 반환!!
	public static final int MEMBER_JOIN_FAIL = 0;		//* 가입이 실패할 때 0으로 반환!!
	public static final int MEMBER_JOIN_SUCCESS = 1;	//* 가입이 성공할 때 1로 반환!!
	public static final int MEMBER_LOGIN_PW_NO_GOOD = 0;//* 로그인 비밀번호가 틀릴 때 0으로 반환!!
	public static final int MEMBER_LOGIN_SUCCESS = 1;	//* 로그인이 성공할 때 1로 반환!!
	public static final int MEMBER_LOGIN_IS_NOT = -1;	//* 로그인 할 때 회원가입이 안된 상태이면 -1로 반환!!

	public MemberDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public int insertMember(MemberDTO dto) {
		int ri = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String query = "insert into memberex (?, ?, ?, ?, ?)"; //* ()안에 값을 안넣어도 자동으로 들어감 갯수에 맞춰서 ? 넣어주면 댐
		// ResultSet rs = null;
		
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getE_mail());
			pstmt.setString(5, dto.getAddress());
			
			pstmt.executeUpdate();
			ri = MemberDAO.MEMBER_JOIN_SUCCESS;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		return ri;
	}
	
	private Connection getConnection() {
		
		Context context = null;
		DataSource dataSource = null;
		Connection conn = null;
		
		try {
			context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
			conn = dataSource.getConnection();
		} catch (Exception e) {								//* Exception이 젤 크다.
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return conn;
	}
}
