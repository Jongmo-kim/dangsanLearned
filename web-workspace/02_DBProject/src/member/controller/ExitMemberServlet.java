package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.dao.MemberDao;
import member.model.vo.Member;

/**
 * Servlet implementation class ExitMemberServlet
 */
@WebServlet("/exitMember")
public class ExitMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExitMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		1.인코딩 설정
		request.setCharacterEncoding("utf-8");
//		2.view 데이터 저장
		
//		3. 비지니스 로직
		HttpSession session = request.getSession(false);
		int result = 0;
		if(session != null) {
			result = new MemberDao().deleteOneMember((Member)session.getAttribute("loginMember"));
		}
//		4.결과처리
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		if(session == null) {
			out.println("alert('로그인이 되지 않았습니다.');");
			out.println("location.href='/';");
		} else if(result == 1){
			session.invalidate();
			out.println("alert('회원 탈퇴 성공');");
			out.println("location.href='/';");
		} else {
			out.println("alert('회원 탈퇴 실패');");
			out.println("location.href='/';");
			
		}
		out.println("</script>");
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
