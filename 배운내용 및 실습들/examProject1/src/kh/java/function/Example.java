package kh.java.function;

import java.util.Scanner;

public class Example {
	public void exam1(){
		Scanner sc = new Scanner(System.in);
		System.out.print("ù��° ���� �Է� :");
		int num1 = sc.nextInt();
		
		System.out.print("�ι�° ���� �Է� :");
		int num2 = sc.nextInt();
		
		//�� �� �� �� ������
		System.out.println("============���=============");
		System.out.printf("%d + %d = %d \n",num1,num2,num1+num2);
		System.out.printf("%d - %d = %d \n",num1,num2,num1-num2);
		System.out.printf("%d * %d = %d \n",num1,num2,num1*num2);
		System.out.printf("%d / %d = %d \n",num1,num2,num1/num2);
		System.out.printf("%d %% %d = %d \n",num1,num2, num1%num2);
		
	}
	public void exam2() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� ���� �Է� : ");
		double length = sc.nextDouble();
		
		System.out.print("���� ���� �Է� : ");
		double vertical = sc.nextDouble();
		
		System.out.printf("���� : %.2f",length * vertical);
		System.out.println();
		System.out.printf("�ѷ� : %.1f",2*(length + vertical));
	}
	public void exam3() {
		Scanner sc = new Scanner(System.in);
		
		System.out.printf("���� �ܾ� �Է� :");
		String str = sc.next();
		
		System.out.printf("ù��° ���� : %c \n",str.charAt(0));
		System.out.printf("�ι�° ���� : %c \n",str.charAt(1));
		System.out.printf("����° ���� : %c \n",str.charAt(2));
		
	}
}
