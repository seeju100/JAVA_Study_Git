package algorithm;

import java.util.Scanner;

public class Fex10 {
	/*
	 * 백준 1834번 =나머지와 몫이 같은 수
	 * N으로 나누었을 때 나머지와 몫이 같은 모든 자연수의 합을 구하는 프로그램을 작성하시오. 
	 * 예를 들어 N=3일 때, 나머지와 몫이 모두 같은 자연수는 4와 8 두 개가 있으므로,
	 * 그 합은 12이다.
	 * 입력: 첫째 줄에 2,000,000 이하의 자연수 N이 주어진다.
	 * 출력: 첫 줄에 구하고자 하는 수를 출력한다.
	 * */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a=0;  //a : n 으로 임의의 수를 나눈 값 (몫)
		int b=0;  //b : n 으로 임의의 수를 나눈 나머지(나머지)
		int sum=0; //a의 값과 b이 같다면 sum의 변수에 담기 
		System.out.println(n+"의 몫과 나머지가 같은 수 찾기");
		//-----------------------------------------------
		for(int i=0;i<=2100000000;i++) {
			a=i/n;	//몫의 값을 a에 담기
			b=i%n;  //나머지 값을 b에 담기
			if(a==b) {
				sum+=i;
			}
			else {
				continue;
			}
		}
		System.out.println(sum);

	}

}
