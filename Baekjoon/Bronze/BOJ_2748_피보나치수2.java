package baekjoon.Bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2748_피보나치수2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] dp = new long[N + 1];

		dp[0] = 0;
		for (int i = 1; i <= N; i++) {
			if (i == 1) {
				dp[i] = 1;
			} else if (N >= 2) {
				dp[i] = dp[i - 1] + dp[i - 2];
			}
		}
		System.out.println(dp[N]);
	}
}
