package sendsourcecode.func;

import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.net.Socket;

public class MsgSender extends Thread {
	Socket socket;
	String msg;
	DataOutputStream dos;
	FileInputStream fis;
	BufferedInputStream bis;
	TcpInitalize f;

	public MsgSender(Socket scoket, String msg) {
		f = new TcpInitalize();
		this.socket = socket;
		this.msg = msg;
		dos = new DataOutputStream(f.getOutputStream(socket));
	}

	@Override
	public void run() {
//			파일전송 구분자 전송 'msg'전송
		f.dosWriteUTF(dos, "msg");
		f.dosFlush(dos);

		f.dosWriteUTF(dos, msg);
		f.dosFlush(dos);
		System.out.printf("[%s]전송", msg);
		f.dosClose(dos);
	}

}
