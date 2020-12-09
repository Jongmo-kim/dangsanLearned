package member.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import member.model.vo.Member;

public class MemberDao {

	public Member selectOneMember(SqlSession session, String inputId, String inputPw) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("inputId", inputId);
		map.put("inputPw", inputPw);
		return session.selectOne("mem.loginMember", map);
	}

	public int updateMember(SqlSession session, int memberNo, String inputPw, String inputAddr) {
		HashMap<String,Object> map = new HashMap<String, Object>();
		map.put("pw", inputPw);
		map.put("addr", inputAddr);
		map.put("no", memberNo);
		return session.update("mem.updateMember", map);
	}

	public ArrayList<Member> selectAllMember(SqlSession session) {
		java.util.List<Member> list = session.selectList("mem.selectAll");
		return (ArrayList<Member>)list;
	}

	public int insertOneMember(SqlSession session, String inputId, String inputPw, String inputName, String inputaddr,
			String inputage) {
		HashMap<String,Object> map = new HashMap<String, Object>();
		map.put("id", inputId);
		map.put("pw", inputPw);
		map.put("name", inputName);
		map.put("addr", inputaddr);
		map.put("age", inputage);
		return session.insert("mem.insertMember", map);
	}

	public int deleteOneMember(SqlSession session, int memberNo) {
		return session.delete("mem.deleteMember",memberNo);
	}
}
