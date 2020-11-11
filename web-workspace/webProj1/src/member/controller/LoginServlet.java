package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		1.인코딩
		request.setCharacterEncoding("utf-8");
		
//		2.view에서 넘어온 값 저장
		Member member = new Member();
		member.setMemberId(request.getParameter("memberId"));
		member.setMemberPw(request.getParameter("memberPw"));
//		3. 비지니스 로직
		Member loginMember = new MemberService().selectOneMember(member);
//		4.결과처리
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		request.setAttribute("loc","/");
		
		if(loginMember != null) {
//			로그인 성공한 경우
			if(loginMember.getMemberLevel()==3) {
				request.setAttribute("msg", "로그인 권한이 없습니다 관리자에게 문의하세요.");
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("member", loginMember);
				request.setAttribute("msg", "로그인 성공");
			}
		} else {
//			로그인 실패한 경우
			request.setAttribute("loc","/views/member/login.jsp");
			request.setAttribute("msg", "아이디 또는 비밀번호를 확인하세요");
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
