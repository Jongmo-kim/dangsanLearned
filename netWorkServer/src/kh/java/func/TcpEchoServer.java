package kh.java.func;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TcpEchoServer {
	public void main() {
		TcpInitalize f = new TcpInitalize();
		Scanner sc= new Scanner(System.in);
//		1. ��Ʈ��ȣ ����
		int port = 5678;
		
//		2. ���� ���� ����
		ServerSocket serverSocket = f.makeServerSocket(port);
		System.out.println("���� ���� ����, ���� �����...");
//		2-1. Ŭ���̾�Ʈ ���� ��� �� ���ӽ� ����
		Socket socket = f.makeClientSocket(serverSocket);
		System.out.println("����ڿ� ���� ����");

//		3. ��Ʈ�� ����
		InputStream is = f.getInputStream(socket);
		OutputStream os = f.getOutputStream(socket);
		System.out.println("��Ʈ������ ����");
//		4. ���� ��Ʈ�� ����
		DataInputStream dis = new DataInputStream(is);
		DataOutputStream dos = new DataOutputStream(os);
		System.out.println("��Ʈ������ ����");
		
//		5. �г��� �Է� �޽��� ���
		System.out.println("���� ���� ����");
		System.out.println("�г��� �Է� �����....");
		f.dosWriteUTF(dos, "�г����� �Է��ϼ��� :");

//		6. �޽��� �б�
		String nickName = f.disReadUTF(dis);
		
//		7. ���� ���� ����
		System.out.println("---- ä�� ���� ----");
		System.out.println("����� exit �Է�");
		while(true) {
			System.out.println("Ŭ���̾�Ʈ �Է� �����....");
			String readMsg = f.disReadUTF(dis);	//Ŭ���̾�Ʈ �Է´��
			System.out.printf("[Ŭ���̾�Ʈ] :%s\n",readMsg);
			if(checkStringEXIT(readMsg)) {
				break;
			}
			f.dosWriteUTF(dos, readMsg);		//�Է��� ���� ��Ʈ���� ������ 
		}
		System.out.println("ä���� �����մϴ�.");
		f.closeStream(dis, dos, serverSocket, socket);
	}
	public boolean checkStringEXIT(String str) {
		return str.equals("exit");
	}
}
