package socket_programming;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Ex3Server {

	public static void main(String[] args) {
		/*
		 * [ 소켓 프로그래밍 ]
		 * Socket 클래스와 ServerSocket 클래스
		 * - 소켓 통신에 사용되는 소켓을 관리하는 클래스
		 * - ServerSocket 클래스는 서버에서 소켓 생성에 사용되고,
		 *   Socket 클래스는 서버와 클라이언트에서 소켓 연결 및 관리에 사용됨
		 * - 통신을 위한 서버측에서 ServerSocket 객체를 사용하여 소켓을 생성하고
		 *   Socket 객체를 사용하여 서버와 클라이언트가 통신 소켓 연결을 수행함
		 * - 소켓에 사용되는 Socket 객체 사용 완료 후에는 반환 필수
		 *   => close() 메서드 사용
		 *   => 단, 서버는 항시 대기중이어야 하므로 ServerSocket 객체는 평상시 닫지 않음
		 */
		
		// 서버측에서 소켓 통신에 사용할 변수 선언
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		try {
			// ServerSocket 객체 생성 시, 생성자에 사용할 포트번호 전달
			int port = 60000; // 서버에서 사용할 포트번호 지정
			serverSocket = new ServerSocket(port); // 사용중인 포트(충돌)일 때 예외 발생
			System.out.println("서버 소켓 생성 완료!");
			
			// -------------------------------------------------------------------------
			// 생성된 ServerSocket 객체의 accept() 메서드를 호출하여
			// 클라이언트로부터의 연결 요청을 대기하도록 지정
			// => 클라이언트로부터 연결 요청을 받아 수락할 경우 Socket 객체 리턴됨
			socket = serverSocket.accept();
			System.out.println("클라이언트와 소켓 연결 완료!");
			System.out.println("클라이언트 주소 : " + socket.getInetAddress());
			// -------------------------------------------------------------------------
			// 접속된 클라이언트에게 텍스트 메세지 전송(= 텍스트 출력 = 내보내기)
			// 1. Socket 객체로부터 출력스트림에 사용되는 OutputStream 객체 가져오기
			OutputStream os = socket.getOutputStream();
				
			// 2. 자바의 기본 데이터타입을 다룰 수 있는 출력스트림 DataOutputStream 객체 생성
			// => 파라미터로 기본 출력스트림인 OutputStream 객체 전달
			DataOutputStream dos = new DataOutputStream(os);
			
			// 3. DataOutputStream 객체의 writeXXX() 메서드를 호출하여 자바의 기본데이터 출력
			// => writeXXX() 메서드의 XXX 은 기본데이터타입 이름 지정
			// => 기본데이터타입 외에 문자열 출력하는 메서드는 writeString() 이 아닌 writeUTF() 사용
			dos.writeUTF("환영합니다!"); // 지정된 문자열을 출력(= 내보내기)
			
			// 4. DataOutputStream 객체 반환(finally 블록에서 반환하는게 더 효과적)
			dos.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 예외가 발생하더라도 무조건 Socket 객체 반환
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}












