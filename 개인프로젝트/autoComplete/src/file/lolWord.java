package file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class lolWord {
	
	public lolWord(){
		File file = new File("C:\\dangsanLearned\\autoComplete\\src\\lolchamp.txt");
		File pasteFile = new File("C:\\dangsanLearned\\autoComplete\\src\\lolchamp_temp.txt");
		try {
			FileWriter fw = new FileWriter(pasteFile);
			FileReader fr = new FileReader(file);
			int ch;
			
			while( (ch = fr.read())!= -1) {
				if(ch==' ') {
					ch='\n';
					
				}
				System.out.print((char)ch);
				fw.write((char)ch);
			}
			fw.close();
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			
		}
	}
}
