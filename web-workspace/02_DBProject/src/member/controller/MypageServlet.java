package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.vo.Member;

/**
 * Servlet implementation class MypageServlet
 */
@WebServlet("/mypage")
public class MypageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MypageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		1. 인코딩
		request.setCharacterEncoding("utf-8");
//		2.
//		3.
//		4.
//		getssion 세션이 있으면 그 세션을 가져오고, 없으면 세션은 만들어온다
//		만약 매개변수로 false가 들어갈때, 만약 현재 세션이 없으면 null을 리턴한다.
		HttpSession session = request.getSession(false);
		Member member = null;
		if(session != null) {
			member = (Member)session.getAttribute("loginMember");
		}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html><head><title> </title></head><body>");
		if(member != null) {
			out.println("<fieldset>");
			out.println("<legend>회원정보</legend>");
			out.println("<form action='/updateMember' method='post'>");
			out.println("회원 번호 : <input type='text' name='memberNo' value='"+member.getMemberNo()+"' readonly><br>");
			out.println("회원 아이디 : <input type='text' name='memberNo' value='"+member.getMemberId()+"' readonly><br>");
			out.println("회원 비밀번호 : <input type='password' name='memberNo' value='"+member.getMemberPw()+"' readonly><br>");
			out.println("회원 이름 : <input type='text' name='memberNo' value='"+member.getEmail()+"' readonly><br>");
			out.println("회원 전화번호 : <input type='text' name='memberNo' value='"+member.getPhone()+"' readonly><br>");
			out.println("회원 성별 : <input type='text' name='memberNo' value='"+member.getGender()+"' readonly><br>");
			out.println("회원 가입일 : <input type='text' name='memberNo' value='"+member.getEnrollDate()+"' readonly><br>");
			out.println("<br>");
			out.println("<a href='/'>메인페이지로 이동</a>)");
			
			out.println("</form>");
			out.println("</fieldset>");
		} else {
			out.println("<script>");
			out.println("alert('로그인 후 이용 가능합니다.');");
			out.println("location.href='/views/loginFrm.html';");
			out.println("</script>");
		}
		out.println("</body></html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
