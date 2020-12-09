package student.model.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import common.SqlSessionTemplate;
import student.model.dao.StudentDao;
import student.model.vo.student;

public class StudentService {

	public int insert(student s) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = new StudentDao().insert(session,s);
		if(result>0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return result;
	}

	public student searchStudent(int studentNo) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		student s = new StudentDao().searchStudent(session, studentNo);
		session.close();
		return s;
	}

	public ArrayList<student> searchAllStudent() {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		ArrayList<student> s = new StudentDao().searchStudent(session);
		session.close();
		return s;
	}

	public int deleteStudent(int studentNo) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = new StudentDao().deleteStudent(session, studentNo);
		if(result>0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return result;
	}

	public int updateStudent(student s) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = new StudentDao().updateStudent(session, s);
		if(result>0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return result;
	}

}
