package kh.java.func;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpInitalize {
	public void dosFlush(DataOutputStream dos) {
		try {
			dos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public int disReadInt(DataInputStream dis) {
		int i = 0;
		try {
			i = dis.readInt();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return i;
	}
	public void closeServerSocket(ServerSocket serverSocket) {
		try {
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void closeAll(DataInputStream dis,DataOutputStream dos,
			ServerSocket serverSocket,Socket socket) {
		try {
			dos.close();
			dis.close();
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void closeStream(DataInputStream dis, DataOutputStream dos) {
		try {
			dos.close();
			dis.close();
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
			System.out.println("서버 생성 성공");
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
	public void closeClientSocket(Socket socket) {
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
