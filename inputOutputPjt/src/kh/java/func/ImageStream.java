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
		BufferedReader br = null;// quiz.txt������ �о�������� ������Ʈ�� ��ü
		BufferedOutputStream bos = null; //������ ������������ ��ü
		try (FileReader fr = new FileReader("img/quiz.txt")){//quiz���ϰ� ��Ʈ������
			br = new BufferedReader(fr);//�ӵ� ���������� ������Ʈ�� ��ü
			bos = new BufferedOutputStream(new FileOutputStream("img.gif"));	//�̹��������� ������������ ��ü[
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			ArrayList<Byte> arr = new ArrayList<Byte>();
			while(st.hasMoreTokens()) {
				String no = st.nextToken();
				byte b = (byte)Integer.parseInt(no,16);//�ι�° �Ű��������� ������ ������� radix �����ǥ�� �� ����ü�迡 ������ �Ǵ� �� 
				arr.add(b);
			}
			for(Byte i : arr) {
				//fos.write �����ε� ���� ������ ���� FileOutputStream fos = new FileOutputStream �̷�������..
				bos.write(i); //�Ʊ�� img.gif�� ���� ���������� ������������ �������� ū�ٱ��ϸ� ���ٰ� �����ϸ�� ��°� �������� �ѹ��� ���̵�� ���ٿ��°� ȿ�����ΰ�ó��
			}
			bos.close(); //���������� �ݱ�
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
