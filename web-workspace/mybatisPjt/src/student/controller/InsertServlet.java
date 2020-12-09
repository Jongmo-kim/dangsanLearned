package student.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.model.service.StudentService;
import student.model.vo.student;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet(name = "Insert", urlPatterns = { "/insert" })
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		student s = new student();
		s.setAddr(request.getParameter("addr"));		
		s.setEmail(request.getParameter("email"));		
		s.setStudentName(request.getParameter("studentName"));	
		s.setStudentPhone(request.getParameter("studentPhone"));
		
		int result = new StudentService().insert(s);
		RequestDispatcher rd = request.getRequestDispatcher("/view/msg.jsp");
		if(result>0) {
			request.setAttribute("msg", "등록성공");
		} else {
			request.setAttribute("msg", "등록실패");
		}
		request.setAttribute("loc", "/");
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
