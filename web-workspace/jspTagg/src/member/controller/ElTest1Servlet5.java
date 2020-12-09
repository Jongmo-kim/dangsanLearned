package member.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.vo.Member;

/**
 * Servlet implementation class ElTest1Servlet
 */
@WebServlet(name = "ElTest5", urlPatterns = { "/elTest5" })
public class ElTest1Servlet5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ElTest1Servlet5() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member m1 =  new Member("이윤수", 20, "서울");
		Member m2 =  new Member("이윤소", 30, "서울");
		Member m3 =  new Member("이윤중", 40, "서울");
		Member m4 =  new Member("이윤대", 50, "서울");
		HttpSession session = request.getSession();
		RequestDispatcher rd = request.getRequestDispatcher("/el/elTest5.jsp");
		request.setAttribute("m1", m1);
		request.setAttribute("m2", m2);
		session.setAttribute("m3", m3);
		session.setAttribute("m4", m4);
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

