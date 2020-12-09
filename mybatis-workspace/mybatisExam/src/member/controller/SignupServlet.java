package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;

/**
 * Servlet implementation class SignupServlet
 */
@WebServlet(name = "Signup", urlPatterns = { "/signup" })
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String inputId =request.getParameter("memberId");
		String inputPw = request.getParameter("memberPw");
		String inputName = request.getParameter("memberName");
		String inputaddr = request.getParameter("addr");
		String inputage = request.getParameter("age");
		int result = new MemberService().insertMember(inputId,inputPw,inputName,inputaddr,inputage);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/msg.jsp");
		if(result > 0 ) {
			request.setAttribute("loc", "/");
			request.setAttribute("msg", "가입 성공");
		} else {
			request.setAttribute("loc", "/");
			request.setAttribute("msg", "가입 실패");
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
