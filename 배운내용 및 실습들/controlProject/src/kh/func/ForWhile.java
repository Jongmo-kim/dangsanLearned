package kh.func;

import java.util.Scanner;

public class ForWhile {
	public void forTest1() {
		for(int List_i = 0 ;List_i<5 ; ++List_i)
			System.out.println("hi");
	}
	public void forTest2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("��� ����Ͻðڽ��ϱ�? :");
		int Limit=sc.nextInt();
		for(int List_i = 0 ;List_i<Limit ; ++List_i)
			System.out.println("hi");	
	}
	public void forTest3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("2���Դϴ�.\n");
		int Limit= 10;
		int gugudan =2 ;
		for(int List_i = 1 ;List_i<Limit ; ++List_i)
			System.out.printf("%d * %d = %d \n",gugudan,List_i,gugudan * List_i);
	}
	public void forTest4() {
		Scanner sc = new Scanner(System.in);
		System.out.print("����� ����Ͻðڽ��ϱ�? \n");
		int Limit= 10;
		int gugudan =sc.nextInt();
		for(int List_i = 1 ;List_i<Limit ; ++List_i)
			System.out.printf("%d * %d = %d \n",gugudan,List_i,gugudan * List_i);
	}
	public void forTest5() {
		Scanner sc = new Scanner(System.in);
		int total =0,temp=0;
		int Limit=5;
		for(int List_i = 0 ;List_i<Limit ; ++List_i) {
			System.out.print("�������� �Է��Ͻÿ�. :");
			temp = sc.nextInt();
			total += temp;
		}
		System.out.println("�Է��� ������ ��: "+total);
		
	}
	public void forTest6() {
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("ù��° ���� �Է� :");
		int first =  sc.nextInt();
		System.out.print("�ι�° ���� �Է�:");
		int second=sc.nextInt();
		
		int temp;
		temp = first;
		first = Integer.max(first, second);
		second =Integer.min(temp,second);
		
		int total=0;
		for(int first_ = first ;first_<second+1 ; ++first_)
			total+=first_;
		System.out.printf("%d ~ %d�� ������ �� :%d",first,second,total);
	}
	public void forTest7() {
		Scanner sc = new Scanner(System.in);

		System.out.print("\n���� �Է� :");
		int limit = sc.nextInt();

		int total = 0;
		for (int List_i =0 ;List_i<limit +1 ;++List_i)
			if(List_i%2 == 0)
				total += List_i;
			
//		��� 2
//		for (int List_i = 2 ;List_i<limit+1 ; List_i +=2)
//			total += List_i;
		System.out.printf("���ڵ��� �� :%d\n",total);	
	}
	
}
