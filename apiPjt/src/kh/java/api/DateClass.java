package kh.java.api;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class DateClass {
	public void dateTest() {
		Date d =  new Date(); //현재 시스템시간
		System.out.println(d);
		
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DATE, 1);
		Date date = new Date(c.getTimeInMillis());
		System.out.println(date);
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd");
		String todayString = sdf1.format(d);
		System.out.println(todayString);
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sdf2.format(d));
	}
	public void exam1() {
		//calendar 클래스사용
		//1. 오늘 날짜에 대한  객체 생성
		//2. 년, 월, 일, 시, 분, 초 값을 각각 변수에 분리하여 저장한 후 하나의 문자여롤 출력
		//출력형식 : 2020년 9월 2일 화요일
		
		Calendar c =Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH)+1;
		int day =c.get( Calendar.DAY_OF_MONTH);
		int minute =  c.get(Calendar.MINUTE);
		int hour = c.get(Calendar.HOUR);
		int sec = c.get(Calendar.SECOND);
		int Dayofweek = c.get(Calendar.DAY_OF_WEEK);
		String dayofweek ="";
		switch(Dayofweek) {
		case 2:
			dayofweek="월";
			break;
		case 3:
			dayofweek="화";
			break;
		case 4:
			dayofweek="수";
			break;
		case 5:
			dayofweek="목";
			break;
		case 6:
			dayofweek="금";
			break;
		case 7:
			dayofweek="토";
			break;
		case 1:
			dayofweek="일";
			break;
		}
		System.out.printf("%d년 %d월 %d일 %s요일\n",year,month,day,dayofweek);
		Date d = new Date(c.getTimeInMillis());
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy년 M월 d일 E요일");
		System.out.println(sdf1.format(d));
	}
	public void exam2() {
		Scanner sc = new Scanner(System.in);
		Calendar c = Calendar.getInstance();
		System.out.println("=============== D-Day 계산기 ================");
		
		System.out.print("D-Day [년도] 입력 : ");
		int inputYear = sc.nextInt();
		
		System.out.print("D-Day [월] 입력 : ");
		int inputMonth = sc.nextInt()-1;
		
		System.out.print("D-Day [일] 입력 : ");
		int inputDay = sc.nextInt();
		
		System.out.print("오늘 날짜 :");
		Date d = new Date(c.getTimeInMillis());
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy년 M월 d일");
		System.out.println(sdf1.format(d));
		
		
		System.out.print("D-day 날짜 :");
		c.set(inputYear, inputMonth, inputDay);
		Date d1 = new Date(c.getTimeInMillis());
		System.out.println(sdf1.format(d1));
		
		System.out.println(d);
		System.out.println(d1);
	
		if(d.after(d1))
			System.out.printf("%d일 지났습니다.",(d.getTime() - d1.getTime()) /(24*60*60*1000));
		else if(d1.after(d))
			System.out.printf("%d일 남았습니다.",(d1.getTime() - d.getTime()) /(24*60*60*1000));
		else
			System.out.println("D-day입니다.");
		
		/*
		 * 	Calendar c = Calendar.getInstance();
		 * Calendar dday = Calendar.getInstance();
		System.out.println("=============== D-Day 계산기 ================");
		 * 		System.out.print("D-Day [년도] 입력 : ");
		dday.set(Caldner.YEAR,sc.nextInt());
		
		System.out.print("D-Day [월] 입력 : ");
		dday.set(Calendar.MONTH,sc.nextInt());
		
		System.out.print("D-Day [일] 입력 : ");
		dday.set(Calendar.DAY, sc.nextInt());
		
		 */
	}
}
