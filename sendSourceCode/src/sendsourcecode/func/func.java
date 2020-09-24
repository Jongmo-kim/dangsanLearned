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
/*
 * https://m.blog.naver.com/PostView.nhn?blogId=hyoun1202&logNo=220015124971&proxyReferer=https:%2F%2Fwww.google.com%2F
 */
public class func {
	public void main() {
		TcpInitalize f = new TcpInitalize();
		int port = 7777;
		ServerSocket serverSocket = f.makeServerSocket(port);
		Socket socket = f.makeClientSocket(serverSocket);

		String filePath = "C:\\Users\\user1\\Downloads";
		String fileNm = "ojdbc8.jar";
		FileSender fs = new FileSender(socket, filePath, fileNm);
		
		String msg = "»ç¶ûÇØ¿ä!";
		MsgSender ms = new MsgSender(socket, msg);
		ms.start();
	}

	

	
}
