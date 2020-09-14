package kh.java.func;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
/*
 * https 프로토콜은 443포트
 * http 프로토콜은 80포트
 * DNS는  되돌려줌
 */
public class TcpChatServer2 {
	public void main() {
		TcpInitalize f = new TcpInitalize();
		Scanner sc = new Scanner(System.in);
		Calendar calendar = Calendar.getInstance();
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
//		1. 포트번호 지정
		int port = 5678;

//		2. 서버 소켓 생성
		ServerSocket serverSocket = f.makeServerSocket(port);
		System.out.println("소켓 생성 성공, 연결 대기중...");
//		2-1. 클라이언트 소켓 대기 및 접속시 생성
		Socket socket = f.makeClientSocket(serverSocket);
		System.out.println("사용자와 연결 성공");

//		3. 스트림 생성
		InputStream is = f.getInputStream(socket);
		OutputStream os = f.getOutputStream(socket);
		System.out.println("스트림생성 성공");
//		4. 보조 스트림 생성
		DataInputStream dis = new DataInputStream(is);
		DataOutputStream dos = new DataOutputStream(os);
		System.out.println("스트림생성 성공");

//		5. 닉네임 입력 메시지 출력
		System.out.println("서버 생성 성공");
		System.out.println("닉네임 입력 대기중....");
		f.dosWriteUTF(dos, "닉네임을 입력하세요 :");

//		6. 메시지 읽기
		String nickName = f.disReadUTF(dis);

//		7. 메인 로직 시작
		System.out.println("---- 채팅 시작 ----");
		System.out.println("종료는 exit 입력");
		boolean exit = true;
		while (exit) {
			while (true) {
				System.out.printf("(%s)[서버] : ",sdf.format(System.currentTimeMillis()));
				String sendMsg = sc.nextLine();
				if (checkStringEXIT(sendMsg)) {
					f.dosWriteUTF(dos, "exit");
					exit = false;
					break;
				}
				f.dosWriteUTF(dos, sendMsg); // 입력한 문자 스트림에 보내기
				System.out.print("클라이언트 입력 대기중....");
				String readMsg = f.disReadUTF(dis); // 클라이언트 입력대기
				System.out.printf("\n(%s)[%s] :%s\n",sdf.format(System.currentTimeMillis()) ,nickName, readMsg);
				if (checkStringEXIT(readMsg)) {
					f.closeClientSocket(socket);
					break;
				}
			}
			if(!exit) {
				continue;
			}
			System.out.println("연결 대기중...");
			socket = f.makeClientSocket(serverSocket);
			is = f.getInputStream(socket);
			os = f.getOutputStream(socket);
			dis = new DataInputStream(is);
			dos = new DataOutputStream(os);
			System.out.println("연결 성공");
			System.out.println("닉네임 입력 대기중....");
			f.dosWriteUTF(dos, "닉네임을 입력하세요 :");
			
			nickName = f.disReadUTF(dis);
		}
		System.out.println("채팅을 종료합니다.");
		f.closeAll(dis, dos, serverSocket, socket);
	}

	public void waitUntilConnectThenMakeSocket() {

	}

	public boolean checkStringEXIT(String str) {
		return str.equals("exit");
	}
}
