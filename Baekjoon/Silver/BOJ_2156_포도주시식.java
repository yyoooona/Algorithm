package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2156_포도주시식_201202 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int wineNum = Integer.parseInt(br.readLine().trim());
		int[] wine = new int[wineNum + 1];
		int[] dp = new int[wineNum + 1];

		for (int i = 1; i <= wineNum; i++) {
			wine[i] = Integer.parseInt(br.readLine().trim());
		}

		for (int j = 1; j <= wineNum; j++) {
			if (j == 1) {
				dp[1] = wine[1];

			} else if (j == 2) {
				dp[2] = wine[1] + wine[2];

			} else if (j >= 3) {
				dp[j] = Math.max(Math.max(dp[j - 3] + wine[j - 1] + wine[j], dp[j - 2] + wine[j]), dp[j - 1]);
			}
		}

		System.out.println(dp[wineNum]);
	} // end of main

}
