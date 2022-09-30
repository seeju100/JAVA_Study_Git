package algorithm;

import java.util.Scanner;

public class Fex14 {
	/*
	 * <프로그래머스 JadenCase 문자열 만들기>
	 * JadenCase란 모든 단어의 첫 문자가 대문자이고, 그 외의 알파벳은 소문자인 문자열입니다. 
	 * 단, 첫 문자가 알파벳이 아닐 때에는 이어지는 알파벳은 소문자로 쓰면 됩니다. (첫 번째 입출력 예 참고)
	 * 문자열 s가 주어졌을 때, s를 JadenCase로 바꾼 문자열을 리턴하는 함수, solution을 완성해주세요.
	 * 
	 * ------------------------------------------
	 *     s	     	       return
	 * "3people   	          3people
	 *  unFollowed me"      "Unfollowed Me"
     * "for the last week"	"For The Last Week"
	 * -------------------------------------------
	 * */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		
		System.out.println(solution(s));
	
	}
	public static String solution(String s) {
        String answer = "";
        String[] sp = s.toLowerCase().split("");
        boolean flag = true;

        for(String ss : sp) {
            answer += flag ? ss.toUpperCase() : ss;
            flag = ss.equals(" ") ? true : false;
        }

        return answer;
  }
}
