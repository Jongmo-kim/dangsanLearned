package kh.java.api;

import java.util.StringTokenizer;

public class StringTest {
	public void stringBufferTest() {
		//java.lang package�� �־ import���� �Ƚᵵ��
		StringBuffer sb = new StringBuffer();
		System.out.println(sb.capacity());//�Ҵ�� ���ڿ��� ����
		System.out.println(sb.length());//���� ���ڿ��� ����
		sb.append("kh");
		sb.append(" ");
		
		sb.insert(3, "AClass"); //3���ڸ����� ����
		
		sb.replace(0, 2, "hello");//��ü
	}
	public void tokenExam() {
		String str = "J a v a P r o g r a m";
		//1. ���ڿ� ���� �������� ��ū ó���Ͽ� char[]�� ����
		//2. 1���� ����char[]�� ��� �빮�ڷ� �����Ͽ� ���
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
