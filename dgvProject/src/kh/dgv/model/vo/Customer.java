package kh.dgv.model.vo;

import java.util.Random;

public class Customer {
	int Id;
	int width,length;
	/*
	 * ���� Point { int x , int y}ó�� Seat��ü�� ���� �����ϴ°� ���� ȿ�����̿�����.
	 * 
	 * 
	 */
	Random rand;
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public Customer(){
		rand = new Random();
		this.Id = Math.abs(rand.nextInt() % 10000000);
	}
	public int getId() {
		return Id;
	}
	public void setNewRandomId() {
		this.Id = rand.nextInt() % 10000000;
	}
	
}
