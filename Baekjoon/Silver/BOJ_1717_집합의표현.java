package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1717_������ǥ�� {
	private static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		parent = new int[n + 1];

		// 1. makeset
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int chk = Integer.parseInt(st.nextToken());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());

			if (chk == 0) { // 1. ������ ��ģ�� union(num1, num2)
				union(num1, num2);
			} else if (chk == 1) { // 2. num1, num2�� ���� ���տ� ���ԵǾ��ִ��� Ȯ��
				if (find(num1) == find(num2)) { // num1�� num2�� ���� �����̸�, �� num1�� ¯�� num2�� ¯�� ������ yes ���
					System.out.println("YES");
				} else { // ���� ������ �ƴϸ� no���
					System.out.println("NO");
				}
			}
		}

	}

	private static int find(int num) {
		if (parent[num] == num)
			return num;
		return parent[num] = find(parent[num]);
	}

	private static void union(int num1, int num2) {
		int a = find(num1);
		int b = find(num2);
		
		if (a != b) { // ���� �ٸ� �����̸�
			if (num1 < num2) {
				parent[b] = a;
			} else {
				parent[a] = b;
			}
		}
	}

}
