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
	
	public static final int MEMBER_NONEXISTENT = 0;		//* member�� �������� ���� �� 0���� ��ȯ�ϰڴ�.
	public static final int MEMBER_EXISTENT = 1;		//* member�� ������ �� 1�� ��ȯ!!
	public static final int MEMBER_JOIN_FAIL = 0;		//* ������ ������ �� 0���� ��ȯ!!
	public static final int MEMBER_JOIN_SUCCESS = 1;	//* ������ ������ �� 1�� ��ȯ!!
	public static final int MEMBER_LOGIN_PW_NO_GOOD = 0;//* �α��� ��й�ȣ�� Ʋ�� �� 0���� ��ȯ!!
	public static final int MEMBER_LOGIN_SUCCESS = 1;	//* �α����� ������ �� 1�� ��ȯ!!
	public static final int MEMBER_LOGIN_IS_NOT = -1;	//* �α��� �� �� ȸ�������� �ȵ� �����̸� -1�� ��ȯ!!

	public MemberDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public int insertMember(MemberDTO dto) {
		int ri = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String query = "insert into memberex (?, ?, ?, ?, ?)"; //* ()�ȿ� ���� �ȳ־ �ڵ����� �� ������ ���缭 ? �־��ָ� ��
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
		} catch (Exception e) {								//* Exception�� �� ũ��.
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return conn;
	}
}
