package kh.exam.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import kh.exam.model.vo.Board;
import kh.exam.model.vo.Member;

public class ExamDao {
////////////코드 줄이기용////////////코드 줄이기용////////////코드 줄이기용
	private void commitOrRollback(Connection conn, int result) {
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
	}
	private Board getBoard(ResultSet rset) {
		int boardNo = 0;
		String boardTitle = "";
		String boardContent = "";
		String boardWriter = "";
		int readCount = 0;
		Date writeDate = null;

		try {
			boardNo = rset.getInt(1);
			boardTitle = rset.getString(2);
			boardContent = rset.getString(3);
			boardWriter = rset.getString(4);
			if(boardWriter == null) {
				boardWriter = "탈퇴회원";
			}
			readCount = rset.getInt(5);
			writeDate = rset.getDate(6);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new Board(boardNo, boardTitle, boardContent, boardWriter, readCount, writeDate);
	}

	private Member getMember(ResultSet rset) {
		int memberNo = 0;
		String memberId = "";
		String memberPw = "";
		String memberName = "";
		String phone = "";
		try {
			memberNo = rset.getInt(1);
			memberId = rset.getString(2);
			memberPw = rset.getString(3);
			memberName = rset.getString(4);
			phone = rset.getString(5);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new Member(memberNo, memberId, memberPw, memberName, phone);

	}
////////////코드 줄이기용////////////코드 줄이기용////////////코드 줄이기용////////////코드 줄이기용////////////코드 줄이기용
	public int insertMember(Connection conn, String memberId, String memberPw, String memberName, String phone) {
		int result = 0;
		String sql = "insert into exam_member values (exam_member_seq.nextval,?,?,?,?)";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, memberId);
			pstmt.setString(2, memberPw);
			pstmt.setString(3, memberName);
			pstmt.setString(4, phone);
			result = pstmt.executeUpdate();

			commitOrRollback(conn, result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public Member loginMember(Connection conn, String memberId, String memberPw) {

		Member m = null;
		String sql = "select * from exam_member where member_id = ? and member_pw = ?";
		try {

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberPw);

			ResultSet rset = pstmt.executeQuery();
			if (rset.next())
				m = getMember(rset);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return m;
	}

	public Member findId(Connection conn, String memberId, String phone) {
		Member m = null;
		String sql = "select * from exam_member where member_id = ? and phone =?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			pstmt.setString(2, phone);

			ResultSet rset = pstmt.executeQuery();
			if (rset.next())
				m = getMember(rset);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return m;
	}

	public ArrayList<Board> getAllBoard(Connection conn) {
		String sql = "select * from exam_board";
		ArrayList<Board> list = new ArrayList<Board>();
		ResultSet rset = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				list.add(getBoard(rset));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}
	public Board openBoard(Connection conn,int boardNo) {
		String sql = "select * from exam_board where board_No = ?";
		ResultSet rset = null;
		Board b = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			rset = pstmt.executeQuery();
			if(rset.next()) b = getBoard(rset);
			
			if(incresementHit(conn, boardNo) == 0) System.out.println("조회수 올리기 실패");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}
	public int incresementHit(Connection conn,int boardNo) {
		String sql = "update exam_board set read_count = read_count + 1";
		int result = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			result = pstmt.executeUpdate();
			commitOrRollback(conn, result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public int insertBoard(Connection conn, String boardTitle, String boardContent,String boardWriter) {
		int result =0;
		String sql = "insert into exam_board values(exam_board_seq.nextval,?,?,?,default,default)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardTitle);
			pstmt.setString(2, boardContent);
			pstmt.setString(3, boardWriter);
			result = pstmt.executeUpdate();
			commitOrRollback(conn, result);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return result;
	}
	public int updateBoard(Connection conn, String boardTitle, String boardContent, int boardNo) {
		String sql = "update exam_board set board_title = ?, board_content = ? where board_no = ?";
		int result = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardTitle);
			pstmt.setString(2, boardContent);
			pstmt.setInt(3, boardNo);
			
			result = pstmt.executeUpdate();
			commitOrRollback(conn, result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	public int deleteBoard(Connection conn, int boardNo) {
		String sql = "delete from exam_board where board_no = ?";
		int result = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			result = pstmt.executeUpdate();
			commitOrRollback(conn, result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return result;
	}
	public int updateMember(Connection conn, String memberPw, String phone, int memberNo) {
		String sql = "update exam_member set member_pw = ?,phone = ? where member_no = ?";
		int result =0;
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberPw);
			pstmt.setString(2, phone);
			pstmt.setInt(3, memberNo);
			result = pstmt.executeUpdate();
			commitOrRollback(conn, result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public int deleteMember(Connection conn, int memberNo) {
		String sql = "delete from exam_member where member_no = ?";
		int result = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNo);
			result = pstmt.executeUpdate();
			commitOrRollback(conn, result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
