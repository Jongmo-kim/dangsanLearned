package file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class fileRead {
	ArrayList<String> list;
	public fileRead() {
		list = new ArrayList<String>();
		File file = new File("C:\\dangsanLearned\\autoComplete\\src\\words.txt");
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = br.readLine()) != null) {
				list.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public ArrayList<String> getStringList() {
		return list;
	}
}
