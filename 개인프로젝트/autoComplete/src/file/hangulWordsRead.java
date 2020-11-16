package file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class hangulWordsRead {
	ArrayList<String> list;
	public hangulWordsRead() {
		list = new ArrayList<String>();
		System.out.println("1: LoL Champ, 2: 한국단어 , 3: 영어단어");
		Scanner sc = new Scanner(System.in);
		String fileName = "";
		System.out.print("선택 >");
		switch(sc.nextInt()) {
		case 1:
			fileName = "lolchamp.txt";
			break;
		case 2:
			fileName = "hangulWords.txt";
			break;
		case 3:
			fileName = "words.txt";
			break;
		}
		
		File file = new File("../autoComplete/src/"+fileName);
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = br.readLine()) != null) {
				list.add(line);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public ArrayList<String> getStringList() {
		return list;
	}
	public void makeTemp() {
		File pasteFile = new File("../autoComplete/src/hangulWords.txt/hangulWords_temp.txt");
		try {
			BufferedWriter bw =new BufferedWriter(new FileWriter(pasteFile));
			for(String str : list) {
				str = deleteNumber(str);
				bw.write(str);
				bw.newLine();
			}
			System.out.println("paste 완료");
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public String deleteNumber(String str) {
		String cutStr = "";
		for(char ch : str.toCharArray()) {
			if(ch>='0' && ch<='9') {//0<=ch<=9
				
			} else {
				cutStr += Character.toString(ch);
			}
		}
		return cutStr;
	}
	

}
