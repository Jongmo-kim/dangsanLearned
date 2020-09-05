package kh.student.controller;

import java.util.ArrayList;
import java.util.Scanner;

import kh.student.model.vo.Student;
import kh.student.view.StudentView;

public class StudentController {
	private ArrayList<Student> students;
	int index;
	StudentView view;

	public StudentController() {
		students = new ArrayList<Student>(10);
		view = new StudentView();

	}

	public void main() {
		while (true) {
			int sel = view.showMenu();
			switch (sel) {
			case 1:
				insertStudent();
				break;
			case 2:
				printAllStudent(students);
				break;
			case 3:
				printOneStudent();
				break;
			case 4:
				modifyStudent();
				break;
			case 5:
				deleteStudent();
				break;
			default:
				return;
			}
		}
	}
	public void insertStudent() {
		students.add(view.insertStudent());
	}
	public void printAllStudent(ArrayList<Student> students) {
		view.printAllStudents(this.students);
	}
	public void printOneStudent() {
		String name = view.getName("조회");
		int searchIndex = searchIndex(name);
		if(searchIndex == -1) {
			view.noSearch();
		} else {
			view.printOneStudent(students.get(searchIndex));
		}
	}
	public int searchIndex(String name) {
		int i=0;
		for(Student List_i : students) {
			if(List_i.getName().equals(name)) {
				return i; 
			}
			i++;
		}
		return -1;
	}
	public void modifyStudent() {
		int searchIndex = searchIndex(view.getName("수정"));
		if(searchIndex == -1) {
			view.noSearch();
		} else {
			view.modifyOneStudent(students.get(searchIndex));
		}
	}
	public void deleteStudent() {
		int searchIndex = searchIndex(view.getName("삭제"));
		if(searchIndex == -1) {
			view.noSearch();
		} else {
			students.remove(searchIndex);
		}
	}
}
