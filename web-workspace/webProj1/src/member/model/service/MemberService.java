package member.model.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import common.JDBCTemplate;
import member.model.dao.MemberDao;
import member.model.vo.Member;
import sun.util.locale.StringTokenIterator;

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

	public ArrayList<Member> selectAllMember() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Member> list = new MemberDao().selectAllMember(conn);
		JDBCTemplate.close(conn);
		return list;
	}

	public int changeLevel( int memberLevel, int memberNo) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new MemberDao().changeLevel(conn,memberLevel,memberNo);
		JDBCTemplate.close(conn);
		return result;
	}

	public boolean changeAllLevel(String num, String level) {
		Connection conn = JDBCTemplate.getConnection();
		boolean result = true;
		StringTokenizer sT1 = new StringTokenizer(num, "/");
		StringTokenizer sT2 = new StringTokenizer(level, "/");
		while(sT1.hasMoreTokens()) {
			int memberLevel = Integer.parseInt(sT2.nextToken());
			int memberNo = Integer.parseInt(sT1.nextToken());
			System.out.println(memberLevel);
			System.out.println(memberNo);
			int result1 = new MemberDao().changeLevel(conn, memberLevel, memberNo);
			if(result1==0) {
//				업데이트가 안됐을때
				result = !result;
				break;
			}
		}
		if(result) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public ArrayList<Member> searchKeyword(String type, String keyword) {
		ArrayList<Member> list = null;
		Connection conn = JDBCTemplate.getConnection();
		if(type.equals("memberId")) {
			list = new MemberDao().searchKeywordId(conn,keyword);
		}else if(type.equals("memberName")) {
			list = new MemberDao().searchKeywordName(conn,keyword);
		}
		
		JDBCTemplate.commit(conn);
		return list;
	}

	public int deleteOneMember(String memberId) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new MemberDao().deleteOneMember(conn,memberId);
		JDBCTemplate.close(conn);
		return result;
	}

	public int updateOneMember(Member member) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new MemberDao().updateOneMember(conn, member);
		JDBCTemplate.close(conn);
		return result;
	}
	
}
