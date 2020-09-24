package kh.member.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import kh.member.model.vo.Member;

public class MemberDao {
	final String CONNECT_IP= "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	final String CONNECT_USER = "jdbc";
	final String CONNECT_PW = "1234";
	final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	public Member getNewMember(ResultSet rset) {
		
		Member e = null;
		try {
			int memberNo = rset.getInt("member_no");
			String memberId = rset.getString("member_id");
			String memberPw = rset.getString("member_pw");
			String memberName = rset.getString("member_name");
			int age = rset.getInt("age");
			char gender = rset.getString("gender").charAt(0);
			String phone = rset.getString("phone");
			Date enrollDate = rset.getDate("enroll_date");
			e = new Member(memberNo, memberId, memberPw, memberName, age, gender, phone, enrollDate);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return e;

	}
	public int insertMember(Member e) {
		/*
		 * create table member (
    member_no number primary key,
    member_id varchar2(20) unique not null,
    member_pw varchar2(20) not null,
    member_name varchar2(20)  null,
    AGe          number,
    gender char(3) check(gender in('남','여')),
    phone   char(13),
    enroll_date date default sysdate
);
		 */
		int result = 0;
		String query = String.format("insert into member values(member_seq.nextval,\'%s\',\'%s\',\'%s\',\'%d\',\'%c\',\'%s\',sysdate)",
				e.getMemberId(),e.getMemberPw(),e.getMemberName(),e.getAge(),e.getGender(),e.getPhone());
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(CONNECT_IP, CONNECT_USER, CONNECT_PW);
			pstmt = conn.prepareStatement(query);
			result = pstmt.executeUpdate(); 
			if(result >0) {
				conn.commit();
			} else {
				conn.rollback();
			}
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return result;
	}
	public Member selectOneMemberById(String Id) {
		Member member = null;
		String query = String.format("select * from member where member_id = \'%s\'",Id);
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(CONNECT_IP,CONNECT_USER,CONNECT_PW);
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			if(rset.next()) {
				member = getNewMember(rset);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return member;
	}
	public ArrayList<Member> selectAllMember() {
//		전체 회원정보를 저장할 ArrayList 레퍼런스 생성
		ArrayList<Member> list = new ArrayList<Member>();
//		보낼 쿼리문
		String query = "select * from member";
//		dbms 연결용 객체
		Connection conn = null;
//		sql구문을 사용하기 위한 객체
		Statement stmt = null;
//		sql결과를 받기위한 객체(select)
		ResultSet rset = null;
		try {
//		1. Driver 등록 (사용할 db에 대한 드라이버(클래스)
			Class.forName("oracle.jdbc.driver.OracleDriver");
//		2. Driver를 이용해서 DB연결 ( Connection 객체 생성) 2번쨰 데이터베이스 id 3번째 데이터베이스 pw
			conn = DriverManager.getConnection(CONNECT_IP, "jdbc", "1234");
//		3. 쿼리문을 실행할 객체 생성
			stmt = conn.createStatement();
//		4. 쿼리문 전송하고 결과받기
			rset = stmt.executeQuery(query);
//		5. 결과처리
			while (rset.next()) {
				int memberNo = rset.getInt("member_no");
				String memberId = rset.getString("member_id");
				String memberPw = rset.getString("member_pw");
				String memberName = rset.getString("member_name");
				int age = rset.getInt("age");
				char gender = rset.getString("gender").charAt(0);
				String phone = rset.getString("phone");
				Date enrollDate = rset.getDate("enroll_date");
				Member e = new Member(memberNo, memberId, memberPw, memberName, age, gender, phone, enrollDate);
				list.add(e);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
//			6. 연결 종료
				rset.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return list;
	}
	public ArrayList<Member> selectChoiceMember(String id) {
		ArrayList<Member> list = new ArrayList<Member>();
		String sql = String.format("select * from member where member_id like \'%%%s%%\'", id);

		Connection conn = null;
		Statement stmt = null;
		ResultSet rset =null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(CONNECT_IP, CONNECT_USER, CONNECT_PW);
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			while(rset.next()) {
				Member e = getNewMember(rset);
				list.add(e);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
		
		return list;
	}
	public int updateMember(Member e) {
		int result = 0;
		/*
		 * create table member (
    member_no number primary key,
    member_id varchar2(20) unique not null,
    member_pw varchar2(20) not null,
    member_name varchar2(20)  null,
    AGe          number,
    gender char(3) check(gender in('남','여')),
    phone   char(13),
    enroll_date date default sysdate
);
		 */
		String sql = String.format("update member set member_id ="
				+ " \'%s\',member_pw = \'%s\',member_name = \'%s\',age = \'%d\', gender = \'%c\', phone = \'%s\' where member_id = \'%s\'", 
				e.getMemberId(), e.getMemberPw(), e.getMemberName(), e.getAge(),    e.getGender(),  e.getPhone(),      e.getMemberId());
		Connection conn = null;
		Statement stmt = null;
		
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(CONNECT_IP, CONNECT_USER, CONNECT_PW);
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
			if(result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			try {
				conn.close();
				stmt.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		}
		
		return result;
	}
	public int deleteMember(String no) {
		Connection conn = null;
		Statement stmt = null;
		int result = 0;
		String sql = String.format("delete from member where member_no = %s",no);
		System.out.println(sql);
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(CONNECT_IP,CONNECT_USER,CONNECT_PW);
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
			if(result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

}
