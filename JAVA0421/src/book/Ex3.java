package book;

import java.util.ArrayList;
import java.util.List;

public class Ex3 {

	public static void main(String[] args) {
		// 484p
		// Q1)
		// 지역 내부 클래스에서 외부 클래스 메서드의 지역변수를 사용할 수 있지만,
		// 그 값을 변경하면 오류가 발생합니다. 이때 사용하는 지역 변수는 fXXX 변수가 되기 때문입니다.
		// 정답: final
		
		// Q2)
		// 내부 클래스 중 클래스 이름 없이 인터페이스나 추상 클래스 자료형에 직접 대입하여
		// 생성하는 클래스를 익XXX 라고 합니다.
		// 정답: 익명클래스
		
		// Q3)
		// 자바에서 제공하는 함수형 프로그래밍 방식으로 인터페이스의 메서드를 직접 구현하는
		// 코드를 람XXX 라고 합니다.
		// 정답: 람다식
		
		// Q4)
		// 람다식으로 구현할 수 있는 인터페이스는 메서드를 하나만 가져야합니다.
		// 이러한 인터페이스를 함XXX 라고 합니다.
		// 정답: 함수형 인터페이스 @FunctionalInterface
		
		// Q5)
		// 다음과 같이 두 정수를 매개변수로 하는 메서드가 인터페이스에 정의되어 있습니다.
		// 두 정수의 합을 반환하는 람다식을 구현하고 호출해보세요.
		
		// 구현
		Calc cal = (num1, num2) -> num1 + num2;
		// 호출
		System.out.println(cal.add(10, 20));
		
		// Q6)
		List<Book> bookList = new ArrayList<Book>();
		bookList.add(new Book("자바", 25000));
		bookList.add(new Book("파이썬", 15000));
		bookList.add(new Book("안드로이드", 30000));
		
		// 위와 같을 때 스트림을 활용하여 다음처럼 책 목록을 출력해보세요.
		// 1. 모든 책의 가격의 합
		int total = bookList.stream().mapToInt(book -> book.getPrice()).sum();
		System.out.println(total);
		
		// 2. 책의 가격이 20000원 이상인 책의 이름을 정렬하여 출력
		bookList.stream().filter(book -> book.getPrice() >= 20000)
						 .map(book -> book.getName())
						 .sorted().forEach(b -> System.out.println(b));
	}

}

// Q5)
interface Calc {
	public int add(int num1, int num2);
}

//Q6)
class Book {
	private String name;
	private int price;
	
	public Book(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}
	
}









