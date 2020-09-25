package kh.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTemplate {
//	데이터 베이스중 중복부분처리
//	1. 드라이버 등록, Connection 객체 생성
//	2. Connection close
//	3. commit, rollback
//	Singleton Pattern 
//	클래스에 대한 객체가 프로그램 구동내내 한개만 작성되어
//	모두 공유하여 사용하는 디자인 패턴
	public static Connection getConnection() {
		Connection conn = null;
//		현재 sql 실행시 자동으로 commit되는
//		auto commit이 설정 되어 있으므로 이를 헤제한다
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc", "1234");
			conn.setAutoCommit(false); // 자동커밋 비활성화
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}

	public static void close(Connection conn) {
		try {
			if (conn != null && conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

//  preparedstatment 는 statement를 상속해서 preparedstmt는 그냥 사용할수있음
	public static void close(Statement stmt) {
		try {
			if (stmt != null && stmt.isClosed()) {
				stmt.close();
			}

		} catch (SQLException e) {

		}

	}

	public static void commit(Connection conn) {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void rollback(Connection conn) {

		try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public static  void close(ResultSet rset) {
		try {
			if (rset != null && rset.isClosed()) {
				rset.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
