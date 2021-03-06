package member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.vo.Member;

/**
 * Servlet implementation class JstlIfServlet
 */
@WebServlet(name = "JstlForEach", urlPatterns = { "/jstlForEach" })
public class JstlForEachServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JstlForEachServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Member> list = new ArrayList<Member>();
		list.add(new member.model.vo.Member("이름 1 ", 21, "주소1"));
		list.add(new member.model.vo.Member("이름 2", 22, "주소2"));
		list.add(new member.model.vo.Member("이름 3 ", 23, "주소3"));
		
		RequestDispatcher rd = request.getRequestDispatcher("/jstl/jstForEach.jsp");
		request.setAttribute("list", list);
		
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
