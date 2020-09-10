package kh.java.run;

import kh.java.func.TcpChatServer;
import kh.java.func.TcpEchoServer;
import kh.java.func.TcpServer;

public class Start {
	public static void main(String args[]) {
		TcpEchoServer f = new TcpEchoServer();
		f.main();
	}
}
