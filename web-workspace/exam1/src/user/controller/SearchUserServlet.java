package user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.model.dao.UserDao;
import user.model.vo.User;

@WebServlet(name = "searchUser", urlPatterns = { "/searchUser" })
public class SearchUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public SearchUserServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		User u = new UserDao().selectUser(userNo);
		RequestDispatcher rd = null;
		if(u==null) {
			rd = request.getRequestDispatcher("/WEB-INF/views/searchFail.jsp");
		} else {
			request.setAttribute("user", u);
			rd = request.getRequestDispatcher("/WEB-INF/views/searchSuccess.jsp");
		}
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
