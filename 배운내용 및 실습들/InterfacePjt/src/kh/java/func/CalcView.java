package kh.java.func;

import java.util.Scanner;
/*
 * ���� ����鳢�� ���α׷��� ���鶧
 * interface�� ���� override�� �Ͽ� Ŭ������ �����Ѵ�
 * ������ �׵��� �ٸ� ����� �������ϴ� �����ڵ��� 
 * � ����� ��� ������ �����ϰ� ������ �ؾ��ϴµ� �̶�
 * CalcImplTest�� �ٿ��� ������ ������ ������ �Ͽ� ���α׷��� �׽�Ʈ �� �� �ִ�.
 */



public class CalcView {
	public void main() {
		 Scanner sc = new Scanner(System.in);
		 Calc c = new CalcImpl();
		 System.out.println("ù��° �� �Է�: ");
		 int num1 = sc.nextInt();
		 System.out.println("�ι�° �� �Է�: ");
		 int num2 = sc.nextInt();
		 System.out.println("������ �Է�(+, -, *, /) : ");
		 char oper = sc.next().charAt(0);
		 switch(oper) {
		 case '+':
			 int result1 = c.sum(num1, num2);
			 System.out.printf("��� : %d",result1);
			 break;
		 case '-':
			 int result2 = c.sum(num1, num2);
			 System.out.printf("��� : %d",result2);
			 break;
		 case '*':
			 int result3 = c.sum(num1, num2);
			 System.out.printf("��� : %d",result3);
			 break;
		 case '/':
			 int result4 = c.sum(num1, num2);
			 System.out.printf("��� : %d",result4);
			 break;
		 }
	}
}
