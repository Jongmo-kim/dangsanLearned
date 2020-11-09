package kr.or.iei.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SendData1Serverlet
 */
@WebServlet({ "/SendData1Serverlet", "/sendData1" })
public class SendData1Serverlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendData1Serverlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("서버 요청 성공");
//		html에서 보내준 데이터가 한글일 경우를 처리하기 위한 인코딩
		request.setCharacterEncoding("utf-8");
		
//		HTML에서 보내준 데이터 꺼내서 변수에 저장 해쉬맵구조
		String str1 = request.getParameter("name");
		String str2 = request.getParameter("test");
		System.out.printf("str1 :%s\n",str1);
		System.out.printf("str2 :%s\n",str2);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
