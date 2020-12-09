package member.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import member.model.vo.Member;

public class MemberDao {
//
//	public Member loginMember(SqlSession session, Member m) {
//		return session.selectOne("member.loginMember", m);
//	}
//
//	public Member searchMember(SqlSession session, Member m) {
//		return session.selectOne("member.searchMember",m);
//	}

	public Member searchOneMember(SqlSession session, Member m) {
		return session.selectOne("member.searchOneMember",m);
	}

	public ArrayList<Member> selectAllMember(SqlSession session, HashMap<String, String> map) {
		List<Member> list = session.selectList("member.selectAllMember", map);
		return (ArrayList<Member>)list;
	}

}
