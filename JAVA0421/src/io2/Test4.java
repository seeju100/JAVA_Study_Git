package io2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Test4 {

	public static void main(String[] args) {
		/*
		 * temp 폴더에 저장된 source.txt 파일을 읽어들여
		 * 각 라인에 라인번호를 추가하여 콘솔(화면)에 출력
		 * - FileReader, BufferedReader 사용
		 *   (키보드로 입력받는 InputStreamReader 대신 File로 부터 입력받는 FileReader 사용)
		 * 
		 * */
//		try(BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
//				PrintWriter out = new PrintWriter(new FileWriter(f))){
//			
//			String str = buffer.readLine();
//			
//			// 입력 문자열이 ":wq" 가 아닐동안 반복
//			while(!str.equals(":wq")) {
//				out.println(str);		// 입력데이터 한줄 출력
//				str = buffer.readLine();// 새로운 한줄 읽어오기
//			}
//			
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		File f = new File("C:\\temp\\source.txt");
		try(BufferedReader buffer = new BufferedReader(new FileReader(f))){
			
			int count = 1;
			
			String str = buffer.readLine();
			while(str != null) {
				System.out.println(count + " " + str);	// 라인번호 붙여 출력
				str = buffer.readLine();	// 새로운 한 줄 읽어오기
				count++;	// 라인번호 증가
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
