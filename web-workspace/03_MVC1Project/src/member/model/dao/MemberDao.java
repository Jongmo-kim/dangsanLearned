package member.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import member.model.vo.Member;

public class MemberDao {
	public int insertMember(Member member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql  = "insert into membership values(mem_seq.nextval,?,?,?,?,?,?,to_char(sysdate,'yyyy-mm-dd'))";
		int result = 0 ;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","webserver","1234");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			pstmt.setString(3, member.getMemberName());
			pstmt.setString(4, member.getPhone());
			pstmt.setString(5, member.getEmail());
			pstmt.setString(6, member.getGender());
			result = pstmt.executeUpdate();
			if(result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	public ArrayList<Member> selectAllMember() {
		ArrayList<Member> list = new ArrayList<Member>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql  = " select * from membership";
		ResultSet rset = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","webserver","1234");
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Member m = new Member();
			    m.setMemberNo(rset.getInt("member_no"));
			    m.setMemberId(rset.getString("member_id"));
			    m.setMemberPw(rset.getString("member_pw"));
			    m.setMemberName(rset.getString("member_name"));
			    m.setPhone(rset.getString("phone"));
			    m.setEmail(rset.getString("email"));
			    m.setGender(rset.getString("gender"));
			    m.setEnrollDate(rset.getString("enroll_date"));
			    list.add(m);
			}
		} catch(Exception e) {
			
		} finally {
			try {
				rset.close();
				pstmt.close();
				conn.close();
			}
			catch(Exception e) {
				
			}
		}
		return list;
	}
	public Member selectOneMember(Member member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql  = " select * from membership where member_id=? and member_pw=?";
		ResultSet rset = null;
		Member loginMember = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","webserver","1234");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			rset = pstmt.executeQuery();
			if(rset.next()) {
				loginMember = new Member();
				loginMember.setMemberNo(rset.getInt("member_no"));
				loginMember.setMemberId(rset.getString("member_id"));
				loginMember.setMemberPw(rset.getString("member_pw"));
				loginMember.setMemberName(rset.getString("member_name"));
				loginMember.setPhone(rset.getString("phone"));
				loginMember.setEmail(rset.getString("email"));
				loginMember.setGender(rset.getString("gender"));
				loginMember.setEnrollDate(rset.getString("enroll_date"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		 catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			try {
				rset.close();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return loginMember;
	}
	public int updateMember(int NumberOfLoggendInMember,Member member) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql  = "update membership set member_id = ?, member_pw = ? , member_name = ? ,phone = ? , email = ? , gender = ?, enroll_date = ? "
				+ "where member_no = ?";
		
		System.out.println(member.getEmail());
				System.out.println(member.getMemberId());
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","webserver","1234");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberId());
			System.out.println(member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			pstmt.setString(3, member.getMemberName());
			pstmt.setString(4, member.getPhone());
			pstmt.setString(5, member.getEmail());
			pstmt.setString(6, member.getGender());
			pstmt.setString(7, member.getEnrollDate());
			pstmt.setInt(8, NumberOfLoggendInMember);
			result = pstmt.executeUpdate();
			if(result> 0 ) {
				conn.commit();
			} else {
				conn.rollback();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
		return result;
	}
	public int deleteOneMember(Member member) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql  = " delete from membership where member_no=?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","webserver","1234");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, member.getMemberNo());
			result = pstmt.executeUpdate();
			if(result > 0 ) {
				conn.commit();
			}{
				conn.rollback();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
}
