package kh.java.func;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class HashSetTest {
	public void main() {
		HashSet<Integer> data = new HashSet<Integer>();
		data.add(10);//10�� �Է��ϰ� true
		data.add(20);//20�� �Է��ϰ� true
		data.add(10);//10�� �ߺ��� ���̹Ƿ� �Է����� ����
		data.add(30);
		data.add(40);
		//1. ArrayList�� �̿��Ͽ� Set�� �ִ� ������ ����
		ArrayList<Integer> list = new ArrayList<Integer>(data);
		for(int num : list) {
			System.out.println(num);
		}
		//2. Iterator�� �̿��Ͽ� Set�� �ִ� ������ ����
		Iterator<Integer> iterData = data.iterator();
		while(iterData.hasNext()) {
			System.out.println(iterData.next());
		}
		
		//3. foreach�� ���� ��� foreach�� iterator�� ���õǾ�����
		for(int num:data) {
			System.out.println(num);
		}
	}
	public void lotto() {
		Scanner sc = new Scanner(System.in);
		HashSet<Integer> user = new HashSet<Integer>();
		int numberOfInputs = 1;
		
		//�ߺ�üũ
		while(user.size() != 6) {
			System.out.println(numberOfInputs + "��° ��ȣ �Է�: ");
			int inputNum = sc.nextInt();
			if(user.add(inputNum)) {
				numberOfInputs++;
			}
		}
		ArrayList<Integer> userList = new ArrayList<Integer>(user);
		Collections.sort(userList);
		System.out.println(userList);
		}
}
