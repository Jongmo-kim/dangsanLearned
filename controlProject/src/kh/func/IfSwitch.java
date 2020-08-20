package kh.func;

import java.util.Scanner;

public class IfSwitch {
	public void ifTest() {
		// Ű����� ���� �Է� �ޱ� ���� ��ĳ��
		Scanner sc = new Scanner(System.in);

		System.out.println("=============���� ���� ���α׷�=============");
		System.out.print("������ ������ �Է� �ϼ��� :");
		int num = sc.nextInt();

		if (num > 0) {
			System.out.printf("�Է��� �� %d�� ����Դϴ�.", num);
		}
		if (num == 0) {
			System.out.printf("�Է��� �� %d�� 0�Դϴ�.", num);
		}
		if (num < 0) {
			System.out.printf("�Է��� �� %d�� �����Դϴ�.", num);
		}
	}

	public void ifTest2() {
		// Ű����� ���� �Է� �ޱ� ���� ��ĳ��
		Scanner sc = new Scanner(System.in);

		System.out.println("=============�μ� �� ���α׷�=============");
		System.out.print("ù��° ������ ������ �Է� �ϼ��� :");
		int num1 = sc.nextInt();

		System.out.print("�ι�° ������ ������ �Է� �ϼ��� :");
		int num2 = sc.nextInt();

		if (num1 > num2) {
			System.out.printf("ù��° ���� ��Ů�ϴ�.");
		}
		if (num1 < num2) {
			System.out.printf("�ι�° ���� �� Ů�ϴ�.");
		}
		if (num1 == num2) {
			System.out.printf("�� ���� �����ϴ�");
		}
	}

	public void ifTest3() {
		Scanner sc = new Scanner(System.in);
		System.out.println("=============����=============");

		System.out.print("�����ڸ� �Է��ϼ���:");
		char operator = sc.next().charAt(0);
		System.out.print("ù��° ������ ������ �Է� �ϼ��� :");
		int num1 = sc.nextInt();
		System.out.print("�ι�° ������ ������ �Է� �ϼ��� :");
		int num2 = sc.nextInt();

		if (operator == '+') {
			System.out.printf("%d + %d = %d", num1, num2, num1 + num2);
		}
		if (operator == '-') {
			System.out.printf("%d - %d = %d", num1, num2, num1 - num2);
		}
		if (operator == '*') {
			System.out.printf("%d * %d = %d", num1, num2, num1 * num2);
		}
		if (operator == '/') {
			System.out.printf("%d / %d = %f", num1, num2, (double) num1 / num2);
		}
	}

	public void ifElseTest1() {

		Scanner sc = new Scanner(System.in);
		System.out.println("=============���̰��� ���α׷�=============");

		System.out.print("�����Ͻ� �� �ο��� ����Դϱ�? :");
		int TotalPeople = sc.nextInt();
		System.out.print("��� ����Դϱ�? (� �δ� 15000��):");
		int Adult = sc.nextInt();
		System.out.print("���̴� ����Դϱ�? (���� �δ� 5000��) :");
		int Child = sc.nextInt();
		if (Adult + Child == TotalPeople)
			System.out.printf("�����Ͻ� �� �ݾ��� %d �Դϴ�. \n", (Adult * 15000) + (Child * 5000));
		else
			System.out.println("�ο����� ���� �ʽ��ϴ�.");
	}

	public void ifElseTest2() {

		Scanner sc = new Scanner(System.in);
		int correctAnswerCount = 0;
		System.out.println("=============���� ���α׷�=============");

		System.out.print("����� ����� �����ϱ��? (1.apple 2. ��Ƽ���⽺) :");
		int appleAnswer = sc.nextInt();

		if (appleAnswer == 1) {
			System.out.println("����!");
			correctAnswerCount = correctAnswerCount + 1;

		} else
			System.out.println("��!!");

		System.out.print("�ٳ����� ��� ������ ���� ������ ? (1. ��� , 2. ����):");
		int bananaAnswer = sc.nextInt();
		if (bananaAnswer == 2) {
			System.out.println("����!");
			++correctAnswerCount;
		} else
			System.out.println("��!!");

		System.out.printf("�� %d ������ ������ϴ�.\n", correctAnswerCount);

	}

	public void ifElseTest3() {
		Scanner sc = new Scanner(System.in);
		System.out.println("=============�ɸ��׽�Ʈ=============");

		System.out.print("����� ���� �����Ͻʴϱ�?(1.yes, 2. no) :");
		int alcoholCheck = sc.nextInt();

		if (alcoholCheck == 1) {
			System.out.print("����� ��踦 �ǿ�ϱ�?(1.yes, 2. no) :");
			int cigaretteCheck = sc.nextInt();
			if (cigaretteCheck == 1)
				System.out.println("���� �ǰ��� ���� �ʽ��ϴ�.");
			else
				System.out.println("���� ���� ���� �ʽ��ϴ�.");
		} else {
			System.out.print("����� �̼� ģ���� �ֽ��ϱ�? (1.yes, 2.no) :");
			int dateCheck = sc.nextInt();
			if (dateCheck == 1)
				System.out.println("��,");
			else
				System.out.println("������");
		}
	}

	public void ifElseElseExam1() {
		Scanner sc = new Scanner(System.in);
		System.out.println("=============��/�ҹ��� ��ȯ ���α׷�=============");
		System.out.print("���� �Է� :");
		char ch = sc.next().charAt(0);
		System.out.println("==========���=========");
		if (Character.isLowerCase(ch)) {
			System.out.println("�ҹ��ڸ� �Է��ϼ̽��ϴ�.");
			System.out.printf("�빮�ڷ� ��ȯ %c \n", Character.toUpperCase(ch));
		} else if (Character.isUpperCase(ch)) {

			System.out.println("�빮�ڸ� �Է��ϼ̽��ϴ�.");
			System.out.printf("�ҹ��ڷ� ��ȯ %c \n", Character.toLowerCase(ch));
		} else
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");

	}

