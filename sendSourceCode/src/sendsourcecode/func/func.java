package sendsourcecode.func;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
/*
 * https://m.blog.naver.com/PostView.nhn?blogId=hyoun1202&logNo=220015124971&proxyReferer=https:%2F%2Fwww.google.com%2F
 */
public class func {
	public void main() {
		TcpInitalize f = new TcpInitalize();
		int port = 7777;
		Scanner sc = new Scanner(System.in);
		Socket socket = null;
		try {
			socket = new Socket("127.0.0.1",port);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("������ ����Ǿ����ϴ�.");
		System.out.println("������ �Ͻðڽ��ϱ�?");
		System.out.println("1: ��������");
		System.out.println("2: �޽�������");
		System.out.print("���� >");
		int sel = sc.nextInt();
		
		switch(sel) {
		//���� ����
		case 1:
		String filePath = "C:/Users/user1/Downloads";
		String fileNm = "ojdbc8.jar";
		FileSender fs = new FileSender(socket, filePath, fileNm);
		fs.start();
		break;
		//�޽��� ����
		case 2:
		String msg = "����ؿ�!";
		MsgSender ms = new MsgSender(socket, msg);
		ms.start();
		break;
		}
	}

	

	
}
