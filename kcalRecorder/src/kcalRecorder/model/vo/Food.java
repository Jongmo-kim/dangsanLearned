package kcalRecorder.model.vo;

import java.io.Serializable;

public class Food implements Serializable{
	private int kcalPerOneHundred;
	private double size;
	private int totalKcal;
	private String name;
	public Food(int kcalPerOneHundred,double size, String name) {
		super();
		this.kcalPerOneHundred = kcalPerOneHundred;
		this.size = size;
		this.name = name;
		this.totalKcal = calcTotalKcal(kcalPerOneHundred,size);
	}
	public int calcTotalKcal(int kcalPerOneHundred,double size) {
		return (int)((double)this.kcalPerOneHundred *  size);
	}
	public int getKcalPerOneHundred() {
		return kcalPerOneHundred;
	}
	public void setKcalPerOneHundred(int kcalPerOneHundred) {
		this.kcalPerOneHundred = kcalPerOneHundred;
	}
	public double getSize() {
		return size;
	}
	public void setSize(double size) {
		this.size = size;
	}
	public int getTotalKcal() {
		return totalKcal;
	}
	public void setTotalKcal(int totalKcal) {
		this.totalKcal = totalKcal;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}