package kh.func;

import java.util.Scanner;

public class Func {
	public void oper1() {
		//대입 연산자
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
		System.out.println(c);//C : 31 , JAVA: 32 자바는 인접연산 C는 한줄 연산
		
		
	}
	public void oper3() {
		char a = 'a'; // 'a' -> 97 'A' ->65
		char A = (char)(a^32); // xor 사용예
		System.out.println(A);
		
	}
	
	public void oper4() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("첫번째 정수 입력: ");
		int num1 = sc.nextInt();
		System.out.println("두번째 정수 입력: ");
		int num2=sc.nextInt();
//		num1 이  num2 보다 작은 경우 result에 num1 대입
//		그 반대의 경우 result에 num2대입
//		결국 result에는 num1과 num2중 작은수를 대입
		int result = num1 < num2?num1:num2;
		System.out.println("두수중 작은수는 ? "+ result);
	}
	public void exam1() {
		Scanner sc = new Scanner(System.in);
		
		System.out.printf("첫번째 수 입력 : ");
		int num1 = sc.nextInt();
		System.out.printf("\n두번째 수 입력 : ");
		int num2 = sc.nextInt();
		
		System.out.println("====================결과===============");
		System.out.printf("%d + %d = %d",num1,num2,num1+num2);
		System.out.printf("%d - %d = %d",num1,num2,num1-num2);
		System.out.printf("%d * %d = %d",num1,num2,num1*num2);
		System.out.printf("%d / %d = %d",num1,num2,num1/num2);
		
		
	}
	public void exam2() {
		int a =40, b= 20;
		a += b;
		System.out.printf("a의 값 %d, b의 값 %d \n",a, b); // a = 60 , b = 20
		a-=b;
		System.out.printf("a의 값 %d, b의 값 %d \n",a, b);// a = 40 , b = 20
		a*=b;
		System.out.printf("a의 값 %d, b의 값 %d \n",a, b);// a = 800, b = 20
		b/=a;
		System.out.printf("a의 값 %d, b의 값 %d \n",a, b);//a= 800 , b = 0 
	}
	public void exam3() {
		int a = 10 , b = 20 , c= 30 , d = 40;
		boolean result1,result2;
		result1 = ((a < 20 && b> 10) && (c == 20 || d == 40));
		result2 = ((a==10&&b!= 2*10) || (c == 30 && d != 40));
		System.out.printf("첫번째 결과값 : %b \n ", result1); //true
		System.out.printf("첫번째 결과값 : %b \n ", result2); //false
	}
	public void exam4() {
		Scanner sc = new Scanner(System.in);
		System.out.print("나이를 입력하세요 : ");
		int age = sc.nextInt();
		System.out.println(age >19 ? "성인입니다. 어서오세요" : "미성년자는 입장불가입니다.");
	}
}
