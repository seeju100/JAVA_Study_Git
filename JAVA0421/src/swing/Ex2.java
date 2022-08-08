package swing;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JFrame;

public class Ex2 {
	public Ex2() {
		showFrame();
	}
	
	public void showFrame() {
		JFrame f = new JFrame();
//		f.setSize(600, 400);
		
		// 크기를 지정하는 setSize() 파라미터에 Dimension 객체 전달 가능하며
		// Dimension 객체 사용 시 크기를 지정하는 값을 관리할 수 있음
		// => 여러 컨테이너나 컴포넌트의 크기가 일정할때 하나로 관리할 수 있음
//		Dimension d = new Dimension(600, 400);
//		f.setSize(d);
		
//		f.setLocation(800, 300);
		
		// 위치 좌표를 지정하는 setLocation() 파라미터에 Point 객체 전달 가능하며
		// Point 객체 사용 시 좌표를 지정하는 값을 관리 가능
		// => 여러 컨테이너나 컴포넌트의 위치가 일정할 때 하나로 관리할 수 있음
//		Point p = new Point(800, 300);
//		f.setLocation(p);
		
		// --------------------------------------------------------------------
		// setBounds() 메서드를 사용하면 좌표와 크기를 동시에 설정 가능
		// 1) setBounds(x, y, width, height) : x좌표, y좌표, 가로크기, 세로크기 순으로 전달
//		f.setBounds(800, 300, 600, 400);
		
		// 2) setBounds(Rectangle r) : 좌표와 크기를 관리하는 Rectangle 객체 전달 가능
		// => Rectangle 객체 생성 시 파라미터로 x, y, width, height 전달 하거나
		//    Point p, Dimention d 객체 전달도 가능
//		Point p = new Point(800, 300);
//		Dimension d = new Dimension(600, 400);
//		Rectangle r = new Rectangle(p, d);
		
		Rectangle r = new Rectangle(800, 300, 600, 400);
		
		
		f.setBounds(r);
		
		
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Ex2();
	}

}
