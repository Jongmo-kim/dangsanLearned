package kh.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import kh.model.dao.Dao;
import kh.model.vo.Kh;

/**
 * Servlet implementation class SearchKHServlet
 */
@WebServlet(name = "SearchKH", urlPatterns = { "/searchKH" })
public class SearchKHServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchKHServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String inputVal = request.getParameter("inputVal");
		Kh kh = new Dao().selectOneKh(inputVal);
		System.out.println(kh);
		
		if(kh==null) {
			PrintWriter out = response.getWriter();
			out.print("null");
			out.flush();
			out.close();
		} else {
			JsonObject obj = new JsonObject();
			JsonParser parse = new JsonParser();
			JsonObject obj2 = new JsonObject();
			
			obj.add("name", parse.parse(kh.getKhName()));
			obj.add("no", parse.parse(Integer.toString(kh.getKhNo())));
			obj.addProperty("addr", kh.getAddr());
			obj.add("fax", parse.parse(kh.getFax()));
			response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			out.print(obj);
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
