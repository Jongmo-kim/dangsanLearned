package member.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import common.SqlSessionTemplate;
import member.model.dao.MemberDao;
import member.model.vo.Member;

public class MemberService {

	public Member selectOneMember(String inputId, String inputPw) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		Member m = new MemberDao().selectOneMember(session,inputId,inputPw);
		session.close();
		return m;
	}

	public int updateMember(int memberNo, String inputPw, String inputAddr) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = new MemberDao().updateMember(session,memberNo,inputPw,inputAddr);
		if(result > 0 ) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return result;
	}

	public ArrayList<Member> selectAll() {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		ArrayList<Member> list = new MemberDao().selectAllMember(session);
		session.close();
		return list;
	}

	public int insertMember(String inputId, String inputPw, String inputName, String inputaddr, String inputage) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = new MemberDao().insertOneMember(session,inputId,inputPw,inputName,inputaddr,inputage);
		if(result > 0 ) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return result;
	}

	public int deleteMember(int memberNo) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = new MemberDao().deleteOneMember(session,memberNo);
		if(result > 0 ) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return result;
	}

}
