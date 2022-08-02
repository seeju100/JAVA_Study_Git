package regular_expression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex2 {

	public static void main(String[] args) {
		/*
		 * 2. java.util.regex.Matcher 클래스
		 * - 정규표현식 패턴 해석 및 입력 문자열 일치 여부를 파악하는 클래스
		 * - Pattern 클래스와 달리 정규표현식 전체에 대한 일치 여부만 판단하는 것이 아니라
		 *   정규표현식 내용을 포함하는지, 위치가 어디인지 등 자세한 정보까지 파악 가능
		 * - 공개된 생성자가 없으며, Pattern 객체의 matcher() 메서드를 호출하여 Matcher 객체를 리턴받을 수 있음
		 *   (= Pattern 객체가 있어야함)
		 * - 메서드를 사용하여 판별할 때 인덱스(또는 커서)의 개념이 활용됨(탐색 위치에 커서가 위치함)
		 */
		
		String src = "Java and Javascript has no relation"; // 원본 문자열
		String regex = "Java"; // 정규표현식
		
		// 만약, Pattern 클래스의 matches() 메서드를 사용할 경우
//		System.out.println(Pattern.matches(regex, src)); // false 출력됨
		// => src 문자열이 regex 와 완벽하게 일치할 경우에만 true, 아니면 false
		
		// Matcher 클래스를 활용한 판별
		// 1. Pattern 클래스의 static 메서드 compile() 메서드를 호출하여 정규표현식을 갖는 Pattern 객체 생성
		// => 파라미터 : 패턴 문자열    리턴타입 : Pattern
		Pattern pattern = Pattern.compile(regex);
		
		// 2. 생성된 Pattern 객체의 matcher() 메서드를 호출하여 Matcher 객체 얻어오기(생성)
		// => 파라미터 : 검증할 문자열    리턴타입 : Matcher
		Matcher matcher = pattern.matcher(src);
		
		// 3. 생성된 Matcher 객체의 다양한 메서드를 호출하여 각종 검증 수행
		// => 대부분의 메서드는 파라미터가 불필요(객체 생성 과정에서 정규표현식 패턴 문자열과 원본 문자열 모두 전달함)
		// 3-1. matches() 메서드 : 정규표현식과 완전히 일치하는지 검사(= Pattern.matches() 와 동일)
		System.out.println("원본문자열이 정규표현식과 완전히 일치하는가? " + matcher.matches()); // false
		// "Java" 와 ""Java and Javascript has no relation" 은 일치하지 않음
		
		// 3-2. lookingAt() : 정규표현식으로 시작하는지 검사
		System.out.println("원본문자열이 정규표현식으로 시작하는가? " + matcher.lookingAt()); // true
//		System.out.println("원본문자열이 정규표현식으로 시작하는가? " + matcher.lookingAt()); // true
		// => 검색 시 항상 가장 처음 위치에서 패턴에 일치하는 문자열을 찾아감
		// => 메서드 호출을 여러번 반복해도 결과값은 동일함
		
		// 3-3. find() : 정규표현식을 포함하는지 검사
		System.out.println("원본문자열이 정규표현식을 포함하는가? " + matcher.find()); // true
		// => 검색 시 현재 커서 위치에서부터 패턴에 일치하는 문자열을 찾아감
		// => 메서드 호출을 여러반 반복할 경우 결과값이 달라질 수 있음
		// => 만약, lookingAt() 메서드를 먼저 호출하여 "Java" 문자열을 탐색할 경우
		//    가장 앞에 있는 "Java" 문자열이 일치하고, 커서는 그 뒤에 위치하므로
		//    find() 메서드를 이어서 호출할 경우 "Java" 가 아닌 "Javascript" 의 "Java" 문자열이 탐색됨
		//    따라서, find() 메서드를 한 번 더 호출할 경우 더 이상 "Java" 문자열이 없으므로 false 리턴됨
		System.out.println("원본문자열이 정규표현식을 포함하는가? " + matcher.find()); // false
	}

}
















