package kr.test.start;

public class Start {
	public static class test1{
		public test1(Integer i) {
		
		}
	}
	public static void main(String[] args) {
		Integer I = new Integer(0);
		test1 test1 = null;
		
		test1 = new test1(I);
		System.out.println(I);
	}
	
}
