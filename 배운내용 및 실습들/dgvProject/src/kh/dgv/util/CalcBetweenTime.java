package kh.dgv.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/*
 * 
 * 
 * 부정확함 피드백 필요.
 */

public class CalcBetweenTime {
	static	final long MILLITOMINUTE = 1000 * 60;
	static	final long MILLITOHOUR = 1000 * 60 * 60;
	static	final long MILLITODAY = 1000 * 60 * 60 * 24;
	static  final long MILLITOMONTH = MILLITODAY * 30;
	static  final long MILLITOYEAR = MILLITOMONTH * 12;
	
	public String calc(Calendar startTime,Calendar endTime) {
		StringBuffer s = new StringBuffer();
		long gapBetweenEachTime = endTime.getTimeInMillis() - startTime.getTimeInMillis();
		Calendar calendar = Calendar.getInstance(); //year추출을 위한 선언
		
		SimpleDateFormat whole = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date wholeDate = new Date(gapBetweenEachTime);
		calendar.setTime(wholeDate);
		System.out.println(whole.format(wholeDate)); // 값이 0일때 해당날자는 1970-01-01 09:00:00.000이다. 따라서 기본 값에의한 날짜를 뺴준후 출력한다.
		if((gapBetweenEachTime/MILLITOYEAR)>0) {
			String year = Integer.toString(calendar.get(Calendar.YEAR) - 1970);
			s.append(year);
			s.append("년 ");
		}
		if(gapBetweenEachTime/MILLITOMONTH>0) {
			String month = Integer.toString(calendar.get(Calendar.MONTH) );//calendar의 month는 0~11이므로 빼지않는다
			s.append(month);
			s.append("개월 ");
		}
		if(gapBetweenEachTime/MILLITODAY>0) {
			String day = Integer.toString(calendar.get(Calendar.DAY_OF_MONTH) - 1);
			s.append(day);
			s.append("일 ");
		}
		int inthour = calendar.get(Calendar.HOUR_OF_DAY) - 9;
		String hour ="";
		if(inthour<0) {
			hour = Integer.toString(24+inthour);
		} else {
			hour = Integer.toString(inthour);
		}
		s.append(hour);
		s.append("시간 ");
		String minute = Integer.toString(calendar.get(Calendar.MINUTE));
		s.append(minute);
		s.append("분 ");
		
		return s.toString();
	}
// version 2	
//	public String calc(Calendar startTime,Calendar endTime) {
//		StringBuffer s = new StringBuffer();
//		long gapBetweenEachTime = endTime.getTimeInMillis() - startTime.getTimeInMillis();
//		final long MILLITOMINUTE = 1000 * 60;
//		final long MILLITOHOUR = 1000 * 60 * 60;
//		final long MILLITODAY = 1000 * 60 * 60 * 24;
//		final long MILLITOMONTH = MILLITODAY * 30;
//		final long MILLITOYEAR = MILLITOMONTH * 12;
//		if((gapBetweenEachTime/MILLITOYEAR)>0) {
//			s.append(Long.toString(gapBetweenEachTime/MILLITOYEAR));
//			gapBetweenEachTime = gapBetweenEachTime%MILLITOYEAR;
//			testResult(gapBetweenEachTime, MILLITOYEAR);
//			s.append("년 ");
//		}
//		if(gapBetweenEachTime/MILLITOMONTH>0) {
//			s.append(Long.toString(gapBetweenEachTime/MILLITOMONTH));
//			gapBetweenEachTime = gapBetweenEachTime%MILLITOMONTH;
//			testResult(gapBetweenEachTime, MILLITOMONTH);
//			s.append("개월 ");
//		}
//		if(gapBetweenEachTime/MILLITODAY>0) {
//			s.append(Long.toString(gapBetweenEachTime/MILLITODAY));
//			gapBetweenEachTime = gapBetweenEachTime%MILLITODAY;
//			testResult(gapBetweenEachTime, MILLITODAY);
//			s.append("일 ");
//		}
//		s.append(Long.toString(gapBetweenEachTime/MILLITOHOUR));
//		gapBetweenEachTime = gapBetweenEachTime%MILLITOHOUR;
//		testResult(gapBetweenEachTime, MILLITOHOUR);
//		s.append("시간 ");
//		s.append(Long.toString(gapBetweenEachTime/MILLITOMINUTE));
//		gapBetweenEachTime = gapBetweenEachTime%MILLITOMINUTE;
//		testResult(gapBetweenEachTime, MILLITOMINUTE);
//		s.append("분");
//		return s.toString();
//	}
	public void testResult(long gap,long millito) {
		System.out.printf("Gap \t:%d\n",gap);
		System.out.printf("Millito \t:%d\n",millito);
		System.out.printf("Gap / Millito =(%%d) %d, (%%f)%f\n",gap/millito,(double)gap/millito);
		System.out.println(gap);
		System.out.println(millito);
		//System.out.printf("Gap % Millito =(%%d) %f, (%%f)%f",(double)gap%millito,(double)gap%millito);
		System.out.println();System.out.println();
	}
}
