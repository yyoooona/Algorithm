package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1316_그룹단어체커 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int answer = 0; // 그룹단어의 수
		for (int i = 0; i < N; i++) { // testcase
			int[] alphabet = new int[26];
			String str = br.readLine();
			alphabet[str.charAt(0) - 'a'] += 1;

			boolean flag = true;
			for (int j = 1; j < str.length(); j++) {
				if (alphabet[str.charAt(j) - 'a'] != 0 && str.charAt(j - 1) != str.charAt(j)) {
					flag = false;
				}
				alphabet[str.charAt(j) - 'a'] += 1;
			}
			if (flag == true) {
				answer += 1;
			}
		}
		System.out.println(answer);
	}
}
