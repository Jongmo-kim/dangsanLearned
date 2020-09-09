package kh.java.func;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CharStream {
	public void primaryStream() {
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("������ ���ϸ� : ");
			String fileName = sc.next();
			try (FileWriter fw = new FileWriter(fileName)){
				System.out.printf("[%s] ���Ͽ� ����� ���� �Է�",fileName);
				System.out.print("����� exit");
				int lineNumber = 1 ;
				while(true) {
					System.out.print(lineNumber++ + " :");
					String str = sc.nextLine() + "\r\n"; //windows �� ���๮��
					if(str.equals("exit\r\n")) {
						break;
					}
					fw.write(str);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
	}
	public void subStream() {
		Scanner sc = new Scanner(System.in);
		System.out.print("������ ���ϸ� �Է�: ");
		String fileName = sc.nextLine();
		String path = "C:\\Users\\Admin\\Downloads\\study\\";
		BufferedWriter bw =null;
		try (FileWriter fw = new FileWriter(path+fileName)){
				bw = new BufferedWriter(fw);
				System.out.printf("[%s] ���Ͽ� ������ ���� �Է�\n",fileName);
				System.out.println("����� exit");
				int lineNumber = 1;
				while(true) {
					System.out.print((lineNumber++) + ": ");
					String str = sc.nextLine();
					if(str.equals("exit")) {
						break;
					}
					bw.write(str);
					bw.newLine(); //�ٰ���
				}
				bw.close(); //�ȴ����� ������ �ȵǴ���...
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void charStreamReader() {
		Scanner sc = new Scanner(System.in);
		System.out.println("�ε��� ���ϸ�: ");
		String fileName = sc.nextLine();
		BufferedReader br = null;
		try (FileReader fr = new FileReader(fileName)){ 
			br = new BufferedReader(fr);
			while(true) {
				String line = br.readLine(); //���Ͽ��� ������ �о line������ ����
				if(line == null) { //���Ͽ��� �о���� ���ҽ� Ż��
					break;
				}
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}