package kh.java.trie;


public class Hanoi {
	public void move(int no, int x, int y) {
		if(no > 1) {
			move(no - 1 , x , 6 - x - y);
		}
		System.out.printf("원반[%d]을 %d기둥에서 %d기둥으로 옮김\n",no,x,y);
		if(no>1) {
			move(no-1,6-x-y,y);
		}
	}
}