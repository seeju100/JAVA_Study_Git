package collection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Ex1 {

	public static void main(String[] args) {
		/*
		 * 컬렉션 프레임워크(Collection Framework)
		 * - 컴퓨터 시스템에서 데이터를 효율적으로 저장 및 관리하는 방법 - 자료구조론
		 *   => 자바에서 자료구조를 구현하여 제공하는 클래스들의 모음
		 *   => 기타 대부분의 언어들은 자료구조를 개발자가 직접 구현해야하지만
		 *      자바는 클래스 내의 메서드를 통해 자료구조를 활용할 수 있도록 지원해준다.
		 * - java.util 패키지에 클래스 및 인터페이스 형태로 제공됨
		 * - 컬렉션 3대 인터페이스 : Set, List, Map   
		 *   => 각 인터페이스를 구현한 구현체 클래스들이 제공됨
		 *   => 이 중, Set과 List 계열은 Collection 인터페이스를 공통으로 상속받았으므로
		 *      대부분의 메서드가 동일함
		 *      
		 * 1. Set 계열
		 * 		- 저장 순서가 유지되지 않음(인덱스 사용 불가)
		 * 		- 데이터 중복을 허용하지 않음(중복 데이터는 저장되지 않는다!)    
		 * 		  => 아주 효율적인 중복제거 수단으로 사용됨
		 *      - Set 계열의 구현체 클래스 : HashSet, TreeSet 등
		 * 
		 * */
		
		// HashSet 객체 생성
//		HashSet set = new HashSet(); // 일반적인 HashSet 객체 생성 방법
		
		// HashSet -> Set 업캐스팅하여 사용하는 방법
		// => 대부분의 메서드를 부모 인터페이스인 Set인터페이스가 보유중이므로
		//    업캐스팅 상태에서도 대부분의 기능을 사용하는데 문제가 없음
		Set set = new HashSet();
		
		// Set 객체의 메서드
		// boolean isEmpty() : 컬렉션 객체가 비어있는지 판별
		System.out.println("Set 객체가 비어있는가? " + set.isEmpty());
		
		// int size() : 컬렉션 객체 내의 요소(데이터)갯수 리턴
		System.out.println("Set 객체에 저장된 요소 갯수 : " + set.size());
		
		// String toString() : 컬렉션 객체 내의 모든 요소를 문자열로 리턴(오버라이딩)
		System.out.println("Set 객체의 모든 요소 : " + set.toString());
		System.out.println("Set 객체의 모든 요소 : " + set);	// 생략가능
		
		System.out.println("---------------------------------");
		
		// boolean add(Object e) : 요소 1개(e)를 컬렉션에 추가 후 추가 성공여부 리턴
		// => 파라미터가 Object 타입이므로 모든 데이터타입 추가 가능(기본형, 객체 모두 가능)
		// => 리턴타입이 boolean 이므로 요소 추가 성공 여부 리턴됨(중복데이터는 추가 X)
		set.add(1);
		set.add("TWO");
		set.add(3.14);
		
		System.out.println("Set 객체가 비어있는가? " + set.isEmpty());
		System.out.println("Set 객체에 저장된 요소 갯수 : " + set.size());
		System.out.println("Set 객체의 모든 요소 : " + set);
		// => 저장 순서가 유지되지 않으므로 출력되는 데이터의 순서는 다를 수 있다!
		
		System.out.println("실수 3.14 추가 가능한가? " + set.add(3.14));
//		System.out.println("실수 3.14 추가 가능한가? " + set.add("3.14")); // 데이터타입이 달라서 true
		System.out.println("문자 '4' 추가 가능한가? " + set.add('4'));
		System.out.println("Set 객체의 모든 요소 : " + set);
		
		System.out.println("------------------------------------");
		
		// boolean contains(Object o) : 특정 요소(o)가 컬렉션 객체에 포함되어 있는지 판별
		System.out.println("Set 객체의 실수 3.14가 포함되어 있는가? " + set.contains(3.14));
//		System.out.println("Set 객체의 실수 3.14가 포함되어 있는가? " + set.contains("3.14"));
		System.out.println("Set 객체에 정수 3이 포함되어 있는가? " + set.contains(3));
		
		// boolean remove(Object o) : 특정 요소(o)를 컬렉션 객체에서 제거
		System.out.println("Set 객체 내의 실수 3.14 삭제: " + set.remove(3.14));
		System.out.println("Set 객체 내의 실수 3.14 삭제: " + set.remove(3.14));
		System.out.println("Set 객체의 모든 요소 : " + set);
		
		Object[] objArr = set.toArray();
		System.out.println(Arrays.toString(objArr));
		System.out.println(objArr[0]);
		
		// addAll()
		Set set2 = new HashSet();
		set2.add(9); set2.add(10); set2.add(1);
		
		System.out.println("Set2 객체에 set 객체 모두 추가 : " + set2.addAll(set));
		System.out.println("Set2 객체의 모든 요소 : " + set2);
		System.out.println("Set2 객체에 set 객체 모두 추가 : " + set2.addAll(set)); 
		
		// clear() : 컬렉션 내의 모든 요소 초기화(제거)
		set2.clear();
		System.out.println("Set2 객체의 모든 요소 : " + set2);
		
		// HashSet 등 컬렉션 객체 생성 시 파라미터로 다른 컬렉션 객체를 전달하면
		// 해당 컬렉션 객체의 요소를 갖는 새로운 컬렉션 객체가 생성됨
	 	Set set3 = new HashSet(set);
	 	System.out.println("Set3 객체의 모든 요소 : " + set3);
	 	System.out.println("Set 객체의 모든 요소 : " + set);
		
		System.out.println("set 과 set3 객체는 동일한 객체인가? " + (set == set3));
		// boolean equals(Collection c) : 컬렉션 요소가 동일한지 판별
		System.out.println("set 과 set3 객체는 동일한 객체인가? " + set.equals(set3));
		
		System.out.println("=======================================");
		
		// TreeSet 객체를 활용하면 같은 타입 데이터가 저장된 Set 객체 정렬가능
		// => 주의! 반드시 같은 타입 데이터만 저장해야한다!
		// => 이진 탐색 트리(Binary Search Tree)를 개량한 레드-블랙 트리(Red-Black Tree)구조 사용
		// => 수치 데이터는 수치의 크기순으로 오름차순 정렬되며(0 -> 9)
		//    문자데이터는 문자 코드값의 크기 순으로 오름차순 정렬되므로
		//    수치 데이터와 문자 데이터의 정렬 결과는 다를 수 있다!
		Set set4 = new HashSet();
		
		set4.add(100);
		set4.add(99);
		set4.add(999);
		set4.add(2);
		set4.add(500);
		set4.add(35);
		System.out.println(set4);
		
		Set<Integer> set5 = new TreeSet(set4);
		System.out.println(set5); // [2, 35, 99, 100, 500, 999] => 항상 결과 같음(정렬)
		
		System.out.println("================================");
		
		/*
		 * Set 계열의 모든 요소를 반복문을 통해 출력
		 * => 인덱스 사용이 불가능하므로 일반 for문을 통해 접근 불가능
		 * => 대신, 향상된 for문을 통해 저장된 요소를 차례대로 접근 가능
		 * */
		for(int i : set5) {
			System.out.println(i);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
