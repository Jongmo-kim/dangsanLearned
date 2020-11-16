package kh.java.func;

import java.io.File;
import java.util.Scanner;

public class FileTest {
	public void fileTest() {
		Scanner sc = new Scanner(System.in);
		System.out.print("파일명 입력: ");
		String fileName = sc.nextLine();
		File file = new File(fileName);
		if(file.exists()) {
			System.out.printf("파일이름 : %s\n",file.getName());
			System.out.printf("해당 디렉토리 : %s\n",file.getParent()); //현재 프로젝트 기준
			System.out.printf("파일 상대경로 : %s\n",file.getPath());//현재 프로젝트 기준
			System.out.printf("파일 절대경로 : %s\n",file.getAbsolutePath());
			System.out.printf("파일 크기 : %s Byte\n",file.length());
		}else {
			System.out.println("해당 파일이 존재하지 않습니다.");
		}
	}
}
