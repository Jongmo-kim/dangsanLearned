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
//		1. �������� ����� ��Ʈ��ȣ����
//      1000�������� ���Ǵ� ��찡 ���� 1000�̻����� ���Ѵ�.
		int port = 7777;
		
//		2.������ ���� ��ü ����
		ServerSocket serverSocket = null;
		serverSocket = makeServerSocket(port);
		System.out.println("�������� ��ü ���� �Ϸ�");
		
//		3. Ŭ���̾�Ʈ ���� ��û ���
		System.out.println("Ŭ���̾�Ʈ ���� ���");
		
//		4. ���ӿ�û�� ���� �����ϰ� �ش� Ŭ���̾�Ʈ������ ���ϰ�ü ����
		Socket clientSocket = makeClientSocket(serverSocket);;
		
//		5. ����� Ŭ���̾�Ʈ�� �Է¹� ��½�Ʈ�� ����
		OutputStream out = getOutputStream(clientSocket);
		InputStream in = getInputStream(clientSocket);
		
//		6. ������Ʈ���� ���� ���ɰ���
		DataOutputStream dos = new DataOutputStream(out);
		DataInputStream dis = new DataInputStream(in);
		
//		7. ��Ʈ���� ���� �Է� �� ���
		dosWriteUTF(dos,"Hello World!");
		String clientMsg =  disReadUTF(dis);
		System.out.println(clientMsg);
//		8. �������
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
			s = new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return s;
	}
}