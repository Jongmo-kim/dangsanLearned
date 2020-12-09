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
 * Servlet implementation class UpdateStudentFrmServlet
 */
@WebServlet(name = "UpdateStudentFrm", urlPatterns = { "/updateStudentFrm" })
public class UpdateStudentFrmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudentFrmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int studentNo = Integer.parseInt(request.getParameter("studentNo"));
		student s = new StudentService().searchStudent(studentNo);
		if(s != null) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/updateStudentFrm.jsp");
			request.setAttribute("s", s);
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/msg.jsp");
			request.setAttribute("msg", "회원정보 없음");
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
