package algorithm;

import java.util.Scanner;

public class Ex9 {
	/* 백준 1652번
	 * 일 년 동안 세계일주를 하던 영식이는 여행을 하다 너무 피곤해서 근처에 있는 코레스코 콘도에서 하룻밤 잠을 자기로 하고 방을 잡았다.
	 *	코레스코 콘도에 있는 방은 NxN의 정사각형모양으로 생겼다. 
	 *  방 안에는 옮길 수 없는 짐들이 이것저것 많이 있어서 영식이의 누울 자리를 차지하고 있었다. 
	 *	영식이는 이 열악한 환경에서 누울 수 있는 자리를 찾아야 한다. 영식이가 누울 수 있는 자리에는 조건이 있다. 똑바로 연속해서 2칸 이상의 빈 칸이 존재하면 그 곳에 몸을 양 옆으로 쭉 뻗으면서 누울 수 있다. 가로로 누울 수도 있고 세로로 누울 수도 있다. 누울 때는 무조건 몸을 쭉 뻗기 때문에 반드시 벽이나 짐에 닿게 된다. 
	 *	(중간에 어정쩡하게 눕는 경우가 없다.)
	 * */
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int num = sc.nextInt();
		
		char[][] map= new char[101][101];
		int horizontal =0; //가로 개수 
		int vertical=0;  //세로 개수
		
		//입력받기
		for(int i=0;i<num;i++) {
			String s=sc.next();
			for(int j=0;j<num;j++) {
				map[i][j] =s.charAt(j);
			}
		}
		
		//가로세로 방향으로 누울 수 있는지 자리 여부 확인
		for(int i=0;i<num;i++) {
			int check_h =0, check_v=0;
			for(int j=0;j<num;j++) {
				//가로체크
				if(map[i][j] =='.')check_h++;
				if(map[i][j] =='x' || (j == num-1)) {
					if(check_h>=2) horizontal++;
					check_h=0;
				}
				
				//세로체크
				if(map[j][i] == '.')check_v++;
				if(map[j][i] == 'x' || (j == num-1)) {
					if(check_v>=2) vertical++;
					check_v=0;
				}
			}
		}
		
		System.out.println(horizontal+" , "+vertical );
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		}//main
		
	}//class

