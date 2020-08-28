package kh.java.func;

import java.util.Scanner;

public class MetthodTest {
	public void method6(int num1,int num2) {
		System.out.printf("두 수의 차는 : %d",num1 - num2);
	}
	
	public int method7(int num1,int num2) {
		return num1+num2; 
	}
	public void methodtest() {
		Scanner sc = new Scanner(System.in);

		System.out.println("첫번째 정수를 입력하세요.");
		int num1 = sc.nextInt();
		System.out.println("두번째 정수를 입력하세요.");
		int num2 = sc.nextInt();
		method1();
		method2();
		method3(num2);
		method4(num2,num1);
		System.out.print("문자열을 입력하세요: ");
		String s =sc.next();
		System.out.print("정수를 입력하세요 :");
		int num3 = sc.nextInt();
		method6(num1,num2);
		method6(num2,num1);
		method7(num1,num2);
		sc.close();
	}

	public void method1() {
		System.out.println("저는 method1() 입니다.");
	}

	public void method2() {
		System.out.println("저는 method1() 입니다.");
	}

	public void method3(int no) {
		// int no = 30;
		System.out.println("입력한 정수는 " + no + "입니다.");
	}

	public void method4(int no1, int no2) {
		//int no1 = 100 ; int no2 =  1000;
		//int no1 = 1000; int no2 = 100;
		System.out.printf("첫번째 정수는 : %d",no1);
		System.out.printf("두번째 정수는 : %d",no2);
	}
	
	public void method5(String str,int num) {
		System.out.printf("입력한 문자열은 : [%s]",str);
		System.out.printf("입력한 숫자는 : %d",num);
	}
	public void main2() {
		method(1);
	}
	public void method(int num) {
		
	}
	public void method(String str) {
		
	}
}
