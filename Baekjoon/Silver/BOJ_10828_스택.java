package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_10828_스택 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<Integer>();
		StringBuilder sb = new StringBuilder();
		// 입력받을 숫자 num
		int num = Integer.parseInt(br.readLine());

		for (int i = 0; i < num; i++) {
			// 입력받은 num만큼 조건문 수행
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();

			switch (command) {
			case "push": // 문자열엔 ' ' 아니라 " "
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
