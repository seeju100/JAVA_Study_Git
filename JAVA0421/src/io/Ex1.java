package io;

import java.io.IOException;
import java.io.InputStream;

public class Ex1 {

	public static void main(String[] args) {
		/*
		 * 자바 I/O (Input / Ouput)
		 * - java.io 패키지에 있는 클래스들의 모음
		 * - 자바에서 각종 입출력을 담당
		 * - Node(노드) : 자바에서 입출력을 수행하는 대상
		 * 					(입력 노드: 키보드, 마우스, 파일, 네트워크, 데이터베이스 등)
		 * 					(출력 노드: 모니터, 스피커, 파일, 네트워크, 데이터베이스 등)
		 * 
		 * - Stream(스트림) : 입력 또는 출력 데이터가 한 방향으로 끊임없이 전송되는 것
		 * 					  출발지 노드 -> 도착지 노드
		 * - 입력스트림 : 자바에서 데이터가 입력될때 처리하는 스트림
		 *   출력스트림 : 자바에서 데이터가 출력될때 처리하는 스트림
		 * - 스트림 종류
		 * 	1. byte 기반(단위) 스트림
		 * 		=> 그림, 사진, 영상 등 바이너리(Binary) 데이터를 입출력
		 * 		=> InputStream, OutputStream을 최상위 클래스로 두고
		 * 			XXXInputStream, XXXOutputStream 클래스가 하위클래스로 존재함
		 *  2. char 기반(단위) 스트림
		 *		=> 문자 데이터(텍스트)를 입출력
		 *		=> Reader, Writer 를 최상위 클래스로 두고
		 *			XXXReader, XXXWriter 클래스가 하위클래스로 존재함
		 *
		 * - 표준 입출력 : 컴퓨터에서 기본적으로 사용하는 입출력
		 * 	=> 표준 입력 장치 : 키보드
		 * 	=> 표준 출력 장치 : 모니터
		 * 	=> 표준 입출력을 담당하는 클래스 : System
		 * 			1) System.in : 표준 입력을 담당(키보드에서 입력받기 가능)
		 * 			2) System.out : 표준 출력을 담당(모니터로 출력 가능)
		 * 			3) System.err : 모니터에 에러 정보 출력(잘 사용하지 않음)
		 * */
		
		
		/*
		 * 키보드로부터 데이터를 입력받아 처리하는 방법
		 * 1. InputStream 객체를 사용하여 1Byte 단위로 입력데이터를 처리하는 방법
		 * 		- read() 메서드를 사용하여 1Byte 만큼의 데이터를 가져올 수 있음
		 * 		- 아무리 많은 데이터가 입력되어도 read() 메서드는 한번에 1Byte만 처리되므로
		 * 		  더 많은 데이터나 더 큰 단위 처리가 불가능
		 * 		  => 영문 또는 숫자 등의 데이터 1글자만 처리 가능
		 * 		  => 한글이나 한자 등 2Byte(char 단위) 문자들은 처리 불가능
		 * 		  => 읽어온 데이터가 int형 이므로 문자로 변환 등의 후속 작업 필요
		 * 		- 가장 저수준의 입력 방법
		 * */
//		InputStream is = null;
//		
//		try {
//			System.out.println("데이터를 입력하세요.");
//			is = System.in;
//			// => System.in 코드에 의해 키보드로 부터 데이터 입력이 가능하며
//			//    입력 스트림 객체를 InputStream 타입 변수에 저장(연결)
//			int n = is.read(); // 입력스트림 데이터 중 1Byte 만큼의 데이터 읽어서 변수에 저장
//			System.out.println("입력 데이터: " + n);
//			System.out.println("입력 데이터를 문자로 변환: " + (char)n);
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			if(is != null) try { is.close(); } catch (IOException e) {}
//		}
		
		// ===============================================================
		/*
		 * try ~ resouce 구문을 사용하여 자원 반환(close())을 자동으로 수행
		 * - 기본적으로 자원을 사용하는 객체(Connection, InputStream 등)는
		 *   사용 후 close() 메서드 호출을 통해 사용중인 자원을 반환해야하며
		 *   자원이 반환되지 않으면 반복적인 자원 요청으로 인해 자원이 고갈되어
		 *   더 이상 다른 사용자의 작업 요청을 수행할 수 없게 된다!
		 *   => 예외 발생 여부와 관계없이 finally 블록 내에서 자원반환 코드 기술했음
		 * - try ~ resource 구분은 try문에서 반환할 자원을 갖는 객체를 생성하고
		 *   try ~ catch 블록 작업이 끝나면 자동으로 자원을 반환해 주도록 함  
		 * 
		 * < 기본 문법 >
		 * try(자원을 반환할 객체 생성 및 변수에 저장){
		 * 		// 작업 수행
		 * } catch(...){
		 * 		// 예외 처리 작업 수행
		 * }
		 * 
		 * */
		
		// try문의 소괄호() 내부에 예외처리가 필요한 객체의 생성 코드를 작성
//		try(InputStream is = System.in){
//			int n = is.read();
//			System.out.println("입력 데이터: " + n);
//			System.out.println("입력 데이터(문자로 변환): " + (char)n);
//		} catch(IOException e) {
//			e.printStackTrace();
//		}
		// => 별도의 close() 메서드를 호출하지 않아도 자동으로 자원이 반환됨
		
		// =====================================================================
		// 반복문을 사용하여 1Byte 씩 여러번 반복하여 입력 처리
		System.out.println("데이터를 입력하세요. (취소 시 Ctrl + Z)");
		try (InputStream is = System.in){
			
			int n = is.read();
			while(n != -1) {
				System.out.println("입력데이터: " + n + ", 문자로변환: " + (char)n);
				n = is.read();
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
