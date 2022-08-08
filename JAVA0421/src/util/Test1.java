package util;

import java.util.StringTokenizer;

public class Test1 {

	public static void main(String[] args) {
		String data = "Address:부산광역시 부산진구 동천로109,Floor:7층,Tel:051-803-0909";
		// 1. 각 항목별 분리(StringTokenizer 클래스 사용)
		// 2. 각 항목에서 실제 데이터를 분리하여 출력
		StringTokenizer st = new StringTokenizer(data, ",");
		
		while(st.hasMoreTokens()) {
//			System.out.println(st.nextToken());
			
			// 1. StringTokenizer 사용 시
//			StringTokenizer st2 = new StringTokenizer(st.nextToken(), ":");
//			st2.nextToken();
//			System.out.println(st2.nextToken());
			
			// 2. String 클래스의 split() 메서드 사용 시
			System.out.println(st.nextToken().split(":")[1]); 
			
		}
		
		System.out.println("------------------------------------");
		
		String result = "";
		for(String str : data.split(",")) {
			 result += str.split(":")[1] + " ";
		}
		
		System.out.println(result);
		
		
		
		
		
		
	}

}
