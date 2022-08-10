package cipher;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ExMessageDigest {

	public static void main(String[] args) {
		// 단방향 암호화에 사용할 해시알고리즘명(MD5, SHA-1, SHA-256, SHA-512 등)을 지정
//		String algorithm = "MD5"; // 암호화 코드(MessageDigest)의 길이가 128 비트인 암호화 알고리즘을 지정
		String algorithm = "SHA-256"; // 암호화 코드(MessageDigest)의 길이가 512 비트인 암호화 알고리즘을 지정
//		String algorithm = "SHA-512"; // 암호화 코드(MessageDigest)의 길이가 512 비트인 암호화 알고리즘을 지정
		
		String strPlainText = "admin123"; // 평문 암호
		
		
		// MyMessageDigest 객체 생성 시 생성자에 암호알고리즘명과 평문암호 전달하여 암호화 수행
		MyMessageDigest mmd = new MyMessageDigest(algorithm, strPlainText);
		
		// MyMessageDigest 객체의 getHashedData() 메서드를 호출하여 암호화 된 암호문을 리턴받아 출력
		String result = mmd.getHashedData();
		System.out.println("암호화 결과 : " + result);
		
		// =========================================================================================
		// 암호문과 새로 입력받은 평문이 같은 문자열인지 판별하는 방법
		// => 새로 입력받은 평문을 동일한 알고리즘으로 암호화한 뒤 
		//    기존에 존재하는 암호문과 결과물을 비교하여 동일 여부를 판별(복호화는 불가능)
		
		// 암호화 알고리즘은 algorithm 변수값을 그대로 활용
		// 로그인 과정을 통해 패스워드를 입력받았다고 가정
		String passwd = "admin1234"; // 평문

		MyMessageDigest mmd2 = new MyMessageDigest(algorithm, passwd);
		String result2 = mmd2.getHashedData(); // 입력받은 패스워드 암호화 결과 리턴받기
		
		// 두 암호문을 비교하여 동일 여부 판별
		if(result.equals(result2)) {
			System.out.println("로그인 성공!");
		} else {
			System.out.println("로그인 실패!");
		}
	}

}

class MyMessageDigest {
	private String strHashedData = ""; // 암호화 된 암호문을 저장할 변수
	
	// 해시알고리즘명과 원문(평문)을 전달받을 파라미터 생성자 정의
	public MyMessageDigest(String algorithm, String strPlaintext) {
		// 암호화를 수행할 hashing() 메서드 호출
		hashing(algorithm, strPlaintext);
	}
	
	// 해싱(암호화) 작업을 수행하는 hashing() 메서드 정의
	// => 파라미터 : 암호화 알고리즘명(algorithm), 원문(strPlainText)
	// => 생성자를 통해서만 호출 가능하도록 접근 불가능하게 설정(private)
	private void hashing(String algorithm, String strPlaintext) {
		try {
			// 1. MessageDigest 클래스의 static 메서드 getInstance() 메서드를 호출하여 객체 얻어오기
			// => 파라미터로 해시알고리즘명을 문자열로 전달
			// => NoSuchAlgorithmException 예외 처리 필요
			MessageDigest md = MessageDigest.getInstance(algorithm);
			
			// 2. 전달받은 평문 암호를 byte[] 타입으로 변환(암호화를 위한 준비 과정) 
			// => String 클래스의 getBytes() 메서드 활용
			// => 문자열을 각각 분리하여 해당 문자에 대한 코드값으로 변환하는 과정
			//    ex) "1234" 를 1, 2, 3, 4 로 각각 분리하려 byte 타입의 코드로 변환 시 49, 50, 51, 52 로 변환됨
			byte[] byteText = strPlaintext.getBytes(); 
//			System.out.println(Arrays.toString(byteText)); // [49, 50, 51, 52]
			
			// 3. MessageDigest 객체의 update() 메서드를 호출하여 평문의 byte[] 타입 변환 결과를 파라미터로 전달
			md.update(byteText);
			
			// 4. MessageDigest 객체의 digest 메서드를 호출하여 암호화 수행
			// => 암호화 결과를 다시 byte[] 타입으로 리턴
			byte[] digest = md.digest();
//			System.out.println(Arrays.toString(digest));
			// [-127, -36, -101, -37, 82, -48, 77, -62, 0, 54, -37, -40, 49, 62, -48, 85]
			
			// 암호화 된 byte[] 값을 16진수 FF 와 비트 단위 AND 연산을 통해 원래 값(양수값) 변환 후
			// 다시 16진수 문자열로 변환하여 암호문 변수에 결합 => 모든 영문자를 대문자로 변환하여 표기
			// => byte 타입 정수와 FF 를 AND 연산 하는 이유
			//    0xFF 는 10진수로 255 이며, 이는 int 타입으로 취급되는 정수이므로
			//    byte & int 연산 과정에서 byte -> int 로 변환되므로
			//    원본 byte 타입 정수를 int 타입으로 데이터 변형없이 변환하기 위해서이다.
			for(byte b : digest) {
				strHashedData += Integer.toHexString(b & 0xFF).toUpperCase(); 
				// ex) 81DC9BDB52D04DC2036DBD8313ED055
			}
			
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			System.out.println("입력한 암호화 알고리즘이 존재하지 않습니다!");
		}
	}

	// 암호문을 외부로 리턴할 getHashedData() 메서드 정의
	public String getHashedData() {
		return strHashedData;
	}
	
}
















