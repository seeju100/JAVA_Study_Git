package algorithm;

import java.util.Scanner;

public class Ex7 {
 /* 백준 1371번
  * 영어에서는 어떤 글자가 다른 글자보다 많이 쓰인다. 예를 들어, 긴 글에서 약 12.31% 글자는 e이다.
  * 어떤 글이 주어졌을 때, 가장 많이 나온 글자를 출력하는 프로그램을 작성하시오.
  * 
  */
	public static void main(String[] args) {
	Scanner sc= new Scanner(System.in);
	int[] alphabet = new int[26];
	
	while(sc.hasNextLine()) {
		String str =  sc.nextLine();
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)>='a'&& str.charAt(i)<='z') {
				alphabet[str.charAt(i-'a')]++;
			}
		}
	}
	
	int max=0;
	for(int i=0;i<26;i++){
		if(max<alphabet[i]) {
			max= alphabet[i];
		}
	}
	
	for(int i=0;i<26;i++){
		if(max== alphabet[i]) {
			System.out.println((char)(i+'a'));
		}
	}
	
	
	
	
	
	
	
	
	
	}
}
