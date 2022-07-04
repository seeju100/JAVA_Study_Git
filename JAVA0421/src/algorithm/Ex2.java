package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex2 {
	/*	백중 1193번 분수찾기
	 * 
	 * 이와 같이 나열된 분수들을 1/1 → 1/2 → 2/1 → 3/1 → 2/2 → … 과 같은 지그재그 순서로 차례대로 1번, 2번, 3번, 4번, 5번, … 분수라고 하자.
	 *	X가 주어졌을 때, X번째 분수를 구하는 프로그램을 작성하시오.
	 * 
	 * */
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());
		
		int cross_count =1; //해당 범위의 대각선 칸 개수
		int prev_count_sum = 0; //해당 대각선 직전 대각선 까지의 칸의 누적 합
		
		while(true) {
			//직전 대각선 누적합 + 해당 대각선 개수 이용한 범위 판별
			if(x<=(prev_count_sum + cross_count)) {
				if(cross_count %2 ==1) { //대각선의 개수가 홀수 일 경우
					//분모가 큰 수부터 시작
					//분모는 대각선 개수 -(x번째 - 직전 대각선까지의 누적합 -1)
					//분자는 x번째 - 직전 대각선까지의 누적합
					System.out.println((cross_count -(x - prev_count_sum -1)+"/"+(x - prev_count_sum)));
				break;
				}else { //대각선 갯수가 짝수일 경우 
					//홀수일 때의 출력을 반대로 출력
					System.out.println((x-prev_count_sum)+"/"+(cross_count - (x-prev_count_sum-1)));
					break;
				}
				
			}else {
				prev_count_sum +=cross_count;
				cross_count++;
			}
		}
		
		
		

	}

}
