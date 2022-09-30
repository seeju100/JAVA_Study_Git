package algorithm;

import java.util.Arrays;

public class Fex13 {

	public static void main(String[] args) {
		
		String[] arrToSort = {"apple","orange","bananas","manggo"};
		Arrays.sort(arrToSort);     //sort 순차정렬
		for(String i:arrToSort) {
			System.out.print(i+",");
		}
		
		System.out.println("-----------------------------------------------------------------");
		int[] arrToast= {10,9,8,7,6,5,4,3,2,1};
		for(int i:arrToast) {
			System.out.print(i+",");
		}
		Arrays.sort(arrToast);  
		System.out.println(" ");
		System.out.println("sort후 배열 확인");
		for(int i:arrToast) {
			System.out.print(i+",");
		}

		String s="자바 코딩 배우기";
		System.out.println(s.replace('자', ' '));//자의 글자를 space로 치환
	}

}
