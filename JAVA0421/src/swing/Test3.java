package swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/*
 * JFrame 객체 2개 생성
 * - 1번 크기와 위치 (800, 400, 300, 200)
 * - 2번 크기와 위치 (200, 200, 500, 500)
 * 
 * JButton 객체 2개 생성 (버튼1, 버튼2)
 * 각각 프레임에 버튼 부착
 * 이벤트: "버튼X 클릭됨!" 이라고 출력 (람다식)
 * 
 * */

public class Test3 {
	
	public Test3() {
		showFrame();
	}
	
	public void showFrame() {
		// JFrame 객체 생성
		JFrame f1 = new JFrame("프레임1");
		JFrame f2 = new JFrame("프레임2");
		
		// JFrame 크기와 위치 설정
		f1.setBounds(800, 400, 300, 200);
		f2.setBounds(200, 200, 500, 500);
		
		// JButton 객체 생성
		JButton btn1 = new JButton("버튼1");
		JButton btn2 = new JButton("버튼2");
		
		// JFrame 객체에 JButton 객체 부착
		f1.add(btn1);
		f2.add(btn2);
		
		// JButton 객체에 이벤트 연결
//		btn1.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				System.out.println("버튼1 클릭됨!");
//				
//			}
//		});
//		
//		btn2.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				System.out.println("버튼2 클릭됨!");
//				
//			}
//		});
		
		// JButton 객체에 이벤트 연결(람다식 version)
//		btn1.addActionListener(e -> System.out.println(btn1.getText() + " 클릭됨!"));
//		btn2.addActionListener(e -> System.out.println(btn2.getText() + " 클릭됨!"));
		
		ActionListener action = e -> System.out.println(((JButton)e.getSource()).getText() + " 클릭됨!");
		btn1.addActionListener(action);
		btn2.addActionListener(action);
		
		
		
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f1.setVisible(true);
		f2.setVisible(true);
	}

	public static void main(String[] args) {
		new Test3();
	}

}
