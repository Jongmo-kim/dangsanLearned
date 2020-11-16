package kh.point.start;

import java.util.Scanner;

import kh.or.iei.controller.PointMgr;
import kh.point.model.vo.*;

/*
1. �����Է� �� �Ѹ� �Է¹�����, �Է������� ���, �̸�, ����Ʈ������ �Է¹޴´�.
2. ���� ��� �� ���, �̸�, ����Ʈ����, ���ʽ�����Ʈ �� 4�� ������ ����Ѵ�.
3. ���ʽ� ����Ʈ�� ����Ʈ ������ ��޺� ������ ����Ǹ� ���� �Է� �� ����Ʈ ������ �Է��ϸ� �ڵ����� ó���Ǿ�� �Ѵ�.
	-> �� ��޺� ���ʽ� ����Ʈ ���� - silver : 2%, gold : 5%, vip : 7%
4. ȸ���������(1��), ��������, ȸ��Ż�� ����� ��� �̸��� �Է¹޾Ƽ� ó���Ѵ�.(�̸��� �ߺ����� �ʴ´ٰ� �����Ѵ�.)
 */
public class Start {
	public static void main(String[] args) {
		PointMgr f = new PointMgr();
		int choice;
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("------ ����Ʈ ���� ���α׷� ------");
			System.out.println("1. ȸ�� ���� ���");
			System.out.println("2. ȸ�� ��ü ���� ���");
			System.out.println("3. ȸ�� ���� ���(1��)");
			System.out.println("4. ȸ�� ���� ����");
			System.out.println("5. ȸ�� ���� ����");
			System.out.print("���� >");choice = sc.nextInt();
			switch(choice) {
			case 1:
				f.addPoint();
				break;
			case 2:
				f.showAll();
				break;
			case 3:
				f.showOne();
				break;
			case 4:
				f.modifyPoint();
				break;
			case 5:
				f.deletePoint();
				break;
			default:
				return;
			}
		}
	}
}
