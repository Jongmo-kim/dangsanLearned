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
			
			System.out.println("저장할 파일명 : ");
			String fileName = sc.next();
			try (FileWriter fw = new FileWriter(fileName)){
				System.out.printf("[%s] 파일에 저장될 내용 입력",fileName);
				System.out.print("종료는 exit");
				int lineNumber = 1 ;
				while(true) {
					System.out.print(lineNumber++ + " :");
					String str = sc.nextLine() + "\r\n"; //windows 용 개행문자
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
		System.out.print("저장할 파일명 입력: ");
		String fileName = sc.nextLine();
		String path = "C:\\Users\\Admin\\Downloads\\study\\";
		BufferedWriter bw =null;
		try (FileWriter fw = new FileWriter(path+fileName)){
				bw = new BufferedWriter(fw);
				System.out.printf("[%s] 파일에 저장할 내용 입력\n",fileName);
				System.out.println("종료는 exit");
				int lineNumber = 1;
				while(true) {
					System.out.print((lineNumber++) + ": ");
					String str = sc.nextLine();
					if(str.equals("exit")) {
						break;
					}
					bw.write(str);
					bw.newLine(); //줄개행
				}
				bw.close(); //안닫으면 저장이 안되더라...
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void charStreamReader() {
		Scanner sc = new Scanner(System.in);
		System.out.println("로드할 파일명: ");
		String fileName = sc.nextLine();
		BufferedReader br = null;
		try (FileReader fr = new FileReader(fileName)){ 
			br = new BufferedReader(fr);
			while(true) {
				String line = br.readLine(); //파일에서 한줄을 읽어서 line변수에 저장
				if(line == null) { //파일에서 읽어오지 못할시 탈출
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