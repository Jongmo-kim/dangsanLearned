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
 * Servlet implementation class UpdateStudentServlet
 */
@WebServlet(name = "UpdateStudent", urlPatterns = { "/updateStudent" })
public class UpdateStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int studentNo = Integer.parseInt(request.getParameter("studentNo"));
		String studentName = request.getParameter("studentName");
		String studentPhone = request.getParameter("studentPhone");
		String email = request.getParameter("email");
		String addr = request.getParameter("addr");
		student s = new student(studentNo, studentName, studentPhone, email, addr);
		int result = new StudentService().updateStudent(s);
		if(result > 0) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/msg.jsp");
			request.setAttribute("msg", "수정성공");
			request.setAttribute("loc", "/");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/msg.jsp");
			request.setAttribute("msg", "수정실패");
			request.setAttribute("loc", "/");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
