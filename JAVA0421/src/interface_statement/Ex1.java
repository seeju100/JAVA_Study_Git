package interface_statement;


interface A {
	// 상수
	int a = 10;
	public int b = 20;
	public static int c = 30;
	
	// 추상메서드
	void turnOn();
	String methodA();
	String methodB(int a, String b);
}
interface B {
	void mehtodBB();
}
interface C extends A, B {}	// 다중상속 가능

class ImplClass implements A, B {

	@Override
	public void turnOn() {
		
	}

	@Override
	public String methodA() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String methodB(int a, String b) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void mehtodBB() {
		// TODO Auto-generated method stub
		
	}
	
}

class SubClass extends ImplClass implements A, B {
	
}




public class Ex1 {

	public static void main(String[] args) {
		
	}

}
