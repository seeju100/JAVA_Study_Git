package event_handling;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class Ex4 {
	
	public Ex4() {
		showFrame();
	}
	
	public void showFrame() {
		JFrame f = new JFrame("이벤트처리 - 4");
		f.setBounds(600, 400, 300, 300);
		
		/*
		 * < 이벤트 처리 5단계 >
		 * 4단계. 익명 내부클래스(Anonymous Inner Class) 형태로 정의
		 * - 리스너 인터페이스 또는 어댑터 클래스를 구현하는 핸들러를 별도로 정의하지 않고
		 *   해당 리스너 또는 어댑터의 이름을 그대로 사용하여
		 *   변수 선언 및 인스턴스 생성과 추상메서드 구현까지 한꺼번에 수행하는 방법
		 * - 개발자가 별도의 핸들러 이름을 부여하지 않으므로
		 *   이름이 없다는 뜻의 익명클래스라는 의미가 붙게됨  
		 * - 3단계 위치와 동일하며 클래스 정의 방법만 달라짐
		 * 
		 * */
		
		// 로컬 내부 클래스 형태로 정의
		// => 로컬변수와 동일한 범위에서만 접근 가능
		WindowAdapter listener = new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("로컬 windowClosing");
				System.exit(0);
			}

		};
		
		// 람다식??
		// => WindowAdapter가 Interface가 아니므로 람다식 적용 X
//		WindowAdapter listener2 = (e) -> {
//			System.out.println("로컬 windowClosing");
//			System.exit(0);
//		};
		
		f.addWindowListener(listener);
		
		f.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Ex1();
		
	}
	
	// 이벤트 처리 4단계. 익명 내부 클래스 (Anonymous Inner Class) 형태로 정의
	// => WindowAdapter 또는 WindowListener 이름을 그대로 사용하여
	//    참조변수선언, 객체생성, 클래스바디 내의 추상메서드 정의까지 한꺼번에 수행
	//
	// 멤버 내부 클래스 형태로 정의
	// => 인스턴스 멤버와 동일한 위치에 정의하므로 인스턴스 내부 클래스라고도 함
	// => 인스턴스 내의 여러 메서드에서 공유 가능
	WindowAdapter listener = new WindowAdapter() {

		@Override
		public void windowClosing(WindowEvent e) {
			System.out.println("멤버 windowClosing");
			System.exit(0);
		}
		
	};
	
	// WindowListener 인터페이스를 익명 내부 클래스 형태로 정의할 경우
	WindowListener listener2 = new WindowListener() {
		
		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
	};
	
}






