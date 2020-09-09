package kh.wordchain.func;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class checkWordAndMakeDict {
	FileWriter fw;
	FileReader fr;
	BufferedWriter bw;
	BufferedReader br;
	ArrayList<String> dict;
	int length1=0,length2=0;
	public checkWordAndMakeDict() {

		fr = makeNewFileReader("dict.txt");
		br = new BufferedReader(fr);
		makeDict();
		closeBr();
		fw = makeNewFileWriter("word.txt");
		bw = new BufferedWriter(fw);
		insertDictToFile();
		closeBw();
	}
	public void closeBr() {
		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public ArrayList<String> getDict() {
		return dict;
	}
	public void insertDictToFile(){
		for(String str : dict) {
			length2++;
			bwWrite(str);
		}
	}
	public void bwWrite(String str) {
		try {
			bw.write(str+"\r\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void closeBw() {
		try {
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void makeDict() {
		dict = new ArrayList<String>();
		String str = "";
		while( (str = brReadLine() )!=null) {
			length1++;
			if(is2CharAbove(str) && !isContainSingleConsonants(str)) {
				dict.add(str);
				
			}
		}
	}
	public String brReadLine() {
		try {
			return br.readLine();
		} catch (IOException e) {
			return null;
		}
	}
	public FileReader makeNewFileReader(String path) {
		FileReader fr =null;
		try {
			fr = new FileReader(path);
		} catch(IOException e) {
			
		}
		return fr;
	}
	public FileWriter makeNewFileWriter(String path){
		FileWriter fw= null;
		try {
			fw = new FileWriter(path);
		}catch (IOException e) {
		}
		return fw;
	}
	public boolean is2CharAbove(String str) {
		return str.length()>1;
	}
	public boolean isContainSingleConsonants(String str) {
		
		for(int List_i=0;List_i<str.length();++List_i) {
			char ch = str.charAt(List_i);
			if(isSingleConsonant(ch)) {

				return true;
			}
		}
		return false;
	}
	public boolean isSingleConsonant(char ch) {
		return !(ch>='°¡' && ch<='ÆR');// ¿Ï¼ºµÈ ÇÑ±ÛÀÚ´Â '°¡' ~'?' ¹üÀ§¾È¿¡ÀÖÀ½
	}
	public FileInputStream makeNewFileInputStream(String path) {
		FileInputStream fis= null;
		try {
			fis = new FileInputStream(path);
		} catch(FileNotFoundException e) {
			System.out.println("ÆÄÀÏÀ» Ã£À»¼ö ¾ø½À´Ï´Ù.");
		}
		return fis;
	}
	public FileOutputStream makeNewFileOutputStream(String path) {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(path);
		} catch(FileNotFoundException e) {
			System.out.println("ÆÄÀÏÀ» Ã£À»¼ö ¾ø½À´Ï´Ù.");
		}
		return fos;
	}
}
