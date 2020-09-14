package kh.java.func;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
//�̿�
public class UdpServer {
	public void main() {
//		1. �������� ����ϴ� Ip�ּҿ� port�Ҵ�
		int port =7877;
		InetAddress serverAddress = inaGetByName("127.0.0.1"); 
		
//		2. DatagramSocket��ü����
		System.out.println("���� ���������");
		DatagramSocket socket = makeDatagramSocket(port);
		System.out.println("���� ���� ����");
//		3. ��Ŷ�� �����ϱ����� ���� Ȯ�� �� ��Ʈ�� �Է�
		byte[] inMsg = new byte[1024];
		String sendMsgToByte = "�� UDP ����";
		byte[] outMsg = sendMsgToByte.getBytes();

//		4. ������ ��Ŷ �Ҵ��� ������ �ʱ�ȭ
		DatagramPacket inPacket = new DatagramPacket(outMsg, outMsg.length);
		System.out.println("inPacket�ʱ�ȭ �Ϸ�");
//		5. Ŭ���̾�Ʈ �޽����� �ޱ����� ��ٸ�
		SocketReceive(socket,inPacket);
		System.out.println("Socket �Է¿Ϸ�");
		
//		6. ���� BYTE[] �迭�� String ���� ��ȯ�� �߷�
		String clientMsg = new String(inMsg).trim();//�ڿ� ������� �ʴ� ���� �ڸ��� �޼ҵ�
		System.out.println(clientMsg);
		System.out.println("��� �Ϸ�");
		
//		7. ������ ��Ŷ ���� �� �ش� ��Ŷ�� �ռ� ������ byte[] outMsg�� ������
		DatagramPacket outPacket = new DatagramPacket(outMsg,outMsg.length,serverAddress,port);
		System.out.println("outPacket �ʱ�ȭ �Ϸ�");
//		8. DatagramSocket.send�� ����ؼ� ���� ������
		while(true)
		socketSend(socket, outPacket);
		//System.out.println("outPacket ������ �Ϸ�");

//		9.��������
		//socket.close();
	//	System.out.println("����");
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
