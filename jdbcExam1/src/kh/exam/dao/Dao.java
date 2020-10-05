package kh.exam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import kh.exam.vo.Memo;
public class Dao {
	public ArrayList<Memo> selectAll() {
		ArrayList<Memo> list = new ArrayList<Memo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from memo";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "oracleuser", "pwd1234");
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery(query);
			while(rset.next()) {
				Memo m = new Memo();
				m.setNo(rset.getInt(1));
				m.setName(rset.getString(2));
				m.setMsg(rset.getString(3));
				m.setWriteday(rset.getDate(4));
				list.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				rset.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}