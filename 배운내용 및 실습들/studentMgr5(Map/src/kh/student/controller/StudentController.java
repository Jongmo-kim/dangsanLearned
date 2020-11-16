package kh.student.controller;

import java.util.HashMap;

import kh.student.model.vo.Student;
import kh.student.view.StudentView;

public class StudentController {
	HashMap<String,Student> students;
	StudentView view;
	public StudentController( ) {
		super();
		students = new HashMap<String,Student>();
		view = new StudentView();
		
	}
	public void main() {
	
		while(true) {
			int sel = view.ShowMenu();
			switch(sel) {
			
			case 1:
				insertStudent();
				break;
			case 2:
				view.printAllStudents(students);
				break;
			case 3:
				printOneStudents();
				break;
			case 4:
			
				updateStudent();
				break;
			case 5:
				deleteStudent();
				break;
			default :
				return;
				
			}
		}
	}
	private void updateStudent() {
		String name = view.getName("����");
		if(students.containsKey(name)) {
			students.remove(name);
			Student s = view.insertStudent();
			students.put(s.getName(), s);
			
			view.doneMessage("����");
		} else {
			view.noSearch();
		}
		
	}
	private void deleteStudent() {
		String name = view.getName("����");
		if(students.containsKey(name)) {
			students.remove(name);
			view.doneMessage("����");
		} else {
			view.noSearch();
		}
		
	}
	private void printOneStudents() {
		String name = view.getName("���");
		if(students.containsKey(name)) {
			view.printOneStudent(students.get(name));
			view.doneMessage("���");
		} else {
			view.noSearch();
		}
		
	}
	private void insertStudent() {
		Student s = view.insertStudent();
		students.put(s.getName(),s);
	}
	
}
