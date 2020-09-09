package kh.java.func;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ByteStreamTest {
	public void primaryStream() {
		Scanner sc = new Scanner(System.in);
		System.out.print("저장할 파일명 입력 : ");
		String fileName = sc.nextLine();
		try (FileOutputStream fOut = new FileOutputStream(fileName)) {// 파일을 생성 / 이미 존재하는경우 파일 덮어쓰기하며 생성
			System.out.printf("[%s]파일에 저장할 내용 입력", fileName);
			System.out.println("종료는 exit 입력 ");
			int lineNumber = 1;
			while (true) {
				System.out.printf("%d :", lineNumber++);
				String str = sc.nextLine() + "\r\n"; // windows개행처리문자 추가
				if (str.equals("exit\r\n")) {
					break;
				}
				byte[] arr = str.getBytes(); // 내보낼 문자열을 byte[]로 변환 전송하기위한 데이터 변환
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
		System.out.println("저장할 파일명 :");
		
		String fileName = sc.nextLine();
		DataOutputStream dos = null;
		try(FileOutputStream fos = new FileOutputStream(fileName)){
			dos = new DataOutputStream(fos);
			System.out.printf("[%s]파일에 저장할 내용 입력", fileName);
			System.out.println("종료는 exit 입력 ");
			int lineNumber = 1;
			while (true) {
				System.out.printf("%d :", lineNumber++);
				String str = sc.nextLine() + "\r\n"; // windows개행처리문자 추가
				if (str.equals("exit\r\n")) {
					break;
				}
				dos.writeChars(str);
				byte[] arr = str.getBytes(); // 내보낼 문자열을 byte[]로 변환 전송하기위한 데이터 변환
				fos.write(str.getBytes());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
