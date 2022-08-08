package util;

import java.util.StringTokenizer;

public class Ex1 {

	public static void main(String[] args) {
		/*
		 * StringTokenizer 클래스
		 * - java.util 패키지
		 * - 문자열을 분리하여 토큰(Token = 분리된 각 문자열)을 생성하는 기능을 제공
		 * - 구분자를 기준으로 문자열을 분리하여
		 *   StringTokenizer 타입 객체로 관리
		 *   => 객체 내의 분리된 문자열을 토큰(Token)이라고 함
		 *   
		 * < 생성자 >
		 * StringTokenizer st = new StringTokenizer(원본문자열, 구분자);
		 * => 구분자를 기준으로 원본문자열을 분리하여 객체로 생성
		 * 
		 * < 제공 메서드 >
		 * 1. countTokens(): 분리된 문자열(토큰) 갯수를 int형으로 리턴
		 * 		=> 구분자가 존재하지 않아 분리할 문자열이 없을 경우 1리턴됨(1개의 문자열)
		 * 2. hasMoreTokens() : 객체 내의 다음 토큰 존재 여부 리턴
		 * 		=> 주로 while문의 조건식에서 토큰 존재 여부 판별에 사용
		 * 3. nextToken(): 객체 내의 다음 토큰 꺼내서 리턴
		 * 		=> while문 내부에서 분리된 실제 데이터(토큰)를 가져올때 사용
		 * */
		String str = "자바/JSP/안드로이드";	// 원본 문자열
		StringTokenizer st = new StringTokenizer(str, "/");
		System.out.println("분리된 토큰 갯수: " + st.countTokens());
		
		while(st.hasMoreTokens()) {
			System.out.println("토큰 꺼내기: " + st.nextToken());
		}
		
		System.out.println("========================");
		
		String str2 = "자바.JSP.안드로이드";
		// StringTokenizer의 구분자로 사용될 문자열에 마침표 사용 시 그대로 사용가능 (".")
		// => String 클래스의 split() 메서드와 달리 정규표현식을 적용하지 않음
		StringTokenizer st2 = new StringTokenizer(str2, ".");
		
		while(st2.hasMoreTokens()) {
			System.out.println(st2.nextToken()); 
		}
		
		System.out.println("=======================");
		
		
		String str3 = "자바/JSP$안드로이드";	// 원본 문자열(구분자: / 기호와 $ 기호)
		
		// 원본문자열에서 구분자로 사용해야할 문자가 복수개일 경우
		// StringTokenizer의 생성자 String delim 부분에
		// 1개의 문자열로 복수개의 구분자를 전달 시 각 문자 하나하나 모두 구분자로 사용됨
		// 단, 구분자 문자열 순서는 무관
		// ex) StringTokenizer st = new StringTokenizer(str2, "/.$%");
		//			=> '/', '.', '$', '%' 기호를 각각의 구분자로 사용하여
		//				해당 문자들을 기준으로 좌우를 모두 분리시킴
		StringTokenizer st3 = new StringTokenizer(str3, "$/");
		// => 원본문자열 내에서 $기호와 /기호를 기준으로 모든 문자열을 분리함
		
		while(st3.hasMoreTokens()) {
			System.out.println(st3.nextToken()); 
		}
		
		
		
	}

}
