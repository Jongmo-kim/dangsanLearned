package notice.controller;

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

import notice.model.service.NoticeService;
import notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeUpdateServlet
 */
@WebServlet(name = "noticeUpdate", urlPatterns = { "/noticeUpdate" })
public class NoticeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeUpdateServlet() {
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
			request.setAttribute("msg", "공지사항 수정 오류[enctype]");
			request.setAttribute("loc", "/");
			rd.forward(request, response);
			return;
		}
		String root = getServletContext().getRealPath("/");
		String saveDir = root + "upload/notice";
		
		int maxSize = 10*1024*1024;
		MultipartRequest mRequest = new MultipartRequest(request,saveDir,maxSize,"UTF-8",new DefaultFileRenamePolicy());
		Notice n = new Notice();
		n.setNoticeNo(Integer.parseInt(mRequest.getParameter("noticeNo")));
		n.setNoticeTitle(mRequest.getParameter("noticeTitle"));
		n.setNoticeContent(mRequest.getParameter("noticeContent"));
		n.setNoticeFileName(mRequest.getOriginalFileName("filename"));
		n.setNoticeFilePath(mRequest.getFilesystemName("filename"));
		//추가항목
//		기존파일 이름 및 경로
		String oldFilename = mRequest.getParameter("oldFilename");
		String oldFilepath = mRequest.getParameter("oldFilepath");
		String status = mRequest.getParameter("status");
//		현재 첨부파일 확인
		File f = mRequest.getFile("filename");
		if(f!=null && f.length()> 0) {//새로운 첨부파일이 있는 경우
			if(status.equals("delete")) { // 기존 첨부파일 삭제
				File delFile = new File(saveDir+"/"+oldFilepath);
				System.out.println(delFile.getPath());
				boolean isDeleted = delFile.delete();
				System.out.println(isDeleted ?"삭제성공": "삭제실패");
			}
		} else { //새 첨부파일이 없는경우
			if(status.equals("delete")) {
				File delFile = new File(saveDir+"/"+oldFilepath);
				boolean isDeleted = delFile.delete();
				System.out.println(isDeleted ?"삭제성공": "삭제실패");
			} else if (status.equals("stay")) {
				n.setNoticeFileName(oldFilename);
				n.setNoticeFilePath(oldFilepath);
			}
		}
		
		int result = new NoticeService().updateNotice(n);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result>0) {
			request.setAttribute("msg", "공지사항 수정 완료");
		} else {
			request.setAttribute("msg", "공지사항 수정 실패");
		}
		request.setAttribute("loc", "/noticeView?noticeNo="+n.getNoticeNo());
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
