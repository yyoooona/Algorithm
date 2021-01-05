package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14888_연산자끼워넣기 {
//	private static int[] calcArr;
	private static int[] numArr;
	private static int max = Integer.MIN_VALUE;
	private static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] calcArr = new int[4];
		numArr = new int[N];

		for (int i = 0; i < N; i++) {
			numArr[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		int calcNum = 0; // 연산자의 총 갯수
		for (int i = 0; i < 4; i++) { // 연산자 배열
			int temp = Integer.parseInt(st.nextToken());
			calcArr[i] = temp;
			calcNum += temp;
		}

		dfs(calcArr, 1, numArr[0], calcNum);
		
		System.out.println(max);
		System.out.println(min);
	}

	private static void dfs(int[] calcArr, int num, int answer, int calcNum) { // 연산자를 활용해 연산
		// dfs가 끝나는 조건
		// calcArr배열이 비었을 때
		if (calcNum == 0) {
			max = Math.max(answer, max);
			min = Math.min(answer, min);
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (calcArr[i] != 0) {
				if (i == 0) { // 더하기
					calcArr[i] -= 1;
					dfs(calcArr, num + 1, answer + numArr[num], calcNum - 1);
					calcArr[i] += 1;
				} else if (i == 1) { // 빼기
					calcArr[i] -= 1;
					dfs(calcArr, num + 1, answer - numArr[num], calcNum - 1);
					calcArr[i] += 1;
				} else if (i == 2) { // 곱하기
					calcArr[i] -= 1;
					dfs(calcArr, num + 1, answer * numArr[num], calcNum - 1);
					calcArr[i] += 1;
				} else if (i == 3) { // 나누기
					calcArr[i] -= 1;
					dfs(calcArr, num + 1, answer / numArr[num], calcNum - 1);
					calcArr[i] += 1;
				}
			}
		}

	}
}
