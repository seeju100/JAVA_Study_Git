package event_handling;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Test3 {

	public Test3() {
		showFrame();
	}
	
	public void showFrame() {
		JFrame f = new JFrame("이벤트처리 연습-3");
		f.setBounds(800, 400, 300, 300);
		
		// JButton 객체 생성 및 JFrame 객체에 부착
		JButton btn = new JButton("버튼");
		f.add(btn);
		
		// 이벤트 처리3. 내부 클래스 형태로 이벤트 처리
		// 1. 리스너 구현체 객체 생성
		MyMemberActionListener listener = new MyMemberActionListener();
		// 2. JButton 객체의 addActionListener() 메서드를 호출하여 구현체 객체 전달
		btn.addActionListener(listener);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Test3();
	}
	
	// 멤버레벨에 JButton 컴포넌트에 대한
	// 이벤트 처리 담당 리스너 : ActionListener 인터페이스
	class MyMemberActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("버튼 클릭!");
		}
	}
	
	// 람다식 X
//	class MyMemberActionListener e -> System.out.println("버튼 클릭!");
	
}




