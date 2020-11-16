package board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import board.model.vo.Board;
import common.JDBCTemplate;

public class BoardDao {

	public ArrayList<Board> selectList(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Board> list = new ArrayList<Board>();
		String sql = "select * from Board order by 1 desc";
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Board n = new Board();
				n = getBoardFromrset(rset);
				list.add(n);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}

	private Board getBoardFromrset(ResultSet rset) {
		Board n = new Board();
		try {
			n.setBoardNo(rset.getInt("Board_no"));
			n.setBoardTitle(rset.getString("Board_title"));
			n.setBoardwriter(rset.getString("Board_writer"));
			n.setBoardDate(rset.getString("Board_date"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return n;
	}

	public int totalCount(Connection conn) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "select count(*) from Board";
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public ArrayList<Board> selectList(Connection conn, int start, int end) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Board> list = new ArrayList<Board>();
		String sql = "select * from (select rownum as rnum, N.* from (select * from Board order by 1 desc)N) where rnum between ? and ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Board n = new Board();
				n = getBoardFromrset(rset);
				list.add(n);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}

	public Board selectOneBoard(Connection conn, int boardNo) {
		Board board = null;
		PreparedStatement pstmt = null;
		ResultSet rset =null;
		String sql = "select * from Board where board_No = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				board = getBoardFromRset(rset);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return board;
	}

	private Board getBoardFromRset(ResultSet rset) {
		Board board = new Board();
		try {
			board.setBoardNo(rset.getInt("Board_no"));
			board.setBoardTitle(rset.getString("Board_Title"));
			board.setBoardwriter(rset.getString("Board_writer"));
			board.setBoardContent(rset.getString("Board_content"));
			board.setBoardDate(rset.getString("Board_date"));
			board.setBoardFileName(rset.getString("filename"));
			board.setBoardFilePath(rset.getString("filepath"));
			board.setBoardStatus(rset.getInt("status"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return board;
	}

	public int insertBoard(Connection conn, Board board) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = "insert into board values(board_seq.nextval,?,?,?,to_char(sysdate,'yyyy-mm-dd'),?,?,default)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getBoardTitle());
			pstmt.setString(2, board.getBoardwriter());
			pstmt.setString(3, board.getBoardContent());
			pstmt.setString(4, board.getBoardFileName());
			pstmt.setString(5, board.getBoardFilePath());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
}
