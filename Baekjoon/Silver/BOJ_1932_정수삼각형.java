package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1932_정수삼각형 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] numArr = new int[N][N];
		int[][] dp = new int[N][N];

		// 입력
		numArr[0][0] = Integer.parseInt(br.readLine().trim());
		for (int i = 1; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < i + 1; j++) {
				numArr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp[0][0] = numArr[0][0];
		for (int i = 1; i < N; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0) {
					dp[i][j] = dp[i - 1][j] + numArr[i][j];
				} else if (j > 0 && j < i) {
					dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + numArr[i][j];
				} else {
					dp[i][j] = dp[i - 1][j - 1] + numArr[i][j];
				}
			}
		}

		int answer = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			answer = Math.max(answer, dp[N - 1][i]);
		}
		System.out.println(answer);
	} // end of main
}
