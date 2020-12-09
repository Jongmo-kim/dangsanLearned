package kr.test.start;

import java.sql.ResultSet;
import java.sql.SQLData;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Scanner;
import java.util.Set;

import kh.java.trie.Hanoi;
import kh.java.trie.Trie;
import kh.java.trie.Trie.trieNode;
import kh.java.trie.likesType;



public class Start{
	public static void main(String args[]) {
		String startDate = "\"1970-01-01T09:01:00.000Z\"";
		String endDate  = "\"2020-11-13T15:23:25.000Z\"";
		
		DateFormat dateFormat = new SimpleDateFormat("\"yyyy-MM-dd'T'HH:mm:ss.SSS'Z'\"");
		try {
			Date utilDate = dateFormat.parse(startDate);
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			System.out.println("sqlDate : " + dateFormat.format(sqlDate));
			System.out.println("test :" + dateFormat.parse(startDate).getTime());
			String parseDate = dateFormat.format(utilDate);
			System.out.println(parseDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
	
}