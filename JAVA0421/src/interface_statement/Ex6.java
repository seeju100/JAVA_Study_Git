package interface_statement;
public class Ex6 {

	public static void main(String[] args) {
		/*
		 * 인터페이스의 default 메서드
		 * 충돌 발생 시 예외처리
		 * */
		
		// 1. (super)class vs interface (class Win!)
		CC c = new CC();
		c.method();
		
		// 2. interface vs interface (반드시 override)
		SubClass1 sub = new SubClass1();
		sub.method();
	}

}

// 1. (super)class vs interface (class Win!)
class AA {
	void method() {
		System.out.println("class A");
	}
}

interface BB {
	default void method() {
		System.out.println("interface B");
	}
}

class CC extends AA implements BB {

	@Override
	public void method() {
		System.out.println("호출됨!");
		super.method();
	}
	
}

// 2. interface vs interface (반드시 override)
interface I1 {
	default void method() {
		System.out.println("I1의 메서드");
	}
}

interface I2 {
	default void method() {
		System.out.println("I2의 메서드");
	}
}

class SubClass1 implements I1, I2 {

	@Override
	public void method() {
		System.out.println("SubClass의 메서드");
	}
	
}

// --------------------------------------------------
interface MyInterface {
	
	// Java 9
//	private void method() {
//		
//	}
	
}











