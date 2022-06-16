package book;

public class Ex1 {

	public static void main(String[] args) {
		// 386p
		// Q1)
		// 두 개의 인스턴스가 메모리는 다르더라도 논리적으로 동일하다는 것을 
		// 구현하는 Object의 메서드를 eXXX 입니다. 정답: equals()
		
		// Q2)
		// String 클래스는 멤버로 가지는 문자열 변수가 final이어서 변하지 않습니다. 다음과 같이 두 개의
		// String 변수를 연결할 때 힙 메모리에 생성되는 String 인스턴스를 그려보세요.
//		String a = new String("abc");
//		String b = new String("def");
//		a = a + b;
//		String c = new String("abc");
//		String d = "abc";
		
		// ------------------------------------
//		String a = "abc";
//		String b = "def";
//		a = a + b;
//		String c = "abc";
//		System.out.println(a == c);
		
		// Q3)
		// 기본 자료형을 멤버 변수로 포함하여 메서드를 제공함으로써 기본 자료형의 객체를 
		// 제공하는 클래스를 WXXX 라고 합니다. 정답: Wrapper Class
		
		// Q4)
		MyDog dog = new MyDog("멍멍이", "진돗개");
		System.out.println(dog);	// 출력결과: 진돗개 멍멍이 
		
	}

}

//Q4)
//다음 코드의 결과가 '진돗개 멍멍이' 가 되도록 MyDog클래스를 수정하세요.
class MyDog {
	String name;
	String type;
	
	public MyDog(String name, String type) {
		this.name = name;
		this.type = type;
	}

	@Override
	public String toString() {
		return type + " " + name;
	}
}









