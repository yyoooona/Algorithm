package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1543_문서검색 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String givenStr = br.readLine();
		String targetStr = br.readLine();
		boolean flag = false;
		int count = 0; // 정답

		while (true) {
			if (givenStr.contains(targetStr)) {
				flag = true;
				int idx = givenStr.indexOf(targetStr);
				count++;
				givenStr = givenStr.substring(idx + targetStr.length(), givenStr.length());
			} else {
				break;
			}
		}
		System.out.println(count);
	} // end of main
}
