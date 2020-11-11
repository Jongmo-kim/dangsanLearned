package member.model.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import common.JDBCTemplate;
import member.model.dao.MemberDao;
import member.model.vo.Member;

public class MemberService {
	public Member selectOneMember(Member member) {
		Connection conn = JDBCTemplate.getConnection();
		Member loginMember = new MemberDao().selectOneMember(conn,member);
		JDBCTemplate.close(conn);
		
		return loginMember;	
		}

	public int insertMember(Member member) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		System.out.println(member.getMemberName());
		System.out.println(member.getMemberLevel());
		System.out.println(member.getMemberPw());
		System.out.println(member.getAddress());
		System.out.println(member.getAddress());
		System.out.println(member.getAddress());
		result = new MemberDao().insertOneMember(conn,member);
		if(result > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public Member selectOneMember(String memberId) {
		Connection conn = JDBCTemplate.getConnection();
		Member member = new MemberDao().selectOneMember(conn, memberId);
		
		return member;
	}
	
}
