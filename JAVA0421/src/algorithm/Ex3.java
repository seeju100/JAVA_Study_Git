package algorithm;

import java.util.Scanner;

public class Ex3 {
/*
 *백준 1236번 성지키기 
 * 영식이는 직사각형 모양의 성을 가지고 있다. 
 * 성의 1층은 몇 명의 경비원에 의해서 보호되고 있다. 
 * 영식이는 모든 행과 모든 열에 한 명 이상의 경비원이 있으면 좋겠다고 생각했다.
 *성의 크기와 경비원이 어디있는지 주어졌을 때, 
 *몇 명의 경비원을 최소로 추가해야 영식이를 만족시키는지 구하는 프로그램을 작성하시오.
 * ------------------------------------------------------------------------
 * (입력)첫째 줄에 성의 세로 크기 N과 가로 크기 M이 주어진다.
 * N과 M은 50보다 작거나 같은 자연수이다. 둘째 줄부터 N개의 줄에는 성의 상태가 주어진다. 
 * 성의 상태는 .은 빈칸, X는 경비원이 있는 칸이다.
 * ------------------------------------------------------------------------
 * (출력)첫째 줄에 추가해야 하는 경비원의 최솟값을 출력한다.
 * */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //세로
		int m = sc.nextInt(); //가로
		int row =0;  //행
		int col=0;   //열
		char[][] map = new char[n][m];
		for(int i=0;i<map.length;i++) {
				String str = sc.next();
				for(int j=0;j<map[i].length;j++) {
					map[i][j] =str.charAt(j);
				}
		}
		
		//행에 필요한 경비원 수 
		for(int i=0;i<n;i++) {
			boolean flag =true;
			for(int j=0;j<m;j++) {
				if(map[i][j]=='x') {
					flag = false;
					break;
				}
			}
			if(flag) 
				row++;
		}
		
		//열에 필요한 경비원 수 
		for(int i=0;i<m;i++) {
			boolean flag = true;
			for(int j=0;j<n;j++) {
				if(map[j][i]=='x') {
					flag=false;
					break;
				}
			}
			if(flag)
				col++;
		}
		//행,열 중 더 많은 경비원 추가
		System.out.println(Math.max(row, col));
		sc.close();
		
	}
}
