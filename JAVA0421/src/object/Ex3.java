package object;

public class Ex3 {

	public static void main(String[] args) {
		/*
		 * 4. toString() 메서드
		 * - 어떤 객체의 정보를 문자열로 변환하여 리턴하는 메서드
		 * - Object 클래스의 toString() 메서드는 객체의 클래스명과 주소값을 결합한 문자열 리턴
		 *   => getClass() 와 hashCode() 메서드 결과를 변형하여 문자열로 리턴해줌
		 * - 일반적으로 객체의 정보란 객체가 가진 고유의 데이터(멤버변수값)를 의미하므로
		 *   클래스 정의 시 Object 클래스의 toString() 메서드 오버라이딩을 통해
		 *   객체의 멤버변수 값들을 문자열로 결합하여 리턴하도록 해야한다!
		 * - 출력문 내에서 참조변수명.toString() 을 호출하여 리턴값을 바로 출력하거나
		 *   리턴값을 String 타입 변수에 저장할 수 있다!
		 *   또한, 출력문 내에서 toString() 메서드 생략이 가능하므로
		 *   참조변수명을 출력문 내에 전달 시 자동으로 toString() 메서드가 호출됨
		 *   ex) System.out.println(str); 또는 System.out.println(str.toString());    
		 * - 일반적으로 자바에서 제공되는 대부분의 API에는 toString() 메서드가
		 *   오버라이딩 되어 있으므로 객체 내의 멤버변수 값을 쉽게 확인 가능함  
		 * 
		 * */
		Person p1 = new Person("홍길동", 20);
		System.out.println(p1.toString()); // Person@15db9742
		// toString() 메서드 호출하면 "클래스명@해시코드값" 형태로 문자열 리턴됨
		
		System.out.println("클래스명: " + p1.getClass().getName());
		System.out.println("해시코드: " + p1.hashCode());
		
		System.out.println("객체 p1의 정보: " + p1);
		
		System.out.println("===================================");
		
		ToStringPerson p2 = new ToStringPerson("홍길동", 20);
		System.out.println("객체 p2의 정보: " + p2.toString());
		System.out.println("객체 p2의 정보: " + p2); // toString() 메서드가 생략되어 있음.
		
		// toString() 메서드가 적용된 대표적인 예 : String 클래스
		String str = "홍길동";
		System.out.println(str);
		System.out.println(str.toString());
		
		
	}

}

class ToStringPerson {
	String name;
	int age;
	
	public ToStringPerson(String name, int age) {
		this.name = name;
		this.age = age;
	}

	
	
//	@Override
//	public String toString() {
//		return name + ", " + age;
//	}
	
	// toString() 메서드 자동 오버라이딩 단축키: Alt + Shift + S -> S
	@Override
	public String toString() {
		return "ToStringPerson [name=" + name + ", age=" + age + "]";
	}
	
}












