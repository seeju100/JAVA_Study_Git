package Wrapper;

public class Ex1 {

	public static void main(String[] args) {
		/*
		 * Wrapper 클래스
		 * - 자바의 기본 데이터타입 8가지와 1:1로 대응하는 8개의 클래스의 모음(java.lang 패키지)
		 * - 대부분 기본 데이터타입 이름의 첫글자를 대문자로 사용하는 클래스명을 가지며,
		 *   char - Character, int - Integer 로 이름이 다르다!
		 *   => byte - Byte, short - Short, int - Integer, long - Long, char - Character
		 *      float - Float, double - Double, boolean - Boolean
		 * - 기본 데이터타입 변수로 할 수 있는 일이 한정적(데이터 저장 및 사용)이므로
		 *   이에 대한 클래스를 정의하여 클래스 내에 상수 및 다양한 메서드를 제공함으로써
		 *   기본 데이터타입에 대한 다양한 정보를 저장하거나, 다양한 작업을 수행하도록 지원
		 *   => 좀 더 효율적인 프로그래밍이 가능하도록 도와주는 클래스들의 모음     
		 * - 기본 데이터타입 데이터 (Stack 영역)를 Wrapper 클래스 객체로 변환하여 데이터 관리 가능
		 *   => Wrapper 클래스의 객체 주소를 Wrapper 클래스 타입 참조변수로 관리 가능(클래스 역할 동일)
		 * - Wrapper 클래스의 상수를 사용하여 해당 클래스에 대한 여러 정보 확인가능
		 *   => Wrapper클래스명.상수명(ex. Integer.SIZE)
		 * - Wrapper 클래스 내부에는 Object 클래스의 toString() 메서드가 오버라이딩 되어 있으므로
		 *   Wrapper 클래스 타입 객체에 저장된 값을 출력하면 출력문에 변수값 그대로 사용
		 * */
		
		System.out.println("byte 타입 메모리 크기: " + Byte.SIZE + "bit");
		System.out.println("byte 타입 메모리 크기: " + Byte.BYTES + "byte");
		System.out.println("byte 타입 최소값: " + Byte.MIN_VALUE);
		System.out.println("byte 타입 최대값: " + Byte.MAX_VALUE);
		
		// short
		System.out.println("========== short ==========");
		System.out.println(Short.SIZE + "bit");
		System.out.println(Short.BYTES + "byte");
		System.out.println(Short.MIN_VALUE);
		System.out.println(Short.MAX_VALUE);
		
		// int
		System.out.println("========== int ==========");
		System.out.println(Integer.SIZE + "bit");
		System.out.println(Integer.BYTES + "byte");
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.MAX_VALUE);
		
		// long
		System.out.println("========== long ==========");
		System.out.println(Long.SIZE + "bit");
		System.out.println(Long.BYTES + "byte");
		System.out.println(Long.MIN_VALUE);
		System.out.println(Long.MAX_VALUE);
		
		// float
		System.out.println("========== float ==========");	
		System.out.println(Float.SIZE + "bit");
		System.out.println(Float.BYTES + "byte");
		System.out.println(Float.MIN_VALUE);
		System.out.println(Float.MAX_VALUE);
		
	}

}
