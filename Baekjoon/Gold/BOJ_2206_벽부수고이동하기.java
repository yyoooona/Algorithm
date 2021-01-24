package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * bfs���� (�ִܰŸ�)
 * visited �湮�迭 üũ -> visited[][][]
 * �Ұ����� �� -1 ���
 * 
 */

public class BOJ_2206_���μ����̵��ϱ� {

	private static class Move {
		int x, y, count, num; // count �� �̵� Ƚ��, num�� �� �Ѽ� Ƚ��

		public Move(int x, int y, int count, int num) {
			super();
			this.x = x;
			this.y = y;
			this.count = count;
			this.num = num;
		}
	}

	private static int[][] map;
	private static int R;
	private static int C;
	private static boolean[][][] visited;
	private static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		visited = new boolean[R][C][2]; // 0�� �Ѱ��� ���� �ȻѼ��� ���, 1�� ���� �Ѱ� �Ѽ��� ���

		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		bfs(0, 0, 1, 0);
		if (min == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min);
	}

	static int[] dr = { 0, 1, 0, -1 }; // �� �� �� ��
	static int[] dc = { 1, 0, -1, 0 };

	private static void bfs(int x, int y, int count, int num) {
		Queue<Move> q = new LinkedList<Move>();
		q.add(new Move(x, y, count, num));

		while (!q.isEmpty()) {
			Move m = q.poll();
			if (m.x == R - 1 && m.y == C - 1) {
				min = Math.min(m.count, min);
			}

			for (int k = 0; k < 4; k++) {
				int nr = m.x + dr[k];
				int nc = m.y + dc[k];

				if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] != 1 && visited[nr][nc][m.num] == false
						&& m.num < 2) { // ���� �ȻѼ���
					visited[nr][nc][m.num] = true;
					q.add(new Move(nr, nc, m.count + 1, m.num));
				} else if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] == 1 && visited[nr][nc][1] == false
						&& m.num == 0) { // ���� �Ѽ���
					visited[nr][nc][1] = true;
					q.add(new Move(nr, nc, m.count + 1, m.num + 1));
				}
			}
		}
	}
}
