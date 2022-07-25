package collection;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Test3 {

	public static void main(String[] args) {
		/*
		 * Stack 객체 1개 생성(stack)
		 * => 웹사이트 주소 4~5개 추가
		 * => 반복문 사용하여 Top 에서부터 하나씩 객체를 꺼내서 출력 후 제거(pop())
		 * 
		 * */
		Stack stack = new Stack();
		
		stack.push("1 - www.itwillbs.co.kr");
		stack.push("2 - www.naver.com");
		stack.push("3 - www.youtube.com");
		stack.push("4 - www.google.com");
		stack.push("5 - www.nate.com");
		
		System.out.println("제거 전 : " + stack);
		
//		int length = stack.size();
//		for(int i=0; i<length; i++) {
//			System.out.println(stack.pop()); 
//		}
		
//		for(int i = stack.size(); i > 0; i--) {
//			System.out.println(stack.pop());
//		}
		
		// 향상된 for문은 원본데이터 그대로 유지될때 써야함
//		for(Object o : stack) {
//			System.out.println(o);
//		}
		
//		while(stack.size() > 0) {
//			System.out.println(stack.pop());
//		}
		
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
		
		System.out.println("제거 후 : " + stack);
		
		
		
		System.out.println("==========================================");
		
		/*
		 * Queue 객체 1개 생성
		 * => 파일 4~5개 추가
		 * => 반복문을 사용하여 하나씩 객체를 꺼내서 출력 후 제거(poll())
		 * 
		 * */
		
		Queue q = new LinkedList();
		
		q.offer("1 - Ex.java");
		q.offer("2 - main.jsp");
		q.offer("3 - a.txt");
		q.offer("4 - windows.jpg");
		q.offer("5 - talk.wav");
		
		System.out.println("제거 전 : " + q);
		
		while(!q.isEmpty()) {
			System.out.println(q.poll());
		}
		
		System.out.println("제거 후 : " + q);
	}

}
