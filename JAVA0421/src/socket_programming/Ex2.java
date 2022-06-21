package socket_programming;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class Ex2 {

	public static void main(String[] args) {
		/*
		 * URLEncoder, URLDecoder 클래스
		 * - URL 에서 사용되는 문자열을 MIME 형식으로 변환하기 위한 클래스
		 *   (MIME : Multipurpose Internet Mail Extensions)
		 * - 주로, 한글로 표시되는 쿼리 문자열 등이 웹 서버에 전송될 때의 형태로
		 *   특정 규칙에 따라 변환되어짐
		 *   1) 아스키코드(영문 대문자, 소문자, 숫자, 일부 특수문자)는 그대로 사용
		 *   2) 공백은 + 기호로 변환
		 *   3) 기타 문자(한글, 한자 등)는 %XX 형태의 16진수 2자리 문자로 변환됨
		 *   
		 *   ex) 네이버 검색창에 "ITWILL 부산교육센터" 를 검색했을 때 다음과 같은 URL 요청 발생
		 *   https://search.naver.com/search.naver?sm=tab_hty.top&where=nexearch&query=ITWILL+%EB%B6%80%EC%82%B0%EA%B5%90%EC%9C%A1%EC%84%BC%ED%84%B0&oquery=%EC%95%84%EC%9D%B4%ED%8B%B0%EC%9C%8C+%EB%B6%80%EC%82%B0%EA%B5%90%EC%9C%A1%EC%84%BC%ED%84%B0&tqi=hramjdp0Jy0ssD5VnEossssst8s-013025
		 *   => 이 때, 주소창에 보이는 한글, 한자 등이 실제 주소 구성과 다르게 보일 수 있음      
		 */
		
		try {
			String originalStr = "[Java Programming : 이연태]";
			System.out.println("원본 문자열 : " + originalStr);
			
			// URLEncoder 클래스의 encode() 메서드를 사용하여 원본 문자열을 MIME 형식으로 변환(= 인코딩)
			String encodeStr = URLEncoder.encode(originalStr, "UTF-8");
			System.out.println("MIME 형식 변환 후 : " + encodeStr);
			// MIME 형식 변환 후 : %5BJava+Programming+%3A+%EC%9D%B4%EC%97%B0%ED%83%9C%5D
			
			// URLDecoder 클래스의 decode() 메서드를 사용하여 MIME 형식 문자열을 원래 문자열로 변환(= 디코딩)
			String decodeStr = URLDecoder.decode(encodeStr, "UTF-8");
			System.out.println("원본으로 복원 후 : " + decodeStr);
			// 원본으로 복원 후 : [Java Programming : 이연태]
		} catch (UnsupportedEncodingException e) {
			// 지정된 인코딩(디코딩) 타입(UTF-8 등)이 지원되지 않을 경우 발생하는 예외
			e.printStackTrace();
		}
		
		
	}

}












