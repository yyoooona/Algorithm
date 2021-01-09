package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_14235_크리스마스선물 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> present = new PriorityQueue<Integer>(Collections.reverseOrder());
		StringBuilder sb =new StringBuilder();
		
		for (int tc = 0; tc < N; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			if (A == 0) { // 아이들을 만난 경우, 받은 선물의 가치 출력
				if (present.isEmpty())
					sb.append(-1).append('\n');
				else {
					sb.append(present.poll()).append('\n');
				}
			} else { // A는 거점지의 수
				for (int a = 0; a < A; a++) {
					int temp = Integer.parseInt(st.nextToken());
					present.add(temp);
				}
			}
		}
		
		System.out.println(sb.toString());
	}
}
