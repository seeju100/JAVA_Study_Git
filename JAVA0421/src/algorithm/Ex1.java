package algorithm;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex1 {
/*
 * 백준 1157번
 * 알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오.
 *  단, 대문자와 소문자를 구분하지 않는다.
 * String -> null사용 가능
 * Char -> null 사용 불가능 대신 '(Space)'  OR '\u0000' 으로 null값 대신 사용 가능
 */
	public static void main(String[] args) {
//		ArrayList<Character> strArr = new ArrayList<Character>();
//		Scanner sc = new Scanner(System.in);
//		System.out.println("단어를 입력해주세요.");
//		
//		String words =sc.nextLine();
//		System.out.println(words+"을 입력하셨습니다.");		
//		int i=0;
//		while(words.charAt(i)==' ') {
//			strArr.add(words.charAt(i));
//			i++;
//		}
//		System.out.println(strArr);
//-----------------------------------------------------------------------------
		Scanner sc = new Scanner(System.in);
		String str = sc.next().toUpperCase();  //확인하고싶은 단어 입력  //빌더패턴으로 1.글을 입력(대소문자 구분) 2.toUpperCase()-->모두 대문자로변형
		System.out.println(checkAnswer(str));  //확인할 단어 중 가장 많이 사용된 단어 출력
		}
	public static char checkAnswer(String str) {

		int[] count = new int[26];  //a~z ,A~Z 총 26개
		
		for(int i=0;i<str.length();i++) {
			int num = str.charAt(i) -'A'; //{0,0,1}
			count[num]++;
		}	
		int max =0;
		char answer = '?';
		
		for(int i=0;i<count.length;i++) {
			System.out.println(count[i]);
			if(max<count[i]) {
				max =count[i];  //AAB
				answer = (char)(i+'A');
				System.out.println(i+"번째:"+answer);
			}else if(max == count[i]) {
				answer='?';
				System.out.println(i+":번째"+answer);
			}
	}	
		return answer;
	}//main
	
}//class Ex1