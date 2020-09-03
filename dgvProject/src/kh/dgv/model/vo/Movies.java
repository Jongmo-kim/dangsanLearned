package kh.dgv.model.vo;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;

import kh.dgv.util.CalcBetweenTime;

public class Movies {
	private Calendar endTime;
	private Calendar startTime;
	private String name;
	private boolean[][] seats;
	private String runningTime;
	private int Index;
	public final int verticalSeats = 9; // 세로
	public final int horizontalSeats = 12;// 가로

	public int getIndex() {
		return Index;
	}

	public void setIndex(int index) {
		Index = index;
	}

	public String getStartTimeToString() {

		return startTime.toString();
	}

	public String getRunningTime() {
		return runningTime;
	}

	public void setRunningTime(String runningTime) {
		this.runningTime = runningTime;
	}

	public Calendar getEndTime() {
		return endTime;
	}

	public void setEndTime(Calendar endTime) {
		this.endTime = endTime;
	}

	public Calendar getStartTime() {
		return startTime;
	}

	public void setStartTime(Calendar startTime) {
		this.startTime = startTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean[][] getSeats() {
		return seats;
	}

	public void setSeats(boolean[][] seats) {
		this.seats = seats;
	}

	public Movies() {
		name = "";
		runningTime = "";
		endTime = Calendar.getInstance();
		startTime = Calendar.getInstance();
		Index =0;
	}

	public Movies(String name, Calendar startTime, String hour) {
		StringTokenizer st = new StringTokenizer(hour, ":", false);
		this.startTime = startTime;
		endTime = (Calendar) startTime.clone();
		endTime.set(Calendar.HOUR, endTime.get(Calendar.HOUR) + Integer.parseInt(st.nextToken()));
		endTime.set(Calendar.MINUTE, endTime.get(Calendar.MINUTE) + Integer.parseInt(st.nextToken()));
		runningTime = new CalcBetweenTime().calc(startTime, endTime);
		seatsInitalize();
		this.name = name;
		Index = 0;
	}
	private void seatsInitalize() {
		seats = new boolean[verticalSeats][horizontalSeats];
		for (int List_i = 0; List_i < verticalSeats; ++List_i) {
			for (int Just_j = 0; Just_j < horizontalSeats; ++Just_j) {
				seats[List_i][Just_j] = false;
			}
		}
	}

	public boolean isChecked(int width, int length) {
		if (seats[width][length]) {
			return true;
		} else {
			return false;
		}
	}

	public void occupiesSeat(int width, int length) {
		if (!seats[width][length]) {
			seats[width][length] = true;
		} else {
			System.out.println("이미 지정된 자리가 있습니다.");
		}
	}

}
