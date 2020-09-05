package kr.test.start;

import java.util.Calendar;

public class CalcBetweenTime {
	public String calc(Calendar startTime,Calendar endTime) {
		StringBuffer s = new StringBuffer();
		long gapBetweenEachTime = endTime.getTimeInMillis() - startTime.getTimeInMillis();
		Calendar calendar = Calendar.getInstance(); //year������ ���� ����
		final long MILLITOMINUTE = 1000 * 60;
		final long MILLITOHOUR = 1000 * 60 * 60;
		final long MILLITODAY = 1000 * 60 * 60 * 24;
		final long MILLITOMONTH = MILLITODAY * 30;
		final long MILLITOYEAR = MILLITOMONTH * 12;
		if(gapBetweenEachTime>MILLITOYEAR) {
			s.append(Long.toString(gapBetweenEachTime/MILLITOYEAR));
			gapBetweenEachTime = gapBetweenEachTime%MILLITOYEAR;
			s.append("�� ");
		}
		if(gapBetweenEachTime>MILLITOMONTH) {
			s.append(Long.toString(gapBetweenEachTime/MILLITOMONTH));
			gapBetweenEachTime = gapBetweenEachTime%MILLITOMONTH;
			s.append("���� ");
		}
		if(gapBetweenEachTime>MILLITODAY) {
			s.append(Long.toString(gapBetweenEachTime/MILLITODAY));
			gapBetweenEachTime = gapBetweenEachTime%MILLITODAY;
			s.append("�� ");
		}
		s.append(Long.toString(gapBetweenEachTime/MILLITOHOUR));
		gapBetweenEachTime = gapBetweenEachTime%MILLITOHOUR;
		s.append("�ð� ");
		s.append(Long.toString(gapBetweenEachTime/MILLITOMINUTE));
		gapBetweenEachTime = gapBetweenEachTime%MILLITOMINUTE;
		s.append("��");
		return s.toString();
	}
}
