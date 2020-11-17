package notice.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import notice.model.vo.Notice;
import notice.model.vo.NoticeComment;

public class NoticeDao {

	public ArrayList<Notice> selectList(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Notice> list = new ArrayList<Notice>();
		String sql = "select * from notice order by 1 desc";
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				Notice n = new Notice();
				n = getNoticeFromrset(rset);
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

	private Notice getNoticeFromrset(ResultSet rset) {
		Notice n = new Notice();
		try {
			n.setNoticeNo(rset.getInt("notice_no"));
			n.setNoticeTitle(rset.getString("notice_title"));
			n.setNoticewriter(rset.getString("notice_writer"));
			n.setNoticeDate(rset.getString("notice_date"));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return n;
	}

	public int totalCount(Connection conn) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "select count(*) from notice";
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public ArrayList<Notice> selectList(Connection conn, int start, int end) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Notice> list = new ArrayList<Notice>();
		String sql = "select * from (select rownum as rnum, n.* from (select * from notice order by 1 desc)N) where rnum between ? and ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				Notice n = new Notice();
				n = getNoticeFromrset(rset);
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

	public int insertNotice(Connection conn, Notice n) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into notice values(notice_seq.nextval,?,?,?,to_char(sysdate,'yyyy-mm-dd'),?,?,default)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, n.getNoticeTitle());
			pstmt.setString(2, n.getNoticeWriter());
			pstmt.setString(3, n.getNoticeContent());
			pstmt.setString(4, n.getNoticeFileName());
			pstmt.setString(5, n.getNoticeFilePath());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public Notice selectOneNotice(Connection conn, int noticeNo) {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			Notice n = null;
			String query = "select * from notice where notice_no = ?";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, noticeNo);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					n = new Notice();
					n.setNoticeNo(rs.getInt("notice_no"));
					n.setNoticeTitle(rs.getString("notice_title"));
					n.setNoticewriter(rs.getString("notice_writer"));
					n.setNoticeContent(rs.getString("notice_content"));
					n.setNoticeDate(rs.getString("notice_date"));
					n.setNoticeFileName(rs.getString("filename"));
					n.setNoticeFilePath(rs.getString("filepath"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				JDBCTemplate.close(rs);
				JDBCTemplate.close(pstmt);
			}
			
			return n;
		
	}

	public int deleteOneNotice(Connection conn, int noticeNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "delete from notice where notice_no=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, noticeNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int updateNotice(Connection conn, Notice n) {
		int result = 0 ;
		PreparedStatement pstmt = null;
		String sql  = "update notice set notice_title=?, notice_content=?,filename=?,filepath=? where notice_no=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, n.getNoticeTitle());
			pstmt.setString(2, n.getNoticeContent());
			pstmt.setString(3, n.getNoticeFileName());
			pstmt.setString(4, n.getNoticeFilePath());
			pstmt.setInt(5, n.getNoticeNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int insertNoticeComment(Connection conn, NoticeComment nc) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = "insert into notice_Comment values(notice_comment_seq.nextval,?,?,?,?,?,to_char(sysdate,'yyyy-mm-dd'))";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, nc.getNoticeCommentLevel());
			pstmt.setString(2, nc.getNoticeCommentWriter());
			pstmt.setString(3, nc.getNoticeCommentContent());
			pstmt.setInt(4, nc.getNoticeRef());
			if(nc.getNoticeCommentRef() == 0) {
				pstmt.setString(5,  null);
			} else {
				pstmt.setInt(5,  nc.getNoticeCommentRef());
			}
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public ArrayList<NoticeComment> selectNoticeCommentList(Connection conn, int noticeNo) {
		ArrayList<NoticeComment> list = new ArrayList<NoticeComment>();
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		String sql = "select * from notice_comment where notice_ref=? order by 1";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, noticeNo);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				NoticeComment n = getNoticeCommentFromRset(rset);
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

	private NoticeComment getNoticeCommentFromRset(ResultSet rset) {
		NoticeComment comment = new NoticeComment();
		try {
			comment.setNoticeCommentNo(rset.getInt("notice_comment_no"));
			comment.setNoticeCommentLevel(rset.getInt("notice_comment_level"));
			comment.setNoticeCommentWriter(rset.getString("notice_comment_writer"));
			comment.setNoticeCommentContent(rset.getString("notice_comment_content"));
			comment.setNoticeCommentRef(rset.getInt("notice_comment_ref"));
			comment.setNoticeRef(rset.getInt("notice_ref"));
			comment.setNoticeCommentDate(rset.getString("notice_comment_date"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return comment;
	}

	public int updateNoticeComment(Connection conn, int noticeCommentNo, String noticeCommentContent) {
		PreparedStatement pstmt = null;
		int result =0;
		String sql = "update notice_comment set notice_comment_content=? where notice_comment_no=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, noticeCommentContent);
			pstmt.setInt(2, noticeCommentNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}


}
