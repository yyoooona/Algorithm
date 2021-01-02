package baekjoon.Bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_17608_¸·´ë±â {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //
		Stack<Integer> st = new Stack<Integer>();
		int firstNum = Integer.parseInt(br.readLine());
		st.push(firstNum);

		for (int i = 0; i < N - 1; i++) {
			int curNum = Integer.parseInt(br.readLine());
			if (st.peek() <= curNum) {
				while (!st.isEmpty()) {
					if (st.peek() > curNum)
						break;
					st.pop();
				}
			}
			st.push(curNum);
		}

		System.out.println(st.size());
	}
}
