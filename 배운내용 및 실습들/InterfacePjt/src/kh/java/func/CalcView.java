package kh.java.func;

import java.util.Scanner;
/*
 * 여러 사람들끼리 프로그램을 만들때
 * interface를 통해 override를 하여 클래스를 구현한다
 * 하지만 그동안 다른 기능을 만들어야하는 개발자들이 
 * 어떤 기능이 어떻게 나올지 예상하고 구현을 해야하는데 이때
 * CalcImplTest를 붙여서 임의의 값으로 리턴을 하여 프로그램을 테스트 할 수 있다.
 */



public class CalcView {
	public void main() {
		 Scanner sc = new Scanner(System.in);
		 Calc c = new CalcImpl();
		 System.out.println("첫번째 수 입력: ");
		 int num1 = sc.nextInt();
		 System.out.println("두번째 수 입력: ");
		 int num2 = sc.nextInt();
		 System.out.println("연산자 입력(+, -, *, /) : ");
		 char oper = sc.next().charAt(0);
		 switch(oper) {
		 case '+':
			 int result1 = c.sum(num1, num2);
			 System.out.printf("결과 : %d",result1);
			 break;
		 case '-':
			 int result2 = c.sum(num1, num2);
			 System.out.printf("결과 : %d",result2);
			 break;
		 case '*':
			 int result3 = c.sum(num1, num2);
			 System.out.printf("결과 : %d",result3);
			 break;
		 case '/':
			 int result4 = c.sum(num1, num2);
			 System.out.printf("결과 : %d",result4);
			 break;
		 }
	}
}
