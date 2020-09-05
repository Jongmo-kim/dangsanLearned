package kh.java.run;

import kh.java.func.AnimalMgr;
import kh.java.func.Bear;
import kh.java.func.GenericEx;
import kh.java.func.Student;
import kh.java.func.Tiger;


public class Start {

	public static void main(String[] args) {
		AnimalMgr am1 = new AnimalMgr();
		Tiger t = new Tiger(200);
		//am1.setData(t);
		AnimalMgr am2 = new AnimalMgr();
		Bear b = new Bear(1000);
		//am2.setData(b);
		GenericEx ge = new GenericEx();
		ge.setData("hi");
		String msg = (String)ge.getData();
		System.out.println(msg);
		GenericEx<Student> gel = new GenericEx<Student>();
		Student s = gel.getData();
		
		GenericEx<Integer> ge2 = new GenericEx<Integer>();
		int num = ge2.getData();
	}

}
