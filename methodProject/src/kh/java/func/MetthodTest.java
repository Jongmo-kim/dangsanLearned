package kh.java.func;

import java.util.Scanner;

public class MetthodTest {
	public void method6(int num1,int num2) {
		System.out.printf("�� ���� ���� : %d",num1 - num2);
	}
	
	public int method7(int num1,int num2) {
		return num1+num2; 
	}
	public void methodtest() {
		Scanner sc = new Scanner(System.in);

		System.out.println("ù��° ������ �Է��ϼ���.");
		int num1 = sc.nextInt();
		System.out.println("�ι�° ������ �Է��ϼ���.");
		int num2 = sc.nextInt();
		method1();
		method2();
		method3(num2);
		method4(num2,num1);
		System.out.print("���ڿ��� �Է��ϼ���: ");
		String s =sc.next();
		System.out.print("������ �Է��ϼ��� :");
		int num3 = sc.nextInt();
		method6(num1,num2);
		method6(num2,num1);
		method7(num1,num2);
		sc.close();
	}

	public void method1() {
		System.out.println("���� method1() �Դϴ�.");
	}

	public void method2() {
		System.out.println("���� method1() �Դϴ�.");
	}

	public void method3(int no) {
		// int no = 30;
		System.out.println("�Է��� ������ " + no + "�Դϴ�.");
	}

	public void method4(int no1, int no2) {
		//int no1 = 100 ; int no2 =  1000;
		//int no1 = 1000; int no2 = 100;
		System.out.printf("ù��° ������ : %d",no1);
		System.out.printf("�ι�° ������ : %d",no2);
	}
	
	public void method5(String str,int num) {
		System.out.printf("�Է��� ���ڿ��� : [%s]",str);
		System.out.printf("�Է��� ���ڴ� : %d",num);
	}
	public void main2() {
		method(1);
	}
	public void method(int num) {
		
	}
	public void method(String str) {
		
	}
}
