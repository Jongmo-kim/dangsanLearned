package ajax.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

/**
 * Servlet implementation class AjaxTest5Servlet
 */
@WebServlet(name = "ajaxTest5", urlPatterns = { "/ajaxTest5" })
public class AjaxTest5Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxTest5Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<User> list = new ArrayList<User>();
		User user1 = new User("이름1",20,"주소1");
		User user2 = new User("이름2",20,"주소2");
		User user3 = new User("이름3",20,"주소3");
		User user4 = new User("이름4",20,"주소4");
		User user5 = new User("이름5",20,"주소5");
		list.add(user1);
		list.add(user2);
		list.add(user3);
		list.add(user4);
		list.add(user5);
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		int index = -1;
		for(int i = 0 ; i < list.size() ;++i) {
			if(list.get(i).getName().equals(name)) {
				index = i;
				break;
			}
		}
		if(index != -1) {
			
			User user = list.get(index);
			JSONObject result = new JSONObject();
			result.put("name", URLEncoder.encode(user.getName(),"UTF-8"));
			result.put("age",user.getAge());
			result.put("addr", URLEncoder.encode(user.getAddr(),"UTF-8"));
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.print(result);
			out.flush();
			out.close();
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
