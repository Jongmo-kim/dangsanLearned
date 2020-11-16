package board.controller;

import java.io.File;
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
 * Servlet implementation class BoardUpdateServlet
 */
@WebServlet(name = "boardUpdate", urlPatterns = { "/boardUpdate" })
public class BoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		if(!ServletFileUpload.isMultipartContent(request)) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			request.setAttribute("msg", "공지사항 수정 오류[enctype");
			request.setAttribute("loc", "/");
			rd.forward(request, response);
			return;
		}
		String root = getServletContext().getRealPath("/");
		String saveDir = root + "upload/board";
		int maxSize = 10*1024*1024;
		MultipartRequest mRequest = new MultipartRequest(request, saveDir, maxSize,"utf-8",new DefaultFileRenamePolicy());
		Board board = new Board();
		board.setBoardNo(Integer.parseInt(mRequest.getParameter("boardNo")));
		board.setBoardTitle(mRequest.getParameter("boardTitle"));
		board.setBoardContent(mRequest.getParameter("boardContent"));
		board.setBoardFileName(mRequest.getOriginalFileName("filename"));
		board.setBoardFilePath(mRequest.getFilesystemName("filename"));
		
		String oldFilename = mRequest.getParameter("oldFilename");
		String oldFilepath = mRequest.getParameter("oldFilepath");
		String status = mRequest.getParameter("status");
		
		File f = mRequest.getFile("filename");
		if(f!=null && f.length() > 0) {
			if(status.equals("delete")) {
				File delFile = new File(saveDir+"/"+oldFilepath);
				boolean isDeleted = delFile.delete();
				System.out.println(isDeleted ? "삭제성공" : "삭제실패");
			}
		} else {
			if(status.equals("delete")) {
				File delFile = new File(saveDir+"/" + oldFilepath);
				boolean isDeleted = delFile.delete();
				System.out.println(isDeleted ? "삭제성공" : "삭제실패");
			} else if ( status.equals("stay")) {
				board.setBoardFileName(oldFilename);
				board.setBoardFilePath(oldFilepath);
			}
		}
		int result = new BoardService().updateBoard(board);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result>0) {
			request.setAttribute("msg", "자유게시글 수정완료");
		} else {
			request.setAttribute("msg", "자유게시글 수정실패");
		}
		request.setAttribute("loc", "/boardView?boardNo="+board.getBoardNo());
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
