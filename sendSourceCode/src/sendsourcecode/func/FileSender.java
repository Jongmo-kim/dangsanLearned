package sendsourcecode.func;

import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;

public class FileSender extends Thread {
	String filePath;
	String fileNm;
	Socket socket;
	DataOutputStream dos;
	FileInputStream fis;
	BufferedInputStream bis;
	TcpInitalize f;

	public FileSender(Socket socket, String filePath, String fileNm) {
		TcpInitalize f = new TcpInitalize();
		this.socket = socket;
		this.fileNm = fileNm;
		this.filePath = filePath;

		dos = new DataOutputStream(f.getOutputStream(socket));
	}

	@Override
	public void run() {
//		���� ������ ������ �˸���.
		f.dosWriteUTF(dos, fileNm);
		f.dosFlush(dos);

//		������ ������ �о Socket Server�� ����
		String result = fileRead(dos);
		System.out.println("result : " + result);
	}

	private String fileRead(DataOutputStream dos) {
		f.dosWriteUTF(dos, fileNm);
		System.out.printf("���� %s��(��) �����Ͽ����ϴ�.", fileNm);

		File file = new File(filePath + "/" + fileNm);
		fis = f.getFileInputStream(file);
		bis = new BufferedInputStream(fis);

		int len;
		int size = 4096;
		byte[] data = new byte[size];
		while ((len = f.bisRead(bis, data)) != -1) {
			f.dosWrite(dos, data, 0, len);
		}
		
		f.dosFlush(dos);
		f.fisClose(fis);		
		return "done";
	}
}
