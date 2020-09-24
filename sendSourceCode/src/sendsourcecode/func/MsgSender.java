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
//			�������� ������ ���� 'msg'����
		f.dosWriteUTF(dos, "msg");
		f.dosFlush(dos);

		f.dosWriteUTF(dos, msg);
		f.dosFlush(dos);
		System.out.printf("[%s]����", msg);
		f.dosClose(dos);
	}

}
