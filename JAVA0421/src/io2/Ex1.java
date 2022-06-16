package io2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex1 {

	public static void main(String[] args) {
		/*
		 * 자바의 기본 데이터 입출력
		 * - DataInputStream, DataOutputStream 사용
		 * - 자바의 기본데이터타입 8가지 + 문자열(String)타입 처리 가능
		 *   => readXXX(), writeXXX() 메서드 사용하며 XXX은 기본데이터타입의 이름 사용
		 *   	ex) int형 데이터 출력시 : writeInt()
		 *   		double형 데이터 입력 시 : readDouble()
		 *   => 주의! String 타입은 XXX 부분에 String 대신 UTF 사용
		 *   	ex) readString() 메서드 (X) => readUTF() 메서드 (O)
		 * - 주의사항!
		 * 	1) 반드시 두 객체 끼리만 데이터 입출력 가능
		 * 	2) 입출력 시 각각의 순서에 따라 처리해야함
		 * 		ex) int, char, String 순으로 출력 시 int, char, String 순으로 입력해야함!
		 * 
		 * < 기본 문법 >
		 * 1. 기본 데이터 출력
		 * 		DataOutputStream dos = new DataOutputStream(바이트 스트림 객체);
		 * 		dos.writeXXX(데이터);
		 * 2. 기본 데이터 입력
		 * 		DataInputStream dis = new DataInputStream(바이트 스트림 객체);
		 * 		dis.readXXX(데이터);  
		 * 
		 * */
		
		// 자바 기본 데이터를 파일로 출력하기
		// 1. FileOutputStream 객체를 생성하여 출력할 파일 위치 및 파일명 지정
//		FileOutputStream fos = new FileOutputStream("C:\\temp\\data.txt");
		// 2. DataOutputSream 객체를 생성하여 FileOutputStream 객체를 전달
//		DataOutputStream dos = new DataOutputStream(fos);
		
//		try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("C:\\temp\\data.txt"))){
//			// DataOutputStream 객체를 통해 출력되는 데이터는
//			// C 드라이브 temp 폴더 내의 data.txt 파일에 출력됨(기록됨)
//			dos.writeInt(100);		// int형 정수 출력
//			dos.writeDouble(3.14);	// double형 실수 출력
//			dos.writeUTF("홍길동");	// 문자열 출력(주의! writeString() 메서드 아님!)
//			
//		} catch (FileNotFoundException e) {
//			// FileOutputStream 에서 지정한 경로가 존재하지 않을 경우 예외 발생
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		System.out.println("=====================================================");
		
		// 파일에 출력된 자바 기본데이터를 읽어와서 화면에 출력하기
		try(DataInputStream dis = new DataInputStream(new FileInputStream("C:\\temp\\data.txt"))){
			
			// dis.readXXX() 메서드 호출하여 데이터 읽어오기(입력)
			// 읽어들일 데이터는 반드시 출력된 데이터 순으로 읽어야 한다!
			// => 출력 순서: int -> double -> String 이므로, 입력 순서도 동일해야함
			// => 순서가 바뀔 경우 EOFException 예외가 발생하므로 주의!
			int num = dis.readInt();
			double dNum = dis.readDouble();
			String str = dis.readUTF();
			
			// 입력받은 데이터 출력
			System.out.println("int형 정수: " + num);
			System.out.println("double형 실수: " + dNum);
			System.out.println("문자열: " + str);
			
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
