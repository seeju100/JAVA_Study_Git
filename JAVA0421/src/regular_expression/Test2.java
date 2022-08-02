package regular_expression;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test2 {

	public static void main(String[] args) {
		/*
		 * Pattern 클래스와 Matcher 클래스를 활용하여 
		 * 입력된 패스워드에 대한 규칙(복잡도) 검사
		 * 
		 * 규칙1. 패스워드 길이 제한 - 영문자, 숫자, 특수문자(!@#$%) 중 하나라도 포함하는 8 ~ 16자리
		 *        1) 길이 제한 통과 시 : 복잡도 검사 수행
		 *        2) 길이 제한 위반 시 : "영문자, 숫자, 특수문자(!@#$%) 조합 8 ~ 16자리 필수!" 출력
		 * 규칙2. 패스워드 복잡도 검사
		 *        1) 영문 대문자
		 *        2) 영문 소문자
		 *        3) 숫자
		 *        4) 특수문자(!@#$%)
		 *        => 위의 네 가지 항목 중 하나씩 포함될 때마다 점수를 카운팅하여 다음 메세지 출력
		 *           4점 : "안전"
		 *           3점 : "보통"
		 *           2점 : "위험"
		 *           1점 이하 : "영문자, 숫자, 특수문자(!@#$%) 중 두 가지 이상 조합 필수!" 출력
		 */
		
		// 패스워드 길이를 판별하는 정규표현식
		String lengthRegex = "^[A-Za-z0-9!@#$%]{8,16}$";
		
		// 복잡도 검증에 대한 조건을 판별하는 정규표현식
		String engUpperRegex = "[A-Z]"; // 영문 대문자
		String engLowerRegex = "[a-z]"; // 영문 소문자
		String numRegex = "[0-9]"; // 숫자
		String specRegex = "[!@#$%]"; // 특수문자(!@#$%)
		
		// -----------------------------------------------------
		// Scanner 클래스를 활용하여 패스워드를 콘솔에 입력받기
		System.out.print("패스워드 입력(종료 시 :wq! 입력) : ");
		Scanner s = new Scanner(System.in);
		String password = s.nextLine();
		
		// Pattern 클래스의 static 메서드 matches() 를 활용하여
		// 입력받은 패스워드(password) 가 정규표현식(lengthRegex) 와 일치하는지 검사하여 결과 출력
		while(!password.equals("/exit")) { // 입력된 문자열이 "/exit" 가 아닐 동안 반복
			// 반복문 내에서 패스워드 입력 및 판별 반복
			if(Pattern.matches(lengthRegex, password)) {
				System.out.println(password + " : 길이 규칙 통과!");
				
				// 패스워드 길이 체크를 통과했을 경우 각 패턴별 검사를 추가적으로 수행
				int count = 0; // 각 패턴 포함 여부를 체크하기 위해 카운팅 변수 선언
				// -----------------------------------------------------------------------------------------------
				// 1) 검사할 정규표현식으로 Pattern 객체 생성 및 Pattern 객체로 Matcher 객체 생성 후 find() 호출 시
//				Pattern pattern = Pattern.compile(engUpperRegex); // 대문자 검사 정규표현식으로 Pattern 객체 생성
//				Matcher matcher = pattern.matcher(password); // 검사할 패스워드 문자열로 Matcher 객체 생성
//				
//				// Matcher 객체의 find() 메서드로 해당 정규표현식이 포함되는지 검사
//				if(matcher.find()) {
//					// 정규표현식이 포함되는 경우 카운팅 변수값 1 증가
//					count++;
//					System.out.println("정규표현식(영문 대문자) 포함됨!");
//				} else {
//					System.out.println("정규표현식(영문 대문자) 포함되지 않음!");
//				}
				// -----------------------------------------------------------------------------------------------
				// 2) Pattern 객체 생성과 Matcher 객체 생성을 하나로 결합 후 find() 호출 시
//				Matcher matcher = Pattern.compile(engUpperRegex).matcher(password);
//				
//				if(matcher.find()) {
//					// 정규표현식이 포함되는 경우 카운팅 변수값 1 증가
//					count++;
//					System.out.println("정규표현식(영문 대문자) 포함됨!");
//				} else {
//					System.out.println("정규표현식(영문 대문자) 포함되지 않음!");
//				}
				
				// -----------------------------------------------------------------------------------------------
				// 3) Pattern 객체 생성과 Matcher 객체 생성 및 find() 메서드 호출을 하나로 결합 시
//				if(Pattern.compile(engUpperRegex).matcher(password).find()) {
//					count++;
//				}
				
				// if 문의 중괄호 생략 시(하지 말 것!)
//				if(Pattern.compile(engUpperRegex).matcher(password).find()) count++;
//				if(Pattern.compile(engLowerRegex).matcher(password).find()) count++;
//				if(Pattern.compile(numRegex).matcher(password).find()) count++;
//				if(Pattern.compile(specRegex).matcher(password).find()) count++;
				
				// 삼항연산자를 사용하여 동일한 결과를 얻을 수 있다!
				// => find() 메서드 호출 결과가 true 이면 +1, 아니면 +0 
				count += Pattern.compile(engUpperRegex).matcher(password).find() ? 1 : 0;
				count += Pattern.compile(engLowerRegex).matcher(password).find() ? 1 : 0;
				count += Pattern.compile(numRegex).matcher(password).find() ? 1 : 0;
				count += Pattern.compile(specRegex).matcher(password).find() ? 1 : 0;
				
				// 점수(count)를 판별하여 패스워드 복잡도 검사 결과 출력
				switch (count) {
					case 4 : System.out.println(password + " : 안전!"); break;
					case 3 : System.out.println(password + " : 보통!"); break;
					case 2 : System.out.println(password + " : 위험!"); break;
					default: System.out.println(password + " : 영문자, 숫자, 특수문자(!@#$%) 중 두 가지 이상 조합 필수!!");
				}
				
			} else {
				System.out.println(password + " : 영문자, 숫자, 특수문자(!@#$%) 조합 8 ~ 16자리 필수!");
			}
			
			System.out.print("패스워드 입력(종료 시 :wq! 입력) : ");
			password = s.nextLine();
		}
		
		s.close();
		System.out.println("패스워드 검사 종료!");
	}

}
















