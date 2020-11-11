package member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;
import member.model.vo.Member;

public class MemberDao {

	public Member selectOneMember(Connection conn, Member member) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member loginMember = null;
		String sql = "select * from member where member_id=? and member_pw=?";
		try {
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
				loginMember.setAddress(rset.getString("address"));
				loginMember.setMemberLevel(rset.getInt("member_level"));
				loginMember.setEnrollDate(rset.getString("enroll"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return loginMember;
	}

	public int insertOneMember(Connection conn, Member member) {
		PreparedStatement pstmt = null;
		String sql = "insert into member values(mem_seq.nextval,?,?,?,?,?,3,to_char(sysdate,'yyyy-mm-dd'))";
		int result = 0;
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			pstmt.setString(3, member.getMemberName());
			pstmt.setString(4, member.getPhone());
			pstmt.setString(5, member.getAddress());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		

		return result;
	}

	public Member selectOneMember(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member loginMember = null;
		String sql = "select * from member where member_id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				loginMember = new Member();
				loginMember.setMemberNo(rset.getInt("member_no"));
				loginMember.setMemberId(rset.getString("member_id"));
				loginMember.setMemberPw(rset.getString("member_pw"));
				loginMember.setMemberName(rset.getString("member_name"));
				loginMember.setPhone(rset.getString("phone"));
				loginMember.setAddress(rset.getString("address"));
				loginMember.setMemberLevel(rset.getInt("member_level"));
				loginMember.setEnrollDate(rset.getString("enroll"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return loginMember;
	}


}
