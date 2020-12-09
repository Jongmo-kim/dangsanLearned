package board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import board.model.service.BoardService;
import board.model.vo.Board;

/**
 * Servlet implementation class InsertBoardServlet
 */
@WebServlet(name = "insertBoard", urlPatterns = { "/insertBoard" })
public class InsertBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertBoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		if (!ServletFileUpload.isMultipartContent(request)) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			request.setAttribute("msg", "자유게시판 작성 오류 [enctype]");
			request.setAttribute("loc", "/");
			rd.forward(request, response);
			return;
		}
		String root = getServletContext().getRealPath("/");
		String saveDir = root + "upload/board";
		int maxSize = 1024 * 1024 * 10;
		MultipartRequest mRequest = new MultipartRequest(request, saveDir, maxSize, "utf-8",new DefaultFileRenamePolicy());
		Board board = new Board();
		board.setBoardContent(mRequest.getParameter("boardContent"));
		board.setBoardwriter(mRequest.getParameter("boardWriter"));
		board.setBoardTitle(mRequest.getParameter("boardTitle"));
		board.setBoardFileName(mRequest.getOriginalFileName("filename"));
		board.setBoardFilePath(mRequest.getFilesystemName("filename"));
		//초기화
		
		int result = new BoardService().insertBoard(board);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result > 0) {
			request.setAttribute("msg", "자유게시글 등록 성공");
		} else {
			request.setAttribute("msg", "자유게시글 등록 실패");
		}
		request.setAttribute("loc", "/boardList?reqPage=1");
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
