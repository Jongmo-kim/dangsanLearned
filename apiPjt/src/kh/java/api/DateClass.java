package kh.java.api;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class DateClass {
	public void dateTest() {
		Date d =  new Date(); //���� �ý��۽ð�
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
		//calendar Ŭ�������
		//1. ���� ��¥�� ����  ��ü ����
		//2. ��, ��, ��, ��, ��, �� ���� ���� ������ �и��Ͽ� ������ �� �ϳ��� ���ڿ��� ���
		//������� : 2020�� 9�� 2�� ȭ����
		
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
			dayofweek="��";
			break;
		case 3:
			dayofweek="ȭ";
			break;
		case 4:
			dayofweek="��";
			break;
		case 5:
			dayofweek="��";
			break;
		case 6:
			dayofweek="��";
			break;
		case 7:
			dayofweek="��";
			break;
		case 1:
			dayofweek="��";
			break;
		}
		System.out.printf("%d�� %d�� %d�� %s����\n",year,month,day,dayofweek);
		Date d = new Date(c.getTimeInMillis());
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy�� M�� d�� E����");
		System.out.println(sdf1.format(d));
	}
	public void exam2() {
		Scanner sc = new Scanner(System.in);
		Calendar c = Calendar.getInstance();
		System.out.println("=============== D-Day ���� ================");
		
		System.out.print("D-Day [�⵵] �Է� : ");
		int inputYear = sc.nextInt();
		
		System.out.print("D-Day [��] �Է� : ");
		int inputMonth = sc.nextInt()-1;
		
		System.out.print("D-Day [��] �Է� : ");
		int inputDay = sc.nextInt();
		
		System.out.print("���� ��¥ :");
		Date d = new Date(c.getTimeInMillis());
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy�� M�� d��");
		System.out.println(sdf1.format(d));
		
		
		System.out.print("D-day ��¥ :");
		c.set(inputYear, inputMonth, inputDay);
		Date d1 = new Date(c.getTimeInMillis());
		System.out.println(sdf1.format(d1));
		
		System.out.println(d);
		System.out.println(d1);
	
		if(d.after(d1))
			System.out.printf("%d�� �������ϴ�.",(d.getTime() - d1.getTime()) /(24*60*60*1000));
		else if(d1.after(d))
			System.out.printf("%d�� ���ҽ��ϴ�.",(d1.getTime() - d.getTime()) /(24*60*60*1000));
		else
			System.out.println("D-day�Դϴ�.");
		
		/*
		 * 	Calendar c = Calendar.getInstance();
		 * Calendar dday = Calendar.getInstance();
		System.out.println("=============== D-Day ���� ================");
		 * 		System.out.print("D-Day [�⵵] �Է� : ");
		dday.set(Caldner.YEAR,sc.nextInt());
		
		System.out.print("D-Day [��] �Է� : ");
		dday.set(Calendar.MONTH,sc.nextInt());
		
		System.out.print("D-Day [��] �Է� : ");
		dday.set(Calendar.DAY, sc.nextInt());
		
		 */
	}
}
