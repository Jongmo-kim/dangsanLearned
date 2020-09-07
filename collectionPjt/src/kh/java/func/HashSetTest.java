package kh.java.func;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class HashSetTest {
	public void main() {
		HashSet<Integer> data = new HashSet<Integer>();
		data.add(10);//10을 입력하고 true
		data.add(20);//20을 입력하고 true
		data.add(10);//10은 중복된 값이므로 입력하지 않음
		data.add(30);
		data.add(40);
		//1. ArrayList를 이용하여 Set에 있는 데이터 추출
		ArrayList<Integer> list = new ArrayList<Integer>(data);
		for(int num : list) {
			System.out.println(num);
		}
		//2. Iterator를 이용하여 Set에 있는 데이터 추출
		Iterator<Integer> iterData = data.iterator();
		while(iterData.hasNext()) {
			System.out.println(iterData.next());
		}
		
		//3. foreach를 통한 출력 foreach는 iterator랑 관련되어있음
		for(int num:data) {
			System.out.println(num);
		}
	}
	public void lotto() {
		Scanner sc = new Scanner(System.in);
		HashSet<Integer> user = new HashSet<Integer>();
		int numberOfInputs = 1;
		
		//중복체크
		while(user.size() != 6) {
			System.out.println(numberOfInputs + "번째 번호 입력: ");
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
