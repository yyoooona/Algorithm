package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_14235_ũ������������ {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> present = new PriorityQueue<Integer>(Collections.reverseOrder());
		StringBuilder sb =new StringBuilder();
		
		for (int tc = 0; tc < N; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			if (A == 0) { // ���̵��� ���� ���, ���� ������ ��ġ ���
				if (present.isEmpty())
					sb.append(-1).append('\n');
				else {
					sb.append(present.poll()).append('\n');
				}
			} else { // A�� �������� ��
				for (int a = 0; a < A; a++) {
					int temp = Integer.parseInt(st.nextToken());
					present.add(temp);
				}
			}
		}
		
		System.out.println(sb.toString());
	}
}
