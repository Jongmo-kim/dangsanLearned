package kh.java.func;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ImageStream {
	public void main() {
		BufferedReader br = null;// quiz.txt파일을 읽어오기위한 보조스트림 객체
		BufferedOutputStream bos = null; //파일을 내보내기위한 객체
		try (FileReader fr = new FileReader("img/quiz.txt")){//quiz파일과 스트림생성
			br = new BufferedReader(fr);//속도 개선을위한 보조스트림 객체
			bos = new BufferedOutputStream(new FileOutputStream("img.gif"));	//이미지파일을 내보내기위한 객체[
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			ArrayList<Byte> arr = new ArrayList<Byte>();
			while(st.hasMoreTokens()) {
				String no = st.nextToken();
				byte b = (byte)Integer.parseInt(no,16);//두번째 매개변수에는 몇진수 사용할지 radix 뜻숫자표현 및 진법체계에 기준이 되는 수 
				arr.add(b);
			}
			for(Byte i : arr) {
				//fos.write 식으로도 가능 하지만 느림 FileOutputStream fos = new FileOutputStream 이런식으로..
				bos.write(i); //아까만든 img.gif에 쓰기 빠른이유는 비유ㅜ적으로 말했을때 큰바구니를 쓴다고 생각하면됨 담는게 느리지만 한번에 많이들고 갔다오는게 효율적인것처럼
			}
			bos.close(); //저장을위한 닫기
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
