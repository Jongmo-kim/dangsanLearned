package kh.java.func;

public class TV {
	//�Ӽ� : ũ��,����,ä��,���� -> ���������� ����
	public int inch;
	public boolean power;
	public int channel;
	public int volume;
	///�������(on/off),ä�� ��,ä�� �ٿ�, ������,���� �ٿ� -> �޼ҵ�� ����
	public void power() {
		power= !power;
		if(power) {
			System.out.println("������ �������ϴ�.");
		} else {
			System.out.println("������ �������ϴ�.");
		}
	}
	public void channelUp() {
		channel++;
		System.out.println("���� ä��"+channel);
	}

	public void channelDown() {
		channel--;
		System.out.println("���� ä��"+channel);
	}
	public void volumeUp() {
		volume++;
		System.out.println("���� ����"+volume);
	}

	public void volumeDown() {
		volume--;
		System.out.println("���� ����"+volume);
	}


}
