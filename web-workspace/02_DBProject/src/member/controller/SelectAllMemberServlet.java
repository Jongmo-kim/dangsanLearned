package member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.dao.MemberDao;
import member.model.vo.Member;

/**
 * Servlet implementation class SelectAllMemberServlet
 */
@WebServlet("/selectAllMember")
public class SelectAllMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectAllMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		1. 인코딩
		request.setCharacterEncoding("utf-8");
//		2. view에서 보내준 데이터 저장
		
//		3. 비지니스 로직처리
		ArrayList<Member> list = new MemberDao().selectAllMember();
//		4. 결과처리
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html><head><title> </title></head><body>");
		out.println("<table>");

		out.println("<tr>");
		out.println("<th>");
		out.println("번호");
		out.println("</th>");

		out.println("<th>");
		out.println("아이디");
		out.println("</th>");
		

		out.println("<th>");
		out.println("비밀번호");
		out.println("</th>");
		

		out.println("<th>");
		out.println("이름");
		out.println("</th>");
		

		out.println("<th>");
		out.println("전화번호");
		out.println("</th>");
		

		out.println("<th>");
		out.println("이메일");
		out.println("</th>");

		out.println("<th>");
		out.println("성별");
		out.println("</th>");
		
		out.println("<th>");
		out.println("가입일");
		out.println("</th>");
		
		out.println("</tr>");
		
		for(Member m : list) {
			out.println("<tr>");
			out.println(m.toMemberThTag());
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("</body></html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
