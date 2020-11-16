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
 * https ���������� 443��Ʈ
 * http ���������� 80��Ʈ
 * DNS��  �ǵ�����
 */
public class TcpChatServer2 {
	public void main() {
		TcpInitalize f = new TcpInitalize();
		Scanner sc = new Scanner(System.in);
		Calendar calendar = Calendar.getInstance();
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
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
		boolean exit = true;
		while (exit) {
			while (true) {
				System.out.printf("(%s)[����] : ",sdf.format(System.currentTimeMillis()));
				String sendMsg = sc.nextLine();
				if (checkStringEXIT(sendMsg)) {
					f.dosWriteUTF(dos, "exit");
					exit = false;
					break;
				}
				f.dosWriteUTF(dos, sendMsg); // �Է��� ���� ��Ʈ���� ������
				System.out.print("Ŭ���̾�Ʈ �Է� �����....");
				String readMsg = f.disReadUTF(dis); // Ŭ���̾�Ʈ �Է´��
				System.out.printf("\n(%s)[%s] :%s\n",sdf.format(System.currentTimeMillis()) ,nickName, readMsg);
				if (checkStringEXIT(readMsg)) {
					f.closeClientSocket(socket);
					break;
				}
			}
			if(!exit) {
				continue;
			}
			System.out.println("���� �����...");
			socket = f.makeClientSocket(serverSocket);
			is = f.getInputStream(socket);
			os = f.getOutputStream(socket);
			dis = new DataInputStream(is);
			dos = new DataOutputStream(os);
			System.out.println("���� ����");
			System.out.println("�г��� �Է� �����....");
			f.dosWriteUTF(dos, "�г����� �Է��ϼ��� :");
			
			nickName = f.disReadUTF(dis);
		}
		System.out.println("ä���� �����մϴ�.");
		f.closeAll(dis, dos, serverSocket, socket);
	}

	public void waitUntilConnectThenMakeSocket() {

	}

	public boolean checkStringEXIT(String str) {
		return str.equals("exit");
	}
}
