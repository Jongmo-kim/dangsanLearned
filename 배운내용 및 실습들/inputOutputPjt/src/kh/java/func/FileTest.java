package kh.java.func;

import java.io.File;
import java.util.Scanner;

public class FileTest {
	public void fileTest() {
		Scanner sc = new Scanner(System.in);
		System.out.print("���ϸ� �Է�: ");
		String fileName = sc.nextLine();
		File file = new File(fileName);
		if(file.exists()) {
			System.out.printf("�����̸� : %s\n",file.getName());
			System.out.printf("�ش� ���丮 : %s\n",file.getParent()); //���� ������Ʈ ����
			System.out.printf("���� ����� : %s\n",file.getPath());//���� ������Ʈ ����
			System.out.printf("���� ������ : %s\n",file.getAbsolutePath());
			System.out.printf("���� ũ�� : %s Byte\n",file.length());
		}else {
			System.out.println("�ش� ������ �������� �ʽ��ϴ�.");
		}
	}
}
