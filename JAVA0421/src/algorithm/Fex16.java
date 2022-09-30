package algorithm;

import java.util.*;

public class Fex16 {
	/*
	 * 프로그래머스 >>최솟값 만들기
	 * */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> A =new ArrayList<Integer>();
		ArrayList<Integer> B =new ArrayList<Integer>();
		System.out.println("배열에 넣을 크기 정하기=>");
		int q =sc.nextInt();
		System.out.println(q+"크기 만큼 값입력");
		System.out.println("----------------------------------");
		System.out.println("A배열");
		for(int i=0;i<q;i++) {
			int input = sc.nextInt();
			A.add(input);
		}
		System.out.println("B배열");
		for(int i=0;i<q;i++) {
			int input = sc.nextInt();
			B.add(input);
		}
		System.out.println(solution(A, B,q));

	}	
	public static int solution(ArrayList<Integer> a,ArrayList<Integer> b,int q) {
		System.out.println("solution메소드 시작<>---------------------------------------------");
		System.out.println("A정렬전:"+a.toString());
		System.out.println("B정렬전:"+b.toString());
		Collections.sort(a);   //A오름차순 정렬
		Collections.sort(b,Collections.reverseOrder()); //B내림차순 정렬		
		System.out.println("A정렬후:"+a+"(오름차순)");
		System.out.println("B정렬후:"+b+"(내림차순)");
		//------------------인덱스끼리 곱해서 더한후 합하기
		int[] arrSum= new int[q];
		for(int i=0;i<q;i++) {
			arrSum[i]+=a.get(i) * b.get(i);
		}
		int sum=0;
		for(int i=0;i<q;i++) {
			
			sum+=arrSum[i];
		}
		System.out.println("총 최솟값:"+sum);
		
		
		return sum;
	}
}
