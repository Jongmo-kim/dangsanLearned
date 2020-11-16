package kh.student.view;

import java.util.ArrayList;
import java.util.Scanner;

import kh.student.model.vo.Student;

public class StudentView {
	Scanner sc;
	
	public StudentView() {
		sc = new Scanner(System.in);
	}
	
	public int showMenu() {
		System.out.println("\n--- 학생 관리 프로그램 ---\n");
		System.out.println("1. 학생 정보 등록");
		System.out.println("2. 전체 학생 정보 출력");
		System.out.println("3. 학생 정보 출력 (1명)");
		System.out.println("4. 학생 정보 수정");
		System.out.println("5. 학생 정보 삭제");
		System.out.print("선택 > ");
		return sc.nextInt();
	}
	
	public Student insertStudent() {
		System.out.println("\n---- 학생 정보 등록 ----\n");
		System.out.print("학생 이름 입력: ");
		String name = sc.next();
		System.out.print("학생 나이 입력: ");
		int age = sc.nextInt();
		System.out.print("학생 주소 입력: ");
		String addr =  sc.next();
		
		return new Student(name,age,addr);
	}
	
	public void printAllStudents(ArrayList<Student> students) {
		System.out.println("\n---- 전체 학생 정보 출력 ----\n");
		System.out.println("이름\t나이\t주소\t\t");
		for(Student List_i : students) {
			System.out.printf("%s\t%d\t%s\t\t\n",List_i.getName()
					,List_i.getAge(),List_i.getAddr());
		}
	}
	
	public void printOneStudent(Student student) {
		System.out.println("\n---- 학생 정보 출력 (1명) ----\n");
		System.out.println("이름\t나이\t주소\t\t");
		System.out.printf("%s\t%d\t%s\t\t\n",student.getName()
					,student.getAge(),student.getAddr());	
	}
	
	public void modifyOneStudent(Student students) {
		System.out.print("학생 이름 입력: ");
		students.setName(sc.next());
		System.out.print("학생 나이 입력: ");
		students.setAge(sc.nextInt());
		System.out.print("학생 주소 입력: ");
		students.setAddr(sc.next());
		
	}
	
	public String getName(String str) {
		System.out.printf("%s 할회원 이름 입력 : ",str);
		return sc.next();
	}
	
	public void noSearch() {
		System.out.println("회원 정보가 없습니다.");
	}
	
}
