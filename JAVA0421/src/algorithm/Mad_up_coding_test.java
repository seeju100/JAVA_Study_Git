package algorithm;

import java.util.Scanner;

public class Mad_up_coding_test {

	public static void main(String[] args) {

		//n자리 이진수중 1을 k 개 포함하여 3인배수를 모두 구하려함
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();  //2진수 자릿수
		int k = sc.nextInt();  //1의갯수
		int count =0;
		int result=0;
		int[] arr= new int[n];

		int sum=0;

		System.out.println("--------------");

		for(int i=0;i<n;i++) {
			sum+=Math.pow(2,i);
		}
		System.out.print("1이"+k+"개 포함된"+n+"자리 이진수 중 3의 배수인 이진수는");
		for(int j=1;j<=sum;j++) {
			int check =j;
			if(check%3==0) {
//				System.out.println(j+":이진수구하기");
				for(int q=0;q<n;q++) {
//					System.out.println(check%2);
					
					arr[q]=check%2;					
					if(check%2==1) count++;  //1의 개수증가시 카운트
					check=check/2;
//					if(count==k) {
//						result++; //k의값이 같다면 result 증가
//						for(int a:arr) {
//							System.out.print("["+a+"]");
//						}
//						System.out.print(","+" ");
						
					}
				if(count==k) {
					result++; //k의값이 같다면 result 증가
					for(int a:arr) {
						System.out.print("["+a+"]");
					}
					System.out.print(","+" ");	
				 }
				
				
				count=0; 
			}//if
		}
		System.out.println(result+"result 값"+"입니다.");
		
		
		
		
	}

}
