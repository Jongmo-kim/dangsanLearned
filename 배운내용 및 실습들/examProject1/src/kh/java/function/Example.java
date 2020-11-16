package kh.java.function;

import java.util.Scanner;

public class Example {
	public void exam1(){
		Scanner sc = new Scanner(System.in);
		System.out.print("첫번째 정수 입력 :");
		int num1 = sc.nextInt();
		
		System.out.print("두번째 정수 입력 :");
		int num2 = sc.nextInt();
		
		//합 차 곱 목 나머지
		System.out.println("============결과=============");
		System.out.printf("%d + %d = %d \n",num1,num2,num1+num2);
		System.out.printf("%d - %d = %d \n",num1,num2,num1-num2);
		System.out.printf("%d * %d = %d \n",num1,num2,num1*num2);
		System.out.printf("%d / %d = %d \n",num1,num2,num1/num2);
		System.out.printf("%d %% %d = %d \n",num1,num2, num1%num2);
		
	}
	public void exam2() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("가로 길이 입력 : ");
		double length = sc.nextDouble();
		
		System.out.print("세로 길이 입력 : ");
		double vertical = sc.nextDouble();
		
		System.out.printf("면적 : %.2f",length * vertical);
		System.out.println();
		System.out.printf("둘레 : %.1f",2*(length + vertical));
	}
	public void exam3() {
		Scanner sc = new Scanner(System.in);
		
		System.out.printf("영어 단어 입력 :");
		String str = sc.next();
		
		System.out.printf("첫번째 문자 : %c \n",str.charAt(0));
		System.out.printf("두번째 문자 : %c \n",str.charAt(1));
		System.out.printf("세번째 문자 : %c \n",str.charAt(2));
		
	}
}
