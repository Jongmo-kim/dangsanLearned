package student.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import student.model.vo.student;

public class StudentDao {

	public int insert(SqlSession session, student s) {
		return session.insert("stu.insertStudent",s);
	}

	public student searchStudent(SqlSession session, int studentNo) {
		return session.selectOne("stu.searchStudent",studentNo);
	}

	public ArrayList<student> searchStudent(SqlSession session) {
		List<student> list = session.selectList("stu.searchAllStudent"); 
		return (ArrayList<student>)list; 
	}

	public int deleteStudent(SqlSession session, int studentNo) {
		return session.delete("stu.deleteStudent",studentNo);
	}

	public int updateStudent(SqlSession session, student s) {
		return session.update("stu.updateStudent", s);
	}

}
