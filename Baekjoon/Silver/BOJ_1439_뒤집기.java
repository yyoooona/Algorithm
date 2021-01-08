package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1439_뒤집기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int count = 0;

		if (str.charAt(0) == '0') {
			if (str.charAt(1) == '1')
				count += 1;
			for (int i = 1; i < str.length() - 1; i++) {
				if (str.charAt(i) == '0' && str.charAt(i + 1) == '1')
					count += 1;
			}
		} else { // 처음 시작이 1이면
			if (str.charAt(1) == '0')
				count += 1;
			for (int i = 1; i < str.length() - 1; i++) {
				if (str.charAt(i) == '1' && str.charAt(i + 1) == '0')
					count += 1;
			}
		}
		System.out.println(count);
	}
}
