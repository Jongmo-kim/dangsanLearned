package kh.java.func;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class ArrayListTest {
	public void ArrayListTest1() {
		// ���� 3¥�� ������ �迭 ����
		int intarr[] = new int[3];
		String strArr[] = new String[3];
		ArrayList<Integer> arr = new ArrayList<Integer>(3);
		ArrayList<String> arr1 = new ArrayList<String>(3);

		intarr[0] = 1;
		arr.add(1);
		intarr[1] = 2;
		arr.add(2);
		intarr[2] = 3;
		arr.add(3);
		for(int List_i=0;List_i<intarr.length;++List_i) {
			System.out.println(intarr[List_i]+"\t");
		}
		for(int List_i=0;List_i<arr.size();++List_i) {
			System.out.print(arr.get(List_i));
		}
		System.out.println();
		//arr[3] = 4; //���� out of bound
		arr.add(4);//�����ȳ�
		//arr 2�� -> Hello, Hi, "�ȳ��ϼ���"
		//list2 -> hello, hi , "�ȳ��ϼ���"
		arr1.add("Hello");
		strArr[0] = ("Hello");
		arr1.add("Hi");
		strArr[1] = ("Hi");
		arr1.add("�ȳ��ϼ���");
		strArr[2] = ("�ȳ��ϼ���");
		for(String str : arr1) {
			System.out.println(str);
		}/*
		for(int List_i=0;List_i<arr1.size();++List_i) {
			String str = arr1.get(List_i);
			System.out.println(str);
		}*/
		strArr[1] = "Hi";
		arr1.set(1, "Hi");
		arr1.remove(1);
		arr1.clear();// ��ü ���� 
		
		arr.add(1);
		arr.add(2);
		arr.add(3);
		arr.add(52);
		arr.add(100);
		arr.add(40);
		arr.add(34);
		arr.add(55);
		Collections.sort(arr);
		for(int i : arr) {
			System.out.print(i+"\t");
		}
		System.out.println();
	}
}
