package kh.java.func;

public class TV {
	//속성 : 크기,전원,채널,볼륨 -> 전역변수로 생성
	public int inch;
	public boolean power;
	public int channel;
	public int volume;
	///기능전원(on/off),채널 업,채널 다운, 볼륨업,볼륨 다운 -> 메소드로 생성
	public void power() {
		power= !power;
		if(power) {
			System.out.println("전원이 켜졌습니다.");
		} else {
			System.out.println("전원이 꺼졌습니다.");
		}
	}
	public void channelUp() {
		channel++;
		System.out.println("현재 채널"+channel);
	}

	public void channelDown() {
		channel--;
		System.out.println("현재 채널"+channel);
	}
	public void volumeUp() {
		volume++;
		System.out.println("현재 볼륨"+volume);
	}

	public void volumeDown() {
		volume--;
		System.out.println("현재 볼륨"+volume);
	}


}
