package kh.java.func;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
	public void main() {
//		1. 서버에서 사용할 포트번호지정
//      1000번안쪽은 사용되는 경우가 많아 1000이상으로 정한다.
		int port = 7777;
		
//		2.서버용 소켓 객체 생성
		ServerSocket serverSocket = null;
		serverSocket = makeServerSocket(port);
		System.out.println("서버소켓 객체 생성 완료");
		
//		3. 클라이언트 접속 요청 대기
		System.out.println("클라이언트 접속 대기");
		
//		4. 접속요청이 오면 수락하고 해당 클라이언트에대한 소켓객체 생성
		Socket clientSocket = makeClientSocket(serverSocket);;
		
//		5. 연결된 클아이언트와 입력및 출력스트림 생성
		OutputStream out = getOutputStream(clientSocket);
		InputStream in = getInputStream(clientSocket);
		
//		6. 보조스트림을 통한 성능개선
		DataOutputStream dos = new DataOutputStream(out);
		DataInputStream dis = new DataInputStream(in);
		
//		7. 스트림을 통한 입력 및 출력
		dosWriteUTF(dos,"Hello World!");
		String clientMsg =  disReadUTF(dis);
		System.out.println(clientMsg);
//		8. 통신종료
		closeStream(dis,dos,serverSocket,clientSocket);
	}
	public void closeStream(DataInputStream dis,DataOutputStream dos,
			ServerSocket serverSocket,Socket socket) {
		try {
			dos.close();
			dis.close();
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public String disReadUTF(DataInputStream dis) {
		String str = "";
		try {
			str = dis.readUTF();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}
	public void dosWriteUTF(DataOutputStream dos, String str) {
		try {
			dos.writeUTF(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public InputStream getInputStream(Socket client) {
		InputStream in = null;
		try {
			in = client.getInputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return in;
	}
	public OutputStream getOutputStream(Socket client) {
		OutputStream out = null;
		try {
			out = client.getOutputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return out;
	}
	public Socket makeClientSocket(ServerSocket serverSocket) {
		Socket cs = null;
		try {
			cs = serverSocket.accept();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return cs;
	}
	public ServerSocket makeServerSocket(int port) {
		ServerSocket s = null;
		try {
			s = new ServerSocket(7777);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return s;
	}
}
