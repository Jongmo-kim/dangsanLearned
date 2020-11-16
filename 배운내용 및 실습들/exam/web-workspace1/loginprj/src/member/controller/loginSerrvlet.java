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
 * Servlet implementation class loginSerrvlet
 */
@WebServlet("/login")
public class loginSerrvlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public loginSerrvlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		1. 인코딩
		request.setCharacterEncoding("utf-8");
//		2. view에서 넘어온 데이터 저장
		Member member = new Member();
		member.setMemberId(request.getParameter("memberId"));
		member.setMemberPw(request.getParameter("memberPw"));
//		3. 비지니스 로직
		boolean loginMember = new MemberDao().selectOneMember(member);
		
//		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html><head><title</title></head><body>");
		out.println("<script>");	
		if(loginMember == false) {
			out.println("alert('아이디 또는 비밀번호를 확인해주세요');");
			out.println("location.href='/';");
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("loginMember", loginMember);
			out.println("alert('로그인 성공');");
			out.println("location.href='/';");
		}
		out.println("</script>");
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
