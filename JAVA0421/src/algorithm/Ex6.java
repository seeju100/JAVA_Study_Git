package algorithm;

import java.util.Scanner;
import java.util.Stack;

public class Ex6 {
/*
 * 어떤 수 X가 주어졌을 때, X의 모든 자리수가 역순이 된 수를 얻을 수 있다. 
 * Rev(X)를 X의 모든 자리수를 역순으로 만드는 함수라고 하자. 예를 들어, X=123일 때, Rev(X) = 321이다. 
 * 그리고, X=100일 때, Rev(X) = 1이다.
 * 두 양의 정수 X와 Y가 주어졌을 때, Rev(Rev(X) + Rev(Y))를 구하는 프로그램을 작성하시오
 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int x =sc.nextInt();
		int y = sc.nextInt();
		
		sc.close();
		int X = rev(x);
		int Y = rev(y);
		int res = rev(X+Y);
		System.out.println(res);
	}
	public static int rev(int n) {  //rev(int x){숫자를 반대로 만들어줄 내용 구현}
		String str="";
		while(n>0) {
			str+=n%10;
			n/=10;
		}
		
		
		return Integer.parseInt(str);
	}
	
}
