package kh.java.func;

import java.util.Scanner;

public class MetthodTest2 {
	public void method6(int num1,int num2) {
		System.out.printf("�� ���� ���� : %d",num1 - num2);
	}
	
	public int method7(int num1,int num2) {
		return num1+num2; 
	}
	public void methodtest() {
		Scanner sc = new Scanner(System.in);
		System.out.print("ù��° ���� �Է� :");
		int num1=sc.nextInt();
		System.out.print("ù��° ���� �Է� :");
		int num2=sc.nextInt();
		sc.close();
	}
	public void method1() {
		int [] arr = {1,2,3,4,5};
		method2(arr[2]);
		System.out.println(arr[2]); //3 call by value
	}
	public void method2(int num) {
		//int num = 3;
		num=10;
	}
}
