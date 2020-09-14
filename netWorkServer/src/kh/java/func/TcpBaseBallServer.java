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
		System.out.println("서버 시작 성공");
		System.out.println("클라이언트의 접속을 기다립니다.");
		Socket socket = f.makeClientSocket(serverSocket);
		
		InputStream is = f.getInputStream(socket);
		OutputStream os = f.getOutputStream(socket);
		DataInputStream dis =  new DataInputStream(is);
		DataOutputStream dos = new DataOutputStream(os);
		
//		랜덤 값 생성하기
			int [] baseballNumber = makeBaseballNumber();
			printServerNumber(baseballNumber);
//		메인로직
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
		System.out.println("게임을 종료합니다.");
		f.closeAll(dis, dos, serverSocket, socket);
	}
	public void sendResult(TcpInitalize f,DataOutputStream dos, int[] strikeAndBall) {
		
		int strike = strikeAndBall[0];
		int ball =strikeAndBall[1];
		if(strike == 0 && ball == 0) {
			f.dosWriteUTF(dos, "아욱!");
		} else if(strike == 3){
			f.dosWriteUTF(dos, "3스트라이크 ");
		} else {
			
			f.dosWriteUTF(dos, String.format("%d 스트라이크 %d 볼",strike,ball));
		}
	}
	public void printResult(int[] strikeAndBall) {
		int strike = strikeAndBall[0];
		int ball =strikeAndBall[1];
		if(strike == 0 && ball == 0) {
			System.out.println("아욱!");
		} else if(strike == 3){
			System.out.println("3스트라이크");
		} else {
			System.out.printf("%d 스트라이크 %d 볼",strike, ball);
		}
	}
	public void printUserNumber(int[] userballNumber) {
		System.out.printf("사용자가 입력한 숫자 :%d %d %d\n",userballNumber[0],userballNumber[1],userballNumber[2]);
	}
	public int [] userballNumber(DataInputStream dis, TcpInitalize f) {
		int firstNum = f.disReadInt(dis);
		int secondNum = f.disReadInt(dis);
		int thridNum = f.disReadInt(dis);
		int [] userNumber = {firstNum,secondNum,thridNum}; //int [] 는 참조형이기때문에 call by referrence
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
		System.out.printf("서버 숫자 :%d %d %d",baseballNumber[0],baseballNumber[1],baseballNumber[2]);
	}
}
