package baekjoon.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11721_열개씩끊어출력하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		int count = 0;
		StringBuilder sb = new StringBuilder();
		while (true) {
			if (count == str.length()) {
				System.out.println(sb);
				break;
			}
			sb.append(str.charAt(count));
			count += 1;
			if (count % 10 == 0) {
				sb.append('\n');
			}
		}

	}
}
