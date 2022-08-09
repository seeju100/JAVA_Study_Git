package event_handling;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Test1 {
	
	public Test1() {
		showFrame();
	}
	
	public void showFrame() {
		/*
		 * 1. 300, 200 프레임 생성
		 * 2. "버튼" 이라는 텍스트를 갖는 버튼 객체 부착(CENTER영역)
		 * 3. 클릭 이벤트 처리를 위해 ActionListener 인터페이스를 구현 핸들어(MyActionListener) 정의
		 *    => 추상 메서드 오버라이딩
		 *    => 메서드 내에 "버튼 클릭" 문자열 출력하는 코드 기술
		 * 4. ActionListener 인터페이스 구현체(MyActionListener) 객체 생성
		 * 5. 버튼 객체의 addXXXListener() 메서드 호출하여 MyActionListener 객체 전달
		 * */
		JFrame f = new JFrame("이벤트처리 연습-1");
		f.setBounds(800, 400, 300, 200);

		// JButton 객체 생성 및 JFrame 객체에 부착
		JButton btn = new JButton("버튼");
		f.add(btn);
		
		// JButton 객체의 addXXXListener() 메서드 호출하여 연결
		// 1. 리스너 구현체 객체 생성
		MyActionListener listener = new MyActionListener();
		
		// 2. JButton 객체의 addActionListener() 메서드를 호출하여 구현체 객체 전달
		btn.addActionListener(listener);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		// ===================================================
		
		JFrame f2 = new JFrame("버튼연습");
		f2.setBounds(300, 300, 300, 300);
		
		JButton btn2 = new JButton("버튼2");
		f2.add(btn2);
		
		btn2.addActionListener(listener);
		
		f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f2.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new Test1();
	}

}

// JButton 컴포넌트에 대한 이벤트 처리 담당 리스너 : ActionListener 인터페이스
class MyActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// 버튼 클릭 시 자동으로 호출되는 메서드
		// => "버튼 클릭" 메세지 출력
		System.out.println("버튼 클릭!");
	}
	
}







