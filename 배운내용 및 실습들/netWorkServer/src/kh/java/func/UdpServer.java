package kh.java.func;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
//미완
public class UdpServer {
	public void main() {
//		1. 서버에서 사용하는 Ip주소와 port할당
		int port =7877;
		InetAddress serverAddress = inaGetByName("127.0.0.1"); 
		
//		2. DatagramSocket객체생성
		System.out.println("소켓 생성대기중");
		DatagramSocket socket = makeDatagramSocket(port);
		System.out.println("소켓 생성 성공");
//		3. 패킷을 선언하기위해 공간 확보 및 스트링 입력
		byte[] inMsg = new byte[1024];
		String sendMsgToByte = "난 UDP 서버";
		byte[] outMsg = sendMsgToByte.getBytes();

//		4. 보내는 패킷 할당한 값으로 초기화
		DatagramPacket inPacket = new DatagramPacket(outMsg, outMsg.length);
		System.out.println("inPacket초기화 완료");
//		5. 클라이언트 메시지를 받기위해 기다림
		SocketReceive(socket,inPacket);
		System.out.println("Socket 입력완료");
		
//		6. 받은 BYTE[] 배열을 String 으로 변환해 추력
		String clientMsg = new String(inMsg).trim();//뒤에 사용하지 않는 공간 자르는 메소드
		System.out.println(clientMsg);
		System.out.println("출력 완료");
		
//		7. 보내는 패킷 선언 및 해당 패킷에 앞서 선언한 byte[] outMsg를 보내기
		DatagramPacket outPacket = new DatagramPacket(outMsg,outMsg.length,serverAddress,port);
		System.out.println("outPacket 초기화 완료");
//		8. DatagramSocket.send를 사용해서 값을 보내기
		while(true)
		socketSend(socket, outPacket);
		//System.out.println("outPacket 보내기 완료");

//		9.소켓종료
		//socket.close();
	//	System.out.println("종료");
	}
	public void socketSend(DatagramSocket socket, DatagramPacket packet) {
		try {
			socket.send(packet);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void SocketReceive(DatagramSocket socket, DatagramPacket packet) {
		try {
			socket.receive(packet);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	public InetAddress inaGetByName(String ip) {
		InetAddress ina = null;
		try {
			ina = InetAddress.getByName(ip);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return ina;
	}
	public InetAddress inaGetLocalHost() {
		InetAddress ina = null;
		try {
			ina = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		return ina;
	}
	public DatagramSocket makeDatagramSocket(int port) {
		DatagramSocket ds = null;
		try {
			ds = new DatagramSocket(port);
		} catch (SocketException e) {
			e.printStackTrace();
		}
		return ds;
	}
}
