package kh.func;

import java.util.Scanner;

public class WhileTest {
	public void whileTest1() {
		int List_i = 0;
		while (List_i<5) { 
			System.out.println("hi");
			++List_i;
		}
	}
	public void whileTest2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("��� ����Ͻðڽ��ϱ�? :");
		int Limit=sc.nextInt();
		int List_i = 0;
		while(List_i<Limit) { 
			System.out.println("hi");
			++List_i;
		}
	}
	public void whileTest3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("2���Դϴ�.\n");
		int Limit= 10;
		int gugudan =2 ;
		int List_i = 1;
		while( List_i<Limit ) {
			System.out.printf("%d * %d = %d \n",gugudan,List_i,gugudan * List_i);
			++List_i;
		}
	}
	public void whileTest4() {
		Scanner sc = new Scanner(System.in);
		System.out.print("����� ����Ͻðڽ��ϱ�? \n");
		int Limit= 10;
		int gugudan =sc.nextInt();
		int List_i = 1 ;
		while(List_i<Limit) {
			System.out.printf("%d * %d = %d \n",gugudan,List_i,gugudan * List_i);
			++List_i;
		}
	}
	public void whileTest5() {
		Scanner sc = new Scanner(System.in);
		int total =0,temp=0;
		int Limit=5;
		int List_i = 0 ;
		while(List_i<Limit ) {
			System.out.print("�������� �Է��Ͻÿ�. :");
			temp = sc.nextInt();
			total += temp;
			++List_i;
		}
		System.out.println("�Է��� ������ ��: "+total);
		
	}
	public void whileTest6() {
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("ù��° ���� �Է� :");
		int first =  sc.nextInt();
		System.out.print("�ι�° ���� �Է�:");
		int second=sc.nextInt();
		
		int temp;
		temp = first;
		first = Integer.min(first, second);
		second =Integer.max(temp,second);
		
		int total=0;
		int first_ = first ;
		while(first_<second+1  ) 
			total+=first_++;

		
		System.out.printf("%d ~ %d�� ������ �� :%d",first,second,total);
	}
	public void whileTest7() {
		Scanner sc = new Scanner(System.in);

		System.out.print("\n���� �Է� :");
		int limit = sc.nextInt();

		int total = 0;
		int List_i =0 ;
		while(List_i<limit +1 ) {
			if(List_i%2 == 0)
				total += List_i;
			++List_i;
		}
			
//		��� 2
//		for (int List_i = 2 ;List_i<limit+1 ; List_i +=2)
//			total += List_i;
		System.out.printf("���ڵ��� �� :%d\n",total);	
	}
	
}
