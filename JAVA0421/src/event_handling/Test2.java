package event_handling;

public class Test2 {

	public Test2() {
		showFrame();
	}
	
	public void showFrame() {
		// 이벤트 처리 2단계.
		// ActionListener -> ActionAdapter
		// ActionListener는 추상메서드가 하나뿐이므로
		// 별도의 어댑터 클래스 (ActionAdapter)가 제공되지 않는다!
	}
	
	public static void main(String[] args) {
		new Test2();
	}

}

//class MyActionAdapter extends ActionAdapter {
//	
//}

