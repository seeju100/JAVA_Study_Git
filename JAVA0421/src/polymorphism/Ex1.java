package polymorphism;

public class Ex1 {

	public static void main(String[] args) {
		/*
		 * 클래스들의 관계 (Has-a, Is-a)
		 * 1. Has-a (포함 관계)
		 * - 어떤 객체가 다른 객체에 포함되는 관계
		 * - 대부분의 클래스들의 관계는 Has-a 관계가 적용됨
		 * - 자동차 has a 타이어, 스마트폰 has a 스피커, 영웅 has a 무기
		 * 	1) 집합 관계
		 * 		- 객체가 다른 객체에 포함될 때 해당 객체가 없어도 동작에 문제가 없는 관계
		 * 		- 객체 상호산의 라이프 사이클이 다른 관계
		 * 		ex) 자동차 has a 라디오 => 자동차는 라디오가 없어도 자동차
		 * 			컴퓨터 has a 스피커 => 컴퓨터는 스피커가 없어도 컴퓨터
		 * 			영웅 has a 무기 => 무기가 없어도 영웅은 영웅
		 * 	2) 구성 관계
		 * 		- 객체가 다른 객체에 포함될 때 해당 객체 없이는 동작이 불가능한 관계
		 * 		  => 객체가 다른 객체에 포함될때 해당 객체 없이는 동작이 불가능한 관계
		 * 		  ex) 자동차 has a 엔진, 컴퓨터 has a CPU
		 * 
		 * 2. Is-a (상속 관계 kind of) 
		 * - 비슷한 속성 및 동작을 갖는 객체 사이의 관계
		 *   ex) 초등학생, 중학생, 고등학생 객체들의 공통점은 학생
		 *   => 이 때, 학생은 초등학생, 중학생, 고등학생의 상위 개념이므로 모두를 포함
		 *   => 초등학생 is a 학생 => 학생의 모든 구성요소는 초등학생이 갖고 있음
		 *      스마트폰 is a 핸드폰 => 핸드폰의 모든 구성요소는 스마트폰이 갖고 있음
		 * - Is-a 관계가 성립하는 경우 좌변의 객체는 우변의 객체를 상속받아 정의한 객체 성립
		 * - Is-a 관계를 판별하는데 사용하는 연산자 : instanceof 연산자
		 * 
		 * 3. instanceof 연산자
		 * - 좌변의 객체(참조변수)가 우변(클래스) 타입인지 판별하는 연산자
		 *   (=> is-a 관계를 판별하는 연산자)
		 * - 판별 결과는 boolean 타입으로 리턴되며, 결과값이 true 이면 형변환 가능한 관계
		 *   (=> 업캐스팅 또는 다운캐스팅 모두 true 가 리턴됨)
		 *   => 만약, false가 리턴될 경우 어떤 경우에도 형변환이 불가능!     
		 *   
		 * < 기본 문법 >  
		 * if(A instanceof B){ // => A는 참조변수, B는 클래스 또는 인터페이스
		 * 		// A is a B 가 성립될때 실행할 코드들...(업캐스팅 또는 다운캐스팅 등)
		 * }
		 * */
		SmartPhone sp = new SmartPhone("010-1234-5678", "안드로이드");
		// SmartPhone 타입으로 접근 가능한 메서드 : 3개
		sp.call();
		sp.sms();
		sp.kakaoTalk();
		
		// instanceof 연산자 활용
		// sp 는 SmartPhone 입니까? YES
		if(sp instanceof SmartPhone) {
			System.out.println("sp는 SmartPhone이다!");
		} else {
			System.out.println("sp는 SmartPhone이 아니다!");
		}
		
		System.out.println("-----------------------------");
		
		if(sp instanceof Handpone) {
			System.out.println("sp는 HandPone이다!");
		} else {
			System.out.println("sp는 HandPone이 아니다!");
		}
		
		System.out.println("----------------------------");
		
		// 서브클래스(SmartPhone) 타입 변수 sp를
		// 슈퍼클래스(HandPhone) 타입으로 변환 가능한지 여부 판별을 위한 질문
		
		Handpone hp = new Handpone("010-1111-2222");
		
		// hp는 SmartPhone 입니까?
		if(hp instanceof SmartPhone) {
			System.out.println("hp는 SmartPhone 이다!");
		} else {
			System.out.println("hp는 SmartPhone이 아니다!");
			System.out.println("그러므로, hp는 SmartPhone으로 형변환이 불가능!");
			System.out.println("hp는 SmartPhone이 가진 기능을 모두 포함하지 않는다!");
		}
		
		System.out.println("------------------------------------");
		
		// SmartPhone -> HandPhone 타입으로 업캐스팅
		Handpone hp2 = new SmartPhone("010-1234-5678", "안드로이드");
		hp2.call();
		hp2.sms();
//		hp2.kakaTalk();	// 사용불가능한 기능
		
		if(hp2 instanceof SmartPhone) {
			System.out.println("hp2는 SmartPhone이다!");
			System.out.println("그러므로 hp2는 SmartPhone 으로 형변환이 가능하다!");
			
			SmartPhone sp2 = (SmartPhone)hp2;
			sp2.call();
			sp2.sms();
			sp2.kakaoTalk();
			
		} else {
			System.out.println("hp2는 SmartPhone이 아니다!");
		}
		
		System.out.println("-----------------------------");
		
		if(hp2 instanceof Handpone) {
			System.out.println("hp2는 HandPhone 이다!");
		} else {
			System.out.println("hp2는 HandPhone이 아니다!");
		}
		
		
	}

}

class Handpone {
	String number;
	
	public Handpone(String number) {
		this.number = number;
	}
	
	public void call() {
		System.out.println("전화 기능!");
	}
	
	public void sms() {
		System.out.println("문자 기능!");
	}
}

class SmartPhone extends Handpone {
	String osName;
	
	public SmartPhone(String number, String osName) {
		// 슈퍼 클래스(Handpone) 생성자 중 기본 생성자가 없으므로
		// 반드시 파라미터 생성자 명시적으로 호출 해야한다!
		super(number);
		this.osName = osName;
	}
	
	public void kakaoTalk() {
		System.out.println("카톡 기능!");
	}
}


















