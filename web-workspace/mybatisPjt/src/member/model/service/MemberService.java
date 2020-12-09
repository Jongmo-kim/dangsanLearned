package member.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import common.SqlSessionTemplate;
import member.model.dao.MemberDao;
import member.model.vo.Member;

public class MemberService {

//	public Member loginMember(Member m) {
//		SqlSession session = SqlSessionTemplate.getSqlSession();
//		Member login = new MemberDao().loginMember(session,m);
//		session.close();
//		return login;
//	}
//
//	public Member searchMember(Member m) {
//		SqlSession session = SqlSessionTemplate.getSqlSession();
//		Member login = new MemberDao().searchMember(session,m);
//		session.close();
//		return login;
//	}

	public Member selectOneMember(Member m) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		Member login = new MemberDao().searchOneMember(session,m);
		session.close();
		return login;
	}

	public ArrayList<Member> selectAllMember(String chkPw, String chkName) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("chkPw", chkPw);
		map.put("chkName", chkName);
		ArrayList<Member> list = new MemberDao().selectAllMember(session,map);
		return list;
	}

}
