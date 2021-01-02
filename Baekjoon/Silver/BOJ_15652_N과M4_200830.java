package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15652_N과M4_S3 {
	static int N, R;
	static int[] input, numbers;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// 중복 조합
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tk.nextToken());
		R = Integer.parseInt(tk.nextToken());
		input = new int[N];
		numbers = new int[R];

		for (int i = 0; i < N; i++) {
			input[i] = i + 1;
		}

		Combination(0, 0);

		System.out.println(sb);
	}

	static void Combination(int cnt, int cur) {
		if (cnt == R) {
			for (int k = 0; k < R; k++) {
				sb.append(numbers[k]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = cur; i < N; i++) {
			numbers[cnt] = input[i];
			Combination(cnt + 1, i);
		}
	}
}
