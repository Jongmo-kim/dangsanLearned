package ajax.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;

public class AjaxDao {

	public ArrayList<String> selectAddr(String sel) {
		Connection conn = JDBCTemplate.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<String> list = new ArrayList<String>();
		String sql = "select addr2 from addr where addr1 = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sel);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				String addr = rset.getString("addr2");
				list.add(addr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(conn);
		}
	
		return list;
	}
	
}
