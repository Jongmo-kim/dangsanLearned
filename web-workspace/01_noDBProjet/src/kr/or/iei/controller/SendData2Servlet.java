package kr.or.iei.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SendData2Servlet
 */
@WebServlet({ "/SendData2Servlet", "/sendData2" })
public class SendData2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendData2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		1.인코딩
		request.setCharacterEncoding("utf-8");
//		2.넘어온 값 변수에 저장
		String str1 = request.getParameter("str1");
		int num = Integer.parseInt(request.getParameter("num"));
		String gender = request.getParameter("gender");
		String[] hobby = request.getParameterValues("hobby");
		String age = request.getParameter("age");
		String str2 = request.getParameter("str2");
		System.out.printf("str1 :%s \n",str1);
		System.out.printf("num :%d \n",num);
		System.out.printf("gender :%s \n",gender);
		for(int i = 0 ; i < hobby.length; ++i) {
			System.out.printf("hobby%d :%s \n",i+1,hobby[0]);
		}
		System.out.printf("age :%s \n",age);
		System.out.printf("str2 :%s \n",str2);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
