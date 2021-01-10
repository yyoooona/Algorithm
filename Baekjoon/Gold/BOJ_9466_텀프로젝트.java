package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_9466_��������Ʈ_201202 {
	private static int[] teamMate;
	private static int teamMateNum;
	private static boolean[] visited;
	private static ArrayList<Integer> arr;
	private static int answerCount;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {

			teamMateNum = Integer.parseInt(br.readLine());
			teamMate = new int[teamMateNum + 1];
			answerCount = teamMateNum;
			visited = new boolean[teamMateNum + 1];

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int tm = 1; tm <= teamMateNum; tm++) {
				teamMate[tm] = Integer.parseInt(st.nextToken());
			}

			for (int tm = 1; tm <= teamMateNum; tm++) {
				arr = new ArrayList<Integer>();
				dfs(tm, tm, 0);

			}
			System.out.println(answerCount);

		} // end of testCase

	} // end of main

	private static void dfs(int originTm, int tm, int count) {
		// ���� ����
		if (visited[tm] == true) {

			// ��� ������ ��ȸ�ϰ� �ڱ� �ڽ����� �� �� (All cycle)
			if (teamMate[tm] == originTm) {
				answerCount -= count;
			}

			// �κ� cycle
			else if (arr.contains(tm)) {
				answerCount -= (arr.size() - arr.indexOf(tm));
			}

			return;

		}

		visited[tm] = true; // �湮 ó��
		arr.add(tm);

		dfs(originTm, teamMate[tm], count + 1);

	}
}
