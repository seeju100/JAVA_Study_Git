package java_mail;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

// 메일 서버 인증을 위해 javax.mail.Authenticator 클래스를 상속받는 서브클래스 정의
public class GoogleSMTPAuthenticator extends Authenticator {
	// 인증 정보(아이디, 패스워드)를 관리할 javax.mail.PasswordAuthentication 클래스 타입 변수 선언
	PasswordAuthentication passwordAuthentication;
	
	// 기본 생성자 정의
	public GoogleSMTPAuthenticator() {
		// 인증에 사용할 아이디와 패스워드 정보를 갖는 PasswordAuthentication 객체 생성
		// => 구글 2단계 인증을 사용하지 않는 경우 계정명, 로그인 패스워드 전달
		// => 구글 2단계 인증을 사용하는 경우 별도의 부가 작업 필요
		//    (Gmail 의 경우 앱 비밀번호를 별도로 발급받아 패스워드 부분에 입력)
//		passwordAuthentication = new PasswordAuthentication("계정명", "비밀번호");
		passwordAuthentication = new PasswordAuthentication("dusxo0310", "jzjelxvrupkuypyn");
	}

	// 인증 정보 객체를 외부로 리턴하는 getPasswordAuthentication() 메서드 오버라이딩
	// => 주의! 변수명이 달라질 수 있으므로 Getter 메서드를 직접 정의하는 것은 좋지 않다!
	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		return passwordAuthentication;
	}
	
}















