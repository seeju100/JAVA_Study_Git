package lang;

import java.util.Arrays;
import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		/*
		 * 주민등록번호(jumin)를 문자열로 입력받아 성별(남 또는 여) 판별
		 * 입력 형식 : "XXXXXX-XXXXXXX"
		 * 판별 조건
		 * 1) 뒷자리 첫번째 숫자가 1 또는 3 : "남성" 출력
		 * 2) 뒷자리 첫번째 숫자가 2 또는 4 : "여성" 출력
		 * 3) 뒷자리 첫번째 숫자가 5 또는 6 : "외국인" 출력
		 * 
		 * */
//		Scanner sc = new Scanner(System.in);
//		String jumin = sc.nextLine();
		String jumin = "881111-7722222";
//		String[] strArr = jumin.split("-");
//		String str = strArr[1];
//		char ch = str.charAt(0);
		
		// 위 문장을 한줄로 표현
//		char ch = jumin.charAt(7);
		char ch = jumin.split("-")[1].charAt(0);
		
		String result = "";
		
		if(ch == '1' || ch == '3') {
			result = "남성";
		} else if(ch == '2' || ch == '4') {
			result = "여성";
		} else if(ch == '5' || ch == '6') {
			result = "외국인";
		} 
		
//		System.out.println(result);
		
		System.out.println("------------------------------------");
		
		// switch - case
		switch (ch) {
		case '1': 
		case '3': result = "남성"; break;
		case '2': 
		case '4': result = "여성"; break;
		case '5': 
		case '6': result = "외국인"; break;

		}
		
		System.out.println(result);
		
		System.out.println("---------------------------------");
		
		// 주소부분만 출력 (부산광역시 부산진구 동천로:109)
		String data1 = "Address:부산광역시 부산진구 동천로:109";
//		String data1 = "addr:부산광역시 부산진구 동천로:109";
//		System.out.println(data1.replace("Address:", "")); 
//		System.out.println(data1.substring(data1.indexOf(":")+1));  // O
//		String[] str = data1.split(":");
//		System.out.println(str[1] + str[2]);
		
		
		// 이름 부분만 출력 (홍길동)
		String data2 = "이름: 홍길동, 나이: 20, 주소: ~~~, 성별:~~~";
		System.out.println(data2.substring( data2.indexOf(":") + 1 , data2.indexOf(",")).trim());
		System.out.println(data2.split(",")[0].split(":")[1].trim());
		
		// 주소부분만 출력 (서울특별시 용산구 24번길, 210동 702호)
		String data3 = "Address:서울특별시 용산구 24번길, 210동 702호, Tel:0518030909";
		System.out.println(data3.substring(data3.indexOf(":") + 1, data3.lastIndexOf(",")));
		
		// 필요한 데이터만 추출 (부산광역시 부산진구 동천로109) (7층) (0518030909)
		String data4 = "Address:부산광역시 부산진구 동천로109, Floor:7층,Tel:051-803-0909";
		String[] strArr = data4.split(",");
		for(String s : strArr) {
			System.out.println(s.split(":")[1].replace("-", "").trim());
		}
		
		System.out.println("====================================");
		
		// 필요한 데이터만 추출 (부산광역시 부산진구 동천로 24번길, 109호) (7층) (0518030909)
		String data5 = "Address:부산광역시 부산진구 동천로 24번길, 109호, Floor:7층,Tel:051-803-0909";
		int index = data5.lastIndexOf(",");
		System.out.println(data5.substring(index + 1).split(":")[1].replace("-", ""));
		data5 = data5.substring(0, index);
		
		index = data5.lastIndexOf(",");
		System.out.println(data5.substring(index + 1).split(":")[1]);
		data5 = data5.substring(0, index);
		
		System.out.println(data5.split(":")[1]);
		
		
	}

}
