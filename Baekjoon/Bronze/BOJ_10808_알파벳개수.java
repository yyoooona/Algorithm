package baekjoon.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10808_¾ËÆÄºª°³¼ö {
	public static void main(String[] args) throws IOException {
		int[] alphabet = new int[26];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();

		for (int i = 0; i < str.length(); i++) {
			int num = str.charAt(i);
//			System.out.println(num);
			alphabet[num - 97] += 1;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < alphabet.length; i++) {
			sb.append(alphabet[i]).append(' ');
		}

		System.out.println(sb);
	}
}
