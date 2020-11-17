package notice.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import notice.model.dao.NoticeDao;
import notice.model.vo.Notice;
import notice.model.vo.NoticeComment;
import notice.model.vo.NoticePageData;
import notice.model.vo.NoticeViewData;

public class NoticeService {

	public ArrayList<Notice> selectList() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Notice> list = new NoticeDao().selectList(conn);
		JDBCTemplate.close(conn);
		return list;
	}

	public int insertNotice(Notice n) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new NoticeDao().insertNotice(conn, n);
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		return result;
	}
	public Notice selectOneNotice(int noticeNo) {
		Connection conn = JDBCTemplate.getConnection();
		Notice n = new NoticeDao().selectOneNotice(conn,noticeNo);
		JDBCTemplate.close(conn);
		return n;
	}
	public NoticePageData selectList(int reqPage) {
		Connection conn = JDBCTemplate.getConnection();
		NoticeDao dao = new NoticeDao();
		int totalCount = dao.totalCount(conn);
		int numPerPage = 10;
		int totalPage = totalCount % numPerPage == 0 ? totalCount / numPerPage : totalCount / numPerPage + 1;
		// reqPage = 1 -> start : 1, end : 10
		int start = (reqPage - 1) * numPerPage + 1;
		int end = reqPage * numPerPage;
		ArrayList<Notice> list = dao.selectList(conn, start, end);

		// 페이지 네비게이션 작성 시작
		int pageNaviSize = 5;
		String pageNavi = "";
		// 페이지네비 시작번호 구하기
		// reqPage : 1~5 -> 1
		int pageNo = ((reqPage - 1) / pageNaviSize) * pageNaviSize + 1;
		// 이전버튼 : 페이지 시작번호가 1이 아닌경우에만 이전버튼 생성
		if (pageNo != 1) {
			pageNavi += "<a class='btn' href='/noticeList?reqPage=" + (pageNo - 1) + "'>이전</a>";
		}

		for (int i = 0; i < pageNaviSize; ++i) {
			if (reqPage == pageNo) {
				// 현재페이지
				pageNavi += "<span class='selectPage'>" + pageNo + "</span>";
			} else {
				pageNavi += "<a class='btn' href='/noticeList?reqPage=" + pageNo + "'>" + pageNo + "</a>";
			}
			++pageNo;
			if (pageNo > totalPage) {
				break;
			}
		}
		if (pageNo <= totalPage) {
			pageNavi += "<a class='btn' href='/noticeList?reqPage=" + pageNo + "'>다음</a>";
		}
		JDBCTemplate.close(conn);
		NoticePageData npd = new NoticePageData(list, pageNavi);
		return npd;
	}

	public int deleteOneNotice(int noticeNo) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new NoticeDao().deleteOneNotice(conn,noticeNo);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int updateNotice(Notice n) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new NoticeDao().updateNotice(conn,n);
		if(result>0) {
			JDBCTemplate.commit(conn);
		} else { 
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int insertNoticeComment(NoticeComment nc) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new NoticeDao().insertNoticeComment(conn,nc);
		if(result>0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public NoticeViewData selectNoticeView(int noticeNo) {
		Connection conn = JDBCTemplate.getConnection();
		Notice n = new NoticeDao().selectOneNotice(conn, noticeNo);
		ArrayList<NoticeComment> list = new NoticeDao().selectNoticeCommentList(conn,noticeNo);
		JDBCTemplate.close(conn);
		NoticeViewData nvd = new NoticeViewData(n, list);
		return nvd;
	}

	public int updateNoticeComment(int noticeCommentNo, String noticeCommentContent) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new NoticeDao().updateNoticeComment(conn,noticeCommentNo,noticeCommentContent);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}


}
