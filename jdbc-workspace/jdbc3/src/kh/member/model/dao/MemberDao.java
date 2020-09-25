package kh.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import kh.common.JDBCTemplate;
import kh.member.model.vo.Member;

public class MemberDao {
	
	public Member getNewMember(ResultSet rset) {
		Member m = null;
		try {
			if(rset.next()) {
				m = new Member();
				m.setAge(rset.getInt("age"));
				m.setEnrollDate(rset.getDate("enroll_date"));
				m.setGender(rset.getString("gender").charAt(0));
				m.setMemberId(rset.getString("member_id"));
				m.setMemberName(rset.getString("member_name"));
				m.setMemberPw(rset.getString("member_pw"));
				m.setPhone(rset.getString("phone"));
				m.setMemberNo(rset.getInt("member_no"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return m;
	}
	public int deleteMember(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "delete from member where member_id = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,memberId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		System.out.println("1");
		return result;
	}
	public Member selectOneMember(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member m = null;
		String sql = "select * from member where member_id = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery();
			m = getNewMember(rset);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return m;
	}
	public int insertDelMember(Connection conn, String memberId) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = "insert into del_member values(del_seq.nextval,?,sysdate)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			
		}
		return result;
	}
	public ArrayList<Member> selectAllMember(Connection conn) {
		ArrayList<Member> list = new ArrayList<Member>(); 
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "select * from member";
		
		try {
			pstmt=conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				list.add(getNewMember(rset));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}
	
	public int insertInsMember(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		int result =0;
		String sql = "insert into ins_member values(ins_seq.nextval,?,sysdate)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	public int insertMember(Connection conn, Member e) {
		int result = 0;
		PreparedStatement ptst = null;
		String sql = "insert into member values(member_seq.nextval,?,?,?,?,?,?,sysdate)";
	
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, e.getMemberId());
			ptst.setString(2, e.getMemberPw());
			ptst.setString(3, e.getMemberName());
			ptst.setInt(4, e.getAge());
			ptst.setString(5, String.valueOf(e.getGender()));
			ptst.setString(6, e.getPhone());
			result = ptst.executeUpdate(sql);
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			try {
				ptst.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return result;
	}

}
