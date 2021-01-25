package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2805_�����ڸ���3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // ������ ��
		long M = Integer.parseInt(st.nextToken()); // �ּ� �������� �� ���� ��
		int[] tree = new int[N];

		st = new StringTokenizer(br.readLine());
		long max = 0;
		for (int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, tree[i]);
		}

		// �̺� Ž���̴� �ݾ� �߶� ��
		long min = 1;
		long half = 0;
		long rest = 0;

		while (min <= max) {
			half = (min + max) / 2;
			rest = 0;
			for (int num : tree) {
				if (num - half <= 0)
					continue;
				rest += (num - half);
			}

			if (rest >= M) {
				min = half + 1;
				half = half + half / 2;
			} else { // rest < M
				max = half - 1;
			}
		}

		System.out.println(max);
	}
}
