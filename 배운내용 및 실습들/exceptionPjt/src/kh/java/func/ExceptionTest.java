package kh.java.func;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionTest {
	public void test1() {
		Scanner sc = new Scanner(System.in);
		System.out.println("ù���� �� �Է�: ");
		int num1 = sc.nextInt();
		System.out.println("�ι�° �� �Է�: ");
		int num2 = sc.nextInt();
		try {
			int result = num1/num2;
			System.out.println("���: " + result);
			
		} catch (Exception e) {
			System.out.println("0���� �������� �����ϴ�.");
		}
		
	}
	public void menuPrint() {
		System.out.println("1. �ȳ��ϼ���. ���");
		System.out.println("2. �ݰ�����. ���");
		System.out.println("1. �߰���. ���");
		System.out.print("����> ");
	}
	public void print(int sel) {
		switch(sel) {
		case 1:
			System.out.println("�ȳ��ϼ���. ");
			break;
		case 2:
			System.out.println("�ݰ�����. ");
			break;
		case 3:
			System.out.println("�߰���. ");
			break;
			default :
				System.out.println("1~3�� �������ּ���.");
		}
	}
	public void exam1() {
		Scanner sc = new Scanner(System.in);
		int sel = 0;
		boolean exit = true;
		while(true) {
			try {
				
			menuPrint();
			sel = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("���ڸ� �Է����ּ���");
				sc.nextLine(); //�Էµ� ���� ����
				continue;
			}
			break;

		}
		print(sel);
	}
	public void exam5() {
		//close���� ���� ó�����ִ� ����
		try(FileReader fr = new FileReader("test.txt")){
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
