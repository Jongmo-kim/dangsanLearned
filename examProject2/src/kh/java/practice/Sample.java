package kh.java.practice;

import java.util.Scanner;

public class Sample {
	
	
	public void sample1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �Է� :");
		String str = sc.next();
		char ch = str.charAt(0);
		
		System.out.printf("%c�� �����ڵ尪 :",ch);
		System.out.println((int)ch);
	}
	public void sample2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("���� ���� �Է�: ");
		int kor = sc.nextInt();
		
		System.out.print("���� ���� �Է�: ");
		int math = sc.nextInt();
		System.out.print("���� ���� �Է�: ");
		int eng = sc.nextInt();
		
		System.out.println("==========���============");
		System.out.printf("���� : %d \n",kor+math+eng);
		System.out.printf("��� : %d",(int)((kor+math+eng)/3.0));
	}
}
