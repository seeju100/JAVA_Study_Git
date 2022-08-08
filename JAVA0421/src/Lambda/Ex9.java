package Lambda;

import java.util.Arrays;
import java.util.function.IntConsumer;

public class Ex9 {

	public static void main(String[] args) {
		/*
		 * 스트림(Stream)
		 * - 여러 자료의 처리에 대한 기능을 구현해 놓은 클래스
		 * - 배열, 컬렉션 등의 자료를 일관성 있게 처리할 수 있다.
		 *   (자료형에 따라 기능을 각각 새로 구현하는것이 아닌
		 *    자료형에 상관없이 같은 방식으로 메서드를 호출할 수 있기 때문)
		 * 
		 * 스트림의 특징
		 * - 자료의 대상과 관계없이 동일한 연산을 수행한다.
		 * - 한번 생성하고 사용한 스트림은 재사용할 수없다.
		 * - 스트림의 연산은 기존 자료를 변경하지 않는다. (스트림 연산을 위해 사용하는 메모리 공간이 별도로 존재)
		 * - 중간연산과 최종연산이 존재한다.
		 *   => 중간연산은 여러개가 적용될 수 있고, 최종연산은 맨 마지막에 한번 적용
		 *      최종연산이 호출되지 않으면 중간연산이 아무리 많더라도 적용되지 않는다.
		 *      이를 지연연산 'lazy evaluation' 이라고함.
		 * 
		 * */
		// 일반적인 배열
		int[] arr = {1, 2, 3, 4, 5};
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		// 스트림을 활용한 람다식
		Arrays.stream(arr).forEach(value -> System.out.println(value));
		
		/*
		 * 스트림의 연산
		 * - 중간연산: filter(), map()
		 * - 최종연산: forEach(), count(), sum(), reduce()
		 * */
		
		// filter: 조건이 참인 경우만 추출하는 경우 사용
		String[] str = {"아이티윌", "부산", "교육센터"};
		Arrays.stream(str).filter(s -> s.length() >= 3).forEach(s -> System.out.println(s));
		
		// map: 요소들을 순회하여 다른형식으로 변환
		Arrays.stream(arr).map(n -> n+10).forEach(n -> System.out.println(n));
		
		// 중간연산은 해당 조건이나 함수에 맞는 결과를 추출해 내는 중간 역할
		// 결국, 최종연산이 있어야한다.
		
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(str));
		
	}

}
