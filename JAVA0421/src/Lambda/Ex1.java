package Lambda;

import java.util.Arrays;
import java.util.Comparator;

public class Ex1 {

	public static void main(String[] args) {
		/*
		 * 람다식(Lambda Expressions)
		 * - 자바 8에 추가된 가장 큰 특징
		 * - "함수형" 프로그래밍 형태를 받아들인 결과
		 * 
		 * 함수형 프로그래밍이란? (함수형 vs 객체지향)
		 * - 함수형: 1950년대, 객체지향: 1990년대 (역사가 더 오래되긴 함)
		 * - 기능 위주의 프로그래밍 기법
		 * - 객체지향: 클래스에 속성과 기능을 정의
		 *   함수형: 기능 즉, 함수가 따로 존재
		 *   
		 * < 기본 문법 >
		 * (데이터타입 매개변수, ...) -> { 실행문... }
		 * 
		 * 1. 기본형
		 * (int x) -> { System.out.println(x); }
		 * 
		 * 2. 매개변수의 타입을 추론 할 수 있는 경우에는 타입 생략 가능
		 * (x) -> { System.out.println(x); }
		 * 
		 * 3. 매개변수나 실행문이 하나라면 소괄호() 와 중괄호{}를 생략 할수 있다.
		 *    (이때, 세미콜론(;)은 생략!)
		 * x -> System.out.println(x)
		 *   
		 * 4. 매개변수가 없을 경우에는 소괄호()를 사용한다. (생략불가)
		 * () -> System.out.println(x)
		 * 
		 * 5. 리턴이 필요한 경우 return 키워드를 사용
		 * (x, y) -> { return x + y; }
		 * 
		 * 6. 실행문이 단순히 return 문 하나로 표현되는 경우
		 *    표현식만 사용할 수 있으며, 이때 리턴 값은 표현식의 결과값이 된다.
		 *    (주의! 이때, 세미콜론은 붙이지 않는다!)
		 * (x, y) -> x + y   
		 *   
		 * */
		
		String[] str = {"this", "is", "java", "world"};
		Integer[] arr = {10, 20, 22, 78, 12, 55};
		
		System.out.println(Arrays.toString(str));
		Arrays.sort(str);
		// 오름 차순으로 정렬 후: [is, java, this, world]
		System.out.println(Arrays.toString(str));
		
		/*
		 * 새로운 정렬기능을 만들려면?
		 * => 내부적으로 Comparator의 compare 메서드를 사용하기 때문에
		 *    새로운 기능을 만들고 Arrays.sort() 에 전달하면됨!
		 *    => 자바에서는 함수만 전달할 방법이? 없다!
		 *       따라서, 해당 기능을 가지는 객체를 전달해야한다.
		 *       일회용으로 정렬 기능을 작성하려면? (익명의 내부 클래스)
		 * */
		
//		Arrays.sort(str, new Comparator<String>() {
//
//			@Override
//			public int compare(String o1, String o2) {
//				// -1을 곱해서 내림차순으로 정렬한다.
//				return o1.compareTo(o2) * -1;
//			}
//		});
		
		
		Arrays.sort(str, (o1, o2) -> o1.compareTo(o2) * -1);
		Arrays.sort(arr, (o1, o2) -> o1.compareTo(o2) * -1);
		
		// 내림차순 정렬 후: [world, this, java, is]
		System.out.println(Arrays.toString(str));
		System.out.println(Arrays.toString(arr));
		
		/*
		 * - 결국 정령을 위해 필요했던 '기능'은 Comparator가 아니라
		 *   사실 compare() 라는 메서드!
		 * - compare() 메서드 만 있으면 되지만, 자바언어의 특성으로 인해
		 *   익명의 내부클래스를 만들고 객체화해서 전달하고 있다!  
		 * - 이러한 번거로움을 없애기 위해 람다식이 등장!  
		 * 
		 * */
		
		System.out.println("------------------------------");
		Arrays.sort(str, (String o1, String o2) -> { return o1.compareTo(o2) * -1; });
		Arrays.sort(str, (o1, o2) -> { return o1.compareTo(o2) * -1; });
		Arrays.sort(str, (o1, o2) -> o1.compareTo(o2) * -1 );
		
		
		
		
		
	}

}



