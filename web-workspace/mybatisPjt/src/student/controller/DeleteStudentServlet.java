package student.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.model.service.StudentService;

/**
 * Servlet implementation class DeleteStudentServlet
 */
@WebServlet(name = "DeleteStudent", urlPatterns = { "/deleteStudent" })
public class DeleteStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int studentNo = Integer.parseInt(request.getParameter("studentNo"));
		int result = new StudentService().deleteStudent(studentNo);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/msg.jsp");
		if(result>0) {
			request.setAttribute("msg", "삭제 성공");
		} else {
			request.setAttribute("msg", "삭제 실패");
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
