package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1026_보물 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		int[] B = new int[N];
		int answer = 0; // 답

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int k = 0; k < N; k++) { // N만큼 입력받기
			A[k] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());

		for (int k = 0; k < N; k++) { // N만큼 입력받기
			B[k] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(A);
		Arrays.sort(B);

		for (int i = N - 1, j = 0; i >= 0; i--, j++) {
			answer += A[i] * B[j];
		}

		System.out.println(answer);

	}
}