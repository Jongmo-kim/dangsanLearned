package kh.java.start;

import kh.java.func.TV;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TV t  = new TV();
		
		System.out.println(t.inch);
		System.out.println(t.power);
		System.out.println(t.channel);
		System.out.println(t.volume);
		t.power();
		System.out.println(t.power);
		t.volumeUp();
		t.volumeUp();
		t.volumeUp();
		t.volumeUp();
		t.volumeUp();
		System.out.println(t.volume);
	}

}
