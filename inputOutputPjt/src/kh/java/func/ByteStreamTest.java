package kh.java.func;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ByteStreamTest {
	public void primaryStream() {
		Scanner sc = new Scanner(System.in);
		System.out.print("������ ���ϸ� �Է� : ");
		String fileName = sc.nextLine();
		try (FileOutputStream fOut = new FileOutputStream(fileName)) {// ������ ���� / �̹� �����ϴ°�� ���� ������ϸ� ����
			System.out.printf("[%s]���Ͽ� ������ ���� �Է�", fileName);
			System.out.println("����� exit �Է� ");
			int lineNumber = 1;
			while (true) {
				System.out.printf("%d :", lineNumber++);
				String str = sc.nextLine() + "\r\n"; // windows����ó������ �߰�
				if (str.equals("exit\r\n")) {
					break;
				}
				byte[] arr = str.getBytes(); // ������ ���ڿ��� byte[]�� ��ȯ �����ϱ����� ������ ��ȯ
				fOut.write(str.getBytes());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void subStream() {
		Scanner sc = new Scanner(System.in);
		System.out.println("������ ���ϸ� :");
		
		String fileName = sc.nextLine();
		DataOutputStream dos = null;
		try(FileOutputStream fos = new FileOutputStream(fileName)){
			dos = new DataOutputStream(fos);
			System.out.printf("[%s]���Ͽ� ������ ���� �Է�", fileName);
			System.out.println("����� exit �Է� ");
			int lineNumber = 1;
			while (true) {
				System.out.printf("%d :", lineNumber++);
				String str = sc.nextLine() + "\r\n"; // windows����ó������ �߰�
				if (str.equals("exit\r\n")) {
					break;
				}
				dos.writeChars(str);
				byte[] arr = str.getBytes(); // ������ ���ڿ��� byte[]�� ��ȯ �����ϱ����� ������ ��ȯ
				fos.write(str.getBytes());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
