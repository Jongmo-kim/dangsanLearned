package kcalRecorder.func.file;

import java.util.ArrayList;

import kcalRecorder.model.vo.Meal;

public class FileController {
	private String filePath;
	private String fileName;
	
	public FileController(String filePath,String fileName) {
		
	}
	public void saveFile(ArrayList<Meal> list) {
		
	}
	public ArrayList<Meal> readFile(){
		ArrayList<Meal> list= null;
		
		return list;
	}


	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