	public void isElseElseExam2() {
		// 3�� ��� �̸鼭 4�� ���
		// 3�� ���
		// 4�� ���
		// �Ѵ� �ƴ�
		// 0
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �Է� :");
		int num = sc.nextInt();
		System.out.println("==========���=========");
		if(num==0)
			System.out.printf("[%d]��(��) 3�� ������ƴϰ� 4�� ����� �ƴմϴ�", num);
		else if ((num % 3) == 0 && (num % 4) == 0)
			System.out.printf("[%d]��(��) 3�� ��� �̸鼭 4�� ��� �Դϴ�.", num);
		else if (num % 3 == 0)
			System.out.printf("[%d]��(��) 3�� ��� �Դϴ�.", num);
		else if (num % 4 == 0)
			System.out.printf("[%d]��(��) 4�� ��� �Դϴ�.", num);
		else if (num != 0)
			System.out.printf("[%d]��(��) 3�� ������ƴϰ� 4�� ����� �ƴմϴ�", num);
			
	}
	public void switchTest() {
		Scanner sc = new Scanner(System.in);
		System.out.println("1~3������ ������ �Է��ϼ��� :");
		int num = sc.nextInt();
		
		switch(num) {
		case 1:
			System.out.println("1�� �Է��߽��ϴ�.");
			break;
		case 2:
			System.out.println("2�� �Է��߽��ϴ�.");
			break;
		case 3:
			System.out.println("3�� �Է��߽��ϴ�.");
			break;
		default :
			System.out.println("�߸� �Է��߽��ϴ�.");
		}
	}
	public void switchTest1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("�ϼ��� �˰���� ���� �Է��ϼ��� :");
		int num = sc.nextInt();
		
		switch(num) {

		case 2:
			System.out.printf("%d�� ��(��)%d���� �ֽ��ϴ�.",num,29);
			break;
		case 3:
		case 4:
		case 1:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.printf("%d�� ��(��)%d���� �ֽ��ϴ�.",num,31);
			break;
		case 6:
			System.out.printf("%d�� ��(��)%d���� �ֽ��ϴ�.",num,30);
			break;
		case 9:
			System.out.printf("%d�� ��(��)%d���� �ֽ��ϴ�.",num,30);
			break;
		case 11:
			System.out.printf("%d�� ��(��)%d���� �ֽ��ϴ�.",num,30);
			break;
	
			
		default :
			System.out.println("�߸� �Է��߽��ϴ�.");
		}
	}
	public void switchTest2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("���б� ���� �ý����Դϴ�. \n������ �Է��ϼ��� (A,B,C,D,F:)");
		char ch = sc.next().charAt(0);
		
		switch(ch) {
		case 'A':
			System.out.println("�����ϼ̽��ϴ�. ���б��� 100% �����ص帮�ڽ��ϴ�.");
			break;
		case 'B':
			System.out.println("�ƽ����� ���б��� 50% �����ص帮�ڽ��ϴ�.");
			break;
		case 'C':
			System.out.println("���б��� �ٶ�ø� ���� ������ ���ּ���");
			break;
		case 'D':
			System.out.println("ũ��.");
			break;
		case 'F':
			System.out.println("�л����Դϴ�.");
			break;
		}
	}
	public void switchTest3() {
		Scanner sc = new Scanner(System.in);
		System.out.println("=============����=============");

		System.out.print("�����ڸ� �Է��ϼ���:");
		char operator = sc.next().charAt(0);
		System.out.print("ù��° ������ ������ �Է� �ϼ��� :");
		int num1 = sc.nextInt();
		System.out.print("�ι�° ������ ������ �Է� �ϼ��� :");
		int num2 = sc.nextInt();
		
		switch (operator) {
		case '+':
			System.out.printf("%d + %d = %d", num1, num2, num1 + num2);
			break;
		case '-':
			System.out.printf("%d - %d = %d", num1, num2, num1 - num2);
			break;
		case '*':
			System.out.printf("%d * %d = %d", num1, num2, num1 * num2);
			break;
		case '/':
			System.out.printf("%d / %d = %f", num1, num2, (double) num1 / num2);
			break;
		}
		
	}
	public void switchTest4() {
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �Է� : ");
		int num = sc.nextInt();
		char ch = 0;
		if ( !(num>100 || num < 0))
			if(90< num)
				ch = 'A';
			else if(80 < num)
				ch ='B';
			else if(70 < num)
				ch ='C';
			else if(60 < num)
				ch ='D';
			else if(60 > num)
				ch ='F';
		
		
		switch(ch) {
		case 'A':
			System.out.printf("%d�� ==> %c���",num,ch);
			break;
		case 'B':
			System.out.printf("%d�� ==> %c���",num,ch);
			break;
		case 'C':
			System.out.printf("%d�� ==> %c���",num,ch);
			break;
		case 'D':
			System.out.printf("%d�� ==> %c���",num,ch);
			break;
		case 'F':
			System.out.printf("%d�� ==> %c���",num,ch);
			break;
		default :
			System.out.println("�߸��� �Է� (0~100)���� �Է�");
	/*	switch(num/10){
	 * case 9:
	 * ...
	 * �̷������� ����� ��밡��
	 * 
	 * default : 
	 * if(score ==100){
	 * sysout(score +"�� ==> A���");
	 * ...
	 * switch �ȿ� if�� ȥ�ջ�밡��
	* 
	 */
		}
	}
	
}
