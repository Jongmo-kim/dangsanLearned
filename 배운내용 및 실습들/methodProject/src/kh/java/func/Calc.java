package kh.java.func;

import java.util.Scanner;

public class Calc {
	public void main() {
		Scanner sc = new Scanner(System.in);
		//정수 두개를 입력받아서 변수에저ㅏ장
		//연산자를 입력받아서 문자형 변수에 저장(+,-,*,/)
		//switch를 통해서 연산자에 따라서 다른 method를 호출
		//각 메소드는 해당 연산을 한 결과를 리턴하고 그 결과를 main에서 출력
		//5. / 연산은 실수연산
		System.out.print("첫번째 정수 입력");
		int num1 = sc.nextInt();
		System.out.print("두번째 정수 입력");
		int num2 = sc.nextInt();
		System.out.print("연산자 입력");
		char ch = sc.next().charAt(0);
		
		switch(ch) {
		case '+':
			System.out.printf("더하기 결과 : %d\n",plus(num1,num2));
			break;
		case '-':
			System.out.printf("빼기 결과 : %d\n",minus(num1,num2));
			break;
		case '*':
			System.out.printf("곱하기 결과 : %d\n",times(num1,num2));
			break;
		case '/':
			System.out.printf("나누기 결과 : %.2f\n",divide(num1,num2));
			break;
		}
		return;
	}
	public int plus(int num1_,int num2_) {
		return num1_+num2_;
	}
	public int minus(int num1_,int num2_) {
		return num1_-num2_;
	}
	public int times(int num1_,int num2_) {
		return num1_*num2_;
	}
	public double divide(int num1_,int num2_) {
		return num1_/(double)num2_;
	}
}
