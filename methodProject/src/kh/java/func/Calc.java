package kh.java.func;

import java.util.Scanner;

public class Calc {
	public void main() {
		Scanner sc = new Scanner(System.in);
		//���� �ΰ��� �Է¹޾Ƽ� ������������
		//�����ڸ� �Է¹޾Ƽ� ������ ������ ����(+,-,*,/)
		//switch�� ���ؼ� �����ڿ� ���� �ٸ� method�� ȣ��
		//�� �޼ҵ�� �ش� ������ �� ����� �����ϰ� �� ����� main���� ���
		//5. / ������ �Ǽ�����
		System.out.print("ù��° ���� �Է�");
		int num1 = sc.nextInt();
		System.out.print("�ι�° ���� �Է�");
		int num2 = sc.nextInt();
		System.out.print("������ �Է�");
		char ch = sc.next().charAt(0);
		
		switch(ch) {
		case '+':
			System.out.printf("���ϱ� ��� : %d\n",plus(num1,num2));
			break;
		case '-':
			System.out.printf("���� ��� : %d\n",minus(num1,num2));
			break;
		case '*':
			System.out.printf("���ϱ� ��� : %d\n",times(num1,num2));
			break;
		case '/':
			System.out.printf("������ ��� : %.2f\n",divide(num1,num2));
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
