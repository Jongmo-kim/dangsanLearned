package kcalRecorder.model.vo;

import java.util.Calendar;
import java.util.Date;

public class Meal {
	private int kcal;
	private String name;
	private Date date;
	public Meal() {
		kcal = 0 ;
		name = "";
		date = new Date();
	}
	public Meal(int kcal,String name,Date date) {
		this.kcal = kcal;
		this.name = name;
		this.date = date;
	}
	public Meal(int kcal,String name) {
		this.kcal = kcal ;
		this.name = name;
		date = new Date();
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
