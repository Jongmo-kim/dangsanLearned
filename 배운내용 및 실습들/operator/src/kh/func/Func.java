package kh.func;

import java.util.Scanner;

public class Func {
	public void oper1() {
		//���� ������
		int num1 = 10;
		System.out.println(num1);
		num1 += 10;
		System.out.println(num1);
		
		num1 += 10;
		System.out.println(num1); // 30
		num1 -= 5;
		System.out.println(num1); // 25
		
		int num2 = 10;
		int num3 = 10;
		int num4 = 10;
		num2 += 3;
		num3 *= 4;
		num4 %= 5;
		System.out.printf("Result : %d %d %d",num2,num3,num4);
		
		num1 = 12;
		int num6 = (++num1) + 10 ;
		System.out.println(num1);// 13 
		System.out.println(num6); // 23
		
		int num5 = 5;
		int num7 =(num4--)+4 ;
		System.out.println(num5);// 4
		System.out.println(num7);// 9
		
		int a = 10;
		int b = 10;
		int c = 10;
		c = (a++) + (++b) + a;
		System.out.println(a);//11
		System.out.println(b);//11
		System.out.println(c);//C : 31 , JAVA: 32 �ڹٴ� �������� C�� ���� ����
		
		
	}
	public void oper3() {
		char a = 'a'; // 'a' -> 97 'A' ->65
		char A = (char)(a^32); // xor ��뿹
		System.out.println(A);
		
	}
	
	public void oper4() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("ù��° ���� �Է�: ");
		int num1 = sc.nextInt();
		System.out.println("�ι�° ���� �Է�: ");
		int num2=sc.nextInt();
//		num1 ��  num2 ���� ���� ��� result�� num1 ����
//		�� �ݴ��� ��� result�� num2����
//		�ᱹ result���� num1�� num2�� �������� ����
		int result = num1 < num2?num1:num2;
		System.out.println("�μ��� �������� ? "+ result);
	}
	public void exam1() {
		Scanner sc = new Scanner(System.in);
		
		System.out.printf("ù��° �� �Է� : ");
		int num1 = sc.nextInt();
		System.out.printf("\n�ι�° �� �Է� : ");
		int num2 = sc.nextInt();
		
		System.out.println("====================���===============");
		System.out.printf("%d + %d = %d",num1,num2,num1+num2);
		System.out.printf("%d - %d = %d",num1,num2,num1-num2);
		System.out.printf("%d * %d = %d",num1,num2,num1*num2);
		System.out.printf("%d / %d = %d",num1,num2,num1/num2);
		
		
	}
	public void exam2() {
		int a =40, b= 20;
		a += b;
		System.out.printf("a�� �� %d, b�� �� %d \n",a, b); // a = 60 , b = 20
		a-=b;
		System.out.printf("a�� �� %d, b�� �� %d \n",a, b);// a = 40 , b = 20
		a*=b;
		System.out.printf("a�� �� %d, b�� �� %d \n",a, b);// a = 800, b = 20
		b/=a;
		System.out.printf("a�� �� %d, b�� �� %d \n",a, b);//a= 800 , b = 0 
	}
	public void exam3() {
		int a = 10 , b = 20 , c= 30 , d = 40;
		boolean result1,result2;
		result1 = ((a < 20 && b> 10) && (c == 20 || d == 40));
		result2 = ((a==10&&b!= 2*10) || (c == 30 && d != 40));
		System.out.printf("ù��° ����� : %b \n ", result1); //true
		System.out.printf("ù��° ����� : %b \n ", result2); //false
	}
	public void exam4() {
		Scanner sc = new Scanner(System.in);
		System.out.print("���̸� �Է��ϼ��� : ");
		int age = sc.nextInt();
		System.out.println(age >19 ? "�����Դϴ�. �������" : "�̼����ڴ� ����Ұ��Դϴ�.");
	}
}
