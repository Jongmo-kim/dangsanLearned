package file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class hangulWordsRead {
	ArrayList<String> list;
	public hangulWordsRead() {
		list = new ArrayList<String>();
		File file = new File("C:\\dangsanLearned\\autoComplete\\src\\hangulWords.txt");
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
	public void makeTemp() {
		File pasteFile = new File("C:\\dangsanLearned\\autoComplete\\src\\hangulWords_temp.txt");
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
	public ArrayList<String> getStringList() {
		return list;
	}
}
