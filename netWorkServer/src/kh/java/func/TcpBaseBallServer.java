package kh.java.func;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class TcpBaseBallServer {
	public void main() {
		TcpInitalize f = new TcpInitalize();
		int port = 7777;
		System.out.println("< < < < < < < < < < BaseBall Game > > > > > > > > > > >");
		ServerSocket serverSocket = f.makeServerSocket(port);
		makeBaseballNumber();
		System.out.println("���� ���� ����");
		System.out.println("Ŭ���̾�Ʈ�� ������ ��ٸ��ϴ�.");
		Socket socket = f.makeClientSocket(serverSocket);
		
		InputStream is = f.getInputStream(socket);
		OutputStream os = f.getOutputStream(socket);
		DataInputStream dis =  new DataInputStream(is);
		DataOutputStream dos = new DataOutputStream(os);
		
//		���� �� �����ϱ�
			int [] baseballNumber = makeBaseballNumber();
			printServerNumber(baseballNumber);
//		���η���
		while(true) {
			int [] userballNumber = userballNumber(dis,f);
			printUserNumber(userballNumber);
			
			int[] strikeAndball = calcStrikeBallOut(baseballNumber, userballNumber);
			printResult(strikeAndball);
			sendResult(f,dos,strikeAndball);
			if(strikeAndball[0]==3) {
				break;
			}
		}
		System.out.println("������ �����մϴ�.");
		f.closeAll(dis, dos, serverSocket, socket);
	}
	public void sendResult(TcpInitalize f,DataOutputStream dos, int[] strikeAndBall) {
		
		int strike = strikeAndBall[0];
		int ball =strikeAndBall[1];
		if(strike == 0 && ball == 0) {
			f.dosWriteUTF(dos, "�ƿ�!");
		} else if(strike == 3){
			f.dosWriteUTF(dos, "3��Ʈ����ũ ");
		} else {
			
			f.dosWriteUTF(dos, String.format("%d ��Ʈ����ũ %d ��",strike,ball));
		}
	}
	public void printResult(int[] strikeAndBall) {
		int strike = strikeAndBall[0];
		int ball =strikeAndBall[1];
		if(strike == 0 && ball == 0) {
			System.out.println("�ƿ�!");
		} else if(strike == 3){
			System.out.println("3��Ʈ����ũ");
		} else {
			System.out.printf("%d ��Ʈ����ũ %d ��",strike, ball);
		}
	}
	public void printUserNumber(int[] userballNumber) {
		System.out.printf("����ڰ� �Է��� ���� :%d %d %d\n",userballNumber[0],userballNumber[1],userballNumber[2]);
	}
	public int [] userballNumber(DataInputStream dis, TcpInitalize f) {
		int firstNum = f.disReadInt(dis);
		int secondNum = f.disReadInt(dis);
		int thridNum = f.disReadInt(dis);
		int [] userNumber = {firstNum,secondNum,thridNum}; //int [] �� �������̱⶧���� call by referrence
		return userNumber;
	}
	public int[] calcStrikeBallOut(int[] baseballNumber,int[] userNumber)
	{
		int strike = 0,ball = 0;
		for(int i = 0 ;i < 3 ; ++i) {
			if(userNumber[i] == baseballNumber[i]) {
				++strike;
			} else if(checkNestedNum(baseballNumber,userNumber[i])) {
				for(int j = 0;j < 3;++j) {
					if(baseballNumber[j]==userNumber[i]) {
						++ball;
					}
				}
			}
		}
		int [] arr = {strike,ball};
		return arr;
	}
	public int[] makeBaseballNumber(){
		Random rand = new Random();
		int [] arr = new int[3];
		for(int i = 0;i < 3 ; ++i) {
			int randNum = rand.nextInt(9)+1;
			if(checkNestedNum(arr, randNum)) {
				--i;
				continue;
			}
			arr[i] = randNum;
		}
		return arr;
	}
	public boolean checkNestedNum(int[] arr,int num) {
		for(int i =0 ;i <arr.length;++i) {
			if(arr[i]==num) {
				return true;
			}
		}
		return false;
	}
	public void printServerNumber(int[] baseballNumber) {
		System.out.printf("���� ���� :%d %d %d",baseballNumber[0],baseballNumber[1],baseballNumber[2]);
	}
}
