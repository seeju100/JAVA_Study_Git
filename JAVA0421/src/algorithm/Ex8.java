package algorithm;

import java.util.Scanner;

public class Ex8 {
	
	/*
	 * 백준 1373번
	 * 2진수가 주어졌을 때, 8진수로 변환하는 프로그램을 작성하시오.
	 * */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("0과1의 숫자만 입력 가능");
		int num=sc.nextInt();
		int mok = 0;
		int a , b, c =0; 
		String s="";  // 먼저 담은 배열
		String real="";//실제로 8진수로 담길값
		for(int i=0;;i++) {
			mok=num%1000;     //내가 입력하는 num의 값을 1000으로 나머지로 나눠 2진수의 3자리까지 파싱작업
			num=num/1000;	  //다음 8진수의 값을 나타내기위하여 num의 뒤의 3자리를 떼준다.
//			System.out.println(i+"번째"+"num="+num);
//			System.out.println("몫:"+mok);
			for(int q=0;q<3;q++) {
				a= mok%10;  mok=mok/10;
				int qw =(int) Math.pow(2, q);
				
				s+=a*qw;
			}
			
			   //	A:첫번째자리 1^2
//			System.out.println("첫번째 자리:"+a);
//			b= mok%10; 	mok=mok/10;	  //	B:두번째자리 1^2
////			System.out.println("두번째 자리:"+b);
//			c= mok%100;	mok=mok/10;   //	C:세번째자리 1^2^2
////			System.out.println("세번째 자리:"+c);
////			System.out.println("합:"+((a*1)+(b*2)+(c*2*2)));
//			s+=((a*1)+(b*2)+(c*2*2));	
			if(num==0) {    //2진수
				break;
			}
		}
//		System.out.println(s);
		for(int j=s.length()-1;j>=0;j--) {
			real+=s.charAt(j);  //s의 글자의 index의 최대값부터 0까지 반대로 출력하여 
			//real의 String에 차례대로 넣어준다.
		}
		System.out.println(real); //2진수 -> 8진수
	}

}
