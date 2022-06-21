package socket_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

public class Ex {

	public static void main(String[] args) {
		/*
		 * [ 소켓 프로그래밍(Socket Programming) ]
		 * 소켓(Socket)이란?
		 * - 프로그램 상에서 통신을 수행하는 단말 장치의 논리적 끝단
		 * - 소켓이 서로 연결되어 있는 단말 장치끼리 통신 수행 가능
		 * - 소켓으로 통신을 하기 위해서는 네트워크 포트 하나를 사용해야함
		 *   (컴퓨터 상의 포트번호 : 0 ~ 65535번까지)
		 * - 자바에서 소켓 프로그래밍을 위한 클래스 및 인터페이스를 제공
		 *   => java.net 패키지 활용
		 *   => 주로, java.io 패키지의 클래스들과 함께 사용하는 경우가 많음
		 * =================================================================
		 * URL 클래스
		 * - URL(주소) 정보를 관리하는 클래스
		 * - URL(Uniform Resource Locator) 이란?
		 *   => 웹(WWW) 상의 자원들의 위치를 가리키는 주소(= 포인터)
		 * - URL 형식
		 *   ex) http://www.itwillbs.co.kr:80/index.jsp
		 *       1) http - 프로토콜(Protocol)
		 *       2) www.itwillbs.co.kr - 호스트명(주소)
		 *       3) 80 - 서비스 포트 번호
		 *       4) index.jsp - 자원 경로(Path) 및 파일명(File)
		 */
		
		URL url = null;
		
		try {
			url = new URL("https://itwillbs.co.kr/css/wvtex/img/wvUser/busan/logo.png");
//			url = new URL("https://itwillbs.co.kr/index.jsp");
//			url = new URL("http://localhost:8080/Test1/loginForm.jsp");
			// 주의! 이 URL 이 실제로 존재하는지 여부는 상관없다!
			
			// URL 객체로부터 메타데이터(= 부가적인 정보) 얻어오기
			System.out.println("프로토콜 : " + url.getProtocol());
			System.out.println("호스트명 : " + url.getHost());
			System.out.println("포트번호 : " + url.getDefaultPort());
			System.out.println("파일명 : " + url.getFile());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		try {
			// URL 객체의 openConnection() 메서드를 활용하여 URLConnection 객체 얻을 수 있으며
			// URLConnection 객체의 connect() 메서드를 활용하여 해당 URL 에 접근 가능
			
//			url = new URL("http://itwillb.co.k");
			// => 만약, URL 정보(자원 경로 제외)가 틀릴 경우 예외 발생할 수 있음
			
			// URL 객체에 지정된 URL 정보를 사용하여 해당 URL 에 접속(연결) 수행
			// => 접속 성공 시 URLConnection 객체 리턴됨
			URLConnection con = url.openConnection();
			con.connect(); // 자원의 경로를 제외한 주소부분이 틀릴 경우 예외 발생
			
			// 실제 해당 자원에 접근했을 경우 정보 가져오기
			System.out.println("문서타입 : " + con.getContentType());
			System.out.println("문서크기 : " + con.getContentLength() + " Byte");
			// => 만약, 해당 URL 에 자원이 존재하지 않을 경우 크기는 -1 리턴됨
			System.out.println("문서 최종 수정일 : " + new Date(con.getLastModified()));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("==========================================");
		
		// 아이티윌 부산교육센터 인덱스 페이지의 소스코드 읽어오기
		try {
//			url = new URL("https://itwillbs.co.kr");
			url = new URL("https://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=2623051000");
			
			// URL 객체로부터 InputStream 객체를 얻어와서
			// Byte -> Char -> String 형태로 최종 변환한 스트림을 통해 소스코드 한 줄씩 출력
			// 1. URL 객체의 openStream() 메서드를 호출하여 InputStream 객체 연결(Byte 단위 처리)
//			InputStream is = url.openStream();
			// 2. InputStream 객체를 char 단위로 처리하기 위해 InputStreamReader 객체 생성
//			InputStreamReader reader = new InputStreamReader(is);
			// 3. InputStreamReader 객체를 String 단위로 처리하기 위해 BufferedReader 객체 생성
//			BufferedReader buffer = new BufferedReader(reader);
			
			// 위의 세 문장을 한 문장으로 결합
			BufferedReader buffer = new BufferedReader(new InputStreamReader(url.openStream()));
			
			// 버퍼(BufferedReader)로부터 입력되는 입력스트림을 한 문장(라인) 읽어서 변수에 저장
			String str = buffer.readLine();
			
			// 읽어온 한 문장이 null 이 아닐동안 반복해서 읽어오기
			while(str != null) {
				// 읽어온 문장 출력 후 다음 문장 읽어오기
				System.out.println(str);
				str = buffer.readLine();
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
	}

}















