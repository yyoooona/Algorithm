package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_10828_���� {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<Integer>();
		StringBuilder sb = new StringBuilder();
		// �Է¹��� ���� num
		int num = Integer.parseInt(br.readLine());

		for (int i = 0; i < num; i++) {
			// �Է¹��� num��ŭ ���ǹ� ����
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();

			switch (command) {
			case "push": // ���ڿ��� ' ' �ƴ϶� " "
				stack.add(Integer.parseInt(st.nextToken()));
				break;

			case "top":
				if (stack.isEmpty())
					sb.append(-1).append('\n');
				else {
					sb.append(stack.peek()).append('\n');
				}
				break;
			case "size":
				sb.append(stack.size()).append('\n');
				break;
			case "empty":
				if (stack.isEmpty())
					sb.append(1).append('\n');
				else {
					sb.append(0).append('\n');
				}
				break;
			case "pop":
				if (stack.isEmpty())
					sb.append(-1).append('\n');
				else {
					sb.append(stack.pop()).append('\n');
				}
				break;
			} // end switch ~ case
		} // end for
		
		System.out.println(sb);
	} // end main
}
