package Lambda;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Ex6 {

	public static void main(String[] args) {
		/*
		 * 3. Function 계열
		 * - 파라미터 리턴 모두 존재
		 * */
		// 람다식
		FunctionTest ft = new FunctionTest();
		ft.addPerson((name, age) -> new Person(name, age), "홍길동", 10);
		System.out.println(ft.person);
		
		ft.printPerson((name) -> {
			
			if(ft.person.name.equals(name)) {
				return ft.person.toString();
			} else {
				return "unknown user";
			}
			
		}, "홍길동");
		
		ft.printPerson(name -> ft.person.name.equals(name) ? ft.person.toString() : "unknown user", "홍길동");
		
		
		System.out.println("----------------------------------------");
		
		// 익명내부클래스로 코딩
		FunctionTest ft2 = new FunctionTest();
		ft2.addPerson(new BiFunction<String, Integer, Person>() {
			
			@Override
			public Person apply(String t, Integer u) {
				return new Person(t, u);
			}
		}, "이순신", 20);
		System.out.println(ft2.person);
		
		ft2.printPerson(new Function<String, String>() {

			@Override
			public String apply(String t) {
				
				if(ft2.person.name.equals(t)) {
					return ft2.person.toString();
				} else {
					return "unknown user";
				}
			}
			
		}, "이순신");
		
	}

}

class Person {
	String name;
	int age;
	
	// Alt + Shift + S -> O
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	// Alt + Shift + S -> S
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
}

class FunctionTest {
	
	Person person;
	
	// String과 Integer를 매개변수로 받고 Person을 리턴하는
	// BiFunction 타입에 String, Integer를 받는 메서드 apply() 메서드 활용
	public void addPerson(BiFunction<String, Integer, Person> function, String name, Integer age) {
		person = function.apply(name, age);
	}
	
	// String을 파라미터로 받고 String을 리턴하는
	// Function 타입에 String을 받는 apply() 메서드 활용
	public void printPerson(Function<String, String> function , String name) {
		System.out.println(function.apply(name));
	}
	
}


















