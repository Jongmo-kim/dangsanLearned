package kh.java.func;

import java.util.HashMap;
import java.util.Set;

public class HashMapTest {
	public void main() {
		HashMap<Integer, String> map1 = new HashMap<Integer,String>();
		map1.put(0, "Hello");
		map1.put(1, "Hi");
		map1.put(2, "�ȳ�");
		System.out.println(map1.get(0));
		System.out.println(map1.get(1));
		System.out.println(map1.get(2));
		map1.put(3, "Hello");
		System.out.println(map1);
		map1.put(2, "�ȳ��ϼ���");
		System.out.println(map1);
		
		map1.remove(3);
		System.out.println(map1);
		System.out.println(map1.containsKey(1));
	}
	public void main2() {
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		map.put("one", 1);
		map.put("two", 2);
		map.put("three", 3);
		System.out.println(map.get("two"));
		map.put("three",5);
		System.out.println(map.get("three")); // 5 
		System.out.println(map.containsKey("four"));//false
		map.put("asdf", 101010);
		map.put("kh", 999);
		//for���� �̿��ؼ� map���ִ� ��ü ������ ��� -> ��ü Ű ���� �˾ƾ� ��°���
		Set<String> keys = map.keySet();
		for(String key : keys) {
			System.out.println("key :" + key + " / value : " + map.get(key));
		}
	}
}
