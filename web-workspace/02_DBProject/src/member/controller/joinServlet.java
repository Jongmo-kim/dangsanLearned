package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.dao.MemberDao;
import member.model.vo.Member;

/**
 * Servlet implementation class joinServlet
 */
@WebServlet({ "/joinServlet", "/join" })
public class joinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public joinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		1. 인코딩
		request.setCharacterEncoding("utf-8");
//		2. view에서 넘어온 데이터저장
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		String memberName = request.getParameter("memberName");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		Member member = new Member(0, memberId, memberPw, memberName, phone, email, gender, null);
//		3. 비지니스 로직
		int result = new MemberDao().insertMember(member);
//		4. 결과처리
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		
		out.println("<!DOCTYPE html>");
		out.println("<html><head><title>회원가입 결과</title></head><body>");
//		알림창 - > 성공/실패 여부
		out.println("<script>");
		if(result>0) {
			out.println("alert('회원가입 성공');");
		} else {
			out.println("alert('회원가입 실패');");
		}
		out.println("location.href='/'");
		out.println("</script>");
		
//		메인페이지로 이동 ->  강제이동
		
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
