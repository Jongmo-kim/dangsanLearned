package photo.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import common.JDBCTemplate;
import photo.model.vo.Photo;

import java.sql.SQLException;
import java.util.ArrayList;

public class PhotoDao {

	public int totalCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int totalCount = 0;
		String sql = "select count(*) cnt from photo";
		try { 
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				totalCount = rset.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return totalCount;
	}

	public int insertPhoto(Connection conn, Photo p) {
		int result = 0;
		String sql = "insert into photo values(photo_seq.nextval,?,?,?,to_char(sysdate,'yyyy-mm-dd'),0)";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p.getPhotoWriter());
			pstmt.setString(2, p.getPhotoContent());
			pstmt.setString(3, p.getFilepath());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public ArrayList<Photo> photoMore(Connection conn, int start, int end) {
		ArrayList<Photo> list = new ArrayList<Photo>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "select * from (select rownum as rnum,p.* from photo order by 1 desc)p) where rnum between ? and ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Photo p = new Photo();
				p.setPhotoNo(rset.getInt("photo_no"));
				p.setPhotoWriter(rset.getString("photo_writer"));
				p.setPhotoContent(rset.getString("content"));
				p.setFilepath(rset.getString("filepath"));
				p.setPhotoDate(rset.getString("photo_date"));
				p.setReadCount(rset.getInt("read_count"));
				list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	
}
