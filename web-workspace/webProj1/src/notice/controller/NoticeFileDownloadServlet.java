package notice.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NoticeFileDownloadServlet
 */
@WebServlet("/noticeFileDownload")
public class NoticeFileDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeFileDownloadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String filename = request.getParameter("filename");
		String filepath = request.getParameter("filepath");
		
		String root = getServletContext().getRealPath("/");
		String saveDir = root + "upload/notice/";
//		파일과 현재 서블릿 연결
		FileInputStream fis = new FileInputStream(saveDir + filepath);
		BufferedInputStream bis = new BufferedInputStream(fis);
//		읽어온 파일을 사용자에게 전달하기위한 객체 생성
		ServletOutputStream sos = response.getOutputStream();
		BufferedOutputStream bos = new BufferedOutputStream(sos);
//		브라우저 종류에 따라 파일명을 변경해주는 로직
//		브라우저가 IE인지 판단

		String resFilename = "";
		boolean bool = request.getHeader("user-agent").indexOf("MSIE") != -1 ||
				request.getHeader("user-agent").indexOf("Trident") != -1;
		
		if(bool) {
			resFilename = URLEncoder.encode(filename,"UTF-8");
			resFilename = resFilename.replaceAll("\\\\", "%20");
		} else {
			resFilename = new String(filename.getBytes("UTF-8"),"ISO-8859-1");
		}
//		파일 다운로드를 위한 HTTP Header 설정
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment;filename="+resFilename);
//		파일전송
		int read = -1;
		while( ( read=bis.read())!= -1) {
			bos.write(read);
		}
		bos.close();
		bis.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
