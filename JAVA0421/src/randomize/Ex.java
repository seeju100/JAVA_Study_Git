package randomize;

import java.util.Random;

public class Ex {

	public static void main(String[] args) {
		/*
		 * 기본적인 난수 발생 방법(java.util.Random vs java.lang.Math.random())
		 * 1. Math.random()
		 *    - 별도의 인스턴스 생성이 불필요하므로(static 메서드 제공) 간단
		 *    - 안정성이 Random 클래스에 비해 떨어짐
		 *      => 시스템의 시각 정보를 seed 값으로 사용하므로, 난수의 빈도가 유사함
		 *    - 항상 double 타입 범위의 값이 난수로 발생되므로, 정수 등의 데이터는 가공 필요함
		 * 
		 * 2. Random
		 *    - 별도의 인스턴스 생성이 필요함
		 *    - Seed 값을 지정 가능하므로 Math 클래스에 비해 난수 자체에 대한 안정성 높음
		 *    - 각 난수 종류에 따라 별도의 메서드가 제공되므로 좀 더 간편한 난수 발생 가능
		 *      ex) 정수 난수 발생 : nextInt() 메서드, 실수 난수 발생 : nextDouble(), 논리 난수 발생 : nextBoolean() 등
		 *    - 시드(seed) 값을 설정하지 않으면 Math.random() 메서드와 동일하게 시스템의 시각 정보를 seed 값으로 사용
		 * 
		 * => Random 클래스도 별도의 seed 값을 설정하지 않으면 매번 동일한 형태의 난수가 발생되며
		 *    이를 가짜 난수 즉, 의사 난수가 생성됨
		 * => 결론! Random 대신 SecureRandom 클래스를 사용하는 것이 좋다!
		 *    
		 */
		
		// Random 클래스를 활용한 4자리 난수 생성
		// 1. Random 클래스 인스턴스 생성
		Random r = new Random(); // 시드값 없이 인스턴스 생성(현재 시스템의 시각을 시드값으로 사용 => 추천하지 않음)
		
		// 2. Random 객체의 nextXXX() 메서드를 호출하여 특정 범위의 난수 발생
		// => r.nextInt(최대값); 지정 시 0 ~ 최대값-1까지 생성됨
		// => 정수 1 ~ 10 까지 범위 지정 시 결과값 + 1 을 통해 1 ~ 10 까지 난수 발생 필요
//		int rNum = r.nextInt(10) + 1;
//		System.out.println(rNum);
//		for(int i = 1; i <= 10; i++) {
//			int rNum = r.nextInt(10); // 0 ~ 9 까지 범위 난수 발생
//			int rNum = r.nextInt(10) + 1; // 1 ~ 10 까지 범위 난수 발생
//			int rNum = r.nextInt(45) + 1; // 1 ~ 10 까지 범위 난수 발생
//			System.out.println(rNum);
//		}
		
		// 4자리 인증코드 생성할 경우(0000 ~ 9999)
		for(int i = 1; i <= 10; i++) {
//			int rNum = r.nextInt(10000); // 0 ~ 9999
//			System.out.println(rNum);
			// => 주의! 숫자 데이터 생성할 경우 모자라는 자릿수는 표시되지 않음
			//    ex) 387 의 경우 0387 로 생성 불가능
			// => 따라서, String.format() 메서드 등으로 문자열을 통해 자릿수 채우는 추가 작업 필요
			//    String.format("형식패턴", 데이터...);
			String randomCode = String.format("%04d", r.nextInt(10000));
			// => %04d : d 는 10진수, 4는 4자리, 0은 빈자리를 0으로 채움
			System.out.println(randomCode);
		}
		
		
	}

}





















