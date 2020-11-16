package kh.student.view;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import javax.swing.text.View;

import kh.student.model.vo.Student;

public class StudentView {
	Scanner sc;
	public StudentView() {
		sc =new Scanner(System.in);
	}
	public int ShowMenu() {
		System.out.println("1. 학생 정보 등록");
		System.out.println("2. 학생 전체 정보 조회");
		System.out.println("3. 학생 정보 조회(1명)");
		System.out.println("4. 학생 정보 수정");
		System.out.println("5. 학생 정보 삭제");
		System.out.print("선택 > ");
		int sel = sc.nextInt();
		return sel;
	}
	public Student insertStudent() {
		System.out.println("\n---- 학생 정보 등록 ----\n");
		System.out.println("학생 이름 입력: ");
		String name = sc.next();
		System.out.println("학생 나이 입력: ");
		int age = sc.nextInt();
		System.out.println("학생 주소 입력: ");
		String addr =  sc.next();

		
		return new Student(name,age,addr);
	}
	
	public void printAllStudents(HashMap<String,Student> students) {
		System.out.println("\n---- 전체 학생 정보 출력 ----\n");
		System.out.println("이름\t나이\t주소\t\t");
		Set<String> names = students.keySet();
		for(String name : names) {
			System.out.printf("%s\t%d\t%s\t\t\n",students.get(name).getName()
					,students.get(name).getAge(),students.get(name).getAddr());
		}
	}
	
	public void printOneStudent(Student student) {
		System.out.println("\n---- 학생 정보 출력 (1명) ----\n");
		System.out.println("이름\t나이\t주소\t\t");
		System.out.printf("%s\t%d\t%s\t\t\n",student.getName()
					,student.getAge(),student.getAddr());	
	}
	
	public void doneMessage(String msg) {
		System.out.printf("\n%s 완료\n",msg);
	}
	
	
	public String getName(String str) {
		System.out.printf("%s 할회원 이름 입력 : ",str);
		return sc.next();
	}
	
	public void noSearch() {
		System.out.println("회원 정보가 없습니다.");
	}

	
}
