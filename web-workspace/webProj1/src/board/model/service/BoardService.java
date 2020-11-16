package board.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import board.model.dao.BoardDao;
import board.model.vo.Board;
import board.model.vo.BoardPageData;
import common.JDBCTemplate;

public class BoardService {

	public ArrayList<Board> selectList() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Board> list = new BoardDao().selectList(conn);
		JDBCTemplate.close(conn);
		return list;
	}

	public BoardPageData selectList(int reqPage) {
		Connection conn = JDBCTemplate.getConnection();
		BoardDao dao = new BoardDao();
		int totalCount = dao.totalCount(conn);
		int numPerPage = 10;
		int totalPage = totalCount% numPerPage == 0 ? totalCount/numPerPage : totalCount/numPerPage+1;
		// reqPage = 1 -> start : 1, end : 10
		int start = (reqPage-1)*numPerPage +1;
		int end = reqPage*numPerPage;
		
		ArrayList<Board> list = dao.selectList(conn,start,end);

		//페이지 네비게이션 작성 시작
		int pageNaviSize = 5;
		String pageNavi = "";
//		페이지네비 시작번호 구하기
//		reqPage : 1~5 -> 1
		int pageNo = reqPage-2;
		if(reqPage<4) {
			pageNo = 1;
		}
//		이전버튼 : 페이지 시작번호가 1이 아닌경우에만 이전버튼 생성
		if(pageNo != -1) {
			pageNavi += "<a class='btn' href='/boardList?reqPage="+(pageNo-1)+"'>이전</a>";
		}
		for(int i = 0 ; i < pageNaviSize ; ++i) {
			if(pageNo <= 0) {
				--i;
				++pageNo;
				continue;
			}
			
				if(reqPage == pageNo) {
	//				현재페이지
					pageNavi += "<span class='selectPage btn btn-danger'>"+pageNo+"</span>";
				} else {
					pageNavi += "<a class='btn' href='/boardList?reqPage="+pageNo+"'>"+pageNo+"</a>";
				}
				++pageNo;
				if(pageNo > totalPage) {
					break;
				}
		}
		if(pageNo <= totalPage) {
			pageNavi += "<a class='btn' href='/boardList?reqPage="+pageNo+"'>다음</a>";
		}
		JDBCTemplate.close(conn);
		BoardPageData npd = new BoardPageData(list,pageNavi);
		return npd;
	}

	public Board selectOneBoard(int boardNo) {
		Connection conn = JDBCTemplate.getConnection();
		Board board = new BoardDao().selectOneBoard(conn, boardNo);
		JDBCTemplate.close(conn);
		return board;
	}

	public int insertBoard(Board board) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new BoardDao().insertBoard(conn, board);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
	}

	public int updateBoard(Board board) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new BoardDao().updateBoard(conn,board);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int deleteBoard(int boardNo) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new BoardDao().deleteBoard(conn,boardNo);
		if(result >  0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
}
