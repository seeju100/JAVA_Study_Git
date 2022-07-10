package algorithm;

import java.util.Scanner;

public class Ex4 {
	/*
	 * 1259번 
	 * 어떤 단어를 뒤에서부터 읽어도 똑같다면 그 단어를 팰린드롬이라고 한다. 'radar', 'sees'는 팰린드롬이다.
	 * 수도 팰린드롬으로 취급할 수 있다. 수의 숫자들을 뒤에서부터 읽어도 같다면 그 수는 팰린드롬수다. 
	 * 121, 12421 등은 팰린드롬수다. 123, 1231은 뒤에서부터 읽으면 다르므로 팰린드롬수가 아니다. 또한 10도 팰린드롬수가 아닌데, 
	 * 앞에 무의미한 0이 올 수 있다면 010이 되어 팰린드롬수로 취급할 수도 있지만, 
	 * 특별히 이번 문제에서는 무의미한 0이 앞에 올 수 없다고 하자.
	 * ------------------------------------------------------------
	 * 입력
	 * 입력은 여러 개의 테스트 케이스로 이루어져 있으며, 각 줄마다 1 이상 99999 이하의 정수가 주어진다.
 	 * 입력의 마지막 줄에는 0이 주어지며, 이 줄은 문제에 포함되지 않는다.	 
	 * ------------------------------------------------------------
	 * 출력
	 * 각 줄마다 주어진 수가 팰린드롬수면 'yes', 아니면 'no'를 출력한다.
	 * ------------------------------------------------------------
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			String N = sc.next();
			if(N.equals("0"))System.exit(0);  //0입력시 프로그램 정지
			String[] arr1 = new String[N.length()]; //배열선언 -->N의 length만큼 생성
			String[] arr2 = new String[N.length()]; //배열선언 -->N의 length만큼 생성
			
			for(int i=0;i<N.length();i++) {    //arr1의 배열에 N의 length만큼 반복문 실행 -->substring으로 n을 파싱하여 arr1에 저장
				arr1[i] =N.substring(i,i+1);				
//				System.out.println(arr1[i] =N.substring(i,i+1));
			}
//			System.out.println("---------------------");
			for(int i=0;i<N.length();i++) {    //arr2의 배열에 N의 length만큼 반복문 실행 -->arr1의 인덱스를 반대로 arr2에 저장
				arr2[i] =arr1[N.length()-1-i];
//				System.out.println(arr2[i] =arr1[N.length()-1-i]);
			}									
			int count =0;
			for(int i=0;i<N.length();i++) {    //arr1의 인덱스와 arr2의 인덱스의 값이 일치하는지 판별후 일치하면 count++
				if(arr1[i].equals(arr2[i])) {  //불일치시 continue;
					count++;
				}
			}
			
			if(count ==N.length()) {	//count의 갯수와 N의 length만큼을 조건문if로 구분 
				System.out.println("yes");
				}else {
				System.out.println("No");
			}
		
		}
	}
}
