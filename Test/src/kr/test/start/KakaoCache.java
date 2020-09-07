package kr.test.start;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class KakaoCache {
	Scanner sc;
	public void main() {
		sc = new Scanner(System.in);
		// ��á���� �Ǿտ� �ִ� �� ������ ����
		// ���� ĳ�ó��� �ִ°� ���� �ǵڷ� ������
		System.out.println(leastRecentlyUsed());
	}
	public int leastRecentlyUsed() {
		int cacheSize,elapsedTime=0;
		
		
		cacheSize = sc.nextInt();
		String cities=sc.next();
		cities = cities.replace("[", "");
		cities = cities.replace("]", "");
		cities = cities.replace("\"", "");
		System.out.println(cities);
		StringTokenizer st = new StringTokenizer(cities,",",false);
		ArrayList<String> cache = new ArrayList<String>(cacheSize);
		
		while(st.hasMoreTokens()) {
			String city = st.nextToken().toUpperCase();
			if(cache.contains(city)) {
				cache.remove(city);
				cache.add(city);
				elapsedTime++;
			}else if(cache.size()<cacheSize || cacheSize == 0){
				cache.add(city);
				elapsedTime += 5;
			}
			else {
				cache.remove(0);
				cache.add(city);
				elapsedTime +=5;
			}
		}
		return elapsedTime;
		
	}
	
}
