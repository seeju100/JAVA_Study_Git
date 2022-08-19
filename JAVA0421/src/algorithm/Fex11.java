package algorithm;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Fex11 {
		/*
		 * 배열 크기 순서대로 나열 (선택정렬)
		 * */
	public static void main(String[] args) {
//		String a ="1234";
//		String b = "1234";
//		int sum = Integer.parseInt(a)+Integer.parseInt(b);
//		System.out.println(sum);
		
//		int[] arr = {10,1,5,3,13,9,2};
//		
//		
//		Arrays.sort(arr);
//		for(int i=0;i<arr.length;i++) {
//			System.out.print("["+arr[i]+"]");
//		}
//		System.out.println();
//		
//		for(int i :arr) {
//			System.out.print("["+i+"]");
//		}
//		System.out.println();
//		
//		Arrays.sort(arr,0,4);
//		for(int i=0;i<arr.length;i++) {
//			System.out.print("["+arr[i]+"]");
//		}
//		System.out.println();
		//---------------------------------------------------------------
		
		int[] arr =new int[10];
		for(int i=0;i<arr.length;i++) {
			arr[i]=(int)(Math.random()*10+1);
		}
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]>arr[j]) {
					int temp =arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		for(int i:arr) {
			System.out.print("["+i+"]");
		}
		
		
		
		
	}

}
