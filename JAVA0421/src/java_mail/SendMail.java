package java_mail;

import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {

	public static void main(String[] args) {
		String sender = "admin@admin.com";
		String receiver = "ytlee@itwillbs.co.kr";
		String title = "자바 메일 발송 테스트";
		String content = "테스트";

		try {
			// ------- 메일 전송에 필요한 설정 작업 -------
			// 메일 전송 프로토콜 : SMTP(Simple Mail Tranfer Protocol) 
			// (참고. 메일 수신 프로토콜 : POP3)
			// 시스템(서버)의 속성 정보(서버 정보)를 java.util.Properties 객체로 리턴받기
			Properties properties = System.getProperties();
			// 메일 전송에 필요한 정보를 가져온 서버 속성 정보에 추가 - put() 메서드 활용
			// TLS(Transport Layer Security) 인증 관련 설정
			properties.put("mail.smtp.starttls.enable", "true");
			properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
			// 메일 전송에 사용할 메일 서버 지정(Gmail, 네이버, 네이트, 아웃룩 등)
			properties.put("mail.smtp.host", "smtp.gmail.com"); // 구글(Gmail) 메일 발송 서버 주소 지정
			properties.put("mail.smtp.auth", "true"); // 인증 여부 설정(로그인 필요 시)
			properties.put("mail.smtp.port", "587"); // 메일 전송에 사용될 서비스 포트 설정(SMTP 포트)

			// 메일 서버에 대한 인증 정보를 관리하는 사용자 정의 클래스(GoogleSMTPAuthenticator)의 인스턴스 생성
			Authenticator authenticator = new GoogleSMTPAuthenticator(); // 업캐스팅

			// 자바 메일의 기본 전송 단위를 javax.mail.Session 객체 단위로 관리
			// => Session 클래스의 getDefaultInstance() 메서드를 호출하여 파라미터로 서버 정보, 인증 정보 전달
//			    (주의! 변수명은 session 외의 다른 이름 사용 필수! => HttpSession 내장객체 변수명이 존재함)
			Session mailSession = Session.getDefaultInstance(properties, authenticator);

			// Message 정보를 관리할 javax.mail.internet.MimeMessage 객체 생성
			// => 파라미터로 서버 정보와 인증 정보를 관리하는 javax.mail.Session 객체 전달
			// => MimeMessage 객체를 사용하여 전송할 메일에 대한 정보 설정 가능
			Message mailMessage = new MimeMessage(mailSession);

			// 전송할 메일에 대한 정보 설정
			// 1. 발신자 정보 설정(발신자 정보를 관리하기 위한 InternetAddress 객체 생성)
			// => 단, 스팸 메일 정책으로 인해 상용 메일 사이트(구글 등)는 발신자 주소 변경 불가능
			Address sender_address = new InternetAddress(sender, "아이티윌"); // 두번째 파라미터는 변경 가능
			// 2. 수신자 정보 설정
			Address receiver_address = new InternetAddress(receiver);
			// 3. Message 객체를 통해 전송할 메세지 정보 설정
			// 1) 메일 헤더 정보 설정
			mailMessage.setHeader("content-type", "text/html; charset=UTF-8");
			// 2) 발신자 정보 설정
			mailMessage.setFrom(sender_address);
			// 3) 수신자 정보 설정(RecipientType 클래스의 TO 상수와 수신자 주소 전달)
			mailMessage.addRecipient(RecipientType.TO, receiver_address);
			// 4) 메일 제목 설정
			mailMessage.setSubject(title);
			// 5) 메일 본문 설정(본문과 본문의 컨텐츠타입 전달)
			mailMessage.setContent(content, "text/html; charset=UTF-8");
			// 6) 메일 전송 날짜 정보 설정(java.util.Date 객체를 활용하여 현재 시스템의 시각 정보 전달)
			mailMessage.setSentDate(new Date());

			// 4. 메일 전송
			// javax.mail.Transport 클래스의 static 메서드 send() 메서드 호출
			Transport.send(mailMessage);
			System.out.println("<h3>메일이 정상적으로 전송되었습니다!</h3>");
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("<h3>SMTP 서버 설정 또는 서비스 문제 발생!</h3>");
		}
	}

}
