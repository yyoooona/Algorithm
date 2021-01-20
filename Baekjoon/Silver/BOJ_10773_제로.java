package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_10773_���� {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// stack ���
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		Stack<Integer> st = new Stack<Integer>();

		for (int tc = 0; tc < n; tc++) {
			int num = Integer.parseInt(br.readLine());
			if (num != 0)
				st.add(num);
			else { // num�� 0�̸� ���� �ֱ� �� pop
				st.pop();
			}
		}

		int ans = 0;
		while (!st.isEmpty()) {
			ans += st.pop();
		}

		System.out.println(ans);
	}
}
