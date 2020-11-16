package kh.java.api;

import java.util.StringTokenizer;

public class StringTest {
	public void stringBufferTest() {
		//java.lang package에 있어서 import구문 안써도됨
		StringBuffer sb = new StringBuffer();
		System.out.println(sb.capacity());//할당된 문자열의 길이
		System.out.println(sb.length());//실제 문자열의 길이
		sb.append("kh");
		sb.append(" ");
		
		sb.insert(3, "AClass"); //3번자리부터 삽입
		
		sb.replace(0, 2, "hello");//대체
	}
	public void tokenExam() {
		String str = "J a v a P r o g r a m";
		//1. 문자열 값을 공백으로 토큰 처리하여 char[]로 저장
		//2. 1에서 만든char[]를 모두 대문자로 변경하여 출력
		StringTokenizer s = new StringTokenizer(str," ", false);
		char[] arr = new char[s.countTokens()];
		int idx=0;
		while(s.hasMoreTokens()) {
			arr[idx++] = s.nextToken().toCharArray()[0];
		}
		for(int List_i=0;List_i<idx;++List_i) {
			System.out.print(Character.toUpperCase(arr[List_i]));
		}
	}
}
