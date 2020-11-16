package board.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;
import board.model.vo.Board;

/**
 * Servlet implementation class BoardDeleteServlet
 */
@WebServlet(name = "boardDelete", urlPatterns = { "/boardDelete" })
public class BoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		Board board = new BoardService().selectOneBoard(boardNo);
		int result = new BoardService().deleteBoard(boardNo);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result > 0) {
			if(board.getBoardFileName() != null) {
				String root = getServletContext().getRealPath("/");
				String SaveDir = root + "upload/board";
				File delFile = new File(root+"/"+SaveDir);
				boolean isDeleted = delFile.delete();
				System.out.println(isDeleted ? "파일 삭제 완료" : "파일 삭제 실패");
			}
			request.setAttribute("msg", "삭제 성공");
			request.setAttribute("loc", "/boardList?reqPage=1");
		} else {
			request.setAttribute("msg", "삭제 실패");
			request.setAttribute("loc", "/boardView?boardNo="+boardNo);
		}
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
