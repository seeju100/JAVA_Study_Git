package regular_expression;

import java.util.regex.Pattern;

public class Ex {

	public static void main(String[] args) {
		/*
		 * 정규표현식을 활용하는 클래스(Pattern, Matcher)
		 * 1. java.util.regex.Pattern 클래스
		 *    - 정규표현식 패턴 문자열을 컴파일해서 객체로 관리
		 *    - 해당 객체를 활용하여 전체 문자열이 정규표현식 패턴에 매칭되는지 판별 가능
		 *      ex) 전화번호 유효성 검사, 패스워드 길이 유효성 검사 등
		 *          => 단, 패스워드 복잡도 검사(= 부분 규칙 검사) 불가
		 *    - 공개된 생성자가 없으며, Pattern.compile() 메서드를 통해 객체 리턴받아 사용 가능 
		 *    - 간단한 검사는 Pattern.matches() 메서드를 통해 검사 가능
		 * 
		 * < 주의! >
		 * 정규표현식 패턴을 자바 문자열로 작성하는 경우 이스케이프 문자(ex. \s 등) 작성 시 \ 대신 \\ 필수
		 */
		
		// 1. 전화번호 검증
		// 1-1) 전화번호 검증에 사용할 정규표현식 작성
		String phoneRegex = "^(010|011)[-\\s]?\\d{3,4}[-\\s]?\\d{4}$"; // 주의! \s 가 아닌 \\s 형태 사용 필수!
		
		// 1-2) 전화번호 검증에 사용할 전화번호 배열 생성
		String[] arrPhone = {"010-1234-5678", "01012345678", "010 1234 5678", "010)1234-5678", "010-1234-567a"};
		
		// for문을 사용하여 배열 크기만큼 반복
		for(String phone : arrPhone) {
			// 1-3. Pattern 클래스의 static 메서드 matches() 를 호출하여 패턴 일치 여부 검사
			//      => 파라미터 : 정규표현식 문자열(regex), 검증할 원본문자열(data)
			//         리턴타입 : boolean
			if(Pattern.matches(phoneRegex, phone)) {
				System.out.println(phone + " : 올바른 전화번호 형식");
			} else {
				System.out.println(phone + " : 잘못된 전화번호 형식");
			}
		}
		
		System.out.println("-----------------------------------------------------");
		
		// 2. 식별자 검증
		// 2-1. 식별자 검증에 사용할 정규표현식 작성
		String idRegex = "^[A-Za-z가-힣$_][A-Za-z가-힣0-9$_]{0,}$";
		
		// 2-2. 식별자 검증에 사용할 식별자 배열 생성
		String[] arrId = {"a", "num1", "$ystem", "7eleven", "my_name", "eleven7", "channel#5", "student name"};
		
		// for문을 사용하여 배열 크기만큼 반복
		for(String id : arrId) {
			// 2-3. Pattern 클래스의 static 메서드 matches() 를 호출하여 패턴 일치 여부 검사
			if(Pattern.matches(idRegex, id)) {
				System.out.println(id + " : 올바른 식별자");
			} else {
				System.out.println(id + " : 잘못된 식별자");
			}
		}
		
	}

}

















