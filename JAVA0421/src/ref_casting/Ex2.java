package ref_casting;

public class Ex2 {

	public static void main(String[] args) {
//		업캐스팅, 다운캐스팅 = 다형성? (X)
		// 업캐스팅, 다운캐스팅 + 오버라이딩 = 다형성(O)
		검 검 = new 검();
		활 활 = new 활();
		총 총 = new 총();
		
		// 1.
		무기[] 무기s = {검, 활, 총};
		for (무기 무기 : 무기s) {
			무기.attack();
		}
		System.out.println("-----------------------------------------1");
		Hero 바바리안 = new Hero();
		바바리안.setWeapon(검);
		바바리안.무기.attack();
		바바리안.setWeapon(총);
		바바리안.무기.attack();
	}

}

class Hero {
	private String name;
	private int demage;
	public 무기 무기;
	
	public void setWeapon(무기 무기) {
		this.무기 = 무기;
	}
	
	
}


class 무기 {
	int demage;
	public void attack() {
		System.out.println("무기로 " + demage + "만큼 때림");
	}
}

class 검 extends 무기 {

	@Override
	public void attack() {
		System.out.println("검으로 " + demage + "만큼 때림");
	}
	
}
class 활 extends 무기 {
	@Override
	public void attack() {
		System.out.println("활로 " + demage + "만큼 때림");
	}
}

class 총 extends 무기 {
	@Override
	public void attack() {
		System.out.println("총으로 " + demage + "만큼 때림");
	}
}







