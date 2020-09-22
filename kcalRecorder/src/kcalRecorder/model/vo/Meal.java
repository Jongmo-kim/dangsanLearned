package kcalRecorder.model.vo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Meal {
	
	private ArrayList<Food> foodArr;
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
	public Food findHighestTotalKcal() {
		int max = 0;
		Food tempToReturn = null;
		for(Food fd : foodArr) {
			if(fd.getTotalKcal()> max) {
				max = Integer.max(max, fd.getTotalKcal());
				tempToReturn = fd;
			}
		}
		return tempToReturn;
	}
	public Food findLowestTotalKcal() {
		int min = Integer.MAX_VALUE;
		Food tempToReturn = null;
		for(Food fd : foodArr) {
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
