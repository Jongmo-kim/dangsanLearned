package kh.java.test.function;

import java.util.Scanner;

public class Example {
	public void exam1() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� ���� �Է�: ");
		int kor = sc.nextInt();
		
		System.out.print("���� ���� �Է�: ");
		int math = sc.nextInt();
		System.out.print("���� ���� �Է�: ");
		int eng = sc.nextInt();
		
		int sum = kor+math+eng;
		double ave = ((kor+math+eng)/3.0);
		System.out.println("==========���============");
		System.out.printf("���� : %d \n",sum);
		System.out.printf("��� : %.2f",ave);
		System.out.println(((ave>=60) && (kor >= 40) && (math >= 40) && (eng >= 40)) ? "\n�հ�" : "\n���հ�");
		
	}
	
	public void exam2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �Է� :");
		int num = sc.nextInt();
		
		System.out.println(((num%2)==0)?"¦��" : "Ȧ��");
	}
}
