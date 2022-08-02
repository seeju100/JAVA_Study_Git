package thread;

public class Test3 {

	public static void main(String[] args) {
		GugudanThread gt1 = new GugudanThread(2);
		GugudanThread gt2 = new GugudanThread(5);
		GugudanThread gt3 = new GugudanThread(9);
		
//		gt1.start();
//		gt2.start();
//		gt3.start();
		
		System.out.println("=======================================");
		
		// GugudanRunnable 인스턴스 3개 생성(각각 다른 단을 생성자에 전달)
		// start() 메서드 호출
//		GugudanRunnable g1 = new GugudanRunnable(2);
//		GugudanRunnable g2 = new GugudanRunnable(5);
//		GugudanRunnable g3 = new GugudanRunnable(9);
//		
//		Thread t1 = new Thread(g1);
//		Thread t2 = new Thread(g2);
//		Thread t3 = new Thread(g3);
		
		Thread t1 = new Thread(new GugudanRunnable(2));
		Thread t2 = new Thread(new GugudanRunnable(5));
		Thread t3 = new Thread(new GugudanRunnable(9));
		
		t1.start();
		t2.start();
		t3.start();
		
		new Thread(new GugudanRunnable(7)).start();
		
	}

}

/*
 * GugudanRunnable 클래스 정의 - Runnable 인터페이스 구현
 * - 멤버변수(int dan)
 * - 생성자 정의(int형 변수 dan을 초기화하는 생성자)
 * - run() 메서드 내부에서 dan에 해당하는 구구단을 100번 반복 출력 => 멀티쓰레드!
 * 
 * */
class GugudanRunnable implements Runnable {

	int dan;
	
	public GugudanRunnable(int dan) {
		this.dan = dan;
	}

	@Override
	public void run() {
		for(int count = 1; count <= 100; count++) {
			for(int i = 1; i <= 9; i++) {
				System.out.printf("%d단 : %d * %d = %d \n", dan, dan, i, dan*i);
			}
		}
	}
	
}





class GugudanThread extends Thread {

	int dan;
	
	public GugudanThread(int dan) {
		this.dan = dan;
	}

	@Override
	public void run() {
		for(int count = 1; count <= 1000; count++) {
			for(int i = 1; i <= 9; i++) {
				System.out.printf("%d단 : %d * %d = %d \n", dan, dan, i, dan*i);
			}
		}
	}
	
}





