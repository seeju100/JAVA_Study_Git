package swing;

import javax.swing.JFrame;

/*
 * 400 * 400 크기의 창 생성
 * 제목 : JFrame 생성 연습
 * 닫기 버튼 클릭 시 프로그램 종료
 * 화면 표시 설정 : true
 * 
 * */

public class Test1 extends JFrame {

	public Test1() {
		showFrame();
	}
	
	public void showFrame() {
		// JFrame 객체 생성 version
//		JFrame f = new JFrame("JFrame 생성 연습");
//		f.setSize(400, 400);
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		f.setVisible(true);
		
		// JFrame 상속 받는 version
		setTitle("JFrame 생성연습");
		setSize(400, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new Test1();
	}

}



