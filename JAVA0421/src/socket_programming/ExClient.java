package socket_programming;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ExClient {

	public static void main(String[] args) {
		// Socket 타입 변수 선언
		Socket socket = null;
		
		// 접속할 서버의 IP 주소(호스트 주소)와 포트번호를 변수에 저장
//		String host = "localhost"; // localhost = 127.0.0.1 = 현재 PC 주소(자신의 IP 직접 지정 가능)
		String host = "192.168.3.127";
		int port = 60000; // 서버에서 여는 포트번호
		
		try {
			// Socket 객체 생성 시 생성자에 호스트주소와 포트번호 전달
			socket = new Socket(host, port);
			System.out.println("서버와 소켓 연결 완료!");
			
			// --------------------------------------------------------------------
			// 서버로부터 전송되는 텍스트(문자열)를 입력스트림을 통해 전달받아 출력
			// => DataOutputStream 으로 출력된 데이터는 반드시 DataInputStream 으로만 읽을 수 있음
			// 1. Socket 객체로부터 입력스트림(InputStream) 연결
			InputStream is = socket.getInputStream();
			
			// 2. DataInputStream 객체 생성(파라미터로 InputStream 객체 전달)
			DataInputStream dis = new DataInputStream(is);
			
			// 3. DataInputStream 객체의 readUTF() 메서드를 호출하여 전송된 문자열 한 문장 읽어오기
			String str = dis.readUTF();
			System.out.println("서버 : " + str);
			
			// DataInputStream 객체 반환
			dis.close();
		} catch (UnknownHostException e) {
			// 호스트주소가 잘못 지정됐을 경우
			e.printStackTrace();
		} catch (IOException e) {
			// 포트번호가 잘못 지정됐을 경우 또는 입력스트림에 문제가 발생했을 경우
			e.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}















