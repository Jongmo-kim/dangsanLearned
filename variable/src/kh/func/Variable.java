package kh.func;

import java.util.Scanner;

public class Variable {
	public void exam1() {
		//�̸� , ���� , �ּ�, Ű, ������, ����
		Scanner sc = new Scanner(System.in);
		System.out.print("�̸��� �Է��ϼ���: ");
		String name = sc.next();
		
		System.out.print("������ �Է��ϼ���: ");
		int age = sc.nextInt();
		
		System.out.print("�ּ��� �Է��ϼ���: ");
		sc.nextLine();//���� ���๮�� ����
		String addr = sc.nextLine();

		System.out.print("Ű�� �Է��ϼ���: ");
		double height = sc.nextDouble();
		
		System.out.print("�������� �Է��ϼ���: ");
		double weight = sc.nextDouble();
		
		System.out.println("���� �Է� (��/��) : ");
		char gender = sc.next().charAt(0);
		
		System.out.println("===============���================");
		System.out.println("�̸� :" + name);
		System.out.println("���� :" + age);
		System.out.println("�ּ� :" + addr);
		System.out.println("Ű :" + (int)height);
		System.out.printf("������ : %.1f \n", weight);
		System.out.println("���� :" + gender);
	}
	public void exam2() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� ���� �Է�: ");
		int kor = sc.nextInt();
		
		System.out.print("���� ���� �Է�: ");
		int math = sc.nextInt();
		System.out.print("���� ���� �Է�: ");
		int eng = sc.nextInt();
		
		System.out.printf("��� ������ �� ���� %d �̰� ����� %.2f �Դϴ�!",kor+math+eng,(((double)kor+math+eng)/3.0));
	}
	
	
	public void test2() {
		String name = "������";
		int age = 25;
		String gender = "����";
		String adress = "����� �߶���";
		String phoneNumber = "010-5906-6845";
		String email = "wa1358@naver.com";
		
		System.out.println("�̸�\t����\t����\t����\t\t��ȭ��ȣ\t\t�̸���");
		System.out.println("-------------------------------------------------------------------------------------------");
		System.out.printf("%s\t%d\t%s\t%s\t%s\t%s\n",name,age,gender,adress,phoneNumber,email);
	
		name = "���Ѽ�";
		age = 30;
		gender = "����";
		adress = "����� ���Ǳ�";
		phoneNumber = "010-1111-1111";
		email = "test@example.com";
		System.out.println("-------------------------------------------------------------------------------------------");
		System.out.printf("%s\t%d\t%s\t%7s\t%13s\t%13s\n",name,age,gender,adress,phoneNumber,email);
		
		int num = 1;
		
	}
	
	
	public void test1() {
		int num0 = 100;
		long num1 = 9999000000000L;
		float num2 = 486.520f;
		double num3 = 5697.890123;
		char num4 = 'A';
		String num5 = "Hello JAVA";
		boolean num6 = true;
		System.out.println(num0);
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num3);
		System.out.println(num4);
		System.out.println(num5);
		System.out.println(num6);
	}
	public void func1() {
		boolean bool1=true;
		boolean bool2=false;
		
		char ch1 ='a';
		System.out.println(ch1);
		
		ch1 = 'b';
		System.out.println(ch1);
		
		int num = 10;
		System.out.println(num);
		
		num = 20;
		System.out.println(num);
		
		num += 10;
		System.out.println(num);
		
		double d = 3.14;
		System.out.println(d);
		
		double d2;
		//������ ���� �� �ʱ�ȭ ���� �ʰ� ���� ���� �߻�
		//	System.out.println(d2);
		d2 = 5.12;
		System.out.println(d2);
		
		long lnum = 10000000000L;
		float fNum = 3.14f;
		
		final double PI = 3.14;
		//����� ������ ���� �ʱ�ȭ ���� ������ �Ұ���
		//PI = 5.12
		
		String str = "abcdef";
		System.out.println(str);
		System.out.println(str.charAt(0)); //a
		System.out.println(str.charAt(4)); //e
		char ch = str.charAt(2);
		System.out.println(ch);
		
		int num1  = 2147483647;
		long result = (long)num1 +1;//������ ����ȯ �ϴ� ���̽� 1
		System.out.println(result);
		
		byte b1 = 10;
		byte b2 = 20;
		byte b3 = (byte)(b1 + b2); // ��2
		int b4 = b1 + b2 ;
		
		System.out.println("1111");
		System.out.println("2222");
		System.out.print("1111");
		System.out.print("2222");
		
	}
	public void func2() {
		//1.���ڿ� ���� name�� �����Ͽ� ���� �̸� ����
		String name = "������";
		//2.������ ����(age)�� �����Ͽ� ���� ���� �Է�
		int age = 25;
		
		System.out.println("�� �̸��� " + name + "�̰� ���̴� " + age +"�Դϴ�.");
		
		System.out.print("�� �̸��� ");
		System.out.print(name);
		System.out.print("�̰� ���̴� ");
		System.out.print(age);
		System.out.println("�Դϴ�.");
		
		System.out.printf("�� �̸��� %s�̰� ���̴� %d�Դϴ�.\n",name,age);
		
		System.out.println("���̸��� \t ������");
		System.out.println("�� �̸��� \n ������");
		System.out.println("�������� ��� \\");
		System.out.println("�������� ��� \\");
		System.out.println("�ܵ���ǥ ��� \'");
		System.out.println("�ֵ���ǥ ��� \"");
	}
	
	public void scan() {
		//1. scnanner �����
		//1. import java.util.Scanner
		Scanner sc = new Scanner(System.in);
		//1) ���� �Է¹ޱ�
		System.out.print("������ �Է��ϼ��� : ");
		int temp =sc.nextInt();
		System.out.print("�Է��Ͻ� ����  " +temp+"�Դϴ�.\n");

		//2) �Ǽ� �Է¹ޱ�
		System.out.print("�Ǽ��� �Է��ϼ��� : ");
		float temp1 = sc.nextFloat();
		System.out.print("�Է��Ͻ� ����  " +temp1+"�Դϴ�. \n");
		
		System.out.print("�Ǽ��� �Է��ϼ��� : ");
		double temp2 =sc.nextDouble();
		System.out.print("�Է��Ͻ� ����  " +temp2+"�Դϴ�. \n");
		
		//3 -1 ) ���ڿ� �Է¹ޱ�
		System.out.print("���ڿ��� �Է��ϼ���.");
		String temp3 = sc.next();
		System.out.println("�Է��Ͻ� ���ڿ��� \"" + temp3 +"\"�Դϴ�. " );
		
		//3 -2 ) ���ڿ� �Է¹ޱ�
		System.out.println("���ڿ� �Է��ϼ��� : ");
		sc.nextLine();
		String temp4 = sc.nextLine();
		System.out.println("�Է��Ͻ� ���ڿ��� \"" + temp4 +"\"�Դϴ�. \n" );
		
		
		//4 ) ���� �Է¹ޱ�
		System.out.print("���ڸ� �Է��ϼ���: ");
		char temp5 = sc.next().charAt(0);
		System.out.println(temp5);
		
		
	}
}
