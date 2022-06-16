package book;

import java.util.HashSet;
import java.util.Iterator;

public class Ex2 {

	public static void main(String[] args) {
		// 446p
		// Q1)
		// 자료구조를 사용하기 편리하도록 자바에서 제공하는 라이브러리를 컬XXX 라고 합니다.
		// 정답: 컬렉션 프레임워크, 컬렉션 라이브러리, 컬렉션 API
		
		// Q2)
		// 클래스에서 여러 자료형을 사용할 때 자료형을 명시하지 않고 자료형을 의미하는
		// 문자로 선언한 후 실제 클래스를 생성할 때 자료형을 명시하는 프로그래밍 방식을 제XXX 이라고 합니다.
		// 정답: 제네릭
		
		// Q3)
		// Collection 인터페이스를 구현한 클래스를 순회하기 위해 사용하는 인터페이스는 IXXX 입니다.
		// 정답: Iterator
		
		// Q5)
		// 출력결과가 다음과 같도록 Student 클래스를 구현해 보세요.
		HashSet<Student> set = new HashSet<Student>();
		set.add(new Student("100", "홍길동"));
		set.add(new Student("200", "강감찬"));
		set.add(new Student("300", "이순신"));
		set.add(new Student("400", "정약용"));
		set.add(new Student("100", "송중기"));
		
		System.out.println(set);
		// < 출력 결과 > (출력 순서는 무관)
		// [100:홍길동, 200:강감찬, 300:이순신, 400:정약용, 100:송중기]
	}

}

class Student {
	String num;
	String name;
	
	public Student(String num, String name) {
		this.num = num;
		this.name = name;
	}

	@Override
	public String toString() {
		return num + ":" + name;
	}
	
}








