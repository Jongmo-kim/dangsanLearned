package member.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import member.model.vo.Member;

public class MemberDao {
	public boolean selectOneMember(Member member) {
		boolean isCorrect = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql  = " select * from membership where member_id=? and member_pw=?";
		ResultSet rset = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "webserver", "1234");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			System.out.println(member.getMemberId());
			System.out.println(member.getMemberPw());
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				isCorrect = !isCorrect;
				System.out.println(isCorrect);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
				pstmt.close();
			} catch(SQLException e) {
				
			}
		}
		return isCorrect;
		
	}
}
