package kcalRecorder.model.vo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Meal {
	public class food {
		private int kcalPerOneHundred;
		private double size;
		private int totalKcal;
		private String name;
		public food(int kcalPerOneHundred,double size, String name) {
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
	private ArrayList<food> foodArr;
	private Date date;
	public Meal() {
		date = new Date();
	}
	public Meal(int kcal,String name,Date date) {
		this.date = date;
	}
	public Meal(int kcal,String name) {
		date = new Date();
	}
	public food findHighestTotalKcal() {
		int max = 0;
		food tempToReturn = null;
		for(food fd : foodArr) {
			if(fd.getTotalKcal()> max) {
				max = Integer.max(max, fd.getTotalKcal());
				tempToReturn = fd;
			}
		}
		return tempToReturn;
	}
	public food findLowestTotalKcal() {
		int min = Integer.MAX_VALUE;
		food tempToReturn = null;
		for(food fd : foodArr) {
			if(fd.getTotalKcal() < min) {
				min = Integer.max(min, fd.getTotalKcal());
				tempToReturn = fd;
			}
		}
		return tempToReturn;
	}
	public void makeDate(int year,int month,int day,int hour,int minute) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(calendar.YEAR, year);
		calendar.set(calendar.MONTH, month);
		calendar.set(calendar.DAY_OF_MONTH, day);
		calendar.set(calendar.HOUR, hour);
		calendar.set(calendar.MINUTE, minute);
		date.setTime(calendar.getTimeInMillis());
	}
	
}
