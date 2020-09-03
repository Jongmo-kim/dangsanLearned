package kh.student.controller;

import java.util.Scanner;

import kh.student.model.vo.Student;
import kh.student.view.StudentView;

public class StudentController {
	private Student[] students;
	int index;
	StudentView view;

	public StudentController() {
		students = new Student[10];
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
				printAllStudent(students, sel);
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
		students[index++]  =    view.insertStudent();
	}
	public void printAllStudent(Student[] students, int index) {
		view.printAllStudents(this.students,this.index);
	}
	public void printOneStudent() {
		String name = view.getName("조회");
		int searchIndex = searchIndex(name);
		if(searchIndex == -1) {
			view.noSearch();
		} else {
			view.printOneStudent(students[searchIndex]);
		}
	}
	public int searchIndex(String name) {
		for(int List_i=0;List_i<index;++List_i) {
			if(students[List_i].getName().equals(name)) {
				return List_i;
			}
		}
		return -1;
	}
	public void modifyStudent() {
		int searchIndex = searchIndex(view.getName("수정"));
		if(searchIndex == -1) {
			view.noSearch();
		} else {
			view.modifyOneStudent(students[searchIndex]);
		}
	}
	public void deleteStudent() {
		int searchIndex = searchIndex(view.getName("삭제"));
		if(searchIndex == -1) {
			view.noSearch();
		} else {
			for(int List_i=searchIndex;List_i<index;++List_i) {
				students[List_i] = students[List_i+1];
			}
			index--;
		}
	}
}
