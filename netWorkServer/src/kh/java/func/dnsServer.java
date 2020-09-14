package kh.java.func;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class dnsServer {
	public void main() {
		TcpInitalize f = new TcpInitalize();
		int port = 5555;
		HashMap<String, String> dns = new HashMap<String,String>();
		dns.put("www.naver.com", "210.89.160.88");
		dns.put("www.google.co.kr", "216.58.200.67");
		dns.put("www.iei.or.kr", "211.43.14.187");
		dns.put("www.nate.com", "120.50.131.112");
		dns.put("www.daum.net","211.231.99.80");
		
		ServerSocket serverSocket = f.makeServerSocket(port);
		int List_i=0;
		while((++List_i) != 10) {
			System.out.println("클라이언트 연결 대기중");
			Socket socket =  f.makeClientSocket(serverSocket);
			InputStream is = f.getInputStream(socket);
			OutputStream os = f.getOutputStream(socket);
			DataInputStream dis = new DataInputStream(is);
			DataOutputStream dos = new DataOutputStream(os);
			System.out.println("연결 성공");
			String domainIp = dns.get(f.disReadUTF(dis));
			f.dosWriteUTF(dos, domainIp);
			f.closeClientSocket(socket);
			f.closeStream(dis, dos);
		}
		f.closeServerSocket(serverSocket);
	}
}
