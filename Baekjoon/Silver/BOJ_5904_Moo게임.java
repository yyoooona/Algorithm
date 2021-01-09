package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_5904_Moo게임 {
	private static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		ArrayList<Integer> arr = new ArrayList<Integer>();

		arr.add(3); // arr.get(0) = 3

		for (int i = 1; i < Math.pow(10, 9); i++) {
			int temp = arr.get(i - 1) + i + 3 + arr.get(i - 1);
			arr.add(temp);
			if (N <= temp) {
				dfs(i, temp);
				break;
			}
		}
	}

	private static void dfs(int k, int temp) {
		if (k == 0 || N <= 3) {
			if (N == 1) {
				System.out.println('m');
				return;
			} else {
				System.out.println('o');
				return;
			}
		}
		int num = (temp - k - 3) / 2; // 기준이 되는 수

		if (N <= num || num + k + 3 < N) { // 반복되는 부분에 N이 들어있으면
			N = N % (num + k + 3);
			dfs(k - 1, num);
		}

		else { // 가운데 k+2에 N이 들어있으면
			if (N == num + 1) {
				System.out.println("m");
				return;
			} else {
				System.out.println("o");
				return;
			}
		}
	}
}
