package kh.func;

public class Variable {
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
}
