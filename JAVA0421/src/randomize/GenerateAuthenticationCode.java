package randomize;

import java.util.Random;

public class GenerateAuthenticationCode {
	// 생성된 난수를 저장할 변수 선언
	private String authenticationCode;
	
	// 난수 조합에 사용될 문자 데이터를 저장할 배열 생성
	// => 알파벳 26자와 숫자 10개, 특수문자 !, @, # 사용한다고 가정
	private char[] codeTable = {
			'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
			'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
			'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
			'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
			'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
			'!', '@', '#' 
	};
	
	// 기본 생성자 정의
	// => Random 클래스를 활용하여 배열 인덱스 범위의 난수 발생시킨 후
	//    해당 난수를 배열의 인덱스로 사용하여 문자 1개 추출 후 문자열로 결합
	public GenerateAuthenticationCode() {
		int codeLength = 50; // 생성할 난수 코드 길이 지정(60자리)
		Random r = new Random();
		StringBuffer buffer = new StringBuffer();
		
		// for문을 사용하여 코드 길이만큼 반복
		// => 배열 인덱스(ex. 62글자일 경우 0 ~ 61) 사이의 난수 1개 생성하여
		//    해당 난수를 배열 인덱스로 사용하여 1글자 추출 후 버퍼에 추가
		for(int i = 0; i < codeLength; i++) {
//			int rNum = r.nextInt(codeTable.length); // 배열 인덱스 범위의 난수 생성
			buffer.append(codeTable[r.nextInt(codeTable.length)]); // 난수를 인덱스로 사용하여 문자 1개 추출 후 버퍼에 추가(문자 결합)
		}
		
		// 반복 종료 후 버퍼에 저장된 문자열을 String 타입 변수에 저장
		authenticationCode = buffer.toString();
		
	}

	// 생성된 인증코드를 리턴하는 getAuthenticationCode() 메서드 정의
	public String getAuthenticationCode() {
		return authenticationCode;
	}
	
}












