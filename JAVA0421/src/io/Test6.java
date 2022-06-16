package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class Test6 {

	public static void main(String[] args) {
		// BufferedReader 를 사용하여 입력받은 문자열을
		// OutputStream 을 사용하여 출력
		
		// try ~ resource 구문 작성
		// try() 문장 소괄호 내에 복수개의 객체를 세미콜론(;)으로 구분하여 전달 가능
		try(BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in)); 
				OutputStream os = System.out){
			
			// 입력 스트림에서 한 줄의 데이터(문자열)읽어오기
			String str = buffer.readLine();
			
			// 출력 스트림을 통해 입력데이터 출력하기
			os.write(str.getBytes());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
