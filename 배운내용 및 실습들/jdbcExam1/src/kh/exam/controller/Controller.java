package kh.exam.controller;

import java.util.ArrayList;
import kh.exam.dao.Dao;
import kh.exam.vo.Memo;
public class Controller {
	public void main() {
		Dao dao = new Dao();
		ArrayList<Memo> list = dao.selectAll();
		if(list.isEmpty()) {
			System.out.println("데이터가 없습니다.");
		}else {
			System.out.println("NO\tNAME\tMSG\tWRITEDAY");
			System.out.println("-----------------------------------");
			for(Memo m : list) {
				System.out.println(m.getNo() + "\t" + m.getName() + "\t" + m.getMsg() + "\t" + m.getWriteday());			
			}
		}
		
	}
}