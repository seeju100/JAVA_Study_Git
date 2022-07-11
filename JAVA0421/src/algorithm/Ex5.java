package algorithm;

import java.util.Scanner;
/*
 * 백준 - 1292번
 * 동호는 내년에 초등학교를 입학한다. 그래서 동호 어머니는 수학 선행 학습을 위해 쉽게 푸는 문제를 동호에게 주었다.
 * 이 문제는 다음과 같다. 
 * 1을 한 번, 2를 두 번, 3을 세 번, 이런 식으로 1 2 2 3 3 3 4 4 4 4 5 .. 이러한 수열을 만들고 어느 일정한 구간을 주면 그 구간의 합을 구하는 것이다.
 *입력----------------------
 *첫째 줄에 구간의 시작과 끝을 나타내는 정수 A, B(1 ≤ A ≤ B ≤ 1,000)가 주어진다. 즉, 수열에서 A번째 숫자부터 B번째 숫자까지 합을 구하면 된다.
 *출력-----------------------
 *첫 줄에 구간에 속하는 숫자의 합을 출력한다.
 * */
public class Ex5 {

	public static void main(String[] args) {
//-----------------------------------------------풀이1
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int[] seq= new int[1003];
		int index=1;
		for(int i=1;i<=1000;i++) {
			for(int j=0;j<i;j++) {
				seq[index]=i;
				index++;
				
				if(index==1000) { //배열의 크기가 1000이 되면 for문 탈출
					break;
				}
			}//자식 for
		}//부모for
		int sum=0;
		
		for(int i=a;i<=b;i++) {
			sum+= seq[i];  //Scanner로 받은 a,b값으로 for문 생성 후 모든값 더하기
		}
		System.out.println(sum);
	}

}
