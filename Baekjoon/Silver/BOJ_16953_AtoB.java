package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16953_AtoB {
	private static int num1;
	private static int num2;
	private static int min = Integer.MAX_VALUE;

	/*
	 * 1. 완탐으로 모든 경우를 다해보기 2. target number가 나오면 해당 연산 횟수 +1 출력 3. 만들 수 없는 경우 -1 출력
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		num1 = Integer.parseInt(st.nextToken());
		num2 = Integer.parseInt(st.nextToken());

		dfs(num2, 0);

		if (min != Integer.MAX_VALUE) {
			System.out.println(min);
		} else
			System.out.println(-1);
	}

	private static void dfs(int num2, int count) {
//		System.out.println("num1: " + num1 + " count : "+ count);
		if (num2 == num1) {
			min = Math.min(min, count + 1);
//			System.out.println("min : " + min);
			return;
		}
		int divideNum = 0;
		int minusOneNum = 0;
		
		if (num2 % 2 == 0) {
			divideNum = num2 / 2;
		}
		if (num2 % 10 == 1) {
			minusOneNum = num2 / 10;
		}

		if (divideNum != 0 || minusOneNum != 0) {
			if ((divideNum >= 1 && divideNum >= num1) || (minusOneNum >= 1 && minusOneNum >= num1)) {
				dfs(divideNum, count + 1);
				dfs(minusOneNum, count + 1);
			}
		}
	}
}
