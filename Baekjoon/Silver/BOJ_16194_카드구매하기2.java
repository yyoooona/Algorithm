package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16194_카드구매하기2_201129 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cardNum = Integer.parseInt(br.readLine());
		int[] card = new int[cardNum + 1];
		int[] dp = new int[cardNum + 1];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= cardNum; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= cardNum; i++) {
			dp[i] = card[i];
			for (int j = 1; j < i; j++) {
				dp[i] = Math.min(dp[i], dp[i - j] + card[j]);
			}
		}

		System.out.println(dp[cardNum]);
	} // end of main
}
