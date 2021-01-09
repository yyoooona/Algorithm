package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_1927_최소힙 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		int chk = 0; // 현재 입력받는 수가 어떤 수인지 check
		StringBuilder sb = new StringBuilder();

		for (int tc = 0; tc < N; tc++) {
			chk = Integer.parseInt(br.readLine());
			if (chk == 0) {
				if (pq.isEmpty())
					sb.append(0).append('\n');
				else {
					sb.append(pq.poll()).append('\n');
				}
			} else {
				pq.add(chk);
			}
		} // end of testCase

		System.out.println(sb);

	} // end of main
}
