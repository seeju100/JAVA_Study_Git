package event_handling;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Test5 {

	public Test5() {
		showFrame();
	}
	
	public void showFrame() {
		JFrame f = new JFrame("이벤트처리 연습 - 5");
		f.setBounds(600, 400, 300, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btn = new JButton("버튼");
		f.add(btn);
		
		// 이벤트 처리5. 익명 내부클래스의 임시객체 형태로 이벤트 처리
		// JButton 컴포넌트에 대한 이벤트 처리 담당 리스너 : ActionListener 인터페이스
		// 1. JButton 객체의 addActionListener() 메서드를 호출하여 구현체 객체 전달
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("버튼 클릭!");
			}
		});
		
		// 2. 람다식
		btn.addActionListener(e -> System.out.println("람다식 버튼 클릭!"));
		
		f.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Test2();
	}

}
