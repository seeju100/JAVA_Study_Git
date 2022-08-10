package randomize;

public class Ex2 {

	public static void main(String[] args) {
		for(int i = 1; i <= 10; i++) {
			// 인증코드 생성을 위해 GenerateAuthenticationCode 인스턴스 생성
			GenerateAuthenticationCode genCode = new GenerateAuthenticationCode();
			
			// 생성된 인증코드를 변수에 저장 후 출력
			String code = genCode.getAuthenticationCode();
			System.out.println(code);
		}
		
	}

}
